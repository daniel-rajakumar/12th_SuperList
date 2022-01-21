import java.util.EmptyStackException;

/**
 * A "super" list that can be used as many forms of data structures such as Arraylist, Stacks, and Queue. 
 */
public class SuperList<E>  {

    private ListNode<E> root;
    private ListNode<E> end;
    private int size = 0;

    /**
     * Adds element to the end of the list.
     * @param val
     */
    void add(E val){
        size++;
        ListNode<E> node = new ListNode<>(val);

        if (size == 1) {
            root = node;

        } else {
            end.setNext(node);
            node.setPrevious(end);
        }

        end = node;
    }

    /**
     * Adds element to the given index of the list.
     * @param index
     * @param val
     */
    void add(int index, E val){
        if ((index > size || index < 0) && size != 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index: %s, Size: %s", index, size));
        }

        add(val);
        if (size == 1) return;

        ListNode<E> node = end;

        while (++index != size){
            node.setValue(node.getPrevious().getValue());
            node = node.getPrevious();
        }

        node.setValue(val);
    }

    /**
     * Adds element to the end of the list
     * @param val
     */
    void push(E val){
        add(val);
    }

    /**
     * Removes the last element
     * @return
     */
    E pop(){
        return remove(size - 1);
    }

    /**
     * Removes the first element
     * @return
     */
    E poll(){
        return remove(0);
    }

    /**
     * Gets the value of last element without modifying it. 
     * @return
     */
    E stackPeek(){
        return end.getValue();
    }

    /**
     * Gets the value of first element without modifying it.
     * @return
     */
    E queuePeek(){
        return root.getValue();
    }

    /**
     * Gets the value of the given index.
     * @param index
     * @return
     */
    E get(int index){
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index: %s, Size: %s", index, size));
        }

        ListNode<E> node = root;
        while (index-- > 0){
            node = node.getNext();
        }
        return node.getValue();
    }

    /**
     * Sets the value of the specific element. 
     * @param index
     * @param value
     * @return
     */
    E set(int index, E value){
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index: %s, Size: %s", index, size));
        }


        ListNode<E> node = root;
        while (index-- > 0){
            node = node.getNext();
        }
        node.setValue(value);
        return node.getValue();
    }

    /**
     * Gets the total size of the list.
     * @return
     */
    int size(){
        return size;
    }

    /**
     * Removes the specific elements from the list. 
     * @param index
     * @return
     */
    E remove(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index: %s, Size: %s", index, size));
        }

        ListNode<E> node = root;
        size--;

        while (index-- != 0) {
            node = node.getNext();
        }

        E removedValue = node.getValue();

        if (node.getPrevious() == null) {
            root = root.getNext();
            if (root.hasNext()) {
                root.setPrevious(null);
            }
        } else if (node.getNext() == null) {
            end = end.getPrevious();
            if (root.hasPrevious()) {
                end.setNext(null);
            }
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }

        return removedValue;
    }

    /**
     * Check if the list is empty
     * @return
     */
    boolean isEmpty(){
        return size == 0;
    }

    /**
     * Remove all element from the list
     */
    void clear(){
        root = null;
        size = 0;
    }

    /**
     * Check if the list contains the value of specific element. 
     * @param listNode
     * @return
     */
    boolean contains(ListNode<E> listNode){
        ListNode<E> node = listNode;
        while (node.hasNext()){
            if (node.equals(listNode)){
                return true;
            }
            node = node.getNext();
        }
        return false;
    }
    
    @Override
    public String toString() {
        ListNode<E> node = root;
        if (node == null || isEmpty()) return "[]";

        String str1 = node.getValue().toString();

        while (node.hasNext()){
            String symbol = "";
            if (node.hasNext()) symbol = ", ";

            node = node.getNext();

            str1 += symbol + node.getValue();
        }

        str1 = "["  + str1 + "]";

        return str1;
    }
    
}
