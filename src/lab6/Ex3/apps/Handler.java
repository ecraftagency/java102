package lab6.Ex3.apps;

import lab6.Ex3.Student;
import lab6.Ex3.StudentController;
import java.util.Map;

@SuppressWarnings("unused")
public class Handler {
  public String addStudent(Map<String, String> input) {
    String name   = input.get("name");
    String id     = input.get("id");
    String email  = input.get("email");
    String phone  = input.get("phone");
    String valid  = Student.validate(name, id, email, phone);
    if (!valid.equals("ok"))
      return valid;
    StudentController.inst().addStudent(new Student(name, id, email, phone));
    return "ok";
  }

  public String listStudents(Map<String, String> input) {
    return StudentController.inst().listStudents();
  }
}