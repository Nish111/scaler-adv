package contest310323;

// https://www.scaler.com/test/a5420ce6fd/#/problem_2
public class NextInLine1 {

	public ListNode solve(ListNode A, int B) { // Correct
		
		ListNode head = A;
		ListNode temp = A;
		int fixedValue = 0;
		while(temp!= null) {
			if(temp.val %B ==0) {
				fixedValue=temp.val;
				changeValuesPrior(head, fixedValue);
				head = temp.next;
			}
			temp=temp.next;
		}
		
		return A;
	}
	public void changeValuesPrior(ListNode head, int fixedValue) {
		while(head.val != fixedValue) {
			head.val=fixedValue;
			head= head.next;
		}
	}
	public ListNode solveScalerSol(ListNode A, int B) { // looks complicated than mine
		ListNode ans;
		ans = A;
		ListNode i, j;
		i = A; j=A;
		while(j!=null) {
			while(j!=null && j.val%B!=0) {
				j=j.next;
			}
			if(j==null) break;
			while(i!=j) {
				i.val=j.val;
				i=i.next;
			}
			i=i.next; j=j.next;
		}
		return ans;
	}
	public void printList(ListNode A) {
		while(A!= null) {
			System.out.print(A.val+" ");
			A=A.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		NextInLine1 nil = new NextInLine1();
		ListNode one = new ListNode(1);
		ListNode three = new ListNode(3);
		ListNode five = new ListNode(5);
		ListNode three1 = new ListNode(3);
		one.next=three; three.next=five; five.next=three1;
		nil.printList(one); // 1 3 5 3 
		ListNode A = nil.solve(one, 5);
		nil.printList(A); // 5 5 5 3 
		ListNode three2 = new ListNode(3);
		ListNode two = new ListNode(2);
		ListNode six = new ListNode(6);
		three2.next=two; two.next=six;
		nil.printList(three2); // 3 2 6 
		ListNode B = nil.solve(three2, 3);
		nil.printList(B); // 3 6 6 
	}
}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}