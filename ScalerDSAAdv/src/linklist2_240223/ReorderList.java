package linklist2_240223;
// https://www.scaler.com/academy/mentee-dashboard/class/50148/homework/problems/31/?navref=cl_pb_nv_tb
public class ReorderList {

	public ListNode reorderNodeSpace(ListNode head) { // O(N) O(N)
		// extra space  
		// working
		if(head == null || head.next == null) return head;
		int count=1;
		ListNode tail = head;
		while(tail.next != null) {
			tail = tail.next;
			count++;
		}
		ListNode t1 = head;
		ListNode[] arr = new ListNode[count];
		for(int i=0; i<count; i++) {
			arr[i] = t1;
			t1 = t1.next;
		}
		ListNode t2 = head;
		ListNode t3 = t2;
		t2.next = arr[count-1];
		t2 = t2.next;
		for(int i=1; i<(count+1)/2; i++) {
			t2.next = arr[i];
			t2 = t2.next;
			t2.next = arr[count-i-1];
			t2 = t2.next;
		}
		//if(count %2 ==1) t2.next = 
		t2.next = null;
		return t3;
	}
	public ListNode reorderNodes(ListNode head) { // O(N) O(1) -- still error for few
		if(head == null || head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head;
		int count=1;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			count++;
		}
		ListNode mid = slow.next;
		slow.next = null;
		ListNode reversed = reverse(mid);
		//System.out.println("head");
		//printLinkedList(head);
		ListNode temp = head;
		ListNode p1 = head.next;
		ListNode p3 = reversed;
		//System.out.println("rever");
		//printLinkedList(p3);
		//System.out.println(temp.val);
		while(p1 != null && p3 != null) {
			temp.next = p3;
			//System.out.println(temp.val);
			temp = temp.next;
			p3 = p3.next;
			//System.out.println(temp.val);
			temp.next = p1;
			//System.out.println(temp.val);
			temp = temp.next;
			//System.out.println(temp.val);
			p1 = p1.next;
		}
		// added this still failing
		//System.out.println(count);
		//System.out.println(fast.val);
		if(count==1) {
			//System.out.println("here");
			temp.next = p3;
			temp = temp.next;
		}
		 if(fast.next != null && fast.next.next ==null && p3 != null) {
				temp.next = p3;
				temp = temp.next;
		}
		temp.next = null;
		//System.out.println("print");
		//printLinkedList(head);
		//temp.next = p1;
		return head;
	}
	public ListNode reverse(ListNode head) {
		if (head.next == null) return head;
        ListNode cur = head, nextNode = head.next, tmp;
        while (nextNode != null) {
            tmp = nextNode.next;
            nextNode.next = cur;
            cur = nextNode;
            nextNode = tmp;
        }
        head.next = nextNode;
       // System.out.println("cur");
        //printLinkedList(cur);
        return cur;
	}
	public void printLinkedList(ListNode head) { // if cycle then no null is next so not 
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		} System.out.println();
	}
	public ListNode reorderListScalerSol(ListNode head) {
        int sz = 0;
        ListNode tmp = head;
        while (tmp != null) {
            sz++;
            tmp = tmp.next;
        }
        if (head == null || head.next == null || head.next.next == null)
            return head;
        //find the middle of the list, and split into two lists.    
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        //reverse from the middle to the end
        ListNode secondHalfReversed = reverseLinkedListScalerSol(mid);
        //merge these two list
        return head = mergeTwoListsScalerSol(head, secondHalfReversed);
    }

    public ListNode mergeTwoListsScalerSol(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = l1; // head of the list to return
        l1 = l1.next;
        ListNode p = head; // pointer to form new list
        // A boolean to track which list we need to extract from. 
        // We alternate between first and second list. 
        boolean curListNum = true;
        while (l1 != null && l2 != null) {
            if (curListNum == false) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
            if (curListNum) curListNum = false;
            else curListNum = true;
        }
        // add the rest of the tail, done!
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return head;
    }

    ListNode reverseLinkedListScalerSol(ListNode head) {
        if (head.next == null) return head;
        ListNode cur = head, nextNode = head.next, tmp;
        while (nextNode != null) {
            tmp = nextNode.next;
            nextNode.next = cur;
            cur = nextNode;
            nextNode = tmp;
        }
        head.next = nextNode;
        return cur;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList rol = new ReorderList();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(9);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(6);
		a.next = b; b.next = c; c.next = d; d.next=e;
		rol.printLinkedList(a); // 2 1 9 3 6 
		rol.printLinkedList(rol.reorderNodes(a)); // 1 2 3 9 6 
		rol.printLinkedList(rol.reorderNodeSpace(a)); // 2 6 1 3 9 
		ListNode k = new ListNode(31);
		ListNode l = new ListNode(23);
		ListNode m = new ListNode(99);
		ListNode n = new ListNode(76);
		ListNode o = new ListNode(81);
		ListNode p = new ListNode(61);
		k.next = l; l.next = m; m.next = n; n.next=o; o.next = p;
		rol.printLinkedList(k); // 31 23 99 76 81 61 
		rol.printLinkedList(rol.reorderNodes(k)); // 23 31 76 99 61 81 
		rol.printLinkedList(m); // 99 76 
		rol.printLinkedList(rol.reorderNodes(m)); // 99 -wrong
		rol.printLinkedList(k); // 31 61 23 81 99 
		rol.printLinkedList(rol.reorderNodeSpace(k)); // 31 99 61 81 23 
	}

}
