package Lab6;

public class UserFactory {
    public static UserBean createUser(String name, int age, boolean active) {
        UserBean user = new UserBean();
        user.setName(name);
        user.setAge(age);
        user.setActive(active);
        return user;
    }
}
