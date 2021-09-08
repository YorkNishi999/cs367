package assign4;

/**
 * This class implements six different comparison sorts (and an optional
 * seventh sort for extra credit):
 * <ul>
 * <li>selection sort</li>
 * <li>insertion sort</li>
 * <li>merge sort</li>
 * <li>quick sort</li>
 * <li>heap sort</li>
 * <li>selection2 sort</li>
 * <li>(extra credit) insertion2 sort</li>
 * </ul>
 * It also has a method that runs all the sorts on the same input array and
 * prints out statistics.
 */

public class ComparisonSort {

	private static int dataMoves = 0; 
	
	// reset dataMoves = 0;
	
	public static void resetDataMoves() {
		dataMoves = 0;
	}
    /**
     * Sorts the given array using the selection sort algorithm. You may use
     * either the algorithm discussed in the on-line reading or the algorithm
     * discussed in lecture (which does fewer data moves than the one from the
     * on-line reading). Note: after this method finishes the array is in sorted
     * order.
     * 
     * @param <E>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <E extends Comparable<E>> void selectionSort(E[] A) {
        // TODO: implement this sorting algorithm
    	
    	if ( A == null) {
    		NullPointerException();
    	}
    	
    	int j;			// current element's position
    	int k; 		// position in the array to find element for 
    	int minIndex; // index of lowest element
    	int N = A.length; // length of the array
    	
    	for ( k = 0; k < N; ++k) {
    		minIndex = k;
    		// find smallest value in k+1 to end of array
    		for ( j = k + 1; j < N; ++j) {
    			if (A[j].compareTo(A[minIndex]) < 0) {
    				minIndex = j;
    			}
    		}
    		// swap the min with value at k
    		E tmp = A[minIndex];
    		dataMoves++;
    		A[minIndex] = A[k];
    		dataMoves++;
    		A[k] = tmp;
    		dataMoves++;
    	}
    	
    } // end of selectionSort

    private static void NullPointerException() {
		// TODO Auto-generated method stub
		System.out.println("Null pointer");
	}
	/**
     * Sorts the given array using the insertion sort algorithm. Note: after
     * this method finishes the array is in sorted order.
     * 
     * @param <E>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <E extends Comparable<E>> void insertionSort(E[] A) {
        // TODO: implement this sorting algorithm
    	if ( A == null) {
    		NullPointerException();
    	}
    	
    	int k;					// position of element being inserted 
    	int j;					// position of current element to compare to
    	E tmp;					// holder for the element inseted
    	int N = A.length;		// length
    	
    	
    	for ( k = 1; k < N; ++k ) {
    		tmp = A[k];
    		dataMoves++;
    		j = k - 1;
    		while (( j >= 0) && (A[j].compareTo(tmp) > 0)) {
    			A[ j + 1] = A[j];
    			dataMoves++;
    			j--;
    		}
    		A[ j + 1] = tmp;  // insert kth value in correct place relative to prev values
    		dataMoves++;
    	}
    } // end of insertionSelection

    /**
     * Sorts the given array using the merge sort algorithm. Note: after this
     * method finishes the array is in sorted order.
     * 
     * @param <E>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <E extends Comparable<E>> void mergeSort(E[] A) {
        // TODO: implement this sorting algorithm
    	
    	if ( A == null) {
    		NullPointerException();
    	}
    	
    	if (A.length == 0) {
    		return;
    	}
    	
    	mergeAux(A, 0, A.length - 1);
    }
    
    private static <E extends Comparable<E>> void mergeAux(E[] A, int low, int high) {
    	// base case
    	if (low == high) {
    		return;
    	}
    	
    	// recursive case
    	
    	// step1: Find the middle of the rray
    	int mid = (low + high) / 2;
    	
    	// step2, 3: Sort the 2 halves of A
    	mergeAux(A, low, mid);
    	mergeAux(A, mid+1, high);
    	
    	// step 4: merge sorted halves into an auxiliary array
    	E[] tmp = (E[])(new Comparable[high - low + 1]);
    	int left = low;
    	int right = mid + 1;
    	int pos = 0;
    	
    	while (( left <= mid) && (right <= high)) {
    		// choose the smaller of the two values "pointed to" by left, right
    		// copy that value int tmp[pos]
    		// increment either left or right as appropriate
    		// increment pos
    		if (A[left].compareTo(A[right]) <= 0 ) {
    			tmp[pos] = A[left];
    			dataMoves++;
    			left++;
    		} else {
    			tmp[pos] = A[right];
    			dataMoves++;
    			right++;
    		}
    		pos++;
    	}
    	
    	// when one of the two sorted halves has "run out" of values, but
    	// there are still some in the other half, copy all the remaining
    	// values to tem
    	// note: only 1 of the next 2 loop will actually execute
    	while (left <= mid) {
    		tmp[pos] = A[left];
    		dataMoves++;
    		left++;
    		pos++;
    	}
    	while (right <= high) {
    		tmp[pos] = A[right];
    		dataMoves++;
    		right++;
    		pos++;
    	}
    	
    	// all values are in tmp; copy them back int A
    	System.arraycopy(tmp, 0, A, low, tmp.length);
    	dataMoves += tmp.length;
    } // end of mergeAux


    /**
     * Sorts the given array using the quick sort algorithm, using the median of
     * the first, last, and middle values in each segment of the array as the
     * pivot value. Note: after this method finishes the array is in sorted
     * order.
     * 
     * @param <E>  the type of values to be sorted
     * @param A   the array to sort
     */
    public static <E extends Comparable<E>> void quickSort(E[] A) {
        // TODO: implement this sorting algorithm
    	if ( A == null) {
    		NullPointerException();
    	}
    	
    	if (A.length == 0) {
    		return;
    	}
    	
    	quickAux(A, 0, A.length - 1);
    }

    private static <E extends Comparable<E>> void quickAux(E[]A, int low, int high) {
    	// if length is  2, compare and swap if necessary
    	// if length is 1, nothing
    	if ( high - low < 2) {
    		if (A[low].compareTo(A[high]) > 0) {
    			E tmp = A[low];
    			dataMoves++;
    			A[low] = A[high];
    			dataMoves++;
    			A[high] = tmp;
    			dataMoves++;
    		}
    	} else {
    		int right = partition(A, low, high);
    		quickAux(A, low, right);
    		quickAux(A, right + 2, high);
    	}
    	
    } // end of quickAux
    
    private static <E extends Comparable<E>> int partition(E[] A, int low, int high) {
    	// precondition: A.length < 2
    	E pivot = medianOfThree(A, low, high); // store the pivot from medianOfTree
    	dataMoves++;
    	
    	int left = low + 1;		// item just after the low
    	int right = high - 2;	// item before the pivot
    	while (left <= right) {
    		// increment left until an item not less than pivot
    		while (A[left].compareTo(pivot) < 0) {
    			left++;
    		}
    		
    		// decrement right until an item not greater than pivot
    		while (A[right].compareTo(pivot) > 0) {
    			right--;
    		}
    		
    		// as long as left and right index still haven't crossed, swap
    		if (left <= right) {
    			E tmp = A[left];
    			dataMoves++;
    			A[left] = A[right];
    			dataMoves++;
    			A[right] = tmp;
    			dataMoves++;
    			left++;
    			right--;
    		}
    	}
    	
    	// swap the lowest item in the right portion with the pivot
    	E tmp = A[right + 1];
    	dataMoves++;
    	A[right + 1] = A[high - 1];
    	dataMoves++;
    	A[high - 1] = tmp;
    	dataMoves++;
    	
    	return right;
    	
    }// end of partition
    
    private static <E extends Comparable<E>> E medianOfThree (E[] A, int low, int high) {
    	int minIndex = low; // index of smallest
    	int medianIndex = (low + high) / 2;
    	int maxIndex = high;
    	
    	// swap if current min > current median
    	if(A[minIndex].compareTo(A[medianIndex]) > 0) {
    		int tmp = medianIndex;
    		medianIndex = minIndex;
    		minIndex = tmp;
    	}
    	
    	// swap if current median greater than current max
    	if(A[medianIndex].compareTo(A[maxIndex]) > 0) {
    		int tmp = medianIndex;
    		medianIndex = maxIndex;
    		maxIndex = tmp;
    	}
    	
    	// swap if current min > current max
    	if(A[minIndex].compareTo(A[maxIndex]) > 0) {
    		int tmp = minIndex;
    		minIndex = maxIndex;
    		maxIndex = tmp;
    	}
    	
    	// put everything in the right place
    	E min = A[minIndex];
    	dataMoves++;
    	E median = A[medianIndex];
    	dataMoves++;
    	E max = A[maxIndex];
    	dataMoves++;
    	
    	A[low] = min;
    	dataMoves++;
    	A[high] = max;
    	dataMoves++;
    	A[(low + high) / 2] = A[high - 1];
    	dataMoves++;
    	A[high - 1] = median;
    	dataMoves++;
    	
    	return A[high - 1];
    }

    /**
     * Sorts the given array using the heap sort algorithm outlined below. Note:
     * after this method finishes the array is in sorted order.
     * <p>
     * The heap sort algorithm is:
     * </p>
     * 
     * <pre>
     * for each i from 1 to the end of the array
     *     insert A[i] into the heap (contained in A[0]...A[i-1])
     *     
     * for each i from the end of the array up to 1
     *     remove the max element from the heap and put it in A[i]
     * </pre>
     * 
     * @param <E>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <E extends Comparable<E>> void heapSort(E[] A) {
        // TODO: implement this sorting algorithm
    	if ( A == null) {
    		NullPointerException();
    	}
    	
    	// create the heap;
    	// for 1 to end of array: compare child with their parent. if child is
    	// greater than parent, swap and continue upwards comparing to next p.
    	
    	for (int i = 1; i < A.length; ++i) {
    		int parentIndex = ( i - 1) / 2; 
    		int childIndex = i;
    		while ( childIndex > 0 && A[childIndex].compareTo(A[parentIndex]) > 0) {
    			E tmp = A[childIndex];
    			dataMoves++;
    			A[childIndex] = A[parentIndex];
    			dataMoves++;
    			A[parentIndex] = tmp;
    			dataMoves++;
    			childIndex = parentIndex;
    			parentIndex = (parentIndex - 1) / 2;
    			
    		}
    	}
    	
    	// sort from the heap;
    	// start removing the max, swapping it with the last unsorted item
    	// index i. reorder the heap as necessary.
    
    	for ( int i = A.length - 1; i > 0; --i ) {
    		E tmp = A[i];
    		dataMoves++;
    		A[i] = A[0];
    		dataMoves++;
    		A[0] = tmp;
    		dataMoves++;
    		
    		int currentIndex = 0;			// index of the item to reorder
    		boolean ordered = false; 		//whether the heap is ordered
    		while(!ordered) {
    			// nochildren
    			if ((currentIndex * 2) + 1 > i - 1) {
    				ordered = true;
    			} else if (( currentIndex * 2) + 2 > i - 1){
    				// one child
    				if ( A[currentIndex].compareTo(A[currentIndex * 2 + 1]) < 0) {
    					E parent = A[currentIndex];
    					dataMoves++;
    					A[currentIndex] = A[currentIndex * 2 + 1];
    					dataMoves++;
    					A[currentIndex * 2 + 1] = parent;
    					dataMoves++;
    					currentIndex = (currentIndex * 2) + 1;
    				}else {
        				ordered = true;
    				} 
    			} else { // two children
    				// find larger children
    				int lgChildIndex; 		// index of larger of the 2 children
    				if (A[currentIndex * 2 + 1].compareTo(A[currentIndex*2 + 2] ) > 0 ) {
    					lgChildIndex = (currentIndex * 2) + 1;
    				} else {
    					lgChildIndex = (currentIndex * 2) + 2;
    				}
    				// swap if less than larger child
    				if (A[currentIndex].compareTo(A[lgChildIndex]) < 0) {
    					E parent = A[currentIndex];
    					dataMoves++;
    					A[currentIndex] = A[lgChildIndex];
    					dataMoves++;
    					A[lgChildIndex] = parent;
    					dataMoves++;
    					currentIndex = lgChildIndex;
    				} else {
    					ordered = true;
    				}
    			}
    			
    			//
    			
    			
    		} // end of while
    	
    	} // end of for
    	
    } // end of heapSort

    /**
     * Sorts the given array using the selection2 sort algorithm outlined
     * below. Note: after this method finishes the array is in sorted order.
     * <p>
     * The selection2 sort is a bi-directional selection sort that sorts
     * the array from the two ends towards the center. The selection2 sort
     * algorithm is:
     * </p>
     * 
     * <pre>
     * begin = 0, end = A.length-1
     * 
     * // At the beginning of every iteration of this loop, we know that the 
     * // elements in A are in their final sorted positions from A[0] to A[begin-1]
     * // and from A[end+1] to the end of A.  That means that A[begin] to A[end] are
     * // still to be sorted.
     * do
     *     use the MinMax algorithm (described below) to find the minimum and maximum 
     *     values between A[begin] and A[end]
     *     
     *     swap the maximum value and A[end]
     *     swap the minimum value and A[begin]
     *     
     *     ++begin, --end
     * until the middle of the array is reached
     * </pre>
     * <p>
     * The MinMax algorithm allows you to find the minimum and maximum of N
     * elements in 3N/2 comparisons (instead of 2N comparisons). The way to do
     * this is to keep the current min and max; then
     * </p>
     * <ul>
     * <li>take two more elements and compare them against each other</li>
     * <li>compare the current max and the larger of the two elements</li>
     * <li>compare the current min and the smaller of the two elements</li>
     * </ul>
     * 
     * @param <E>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <E extends Comparable<E>> void selection2Sort(E[] A) {
        // TODO: implement this sorting algorithm
    }

    
    /**
     * <b>Extra Credit:</b> Sorts the given array using the insertion2 sort 
     * algorithm outlined below.  Note: after this method finishes the array 
     * is in sorted order.
     * <p>
     * The insertion2 sort is a bi-directional insertion sort that sorts the 
     * array from the center out towards the ends.  The insertion2 sort 
     * algorithm is:
     * </p>
     * <pre>
     * precondition: A has an even length
     * left = element immediately to the left of the center of A
     * right = element immediately to the right of the center of A
     * if A[left] > A[right]
     *     swap A[left] and A[right]
     * left--, right++ 
     *  
     * // At the beginning of every iteration of this loop, we know that the elements
     * // in A from A[left+1] to A[right-1] are in relative sorted order.
     * do
     *     if (A[left] > A[right])
     *         swap A[left] and A[right]
     *  
     *     starting with with A[right] and moving to the left, use insertion sort 
     *     algorithm to insert the element at A[right] into the correct location 
     *     between A[left+1] and A[right-1]
     *     
     *     starting with A[left] and moving to the right, use the insertion sort 
     *     algorithm to insert the element at A[left] into the correct location 
     *     between A[left+1] and A[right-1]
     *  
     *     left--, right++
     * until left has gone off the left edge of A and right has gone off the right 
     *       edge of A
     * </pre>
     * <p>
     * This sorting algorithm described above only works on arrays of even 
     * length.  If the array passed in as a parameter is not even, the method 
     * throws an IllegalArgumentException
     * </p>
     *
     * @param  A the array to sort
     * @throws IllegalArgumentException if the length or A is not even
     */    
    public static <E extends Comparable<E>> void insertion2Sort(E[] A) { 
        // TODO: implement this sorting algorithm 
    }

    /**
     * Internal helper for printing rows of the output table.
     * 
     * @param sort          name of the sorting algorithm
     * @param compares      number of comparisons performed during sort
     * @param moves         number of data moves performed during sort
     * @param milliseconds  time taken to sort, in milliseconds
     */
    private static void printStatistics(String sort, int compares, int moves,
                                        long milliseconds) {
        System.out.format("%-23s%,15d%,15d%,15d\n", sort, compares, moves, 
                          milliseconds);
    }

    /**
     * Sorts the given array using the six (seven with the extra credit)
     * different sorting algorithms and prints out statistics. The sorts 
     * performed are:
     * <ul>
     * <li>selection sort</li>
     * <li>insertion sort</li>
     * <li>merge sort</li>
     * <li>quick sort</li>
     * <li>heap sort</li>
     * <li>selection2 sort</li>
     * <li>(extra credit) insertion2 sort</li>
     * </ul>
     * <p>
     * The statistics displayed for each sort are: number of comparisons, 
     * number of data moves, and time (in milliseconds).
     * </p>
     * <p>
     * Note: each sort is given the same array (i.e., in the original order) 
     * and the input array A is not changed by this method.
     * </p>
     * 
     * @param A  the array to sort
     */
    static public void runAllSorts(SortObject[] A) {
        System.out.format("%-23s%15s%15s%15s\n", "algorithm", "data compares", 
                          "data moves", "milliseconds");
        System.out.format("%-23s%15s%15s%15s\n", "---------", "-------------", 
                          "----------", "------------");

        // TODO: run each sort and print statistics about what it did
        int totalDataCompares;      // number of data compares for sort
        int totalDataMoves;         // number of data moves for sort
        long startTime;				// time at start of sort
        long endTime;				// time at end of sort
        long totalTime;				// total time taken for sort
        
        // selection sort
        SortObject[] ssArray = A.clone();	// clone to be sorted
        SortObject.resetCompares();
        dataMoves = 0;
        
        startTime = System.currentTimeMillis();
        selectionSort(ssArray);
        endTime = System.currentTimeMillis();
        
        totalTime = endTime - startTime;
        totalDataCompares = SortObject.getCompares();
        totalDataMoves = dataMoves;
        
        printStatistics("selection", 
      		  totalDataCompares, totalDataMoves, totalTime);
        
        // insertion sort
        SortObject[]  isArray = A.clone();	// clone to be sorted
        SortObject.resetCompares();
        dataMoves = 0;
        
        startTime = System.currentTimeMillis();
        insertionSort(isArray);
        endTime = System.currentTimeMillis();
        
        totalTime = endTime - startTime;
        totalDataCompares = SortObject.getCompares();
        totalDataMoves = dataMoves;
        
        printStatistics("insertion", 
      		  totalDataCompares, totalDataMoves, totalTime);
        
        // merge sort
        SortObject[]  msArray = A.clone();	// clone to be sorted
        SortObject.resetCompares();
        dataMoves = 0;
        
        startTime = System.currentTimeMillis();
        mergeSort(msArray);
        endTime = System.currentTimeMillis();
        
        totalTime = endTime - startTime;
        totalDataCompares = SortObject.getCompares();
        totalDataMoves = dataMoves;
        
        printStatistics("merge", 
      		  totalDataCompares, totalDataMoves, totalTime);
        
        // quick sort
        SortObject[]  qsArray = A.clone();	// clone to be sorted
        SortObject.resetCompares();
        dataMoves = 0;
        
        startTime = System.currentTimeMillis();
        quickSort(qsArray);
        endTime = System.currentTimeMillis();
        
        totalTime = endTime - startTime;
        totalDataCompares = SortObject.getCompares();
        totalDataMoves = dataMoves;
        
        printStatistics("quick", 
      		  totalDataCompares, totalDataMoves, totalTime);
        
        // heap sort
        SortObject[]  hsArray = A.clone();	// clone to be sorted
        SortObject.resetCompares();
        dataMoves = 0;
        
        startTime = System.currentTimeMillis();
        heapSort(hsArray);
        endTime = System.currentTimeMillis();
        
        totalTime = endTime - startTime;
        totalDataCompares = SortObject.getCompares();
        totalDataMoves = dataMoves;
        
        printStatistics("heap",totalDataCompares, totalDataMoves, totalTime);
        
        // selection2 sort
        SortObject[]  ss2Array = A.clone();	// clone to be sorted
        SortObject.resetCompares();
        dataMoves = 0;
        
        startTime = System.currentTimeMillis();
        selection2Sort(ss2Array);
        endTime = System.currentTimeMillis();
        
        totalTime = endTime - startTime;
        totalDataCompares = SortObject.getCompares();
        totalDataMoves = dataMoves;
        
        printStatistics("selection2", 
      		  totalDataCompares, totalDataMoves, totalTime);
        
//        // (extra credit) insertion2 sort
//        SortObject[] is2Array = A.clone();	// clone to be sorted
//        SortObject.resetCompares();
//        dataMoves = 0;
//        
//        startTime = System.currentTimeMillis();
//        insertion2Sort(is2Array);
//        endTime = System.currentTimeMillis();
//        
//        totalTime = endTime - startTime;
//        totalDataCompares = SortObject.getCompares();
//        totalDataMoves = dataMoves;
//        
//        printStatistics("insertion2", 
//      		  totalDataCompares, totalDataMoves, totalTime);
        
        // reset at end of method
        SortObject.resetCompares();
        dataMoves = 0;
    } // end of runAllSort
}