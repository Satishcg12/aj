import javax.swing.*;
import java.awt.*;

public class PieChartExample extends JPanel {

  int[] data = { 20, 30, 50 }; // Pie slice data
  String[] labels = { "Category 1", "Category 2", "Category 3" }; // Labels
  Color[] colors = { Color.RED, Color.GREEN, Color.BLUE }; // Colors for slices
  int total = 0; // Total of all slices

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int startAngle = 0; // Starting angle for the first slice

    // Calculate the total of all slices
    for (int value : data) {
      total += value;
    }


    for (int i = 0; i < data.length; i++) {
      int angle = (int) Math.round((data[i] / (double) total) * 360);
      g.setColor(colors[i]);
      g.fillArc(50, 50, 200, 200, startAngle, angle);
      startAngle += angle;
    }
  }

  public static void main(String[] args) {
    // Create the JFrame to display the panel
    JFrame frame = new JFrame("Pie Chart Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.add(new PieChartExample()); // Add PieChartExample to the JFrame
    frame.setVisible(true);
  }
}

