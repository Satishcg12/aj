package bean;
import java.io.Serializable;

// SimpleBean with simple, boolean and indexed properties
public class SimpleBean implements Serializable {
  private String name; // Simple property
  private boolean active; // Boolean property
  private int[] scores = new int[5]; // Indexed property

  public SimpleBean() {
    // Default constructor
  }

  // Simple Property: name
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Boolean Property: active
  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  // Indexed Property: scores
  public int getScore(int index) {
    if (index >= 0 && index < scores.length) {
      return scores[index];
    } else {
      throw new IndexOutOfBoundsException("Invalid index for scores");
    }
  }

  public void setScore(int index, int value) {
    if (index >= 0 && index < scores.length) {
      this.scores[index] = value;
    } else {
      throw new IndexOutOfBoundsException("Invalid index for scores");
    }
  }

  public int[] getScores() {
    return scores;
  }

  public void setScores(int[] scores) {
    this.scores = scores;
  }
}

// Singleton Pattern
class SingletonBean {
  private static SingletonBean instance;
  private String message;

  private SingletonBean() {
    // Private constructor
    message = "Default Singleton Message";
  }

  public static SingletonBean getInstance() {
    if (instance == null) {
      instance = new SingletonBean();
    }
    return instance;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

// Factory Pattern
class FactoryBean {
  public static Object createBean(String type) {
    if (type.equalsIgnoreCase("simple")) {
      return new SimpleBean();
    } else if (type.equalsIgnoreCase("singleton")) {
      return SingletonBean.getInstance();
    }
    return null;
  }
}

// Legacy Class
class LegacyUser {
  private String fullName; // Legacy has "fullName" instead of "name"
  private int age;

  public LegacyUser(String fullName, int age) {
    this.fullName = fullName;
    this.age = age;
  }

  public String getFullName() {
    return fullName;
  }

  public int getAge() {
    return age;
  }
}

// Adapter Class
class UserAdapter {
  private LegacyUser legacyUser;

  public UserAdapter(LegacyUser legacyUser) {
    this.legacyUser = legacyUser;
  }

  // Adapting getFullName() to getName()
  public String getName() {
    return legacyUser.getFullName(); // Adapting the method
  }

  public int getAge() {
    return legacyUser.getAge();
  }
}
