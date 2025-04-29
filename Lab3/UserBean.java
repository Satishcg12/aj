package Lab3;
import java.io.Serializable;

public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String firstName;
    private String lastName;
    private int age;

    public UserBean() {}
    
    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}