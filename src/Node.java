
public class Node {

	private String name;
	private int time, size, noOfTables, date, month;
	private Node next;

	public Node(String name, int time, int size, int month, int date) {
		this.name = name;
		this.time = time;
		this.size = size;
		this.month = month;
		this.date = date;
		this.next = null;
		
		int div = size/4;
		int mod = size%4;
		if(mod != 0) {
			noOfTables = div + 1;
		}
		else {
			if (size == 1 ||  size == 2 || size == 3) {
				noOfTables = 1;
			} else {
			noOfTables = div;
		}
			}
		
	}

	public Node(String name, int size) {
		this.name = name;
		this.size = size;
		
		int div = size/4;
		int mod = size%4;
		if(mod != 0) {
			noOfTables = div + 1;
		}
		else {
			if (size == 1 ||  size == 2 || size == 3) {
				noOfTables = 1;
			} else {
			noOfTables = div;
		}
			}
		
		
		this.next = null;
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

	public int getTime() {
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

	public Node getNext() {
		return next;
	}

	public void setNext(Node node) {
		this.next = node;
	}

}
