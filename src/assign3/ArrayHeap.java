package assign3;

import java.util.NoSuchElementException;

public class ArrayHeap<E extends Prioritizable> implements PriorityQueueADT<E> {

    // default number of items the heap can hold before expanding
    private static final int INIT_SIZE = 100;
    private E[] items;
    private int numItems;

    // TO DO:
    //
    // Add a no-argument constructor that constructs a heap whose underlying
    // array has enough space to store INIT_SIZE items before needing to 
    // expand.
    //
    // Add a 1-argument constructor that takes an integer parameter and 
    // constructs a heap whose underlying array has enough space to store the 
    // number of items given in the parameter before needing to expand.  If
    // the parameter value is less 0, an IllegalArgumentException is thrown.
    //
    // Add your code to implement the PriorityQueue ADT operations using a
    // heap whose underlying data structure is an array.
    
    // constructor
    public ArrayHeap() {
    	this(INIT_SIZE);
    }
    
    public ArrayHeap(int size) {
    	if (size < 0)
    		throw new IllegalArgumentException();
    	items = (E[])(new Prioritizable[size + 1]);
    	numItems = 0;
    }


    public boolean isEmpty() {
    	return numItems ==0;
    }

    public void insert(E item) {
        // add your code
    	if (item == null)
    		throw new IllegalArgumentException();
    	
    	if (items.length == numItems + 1)
    		expandArray();
    
    	int newIndex = numItems + 1;		// set index for new item
    	items[newIndex] = item;				// add item to the end of array
    	int parentIndex = newIndex / 2;		// set index of item's parent
    	
    	// keep swapping until ArrayHeap is ordered
    	while (parentIndex > 0 && items[parentIndex].getPriority() < 
    			items[newIndex].getPriority() ) {
    		// swap item and parent
    		items[newIndex] = items[parentIndex];
    		items[parentIndex] = item;
    		// reset indices
    		newIndex = parentIndex;
    		parentIndex = newIndex / 2;
    	}
    	numItems++;
    }

    public E removeMax() {
    	if(isEmpty())
    		throw new NoSuchElementException();
    	
    	E max = items[1];					// return first element
    	int currentIndex = 1;			// index of the item being swapped with
    	E item = items[numItems];		// the item being swapped
    	items[currentIndex] = item;		// make the last item the first
    	numItems--;
    	
    	boolean ordered = false;
    	
    	while (!ordered) {
    		// case where there are no children
    		if (currentIndex * 2 > numItems) {
    			ordered = true;
    		} 
    		// case where there are a child
    		else if ((currentIndex * 2) + 1 > numItems) {
    			// if the child is larger
    			if (items[currentIndex].getPriority() < 
    					items[currentIndex * 2].getPriority() ) {
    				items[currentIndex] = items[currentIndex * 2];
    				items[currentIndex * 2] = item;
    				currentIndex = currentIndex * 2;
    			}
    			// of the parent is larger
    			else {
    				ordered = true;
    			}
    		}
    		// case where there are two children
    		// and at least one of them are larger than the parent
	    	else if ( (items[currentIndex].getPriority() < items[currentIndex*2].getPriority() ) || (items[currentIndex].getPriority() <  items[(currentIndex * 2) + 1].getPriority()) ) {
	    		// case where left child is larger or equal to right
	    		if (items[currentIndex * 2 + 1].getPriority() <= items[currentIndex * 2].getPriority() ) {
	    			items[currentIndex] = items[currentIndex * 2];
	    			items[currentIndex * 2] = item;
	    			currentIndex = currentIndex * 2;
	    		}
	    		else {
	    			items[currentIndex] = items[(currentIndex * 2) + 1];
	    			items[(currentIndex * 2) + 1] = item;
	    			currentIndex = (currentIndex * 2) + 1;
	    		}
	    	} // end of elseif
	    	else {
	    		ordered = true;
	    	}
	    		
    		
	    } // end of while
    	
    	return max;
    		
    } // end of removeMax

    public E getMax() {
    	if (isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	return items[1];
    }

    public int size() {
        return numItems;  // replace this stub with your code
    }
    
    private void expandArray() {
    	E[] newArr = (E[])new Prioritizable[(numItems + 1) * 2];
    	System.arraycopy(items, 0, newArr, 0, numItems + 1);
    	items = newArr;
    }
} // end of class