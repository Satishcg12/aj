package lab8;
import java.io.*;

// A simple Serializable class
class Student implements Serializable {
  private String name;
  private int roll;

  public Student(String name, int roll) {
    this.name = name;
    this.roll = roll;
  }

  public void display() {
    System.out.println("Name: " + name);
    System.out.println("Roll: " + roll);
  }
}

public class MarshalUnmarshalExample {
  public static void main(String[] args) {
    try {
      // STEP 1: Marshaling (Object → Bytes)
      Student student1 = new Student("Satish Chaudhary", 30);

      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./student.ser"));
      out.writeObject(student1); // marshaling here
      out.close();

      student1.display();
      System.out.println("Student object marshaled (saved).");

      // STEP 2: Unmarshaling (Bytes → Object)
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("./student.ser"));
      Student student2 = (Student) in.readObject(); // unmarshaling here
      in.close();

      System.out.println("Student object unmarshaled (loaded).");
      student2.display();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
