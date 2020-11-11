import java.util.LinkedList;

public class TableStack {
	
	private Stack stack;
	private Node reservations;
	private boolean isFinished;
	
	
	public TableStack() {
		
		ReservationTree tree = new ReservationTree();
		
	    stack = new Stack(tree);
	}
	
	
	public void createWaitList() {
	  if (stack.isFull()) {
		
	     LinkedList <String> waitList = new LinkedList<String>();
	  }
	   
	}
	
	public void pushTable() {
		
		 if(stack.size() <= 10) {
		    	stack.push('x');
		    	
		    }
		
	}
	
	public void popTable() {
		if(isFinished) {
			stack.pop();
		}
	}
	
	public void setTableStack(Stack newStack) {
		stack = newStack;
	}
	
	public Stack getTableStack() {
		return stack;
	}
	
	

}
