package linklist3_270223;

public class LongestOddPalindrome {

	public int longestOddLengthPalindrome(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode fut = null;
		int count = 0;
		int ans = 1;
		while(curr != null) {
			fut = curr.next;
			count = countMatch(prev, fut);
			ans = Math.max(ans, 2*count+1);
			curr.next = prev;
			prev = curr;
			curr = fut;
		}
		reverse(prev);
		return ans;
	}
	public void reverse(ListNode head) {
		// TODO Auto-generated method stub
		ListNode curr = head;
		ListNode prev = null;
		ListNode fut = null;
		while(curr != null) {
			fut = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fut;
		}
	}
	public int countMatch(ListNode prev, ListNode fut) {
		// TODO Auto-generated method stub
		int count = 0;
		while(prev != null && fut != null) {
			if(prev.val == fut.val) count++;
			else break;
			prev = prev.next;
			fut = fut.next;
		}
		return count;
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
		LongestOddPalindrome lop = new LongestOddPalindrome();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(2);
		a.next = b; b.next = c; c.next = d; d.next=e;
		lop.printLinkedList(a); // 2 1 2 3 2 
		System.out.println(lop.longestOddLengthPalindrome(a)); // 3
		ListNode k = new ListNode(31);
		ListNode l = new ListNode(23);
		ListNode m = new ListNode(99);
		ListNode n = new ListNode(23);
		ListNode o = new ListNode(31);
		ListNode p = new ListNode(61);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = p;
		lop.printLinkedList(k); // 31 23 99 23 31 61 
		System.out.println(lop.longestOddLengthPalindrome(k)); // 5
	}
}
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null;
    }
 }
