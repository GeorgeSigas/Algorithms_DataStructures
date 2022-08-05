import java.io.*;
class ST
{
	private class TreeNode
	{
		int id;
		String city;
		TreeNode p;
		TreeNode l;
		TreeNode r;
		int N;
		List Booklist;
		TreeNode(int id,String city)
		{
			this.id=id;
			this.city=city;
			Booklist=new List();
			p=null;
			l=null;
			r=null;
			N=1;
		}
		int key(){return this.id;}
	}
	public static int counter=0;
	private TreeNode head;
	
	ST(){}
	
	void insertWarehouse(int nodeid, String name)
	{
		TreeNode New_Node=new TreeNode(nodeid,name);
		insert(New_Node);
	}
	
	void insertBookAtWarehouse(int nodeid,int isbn,int copies)
	{
		TreeNode Node=searchR(head,nodeid);
		if(Node==null)
		{
			System.out.println("Warehouse "+nodeid+" not found!\n");
		}
		else
		{
			if(Node.Booklist.contains(isbn))
			{
				Node.Booklist.update(isbn,copies);
			}
			else
			{
				BookInfo Book =new BookInfo(isbn,copies);
				Node.Booklist.insert(Book);
			}
		}
	}
	
	void removeWarehouse(int ID)
	{
		if(searchR(head,ID)!=null)
		{
			head=removeR(head,ID);
		}
		else 
		{
			System.out.println("No Warehouse found!");
		}
	}
	
	void removeBook(int nodeid, int isbn)
	{
		TreeNode Node=searchR(head,nodeid);
		if(Node==null)
		{
			System.out.println("No warehouse found!\n");
		}
		else
		{
			if(Node.Booklist.contains(isbn))
			{
				Node.Booklist.update(isbn,-1);
			}
			else
			{
				System.out.println("No Books with the given ISBN found\n");
			}
			
		}
	}
	
	void searchByWarehouse(int nodeid)
	{
		TreeNode Node=searchR(head,nodeid);
		if(Node==null)
		{
			System.out.println("No warehouse found!");
		}
		else
		{
			System.out.println("Warehouse "+Node.key()+" located in "+Node.city+":\n");
			System.out.println(Node.Booklist.toString());
		}
	}
	void searchBookInWarehouse(int nodeid, int isbn)
	{
		TreeNode Node=searchR(head,nodeid);
		if(Node!=null)
		{
			if(counter==0&&Node.Booklist.contains(isbn))System.out.print("The book is available at\n");
			System.out.print("Warehouse "+Node.key()+" located in "+Node.city);
			Node.Booklist.getBookInfo(isbn);
		}
		else
		{
			System.out.println("There is no Warehouse with this Id!");
		}
		counter++;
		
	}
	void searchBook(int isbn)
	{
		counter=0;
		searchBookR(head,isbn);
		if(counter==0)
		{
			System.out.print("There are no copies of this Book\n");
		}
		else 
		{
			counter=0;
			System.out.println();
		}
		
		
	}
	void printΤree(PrintStream stream)
	{
		stream.println(toString());
	}
	
	private void searchBookR(TreeNode h,int isbn)
	{
		if (h == null) return ;
		searchBookR(h.l,isbn);
		if(h.Booklist.contains(isbn))searchBookInWarehouse(h.key(), isbn);
		searchBookR(h.r,isbn);
        return;
	}
	
	void insert(TreeNode Node)
	{
		if(searchR(head,Node.key())!=null)
		{
			System.out.println("This Id already exists!");
			return;
		}
		head = insertR(head,Node);
		head.N=countR(head);
	}
	
	private TreeNode insertR(TreeNode h, TreeNode NewNode)
	{
		if(h==null)return NewNode;
		if(Math.random()*(h.N+1)<1.0)return insertT(h,NewNode,null);
		if(NewNode.key()<h.key())
		{
			h.l=insertR(h.l,NewNode);
		}
		else
		{
			h.r=insertR(h.r,NewNode);
		}
		h.N++;
		return h;
	}
	
	private TreeNode insertT(TreeNode h, TreeNode NewNode, TreeNode parent)
	{
		if(h==null)
		{
			NewNode.p=parent;
			return NewNode;
		}
		if(NewNode.key()==h.key())
		{
			System.out.print("ERROR!\n");
			return null;
		}
		if(NewNode.key()<h.key())
		{
			h.l=insertT(h.l,NewNode,h);
			h= rotateR(h);
		}
		else
		{
			h.r=insertT(h.r,NewNode,h);
			h=rotateL(h);
		}
		return h;
	}
	
	private TreeNode rotateL(TreeNode pivot) {
        TreeNode parent = pivot.p;
        TreeNode child = pivot.r;
        if (parent == null) {
            head = child;
        } else if (parent.l == pivot) {
            parent.l = child;
        } else {
            parent.r = child;
        }
        child.p = pivot.p;
        pivot.p = child;
        pivot.r = child.l;
        if (child.l != null) child.l.p = pivot;
        child.l = pivot;
        return child;
    }
	
	private TreeNode rotateR(TreeNode pivot) {
        TreeNode parent = pivot.p;
        TreeNode child = pivot.l;
        if (parent == null) {
            head = child;
        } else if (parent.l == pivot) {
            parent.l = child;
        } else {
            parent.r = child;
        }
        child.p = pivot.p;
        pivot.p = child;
        pivot.l = child.r;
        if (child.r != null) child.r.p = pivot;
        child.r = pivot;
        return child;
    }
	
	private TreeNode removeR(TreeNode h,int ID)
	{
		if(h==null)return null;
		int current=h.key();
		if(ID<current)h.l=removeR(h.l,ID);
		if(ID>current)h.r=removeR(h.r,ID);
		if(ID==current)h=joinLR(h.l,h.r);
		return h;
	}
	
	private TreeNode joinLR(TreeNode a,TreeNode b)
	{
		if(a==null)return b;
		if(b==null)return a;
		a.N=countR(a);
		b.N=countR(b);
		int Num=a.N+b.N;
		if(Math.random()*Num<1.0*a.N)
		{
			a.r=joinLR(a.r,b);
			return a;
		}
		else
		{
			b.l=joinLR(a,b.l);
			return b;

		}
	}
	
	private TreeNode searchR(TreeNode h,int key)
	{
		if(h==null)return null;
		if(key==h.key())return h;
		if(key<h.key())
		{
			return searchR(h.l,key);
		}
		else
		{
			return searchR(h.r,key);
		}
	}
	
	int countR(TreeNode h)
	{
		if(h==null)return 0;
		return 1 + countR(h.l)+countR(h.r);		
	}
	
	public String toString()
	{
		if(head==null)return"There are no Warehouses!";
        return toStringR(head);
    }    
	
	private String toStringR(TreeNode h){
        if (h == null) return "";
        String s = toStringR(h.l);
        s += "Warehouse "+h.key() + " in "+h.city+":\n"+h.Booklist.toString();
        s += toStringR(h.r);
        return s;
    }
	
}