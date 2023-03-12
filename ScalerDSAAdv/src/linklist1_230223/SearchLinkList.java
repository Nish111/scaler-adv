package linklist1_230223;

public class SearchLinkList {

	public boolean searchLinkedList(ListNode head, int k) {
		ListNode temp = head;
		while(temp != null) {
			if(temp.val == k) return true;
			temp = temp.next;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchLinkList sll = new SearchLinkList();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(9);
		a.next = b; b.next = c; c.next = d; d.next=e;
		System.out.println(sll.searchLinkedList(a, 3)); // true
		System.out.println(sll.searchLinkedList(a, 4)); // false
	}
/*
 * class ListNode {
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
}
 */
}
