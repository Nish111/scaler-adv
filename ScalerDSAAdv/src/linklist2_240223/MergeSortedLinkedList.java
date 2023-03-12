package linklist2_240223;

import java.util.List;
// https://www.scaler.com/academy/mentee-dashboard/class/50148/assignment/problems/36?navref=cl_tt_nv
public class MergeSortedLinkedList {

	public ListNode mergeSortedLL(ListNode h1, ListNode h2) { // O(m+n) O(1)
		
		ListNode head = new ListNode(-1);
		ListNode temp = head;
		while(h1 != null && h2 != null) {
			if(h1.val <= h2.val) {
				temp.next = h1;
				h1 = h1.next;
				temp = temp.next;
				//printLinkedList(temp);
			} else {
					temp.next = h2;
					h2 = h2.next;
					temp = temp.next;
					//printLinkedList(temp);
			}
		}
		if(h1 != null) temp.next = h1;
		else temp.next = h2;
		head = head.next;
		return head;
	}
	public ListNode mergeTwoListScalerSol(ListNode A, ListNode B) {
        return solveScalerSol(A, B);
    }
    public ListNode solveScalerSol(ListNode A, ListNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        ListNode head;
        ListNode node = new ListNode(0);
        head = node;
        while (A != null && B != null) {
            // compare both the values
            if (A.val <= B.val) {
                node.next = A;
                A = A.next;
                node = node.next;
            } else {
                node.next = B;
                B = B.next;
                node = node.next;
            }
        }
        if (A == null)
            node.next = B;
        else
            node.next = A;
        head = head.next;
        return head;
    }
	public void printLinkedList(ListNode head) { // if cycle then no null is next so not 
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		} System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedLinkedList msll = new MergeSortedLinkedList();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(9);
		a.next = b; b.next = c; c.next = d; d.next=e; e.next = f;
		msll.printLinkedList(a);
		ListNode k = new ListNode(12);
		ListNode l = new ListNode(21);
		ListNode m = new ListNode(31);
		ListNode n = new ListNode(56);
		ListNode o = new ListNode(59);
		ListNode p = new ListNode(61);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = p;
		msll.printLinkedList(k);
		msll.printLinkedList(msll.mergeSortedLL(a, k));
	}

}
