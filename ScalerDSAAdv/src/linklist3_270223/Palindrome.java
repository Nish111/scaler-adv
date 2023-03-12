package linklist3_270223;

import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50149/assignment/problems/331/?navref=cl_pb_nv_tb
public class Palindrome {

	public int findPalindrome(ListNode head) {
		//printLinkedList(head);
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = slow;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode temp = slow.next;
		slow.next = null;
		temp = reverse(temp);
		while(head != null && temp != null) {
			if(head.val != temp.val) return 0;
			head = head.next;
			temp = temp.next;
		}
		return 1;
	}
	public ListNode reverse(ListNode head) {
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
		return prev;
	}
	public void printLinkedList(ListNode head) { // if cycle then no null is next so not 
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		} System.out.println();
	}
	public ListNode reverseList(ListNode A) { //1
        ListNode head=A;
        ListNode prev=null;
        ListNode t=head;
        ListNode Next=null;
        while(t!=null){
             Next=t.next;
             t.next=prev;
             prev=t;
             t=Next;
        }
        return prev;
    }
     public ListNode solve(ListNode A) { //2
        ListNode f=A;
        ListNode s=A;
        if(s.next==null)
           return s;
        if(s.next.next==null)
           return s;  
        while(f.next!=null&&f.next.next!=null){ 
            f=f.next.next;
            s=s.next;
        }
        if(f.next==null)
           return s;
        return s;
    }
     // not working
    public int lPalin(ListNode A) { // 3
        ListNode m=solve(A);
        ListNode h2=m.next;
        m.next=null;
        ListNode rev=reverseList(h2);
        while(A!=null && rev!=null){
            if(A.val!=rev.val)
              return 0;
            A=A.next;
            rev=rev.next;  
        }
        return 1;
    }
    public int lPalin2(ListNode A) {// working
        Stack<Integer> st = new Stack<Integer>();

        ListNode Slow = A;
        ListNode Fast = A;

        while(Fast != null && Fast.next != null){
            st.push(Slow.val);
            Slow = Slow.next;
            Fast = Fast.next.next;
        }
        if(Fast != null){
            Slow = Slow.next;
        }
        while(!st.empty()){
            if(Slow.val != st.peek()){
                return 0;
            }
            Slow = Slow.next;
            st.pop();
        }
        return 1;
    }
    //  // not working
    public ListNode reverse3(ListNode h){
        ListNode prev=null, curr=h;
        while(curr!=null){
            ListNode upcoming=curr.next;
            curr.next=prev;
            prev=curr;
            curr=upcoming;
        }
        return prev;
    }
   
    public int lPalin3(ListNode A) {
        ListNode s=A,f=A;
        while(f.next!=null && f.next.next!=null){
            s=s.next; f=f.next.next;
        }
        ListNode midHead=s.next;
        s.next=null;
        ListNode reversedHead=reverse(midHead);
        while(reversedHead!=null && A!=null){
            if(reversedHead.val!=A.val) return 0;
            reversedHead=reversedHead.next;
            A=A.next;
        }
        return 1;
    }
    public int lPalinScalerSol(ListNode A) {
        ListNode slow_ptr = A, fast_ptr = A;
        ListNode second_half, prev_of_slow_ptr = A;
        ListNode midnode = null; // To handle odd size list
        int res = 1; // initialize result
        if (A != null && A.next != null) {
            /* Get the middle of the list. Move slow_ptr by 1
               and fast_ptrr by 2, slow_ptr will have the middle
               ListNode */
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;

                /*We need previous of the slow_ptr for
                  linked lists  with odd elements */
                prev_of_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            /* fast_ptr would become NULL when there are even elements in list. 
               And not NULL for odd elements. We need to skip the middle ListNode 
               for odd case and store it somewhere so that we can restore the
               original list*/
            if (fast_ptr != null) {
                midnode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            // Now reverse the second half and compare it with first half
            second_half = slow_ptr;
            prev_of_slow_ptr.next = null; // NULL terminate first half
            second_half = reverseScalerSol(second_half); // Reverse the second half
            res = compareListsScalerSol(A, second_half); // compare
        }
        return res;
    }
    public ListNode reverseScalerSol(ListNode head_ref) {
        ListNode prev = null;
        ListNode current = head_ref;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /* Function to check if two input lists have same val*/
    int compareListsScalerSol(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val == temp2.val) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else return 0;
        }
        /* Both are empty reurn 1*/
        if (temp1 == null && temp2 == null)
            return 1;
        /* Will reach here when one is NULL
           and other is not */
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome pl = new Palindrome();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(3);
		a.next = b; b.next = c; c.next = d; 
		pl.printLinkedList(a); // 2 1 2 3 2 
		System.out.println(pl.findPalindrome(a)); // 1
		System.out.println(pl.lPalin(a)); // 0 - not working
		System.out.println(pl.lPalin2(a)); // 1
		System.out.println(pl.lPalin3(a)); // 1
		ListNode k = new ListNode(31);
		ListNode l = new ListNode(23);
		ListNode m = new ListNode(99);
		ListNode n = new ListNode(99);
		ListNode o = new ListNode(23);
		ListNode p = new ListNode(61);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = p;
		pl.printLinkedList(k); // 31 23 99 23 31 61 
		System.out.println(pl.findPalindrome(k)); // 0
		System.out.println(pl.lPalin(k)); // 0
		System.out.println(pl.lPalin2(k)); // 0
		System.out.println(pl.lPalin3(k)); // 0
	}
}
/*
 * class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null;
    }
 }
*/
