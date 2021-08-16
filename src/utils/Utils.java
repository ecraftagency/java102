package utils;

@SuppressWarnings("unused")
public class Utils {
  public static int[] parseIntArr(String input) {
    String[] split = input.split(",");
    int[] res = new int[split.length];
    for (int i = 0; i < split.length; i++)
      res[i] = Integer.parseInt(split[i].trim());
    return res;
  }
}
