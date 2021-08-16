package part1;

import utils.Utils;
import java.io.PrintStream;
import java.util.Map;

@SuppressWarnings("unused")
public class Handler {

  //Find a pair with the given sum in an array
  public void ex1(Map<String, String> in, PrintStream out) {
    int[] arr         = Utils.parseIntArr(in.get("arr"));
    int target        = Integer.parseInt(in.get("target"));
    out.println("chưa làm");
  }

  //Check if a sub array with 0 sum exists or not
  public void ex2(Map<String, String> in, PrintStream out) {
    int[] arr = Utils.parseIntArr(in.get("arr"));
    out.println("chưa làm");
  }

  //Print all sub arrays with 0 sum
  public void ex3(Map<String, String> in, PrintStream out) {
    int[] arr = Utils.parseIntArr(in.get("arr"));
    out.println("chưa làm");
  }

  //Sort binary array in linear time
  //[0,1,1,0,0,1,0] -> [0,0,0,0,1,1,1]
  public void ex4(Map<String, String> in, PrintStream out) {
    int[] arr = Utils.parseIntArr(in.get("arr"));
    out.println("chưa làm");
  }
}