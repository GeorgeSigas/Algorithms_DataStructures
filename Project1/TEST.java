

public class TEST
{
	public static void main(String args[]) throws java.io.IOException
	{
		CharQueueWithMinImpl Temp= new CharQueueWithMinImpl();
		Temp.put("Antwnis");
		Temp.put("Kwstas");
		Temp.put("Baggelis");
		Temp.put("Giwrgos");
		Temp.get();
		System.out.print(Temp.min());
		
	}
}