package linklist1_230223;

import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50147/assignment/problems/159/?navref=cl_pb_nv_tb
public class CopyList {

	public RandomListNode approach1(RandomListNode a) { // works but Scaler does not accept
		HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
		RandomListNode p1 = a;
		RandomListNode p2 = new RandomListNode(a.label);
		RandomListNode temp = a;
		while(temp != null) {
			p2.label = a.label;
			p2.next = a.next;
			temp = temp.next;
		}
		printLinkedList(p2);

		hm.put(p1, p2);
		while(temp != null) {
			p2.label = a.label;
			p2.random = hm.get(p1.random);
			temp = temp.next;
		}
		p2.random = hm.get(p1.random);
		printLinkedListRandom(p2);
		return p2;
	}
	public RandomListNode approach2(RandomListNode a) {
		RandomListNode p2 = new RandomListNode(a.label);
		return p2;
	}
	public RandomListNode disc(RandomListNode a) { // check again
		RandomListNode temp = a;
		while(temp!=null) {
			RandomListNode curr = new RandomListNode(temp.label);
			RandomListNode fut = temp.next;
			temp.next = curr;
			curr.next = fut;
			temp = temp.next.next;
		}
		temp = a;
		while(temp!=null) {
			if(temp.random != null) {
				temp.next.random = temp.random.next;
			}
			temp = temp.next.next;
		}
		RandomListNode i = a;
		RandomListNode j = a.next;
		
		RandomListNode k = a.next;
		while(i!=null) {
			RandomListNode l = null;
			if(i !=null && i.next != null) {
				l = i.next.next;
			}
			RandomListNode m = null;
			if(j !=null && j.next != null) {
				m = j.next.next;
			}
			i.next = l;
			j.next = m;
			i = l;
			j = m;
		}
		return k;
	}
	public void printLinkedList(RandomListNode head) {
		RandomListNode temp = head;
		while(temp != null) {
			System.out.print(temp.label +" ");
			temp = temp.next;
		} System.out.println();
	}
	public void printLinkedListRandom(RandomListNode head) {
		RandomListNode temp = head;
		while(temp != null) {
			System.out.print(temp.label +" ");
			temp = temp.random;
		} System.out.println();
	}
	  public RandomListNode copyRandomList(RandomListNode head) {

	        // Step 1 : Insertion
	        RandomListNode t = head;

	        while( t != null){
	            RandomListNode n1 = new RandomListNode(t.label);
	            RandomListNode tp1 = t.next;
	            t.next = n1;
	            n1.next = tp1;
	            t = t.next.next;
	        }

	        // Step 2 : Setting the random pointer

	        t = head;
	        while( t != null){
	           if(t.random != null){
	               t.next.random = t.random.next;
	           }
	           t = t.next.next;
	        }

	        //Step 3 : Segregating old and new list seperating them

	        RandomListNode t1 = head;
	        RandomListNode t2 = head.next;

	        RandomListNode newHead = head.next;

	        while( t1 != null){
	            RandomListNode t1p1 = null;
	           
	            if( t1 != null && t1.next != null){
	                 t1p1 = t1.next.next;  
	            }
	                   
	            RandomListNode t2p1 = null;

	             if( t2 != null && t2.next != null){
	                t2p1 = t2.next.next;
	             }
	           
	            t1.next = t1p1;
	            t2.next = t2p1;

	            t1 = t1p1;
	            t2 = t2p1;
	        }

	        return newHead;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyList cl = new CopyList();
		RandomListNode a = new RandomListNode(2);
		RandomListNode b = new RandomListNode(3);
		RandomListNode c = new RandomListNode(5);
		RandomListNode d = new RandomListNode(1);
		RandomListNode e = new RandomListNode(9);
		RandomListNode f = new RandomListNode(1);
		RandomListNode g = new RandomListNode(6);
		RandomListNode h = new RandomListNode(4);
		a.next = b; b.next = c; c.next = d; d.next=e;
		e.next = f; f.next = g; g.next = h; 
		a.random = c; c.random = f; f.random = g; g.random = d;
		d.random = b;b.random = e; e.random = a; h.random = null;
		cl.printLinkedList(a);
		//cl.printLinkedList(cl.copyRandomList(a));
		cl.printLinkedList(cl.disc(a));

	}

}
class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
};