package tomcat.src.lab13;

public class StudentBean {
  private String name;
  private int age;
  private String major;

  // Constructors, getters, setters...

  public StudentBean() {} // Default constructor is important

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
  public String getMajor() { return major; }
  public void setMajor(String major) { this.major = major; }
}

