import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ReservationPanel extends JPanel {

	private ControlPanel controlPanel;
	private JLabel sectionTitle, nameLabel, timeLabel, sizeLabel, monthLabel, dateLabel;
	private JTextField nameField;
	private JComboBox hourBox, minuteBox, sizeBox, monthBox, dateBox;
	private String[] hours, minutes, size, months, days;
	private JPanel hoursLine, dateLine;
	private JButton submitButton;
	private ReservationTree reservationTree;
	// private BinaryTreeNode binaryNode;

	ReservationPanel(ControlPanel p){
		
		reservationTree = new ReservationTree();
		
		this.setLayout(new GridLayout(12,1));
		controlPanel = p;
		this.setSize(100, 200);
		sectionTitle = new JLabel("   New Reservation   ");
		sectionTitle.setHorizontalAlignment(JLabel.CENTER);
		this.add(sectionTitle);
		this.add(new JLabel(" "));
		
		nameLabel = new JLabel("Name:");
		//nameLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(nameLabel);
		
		nameField  = new JTextField();
		nameField.setColumns(20);
		
		
		this.add(nameField);
		
		hours = new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		minutes = new String[60];
		
		for (int i = 0; i<minutes.length; i++) {
			
			if (i < 10) {
				minutes[i] = ("0" +i);
			} else {
				minutes[i] = (""+i);
			}
			
			
		}
		
		
		hourBox = new JComboBox(hours);
		minuteBox = new JComboBox(minutes);
		
		
		months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
		days = new String[31];
		
		for (int i = 0; i<days.length; i++) {
			days[i] = (""+(i+1));
		}
		
		
		monthBox = new JComboBox(months);
		dateBox = new JComboBox(days);
		
		
		this.add(new JLabel("Date:"));
		
		dateLine = new JPanel();
		dateLine.add(monthBox);
		dateLine.add(new JLabel("/"));
		dateLine.add(dateBox);
		this.add(dateLine);
		

		
		this.add(new JLabel("Time:"));
		
		hoursLine = new JPanel();
		hoursLine.add(hourBox);
		hoursLine.add(new JLabel(":"));
		hoursLine.add(minuteBox);
		this.add(hoursLine);
		
		
		size = new String[40];
		
		for (int i = 0; i<size.length; i++) {
			size[i] = (""+(i+1));
		}
		
		sizeBox = new JComboBox(size);
		
		this.add(new JLabel("Party Size:"));
		this.add(sizeBox);
		
		submitButton = new JButton("Submit");
		
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//GET INFORMATION
				
				String nameInput = nameField.getText();
				int monthInput = monthBox.getSelectedIndex()+1;
				int dayInput = dateBox.getSelectedIndex() + 1;
				double hourInput = hourBox.getSelectedIndex() + 8;
				double minuteInput = minuteBox.getSelectedIndex() * .01;
				double timeInput = hourInput + minuteInput;
				int sizeInput = sizeBox.getSelectedIndex() + 1;
				
			
				//Add Information to Tree
				BinaryTreeNode reservationNode = new BinaryTreeNode(nameInput, timeInput, sizeInput, monthInput, dayInput);
				reservationTree.add(reservationNode);
				
				//Clear Fields
				monthBox.setSelectedIndex(-1);
				dateBox.setSelectedIndex(-1);
				hourBox.setSelectedIndex(-1);
				minuteBox.setSelectedIndex(-1);
				sizeBox.setSelectedIndex(-1);
				nameField.setText(null);
				
			}
			
		});
		
		this.add(submitButton);
		
		
		JButton viewReservationsButton = new JButton("View Reservations");
		viewReservationsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reservationTree.inOrderTraversal();
				
			}
			
		});
		
		this.add(viewReservationsButton);
		
		this.setVisible(true);
		
	}

}
