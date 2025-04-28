package lab1;

import java.awt.*;
import java.awt.event.*;

public class BasicCalculator extends Frame implements ActionListener {
  TextField display;
  String operator = "";
  double num1 = 0, num2 = 0, result = 0;

  public BasicCalculator() {
    setTitle("Calculator");
    setSize(250, 300);
    setLayout(new BorderLayout());

    display = new TextField();
    display.setEditable(false);
    add(display, BorderLayout.NORTH);

    Panel panel = new Panel(new GridLayout(4, 4));
    String[] btns = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        "C", "0", "=", "/"
    };

    for (String text : btns) {
      Button btn = new Button(text);
      btn.addActionListener(this);
      panel.add(btn);
    }

    add(panel, BorderLayout.CENTER);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();

    if (cmd.matches("[0-9]")) {
      display.setText(cmd);
    } else if (cmd.matches("[+\\-*/]")) {
      num1 = Double.parseDouble(display.getText());
      operator = cmd;
      display.setText(cmd);
    } else if (cmd.equals("=")) {
      num2 = Double.parseDouble(display.getText());
      switch (operator) {
        case "+":
          result = num1 + num2;
          break;
        case "-":
          result = num1 - num2;
          break;
        case "*":
          result = num1 * num2;
          break;
        case "/":
          result = (num2 != 0) ? num1 / num2 : 0;
          break;
      }
      display.setText("" + result);
    } else if (cmd.equals("C")) {
      display.setText("");
    }
  }

  public static void main(String[] args) {
    new BasicCalculator();
  }
}
