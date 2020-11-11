import java.util.*;


public class Queue {
	
		private Node front;         // front points to front element in the queue
		private Node back;          // rear points to last element in the queue
		private int count;         // current size of the queue
		private StringBuilder builder;
		
		// Constructor to initialize queue
		Queue()
		{
			front = null;
			back = null;
			count = 0;
			builder = new StringBuilder();
		}

		// Utility function to remove front element from the queue
		public void dequeue()
		{
			// check for queue underflow
			if (isEmpty())
			{
				System.out.println("UnderFlow\nProgram Terminated");
				//System.exit(1);
			}

			Node f = front;

			if(count == 1) {
				count = 0;
				front = null;
				back = null;
				builder.setLength(0);;
				//return f.getName();
			}
			else {
				count --;
				front = front.getNext();
				
				builder.setLength(0);
				System.out.println("dequeued");
				System.out.println(front);
				System.out.println(builder);
				System.out.println(count);
				//return f.getName();
			}
		}

		// Utility function to add an item to the queue
		public void enqueue(String name, int size)
		{
			if(isEmpty()) {
				Node babyNode = new Node(name, size);
				front = babyNode;
				back = babyNode;
				count++;
			}
			else {
				Node node = new Node(name, size);
				back.setNext(node);
				back = node;
				count++;
			}
			
		}

		// Utility function to return front element in the queue
		public String peek()
		{
			if (isEmpty()) 
			{
				System.out.println("UnderFlow\nProgram Terminated");
				System.exit(1);
			}
			
			System.out.println(builder);
			System.out.println(front);
			
			builder.append("Name: "+front.getName() + " | Party Size: " +front.getSize() + " | Tables Needed: " + front.getNoOfTables());
		
			return builder.toString();
		}
		
		//Utility function to return entire list
		public String printList() 
		{
			if (isEmpty()) {
				System.out.println("UnderFlow\nProgram Terminated");
				System.exit(1);
			}
			
			Node frontHolder = front;
			
			StringBuilder builder2 = new StringBuilder();
			for (int i = 0; i<count; i++) {
				builder2.append("Name: "+frontHolder.getName() + " | Party Size: " +frontHolder.getSize() + " | Tables Needed: " + frontHolder.getNoOfTables() + "\n");
				frontHolder = frontHolder.getNext();
			}
			
		
			
			return builder2.toString();
			
		}

		// Utility function to return the size of the queue
		public int size()
		{
			return count;
		}

		// Utility function to check if the queue is empty or not
		public Boolean isEmpty()
		{
			return (size() == 0);
		}
		
		public int getNoOfTables() {
			return front.getNoOfTables();
		}
	

}
