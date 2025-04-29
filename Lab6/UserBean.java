package Lab6;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String name;
    private int age;
    private boolean active;

    // No-arg constructor
    public UserBean() {}

    // Getters and Setters (Simple Properties)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // Boolean Property
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
