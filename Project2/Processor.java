public class Processor implements Comparable<Processor>
{
	static int idcounter=0;
	private int id;
	private Queue processed_jobs;
	
	public Processor()
	{
		idcounter++;
		id=idcounter;
		this.processed_jobs=new Queue();	
	}
	
	public int getActiveTime()
	{
		int sum=0;
		if(!(processed_jobs.isEmpty()))
		{
			Node node=processed_jobs.getFirstNode();
			while(node!=null)
			{
				sum+=node.getData();
				node=node.next;
			}
		}
		return sum;
	}
	
	public void addProcess(int process_time)
	{
		processed_jobs.put(process_time);
	}
	
	public void printProcesses()
	{
		processed_jobs.printQueue();
	}
	
	public int compareTo(Processor other)
	{
		return Integer.compare(this.getActiveTime(),other.getActiveTime());
	}
	
	public int getID()
	{
		return id;
	}
	
}