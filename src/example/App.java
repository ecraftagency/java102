package example;

import utils.ConsoleAppEngine;

import java.io.IOException;

@SuppressWarnings("unused")
public class App {
  public static void main(String[] args) throws IOException {
    ConsoleAppEngine.execute("src/example/script.toml", new Handler(), Handler.class);
//    WebAppEngine.execute("src/example/script.toml", new Handler(), Handler.class, 8080);
  }
}