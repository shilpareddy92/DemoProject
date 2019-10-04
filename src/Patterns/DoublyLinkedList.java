package Patterns;

public class DoublyLinkedList {

	public ListNode head;
	public ListNode tail;
	public int length;

	public DoublyLinkedList() {

		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	private static class ListNode {
		private int data;
		private ListNode previous;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public boolean isEmpty(){
		return length == 0;
	}
	
	public int length(){
		return length;
	}
	
	public void insertFirst(int data)
	{
		ListNode newnode= new ListNode(data);
		
		if(isEmpty()){
			tail=  newnode;
		}
		else {
		head.previous = newnode;
		}
		newnode.next =  head;
		head=  newnode;
		length++;
	}
	
	public void insertLast(int data)
	{
		ListNode newnode= new ListNode(data);
		
		
		if(isEmpty())
		{
			head=  newnode;
		}
		else {
		tail.next = newnode;
		newnode.previous = tail;
		
		}
		tail =newnode;
		length++;
	}
	
	public void printForward()
	{
		if(head== null) {
			return;
	}
		ListNode newnode= head;
		while(newnode != null)
		{
			System.out.print(newnode.data+"----");
			newnode = newnode.next;
		}
		System.out.println("null");
	}
	
	public void printbackward()
	{
		if(tail== null) {
			return;
		}
		ListNode newnode= tail;
		while(newnode != null)
		{
			System.out.print(newnode.data+"----");
			newnode = newnode.previous;
		}
		System.out.println("null");
	}
	
	

	public static void main(String[] args) {
		
		DoublyLinkedList dll=  new DoublyLinkedList();
		
		dll.insertFirst(5);
		dll.insertFirst(10);
		dll.insertFirst(15);
		dll.insertFirst(20);
		dll.printForward();
		dll.printbackward();
		dll.insertLast(50);
		dll.insertLast(100);
		dll.insertLast(150);
		dll.insertLast(200);
		dll.printForward();
		dll.printbackward();

		
	}

}
