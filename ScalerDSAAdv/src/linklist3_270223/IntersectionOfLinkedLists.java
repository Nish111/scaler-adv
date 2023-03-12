package linklist3_270223;

import java.util.HashMap;

// https://www.scaler.com/academy/mentee-dashboard/class/50149/homework/problems/44?navref=cl_tt_nv
public class IntersectionOfLinkedLists {

	public ListNode getIntersectionNodeBrute (ListNode a, ListNode b) { // O(m*n)
		ListNode slow = a;
		ListNode fast = b;
		ListNode res = null;
		while(slow.next != null) {
			fast = b;
			//printLinkedList(fast);
			while(fast != null) {
				if(fast.val==slow.val) {
					//System.out.println(fast.val + " here ");
					res =  fast;
					//printLinkedList(fast);
					return fast;
				}
				fast = fast.next;
			}
			slow = slow.next;
		}
		return res;
	}
	public ListNode getIntersectionNode(ListNode a, ListNode b) { // O(n) O(m)
		HashMap<Integer, Integer> hmA = new HashMap<>();
		ListNode slow = a;
		int i=0;
		while(a != null) {
			hmA.put(i, a.val);
			a = a.next;
			i++;
		}
		ListNode fast = b;
		ListNode res = null;
		//printLinkedList(fast);
		while(fast != null) {
			if(hmA.containsKey(fast.val)) {
				//System.out.println(fast.val + " here ");
				res =  fast;
				//printLinkedList(fast);
				return fast;
			}
			fast = fast.next;
		}
		return res;
	}
	public ListNode getIntersectionNodeOptimized(ListNode a, ListNode b) { // O(n) O(1)
		
		ListNode p1 = a;
		ListNode p2 = b;
		int lengthA=0, lengthB=0;
		while(p1 != null) {
			p1 = p1.next;
			lengthA++;
		}
		while(p2 != null) {
			p2 = p2.next;
			lengthB++;
		}
		p1 = a;
		p2 = b;
		//printLinkedList(p1);
		//printLinkedList(p2);
		int diff = 0, i=0;
		if(lengthA>lengthB) {
			diff = lengthA-lengthB;
			while(i<diff) {
				p1 = p1.next;
				i++;
			}
			//printLinkedList(p1);
		}
		else {
			diff = lengthB-lengthA;
			while(i<diff) {
				p2 = p2.next;
				i++;
			}
		}
		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	public ListNode getIntersectionNodeScalerSol(ListNode A, ListNode B) {
	    ListNode lastA, lastB;
	    int countA, countB;
	    
	    if (A == null || B == null)
	        return null;
	    
	    countA = countB = 1;
	    
	    lastA = A;
	    lastB = B;
	    
	    while (lastA.next != null) {
	        lastA = lastA.next;
	        countA++;
	    }
	    
	    while (lastB.next != null) {
	        lastB = lastB.next;
	        countB++;
	    }
	    
	    if (!lastA.equals(lastB))
	        return null;
	    
	    int diff = Math.abs(countA - countB);
	    
	    lastA = A;
	    lastB = B;
	    
	    if (countA > countB) {
	        while (diff-- > 0) {
	            lastA = lastA.next;
	        }
	    } else {
	        while (diff-- > 0)
	            lastB = lastB.next;
	    }
	    
	    while (!lastA.equals(lastB)) {
	        lastA = lastA.next;
	        lastB = lastB.next;
	    }
	    
	    return lastA;
	    
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
		IntersectionOfLinkedLists ioll = new IntersectionOfLinkedLists();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode g = new ListNode(6);
		a.next = b; b.next = c; c.next = d; d.next=e;
		g.next = c;
		ioll.printLinkedList(a); // 1 2 3 4 5 
		ioll.printLinkedList(g); // 6 3 4 5 
		ListNode f = ioll.getIntersectionNodeBrute(a, g); 
		ioll.printLinkedList(f); // 3 4 5 
		ListNode h = ioll.getIntersectionNode(a, g); 
		ioll.printLinkedList(h); // 3 4 5 
		ListNode i = ioll.getIntersectionNodeOptimized(a, g); 
		ioll.printLinkedList(i); // 3 4 5 
		ListNode k = new ListNode(1);
		ListNode l = new ListNode(2);
		ListNode m = new ListNode(3);
		k.next = l; l.next = m;
		ListNode n = new ListNode(4);
		ListNode o = new ListNode(5);
		n.next=o;
		ioll.printLinkedList(k); // 1 2 3 
		ioll.printLinkedList(n); // 4 5 
		ListNode p=ioll.getIntersectionNodeBrute(k, n); 
		ioll.printLinkedList(p); // null
		ListNode q=ioll.getIntersectionNode(k, n); 
		ioll.printLinkedList(q); // null
		ListNode r = ioll.getIntersectionNodeOptimized(k, n); 
		ioll.printLinkedList(r); // null
	}

}
