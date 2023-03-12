package linklist1_230223;

public class DeleteOccurences {

	/*
	 * public ListNode deleteOccurences(ListNode head, int k) { if(head == null)
	 * return head; // no nodes ListNode temp = head; while(temp.next != null) {
	 * if(temp.val == k) }
	 * 
	 * }
	 */
	public ListNode deleteOccurencesPrev(ListNode head, int k) { // with 2 pointers
		if(head == null) return head;
		ListNode temp = head;
		ListNode prev = null;
		while(temp.next != null) {
			if(temp.val == k) {
				prev.next = temp.next;
				temp.next = null;
				return head;
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}
	public ListNode deleteAllOccurencesPrev(ListNode head, int k) { // with 2 pointers
		if(head == null) return head;
		ListNode temp = head;
		ListNode prev = null;
		while(temp.next != null) {
			if(temp.val == k) {
				prev.next = temp.next;
				temp.next = null;
				temp = prev.next;
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}
	public void printLinkedList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		} System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteOccurences do1 = new DeleteOccurences();
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
		do1.printLinkedList(a); // 2 3 5 1 9 1 6 4 
		do1.printLinkedList(do1.deleteOccurencesPrev(a, 3)); // 2 5 1 9 1 6 4 
		do1.printLinkedList(do1.deleteAllOccurencesPrev(a, 1)); // 2 5 9 6 4 
	}

}
