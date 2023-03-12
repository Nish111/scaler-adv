package linklist2_240223;

import java.util.HashMap;

public class DetectCycleStartingPoint {
// to return starting point of cycle
	// if no cycle then we return head
	public ListNode detectStartPoint(ListNode head) {
		ListNode temp = head;
		HashMap<ListNode, Integer> hm = new HashMap<>();
		int i=1;
		while(temp.next != null ) {
			if(hm.containsKey(temp)) return temp;
			hm.put(temp, i);
			i++; temp = temp.next;
		}
		return head;
	}
	public ListNode detectStartSlowFast(ListNode head) { // O(n) O(n)
		if(head == null) return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode p1 = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				ListNode p2 = slow;
				while(p1 != p2) {
					p1 = p1.next; p2 = p2.next;
				}
				return p1;
			}
		}
		return p1;
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
		DetectCycleStartingPoint dcsp = new DetectCycleStartingPoint();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(9);
		ListNode f = new ListNode(6);
		a.next = b; b.next = c; c.next = d; d.next=e; e.next = f;
		dcsp.printLinkedList(a); // 2 3 5 1 9 6 
		System.out.println(dcsp.detectStartPoint(a).val); // 2
		System.out.println(dcsp.detectStartSlowFast(a).val); // 2
		ListNode k = new ListNode(2);
		ListNode l = new ListNode(3);
		ListNode m = new ListNode(5);
		ListNode n = new ListNode(1);
		ListNode o = new ListNode(9);
		ListNode p = new ListNode(6);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = l;
		//dc.printLinkedList(l);
		System.out.println(dcsp.detectStartPoint(k).val); // 3
		System.out.println(dcsp.detectStartSlowFast(k).val); // 3
	}

}
