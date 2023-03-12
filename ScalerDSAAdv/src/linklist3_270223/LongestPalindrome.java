package linklist3_270223;
// https://www.scaler.com/academy/mentee-dashboard/class/50149/assignment/problems/4386?navref=cl_tt_nv
public class LongestPalindrome {

	 public int solve(ListNode head) {
	        int countOdd = longestOddLengthPalindrome(head);
	        int countEven = longestEvenLengthPalindrome(head);
	        return Math.max(countOdd, countEven);
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
	    public int longestEvenLengthPalindrome(ListNode head) {
			ListNode curr = head;
			ListNode prev = null;
			ListNode fut = null;
			int count = 0;
			int ans = 0;
			while(curr != null) {
				fut = curr.next;
				curr.next = prev;
				count = countMatch(curr, fut);
				ans = Math.max(ans, 2*count);
				prev = curr;
				curr = fut;
			}
			reverse(prev);
			return ans;
		}
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
	    public void printLinkedList(ListNode head) { // if cycle then no null is next so not 
			ListNode temp = head;
			while(temp != null) {
				System.out.print(temp.val +" ");
				temp = temp.next;
			} System.out.println();
		}
	    public int solveScalerSol(ListNode A) {

	        ListNode dummy = new ListNode(-1);
	        ListNode cur = A, prev = dummy;
	        int ans = 0;

	        while (cur != null) {
	            // Case 1: cur is a center node of palindrome of odd length

	            ListNode prevItr = prev, nextItr = cur.next;
	            int l = 1;
	            while (prevItr != null && nextItr != null) {
	                if (prevItr.val == nextItr.val) {
	                    prevItr = prevItr.next;
	                    nextItr = nextItr.next;
	                    l++;
	                } else break;

	            }
	            ans = Math.max(ans, l + l - 1);

	            // Case 2: When palindrome length is even
	            l = 0;
	            prevItr = prev;
	            nextItr = cur;

	            while (prevItr != null && nextItr != null) {
	                if (prevItr.val == nextItr.val) {
	                    prevItr = prevItr.next;
	                    nextItr = nextItr.next;
	                    l++;
	                } else break;

	            }

	            ans = Math.max(2 * l, ans);

	            ListNode Next = cur.next;
	            cur.next = prev;
	            prev = cur;
	            cur = Next;
	        }

	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindrome lp = new LongestPalindrome();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(3);
		a.next = b; b.next = c; c.next = d; d.next=e;
		lp.printLinkedList(a); // 2 1 1 2 3 
		System.out.println(lp.solve(a)); // 4
		ListNode k = new ListNode(31);
		ListNode l = new ListNode(23);
		ListNode m = new ListNode(99);
		ListNode n = new ListNode(99);
		ListNode o = new ListNode(23);
		ListNode p = new ListNode(31);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = p;
		lp.printLinkedList(k); // 31 23 99 99 23 31  
		System.out.println(lp.solve(k)); // 6
	}

}
