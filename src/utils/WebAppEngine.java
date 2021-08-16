package utils;

import com.moandjiezana.toml.Toml;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class WebAppEngine {
  public Components.Loop  loop;
  public PrintStream out;
  public ByteArrayOutputStream bos;

  public WebAppEngine() {
    bos = new ByteArrayOutputStream();
    out = new PrintStream(new FilterOutputStream(bos));
  }

  public <T> void run(Object handler, Class<T> type, int port) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

    for (Components.Switch sw : loop.sw) {
      server.createContext("/" + sw.handler, ex -> {
        try {
          bos.reset();
          Method med = type.getMethod(sw.handler, Map.class, PrintStream.class);
          med.invoke(handler, queryToMap(ex.getRequestURI().getQuery()), this.out);
          ex.sendResponseHeaders(200, bos.size());
          OutputStream os = ex.getResponseBody();
          os.write(bos.toByteArray());
          os.close();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {

        }
      });
    }

    server.setExecutor(null); // creates a default executor
    server.start();
  }

  private Map<String, String> queryToMap(String query) {
    if(query == null) {
      return null;
    }
    Map<String, String> result = new HashMap<>();
    for (String param : query.split("&")) {
      String[] entry = param.split("=");
      if (entry.length > 1) {
        result.put(entry[0], entry[1]);
      }else{
        result.put(entry[0], "");
      }
    }
    return result;
  }

  public static <T> void execute(String script, Object handler, Class<T> type, int port) throws IOException {
    InputStream inputStream = new FileInputStream(script);
    WebAppEngine app = new Toml().read(inputStream).to(WebAppEngine.class);
    app.run(handler, type, port);
  }
}
