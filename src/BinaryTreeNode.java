
public class BinaryTreeNode {

	private String name;
	private int size, noOfTables, date, month;
	private double time;
	private BinaryTreeNode node;
	private BinaryTreeNode leftChild, rightChild;

	public BinaryTreeNode(String name, double time, int size, int month, int date) {
		this.name = name;
		this.time = time;
		this.size = size;
		this.month = month;
		this.date = date;

		int div = size / 4;
		int mod = size % 4;
		if (mod != 0) {
			noOfTables = div + 1;
		} else {
			noOfTables = div;
		}

		leftChild = null;
		rightChild = null;

	}

	public BinaryTreeNode(String name, double time, int size, int month, int date, BinaryTreeNode newLeftChild,
			BinaryTreeNode newRightChild) {
		this.name = name;
		this.time = time;
		this.size = size;
		this.month = month;
		this.date = date;

		int div = size / 4;
		int mod = size % 4;
		if (mod != 0) {
			noOfTables = div + 1;
		} else {
			noOfTables = div;
		}

		leftChild = newLeftChild;
		rightChild = newRightChild;

	}

	public int getNoOfTables() {
		return noOfTables;
	}

	public void setNoOfTables(int n) {
		noOfTables = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public BinaryTreeNode getNode() {
		return node;
	}

	public void setNode(BinaryTreeNode node) {
		this.node = node;
	}

	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}

}
