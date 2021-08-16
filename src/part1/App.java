package part1;

import utils.ConsoleAppEngine;
import utils.WebAppEngine;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    ConsoleAppEngine.execute("src/part1/script.toml", new Handler(), Handler.class);
//    WebAppEngine.execute("src/part1/script.toml", new Handler(), Handler.class, 8080);
  }
}