package linklist2_240223;

import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50148/assignment/problems/4226?navref=cl_tt_lst_nm
public class RemoveLoopFromLinkedList {
// list contains a loop
	public ListNode detectStartPoint(ListNode head) { // have to modify 
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
				ListNode p3 = slow;
				while(p1 != p2) {
					p1 = p1.next; p2 = p2.next;
				}
				while(p3.next != p1) {
					p3 = p3.next;
				}
				p3.next=null;
				return head;
			}
		}
		return head;
	}
	 public ListNode solveScalerSol(ListNode A) {
	        detectAndRemoveLoopScalerSol(A);
	        return A;
	    }
	    int detectAndRemoveLoopScalerSol(ListNode node) {
	        ListNode slow = node, fast = node;
	        while (slow != null && fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;

	            // If slow and fast meet at same point then loop is present 
	            if (slow == fast) {
	                removeLoopScalerSol(slow, node);
	                return 1;
	            }
	        }
	        return 0;
	    }

	    // Function to remove loop 
	    void removeLoopScalerSol(ListNode loop, ListNode curr) {
	        ListNode ptr1 = null;
	        ListNode ptr2 = null;
	        /* Set a pointer to the beginning of the Linked List and 
	         move it one by one to find the first node which is 
	         part of the Linked List */
	        ptr1 = curr;
	        while (1 == 1) {
	            /* Now start a pointer from loop_node and check if it ever 
	             reaches ptr2 */
	            ptr2 = loop;
	            while (ptr2.next != loop && ptr2.next != ptr1) {
	                ptr2 = ptr2.next;
	            }
	            /* If ptr2 reahced ptr1 then there is a loop. So break the 
	             loop */
	            if (ptr2.next == ptr1) {
	                break;
	            }
	            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
	            ptr1 = ptr1.next;
	        }
	        /* After the end of loop ptr2 is the last node of the loop. So 
	         make next of ptr2 as NULL */
	        ptr2.next = null;
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
		RemoveLoopFromLinkedList dcsp = new RemoveLoopFromLinkedList();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(9);
		ListNode f = new ListNode(6);
		a.next = b; b.next = c; c.next = d; d.next=e; e.next = f;
		dcsp.printLinkedList(a); // 2 3 5 1 9 6 
		//System.out.println(dcsp.detectStartPoint(a).val); // 2
		System.out.println(dcsp.detectStartSlowFast(a).val); // 2
		ListNode k = new ListNode(2);
		ListNode l = new ListNode(3);
		ListNode m = new ListNode(5);
		ListNode n = new ListNode(1);
		ListNode o = new ListNode(9);
		ListNode p = new ListNode(6);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = l;
		//dc.printLinkedList(l);
		//System.out.println(dcsp.detectStartPoint(k).val); // 3
		dcsp.printLinkedList(dcsp.detectStartSlowFast(k)); // 3
	}

}
