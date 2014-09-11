/**
 	* 	@author Kristian Sooklal
	*	<br/><br/>
	*	Implementation of a simple stack data structure in Java with basic
		functionality including push(), pop(), peek(), getMinimum(), 
		getMaximum(), and size(), all of which run in constant time (big O(1) 
		run time).
	*	<br/><br/>
	*	All elements must be non-null, comparable elements in order to provide 
		the functionality of getMinimum() and getMaximum().
	*	<br/><br/>
	*	Elements are inserted and retrieved in a Last In, First Out basis 
		(LIFO), meaning that the element that is most recently inserted will be 
		the element that is first removed.
**/
public class Stack<T extends Comparable<T>>{
	private Node<T> head;
	private Node<T> minStack;
	private long size;
	private Node<T> maxStack;
	
	/** 
	 	@author Kristian Sooklal
	 	<br/><br/>
	 	Implementation of a Node class that holds each individual data item in 
	 	the stack. Holds a copy of the data and a reference to the next data 
	 	item in the stack .
	 **/
	private static class Node<T extends Comparable<T>>{
		private Node<T> next;
		private T data;

		private Node(T data){
			this.data = data;
		}
	}

	/** 
	 * 	Performs a constant time retrieval of the "minimum" element in the 
	 * 	stack, according to the natural order of the element. If the list is 
	 * 	empty, null is returned.
	 * 	<br/><br/>
	 * 	@return minimum element of the stack
	 */
	public T getMinimum(){
		return (minStack == null) ? null : minStack.data;
	}
	
	/** 
	 * 	Performs a constant time retrieval of the "maximum" element in the 
	 * 	stack, according to the natural order of the element. If the list is 
	 * 	empty, null is returned.
	 * 	<br/><br/>
	 * 	@return maximum element of the stack
	 */
	public T getMaximum(){
		return (maxStack == null) ? null : maxStack.data;
	}

	/** 
	 *	Performs a constant time retrieval of the "top" element of the stack,
	 *	meaning the element that was the most recently inserted into the stack.
	 *	Differs from the pop() method in that the peek() method does not change 
	 *	the list or any elements within the list. If the list is empty, null is 
	 *	returned.
	 *	<br/><br/>
	 * 	@return top element of the stack
	 */
	public T peek(){
		return (this.head == null) ? null : this.head.data;
	}

	/** 
	 * 	Performs a constant time check to see if the list has any elements, and 
	 * 	returns true if the list has no elements, false otherwise.
	 * 	<br/><br/>
	 * 	@return true if the list has no elements, false otherwise
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * 	Performs a constant time insertion of a non-null, comparable element 
	 * 	into the stack. Adds the element to the top of the stack according to 
	 *  LIFO principle (Last In, First Out). Updates the size, minimum, and 
	 *  maximum of the stack in constant time as well.
	 * 	@param data - must be an object that implements Comparable<T> in order 
	 * 	to facilitate the functionality of getMinimum() and getMaximum(). 
	 * 	Element to be inserted cannot be null.
	 * 	<br/><br/>
	 * 	@return element that was pushed to the stack
	 *	<br/><br/> 
	 *	@throws NullPointerException if the element passed in is null
	 */
	public T push(T data){
		if (data == null)
			throw new NullPointerException("No Null Elements allowed");
		Node<T> newNode = new Node<T>(data);
		Node<T> minNode = new Node<T>(data);
		Node<T> maxNode = new Node<T>(data);
		
		/* If the stack is empty, the first element becomes the head, the 
		 * minimum, and the maximum. */
		if (this.head == null){
			this.minStack = minNode;
			this.maxStack = maxNode;
		} else {
			/* Otherwise, add the element to the top of the stack and perform
			 * a constant time to update the minimum element stack and/or the 
			 * maximum element stack.
			 */
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

	/** 
	 * 	Returns the number of elements in the stack.
	 * 	<br/><br/>
	 * 	@return size of the list
	 */
	public int size(){
		return (size > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) size;
	}

	/**
	 * 	Performs a constant time removal of the top element of the stack and 
	 * 	then return that top element of the stack. Differs from peek() in that 
	 * 	it removes an element from the list. If the list is empty, null is 
	 * 	returned. Updates the size, minimum, and maximum of the stack in 
	 * 	constant time as well.
	 * 	<br/><br/>
	 * 	@return top element of the stack
	 */
	public T pop(){
		if (this.head == null)
			return null;
		
		T data = this.head.data;
		
		/* Check to see if the element to be removed is a minimum and/or 
		 * maximum element, then remove it if necessary.
		 */
		if (data.equals(this.minStack.data))
			this.minStack = this.minStack.next;
		if (data.equals(this.maxStack.data))
			this.maxStack = this.maxStack.next;
		
		this.head = this.head.next;
		size--;
		
		return data;
	}
}