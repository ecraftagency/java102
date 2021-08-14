package lab5;

import utils.Utils;
import java.util.*;
import static java.lang.System.out;

public class Ex2 {
  static Scanner      in  = new Scanner(System.in);
  static List<String> ls  = new ArrayList<>();
  static Map<String, String> desc; //learn more about map, what is map? what is it use for?

  static final int BUILD_LIST = 1, PRINT_LIST = 2, RAND_PRINT = 3, SORT_PRINT = 4, DEL_ELEM = 5;

  public static void main(String[] args) {
    Utils.cat("src/lab5/data/ex1_welc.dat");
    desc = Utils.buildDesc("src/lab5/data/ex1_desc.dat");

    int answer = 0;
    while (answer != 6) {
      out.print("\n" + desc.get("op"));
      answer = in.nextInt();

      switch (answer) {
        case BUILD_LIST:
          out.print(desc.get("nelem"));
          int el = in.nextInt();
          in.nextLine();
          for (int i = 0; i < el; i++) {
            out.printf("\t elem %d: ", i + 1);
            ls.add(in.nextLine());
          }
          break;

        case PRINT_LIST:
          out.println(desc.get("urls") + ls.toString());
          break;

        case RAND_PRINT:
          Collections.shuffle(ls);
          out.println(desc.get("randls") + ls.toString());
          break;

        case SORT_PRINT:
          ls.sort(String::compareTo);
          out.println(desc.get("sortpr") + ls.toString());
          break;

        case DEL_ELEM:
          out.print(desc.get("del"));
          in.nextLine();
          ls.remove(in.nextLine());
          break;
        default:
          break;
      }
    }
  }
}