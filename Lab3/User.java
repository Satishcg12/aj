
package Lab3;

public class User extends JFrame {
    public static void main(String[] args) {
        UserBean user = new UserBean();
        user.setFirstName("rayyan");
        user.setLastName("balami");
        user.setAge(30);
        System.out.println("User First Name: " + user.getFirstName());
        System.out.println("User Last Name: " + user.getLastName());
        System.out.println("User Age: " + user.getAge());
    }
}
