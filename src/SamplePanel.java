import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SamplePanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        // Fill background of our panel with blue
        g.setColor(Color.blue);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}