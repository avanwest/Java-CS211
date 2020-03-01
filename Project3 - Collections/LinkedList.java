
public class LinkedList implements Collections {

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
	   head = null;
	   tail = null;
	   size = 0;
	  }
	  
	// Print method  
	public void printList() {
	    Node current = this.head;
	    while (current.getNext() != null) {
	      System.out.print(current.getData() + " ");
	      current = current.getNext();
	    } 
	    System.out.print(current.getData());
	  }
	
	
	// Data insertion methods
	public void prepend(int data) {
	    Node addNode = new Node(data);
	    addNode.setNext(head);
	    head = addNode;
	    size++;
	 }
	
	public void append(int data) {
		if (head == null) {
			prepend(data);
		} else {
		    Node addNode = new Node(data);
		    Node current = head;
		    while (current.getNext() != null) {
		    		current = current.getNext();
		    }
		    current.setNext(addNode);
		    tail = addNode;
		    size++;
		}
	}
	
	public void insert(int index, int data) {
		if (size == 0 || index == 1) {
			prepend(data);
		} else {
			Node addNode = new Node(data);
			Node current = head;
			int i = 0;
			while (i < index) {
				current = current.getNext();
				i++;
			}
				addNode.setNext(current.getNext());
				current.setNext(addNode);
				size++;
		}
	}
	
	
	// Data retrieval methods
	public int get(int index) {
		Node current = head;
		for (int i = 0; i < index - 1; i++) {
			current = current.getNext();
		}
		return current.getData();
	}
	
	public int getFirst() {
		return head.getData();
	}
	
	public int getLast() {
		return tail.getData();
	}
	
	
	// Data removal methods
	public void removeFirst() {
		head = head.getNext();
		size--;
	}
	
	public void removeLast() {
		Node current = head;
		int i = 1;
		while (i < size - 1) {
			current = current.getNext();
			i++;
		}
		current.setNext(null);
		size--;
	}
	
	public void remove(int index) {
		Node current = head;
		int i = 0;
		while (i < index) {
			current = current.getNext();
			i++;
		}
			current.setNext(current.next.next);
			size--;
	}
	
	// Return size method
	public int size() {
		return size;
	}
	
	
	
		
	
	
	
	



	  
	
	    
	
	
}
