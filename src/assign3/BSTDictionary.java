package assign3;

import java.util.Iterator;

import prog1.DblListnode;

public class BSTDictionary<K extends Comparable<K>> implements DictionaryADT<K> {
    private BSTnode<K> root;  // the root node
    private int numItems;     // the number of items in the dictionary
    private boolean deletion;
    // TO DO:
    //
    // Add a no-argument constructor
    
    // constructor
    public BSTDictionary() {
    	root = null;
    	numItems = 0;
    }
    //
    // Add your code to implement the Dictionary ADT operations using a binary
    // search tree.
    // You may use any code given in the on-line reading on BSTs.
    
    public void insert(K key) throws DuplicateException {
    	
    	if(key == null) {
    		throw new IllegalArgumentException();
    	}
    	
    	root = insert1(root, key);
    	numItems++;
    }
    
    private BSTnode<K> insert1(BSTnode<K> n, K key) throws DuplicateException {
        // add your code
    	   /**
         * Inserts the given key into the Dictionary if the key 
         * is not already in 
         * the Dictionary.  If the key is already in the
         *  Dictionary, a DuplicatException is thrown.
         * @param key the key to insert into the Dictionary
         * @throws DuplicateException if the key is already in the Dictionary
         * @throws IllegalArgumentException if the key is null
         */ 
    	
    	if (key == null)
    		return new BSTnode<K>(key, null, null);
    	
    	if(n.getKey().equals(key)) {
    		throw new DuplicateException("Error occurs.");
        	
    	}
    	
    	if(key.compareTo(n.getKey()) < 0) {
    		// add key to left subtree
    		n.setLeft(insert1(n.getLeft(), key));
    		return n;
    	}
    	else {
    		n.setRight(insert1(n.getRight(), key));
    		return n;
    	}
    	
    } // end of insert

    public boolean delete(K key) {
    	deletion = false;
    	if (key != null) {
    		root = delete1(root, key);
    	}
    	
    	if (deletion)
    		numItems--;
    	
    	return deletion;
    }
    
    
    private BSTnode<K> delete1(BSTnode<K> n, K key){
    	
    	if (n == null) {
    		return null;
    	}
    	
    	if (key.equals(n.getKey())) {
    		deletion = true;
    		
    		if (n.getLeft() == null && n.getRight() == null) {
    			// no child
    			return null;
    		}
    		if (n.getLeft() == null) {
    			//right child
    			return n.getRight();
    		}
    		if (n.getRight() == null) {
    			return n.getLeft();
    		}
    		
    		// n has 2 children
    		K smallVal = smallest(n.getRight());
    		n.setKey(smallVal);
    		n.setRight(delete1(n.getRight(), smallVal));
    		return n;
    	}
    	
    	else if (key.compareTo(n.getKey()) < 0) {
    		n.setLeft(delete1(n.getLeft(), key));
    		return n;
    	}
    	
    	else {
    		n.setRight(delete1(n.getRight(), key));
    		return n;
    	}
    	
    	
    } // end of delete
    
    private K smallest(BSTnode<K> n) {
    	if(n.getLeft() == null) {
    		// no left child, this value is the smallest
    		return n.getKey();
    	} else {
    		// if the left exists, go to left subtree
    		return smallest(n.getLeft());
    	}
    }

    public K lookup(K key) {
    	if (key == null)
    		return null;
    	
    	return lookup1(root, key);
    }
    
    private K lookup1(BSTnode<K> n, K key) {
    	// node n から K key を探す
    	
    	if (n == null)
    		return null;
    	
    	if (n.getKey().equals(key))
    		return n.getKey();
    	
    	if (key.compareTo(n.getKey()) < 0) {
    		return lookup1(n.getLeft(), key);
    				// key less than node's key -> left
    	} else {
    		return lookup1(n.getRight(), key);
    	}
    } // end of lookup, lookup1

    public boolean isEmpty() {
    	
        return numItems == 0;  // replace this stub with your code
    }

    public int size() {
        return numItems;  // replace this stub with your code
    }
    
    public int totalPathLength() {
        return totalPathLength1(root, 1);  // replace this stub with your code
    }
    
    private int totalPathLength1(BSTnode<K> n, int depth) {
    	if (n == null)
    		return 0;
    	
    	if (n.getLeft() == null && n.getRight() == null) {
    		return depth;
    	}
    	return depth + totalPathLength1(n.getLeft(), depth + 1) + totalPathLength1(n.getRight(), depth + 1);
    }
    
    public Iterator<K> iterator() {
        return new BSTDictionaryIterator<K>(root);  // replace this stub with your code
    }


}