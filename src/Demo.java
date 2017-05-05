import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Demo implements Runnable {
	public static void main(String[] args) {
		Runnable runnable = new Demo();
        SwingUtilities.invokeLater(runnable);
	}
	
	public void run() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Demo program");
		frame.setPreferredSize(new Dimension(640,480));
		frame.add(new SamplePanel2());
		frame.pack();
		frame.setVisible(true);
	}
}
