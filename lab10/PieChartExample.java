import javax.swing.*;
import java.awt.*;

public class PieChartExample extends JPanel {
  int[] data = {20, 30, 50};
  Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int total = 0;
    for (int value : data) total += value;
    
    int startAngle = 0;
    for (int i = 0; i < data.length; i++) {
      int angle = (int)(data[i] * 360.0 / total);
      g.setColor(colors[i]);
      g.fillArc(50, 50, 200, 200, startAngle, angle);
      startAngle += angle;
    }
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Pie Chart");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.add(new PieChartExample());
    frame.setVisible(true);
  }
}

