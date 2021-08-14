package utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Utils {
  public static void cat(String filename) {
    String line;

    try (FileInputStream fin = new FileInputStream(filename); InputStreamReader isr = new InputStreamReader(fin); BufferedReader br = new BufferedReader(isr)) {
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Map<String, String> buildDesc(String filename) {
    String line;
    Map<String, String> res = new HashMap<>();
    try (FileInputStream fin = new FileInputStream(filename); InputStreamReader isr = new InputStreamReader(fin); BufferedReader br = new BufferedReader(isr)) {
      while ((line = br.readLine()) != null) {
        String[] kv = line.split("-");
        if (kv.length == 2)
          res.put(kv[0], kv[1]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return res;
  }
}
