class ListNode
{
	BookInfo data;
	ListNode nextNode;

	ListNode(BookInfo Book)
	{
		this(Book, null );
	} 
	
	ListNode( BookInfo Book, ListNode node )
	{
		data = Book;
		nextNode = node;
	}

	BookInfo getData()
	
	{
		return data; 
	}

	ListNode getNext()
	{
		return nextNode; 
	} 
} 