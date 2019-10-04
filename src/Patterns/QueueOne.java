package Patterns;

import java.util.NoSuchElementException;

public class QueueOne {
	
	private ListNode rear;
	private ListNode front;
	private int length;
	
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public boolean isEmpty(){
		 return length <=0;
	}
	public int size()
	{
		return length;
	}
	
	public void print()
	{
		ListNode current = front;
		while(current.next != null)
		{
			System.out.print(current.data+" ");
			current =  current.next;
		}
		System.out.println(current.data);
	}
	
	public void enqueue(int data)
	{
		ListNode node = new ListNode(data);
		if(isEmpty()) {
			front = node;
		}else {
			rear.next =  node;
		}
		rear=  node;
		length++;
	}
	
	public int dequeue()
	{
		int data =0;
		
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is EMPTY---->>>");
		}else {
			 data =  front.data;
			front = front .next;
			if(front == null)
			{
				rear = null;
			}
		}
		 length--;
		 return data;
	
	}
	
	public static void main(String[] args) {
		QueueOne  q=  new QueueOne();
		System.out.println(q.size());
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.print();
		System.out.println(q.dequeue());
		q.print();
	}

}
