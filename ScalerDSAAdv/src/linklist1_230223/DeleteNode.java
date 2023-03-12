package linklist1_230223;

public class DeleteNode { // delete at head

	public ListNode deleteHeadNode(ListNode head) {
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return head;
	}
	public ListNode deleteTailNode(ListNode head) { // without 2 pointers
		if(head == null) return head;
		if(head.next == null) return null; // only 1 node so deleted
		ListNode temp = head;
		while(temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}
	public ListNode deleteTailNodePrev(ListNode head) { // with 2 pointers
		if(head == null) return head;
		if(head.next == null) return null; // only 1 node so deleted
		ListNode temp = head;
		ListNode prev = null;
		while(temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
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
		DeleteNode dn = new DeleteNode();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(9);
		a.next = b; b.next = c; c.next = d; d.next=e;
		dn.printLinkedList(a); // 2 3 5 1 9 
		dn.printLinkedList(dn.deleteHeadNode(a)); // 3 5 1 9 
		//dn.printLinkedList(dn.deleteHeadNode(c));  // 1 9 
		dn.printLinkedList(dn.deleteTailNode(c)); // 5 1 
		dn.printLinkedList(dn.deleteTailNodePrev(c)); // 5
	}

}
