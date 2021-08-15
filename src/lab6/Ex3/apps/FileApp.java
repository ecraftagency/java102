package lab6.Ex3.apps;

import lab6.Ex3.StudentController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileApp {
  public static void main(String[] args) throws FileNotFoundException {
    InputStream is = new FileInputStream("src/lab6/Ex3/data/student.dat");
    StudentController.inst().addStudent(is);
    StudentController.inst().printStudent();
  }
}
