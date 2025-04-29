package Lab6;

public class SingletonBean {
    private static SingletonBean instance;

    // Private constructor to prevent instantiation
    private SingletonBean() {}

    public static SingletonBean getInstance() {
        if (instance == null) {
            instance = new SingletonBean();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from SingletonBean!");
    }
}
