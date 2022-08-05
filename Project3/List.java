public class List {
	private ListNode firstNode;
	private ListNode lastNode;

	
	public List()
	{
		firstNode = lastNode = null;
	}
	
	public void insert(BookInfo insertItem)
	{
		
		ListNode node=firstNode;
		if(firstNode==null || insertItem.getISBN()<firstNode.getData().getISBN())
		{
			insertAtFront(insertItem);
		}
		else
		{
			ListNode previous=firstNode;
			node=firstNode.getNext();
			while(node!=null&&insertItem.getISBN()>node.getData().getISBN())
			{
				previous=node;
				node=node.getNext();
			}
			if(node==null){insertAtBack(insertItem);}
			previous.nextNode=new ListNode(insertItem,node);
			
			
		}
	}

	public void insertAtFront(BookInfo insertItem) {
		ListNode node = new ListNode(insertItem);
		if (isEmpty())
			firstNode = lastNode = node;
		else { 
			node.nextNode = firstNode;
			firstNode = node;
		}
	}

	public void insertAtBack(BookInfo insertItem) {
		ListNode node = new ListNode(insertItem);
		if (isEmpty()) 
			firstNode = lastNode = node;
		else { 
			lastNode.nextNode = node;
			lastNode = node;
		}
	}

	public boolean contains(int data) {
		if (isEmpty()) {
			return false;
		}
		
		ListNode cursor = firstNode;
		boolean found = false;
		while(cursor != null){
			if(cursor.getData().getISBN()==data){
				found = true;
				break;
			}else{
				cursor = cursor.nextNode;
			}
		}
		
		return found;
	}

	public boolean remove(int data) {
		if(isEmpty()){
			return false;
		}
		
		ListNode cursor = firstNode;
		ListNode previous = null;
		while(cursor != null){
			if(cursor.getData().getISBN()==data)
			{
				break;
			}
			previous = cursor;
			cursor = cursor.nextNode;
		}
		if(cursor == null)
		{
			return false;
		}
		if(cursor == firstNode)
		{
			removeFromFront();
		}
		else if(cursor == lastNode)
		{
			removeFromBack();
		}
		else
		{
			previous.nextNode = cursor.nextNode;
		}
		return true;
	}

	public BookInfo removeFromFront() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException();

		BookInfo removedItem = firstNode.data;
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;

		return removedItem;
	}
	public BookInfo removeFromBack() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException();

		BookInfo removedItem = lastNode.data;
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
		{
			ListNode current = firstNode;

			
			while (current.nextNode != lastNode)
				current = current.nextNode;

			lastNode = current; 
			current.nextNode = null;
		}

		return removedItem; 
	}
	
	public void update(int isbn,int copies)
	{
		ListNode cursor=firstNode;
		boolean updated=false;
		while(cursor!=null && (!updated))
		{
			if(cursor.getData().getISBN()==isbn) 
			{
				cursor.getData().setBooks(cursor.getData().getBooks()+copies);
				updated=true;
				if(cursor.getData().getBooks()==0)
				{
					remove(isbn);
				}
			}
		}
		cursor=cursor.getNext();	
	}
	
	public void getBookInfo(int data)
	{
		if (isEmpty()) 
		{
			System.out.print(",does not have this book.\n");
			return;
		}
		
		ListNode cursor = firstNode;
		boolean found = false;
		while(cursor != null)
		{
			if(cursor.getData().getISBN()==data)
			{
				found = true;
				break;
			}
			else
			{
				cursor = cursor.nextNode;
			}
		}
		if(found)
		{
			System.out.print(", copies: "+cursor.getData().getBooks()+"\n");
		}
		else
		{
			System.out.print(",does not have this book.\n");
		}
	}

	public boolean isEmpty() {
		return firstNode == null; 
	}

	public String toString() 
	{
		String s="";
		if (isEmpty()) {
			s="No Books found!\n\n";
			return s;
		}
		ListNode current = firstNode;
		while (current != null) {
			s+="Book "+current.getData().getISBN()+", Copies:"+current.getData().getBooks()+"\n";
			current = current.nextNode;
		}
		s+="\n";
		return s;
	}
}
