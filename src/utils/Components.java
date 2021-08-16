package utils;
import java.util.List;

@SuppressWarnings("unused")
public class Components {
  static class Loop {
    public String end;
    public String print;
    public List<Switch> sw;
  }

  static class Switch {
    public String handler;
    public List<String> args;
    public List<String> desc;
  }
}