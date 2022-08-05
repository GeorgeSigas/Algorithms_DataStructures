class Node
{
	int data;
	Node next;
	
	Node(int c)
	{
		this(c, null);
	}
	
	Node(int data, Node next)
	{
		this.data=data;
		this.next=next;
	}
	
	int getData()
	{
		return data;
	}
	
	Node getNext()
	{
		return next;
	}
	
	
}