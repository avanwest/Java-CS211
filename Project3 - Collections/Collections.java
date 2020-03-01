
public interface Collections {

  void insert(int index, int data);
  void append(int data);
  void prepend(int data);
  
  int get(int index);
  int getFirst();
  int getLast();
  
  void remove(int index);
  void removeFirst();
  void removeLast();

  int size();	

}
