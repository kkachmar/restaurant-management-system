import java.awt.*;
import javax.swing.*;

public class ControlPanel extends JPanel{
	
	
	public ControlPanel(RestarauntDiagram rd) {
	RestarauntDiagram diagram = rd;
	this.setLayout(new GridLayout(2, 1));
	this.setBackground(Color.GRAY);
	this.setSize(200, 800);
	this.setVisible(true);
	
	this.add(new ReservationPanel(this));
	this.add(new WalkInPanel(this, diagram));
	
	
	}
	
	
}
