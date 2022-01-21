/**
 * This class can also be called "nodes" which is an object that superList uses as a list. 
 */
public class ListNode<E> {

    private E current;
    private ListNode<E> next;
    private ListNode<E> previous;

    /**
     * Gets and Sets the node's value.
     * @param current
     */
    ListNode(E current){
        this.current = current;
    }

    /**
     * Sets the next linked node.
     * @param next
     */
    void setNext(ListNode<E> next){ 
        this.next = next; 
    }

    /**
     * Sets the next previous node.
     * @param previous
     */
    void setPrevious(ListNode<E> previous){ 
        this.previous = previous; 
    }

    /**
     * Gets the next linked node.
     * @return
     */
    ListNode<E> getNext(){ 
        return next; 
    }

    /**
     * Gets the previous linked node.
     * @return
     */
    ListNode<E> getPrevious(){ 
        return previous; 
    }

    /**
     * Checks if there is a node linked forward.
     * @return
     */
    boolean hasNext(){ 
        return this.next != null; 
    }

    /**
     * Checks if there is a node linked backward.
     * @return
     */
    boolean hasPrevious(){ 
        return this.previous != null; 
    }

    /**
     * Gets the value of the node
     * @return
     */
    E getValue(){
        return current;
    }

    /**
     * Sets the value of the node.
     * @param current
     */
    void setValue(E current) {
        this.current = current;
    }

}
