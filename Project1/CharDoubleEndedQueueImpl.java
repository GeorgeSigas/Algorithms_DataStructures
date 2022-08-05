import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
	
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int size = 0;
	public CharDoubleEndedQueueImpl()
	{
			firstNode=null;
			lastNode=null;
	}
	
	
	/**
	public boolean isEmpty()
	{
		return firstNode == null;
	}
	
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
	}
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty
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
		
	
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty
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
	}
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty
	{
		{
			return firstNode.getData();
		}
		else
		{
			throw new NoSuchElementException();
		}
	}
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty
	{
		if (!isEmpty())
		{
			return lastNode.getData();
		}
		else
		{
			throw new NoSuchElementException();
		}
	}
	{
		Node <T> node=firstNode;
		while(node!=null)
		{
			stream.println(node.getData());
			stream.flush();
			node=node.next;
		}
		
	}
	 * @return number of elements in the queue
	{
		return size;
	}