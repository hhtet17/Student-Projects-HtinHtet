import java.util.*;
//ACO 201 Project 3
//Htin Htet & Eric Gonzales
public class Graph {
	public int V;
	private LinkedList<Integer> adjacent[];
	
	Graph(int var) //constructor
	{
		V = var;
		adjacent = new LinkedList[var];
			for(int i = 0; i < var; ++i)
			{
				adjacent[i] = new LinkedList();
			}
	}
	
	public void addEdge(int x, int y) //adds vertices
	{
		adjacent[x].add(y);
		//adjacent[y].add(x);
	}
	
	public void breathFirstSearch(int set) //method for breadth first transversal order
	{
		
		System.out.println("Breadth First Traversal Order: ");
		boolean HV[] = new boolean[V];
		LinkedList<Integer> q = new LinkedList<Integer>(); // declares new queue using Linked List
		HV[set] = true;
		q.add(set);
		 while(q.size() != 0)
		 {
			 set = q.poll(); //returns front end
			 System.out.print(set + "-");
			 Iterator<Integer> it = adjacent[set].listIterator();
			 while(it.hasNext())
			 {
				 int j = it.next();
				 if(!HV[j])
				 {
					 HV[j]= true;
					 q.add(j);
				 }
			 }
		 }
		 System.out.println();
	}
	
	public void print()
	{
		for(int i = 0; i < adjacent.length; i++) //prints array of adjacent vertices via index
		{
			System.out.println("\n List of Adjacency for Vertex: " + i);
			
			for(int j : adjacent[i])
			{
				System.out.print(j + ", ");
			}
			
		}
	}
	
}
