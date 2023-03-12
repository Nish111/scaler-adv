package linklist1_230223;

import java.util.HashMap;

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
		cl.printLinkedList(cl.approach1(a));

	}

}
class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
};