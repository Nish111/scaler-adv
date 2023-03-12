package queues_070323;

import java.util.LinkedList;

public class Queues { // using Linked List
	
	ListNode head, tail;
	public void enqueue(int x) {
		ListNode n = new ListNode(x);
		if(head==null) {
			head = n; 
			tail=n;
		} else {
			tail.next = n;
			tail = n;
		}
	}
	public void dequeue() {
		if(isEmpty()) return;
		ListNode temp = head;
		head = head.next;
		temp.next = temp;
		if(head == null) tail = null;
	}
	public boolean isEmpty() {
	      return head == null;
	}
	public int peek() {
		if(isEmpty()) return -1;// to inform queue is empty
		else return head.val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queues q = new Queues();
		q.enqueue(4);
		System.out.println(q.peek()); // 4
		q.enqueue(5);
		System.out.println(q.peek()); // 4
		q.enqueue(6);
		System.out.println(q.peek()); // 4
		q.dequeue();
		System.out.println(q.peek()); // 5
		q.dequeue();
		System.out.println(q.peek()); // 6
		q.dequeue();
		System.out.println(q.peek()); // -1
	}

}
class ListNode {
	public ListNode head, tail, next;
	public int val;
	ListNode(int x){
		this.val =x; head = null; tail = next; next = null;
	}
	ListNode(){
		head = null; tail = next; next = null;
	}
}