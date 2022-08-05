/**
 * EmptyListException is a simple class that extends RuntimeException. It 
 * is thrown by {@link List} when get methods are called on an empty list. 
 */
public class EmptyListException extends RuntimeException
{

	public EmptyListException()
	{
		super( "List is empty" ); // call superclass constructor
	} 
} 

