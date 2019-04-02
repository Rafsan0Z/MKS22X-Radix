public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
  }

  public void clear(){
    size = 0;
    start = null;
    end = null;
  }

  public int size() { // returns size of LinkedList
    return size;
  }

  public boolean add(int value){ // Not complete
    size++;
    Node addend = new Node(null,end,value);
    if(end != null){
      end.setNext(addend);
      end = addend;
    }
    else{
      start = addend;
      end = start;
    }
    return true;
  }

  public boolean contains(Integer value){
    Node temp = start;
    int i = 0;
    while(temp.next() != null){
      temp = temp.next();
      if(temp.getData() == value){
        return true;
      }
    }
    return false;
  }

  public String toString(){ // turns the LinkedList into a String to be printed!
    String result = "[";
    Node temp = start;
    while(temp != null){
      if(temp.next() != null) {result += temp.getData() + ", ";}
      else{result += temp.getData();}
      temp = temp.next();
    }
    return result + "]";
}

  public int get(int index){
    if(index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Incorrect Index!");
    }
    Node temp = start;
    int i = 0;
    while(i < index){
      temp = temp.next();
      i++;
    }
    return temp.getData();
  }

  public int indexOf(Integer value){
    Node temp = start;
    int i = 0;
    while(temp.next() != null){
      temp = temp.next();
      if(temp.getData() == value){
        return i + 1;
      }
      i++;
    }
    return -1;
  }

  public void add(int index, Integer value){
    if(size == 0){add(value);}
    if(index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Incorrect Index!");
    }
    Node now = getNode(index);
    size++;
    if(index == size - 1){
      add(value);
    }
    Node add = new Node(now,now.prev(),value);
    now.setPrev(add);
    if(index == 0){start = add;}
    else{
      add.prev().setNext(add);
    }
  }

  private Node getNode(int index){
    Node now = start;
    for(int i = 0; i < index; i++){
      now = now.next();
    }
    return now;
  }

  public Integer remove(int index){
    if(index < 0 || index > size){
      throw new IndexOutOfBoundsException("Incorrect Index!");
    }
    Node temp = start; // create temporary Node
    Integer result = 0; // set result to 0
    if(index == 0){
      result = start.getData();
      start = start.next();
      return result;
    }
    int i = 0;
    while(i != index){
      temp = temp.next(); // while loop to get Node at index
      i++;
    }
    if(end != temp){
      Node previous = temp.prev();
      Node following = temp.next();
      previous.setNext(following);  // if temporary Node and end Node are differet, make create the previous and following Node and join them
      following.setPrev(previous);
      result = temp.getData();
    }
    else{
      Node previous = temp.prev();
      previous.setNext(null);
      end = previous;
      result = temp.getData();
    }
    size--;
    return result;
  }

  public Integer removeFront(){
    Node index = start;
    if(size == 1){
      int result = index.getData();
      clear();
      return result;
    }
    Node pivot = start.next();
    start = pivot;
    pivot.setPrev(null);
    index.setNext(null);
    size--;
    return index.getData();
  }

  public boolean remove(Integer value){
    boolean result = false; // setting result as false
    if(contains(value)) {
      remove(indexOf(value)); // Make sure that remove works!
      result = true;  // Changes the result
    }
    return result; // returns the result
  }

  public void extend(MyLinkedList extension){
    int len1 = size();
    int len2 = extension.size();
    if(len2 == 0) {extension.end = end;}
    if(len1 == 0) {start = extension.start;}
    else{
      end.setNext(extension.start);
      extension.start.setPrev(end);
    }
    size += len2;
    //extension.size() = 0;
    extension.end = null;
    extension.start = null;
  }

  public String toStringReverse(){
    String result = "[";
    Node temp = end;
    while(temp != null){
      if(temp.prev() != null) {result += temp.getData() + ", ";}
      else{result += temp.getData();}
      temp = temp.prev();
    }
    return result + "]";
  }

  public static void main(String args[]){
    MyLinkedList test = new MyLinkedList();
    test.add(1);
    test.add(2);
    System.out.println(test);
  }
}
