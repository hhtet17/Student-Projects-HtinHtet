//ACO Project 2
//Htin Htet, Eric Gonzales
public class Queue {
	Node front, end;
	
	public Queue() //constructor of queue
	{
		this.front = null;
		this.end = null;
	}
	void enqueue(int data) //adds data
	{
		Node temp = new Node(data);
		
		if(this.end == null)
		{
			this.front = this.end = temp;
			return;
		}
		this.end.next = temp;
		this.end = temp;
	}
	 int dequeue() //returns int and removes datat FIFO protocal
	{
		if(this.front == null)
			return 0;
		int frnt = front.data;
		Node temp = this.front;
		this.front = this.front.next;
		
		if(this.front == null)
			this.end = null;
		return frnt;
	}
	
}
class Node //linked list implementation
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}
