package example;

import java.util.HashMap;
import java.util.Map;

public class StudentController {
  Map<String, Student> students;
  StringBuilder sb = new StringBuilder();
  static Student nullStudent = new Student("","","","") {
    @Override
    public String toString() {
      return "not found";
    }
  };

  private static StudentController inst = new StudentController();

  private StudentController() {
    students = new HashMap<>();
  }

  public static StudentController inst() {
    return inst;
  }

  public void add(Student student) {
    students.put(student.id, student);
  }

  public String list() {
    sb.setLength(0);
    for (Student student : students.values())
      sb.append(student.toString()).append("\n");
    return sb.toString();
  }

  public Student find(String id) {
    return students.getOrDefault(id, nullStudent);
  }

  public String rem(String id) {
    return students.remove(id) != null ? "ok" : "not found";
  }
}