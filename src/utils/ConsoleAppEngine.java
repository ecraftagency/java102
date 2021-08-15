package utils;
import com.moandjiezana.toml.Toml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleAppEngine {
  public static class App {
    public String           welcome;
    public Components.Loop  loop;

    public <T> void run(Object handler, Class<T> type) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(welcome);
      if (loop != null) {
        do {
          System.out.print(loop.print);
          String cmd = scanner.nextLine();
          if (cmd.equals(loop.end))
            break;
          loop.sw.stream().filter(e -> e.handler.equals(cmd)).forEach(e -> {
            Map<String, String> inputs = new HashMap<>();
            for (String input : e.input) {
              System.out.print(input + ": ");
              String val = scanner.nextLine();
              inputs.put(input, val);
            }
            try {
              Method med = type.getMethod(cmd, Map.class);
              Object res = med.invoke(handler, inputs);
              System.out.println(res);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {

            }
          });
        }
        while (true);
      }
    }
  }

  public static <T> void execute(String script, Object handler, Class<T> type) throws FileNotFoundException {
    InputStream inputStream = new FileInputStream(script);
    ConsoleAppEngine.App app = new Toml().read(inputStream).to(ConsoleAppEngine.App.class);
    app.run(handler, type);
  }
}