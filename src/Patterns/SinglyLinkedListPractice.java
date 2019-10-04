package Patterns;



public class SinglyLinkedListPractice {
	
	private ListNode head;
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void insert(int data)
	{
		ListNode node = new ListNode(data);
		if (head == null) {
			head = node;
		} else {
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}
	public void print(){
		ListNode current = head;
		while (current.next != null) {
			System.out.print(current.data+ " " );
			current = current.next;
		}
		System.out.println(current.data);
	}
	public int length()
	{
		ListNode current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		 return count;
	}
	
	public void insertAtStart(int data)
	{
		ListNode node = new ListNode(data);
		node.next =  head;
		head= node;
	}
	public void insertAtEnd(int data)
	{
		ListNode node = new ListNode(data);
		ListNode current = head;
		
		while (current.next != null) {
			current = current.next;
		}
		current.next =  node;
	}
	
	public void inserAt(int index, int data) {
		ListNode node = new ListNode(data);
		if (index == 0) {
			insertAtStart(data);
		} else {
			ListNode current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			node.next = current.next;
			current.next = node;
		}
	}
	
	public void deleteAt(int index)
	{
		if (index == 0) {
			head= head.next;
		}
		else
		{
			ListNode current = head;
			ListNode node =null;
				for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			node = current.next;
			current.next = node.next;
		}
		
	}
	
	public ListNode reverse() {

		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			}
		return head = previous;

	}
	
	public ListNode getMiddleNode()
	{
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while(fastPtr !=null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr =fastPtr.next.next;
		}
		return slowPtr;
	}
	
	public ListNode getNthNodeFromEnd(int nodenumber)
	{
		
		ListNode refPtr = head;
		ListNode mainPtr = head;
		if(nodenumber <0)
		{
			System.out.println("Invalid node number");
		}
		int count= 0;
		while(count<nodenumber)
		{
			if(refPtr == null)
			{
				System.out.println("Invalid node number");
			}
			refPtr = refPtr.next;
			count++;
		}
		while(refPtr !=null)
		{
			refPtr =refPtr.next;
			mainPtr = mainPtr.next;
		}
		return  mainPtr;
	}


	public static void main(String[] args) {
		SinglyLinkedListPractice ll= new SinglyLinkedListPractice();
		ll.insert(6);
		ll.insert(8);
		ll.insertAtStart(5);
		ll.insertAtEnd(9);
		ll.print();
		System.out.println("The length of linked list is "+ll.length());
		//ll.reverse();
		ll.print();
		System.out.println("The middle node of linked list is "+ll.getMiddleNode().data);
		
	}

}
