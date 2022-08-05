public class MaxPQ
{
	private Processor[] heap;
	private int size;
	Sort s=new Sort();
	
	public MaxPQ(int capacity)
	{
		if (capacity < 1) throw new IllegalArgumentException();
        this.heap = new Processor[capacity+1];
        this.size = 0;
	}
	
	public void insert(Processor P)
	{
		if (P==null) throw new IllegalArgumentException();
		if(size==(heap.length)-1) throw new IllegalStateException();
		heap[++size]=P;
		swim(size);
	}
	
	public Processor getMax()
	{
        if (size == 0) throw new IllegalStateException();
        Processor P = heap[1];
        if (size > 1) heap[1] = heap[size];
        heap[size--] = null;
        sink(1);
        return P;
	}
	
	public int getMakespan()
	{
		return heap[size].getActiveTime();
	}
	
	private void swim(int i) 
	{
        while (i > 1)
		{
            int p = i/2;
            int result = heap[i].compareTo(heap[p]);
            if (result >= 0) return;
            swap(i, p);
            i = p;
        }
    }
	
	private void sink(int i)
	{
        int left = 2*i, right = left+1, max = left;
        while (left <= size)
		{
            if (right <= size)
			{
                max = heap[left].compareTo(heap[right]) < 0 ? left : right;
            }
            if (heap[i].compareTo(heap[max]) <= 0) return;
            swap(i, max);
            i = max;
			left = 2*i;
			right = left+1;
			max = left;
        }
    }
	
	private void swap(int i, int j) {
        Processor tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
		
	public void print(int num)
	{
		if (num<100)
		{
			for (int i=1; i<=size; i++)
			{
				System.out.print("ID: "+heap[i].getID()+ ", Load="+heap[i].getActiveTime()+": ");
				heap[i].printProcesses();
				System.out.println();
			}
		}
	}
	
	boolean empty(){
        return size == 0;
    }		
}