class Node<T>
{
	 Node<T> next;
	 Node<T> previous; 
	T Data;
	
	public Node(T Data, Node next, Node previous)
	{
		this.Data=Data;
		this.next=next;
		this.previous=previous;
	}
	
	public void setData(T Data)
	{
		this.Data=Data;
	}
	
	public void setNext(Node<T> next)
	{
		this.next=next;
	}

    public void setPrevious(Node<T> Previous)
    { 
	    this.previous=previous;
	}
	
	public T getData (){
		return this.Data;
	}
    
    public Node<T> getNext(){
        return this.next;
    }

    public Node<T> getPrevious(){
        return this.previous;
    }
}
	
		