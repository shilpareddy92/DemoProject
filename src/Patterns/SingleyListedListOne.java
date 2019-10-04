package Patterns;

public class SingleyListedListOne {
	
	private ListNode head;
	
	private static class ListNode
	{
		private int data;
		private ListNode  next;
		
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public void insert(int data)
	{
		ListNode node = new ListNode(data);
		if(head == null){
			head = node;
		} else {
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	public  void display()
	{
		ListNode current = head;
		while (current.next != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println(current.data+" ");
	}
	
	public int length()
	{
		ListNode current = head;
		int count = 0;
		while (current!= null) {
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
		current.next = node;
	}
	
	public void insertAt(int index,int data)
	{
		ListNode node = new ListNode(data);
		if(index == 0){
			insertAtStart(data);
		}
		else
		{
			ListNode current = head;
			for(int i=0;i<index-1;i++){
				current = current.next;
			}
			node.next = current.next;
			current.next = node;		
		}
	}
	
	public void deleteAt(int index)
	{
		if(index== 0){
			head= head.next;
		}
		else
		{
			ListNode current = head;
			ListNode temp = null;
			for(int i=0;i<index-1;i++){
				current = current.next;
			}
		temp= current.next;
		current.next = temp.next;
		}
	}
	
	public ListNode reverse()
	{
		ListNode current=  head;
		ListNode next =null;
		ListNode previous = null;
		
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous=current;
			current= next;
		}
		return head= previous;
	}
	
	public ListNode getMiddleNode()
	{
		
		ListNode slowPtr =head;
		ListNode fastPtr = head;
		while(fastPtr != null && fastPtr.next != null)
		{
			slowPtr = slowPtr.next;
			fastPtr =fastPtr.next.next;
		}
		return slowPtr;
	
	}
	
	public ListNode getNthNodeFromEnd(int nodenumber)
	{
		ListNode mainPtr =head;
		ListNode refPtr = head;
		if(nodenumber <=0){
			throw new IllegalArgumentException("Invalid value node number "+ nodenumber)  ;
		}
		
		int count =0;
		while(count <nodenumber){
			if(refPtr ==  null)
			{
				throw new IllegalArgumentException("Invalid value node number "+ nodenumber);
			}
			refPtr =refPtr.next;
			count++;
		}
		while(refPtr != null){
			refPtr =refPtr.next;
			mainPtr =mainPtr.next;
		}
		return mainPtr;
	}
	
	public void RemoveDuplicatesFromSortedList()
	{
		ListNode current =head;
		while(current != null  && current.next != null)
		{
			if(current.data ==current.next.data){
			current.next =current.next.next;
			}
			else {
				current = current.next;
			}
		}
	}
	
	public ListNode InsertInSortedList(int data)
	{
		ListNode newNode=  new ListNode(data);
		ListNode current =head;
		ListNode temp =  null;
		while(current != null  && current.data < newNode.data)
		{
			temp = current;
			current = current.next ;
		}
		newNode.next   =current;
		temp.next = newNode;
		return head;
	}
	
	
	public static void main(String[] args) {
		SingleyListedListOne ll=  new SingleyListedListOne();
		ll.insert(0);
		ll.insert(8);
		ll.insert(81);
		ll.insert(97);
		ll.insert(400);
		ll.display();
		ll.InsertInSortedList(399);
		
	ll.display();
	
	}
	

}
