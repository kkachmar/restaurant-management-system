import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WalkInPanel extends JPanel {

	private ControlPanel controlPanel;
	private JLabel sectionTitle, nameLabel, sizeLabel;
	private JTextField nameField;
	private JComboBox sizeBox;
	private String[] size;
	private JButton submitButton, seatPeopleButton, removePeopleButton;
	private Queue waitlist;
	private JFrame waitlistFrame;
	private JPanel waitlistPanel;
	private TableStack tableStack;
	private RestarauntDiagram restaraunt;
	// private BinaryTreeNode binaryNode;

	WalkInPanel(ControlPanel p, RestarauntDiagram rd) {

		// String name, double time, int size, int month, int date
		controlPanel = p;
		waitlist = new Queue();
		tableStack = new TableStack();
		restaraunt = rd;

		this.setLayout(new GridLayout(12, 1));
		
		this.setSize(100, 200);
		this.setBackground(Color.GRAY);
		
		seatPeopleButton = new JButton("Seat");
		this.add(seatPeopleButton);
		seatPeopleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableStack.pushTable();
				restaraunt.seatNextTable();
				restaraunt.repaint();
			}
		});
		
		removePeopleButton = new JButton("Remove Customers");
		this.add(removePeopleButton);
		removePeopleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableStack.popTable();
				restaraunt.cleanNextTable();
				restaraunt.repaint();
			}
		});
		
		this.add(new JLabel(""));
		sectionTitle = new JLabel("   Waitlist   ");
		sectionTitle.setHorizontalAlignment(JLabel.CENTER);
		this.add(sectionTitle);
		this.add(new JLabel(" "));

		nameLabel = new JLabel("Name:");
		this.add(nameLabel);

		nameField = new JTextField();
		nameField.setColumns(20);
		this.add(nameField);

		size = new String[40];

		for (int i = 0; i < size.length; i++) {
			size[i] = ("" + (i + 1));
		}

		sizeBox = new JComboBox(size);

		this.add(new JLabel("Party Size:"));
		this.add(sizeBox);

		submitButton = new JButton("Submit");

		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// GET INFORMATION

				String nameInput = nameField.getText();
				int sizeInput = sizeBox.getSelectedIndex() + 1;

				// Add Information to Queue
				waitlist.enqueue(nameInput, sizeInput);

				// Clear Fields
				nameField.setText(null);
				sizeBox.setSelectedIndex(-1);

			}

		});

		this.add(submitButton);

		JButton viewFullWaitlistButton = new JButton("View Entire Waitlist");
		viewFullWaitlistButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				waitlistFrame = new JFrame("Reservations");
				waitlistFrame.setSize(600, 500);
				
				waitlistPanel = new JPanel();
				
				String waitlistStream = waitlist.printList();
				JLabel allWaiting = new JLabel(" ");
				
				allWaiting.setText(makeMultiLineText(waitlistStream));
				
				waitlistPanel.add(allWaiting);
				
				waitlistFrame.add(waitlistPanel);
				
				waitlistPanel.setVisible(true);
				waitlistFrame.setVisible(true);

			}

		});

		this.add(viewFullWaitlistButton);

		
		JButton viewNextButton = new JButton("View Next In Line");
		viewNextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				waitlistFrame = new JFrame("Next Waiting:");
				waitlistFrame.setSize(500, 100);
				waitlistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				waitlistPanel = new JPanel();
				
				String waitlistStream = waitlist.peek();
				JLabel allWaiting = new JLabel(" ");
				
				allWaiting.setText(makeMultiLineText(waitlistStream));
				
				waitlistPanel.add(allWaiting);
				
				waitlistFrame.add(waitlistPanel);
				
				
				JButton seatButton = new JButton("Seat");
				
				seatButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						//push to stack
						tableStack.pushTable();
						restaraunt.seatTables(waitlist.getNoOfTables());
						waitlist.dequeue();
						restaraunt.repaint();
						
						//close frame
						waitlistFrame.dispose();
					}
					
				});
				
				waitlistPanel.add(seatButton);
				
				waitlistPanel.setVisible(true);
				waitlistFrame.setVisible(true);
				
			}
			
			
			
		});
		
		
		this.add(viewNextButton);
		
		
		this.setVisible(true);
		
	

	}

	public static String makeMultiLineText(String startingString) {

		return "<html>" + startingString.replaceAll("\n", "<br>");
	}
}
