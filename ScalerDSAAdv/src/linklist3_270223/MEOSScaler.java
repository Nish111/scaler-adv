package linklist3_270223;

import java.util.ArrayList;
// https://www.scaler.com/academy/mentee-dashboard/class/50149/homework/problems/9290/hints?navref=cl_pb_nv_tb
class DLLNode {
    public DLLNode prev;
    public int data;
    public DLLNode next;
};

/* Representation of the stack data structure
that supports findMiddle() in O(1) time.
The Stack is implemented using Doubly Linked List.
It maintains pointer to head node, pointer to
middle node and count of nodes */
class myStack {
    public DLLNode head;
    public DLLNode mid;
    public int count;
};

public class MEOSScaler {
    public ArrayList < Integer > solve(ArrayList < ArrayList < Integer >> A) {
        myStack ms = createMyStack();
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        for (int i = 0; i < A.size(); i++) {
            int a = A.get(i).get(0);
            int b = A.get(i).get(1);
            if (a == 1)
                push(ms, b);
            else if (a == 2)
                ans.add(pop(ms));
            else if (a == 3)
                ans.add(findMiddle(ms));
            else if (a == 4)
                deleteMiddle(ms);
        }
        return ans;
    }

    /* Function to create the stack data structure */
    public myStack createMyStack() {
        myStack ms = new myStack();
        ms.count = 0;
        return ms;
    };
    /* Function to push an element to the stack */
    public void push(myStack ms, int new_data) {
        /* allocate DLLNode and put in data */
        DLLNode new_DLLNode = new DLLNode();
        new_DLLNode.data = new_data;
        /* Since we are adding at the beginning,
        prev is always null */
        new_DLLNode.prev = null;
        /* link the old list off the new DLLNode */
        new_DLLNode.next = ms.head;
        /* Increment count of items in stack */
        ms.count += 1;
        /* Change mid pointer in two cases
        1) Linked List is empty
        2) Number of nodes in linked list is odd */
        if (ms.count == 1) {
            ms.mid = new_DLLNode;
        } else {
            ms.head.prev = new_DLLNode;
            if ((ms.count & 1) == 0) // Update mid if ms->count is even
                ms.mid = ms.mid.prev;
        }
        /* move head to point to the new DLLNode */
        ms.head = new_DLLNode;
    }

    /* Function to pop an element from stack */
    public int pop(myStack ms) {
        /* Stack underflow */
        if (ms.count == 0) {
            return -1;
        }
        DLLNode head = ms.head;
        int item = head.data;
        ms.head = head.next;
        // If linked list doesn't
        // become empty, update prev
        // of new head as null
        if (ms.head != null)
            ms.head.prev = null;
        ms.count -= 1;
        // update the mid pointer when
        // we have odd number of
        // elements in the stack, i,e
        // move down the mid pointer.
        if ((ms.count & 1) != 0)
            ms.mid = ms.mid.next;
        return item;
    }

    // Function for finding middle of the stack
    public int findMiddle(myStack ms) {
        if (ms.count == 0) {
            return -1;
        }
        return ms.mid.data;
    }
    public void deleteMiddle(myStack ms) {
        if (ms.count == 0)
            return;
        else if (ms.count == 1) {
            ms.count = 0;
            ms.head = null;
            ms.mid = null;
        } else if (ms.count == 2) {
            ms.count = 1;
            DLLNode head = ms.head;
            ms.head = head.next;
            ms.head.prev = null;
            ms.mid = ms.head;
        } else {
            DLLNode fo = ms.mid.next;
            DLLNode bac = ms.mid.prev;
            ms.mid.prev.next = ms.mid.next;
            ms.mid.next.prev = ms.mid.prev;
            ms.count -= 1;
            if ((ms.count & 1) != 0) ms.mid = fo;
            else ms.mid = bac;
        }
        return;
    }
}