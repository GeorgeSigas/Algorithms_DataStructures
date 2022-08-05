import java.util.*;
import java.io.*;

public class Comparisons
{
	public static final int N_1=100;
	public static final int N_2=500;
	public static final int N_3=1000;
	
	public static void main (String args[])
	{
		//Creates Random txt files for each N
		Greedy G=new Greedy();
		//Randomize(N_1);
		//Randomize(N_2);
		//Randomize(N_3);
		
		String f_n; // The name of each file used
		
		//One Array for each N using Greedy algorithm
		int[] MakespanN_1G = new int[10];
		int[] MakespanN_2G = new int[10];
		int[] MakespanN_3G = new int[10];
		
		//One Array for each N using Greedy-Decreasing algorithm
		int[] MakespanN_1GDCR = new int[10];
		int[] MakespanN_2GDCR = new int[10];
		int[] MakespanN_3GDCR = new int[10];
		
		
		//Calling Greedy and Greedy-Decreasing algorithms for N_1, N_2, N_3 processes
		
		for(int c=1;c<=10;c++)
		{
			f_n=("data/Input_"+N_1+"_"+c+".txt");
			MakespanN_1G[c-1]=G.GreedyRun(f_n,false);
			MakespanN_1GDCR[c-1]=G.GreedyRun(f_n,true);
			
		}
		
		for(int c=1;c<=10;c++)
		{
			f_n=("data/Input_"+N_2+"_"+c+".txt");
			MakespanN_2G[c-1]=G.GreedyRun(f_n,false);
			MakespanN_2GDCR[c-1]=G.GreedyRun(f_n,true);
		}
		
		for(int c=1;c<=10;c++)
		{
			f_n=("data/Input_"+N_3+"_"+c+".txt");
			MakespanN_3G[c-1]=G.GreedyRun(f_n,false);
			MakespanN_3GDCR[c-1]=G.GreedyRun(f_n,true);
		}
		
		
		//Calculating and printing Average makespans for each algorithm and for all N's
		
		System.out.println("\n"+"========== Average Makespans =========="+"\n"+"\n");
		
		System.out.println("For "+N_1+" Processes: ");
		System.out.println("\t"+"Greedy Algorithm: "+Average(MakespanN_1G));
		System.out.println("\t"+"Greedy-Decreasing Algorithm: "+Average(MakespanN_1GDCR));
		System.out.println();
		System.out.println("For "+N_2+" Processes: ");
		System.out.println("\t"+"Greedy Algorithm: "+Average(MakespanN_2G));
		System.out.println("\t"+"Greedy-Decreasing Algorithm: "+Average(MakespanN_2GDCR));
		System.out.println();
		System.out.println("For "+N_3+" Processes: ");
		System.out.println("\t"+"Greedy Algorithm: "+Average(MakespanN_3G));
		System.out.println("\t"+"Greedy-Decreasing Algorithm: "+Average(MakespanN_3GDCR));
	}
	
	
	//Creates 10 files with random Processing times for the number of Processes given
	/*private static void Randomize(int N) //N=number of Processes
	{
		Random rand = new Random();
		
		int M = (int)Math.sqrt(N); //M= number of Processors
		
		int counter=1;
		
		for (int i=0;i<10;i++) //Create 10 files for each N
		{
			//Write file
			
			File f = null;
			BufferedWriter W = null;
			String newline = System.getProperty("line.separator");
			String filename="Input_" + N + "_" + counter + ".txt";
			
			try
			{
				f=new File("Inputs/"+filename);
				counter++;
			}
			catch(NullPointerException e) 
			{
				System.err.println ("Error creating file.");
			}
			
			try
			{
				W = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
			}
			catch (FileNotFoundException e) 
			{
				System.err.println("Error opening file for writing!");
			}
			try
			{
				W.write(String.valueOf(M) + newline + String.valueOf(N) + newline); //First 2 lines
				
				for (int j=0;j<N;j++) //Add random proc times to file (1 per line)
				{
					W.write(String.valueOf( rand.nextInt(100)+1 ) + newline); 
				}
			}
			catch (IOException e)
			{
				System.err.println("Write error!");
			}
			try 
			{
				W.close();
			}
			catch (IOException e)
			{
				System.err.println("Error closing file.");
			}
		}
	}*/
	
	
	//Calculates the Average of an int array
	private static double Average(int[] arr)
	{
		int L=arr.length;
		int sum=0;
		for(int i=0;i<L;i++)
		{
			sum+=arr[i];
		}
			return sum/L;
	}	
	
}