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

    do {
      System.out.print(input.equals("stdin") ? loop.print : "");
      String cmd = in.nextLine();

      if (cmd.equals(loop.end))
        break;

      loop.sw.stream().filter(e -> e.handler.equals(cmd)).findAny().ifPresent(e -> {
        args.clear();

        for (String arg : e.args) {
          if (input.equals("stdin")) {
            int i = e.args.indexOf(arg);
            System.out.print(i < e.desc.size() ? e.desc.get(i) : arg + ": ");
          }
          String val = in.nextLine();
          args.put(arg, val);
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

  public static <T> void execute(String script, Object handler, Class<T> type) throws IOException {
    InputStream inputStream = new FileInputStream(script);
    ConsoleAppEngine app = new Toml().read(inputStream).to(ConsoleAppEngine.class);
    app.run(handler, type);
  }
}