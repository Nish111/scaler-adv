package linklist3_270223;
// https://www.scaler.com/academy/mentee-dashboard/class/50149/homework/problems/41/hints?navref=cl_pb_nv_tb/
public class PartitionList {

	public ListNode partition(ListNode A, int B) { // working now
		// make 2 LL and join them
		ListNode head = A;
		ListNode res = head;
		ListNode small = null, smallHead = null;
		ListNode large = null, largeHead = null;
		while(A != null) {
			if(A.val<B) {
				if(small== null) {
					small = A;
					smallHead = A;
					//System.out.println("value of A "+A.val);
				} else {
					small.next = A;
					small = small.next;
					//System.out.println("value of A "+A.val);
				}
				//small.next = null;
				//System.out.println("small");
				//printLinkedList(small);
			} else {
				if(large == null) {
					large = A;
					largeHead = A;
					//System.out.println("value of A "+A.val);
				} else {
					large.next = A;
					large = large.next;
					//System.out.println("value of A "+A.val);
				}
				//large.next = null;
				//System.out.println("large");
				//printLinkedList(large);
			}
			A = A.next;
			//printLinkedList(small);
			//printLinkedList(large);
		}
		//System.out.println(A.val);
		//System.out.println(large.val);
		/*
		 * -- initally did A.next != null above so below was needed
		 * if(A != null) { if(A.val<B) { if(small != null) { small.next = A; } else {
		 * small = A; smallHead = A; } small = small.next; } else { if(large != null) {
		 * large.next = A; } else { large = A; largeHead = A;
		 * //System.out.println(large.val); } large = large.next;
		 * //System.out.println(large.val); } }
		 */
		//System.out.println(large.val);
		//System.out.println(small.val);
		if(large != null) {
			large.next = null;
		}

		if(small != null) {
			small.next = largeHead;
			//smallHead.next = largeHead;
		} else if(smallHead == null) {
			return largeHead;
		}
		else {
			small=largeHead;
		}
		res = smallHead;
		return res;
    }
	public void printLinkedList(ListNode head) { // if cycle then no null is next so not 
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		} System.out.println();
	}
	 public ListNode partitionScalerSol(ListNode A, int B) {
	        ListNode lessPrev = null;
	        ListNode greaterPrev = null;
	        ListNode head = A;
	        ListNode greaterHead = null;
	        while (A != null) {
	            if (A.val < B) {
	                // contains the node with value < B
	                if (lessPrev != null) {
	                    // append A to the list
	                    lessPrev.next = A;
	                    lessPrev = A;
	                } else {
	                    // A is the starting node
	                    lessPrev = A;
	                    head = A;
	                }
	            } else {
	                // contains the node with value >= B
	                if (greaterPrev != null) {
	                    // append A to the list
	                    greaterPrev.next = A;
	                    greaterPrev = A;
	                } else {
	                    // A is the starting node
	                    greaterPrev = A;
	                    greaterHead = A;
	                }
	            }
	            A = A.next;
	        }
	        if (greaterPrev != null)
	            greaterPrev.next = null;
	        if (lessPrev != null) {
	            lessPrev.next = greaterHead;
	        }
	        return head;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionList pl = new PartitionList();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(2);
		//ListNode g = new ListNode(6);
		a.next = b; b.next = c; c.next = d; d.next=e; e.next = f;// f.next = g;
		pl.printLinkedList(a);
		ListNode z = pl.partition(a, 3);
		System.out.println("output ");
		pl.printLinkedList(z);
		ListNode p = new ListNode(1);
		ListNode q = new ListNode(2);
		ListNode r = new ListNode(3);
		ListNode s = new ListNode(4);
		ListNode t = new ListNode(5);
		//ListNode u = new ListNode(6);
		p.next=q; q.next = r; r.next=s;s.next=t;//t.next=u;
		pl.printLinkedList(p);
		ListNode y = pl.partition(p, 5);
		System.out.println("output ");
		pl.printLinkedList(y);
		ListNode l = new ListNode(1);
		l.next = null;
		pl.printLinkedList(l);
		ListNode x = pl.partition(l, 1);
		System.out.println("output ");
		pl.printLinkedList(x);
		ListNode m=new ListNode(31);
		ListNode n=new ListNode(384);
		ListNode o=new ListNode(183);
		ListNode mn=new ListNode(463);
		m.next=n;n.next=o;o.next=mn;
		pl.printLinkedList(m);
		ListNode v = pl.partition(m, 77);
		System.out.println("output ");
		pl.printLinkedList(v);
		ListNode ma=new ListNode(31);
		ListNode na=new ListNode(384);
		ListNode oa=new ListNode(183);
		ListNode mna=new ListNode(463);
		mna.next=oa;oa.next=na;na.next=ma;
		pl.printLinkedList(mna);
		ListNode vv = pl.partition(mna, 77);
		System.out.println("output ");
		pl.printLinkedList(vv);
	}

}
/*
class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
*/