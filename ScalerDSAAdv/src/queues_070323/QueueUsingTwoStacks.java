package queues_070323;

import java.util.Stack;

public class QueueUsingTwoStacks<T> {

	Stack<T> st1 = new Stack<>();
	Stack<T> st2 = new Stack<>();
	
	public void enqueue(T i) {
		// TODO Auto-generated method stub
		st1.push(i);
		
	}
	public void dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) return;
		if(st2.isEmpty()) {
			move();
		}
		st2.pop(); 
	}
	public void move() {
		// TODO Auto-generated method stub
		while(!st1.isEmpty()) {
			st2.push(st1.peek());
			st1.pop();
		}
	}
	public T peek() {
		// TODO Auto-generated method stub
		if(!st1.isEmpty())	return st1.peek();
		else if(!st2.isEmpty()) return st2.peek();
		else {
			System.out.println("Queue is empty");
			return null;
		}
	}
	boolean isEmpty() {
		if(st1.isEmpty() && st2.isEmpty()) return true;
		else return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingTwoStacks quts = new QueueUsingTwoStacks();
		quts.enqueue(4);
		//System.out.println(q.isEmpty());
		System.out.println(quts.peek()); // 4
		quts.enqueue(5);
		System.out.println(quts.peek()); // 5
		quts.enqueue(6);
		System.out.println(quts.peek()); // 6
		quts.dequeue();
		System.out.println(quts.peek()); // 5
		quts.dequeue();
		System.out.println(quts.peek()); // 6
		quts.enqueue(10);
		System.out.println(quts.peek()); // 10
		quts.dequeue();
		System.out.println(quts.peek()); // 10
		quts.enqueue(4);
		System.out.println(quts.peek()); // 4
		quts.dequeue();
		System.out.println(quts.peek()); // 4
		quts.dequeue();
		System.out.println(quts.peek()); // Queue is empty null

	}
	

	
}
