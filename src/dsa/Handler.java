package dsa;

import utils.Utils;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;

@SuppressWarnings("unused")
public class Handler {
  public void ex1(Map<String, String> in, PrintStream out) {
    int[] arr         = Utils.parseIntArr(in.get("arr"));
    int target        = Integer.parseInt(in.get("target"));
    out.println("not implementation");
  }

  public void ex2(Map<String, String> in, PrintStream out) {
    int[] arr = Utils.parseIntArr(in.get("arr"));
    out.println("not implementation");
  }

  public void ex3(Map<String, String> in, PrintStream out) {
    int[] arr = Utils.parseIntArr(in.get("arr"));
    out.println("not implementation");
  }

  public void ex4(Map<String, String> in, PrintStream out) {
    int[] arr = Utils.parseIntArr(in.get("arr"));

    int zeros = 0;
    for (int value: arr)
      if (value == 0)
        zeros++;

    int k = 0;
    while (zeros-- != 0)
      arr[k++] = 0;

    while (k < arr.length)
      arr[k++] = 1;

    out.println(Arrays.toString(arr));
  }
}