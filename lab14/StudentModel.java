package lab14;

public class StudentModel {
  private String name;
  private double gpa;

  public StudentModel(String name, double gpa) {
    this.name = name;
    this.gpa = gpa;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getGpa() {
    return gpa;
  }
  public void setGpa(double gpa) {
    this.gpa = gpa;
  }
}
