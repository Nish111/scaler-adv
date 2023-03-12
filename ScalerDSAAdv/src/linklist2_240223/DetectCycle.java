package linklist2_240223;

import java.util.HashMap;

public class DetectCycle {

	public boolean detectCycle(ListNode head) { // O(n) O(n)
		ListNode temp = head;
		HashMap<ListNode, Integer> hm = new HashMap<>();
		int i=1;
		while(temp.next != null ) {
			if(hm.containsKey(temp)) return true;
			hm.put(temp, i);
			i++; temp = temp.next;
		}
		return false;
	}
	public boolean detectCycleSlowFast(ListNode head) { // O(n) O(n)
		if(head == null) return false;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
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
		DetectCycle dc = new DetectCycle();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(9);
		ListNode f = new ListNode(6);
		a.next = b; b.next = c; c.next = d; d.next=e; e.next = f;
		dc.printLinkedList(a);
		System.out.println(dc.detectCycle(a)); // false
		System.out.println(dc.detectCycleSlowFast(a)); // false
		ListNode k = new ListNode(2);
		ListNode l = new ListNode(3);
		ListNode m = new ListNode(5);
		ListNode n = new ListNode(1);
		ListNode o = new ListNode(9);
		ListNode p = new ListNode(6);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = l;
		//dc.printLinkedList(l);
		System.out.println(dc.detectCycle(k)); // true
		System.out.println(dc.detectCycleSlowFast(k)); // true
	}

}
