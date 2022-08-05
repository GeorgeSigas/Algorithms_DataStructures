class Node
{
	BookInfo data;
	Node next;
	
	Node(BookInfo c)
	{
		this(c, null);
	}
	
	Node(BookInfo data, Node next)
	{
		this.data=data;
		this.next=next;
	}
	
	BookInfo getData()
	{
		return data;
	}
	
	Node getNext()
	{
		return next;
	}
	void setNext(Node NewNext)
	{
		this.next=NewNext;
	}	
	
}