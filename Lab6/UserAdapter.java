package Lab6;

public class UserAdapter {
    private UserBean userBean;

    public UserAdapter(UserBean userBean) {
        this.userBean = userBean;
    }

    public void displayUser() {
        System.out.println("Name: " + userBean.getName());
        System.out.println("Age: " + userBean.getAge());
        System.out.println("Active: " + (userBean.isActive() ? "Yes" : "No"));
    }
}
