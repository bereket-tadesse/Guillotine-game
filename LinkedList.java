
package application;
import java.util.NoSuchElementException;

/**
 * A class to represent a linked list of nodes.
 * @author Bereket
 * @version 1.0
 * @param <T> the type of item the linked list stores
 */
public class LinkedList<T> implements Iterable<T> {
	
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    firstNode = null;
  }
  
  public static void main(String[] args) {
	LinkedList<Integer> ls = new LinkedList();
	ls.addToEnd(9);		
	ls.addToEnd(10);
	ls.addToEnd(4);
	ls.addToEnd(3);
	ls.addToEnd(6);
	System.out.println(LinkedList.printList(ls));
	
}
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFirstNode() {
    return firstNode;
  }
  /**
   * Changes the front node.
   * @param node  the node that will be the first node of the new linked list
   */
  protected void setFirstNode(LLNode<T> node) {
    this.firstNode = node;
  }
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirstNode() == null);
  }
  
  /**
   * Add an element to the front of the linked list
   */
  public void addToFront(T element) {
    setFirstNode(new LLNode<T>(element, getFirstNode()));
  }
  
  /**
   * Removes and returns the element at the front of the linked list
   * @return the element removed from the front of the linked list
   * @throws NoSuchElementException if the list is empty
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFirstNode().getElement();
      setFirstNode(getFirstNode().getNext());
      return save;
    }
  }
  
  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int length() {
    int count = 0;
    LLNode<T> nodeptr = getFirstNode();
    while (nodeptr != null) {
      count++;
      nodeptr = nodeptr.getNext();
    }
    return count;
  }
  
  /**
   * Adds an element to the end of the linkd list
   * @param element the element to insert at the end
   */
  public void addToEnd(T element) {
    if (isEmpty())
      addToFront(element);
    else {
      LLNode<T> nodeptr = getFirstNode();
      while (nodeptr.getNext() != null) 
        nodeptr = nodeptr.getNext();
      nodeptr.setNext(new LLNode<T>(element, null));
    }
  }
  
  /**
   * Return an iterator for this list
   * @return the iterator for the list
   */
  @Override
  public LinkedListIterator<T> iterator() {
    return new LinkedListIterator<T>(getFirstNode());
  }
  
  /* Static methods and generics: 
   *   Generic types only go with instance methods and fields
   *   If I want a generic here, I must declare it in the method header,
   *   before the return type 
   */
  
  /**
   * return the contents of a list.
   * @param list the list to print
   */
  public static <S> String printList(LinkedList<S> list) {
	String s = "";
    for (S element : list) {
    	s =  s + " " + element;
    }
    return s;
  }
  
  /* Generic types and wildcards:
   *    If we don't care what the generic type is because we don't use that type 
   *     (other than calling Object methods on it)
   *    we can use a wildcard that means we don't care what the generic type is 
   */
  
  /**
   * Prints the contents of a linked list to System.out.
   * @param list the linked list to print
   */
  public static void printList2(LinkedList<?> list) {
    for (Object element : list) {
      System.out.print(element);
      System.out.print(" ");
    }
    System.out.println();
  }
  
  /**
   * moves the first node of the list back n places
   * @param n number of node to move back.
   */
  public void moveBack(int n) {
	  
	  if (this.length() >= n ) {
		  //stores the current node of the linked list.
		  LLNode target = this.getFirstNode();
		  
		  //loops until the end of the linked list.
		  for (int i = 0; i<n ; i++) {
			  target = target.getNext();
		  }
		  
		  //stores the node next to the target node
		  LLNode temp = target.getNext();
		  target.setNext(this.getFirstNode());
		  this.setFirstNode(getFirstNode().getNext());
		  target.getNext().setNext(temp);
	  }
	  
  }
  
  /**
   * moves the first node to last node
   */
  public void moveFirstToLast() {
	  
	  if (getFirstNode()!= null) {
	  
		  /* stores the current node of the linked list */
		  LLNode target = this.getFirstNode();
		  
		  while(target.getNext()!=null) {
			  target = target.getNext();
		  }
		  
		  target.setNext(getFirstNode());
		  LLNode temp = getFirstNode().getNext();
		  getFirstNode().setNext(null);
		  this.setFirstNode(temp);
	  
	  }
  }
  
  /**
   * Moves the last node to first node.
   */
  public void moveLastToFIrst() {
	  
	  if (this.length()>0 ) {
		  
		  /* Stores the current node. */
		  LLNode target = this.getFirstNode();
		  
		  /* loops until final found */
		  while(target.getNext().getNext()!=null) {
			  target = target.getNext();
		  }
		 
		  target.getNext().setNext(this.getFirstNode());
		  this.setFirstNode(target.getNext());
		  target.setNext(null);
	  
	  }

  }
  
  
  /**
   * Reverses the first k nodes of the linked list
   * @param k the number of nodes to reverse
   */
  public void reverseFirstK(int k) {
	  if (k <= length()) {
		  for (int i = 1; i <= k - 1; i++) {
			  moveBack(k-i);
		  }
	  }
	  
  }
  
  /**
   * Reverses the entire linked list
   */
  public void reverseList() {
	  this.reverseFirstK(length());
  }
    
}
