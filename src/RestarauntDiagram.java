import java.awt.*;
import javax.swing.*;

public class RestarauntDiagram extends JPanel {

	private Table t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
	

	public RestarauntDiagram() {
		super();
		
		this.setSize(650,700);
		this.setBackground(Color.BLACK);
		
		//Add Tables
		t1 = new Table(50, 50, this);
		t2 = new Table(200, 50, this);
		t3 = new Table(350, 50, this);
		t4 = new Table (500, 50, this);
		t5 = new Table(50, 250, this);
		t6 = new Table(200, 250, this);
		t7 = new Table(350, 250, this);
		t8 = new Table(500, 250, this);
		t9 = new Table(200, 450, this);
		t10 = new Table(350, 450, this);
		
		
		this.setVisible(true);

	}
	
	public void paintComponent(java.awt.Graphics brush) {
		
		super.paintComponent(brush);
		java.awt.Graphics2D paintbrush = (java.awt.Graphics2D) brush;
		t1.paint(paintbrush);
		t2.paint(paintbrush);
		t3.paint(paintbrush);
		t4.paint(paintbrush);
		t5.paint(paintbrush);
		t6.paint(paintbrush);
		t7.paint(paintbrush);
		t8.paint(paintbrush);
		t9.paint(paintbrush);
		t10.paint(paintbrush);
		//System.out.println("painted");
		
		
	}
	
	public void seatTables(int noOfTables) {
		
		for(int i = 0; i<noOfTables; i ++) {
			seatNextTable();
		}
	}
	
	public void seatNextTable() {
		if(!t1.isTaken()) {
			t1.seatTable();
		}
		else if(!t2.isTaken()) {
			t2.seatTable();
		}
		else if(!t3.isTaken()) {
			t3.seatTable();
		}
		else if(!t4.isTaken()) {
			t4.seatTable();
		}
		else if(!t5.isTaken()) {
			t5.seatTable();
		}
		else if(!t6.isTaken()) {
			t6.seatTable();
		}
		else if(!t7.isTaken()) {
			t7.seatTable();
		}
		else if(!t8.isTaken()) {
			t8.seatTable();
		}
		else if(!t9.isTaken()) {
			t9.seatTable();
		}
		else if(!t10.isTaken()) {
			t10.seatTable();
		}
		
	}

	public void cleanNextTable() {
		// TODO Auto-generated method stub
		if(t10.isTaken()) {
			t10.cleanTable();
		}
		else if(t9.isTaken()) {
			t9.cleanTable();
		}
		else if(t8.isTaken()) {
			t8.cleanTable();
		}
		else if(t7.isTaken()) {
			t7.cleanTable();
		}
		else if(t6.isTaken()) {
			t6.cleanTable();
		}
		else if(t5.isTaken()) {
			t5.cleanTable();
		}
		else if(t4.isTaken()) {
			t4.cleanTable();
		}
		else if(t3.isTaken()) {
			t3.cleanTable();
		}
		else if(t2.isTaken()) {
			t2.cleanTable();
		}
		else if(t1.isTaken()) {
			t1.cleanTable();
		}
		
	}

}
