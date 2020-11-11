
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends javax.swing.JFrame {
	
	private ControlPanel controlPanel;
	private RestarauntDiagram diagram;
	

	public App(String title) {
		super(title);
		this.setSize(900, 800);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		diagram = new RestarauntDiagram();
		this.add(diagram, BorderLayout.CENTER);
		controlPanel = new ControlPanel(diagram);
		
		this.add(controlPanel, BorderLayout.EAST);
		
		
		
		
		
		
		this.setVisible(true);

	}

	public static void main(String[] args) {
		App app = new App("Restaraunt Management System");
	}
}
