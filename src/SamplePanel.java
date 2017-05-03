import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SamplePanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        // Fill background of our panel with blue
        g.setColor(Color.blue);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        // Draw yellow text
        g.setColor(Color.yellow);
        Font font = new Font("Arial", Font.BOLD, 38);
        g.setFont(font);
        g.drawString("(30,30)", 30, 30);
        g.drawString("(230,30)", 230, 30);
        g.drawString("(30,230)", 30, 230);
    }
}