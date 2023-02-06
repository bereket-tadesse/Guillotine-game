package application;
import java.util.Iterator;
import java.util.NoSuchElementException;
/** An iterator for our linked list class */
public class LinkedListIterator<T> implements Iterator<T> {
  
  // keeps track of where in the list the iteration is at
  private LLNode<T> nodeptr;
  
  /**
   * Create a new iterator for the linked list starting at a particular node of the
list
   * @param firstNode the node where the iteration will start
   */
  public LinkedListIterator(LLNode<T> firstNode) {
    nodeptr = firstNode;
  }
  
  /**
   * Returns whether there are more elements in the iteration of the list
   * @return true if the iterator has more elements because it has not yet reached 
the end of the list
   */
  public boolean hasNext() {
    return nodeptr != null;
  }
  
  /**
   * Returns the next element of the iteration of the linked list
   * @return the next element of the iteration
   * @throws NoSuchElementException if calling next after the iteration reached the
end of the list
   */
  
  public T next() {
    if (hasNext()) {
      T save = nodeptr.getElement();
      nodeptr = nodeptr.getNext();
      return save;
    }
    else
      throw new NoSuchElementException();
  }
  
  
 
}
