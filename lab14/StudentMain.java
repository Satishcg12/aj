package MVC;

public class StudentMain {
  public static void main(String[] args) {
        // Create the model (Student)
        StudentModel student = new StudentModel("Rynb", 3.9);
        
        // Create the view
        StudentView view = new StudentView();
        
        // Create the controller
        StudentController controller = new StudentController(student, view);
        
        // Display the student details using the controller
        controller.updateView();
    }
}
