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
    }

    public E removeMax() {
        return null;  // replace this stub with your code
    }

    public E getMax() {
        return null;  // replace this stub with your code
    }

    public int size() {
        return 0;  // replace this stub with your code
    }
}