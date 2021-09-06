package assign3;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class KeyWord {
	
	/*The KeyWord Class
	 * The dictionary created from the input file will store KeyWord objects,
	 * each of which contains a word and a non-negative integer 
	 * representing the number of times the word occurs in the input file. 
	 * For the purposes of the KeyWord class, a word is a non-empty sequence 
	 * of characters in which all the letters have been converted to 
	 * lower-case (we'll add some more restrictions on what we consider 
	 * to be a word in the main class). The javadoc documentation
	 *  for KeyWord contains the complete details for each method and 
	 *  constructor. Note that the KeyWord class implements both the 
	 *  Comparable<KeyWord> interface and the Prioritizable interface
	 *   (more below) and that you will need to override the equals
	 *    method inherited from the Object class.
	 */
	
	// field
	String key;
	int wordCount;
	
	// method
	String getKey() {
		return this.key;
	}
	
	int getWordCount() {
		return this.wordCount;
	}
	
	

}
