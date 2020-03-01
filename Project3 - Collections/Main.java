// Adam vanWestrienen
// JAVA PROJECT - Collections


import java.util.*;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		
		 // Create SafeArray object 'test'
		 SafeArray test = new SafeArray(); 
		 
		 // Insert 100 random numbers 0-10
		 Random rand = new Random();
		 for (int i = 0; i < 100; i++) {
			 int n = rand.nextInt(10);
			 test.insert(i, n);
		 }
		 
		 print("------------------------");
		 print("SAFEARRAY");
		 print("------------------------");
		 
		 // Print the starting array and count size
		 test.printArray();
		 print('\n');
		 print("The size of the array is: ");
		 print(test.size());
		 print('\n');
		 
		 // Call prepend method
		 print("PREPENDING: ");
		 test.prepend(77777); // output should have 5 '7s' in front
		 test.printArray();
		 print('\n');
		 print("The size of the array is: "); 
		 print(test.size()); // call size, increase to 101
		 print('\n');
		 
		 // Call append method
		 print("APPENDING: ");
		 test.append(2121212); // test output at end of array
		 test.printArray();
		 print('\n');
		 print("The size of the array is: ");
		 print(test.size()); // size increase to 102
		 print('\n');

		// Call insert method
		 print("INSERTING: ");
		 test.insert(25, 111111); 
		 test.printArray();
		 print('\n');
		 print("The size of the array is: ");
		 print(test.size()); // size increase to 102
		 
		// Call removeFirst method
		 print("REMOVE FIRST:  ");
		 test.removeFirst();
		 test.printArray();
		 print('\n');
		 print("The size of the array is: ");
		 print(test.size()); // size decrease to 101
		 print('\n');
	 
//		// Call removeLast method
		 print("REMOVE LAST:  ");
		 test.removeLast();
		 test.printArray();
		 print('\n');
		 print("The size of the array is: ");
		 print(test.size()); // size decrease to 100
		 print('\n');
	 
//		// Call removeLast method
		 print("REMOVE AT INDEX:  ");
		 test.remove(10); // remove index 10
		 test.remove(5); // remove index 5
		 test.printArray();
		 print('\n');
		 print("The size of the array is: ");
		 print(test.size()); // size decrease to 98
		 print('\n');
		 
		 print("------------------------");
		 print("LINKEDLIST");
		 print("------------------------");
		 
		 // Create LinkedList object 'list'
	     LinkedList list = new LinkedList();
	     Node head = new Node(1);
	     Node tail = new Node(2);
	     
	     // Call and test prepend
	     print("PREPENDING: ");
	     list.prepend(4);
	     list.prepend(6);
	     list.prepend(7);
	     list.prepend(head.getData());
	     list.printList();
	     print('\n');
	     print("List size: ");
	     print(list.size());
	     print('\n');
	     
	     
	     // Call and test append
	     print("APPENDING: ");
	     list.append(tail.getData());
	     list.append(9);
	     list.append(666);
	     list.printList();
	     print('\n');
	     print("List size: ");
	     print(list.size());
	     print('\n');

	     // Call and test insert
	     print("INSERT: ");
	     list.insert(3, 5555);
	     list.printList();
	     print('\n');
	     print("List size: ");
	     print(list.size());
	     print('\n');
	     
	     // Call and test removeFirst
	     print("REMOVE FIRST: ");
	     list.removeFirst();
	     list.printList();
	     print('\n');
	     print("List size: ");
	     print(list.size());
	     print('\n');
	     
	     // Call and test removeLast
	     print("REMOVE LAST: ");
	     list.removeLast();
	     list.printList();
	     print('\n');
	     print("List size: ");
	     print(list.size());
	     print('\n');
	     
	     // Call and test remove at index
	     print("REMOVE AT INDEX: ");
	     list.remove(4);
	     list.printList();
	     print('\n');
	     print("List size: ");
	     print(list.size());
	     print('\n');
	     
	     // Call and test get methods
	     print(list.get(3));
	     print(list.get(1));
	     print(list.getFirst());
	     print(list.getLast());
//	     
//	     list.remove(3);
//	     print("-----");
//	     list.printList();
//	     print("-----");
//	     list.remove(1);
//	     list.printList();
//	     print("----");
//	     
//	     list.removeFirst();
////	     list.removeLast();
//	     list.printList();
//	     print('\n');
//	     print("The size of the list is: ");
//	     print(list.size());
	     
	     
	     
	     
	     
		    
		    
		    
		    
		  }
		  
		  
	public static void print(Object o) {
	  System.out.println(o);
	  
	}
	
	
	

}
