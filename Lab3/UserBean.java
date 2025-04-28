package Lab3;
import java.io.Serializable;

public class UserBean implements Serializable {
    // Unique ID for serialization
    private static final long serialVersionUID = 1L;
    
    // Private fields (properties)
    private String firstName;
    private String lastName;
    private int age;
    
    // No-argument constructor (required for JavaBeans as it will work without any no argument constructor its by default but we still put it beacuse it is a good practice s o=if any other constructor is added then java will not add the default constructor which is required for java beans)
    public UserBean() {
    }
    
    // Getter and Setter methods
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}