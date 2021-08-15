package lab6.Ex3;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//apply singleton pattern, what is singleton pattern? google for it
public class StudentController {
  List<StudentModel> students;
  private static StudentController inst = new StudentController();

  private StudentController() {
    students = new ArrayList<>();
  }

  public static StudentController inst() {
    return inst;
  }

  public void addStudent(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream);
    String header;
    while ( !(header = scanner.nextLine()).equals("[END]")) {
      if (header.equals("[STUDENT]")) {
        String body, name = "", email = "", phone = "", id = "";
        for (int i = 0; i < 4; i++) {
          body = scanner.nextLine();
          String[] split = body.split("=");
          switch (split[0]) {
            case "name": name = split[1]; break;
            case "email": email = split[1]; break;
            case "phone": phone = split[1]; break;
            case "id": id = split[1]; break;
            default: break;
          }
        }
        try {
          students.add(StudentModel.StudentBuilder.newBuilder().setName(name).setPhone(phone).setId(id).setEmail(email).build());
        }
        catch (Exception e) {
          System.out.print("\t" + e.getMessage() + "\n");
        }
      }
    }
  }

  public void printStudent() {
    System.out.print(students);
  }
}
