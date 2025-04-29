package lab14;

public class StudentController {
  private StudentModel model;
  private StudentView view;

  public StudentController(StudentModel model, StudentView view) {
      this.model = model;
      this.view = view;
  }

  public void setStudentDetails(String name, double gpa) {
      model.setName(name);
      model.setGpa(gpa);
  }

  public void updateView() {
      // Update the view with student data
      view.displayStudentDetails(model.getName(), model.getGpa());
  }
}

