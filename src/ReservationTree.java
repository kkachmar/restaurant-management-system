import javax.swing.*;
import java.awt.*;

public class ReservationTree {

	
	private BinaryTreeNode root;
	private BinaryTreeNode parent;
	private int numberOfReservations;
	private JFrame reservations;
	private StringBuilder builder;
	private JPanel reservationList;

	public ReservationTree() {
		root = null;
		numberOfReservations = 0;
		
		builder = new StringBuilder();
		
	}

	public void add(BinaryTreeNode reservation) {
		if (this.isEmpty()) {
			root = reservation;
		} else {
			insert(root, reservation);
		}

		numberOfReservations++;
	}

	private void insert(BinaryTreeNode parent, BinaryTreeNode reservation) {
		BinaryTreeNode p = parent;
		if (reservation.getMonth() < p.getMonth()) {
			if (p.getLeftChild() == null) {
				p.setLeftChild(reservation);
			} else {
				insert(p.getLeftChild(), reservation);
			}
		} else if (reservation.getMonth() > p.getMonth()) {
			if (p.getRightChild() == null) {
				p.setRightChild(reservation);
			} else {
				insert(p.getRightChild(), reservation);
			}
		} else {// reservation.getMonth() == p.getMonth()
			if (reservation.getDate() < p.getDate()) {
				if (p.getLeftChild() == null) {
					p.setLeftChild(reservation);
				} else {
					insert(p.getLeftChild(), reservation);
				}
			} else if (reservation.getDate() > p.getDate()) {
				if (p.getRightChild() == null) {
					p.setRightChild(reservation);
				} else {
					insert(p.getRightChild(), reservation);
				}
			} else {// reservation.getDate() == p.getDate()
				if (reservation.getTime() < p.getTime()) {
					if (p.getLeftChild() == null) {
						p.setLeftChild(reservation);
					} else {
						insert(p.getLeftChild(), reservation);
					}
				} else if (reservation.getTime() > p.getTime()) {
					if (p.getRightChild() == null) {
						p.setRightChild(reservation);
					} else {
						insert(p.getRightChild(), reservation);
					}
				} else {// reservation.getTime() == p.getTime()
					p.setRightChild(reservation);
				}
			}
		}

	}

	private boolean isEmpty() {
		return (root == null);
	}

	public void inOrderTraversal() {
		if (this.isEmpty()) {
			System.out.println("No Reservations");
		} else {
			inOrder(root);
			
			reservations = new JFrame("Reservations");
			reservations.setSize(600, 500);
			
			reservationList = new JPanel();
			
			String reservationStream = builder.toString();
			JLabel allReservations = new JLabel(" ");
			
			allReservations.setText(makeMultiLineText(reservationStream));
			
			reservationList.add(allReservations);
			
			reservations.add(reservationList);
			
			reservationList.setVisible(true);
			reservations.setVisible(true);
		}
	}

	private void inOrder(BinaryTreeNode treeNode) {
		
		if (treeNode != null) {
			inOrder(treeNode.getLeftChild());
			
			builder.append("Date: "+ treeNode.getMonth() + "/" + treeNode.getDate() + " | Time: " + treeNode.getTime()+ " | Name: " + treeNode.getName() + " | Time: " + treeNode.getTime() + " | Party Size: " + treeNode.getSize() + " | Tables Needed: " + treeNode.getNoOfTables()+ "\n");
			
			inOrder(treeNode.getRightChild());
			
		}
		
	}
	
	//helper method found on stackOverflow
	public static String makeMultiLineText(String startingString) {
		
		return "<html>" + startingString.replaceAll("\n", "<br>");
	}
	
	
	
}
