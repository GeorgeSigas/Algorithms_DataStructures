import java.io.PrintStream;

public class DNAPalindrome
{
	public static void main(String args[]) throws java.io.IOException
	{
		CharDoubleEndedQueueImpl DNA = new CharDoubleEndedQueueImpl();
		int ch;
		char letter='0';
		String sequenceGiven="";
		String sequenceReversed="";
		PrintStream ps= new PrintStream(System.out);
		
		System.out.print("Enter DNA sequence: ");
		while((ch=System.in.read())!='\n')
		{
			letter=(char)ch;
			if(letter=='A' || letter=='T' || letter=='C' || letter=='G')
			{
				sequenceGiven+=letter;
				if(letter=='A')
				{
					letter='T';
				}
				else if(letter=='T')
				{
					letter='A';
				}
				else if(letter=='G') 
				{
					letter='C';
				}
				else
				{
					letter='G';
				}
				DNA.addFirst(letter);
			}
			else
			{
					System.out.println("Invalid character");
					break;
			}
		}
		while(!DNA.isEmpty())
		{
			sequenceReversed+=DNA.getFirst();
			DNA.removeFirst();
		}
		if(sequenceGiven.equals(sequenceReversed))
		{
			System.out.print("This sequence is Watson-Crick complemented palindrome" );
		}
		else
		{
			System.out.print("Wrong Sequence!");
		}
		
	}
	
}