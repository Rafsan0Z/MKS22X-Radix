@SuppressWarnings("unchecked")
public class Node<E>{
  private E data;
  private Node next,prev;

  public Node(Node<E> n, Node<E> p, E d){
    data = d;
    next = n;
    prev = p;
  }

  public Node<E> next(){ // This get is for the Node
    return next;
  }

  public Node<E> prev(){
    return prev;
  }

  public E getData(){ // This get is for integer data
    return data;
  }

  public void setPrev(Node P){ // Set previous Node
    prev = P;
  }

  public void setNext(Node N){ // Set the next Node
    next = N;
  }

  public E setData(E i){
    E result = data;
    data = i;
    return result;
  }

  public String toString(){
    String result = "" + data;
    return result;
  }
}
