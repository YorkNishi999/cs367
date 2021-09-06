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
			if (item == null)
				throw new IllegalArgumentException();
			
			DblListnode<E> n = new DblListnode(item);
			DblListnode<E> index = head;
			
			for (int i = 0; i < numItem; ++i) {
				index = index.getNext();
				if (index.getData().equals(n.getData())) {
					return true;
				}
			}
			return false;
		} // end of contains

		@Override
		public E get(int pos) {
			// TODO Auto-generated method stub
			DblListnode<E> index = head;
			
			if (pos > numItem || pos < 0) {
				return null;
			}
			
			for (int i = 0; i <= pos; ++i) {
				index = index.getNext();
			}
			return (E) index;
		}


		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			if (numItem > 0) 
				return true;
			else 
				return false;
		}


		@Override
		public E remove(int pos) {
			
			DblListnode<E> index = head;

			// TODO Auto-generated method stub
			for (int i = 0; i < pos; ++i) {
				index = index.getNext();
			}
			DblListnode<E> prevIndex = index.getPrev();
			DblListnode<E> nextIndex = index.getNext();
			
			prevIndex.setNext(nextIndex);
			nextIndex.setPrev(prevIndex);
			numItem--;
			
			return index.getData();		
			
		}


		@Override
		public int size() {
			// TODO Auto-generated method stub
			return numItem;
		}




}  // end of class
