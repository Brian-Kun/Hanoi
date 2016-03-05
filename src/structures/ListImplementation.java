package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T>{
	
	private Node<T> head;
	private Node<T> tail;
	
	int size = 0;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public T get(int n) throws NoSuchElementException {		
		Node<T> currNode = head;
		if(n > size-1 || n < 0){
			throw new NoSuchElementException();
		}
		int counter = 0;
		while(counter < n && currNode != null){
			currNode = currNode.getNext();
			counter++;
		}
			
		if(currNode == null) return null;
		return currNode.getData();
	}

	@Override
	public ListInterface<T> append(Object elem) {
		
		if(elem == null)
			throw new NullPointerException();

		@SuppressWarnings("unchecked")
		Node<T> newNode = new Node<T>((T)elem,null);
		if(tail == null){
			head = newNode;
		}else{
			tail.setNext(newNode);
		}
		tail = newNode;
		size++;
		return this;
	}
	



	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(head);
	}
	
	public String toString(){
		
		String answer = "";
		
		Node<T> curr = head;
		while(curr != null){
			answer += curr.getData() + " ";
			curr = curr.getNext();
		}
		return answer;
		
	}

}
