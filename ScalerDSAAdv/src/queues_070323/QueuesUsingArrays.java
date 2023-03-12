package queues_070323;

import java.util.NoSuchElementException;

public class QueuesUsingArrays<T> {

    private T[] elements;
    private int front;
    private int rear;
    private int size;

    public QueuesUsingArrays(int capacity) {
        elements = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T element) {
        if (isFull()) {
            //throw new IllegalStateException("Queue is full");
        	System.out.println("Queue is full");
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
        //System.out.println("here");
    }

    public T dequeue() {
        if (isEmpty()) {
            //throw new NoSuchElementException("Queue is empty");
        	System.out.println("Queue is empty");
        }
        T element = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }
    private T peek() {
		// TODO Auto-generated method stub
    	if(isEmpty()) {
    		// throw new NoSuchElementException("Queue is empty");
    		System.out.println("Queue is empty");
    	}
    	else return (T) elements[front];
		return null;
	}
    public int size() {
        return size;
    }
    public static void main(String[] args) {
    	QueuesUsingArrays q = new QueuesUsingArrays(6);
		q.enqueue(4);
		//System.out.println(q.isEmpty());
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
		System.out.println(q.peek()); // Queue is empty null

	}

	
}