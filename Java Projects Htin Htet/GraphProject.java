import java.util.*;
//ACO 201 Project 3
//Htin Htet Eric Gonzales

public class GraphProject {

	public static void main(String[] args) {
		System.out.println("ACO-201 Project-03: Htin Htet, Eric Gonzales");
		System.out.print("Enter the vertex count: "); //prompts input #1 (count of vertices)
		Scanner count = new Scanner(System.in);
		int vertexCount = count.nextInt();
		System.out.print("Enter the vertices: "); // prompts all adjacency edges input#2
		Scanner thread = new Scanner(System.in);
		int set = 0;
		String [] graphEdge = thread.nextLine().split(";"); // separates all graph edges into String array
		Graph gph = new Graph(vertexCount);
		
			for(String index: graphEdge)
			{
				String[] edgeKeep = index.split(","); //Separates integers of index
				
				int leftE = Integer.parseInt(edgeKeep[0]);
				int rightE = Integer.parseInt(edgeKeep[1]);
				gph.addEdge(leftE, rightE); //adds parsed int 
			}
		gph.breathFirstSearch(set); //BFS method
		gph.print(); //prints all list of adjacency
		

	}

}
