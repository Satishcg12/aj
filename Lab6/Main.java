package Lab6;

public class Main {
    public static void main(String[] args) {
        // Factory Usage
        UserBean user1 = UserFactory.createUser("Satish Chaudhary", 22, true);

        // Adapter Usage
        UserAdapter adapter = new UserAdapter(user1);
        adapter.displayUser();

        // Singleton Usage
        SingletonBean singleton = SingletonBean.getInstance();
        singleton.showMessage();
    }
}
