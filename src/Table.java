import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class Table {

	private SmartShape tableTop, seat1, seat2, seat3, seat4;
	private double xLoc, yLoc;
	private RestarauntDiagram restaraunt;
	// private int widthPanel, heightPanel;
	private boolean isTaken;

	public Table(int x, int y, RestarauntDiagram theRestaraunt) {
		isTaken = false;
		restaraunt = theRestaraunt;

		xLoc = x;
		yLoc = y;

		tableTop = new SmartShape(new Rectangle2D.Double(), Color.green);
		tableTop.setSize(100, 70);
		tableTop.setLocation(xLoc - 8, yLoc);

		seat1 = new SmartShape(new Ellipse2D.Double(), Color.blue);
		seat1.setSize(30, 30);
		seat1.setLocation(xLoc + 3, yLoc - 33);

		seat2 = new SmartShape(new Ellipse2D.Double(), Color.blue);
		seat2.setSize(30, 30);
		seat2.setLocation(xLoc + 53, yLoc - 33);

		seat3 = new SmartShape(new Ellipse2D.Double(), Color.blue);
		seat3.setSize(30, 30);
		seat3.setLocation(xLoc + 3, yLoc + 73);

		seat4 = new SmartShape(new Ellipse2D.Double(), Color.blue);
		seat4.setSize(30, 30);
		seat4.setLocation(xLoc + 53, yLoc + 73);

	}

	private void setTableLocation() {
		tableTop.setLocation(xLoc, yLoc);
		seat1.setLocation(xLoc + 3, yLoc - 33);
		seat2.setLocation(xLoc + 53, yLoc - 33);
		seat3.setLocation(xLoc + 3, yLoc + 73);
		seat4.setLocation(xLoc + 53, yLoc + 73);
	}

	public void cleanTable() {
		tableTop.setBorderColor(Color.green);
		//System.out.println("Color set to green");
		isTaken = false;
	}

	public void seatTable() {
		tableTop.setBorderColor(Color.red);
		//System.out.println("Color set to red");
		isTaken = true;
	}

	public void paint(java.awt.Graphics2D paintbrush) {
		tableTop.paint(paintbrush);
		seat1.paint(paintbrush);
		seat2.paint(paintbrush);
		seat3.paint(paintbrush);
		seat4.paint(paintbrush);
		//System.out.println("table painted");
	}

	public boolean isTaken() {
		return isTaken;
	}

	public SmartShape getTableTop() {
		return tableTop;
	}

}
