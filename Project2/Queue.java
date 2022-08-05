import java.util.NoSuchElementException;

public class Queue 
{
	private Node FirstNode;
	private Node LastNode;
	private int CurrentSize=0;
	
	public Queue()
	{
		FirstNode=null;
		LastNode=null;
	}
	
	public void put(int item)
	{
		Node N=new Node(item);
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
	
	public int get() throws NoSuchElementException
	{
		if (isEmpty()) throw new NoSuchElementException();
		int temp=FirstNode.getData();
		FirstNode=FirstNode.getNext();
		CurrentSize--;
		return temp;
	}
	
	public int peek() throws NoSuchElementException
	{
		if (isEmpty()) throw new NoSuchElementException();
		return FirstNode.getData();
	}
	
	public void printQueue()
	{
		Node node=FirstNode;
		while(node!=null)
		{
			System.out.print(node.getData()+" ");
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
	public Node getFirstNode()
	{
		return FirstNode;
	}
}