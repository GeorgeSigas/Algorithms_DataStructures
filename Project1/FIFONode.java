class FIFONode <T>
{
	T data;
	FIFONode<T> next;
	
	FIFONode(T c)
	{
		this(c, null);
	}
	
	FIFONode(T data, FIFONode<T> next)
	{
		this.data=data;
		this.next=next;
	}
	
	T getData()
	{
		return data;
	}
	
	FIFONode<T> getNext()
	{
		return next;
	}
	
	
}