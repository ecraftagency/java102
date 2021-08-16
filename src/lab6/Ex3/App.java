package lab6.Ex3;

import utils.ConsoleAppEngine;
import utils.WebAppEngine;

import java.io.IOException;

@SuppressWarnings("unused")
public class App {
  public static void main(String[] args) throws IOException {
//    ConsoleAppEngine.execute("src/lab6/ex3/script.toml", new Handler(), Handler.class);
    WebAppEngine.execute("src/lab6/ex3/script.toml", new Handler(), Handler.class, 8080);
  }
}