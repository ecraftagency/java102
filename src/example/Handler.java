package example;

import java.io.PrintStream;
import java.util.Map;

@SuppressWarnings("unused")
public class Handler {
  public void add(Map<String, String> input, PrintStream out) {
    String name   = input.get("name");
    String id     = input.get("id");
    String email  = input.get("email");
    String phone  = input.get("phone");
    String valid  = Student.validate(id, email, phone);
    if (!valid.equals("ok")) {
      out.println(valid);
      return;
    }
    StudentController.inst().add(new Student(name, id, email, phone));
    out.println("ok");
  }

  public void list(Map<String, String> input, PrintStream out) {
    out.println(StudentController.inst().list());
  }

  public void find(Map<String, String> input, PrintStream out) {
    out.println(StudentController.inst().find(input.get("id")));
  }

  public void rem(Map<String, String> input, PrintStream out) {
    out.println(StudentController.inst().rem(input.get("id")));
  }
}