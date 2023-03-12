package linklist3_270223;

import java.util.HashMap;

/** 
Approach:
1. Initially, we create a head & a tail node will key value as -1 & -1 respectively.
2. We will set head.next = tail and tail.prev = head.
3. This will help us to easily avoid corner cases. 
4. While setting:


Check if the HashMap contains the key. if yes, that means the size will remain same.
In this case, simply we will have to delete the node and update the value in the HashMap.
Then, if the HashMap doesn’t contain the key that means this is a new value. In this case there can be two scenarios
Either the capacity might have been reached, for this case delete the head and attach the new node at the end of the List.
Delete the key for the head node & insert the node in the HashMap.
If the capacity isn’t reached, insert the node to the end of the list and also insert a key node pair in the HashMap.
5. While getting:
Delete the existing position and attach to the end of the list update new node in the HashMap and return the value
If the HashMap doesn’t contain the key return -1

*/

public class Solution { // LRUCache

    static int capacity = 0;
    HashMap < Integer, ListNode1 > hm = new HashMap < > ();
    ListNode1 head = null, tail = null;

    public Solution(int capacity) {
        this.hm = new HashMap <> ();
        this.capacity = capacity;
        this.head=new ListNode1(-1, -1);
        this.tail=new ListNode1(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
    	System.out.println("In get "+key);
        if (hm.containsKey(key)) {

            ListNode1 node = hm.get(key);
            delete(node.key);
            insert(node.key, node.val);
            return node.val;

        } else {
            return -1;
        }

    }
   
    public void delete(int key) {
    	System.out.println("In delete "+key);
        ListNode1 curr = hm.get(key);
        ListNode1 prv = curr.prev;
        ListNode1 nxt = curr.next;
        prv.next = nxt;
        nxt.prev = prv;
        hm.remove(key);

    }
   
    public void insert(int key, int value) {
    	System.out.println("In insert "+key +" "+value);
        ListNode1 node = new ListNode1(key, value);
        hm.put(key, node);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev=node;

    }

    public void set(int key, int value) {
       
        if (hm.containsKey(key)) {
            delete(key);
            insert(key, value);
        } else {
            if (hm.size() == capacity) {
                delete(head.next.key);
                insert(key, value);
            } else {
                insert(key, value);
            }
        }
       
    }
    public static void main(String[] args) {
    	Solution lruc = new Solution(1);
    	lruc.set(2, 1);
    	lruc.set(2, 2);
    	System.out.println(lruc.get(2));
    	lruc.set(1, 1);
    	lruc.set(4, 1);
    	System.out.println(lruc.get(2));
	}

}

class ListNode1 {

    public int key;
    public int val;
    public ListNode1 next, prev;
    ListNode1(int x, int y) {
        key = x;
        val = y;
        next = null;
    }

}