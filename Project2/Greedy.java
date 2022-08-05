import java.io.*;
import java.util.*;

public class Greedy
{
	static boolean check;
	static boolean checkDouble;
	
	public static void main(String args[])
	{
		Greedy G=new Greedy();
		int Makespan=G.GreedyRun("Input.txt", false);
		if(Makespan!=0) System.out.println("Makespan= "+Makespan);
	}

	public Greedy()
	{}
	
	public int GreedyRun(String filename, boolean sort)
	{
		check=false;
		checkDouble=false;
		int[] InputArray=ReadInput(filename);
		if(!(check || checkDouble))
		{
			int N=InputArray[0];
			int NumOfProc=InputArray[1];
		
		
			int[] Processes=new int[NumOfProc];
		
			MaxPQ PQ = new MaxPQ(N);
		
		
			//Filling PQ with Processors
			for(int i=0;i<N;i++)
			{
				Processor P = new Processor();
				PQ.insert(P);
			}

		
			//Assigning Processes to Processors
			for(int i=0;i<NumOfProc;i++)
			{
				Processes[i]=InputArray[i+2];
			}
		
			if(sort)
			{
				Sort(Processes,NumOfProc);
			}		
		
		
			for(int i=0;i<NumOfProc;i++)
			{
				Processor CurrentP = PQ.getMax();
				CurrentP.addProcess(Processes[i]); //Adds the Process to Processor's Queue
				PQ.insert(CurrentP);
			}
			
			PQ.print(NumOfProc);
			return PQ.getMakespan();
		}
		else
		{
			if(check) System.out.println("Invalid input form! (Empty line or Wrong txt structure)");
			if(checkDouble)System.out.println("Invalid input number!(Double Given as input)");
			
			return 0;
		}
	}
	
	
	public void Sort(int[] Processes, int NumOfProc)
	{
		Sort Qsort=new Sort();
		Qsort.quickSort(Processes,0,NumOfProc-1);
	}
	
	
	//Reads Input.txt and inserts all lines in an array of ints
	public int[] ReadInput(String filename)
	{
		
		File f = null;
		BufferedReader R = null;
		int[] MyArray = new int[0]; //Initializing to empty array

		try 
		{
            f = new File(filename);
        } 
		catch (NullPointerException e)
		{
            System.err.println("File not found.");
        }

        try 
		{
            R = new BufferedReader(new FileReader(f));
        } 
		catch (FileNotFoundException e)
		{
            System.err.println("Error opening file!");
        }
		try
		{
			int LineCounter=0;
			String line=R.readLine();
			int M=0;
			int N;
			while(line != null)
			{
				if(line.indexOf(".")>=0 || !line.matches("[0-9]+"))
				{
					if(line.indexOf(".")>=0) 
					{
						checkDouble=true;
					}
					else
					{
						check=true;
					}
					break;
				}
				if(LineCounter<2)
				{
					//Reading first 2 lines to determine array size
					N = Integer.parseInt(line);//N= Number of Processors
					line=R.readLine();
					M = Integer.parseInt(line);//M= Number of Processes
					MyArray=new int[M+2];
					MyArray[0]=N;
					MyArray[1]=M;
					LineCounter=2;
					line=R.readLine();
				}
				if(LineCounter<M+2)
				{
					//Reading the rest of the lines and adding them to the array	
					MyArray[LineCounter]=Integer.parseInt(line);
					LineCounter++;
					line=R.readLine();
				}
				else
				{
					check=true;
					break;
				}
			}
			if (LineCounter<M+2) check=true;
		}
		catch(IOException e)
		{
			System.out.println("Could not read line.");
		}
		try 
		{
           R.close();
		}
		catch (IOException e) 
		{
			System.err.println("Error closing file.");
        }

		return MyArray;
	
	}
}