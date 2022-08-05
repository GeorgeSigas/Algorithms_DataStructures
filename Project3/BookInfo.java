class BookInfo
{
	private int ISBN,Books_num;
	
	BookInfo(int ISBN,int Books_num)
	{
		this.ISBN=ISBN;
		this.Books_num=Books_num;
	}
	
	public int getISBN()
	{
		return this.ISBN;
	}
	
	public int getBooks()
	{
		return this.Books_num;
	}
	
	public void setBooks(int Books_num)
	{
		this.Books_num=Books_num;
	}
} 