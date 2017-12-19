

/**
 * A class that extends MyLinkedList to keep track and use a reference to the middle.
 *   @author Austin Fillipi
 *   @version 10/31/17
 */
public class MidLinkedList<E> extends MyLinkedList<E> {
    private DNode<E> middle;
    
    /**
     * Constructs an empty list (with dummy nodes at each end).
     */
    public MidLinkedList() {
        super();
        this.middle = this.front;
    }
    
    /**
     * Adds an item at the specified index.
     *   @param index the location where the item is to be added
     *   @param newItem the item being added
     */
    public void add(int index, E newItem) {        
        super.add(index, newItem);
        
        int midIndex = this.size()/2;        
        if (this.size() > 1 && index < midIndex) {
            if (this.size() % 2 == 0) {
                this.middle = this.middle.getPrevious();
            }
        }
        else if (this.size() % 2 == 1) {
            this.middle = this.middle.getNext();
        }       
        // System.out.println(this.middle.getData() + " " + this.toString());
    }
    
    /**
     * Removes an item at the specified index
     * @param index the location where the item is to be removed
     */
    public void remove(int index) {
    	super.remove(index);
    	
    	int midIndex = this.size()/2;        
        if (this.size() > 1 && index < midIndex) {
            if (this.size() % 2 == 0) {
                this.middle = this.middle.getNext();
            }
        }
        //else if (this.size() % 2 == 1) {
        //    this.middle = this.middle.getPrevious();
        //}
    }
    
    /**
     * Gets item at specified index
     * @param index of item to be retrieved
     */
    public DNode<E> getNode(int index){
    	 if (index < this.numStored/2) {
    		 if((this.numStored/2)-index<index) {
    			 DNode<E> stepper = this.middle;
                 for (int i = this.numStored/2; i >= index; i--) {
                     stepper = stepper.getPrevious();
                 }
                 return stepper;
    		 }
    		 else {
    			 DNode<E> stepper = this.front;
                 for (int i = 0; i <= index; i++) {
                     stepper = stepper.getNext();
                 }
                 return stepper;
    		 }
         }
    	 else {
        	 if(index-(this.numStored/2)<this.numStored-index) {
        		 DNode<E> stepper = this.middle;
                 for (int i = (this.numStored/2); i <= index; i++) {
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
    }
}