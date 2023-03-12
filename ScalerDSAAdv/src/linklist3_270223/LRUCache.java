package linklist3_270223;

import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50149/assignment/problems/239?navref=cl_tt_lst_nm
public class LRUCache {
	
	static int capacity = 0;
    HashMap<Integer, DoublyListNode> hm = new HashMap<>();
    DoublyListNode head = null, tail = null;
    
    public LRUCache(int capacity) {
    	this.hm = new HashMap<>();
    	this.capacity = capacity;
        this.head = new DoublyListNode(-1, -1);
        this.tail = new DoublyListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
    	System.out.println("In get "+key);
        if(hm.containsKey(key)) {
        	DoublyListNode temp = hm.get(key);
        	delete(temp.key);
        	insert(temp.key, temp.val);
        	return temp.val;
        } else return -1;
    }
    
    public void insert(int key, int val) {
		// TODO Auto-generated method stub
    	System.out.println("In insert "+key +" "+val);
		DoublyListNode temp = new DoublyListNode(key, val);
		hm.put(key, temp);
		tail.prev.next = temp;
		temp.prev = tail.prev;
		temp.next = tail;
		tail.prev = temp;
	}

	public void delete(int key) {
		// TODO Auto-generated method stub
		System.out.println("In delete "+key);
		DoublyListNode curr = hm.get(key);
		DoublyListNode prev = curr.prev;
		DoublyListNode fut = curr.next;
		prev.next = fut;
		fut.prev = prev;
		hm.remove(key);
	}

	public void set(int key, int val) {
		System.out.println("In set "+key +" "+val);
    	if(hm.containsKey(key)) {
    		delete(key);
    		insert(key, val);
    	} else {
    		if(hm.size() == capacity) {
    			delete(head.next.key);
    			insert(key, val);
    		} else insert(key, val);
    	}
    	System.out.println("Exiting set ");
    	for(int i=0; i<hm.size(); i++) {
    		System.out.print(hm.get(key).val +" ");
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	LRUCache lruc = new LRUCache(1);
    	lruc.set(2, 1);
    	lruc.set(2, 2);
    	System.out.println(lruc.get(2));
    	lruc.set(1, 1);
    	lruc.set(4, 1);
    	System.out.println(lruc.get(2));
	}
}
class DoublyListNode {
	public int key;
    public int val;
    public DoublyListNode next, prev;
    DoublyListNode(int key, int val) { this.key = key; this.val = val;}
 }

/*
Your submission failed for the following input
6 1 S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 2

There are 1 lines in the input

Line 1 ( Corresponds to arg 1 ) : The line starts with a pair of number numOperations, capacity. capacity is the number your constructor is initialized with. 
Then numOperation operations follow. 
Each operation is either : 
 * G  : This corresponds to a function call get()
 * S   : This corresponds to a function call set(num1, num2)
Note that the function calls are made in order.  

Test As Custom Input
The expected return value:
2 -1 
Your function returned the following:
2 2 
*/