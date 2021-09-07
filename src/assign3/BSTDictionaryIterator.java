package assign3;

import java.util.*;

/**
 * BSTDictionaryIterator implements an iterator for a binary search tree (BST)
 * implementation of a Dictionary.  The iterator iterates over the tree in 
 * order of the key values (from smallest to largest).
 */
public class BSTDictionaryIterator<K> implements Iterator<K> {


	private Stack<BSTnode<K>> nodes;
	
    // TO DO:
    //
    // Add your code to implement the BSTDictionaryIterator.  To receive full
    // credit:
    // - You must not use recursion in any of methods or constructor.
    // - The constructor must have a worst-case complexity of O(height of BST).
    // 
    // Hint: use a Stack and push/pop nodes as you iterate through the BST.
    // The constructor should push all the nodes needed so the *first* call 
    // to next() returns the value in the node with the smallest key.
    // (You can use the Java API Stack or implement your own Stack - if you
    // implement your own, make sure to hand it in.)
	
	// constructor
	BSTDictionaryIterator(BSTnode<K> root) { 
		nodes = new Stack<BSTnode<K>>();
		if (root == null) {
			return;
		}
		
		BSTnode<K> n = root;
		nodes.push(n);
		
		// while there exist left, psu them onto the stack.
		while(n.getLeft() != null) {
			nodes.push(n.getLeft());
			n = n.getLeft();
		}
	}

    public boolean hasNext() {
       return nodes.isEmpty() == false;
    }

    public K next() {
    	if (hasNext() == false) {
    		throw new NoSuchElementException();
    	}
    
	    BSTnode<K> next = nodes.pop();
	    // if there is the right child, push it onto the stack
	    // then push the line of all left children onto the stack
	    if (next.getRight() != null) {
	    	BSTnode<K> n = next.getRight();
	    	nodes.push(n);
	    	while(n.getLeft() != null) {
	    		nodes.push(n.getLeft());
	    		n = n.getLeft();
	    	}
	    }
    return next.getKey();
     // end of next
    }
    
    public void remove() {
        // DO NOT CHANGE: you do not need to implement this method
        throw new UnsupportedOperationException();
    }    
} // end of class