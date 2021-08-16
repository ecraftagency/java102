package utils;

import com.google.gson.Gson;

@SuppressWarnings("unused")
public class Utils {
  static Gson gson = new Gson();
  public static int[] parseIntArr(String input) {
    return gson.fromJson(input, int[].class);
  }
}