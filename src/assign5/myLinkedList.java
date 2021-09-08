package assign5;

import java.util.LinkedList;

public class myLinkedList<T> extends LinkedList<Object> {
	
	//field
	private int length; // = initSize
	private double ldf;
	private int maxSize;
	private LinkedList<T>[] arr;
	private int size;
	
	
	//constructor
	public myLinkedList(int length, double ldf ) {
		this.length = length;
		this.ldf = ldf;
		this.maxSize = (int) ((int)length*ldf);
		this.arr = new LinkedList[length];
		int i = 0;
		while( i < length) {
			arr[i] = new LinkedList<T>();
		}
		
	}
	
	
	//method
	private int hashCode(int value, int length) {
		int res;
		res = value%length;
		
		return res;
	}
	
}
