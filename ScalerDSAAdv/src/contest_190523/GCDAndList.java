package contest_190523;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
// https://www.scaler.com/test/745654aa9c/#/problem_1
public class GCDAndList {
    public ListNode solve(ListNode A) {
        ListNode head = A;
        //int temp = A;
        while(head != null){
            int value1 = head.val;
            if(head.next != null){
                int value2 = head.next.val;
                int gcd = findGcd(value1, value2);
                ListNode temp = new ListNode(gcd);
                temp.next = head.next;
                head.next = temp;
                head = head.next;
            }
            head = head.next;
            
        }
        return A;
    }
    public int findGcd(int value1, int value2){
        if(value2==0) return value1;
        else return findGcd(value2, value1%value2);
        
    }
}
class ListNode {
	    public int val;
	    public ListNode next;
	     ListNode(int x) { val = x; next = null; }
}
