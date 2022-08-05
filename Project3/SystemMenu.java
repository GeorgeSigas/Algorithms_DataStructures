import java.io.*;
import java.util.Scanner;


public class SystemMenu
{
	public static void main(String args[]) throws java.io.IOException
	{
		ST Warehouses=new ST();
		PrintStream ps=new PrintStream(System.out);
		Scanner sc=new Scanner(System.in);
		int id,isbn,copies;
		String city;
		while(true)
		{
			ps.println("\n========Menu========\n");
			ps.print("1.Insert Warehouse\n"+
					"2.Insert Book at Warehouse\n"+
					"3.Remove Warehouse\n"+
					"4.Remove Book\n"+
					"5.Search for a Warehouse\n"+
					"6.Search for a book in a Specific Warehouse\n"+
					"7.Search for a Book in every Warehouse\n"+
					"8.Print the books of Every Warehouse\n"+
					"9.Exit Menu\n\n"+
					"========================\n\n"+
					"Enter your Action Number: ");
			int input=sc.nextInt();		
			if(input==1)
			{
				ps.print("\nGive the id of the Warehouse: ");
				id=sc.nextInt();
				ps.print("Give the name of the City: ");
				sc.nextLine();
				city=sc.nextLine();
				ps.println();
				Warehouses.insertWarehouse(id,city);
				
			}
			else if(input==2)
			{
				ps.print("Give the id of the Warehouse: ");
				id=sc.nextInt();
				ps.print("Give the isbn of the Book: ");
				isbn=sc.nextInt();
				ps.print("Give the the number of the copies that you want to add: ");
				copies=sc.nextInt();
				ps.println();
				Warehouses.insertBookAtWarehouse(id,isbn,copies);
			}
			else if(input==3)
			{
				ps.print("Give the id of the Warehouse: ");
				id=sc.nextInt();
				ps.println();
				Warehouses.removeWarehouse(id);
			}
			else if(input==4)
			{
				ps.print("Give the id of the Warehouse from which you want to delete the Book: ");
				id=sc.nextInt();
				ps.print("Give the isbn of the Book you want to delete: ");
				isbn=sc.nextInt();
				ps.println();
				Warehouses.removeBook(id,isbn); 
			}
			else if(input==5)
			{
				ps.print("Give the id of the Warehouse you want to search for: ");
				id=sc.nextInt();
				ps.println();
				Warehouses.searchByWarehouse(id);
			}
			else if(input==6)
			{	
				ps.print("Give the id of the Warehouse in which you want to Search for the book: ");
				id=sc.nextInt();
				ps.print("Give the isbn of the Book you want search for: ");
				isbn=sc.nextInt();
				ps.println();
				Warehouses.searchBookInWarehouse(id,isbn);
				Warehouses.counter=0;
			}
			else if(input==7)
			{
				ps.print("Give the isbn of the Book you want search for: ");
				isbn=sc.nextInt();
				ps.println();
				Warehouses.searchBook(isbn);
			}
			else if(input==8)
			{
				ps.println();
				Warehouses.printΤree(ps);
				
			}
			else if(input==9)
			{
				break;
			}
			else
			{
				ps.println("Wrong Number!Please try again");
			}
		}
	}
}