package linklist2_240223;
// https://www.scaler.com/academy/mentee-dashboard/class/50148/assignment/problems/4370?navref=cl_tt_lst_nm
public class MiddleList1 {
// NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
	public int middleOfLinkedList(ListNode head) { // O(n+n/2)
		ListNode temp = head;
		int count=0;
		while(temp.next != null) {
			count++;
			temp = temp.next;
		}
		temp = head;
		int counter = count/2;
		count=0;
		while(temp != null) {
			if(count == counter) {
				return temp.val;
			}
			temp = temp.next;
			count++;
		}
		return 0;
	}
	public int slowFast(ListNode head) { // O(n )
		if(head==null) return 0;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast.next == null) return slow.val;
		else return slow.next.val;
	}
	public int solveScalersol(ListNode A) {
        if (A.next == null)
            return A.val;
        // slow and fast pointer
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
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
		MiddleList1 ml = new MiddleList1();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(9);
		ListNode f = new ListNode(6);
		ListNode g = new ListNode(34);
		ListNode h = new ListNode(63);
		a.next = b; b.next = c; c.next = d; d.next=e; e.next = f;
		f.next = g; g.next = h;
		ml.printLinkedList(a); // 2 3 5 1 9 6 34 63 
		System.out.println(ml.middleOfLinkedList(a)); // 1 --9
		System.out.println(ml.middleOfLinkedList(d)); // 6
		System.out.println(ml.slowFast(a)); // 9
		System.out.println(ml.slowFast(d)); // 6
		System.out.println(ml.slowFast(c)); // 6
	}

}
