import java.io.PrintStream;
import java.util.NoSuchElementException;

public class CharQueueImpl<T> implements CharQueue<T>
{
	private FIFONode<T> FirstNode;
	private FIFONode<T> LastNode;
	private int CurrentSize=0;
	
	public CharQueueImpl()
	{
		FirstNode=null;
		LastNode=null;
	}
	
	public void put(T item)
	{
		FIFONode<T> N=new FIFONode<T>(item);
		if(isEmpty())
		{
			FirstNode=N;
			LastNode=N;
		}
		else
		{
			LastNode.next=N;
			LastNode=N;
		}
		CurrentSize++;
	}
	
	public T get() throws NoSuchElementException
	{
		if (isEmpty()) throw new NoSuchElementException();
		T temp=FirstNode.getData();
		FirstNode=FirstNode.getNext();
		CurrentSize--;
		return temp;
	}
	
	public T peek() throws NoSuchElementException
	{
		if (isEmpty()) throw new NoSuchElementException();
		return (T)FirstNode.getData();
	}
	
	public void printQueue(PrintStream stream)
	{
		FIFONode <T> node=FirstNode;
		while(node!=null)
		{
			stream.println(node.getData());
			stream.flush();
			node=node.next;
		}
		
	}
	
	public boolean isEmpty()
	{
		return (CurrentSize==0);
	}
	
	public int size()
	{
		return CurrentSize;
	}
}