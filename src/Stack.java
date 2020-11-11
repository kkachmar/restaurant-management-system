

public class Stack {
	
	private char[] array;
	private int top;
	private int numItems;
	private ReservationTree binaryTree;
	
	
	public Stack(ReservationTree binaryTree) {
		this.binaryTree = binaryTree;
		top = -1;
		array = new char [10];
		
	}
	
	public void push(char item) {
		top++;
		numItems++;
		array[top] = item;
	}
	
	
	public char pop() {
		top--;
		numItems--;
		return array[top+1];
	}
	
	public char peek() {
		
		return array[top];
	}
	
    public boolean isEmpty() {
		
		return top == -1;
	}
    
    public void popAll() {
		top = -1;
		numItems = 0;;
	}
    
    public int size() {
    	return numItems;
    }
    
    public boolean isFull() {
    	
    	return top == array.length-1;
    	
    }
	

	
	
	
		
}


