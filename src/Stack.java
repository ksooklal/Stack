public class Stack<T extends Comparable<T>>{
	private Node<T> head;
	private Node<T> minStack;
	private int size;
	private Node<T> maxStack;
	
	private static class Node<T extends Comparable<T>>{
		private Node<T> next;
		private T data;

		private Node(T data){
			this.data = data;
		}
	}

	public T getMinimum(){
		return (minStack == null) ? null : minStack.data;
	}
	
	public T getMaximum(){
		return (maxStack == null) ? null : maxStack.data;
	}

	public T peek(){
		return (this.head == null) ? null : this.head.data;
	}

	public boolean isEmpty(){
		return size == 0;
	}
	
	public T push(T data){
		if (data == null)
			throw new NullPointerException("No Null Elements allowed");
		Node<T> newNode = new Node<T>(data);
		Node<T> minNode = new Node<T>(data);
		Node<T> maxNode = new Node<T>(data);
		
		if (this.head == null){
			this.minStack = minNode;
			this.maxStack = maxNode;
		} else {
			newNode.next = this.head;
			if (data.compareTo(this.minStack.data) <= 0){
				minNode.next = this.minStack;
				this.minStack = minNode;
			}
			if (data.compareTo(this.maxStack.data) >= 0){
				maxNode.next = this.maxStack;
				this.maxStack = maxNode;
			}
		} 
		
		size++;
		this.head = newNode;
		return data;
	}

	public int size(){
		return size;
	}

	public T pop(){
		if (this.head == null)
			return null;
		
		T data = this.head.data;
		
		if (data.equals(this.minStack.data))
			this.minStack = this.minStack.next;
		if (data.equals(this.maxStack.data))
			this.maxStack = this.maxStack.next;
		
		this.head = this.head.next;
		size--;
		
		return data;
	}
}