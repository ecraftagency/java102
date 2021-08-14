import java.io.IOException;

public class WC {
  static final int IN   = 1;
  static final int OUT  = 2;

  public static void main(String []args) throws IOException {
    int c, nl = 0, nw = 0, nc = 0, state = OUT;
    while ((c = System.in.read()) != -1) {
      if (c == '\n')
        nl++;
      if (c == ' ' || c == '\n' || c == '\t')
        state = OUT;
      else if (state == OUT) {
        nw++;
        state = IN;
      }
      ++nc;
    }

    System.out.printf("\t%d\t%d\t%d\n", nl, nw, nc);
  }
}