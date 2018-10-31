import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * List of items.
 *
 * @param      <Item>  The item
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * size of the stack.
     */
    private int N;
    /**
     * top of stack.
     */
    private Node first;
    /**
     * helper linked list class.
     */
    private class Node {
        /**
         * item Item.
         */
        private Item item;
        /**
         * next Node.
         */
        private Node next;
    }

   /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        N = 0;
    }

   /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the stack.
     */
    public int size() {
        return N;
    }

   /**
    * Add the item to the stack.
    *
    * @param      item  The item
    */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

   /**
    * Delete and return the item most recently added to the stack.
    * Throw an exception if no such item exists because the stack is empty.
    *
    * @return     Item
    */
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }

   /**
    * Return the item most recently added to the stack.
    * Throw an exception if no such item exists because the stack is empty.
    *
    * @return     Item
    */
    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        } return first.item;
    }

   /**
    * Returns a string representation of the object.
    *
    * @return     String representation of the object.
    */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }

   /**
    * Return an iterator to the stack that iterates through the items in LIFO order. 
    *
    * @return     Item
    */
    public Iterator<Item> iterator()  { return new ListIterator();  }

    /**
     * Class for list iterator.
     * an iterator, doesn't implement remove() since it's optional
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * current node.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
             return current != null;
         }
         /**
          * remove method.
          */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * next method.
         *
         * @return     Item.
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
