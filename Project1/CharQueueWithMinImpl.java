import java.io.PrintStream;
import java.util.NoSuchElementException;

public class CharQueueWithMinImpl<T extends Comparable<T>> implements CharQueueWithMin<T>
{
	private CharQueueImpl<T> F;
	private CharDoubleEndedQueueImpl<T> D;
	
	public CharQueueWithMinImpl()
	{
		F = new CharQueueImpl();
		D = new CharDoubleEndedQueueImpl();
	}
	
	public void put(T item)
	{
		if(F.isEmpty())
		{
			F.put(item);
			D.addFirst(item);
		}
		else
		{
			F.put(item);
			while(item.compareTo(D.getFirst())<0)
			{
				D.removeFirst();
				if(D.isEmpty())
				{
					break;
				}
			}
			D.addFirst(item);
		}
	}
	
	public T get() throws NoSuchElementException
	{
		if (F.isEmpty()) throw new NoSuchElementException();
		if(F.peek()==D.getLast())
		{
			D.removeLast();
		}
		return F.get();
		
	}
	
	public T peek() throws NoSuchElementException
	{
		return F.peek();
	}
	
	public void printQueue(PrintStream stream)
	{
		F.printQueue(stream);
		
	}
	
	public boolean isEmpty()
	{
		return F.isEmpty();
	}
	
	public int size()
	{
		return F.size();
	}
	
	public T min()
	{
		return D.getLast();
	}
}