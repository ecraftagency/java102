package lab6.Ex3.apps;

import lab6.Ex3.StudentController;

import java.io.*;
import java.util.Scanner;

public class ConsoleApp {
  static PipedOutputStream pos = new PipedOutputStream();
  static Scanner scanner = new Scanner(System.in);
  static Writer w = new OutputStreamWriter(pos);

  public static void main(String[] args) throws IOException, InterruptedException {
    new Thread(() -> {
      try {
        StudentController.inst().addStudent(new PipedInputStream(pos));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }).start();

    String op;
    System.out.print("Operation (add/print/quit) :");
    while (!(op = scanner.nextLine()).equals("quit")) {
      switch (op) {
        case "add": fetchStudent(); break;
        case "print": StudentController.inst().printStudent(); break;
        default:System.out.print("Operation (add/print/quit) :");
      }
    }
    System.exit(1);
  }

  public static void fetchStudent() throws IOException, InterruptedException {
    do {
      System.out.print("\tname:");
      String name = scanner.nextLine();
      System.out.print("\tphone:");
      String phone = scanner.nextLine();
      System.out.print("\tid:");
      String id = scanner.nextLine();
      System.out.print("\temail:");
      String email = scanner.nextLine();

      w.write("[STUDENT]\n");
      w.write("name=" + name + "\n");
      w.write("email=" + email + "\n");
      w.write("phone=" + phone + "\n");
      w.write("id=" + id + "\n");
      w.flush();
      Thread.sleep(200);
      System.out.print("new student (yes/no)? ");
    }
    while (!scanner.nextLine().equals("no"));
  }
}