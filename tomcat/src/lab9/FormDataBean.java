package tomcat.src.lab9;


// File: FormDataBean.java
public class FormDataBean {
  private String name;
  private String email;
  private String message;

  // No-argument constructor
  public FormDataBean() {
  }

  // Getters and setters
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getMessage() {
      return message;
  }

  public void setMessage(String message) {
      this.message = message;
  }
}

