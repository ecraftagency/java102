package lab6.Ex3;

//apply builder pattern, what is builder pattern? search google
public class StudentModel {
  String name;
  String id;
  String phone;
  String email;
  private StudentModel() {} //what is private constructor, and what is it use for?

  @Override
  public String toString() {
    return "\nStudent{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", \tphone='" + phone + '\'' +
            ", \temail='" + email + '\'' +
            '}';
  }

  public static class StudentBuilder {
    static final String idRegex     = "^[0-9]{12}$";
    static final String phoneRegex  = "^[0-9]{10}$|^[0-9]{11}$";
    static final String mailRegex   = "^(.+)@(.+)$";

    static final StudentBuilder builder = new StudentBuilder();

    String name;
    String id;
    String phone;
    String email;

    public StudentBuilder setName(String name) {
      this.name = name;
      return this;
    }

    public StudentBuilder setId(String id) {
      this.id = id;
      return this;
    }

    public StudentBuilder setPhone(String phone) {
      this.phone = phone;
      return this;
    }

    public StudentBuilder setEmail(String email) {
      this.email = email;
      return this;
    }

    public StudentModel build() {
      StudentModel student = new StudentModel();
      if (!id.matches(idRegex))
        throw new IllegalArgumentException("invalid id number");
      if (!phone.matches(phoneRegex))
        throw new IllegalArgumentException("invalid id number");
      if (!email.matches(mailRegex))
        throw new IllegalArgumentException("invalid email address");

      student.name = this.name;
      student.email = this.email;
      student.id = this.id;
      student.phone = this.phone;
      return student;
    }

    public static StudentBuilder newBuilder() {
      builder.phone   = "";
      builder.id      = "";
      builder.name    = "";
      builder.email   = "";
      return builder;
    }
  }
}
