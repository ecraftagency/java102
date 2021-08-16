package dsa;

import utils.ConsoleAppEngine;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    ConsoleAppEngine.execute("src/dsa/script.toml", new Handler(), Handler.class);
//    WebAppEngine.execute("src/part1/script.toml", new Handler(), Handler.class, 8080);
  }
}