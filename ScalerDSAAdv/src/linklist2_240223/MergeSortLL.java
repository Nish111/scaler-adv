package linklist2_240223;
// https://www.scaler.com/academy/mentee-dashboard/class/50148/assignment/problems/34/?navref=cl_pb_nv_tb
public class MergeSortLL {

	public ListNode mergeSortForLL(ListNode head) {
		//printLinkedList(head);
		if(head == null || head.next == null) return head;
		ListNode mid = findMiddle(head);
		ListNode h2 = mid.next;
		mid.next = null;
		head = mergeSortForLL(head);
		h2 = mergeSortForLL(h2);
		return mergeSortedLL(head, h2);
		//return head; // head is pointing to different node so does not work
	}
	public ListNode findMiddle(ListNode head) { // O(n ) // is slowFast from MiddleList class
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	public ListNode mergeSortedLL(ListNode h1, ListNode h2) { // O(m+n) O(1)
		ListNode head = new ListNode(-1);
		ListNode temp = head;
		while(h1 != null && h2 != null) {
			if(h1.val <= h2.val) {
				temp.next = h1;
				h1 = h1.next;
				temp = temp.next;
				//printLinkedList(temp);
			} else {
					temp.next = h2;
					h2 = h2.next;
					temp = temp.next;
					//printLinkedList(temp);
			}
		}
		if(h1 != null) temp.next = h1;
		else temp.next = h2;
		head = head.next;
		return head;
	}
	public void printLinkedList(ListNode head) { // if cycle then no null is next so not 
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		} System.out.println();
	}
	public ListNode sortListScalerSol(ListNode A) {
        if (A == null || A.next == null)
            return A;
        ListNode first = A;
        // find the middle node
        ListNode second = findMidNode(A);
        first = sortListScalerSol(first);
        second = sortListScalerSol(second);
        ListNode res = mergeNodesScalerSol(first, second);
        return res;

    }

    public ListNode mergeNodesScalerSol(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (node1 != null && node2 != null) {
            // find the smaller node
            if (node1.val <= node2.val) {
                dummy.next = node1;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }
        // add the remaining nodes
        dummy = addNodesScalerSol(dummy, node1);
        addNodesScalerSol(dummy, node2);
        head = head.next;
        return head;
    }

    public ListNode addNodesScalerSol(ListNode node, ListNode node1) {
        while (node1 != null) {
            node.next = node1;
            node1 = node1.next;
            node = node.next;
        }
        return node;
    }

    public ListNode findMidNode(ListNode node) {
        ListNode doubleRate;
        ListNode prev;
        if (node == null || node.next == null)
            return node;
        doubleRate = node;
        prev = node;
        while (doubleRate.next != null && doubleRate.next.next != null) {
            prev = node;
            node = node.next;
            doubleRate = doubleRate.next.next;
        }
        prev = node;
        node = node.next;
        prev.next = null;
        return node;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortLL msll = new MergeSortLL();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(9);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(5);
		a.next = b; b.next = c; c.next = d; d.next=e; e.next = f;
		msll.printLinkedList(a);
		msll.printLinkedList(msll.mergeSortForLL(a));
		ListNode k = new ListNode(31);
		ListNode l = new ListNode(23);
		ListNode m = new ListNode(99);
		ListNode n = new ListNode(76);
		ListNode o = new ListNode(81);
		ListNode p = new ListNode(61);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = p;
		msll.printLinkedList(k);
		msll.printLinkedList(msll.mergeSortForLL(k));
	}

}
