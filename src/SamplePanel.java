import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
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

        // Draw random color square
        g.setColor(new Color((int)(Math.random()*10000000)));
        g.fillRect(100, 100, 100, 100);
        
        // Draw red line
        g.setColor(Color.red);
        g.drawLine(30, 30, 230, 30);
        
        // Draw cyan oval
        int red = 100;
        int green = 200;
        int blue = 20;
        g.setColor(new Color(red, green, blue));
        g.drawOval(230, 230, 80, 30);
        
        // Draw pink square
        g.setColor(Color.pink);
        g.drawRect(230, 230, 10, 10);
        
        // Draw image
        BufferedImage img = null;
        try {
        	String fileName = "BSD.png";
        	File file = new File(System.getProperty("user.dir") + 
        			File.separatorChar + fileName);
            img = ImageIO.read(file);
            g.drawImage(img, 300, 300, null);
        } catch (IOException e) {
        	System.out.println(e);
        }  
    }
}