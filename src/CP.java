import java.io.IOException;

public class CP {
  public static void main(String[] args) throws IOException {
    int c;
    while ((c = System.in.read()) != -1) System.out.write(c);
  }
}