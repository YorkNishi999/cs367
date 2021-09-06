package prog1;

public class DLinkedList<E> implements ListADT<E>{
	
	// field
	private DblListnode<E> head, tail;
	private int numItem;
	
	// constructor
	public DLinkedList() {
		head = new DblListnode<E>(null);
		tail = head;
		numItem = 0;
	}
	
	
//	private int nth(DblListnode item) {
//		
//		int counter = 0;
//		
//		if (item.getPrev() == null) {
//			return counter;
//		} else {
//			while (item.getNext() == null) {
//				counter++;
//			}
//			return counter;
//		}	
//	} // 


		@Override
		public void add(E item) {
			// TODO Auto-generated method stub
			if (item == null)
				throw new IllegalArgumentException();
		
			DblListnode<E> n = new DblListnode(item);
			tail.setNext(n);
			n.setPrev(tail);
			tail = n;
			numItem++;
		}
		
		


		@Override
		public void add(int pos, E item) {
			// TODO Auto-generated method stub
			
			if (item == null)
				throw new IllegalArgumentException();
			
			DblListnode<E> n = new DblListnode(item);
			DblListnode<E> index = head;
			
			for (int i = 0; i < pos; ++i) {
				index = index.getNext();
			}
			
			index.setNext(n);
			n.setPrev(index);
			numItem++;
			
		}


		@Override
		public boolean contains(E item) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E get(int pos) {
			// TODO Auto-generated method stub
			return null;
		}

		

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public E remove(int pos) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}




}  // end of class
