

import java.io.PrintStream;
import java.util.NoSuchElementException;

/** * Defines the methods for a Double-ended Queue that handles characters */public interface CharDoubleEndedQueue<T> {	/**	 * @return true if the queue is empty	 */	public boolean isEmpty();	/**	 * insert a character at the front of the queue	 */	public void addFirst(T item);	/**	 * remove and return a character from the front of the queue
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty	 */	public T removeFirst() throws NoSuchElementException;	/**	 * insert a character at the end of the queue	 */	public void addLast(T item);	/**	 * remove and return a character from the end of the queue
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty	 */	public T removeLast() throws NoSuchElementException;		/**	 * return without removing the first item in the queue
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty	 */	public T getFirst();	/**	 * return without removing the last item in the queue
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty	 */	public T getLast();			/**	 * print the elements of the queue, starting from the front,      	 * to the print stream given as argument. For example, to          * print the elements to the	 * standard output, pass System.out as parameter. E.g.,	 * printQueue(System.out);	 */	public void printQueue(PrintStream stream);	/**	 * return the size of the queue, 0 if empty
	 * @return number of elements in the queue	 */	public int size();}