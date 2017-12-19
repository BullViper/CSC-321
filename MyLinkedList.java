
import java.util.Iterator;
import java.util.Scanner;

/**
 * A simplified version of the generic LinkedList class.
 *   @author Dave Reed
 *   @version 9/2/17
 */
public class MyLinkedList<E> implements Iterable<E> {
    protected DNode<E> front;
    protected DNode<E> back;
    protected int numStored;
    
    /**
     * Constructs an empty list (with dummy nodes at each end).
     */
    public MyLinkedList() {
        this.front = new DNode(null, null, null);
        this.back = new DNode(null, front, null);
        this.front.setNext(this.back);
        this.numStored = 0;
    }
    
    /**
     * Adds an item at the specified index.
     *   @param index the location where the item is to be added
     *   @param newItem the item being added
     */
    public void add(int index, E newItem) {
        this.rangeCheck(index, "ArrayList add()", this.numStored);
        
        DNode<E> beforeNode = this.getNode(index-1);
        DNode<E> afterNode = beforeNode.getNext();
        
        DNode<E> newNode = new DNode<E>(newItem, beforeNode, afterNode);
        beforeNode.setNext(newNode);
        afterNode.setPrevious(newNode);
                
        this.numStored++;
    }
    
    /**
     * Adds an item to the end of the list.
     *   @param newItem the item to be added
     *   @return true
     */
    public boolean add(E newItem) {
        this.add(this.numStored, newItem);
        return true;
    }
    
    /**
     * Gets the item stored at the specified index.
     *   @param index the index
     *   @return the item stored at index
     */
    public E get(int index) {
        this.rangeCheck(index, "ArrayList get()", this.numStored-1);
        return this.getNode(index).getData();
    }
    
    /**
     * Finds the first occurrence of an item in the list.
     *   @param oldItem the item to be searched for
     *   @return the index of oldItem in the list
     */
    public int indexOf(E oldItem) {
        DNode<E> stepper = this.front.getNext(); 
        for (int i = 0; i < this.numStored; i++) {
            if (oldItem.equals(stepper.getData())) {
                return i;
            }
            stepper = stepper.getNext();
        }    
        return -1;
    }
    
    /**
     * Determines whether a specified item is stored in the list.
     *   @param oldItem the item to be searched for
     *   @return true if the list contains oldItem, else false
     */
    public boolean contains(E oldItem) {
        return (this.indexOf(oldItem) >= 0);
    }
    
    /**
     * Determines the size of the list.
     *     @return the number of items currently stored
     */
    public int size() {
        return this.numStored;
    }
    
    /**
     * Removes the item at a specified index.
     *   @param index the index of the item to be removed 
     */
    public void remove(int index) {
        this.rangeCheck(index, "ArrayList remove()", this.numStored-1);
        
        DNode<E> removeNode = this.getNode(index);
        removeNode.getPrevious().setNext(removeNode.getNext());
        removeNode.getNext().setPrevious(removeNode.getPrevious());
        this.numStored--;
    }
    
    /**
     * Removes a specified item from the list.
     *   @param oldItem the item to be removed
     *   @return true if able to remove oldItem, else false
     */
    public boolean remove(E oldItem) {
        int index = this.indexOf(oldItem);
        if (index >= 0) {
            this.remove(index);
            return true;
        }
        return false;
    }
       
    /**
     * Generates an iterator over the list.
     * @return the iterator
     */
    public Iterator<E> iterator() {
         return new LinkedIterator();
    }
    
    public String toString() {
        if (this.size() == 0) {
            return "[]";
        }
        
        String msg = "[";
        for (E item : this) {
            msg += item.toString() + ", ";
        }
        return msg.substring(0, msg.length()-2) + "]";
    }
    /////////////////////////////////////////////////////////////////
    
    /**
     * Helper method that checks for index-out-of-bounds errors.
     *   @param index the index to be checked
     *   @param msg a String identifying the calling origin
     *      @param upperBound the largest index allowed
     */
    private void rangeCheck(int index, String msg, int upperBound)  {
        if (index < 0 || index > upperBound)
            throw new IndexOutOfBoundsException("\n" + msg + ": index " 
                    + index + " out of bounds. Should be in the range 0 to " +
                    upperBound);
    }

    /**
     * Helper method that returns the node at the specified index.
     *   @param index the index of the desired node
     *   @return (a reference to) that node 
     */
    protected DNode<E> getNode(int index) {
        if (index < this.numStored/2) {
            DNode<E> stepper = this.front;
            for (int i = 0; i <= index; i++) {
                stepper = stepper.getNext();
            }
            return stepper;
        }
        else {
            DNode<E> stepper = this.back;
            for (int i = this.numStored-1; i >= index; i--) {
                stepper = stepper.getPrevious();
            }
            return stepper;
        }
    }
    
    /////////////////////////////////////////////////////////////////
    
    /**
     * Inner class that defines a doubly-linked node.
     *   @param <E> the type of data being stored in the node
     */
    protected class DNode<E> {
        private E data;
        private DNode<E> previous;
        private DNode<E> next;
        
        public DNode(E data, DNode<E> previous, DNode<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
        
        public E getData() {
            return this.data;
        }
        
        public DNode<E> getPrevious() {
            return this.previous;
        }
        
        public DNode<E> getNext() {
            return this.next;
        }
        
        public void setData(E newData) {
            this.data = newData;
        }
        
        public void setPrevious(DNode<E> newPrevious) {
            this.previous = newPrevious;
        }
        
        public void setNext(DNode<E> newNext) {
            this.next = newNext;
        }
    }
    
    /**
     * Inner class that defines an iterator for MyLinkedList.
     */
    private class LinkedIterator implements Iterator<E> {
        private DNode<E> nextNode;
        public LinkedIterator() {
            this.nextNode = front.getNext();
        }

        public boolean hasNext() {
            return this.nextNode != MyLinkedList.this.back;
        }

        public E next() {
            this.nextNode = this.nextNode.getNext();
            return this.nextNode.getPrevious().getData();
        }

        public void remove() {
           if (this.nextNode == front.getNext()) {
               throw new RuntimeException("Iterator call " +
                                           "to next() required before " +
                                           "calling remove()");
           }
           this.nextNode.setPrevious(this.nextNode.getPrevious().getPrevious());
           this.nextNode.getPrevious().setNext(this.nextNode);
           MyLinkedList.this.numStored--;
       }
    }
}