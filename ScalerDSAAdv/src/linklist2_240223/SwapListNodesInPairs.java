package linklist2_240223;
// https://www.scaler.com/academy/mentee-dashboard/class/50148/homework/problems/31/?navref=cl_pb_nv_tb
public class SwapListNodesInPairs {

	public ListNode swapNodesInPairs(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode t1 = head;
		ListNode t2 = head.next;
		t1.next = t2.next;
		head = t2;
		t2.next = t1;
		ListNode temp = head.next;
		while(temp != null && temp.next != null && temp.next.next != null) {
			t1 = temp.next;
			t2 = temp.next.next;
			t1.next = t2.next;
			temp.next = t2;
			t2.next = t1;
			temp = temp.next.next;
		}
		return head;
	}
	public void printLinkedList(ListNode head) { // if cycle then no null is next so not 
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		} System.out.println();
	}
	public ListNode swapPairsScalerSol(ListNode A) {
        if (A == null)
            return null;
        A = recScalerSol(A);
        return A;
    }

    public ListNode recScalerSol(ListNode node) {
        ListNode nextNode;
        ListNode firstNode = node;
        ListNode prevNode = null;
        if (node.next != null)
            firstNode = node.next;
        while (!(node == null || node.next == null)) {
            // swap the two adjacent nodes
            nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = node;
            if (prevNode != null)
                prevNode.next = nextNode;
            prevNode = node;
            node = node.next;
        }
        return firstNode;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapListNodesInPairs slnp = new SwapListNodesInPairs();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(9);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(6);
		a.next = b; b.next = c; c.next = d; d.next=e;
		slnp.printLinkedList(a); // 2 1 9 3 6 
		slnp.printLinkedList(slnp.swapNodesInPairs(a)); // 1 2 3 9 6 
		ListNode k = new ListNode(31);
		ListNode l = new ListNode(23);
		ListNode m = new ListNode(99);
		ListNode n = new ListNode(76);
		ListNode o = new ListNode(81);
		ListNode p = new ListNode(61);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = p;
		slnp.printLinkedList(k); // 31 23 99 76 81 61 
		slnp.printLinkedList(slnp.swapNodesInPairs(k)); // 23 31 76 99 61 81 
	}

}
