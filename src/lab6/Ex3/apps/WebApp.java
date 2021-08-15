package lab6.Ex3.apps;

import utils.WebAppEngine;

public class WebApp {
  public static void main(String[] args) throws Exception {
    WebAppEngine.execute("src/lab6/data/ex3.toml", new Handler(), Handler.class, 8080);
  }
}