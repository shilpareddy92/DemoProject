package Patterns;

public class Stack {

	int capacity = 2;
	int stack[] = new int[capacity];
	int top = 0;

	public int size() {
		return top;
	}

	public boolean isEmpty() {
		return top <= 0;
	}

	private void expand() {
		int length = size();
		int[] newstack = new int[capacity * 2];
		System.arraycopy(stack, 0, newstack, 0, length);
		stack = newstack;
		capacity *= 2;
	}
	
	private void shrink() {
		int length = size();
		if (length <= (capacity / 2) / 2)
			capacity = capacity / 2;

		int[] newstack = new int[capacity];
		System.arraycopy(stack, 0, newstack, 0, length);
		stack = newstack;

	}
	
	public void push(int data) {
		if (size() == capacity)
			expand();
		stack[top] = data;
		top++;
	}
	
	public int pop() {
		int data = 0;
		if (isEmpty()) {
			System.out.println("stack is empty");
		} else {
			top--;
			data = stack[top];
			stack[top] = 0;
			shrink();
		}
		return data;
	}

	public int peek() {
		int data;
		data = stack[top - 1];
		return data;
	}
	public void print() {
		for (int n : stack) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Stack one = new Stack();
		one.push(5);
		one.push(6);
		one.push(7);
		one.print();
	}
}
