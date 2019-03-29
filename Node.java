public class Node{
  private int data;
  private Node next,prev;

  public Node(Node n, Node p, int d){
    data = d;
    next = n;
    prev = p;
  }

  public Node next(){ // This get is for the Node
    return next;
  }

  public Node prev(){
    return prev;
  }

  public int getData(){ // This get is for integer data
    return data;
  }

  public void setPrev(Node P){ // Set previous Node
    prev = P;
  }

  public void setNext(Node N){ // Set the next Node
    next = N;
  }

  public int setData(int i){
    int result = data;
    data = i;
    return result;
  }

  public String toString(){
    String result = "" + data;
    return result;
  }
}
