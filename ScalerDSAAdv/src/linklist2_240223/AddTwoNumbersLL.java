package linklist2_240223;
// https://www.scaler.com/academy/mentee-dashboard/class/50148/homework/problems/38
public class AddTwoNumbersLL {
	public ListNode addTwoNumbers(ListNode A, ListNode B) { // O(n) O(n)
		if(A == null) return B;
		if(B==null) return A;
		ListNode res = new ListNode(0);
		ListNode head = res;
		ListNode slow = A;
		ListNode fast = B;
		int sum=0, temp=0, carry=0;
		while(slow != null && fast != null) {
			sum*=10;
			temp = slow.val+fast.val+carry;
			if(temp>=10) {
				carry =1; temp=temp%10;
			} else carry=0;
			sum+=temp;
			res.next = new ListNode(temp);
			res = res.next;
			slow = slow.next;
			fast = fast.next;
		}
		while(slow!=null) {
			sum*=10;
			temp = slow.val+carry;
			if(temp>=10) {
				carry =1; temp=temp%10;
			} else carry=0;
			sum+=temp;
			res.next = new ListNode(temp);
			res = res.next;
			slow = slow.next;
		}
		while(fast!=null) {
			sum*=10;
			temp = fast.val+carry;
			if(temp>=10) {
				carry =1; temp=temp%10;
			} else carry=0;
			sum+=temp;
			res.next = new ListNode(temp);
			res = res.next;
			fast = fast.next;
		}
		if(carry==1) {
			sum=sum+carry;
			res.next=new ListNode(carry);
		}
		//System.out.println(sum);
		return head.next;
	}
	public void printLinkedList(ListNode head) { // if cycle then no null is next so not 
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		} System.out.println();
	}
	public ListNode addTwoNumbersScalerSol(ListNode A, ListNode B) {
        ListNode node;
        ListNode prev = null;
        ListNode first = null;
        int carry = 0;
        int sum = 0;
        while (A != null || B != null || carry != 0) {
            node = new ListNode(0);
            // finds the value of each node
            sum = carry;
            if (first == null)
                first = node;
            if (prev != null)
                prev.next = node;
            if (A != null) {
                sum += A.val;
                A = A.next;
            }
            if (B != null) {
                sum += B.val;
                B = B.next;
            }
            node.val = sum % 10;
            sum /= 10;
            carry = sum;
            prev = node;
        }
        return first;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbersLL ad = new AddTwoNumbersLL();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(4);
		a.next = b; b.next = c; d.next=e; e.next = f;
		ad.printLinkedList(a);
		ad.printLinkedList(d);
		ad.printLinkedList(ad.addTwoNumbers(a, d)); // false
		ListNode k = new ListNode(9);
		ListNode l = new ListNode(9);
		ListNode m = new ListNode(1);
		ListNode n = new ListNode(1);
		ListNode o = new ListNode(9);
		ListNode p = new ListNode(6);
		k.next = l; 
		ad.printLinkedList(k);
		ad.printLinkedList(ad.addTwoNumbers(k, m));
	}

}
