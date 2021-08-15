package lab6.Ex3.apps;

import utils.ConsoleAppEngine;
import java.io.IOException;

@SuppressWarnings("unused")
public class ConsoleApp {
  public static void main(String[] args) throws IOException {
    ConsoleAppEngine.execute("src/lab6/data/ex3.toml", new Handler(), Handler.class);
  }
}