package utils;

import java.util.Map;

public interface Handler {
  String handle(String cmd, Map<String, String> input);
}
