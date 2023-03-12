package linklist1_230223;
// https://www.scaler.com/academy/mentee-dashboard/class/50147/assignment/problems/40?navref=cl_tt_lst_sl
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		ListNode prev = null;
		ListNode curr = head;
		ListNode fut = head.next;
		while(curr != null) {
			curr.next = prev;
			prev = curr;
			curr = fut;
			if(fut != null) fut = fut.next;
		}
		return prev;
    }
	public ListNode reverseListScalerSol(ListNode A) {
	    ListNode node, prev, temp; node = A;
	    if (node == null) return null;
	    prev = null;
	    while (node != null) {
	        temp = node.next;
	        node.next = prev;
	        prev = node;
	        node = temp;
	    }
	    return prev;
	}
	public void printLinkedList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		} System.out.println();
	}
	public ListNode initializeLinkedList() {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(9);
		ListNode f = new ListNode(1);
		ListNode g = new ListNode(6);
		ListNode h = new ListNode(4);
		a.next = b; b.next = c; c.next = d; d.next=e;
		e.next = f; f.next = g; g.next = h;
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode a = rll.initializeLinkedList();
		rll.printLinkedList(a); // 2 3 5 1 9 1 6 4 
		rll.printLinkedList(rll.reverseList(a)); // 4 6 1 9 1 5 3 2 

	}

}
class ListNode {
	      public int val;
	      public ListNode next;
	      public ListNode prev;
	      ListNode(int x) { val = x; next = null; }
}