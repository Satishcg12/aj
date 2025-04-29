package lab2;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SwingDb extends JFrame {
  JTextField name, email, id;
  JTextArea display;
  Connection conn;
  Statement stmt;

  public SwingDb() {
    setTitle("Student CRUD");
    setSize(400, 350);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(5, 5));

    // Input panel
    JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
    inputPanel.add(new JLabel("ID"));
    inputPanel.add(id = new JTextField());
    inputPanel.add(new JLabel("Name"));
    inputPanel.add(name = new JTextField());
    inputPanel.add(new JLabel("Email"));
    inputPanel.add(email = new JTextField());
    add(inputPanel, BorderLayout.NORTH);

    // Button panel
    JPanel buttonPanel = new JPanel(new FlowLayout());
    String[] buttonLabels = {"Add", "Update", "Delete", "Search", "Get All"};
    for (String label : buttonLabels) {
      JButton button = new JButton(label);
      button.addActionListener(e -> handleAction(label));
      buttonPanel.add(button);
    }
    add(buttonPanel, BorderLayout.CENTER);

    // Display area
    display = new JTextArea();
    add(new JScrollPane(display), BorderLayout.SOUTH);

    // Connect to DB
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/satish", "root", "");
      stmt = conn.createStatement();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error: " + e);
    }

    setVisible(true);
  }

  private void handleAction(String action) {
    try {
      String studentId = id.getText();
      String studentName = name.getText();
      String studentEmail = email.getText();
      String sql = "";
      String result = "";

      switch (action) {
        case "Add":
          sql = "INSERT INTO students(name, email) VALUES('" + studentName + "', '" + studentEmail + "')";
          stmt.executeUpdate(sql);
          result = "Added Successfully.";
          break;
        case "Update":
          sql = "UPDATE students SET name='" + studentName + "', email='" + studentEmail + "' WHERE id=" + studentId;
          stmt.executeUpdate(sql);
          result = "Updated Successfully.";
          break;
        case "Delete":
          sql = "DELETE FROM students WHERE id=" + studentId;
          stmt.executeUpdate(sql);
          result = "Deleted Successfully.";
          break;
        case "Search":
          sql = "SELECT * FROM students WHERE id=" + studentId;
          ResultSet rs = stmt.executeQuery(sql);
          result = rs.next() ? rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("email") : "Not Found.";
          break;
        case "Get All":
          sql = "SELECT * FROM students";
          ResultSet allRs = stmt.executeQuery(sql);
          result = "ID\tName\tEmail\n";
          while (allRs.next()) {
            result += allRs.getInt("id") + "\t" + allRs.getString("name") + "\t" + allRs.getString("email") + "\n";
          }
          break;
      }
      display.setText(result);
    } catch (SQLException e) {
      display.setText("Error: " + e);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(SwingDb::new);
  }
}