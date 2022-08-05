import java.io.PrintStream;
import java.util.NoSuchElementException;

/** * Defines the methods for a Double-ended Queue that handles characters */public class CharDoubleEndedQueueImpl<T> implements CharDoubleEndedQueue<T>{
	
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int size = 0;	
	public CharDoubleEndedQueueImpl()
	{
			firstNode=null;
			lastNode=null;
	}
	
	
	/**	 * @return true if the queue is empty	 */
	public boolean isEmpty()
	{
		return firstNode == null;
	}
		/**	 * insert a character at the front of the queue	 */	public void addFirst(T item)
	{
		size++;
		if(isEmpty())
		{
			firstNode=new Node<T> (item,null,null);
			lastNode=firstNode;
		}
		else
		{
			Node <T> node=new Node<T> (item,firstNode,null);
			this.firstNode.previous=node;
			this.firstNode=node;
		}
	}	/**	 * remove and return a character from the front of the queue
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty	 */	public T removeFirst() throws NoSuchElementException
	{
		T result=null;
		if(!isEmpty())
		{
			size--;
			result=firstNode.Data;
			if(firstNode.next!=null)
			{
				firstNode.next.previous=null;
				firstNode=firstNode.next;
			}
			else
			{
				firstNode=null;
				lastNode=null;
			}
		}
		else
		{
			throw new NoSuchElementException();
		}
		return result;
	}
		/**	 * insert a character at the end of the queue	 */	public void addLast(T item)
	{
		size++;
		if(isEmpty())
		{
			firstNode=new Node<T> (item,null,null);
			lastNode=firstNode;
		}
		else
		{
			Node <T> node=new Node<T> (item,null,lastNode);
			this.lastNode.next=node;
			this.lastNode=node;
		}
	
	}
		
		/**	 * remove and return a character from the end of the queue
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty	 */	public T removeLast() throws NoSuchElementException
	{
		T result=null;
		if(!isEmpty())
		{
			size--;
			result=lastNode.Data;
			if(lastNode.previous!=null) 
			{
				lastNode.previous.next=null;
				lastNode=lastNode.previous;
			}
			else
			{
				firstNode=null;
				lastNode=null;
			}
		}
		else
		{
			throw new NoSuchElementException();
		}
		return result;
	}		/**	 * return without removing the first item in the queue
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty	 */	public T getFirst()
	{		if (!isEmpty())
		{
			return firstNode.getData();
		}
		else
		{
			throw new NoSuchElementException();
		}
	}	/**	 * return without removing the last item in the queue
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty	 */	public T getLast()
	{
		if (!isEmpty())
		{
			return lastNode.getData();
		}
		else
		{
			throw new NoSuchElementException();
		}
	}			/**	 * print the elements of the queue, starting from the front,      	 * to the print stream given as argument. For example, to          * print the elements to the	 * standard output, pass System.out as parameter. E.g.,	 * printQueue(System.out);	 */	public void printQueue(PrintStream stream)
	{
		Node <T> node=firstNode;
		while(node!=null)
		{
			stream.println(node.getData());
			stream.flush();
			node=node.next;
		}
		
	}	/**	 * return the size of the queue, 0 if empty
	 * @return number of elements in the queue	 */	public int size()
	{
		return size;
	}}