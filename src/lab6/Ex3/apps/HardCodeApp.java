package lab6.Ex3.apps;

/*
There 3 components:
  1. The student class: only data of student, NOTHING MORE
  2. The builder class: control how to make student, also data validation
  3. The manager class: handle and manage multiple students
  => do one simple thing and do it well.
 */

import lab6.Ex3.StudentController;

import java.io.*;

public class HardCodeApp {
  public static void main(String[] args) throws IOException {
    PipedOutputStream pos = new PipedOutputStream();
    InputStream pis       = new PipedInputStream(pos);

    Writer w = new OutputStreamWriter(pos);
    w.write("[STUDENT]\n");
    w.write("name=hello\n");
    w.write("email=hello@gmail.com\n");
    w.write("id=000000000000\n");
    w.write("phone=0901343403\n");
    w.write("[END]\n");
    w.flush();

    StudentController.inst().addStudent(pis);
    StudentController.inst().printStudent();

    pos.close();
    pis.close();
  }
}