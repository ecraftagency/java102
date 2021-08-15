package lab6.Ex3;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
  List<Student> students;
  StringBuilder sb = new StringBuilder();

  private static StudentController inst = new StudentController();

  private StudentController() {
    students = new ArrayList<>();
  }

  public static StudentController inst() {
    return inst;
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public String printStudent() {
    System.out.print(students);
    return students.toString();
  }

  @Override
  public String toString() {
    sb.setLength(0);
    for (Student student : students)
      sb.append(student.toString()).append("\n");
    return sb.toString();
  }
}