package utils;
import com.moandjiezana.toml.Toml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleAppEngine {
  public Components.Loop  loop;
  public String welc;
  public String output;
  public String input;
  public PrintStream out;
  Scanner in;

  public <T> void run(Object handler, Class<T> type) throws FileNotFoundException {
    in  = "file".equals(input) ? new Scanner(new FileInputStream("out/in.dat")) : new Scanner(System.in);
    out = "file".equals(output) ? new PrintStream(new FilterOutputStream(new FileOutputStream("out/out.dat"))) : System.out;

    System.out.println(welc);
    Map<String, String> args = new HashMap<>();

    if (loop != null) {
      do {
        System.out.print(loop.print);
        String cmd = in.nextLine();

        if (cmd.equals(loop.end))
          break;

        loop.sw.stream().filter(e -> e.handler.equals(cmd)).findAny().ifPresent(e -> {
          args.clear();

          for (String input : e.args) {
            int i = e.args.indexOf(input);
            System.out.print(i < e.desc.size() ? e.desc.get(i) : input + ": ");
            String val = in.nextLine();
            args.put(input, val);
          }

          try {
            type.getMethod(cmd, Map.class, PrintStream.class).invoke(handler, args, out);
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        });
      }
      while (true);
    }
  }

  public static <T> void execute(String script, Object handler, Class<T> type) throws IOException {
    InputStream inputStream = new FileInputStream(script);
    ConsoleAppEngine app = new Toml().read(inputStream).to(ConsoleAppEngine.class);
    app.run(handler, type);
  }
}