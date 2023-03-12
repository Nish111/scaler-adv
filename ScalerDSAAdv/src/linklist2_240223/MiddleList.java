package linklist2_240223;
// 
public class MiddleList {

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
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
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
		MiddleList ml = new MiddleList();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(9);
		ListNode f = new ListNode(6);
		a.next = b; b.next = c; c.next = d; d.next=e; e.next = f;
		ml.printLinkedList(a); // 2 3 5 1 9 6 
		System.out.println(ml.middleOfLinkedList(a)); // 5
		System.out.println(ml.middleOfLinkedList(d)); // 9
		System.out.println(ml.slowFast(a)); // 5
		System.out.println(ml.slowFast(d)); // 9
	}

}
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }}