
package Lab3;

import javax.swing.JFrame;

public class User extends JFrame {
    public static void main(String[] args) {
        UserBean user = new UserBean();
        user.setFirstName("Satish");
        user.setLastName("Chaudhary");
        user.setAge(22);
        System.out.println("User First Name: " + user.getFirstName());
        System.out.println("User Last Name: " + user.getLastName());
        System.out.println("User Age: " + user.getAge());
    }
}
