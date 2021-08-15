package lab6.Ex3;

public class Student {
  static final String idRegex     = "^[0-9]{12}$";
  static final String phoneRegex  = "^[0-9]{10}$|^[0-9]{11}$";
  static final String mailRegex   = "^(.+)@(.+)$";

  public String name;
  public String id;
  public String phone;
  public String email;

  public Student(String name, String id, String email, String phone) {
    this.name = name;
    this.id = id;
    this.email = email;
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", \tphone='" + phone + '\'' +
            ", \temail='" + email + '\'' +
            '}';
  }

  public static String validate(String name, String id, String mail, String phone) {
    if (id == null || !id.matches(idRegex))
      return "invalid id number";
    if (phone == null || !phone.matches(phoneRegex))
      return "invalid id number";
    if (mail == null || !mail.matches(mailRegex))
      return "invalid email address";
    return "ok";
  }
}
