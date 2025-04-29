package lab14;

import javax.swing.*;

public class StudentView {
  public void displayStudentDetails(String name, double gpa) {
    // Simple display of student details
    JOptionPane.showMessageDialog(null, "Student Name: " + name + "\nGPA: " + gpa);
  }
}