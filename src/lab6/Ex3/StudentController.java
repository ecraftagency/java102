package lab6.Ex3;

import java.util.HashMap;
import java.util.Map;

public class StudentController {
  Map<String, Student> students;
  StringBuilder sb = new StringBuilder();

  private static StudentController inst = new StudentController();

  private StudentController() {
    students = new HashMap<>();
  }

  public static StudentController inst() {
    return inst;
  }

  public void addStudent(Student student) {
    students.put(student.id, student);
  }

  public String listStudents() {
    sb.setLength(0);
    for (Student student : students.values())
      sb.append(student.toString()).append("\n");
    return sb.toString();
  }
}