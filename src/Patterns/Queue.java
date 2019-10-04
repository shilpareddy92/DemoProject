package Patterns;

public class Queue {

	int arraysize = 6;
	int[] queue= new int[arraysize];
	int rear= 0;
	int front =0;
	int size =0;
	
	public int getSize() {
		
		return size;
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	public boolean isFull() {
		return getSize() == arraysize ;
	}
	public void enqueue(int data)
	{
		
//		if(!isFull())
//		{
		queue[rear] =data;
		rear= (rear+1)%arraysize;
		size++;
//		}
//		else
//		{
//			System.out.println("queue is full");
//		}
	}
	
	public int dequeue()
	{
		int data  = queue[front];
//		if(!isEmpty())
//		{
		front = (front+1)%arraysize;
		size--;
//		}
//		else
//		{
//			System.out.println("queue is empty");
//		}
		return data;
	}
	
	public void print()
	{
		for (int n : queue) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
