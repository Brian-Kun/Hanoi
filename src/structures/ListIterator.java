package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T>{
	
	Node<T> head;
	
	public ListIterator(Node<T> head){
		this.head = new Node<T>(null,head);
	}

	public boolean hasNext() {
		return (head.getNext() != null);
	}

		  @Override
	public T next() {
		if(hasNext()){
		   head = head.getNext();
		   return head.getData();
		}
		   throw new NoSuchElementException();
	}

}
