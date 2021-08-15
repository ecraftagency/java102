package utils;
import com.moandjiezana.toml.Toml;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleAppEngine {
  public Components.Loop  loop;
  public Map<String, String> desc;
  public String welc;

  public <T> void run(Object handler, Class<T> type) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(welc);
    Map<String, String> inputs = new HashMap<>();

    if (loop != null) {
      do {
        System.out.print(loop.print);
        String cmd = scanner.nextLine();

        if (cmd.equals(loop.end))
          break;

        loop.sw.stream().filter(e -> e.handler.equals(cmd)).findAny().ifPresent(e -> {
          inputs.clear();

          for (String input : e.input) {
            System.out.print(desc.getOrDefault(cmd + "_" + input, input + ": "));
            String val = scanner.nextLine();
            inputs.put(input, val);
          }

          try {
            Method med = type.getMethod(cmd, Map.class);
            Object res = med.invoke(handler, inputs);
            System.out.println(res);
          } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            System.out.println(ex.getMessage());
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