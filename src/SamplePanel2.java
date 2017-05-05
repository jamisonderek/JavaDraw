import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SamplePanel2 extends JPanel {
	
	ArrayList<Shape> shapes;
	Rectangle2D mouseClickRect = new Rectangle2D.Double();

	SamplePanel2() {

		setBackground(Color.blue);
		
		shapes = new ArrayList<Shape>();

		shapes.add(new Line2D.Double(20, 20, 30, 30));
		shapes.add(new Line2D.Double(20, 30, 30, 20));
		shapes.add(new Line2D.Double(25, 20, 25, 30));

		shapes.add(new Rectangle2D.Double(50, 70, 20, 30));

		shapes.add(new QuadCurve2D.Double(50, 120, 30, 150, 150, 120));

		shapes.add(new CubicCurve2D.Double(50, 150, 70, 130, 120, 180, 150, 150));

		shapes.add(new Rectangle2D.Double(50, 200, 150, 50));

		shapes.add(new RoundRectangle2D.Double(50, 280, 150, 50, 30, 30));

		shapes.add(new Ellipse2D.Double(50, 350, 150, 50));
		shapes.add(new Ellipse2D.Double(170, 350, 150, 50));

		shapes.add(new Arc2D.Double(350, 350, 150, 50, 45, 270, Arc2D.PIE));

		shapes.add(MyShape(350, 100));

		shapes.add(MyShape(350, 200));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pressed(e.getX(), e.getY());
			}
		});
	}

	private void pressed(int x, int y) {
		mouseClickRect.setRect(x, y, 1, 1);
		repaint();
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;

		Rectangle2D mouseCursorRect = getMouseCursor();
		
		for (Shape s : shapes) {
			if (s.intersects(mouseClickRect)) {
				float x = (float)mouseClickRect.getX();
				float y = (float)mouseClickRect.getY();
				g.setPaint(new GradientPaint(x, y, Color.RED, x + 10, y + 30, Color.YELLOW));
				g.fill(s);
			} else if (s.intersects(mouseCursorRect)) {
					float x = (float)mouseCursorRect.getX();
					float y = (float)mouseCursorRect.getY();
					g.setPaint(new GradientPaint(x, y, Color.GREEN, x + 30, y + 10, Color.BLACK));
					g.fill(s);
			} else {
				g.setPaint(Color.yellow);
				g.draw(s);
			}
		}
		
		// Repaint so that we paint latest mouseCursor.
		repaint();
	}
	
	private Rectangle2D getMouseCursor()
	{
		Point cursor = MouseInfo.getPointerInfo().getLocation();
		Point locataionOfJPanel = new Point(0,0);
		SwingUtilities.convertPointToScreen(locataionOfJPanel, this);		
		Rectangle2D mouseCursor = new Rectangle2D.Double(cursor.getX()-locataionOfJPanel.getX(), cursor.getY()-locataionOfJPanel.getY(), 1, 1); 		
		return mouseCursor;
	}
	
	private Shape MyShape(int x, int y) {
		int[][] coords = { 
				{ 0, 0 }, 
				{ 20, 5 }, 
				{ 40, 10 }, 
				{ 60, 20 }, 
				{ 80, 40 }, 
				{ 20, 37 }, 
				{ 30, 20 }, 
				{ 10, 5 } 
			};
		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, coords.length);
		polygon.moveTo(x + coords[0][0], y + coords[0][1]);
		for (int i = 1; i < coords.length; i++) {
			polygon.lineTo(x + coords[i][0], y + coords[i][1]);
		}
		polygon.closePath();
		return polygon;
	}
}