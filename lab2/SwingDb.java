package lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SwingDb extends JFrame {
  JTextField name, email, id;
  JButton add, update, delete, search, getAll;
  JTextArea display;

  Connection conn;
  Statement stmt;

  public SwingDb() {
    setTitle("Basic Student CRUD");
    setSize(400, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(0, 2, 5, 5));

    // Create UI components
    id = new JTextField(10);
    name = new JTextField(10);
    email = new JTextField(10);
    add = new JButton("Add");
    update = new JButton("Update");
    delete = new JButton("Delete");
    search = new JButton("Search");
    getAll = new JButton("Get All");
    display = new JTextArea(10, 30);

    // Add components to frame
    add(new JLabel("ID"));
    add(id);
    add(new JLabel("Name"));
    add(name);
    add(new JLabel("Email"));
    add(email);
    add(add);
    add(update);
    add(delete);
    add(search);
    add(getAll);
    add(new JScrollPane(display));

    // Database connection
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/satish", "root", "satish");
      stmt = conn.createStatement();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(this, "DB Error: " + e);
    } catch (ClassNotFoundException e) {
      JOptionPane.showMessageDialog(this, "Driver Error: " + e);
    }

    // Event handlers
    add.addActionListener(e -> addStudent());
    update.addActionListener(e -> updateStudent());
    delete.addActionListener(e -> deleteStudent());
    search.addActionListener(e -> searchStudent());
    getAll.addActionListener(e -> getAllStudents());

    setVisible(true);
  }

  void addStudent() {
    try {
      String studentName = name.getText();
      String studentEmail = email.getText();
      String sql = "INSERT INTO students(name, email) VALUES('" + studentName + "', '" + studentEmail + "')";
      stmt.executeUpdate(sql);
      display.setText("Added Successfully.");
    } catch (SQLException e) {
      display.setText("Error: " + e);
    }
  }

  void updateStudent() {
    try {
      String studentName = name.getText();
      String studentEmail = email.getText();
      String studentId = id.getText();
      String sql = "UPDATE students SET name='" + studentName + "', email='" + studentEmail + "' WHERE id=" + studentId;
      stmt.executeUpdate(sql);
      display.setText("Updated Successfully.");
    } catch (SQLException e) {
      display.setText("Error: " + e);
    }
  }

  void deleteStudent() {
    try {
      String studentId = id.getText();
      String sql = "DELETE FROM students WHERE id=" + studentId;
      stmt.executeUpdate(sql);
      display.setText("Deleted Successfully.");
    } catch (SQLException e) {
      display.setText("Error: " + e);
    }
  }

  void searchStudent() {
    try {
      String studentId = id.getText();
      String sql = "SELECT * FROM students WHERE id=" + studentId;
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next()) {
        String result = rs.getInt("id") + "\t" +
            rs.getString("name") + "\t\t" +
            rs.getString("email") + "\n";
        display.setText(result);
      } else {
        display.setText("Not Found.");
      }
    } catch (SQLException e) {
      display.setText("Error: " + e);
    }
  }

  void getAllStudents() {
    try {
      String sql = "SELECT * FROM students";
      ResultSet rs = stmt.executeQuery(sql);
      String result = "ID\tName\t\tEmail\n";
      result += "";

      while (rs.next()) {
        result += rs.getInt("id") + "\t" +
            rs.getString("name") + "\t\t" +
            rs.getString("email") + "\n";
      }

      if (result.length() == 0) {
        display.setText("No students found in database.");
      } else {
        display.setText(result);
      }
    } catch (SQLException e) {
      display.setText("Error: " + e);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new SwingDb();
    });
  }
}