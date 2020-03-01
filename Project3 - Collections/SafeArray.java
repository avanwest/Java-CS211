import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;



public class SafeArray implements Collections {

	  private int[] arr;
	  private int size;
	  
	  // The default capacity to use (if not specified by the user).
	  private static final int DEFAULT_CAPACITY = 10;
	  
	  public SafeArray() {
	    this(DEFAULT_CAPACITY);
	  }
	  
	  public SafeArray(int capacity) {
	    arr = new int[capacity];
	    size = 0;
	  }
	  
	  // Print array method
	  public void printArray() {
		  for (int i = 0; i < arr.length; i++) {
			  System.out.print(arr[i] + " ");
		  }
	  }
	  
	  // Method to resize array
	  public void grow() {
		  int[] newArray = new int[arr.length];
		  newArray = Arrays.copyOf(arr,  arr.length + 10);
		  arr = newArray;
	  }
	  
	  // Data insertion methods
	  public void prepend(int data) {
		  if (size >= arr.length - 1) {
			  grow();

		  }
		  for (int i = size; i >= 0; i--) {
			  arr[i+1] = arr[i];
		  }
		    arr[0] = data;
		    size++;
		  }
	  
	  public void append(int data) {
		if (size >= arr.length) {
			grow();
			arr[size] = data;
			size++;
		} else {
		    arr[size] = data;
		    size++;
		}
	    
	  }
	  
	  public void insert(int index, int data) {
		  if (size >= arr.length) {
			  grow();
		  } 
		  for (int i = index + 1; i < arr.length; i++) {
			  arr[i] = arr[i - 1];
		  }
		  arr[index] = data;
		  size++;
	  }
	  
	  
	  // Data retrieval methods
	  public int get(int index) {
	    return this.arr[index];
	  }
	  
	  
	  public int getFirst() {
	    return arr[0];
	  }
	  
	  
	  public int getLast() {
	    return arr[size];
	  }
	  
	  // Data removal methods
	  public void removeFirst() {
		 if (size >= arr.length) {
			 grow();
		 }
		 for (int i = 0; i < size; i++) {
			 arr[i] = arr[i + 1];
		 }
		 size--;
	  }
	  
	  public void removeLast() {
		  int[] newArray = Arrays.copyOf(arr, size - 1);
		  arr = newArray;
		  size--;
				  
	  }
	  
	  public void remove(int index) {
		  arr = ArrayUtils.remove(arr, index); // falls under principles of KISS / Don't reinvent the wheel ;)
		  size--;
	  }
	  
	  
	  
	  // Return array size
	  public int size() {
		  return size;
	  }
}
