package Patterns;

public class SingleyLinkedList {

	// private ListNode head;

	public void display(ListNode head) {
		if (head == null) {
			return;
		} else {
			ListNode current = head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println(current);

		}

	}

	public int length(ListNode head) {
		if (head == null) {
			return 0;
		} else {
			int count = 0;
			ListNode current = head;
			while (current != null) {
				count++;
				current = current.next;
			}
			return count;

		}

	}

	public ListNode insertAtStart(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			return newNode;
		} else {
			newNode.next = head;
			head = newNode;
			return head;
		}
	}

	public ListNode insertAtEnd(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			return newNode;
		} else {
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;

			return head;
		}
	}

	public void insertAfter(ListNode previous, int data) {

		if (previous == null) {
			System.out.println("previous can not be null");
			return;
		} else {
			ListNode newNode = new ListNode(data);
			newNode.next = previous.next;
			previous.next = newNode;
		}
	}

	public ListNode insertAtPostion(ListNode head, int position, int data) {
		int size = length(head);
		if (position > size + 1 || position < 1) {
			System.out.println("Inavalid position");
			return head;
		}
		ListNode mynode = new ListNode(data);

		if (position == 1) {
			mynode.next = head;
			return mynode;
		} else

		{
			ListNode previous = head;
			for (int i = 0; i < position - 1; i++) {
				previous = previous.next;
			}

			ListNode current = previous.next;
			mynode.next = current;
			previous.next = mynode;
			return mynode;

		}
	}

	private static class ListNode {
		private int data;

		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(8);
		ListNode second = new ListNode(9);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(12);
		head.next = second;
		second.next = third;
		third.next = fourth;

		SingleyLinkedList list = new SingleyLinkedList();
		list.display(head);
		System.out.println("Size is " + list.length(head));
		list.insertAfter(second, 15);
		list.display(head);
	}

}
