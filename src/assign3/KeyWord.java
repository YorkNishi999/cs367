package assign3;

public class KeyWord implements Comparable<KeyWord>, Prioritizable {
	
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
	private String key;
	private int wordCount;
	
	
	// constructor
	public KeyWord(String key) {
		this.key = key.toLowerCase();
		this.wordCount = 0;
	}
	
	
	// method
	String getKey() {
		return this.key;
	}
	
	int getWordCount() {
		return this.wordCount;
	}

	public void incrementWordCount() {
		wordCount++;
	}
	
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return this.wordCount;
	}

	@Override
	public int compareTo(KeyWord o) {
		// TODO Auto-generated method stub
		return this.getKey().compareTo(o.getKey());
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(o != null && this.getKey().equals(o)) {
			return true;
		} else {
			return false;
		}
	}


	public void increment() {
		// TODO Auto-generated method stub
		wordCount--;
	}
	
    public int getOccurrences() {
        return wordCount;
    }
	
	

}
