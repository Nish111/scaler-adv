package linklist1_230223;

public class ImplementLinkedList {

	//Insert(position, value)
	//1} Very first node to be inserted in datastructure when size == 0
	//2} first node to be inserted when size != 0
	//3} node to be inserted after tail
	//4} node to be inserted somewhere between head and tail
	//5} Invalid position

	//delete(position)
	//6} deleting head
	//7} deleting some node between head and tail
	//8} when deleted node is tail, update the tail
	    static int size = 0;
	    static ListNode head = null;
	    static ListNode tail = null;

	    public static void insert_node(int position, int value) {
	        // @params position, integer
	        // @params value, integer
	        ListNode node = new ListNode(value);

	        if (position == 1 && head == null && tail == null) {    //1}
	            node.next = head;
	            head = node;
	            tail = node;
	        }
	        else if (position == 1) {   //2}
	            node.next = head;
	            head = node;
	        }
	        else if (position == size+1) {  //3}
	            tail.next = node;
	            tail = node;
	        }
	        else if (position >= 2 && position <= size){    //4}
	            int count = 0;
	            ListNode curr = head;
	            ListNode prev = null;
	            while (curr != null && count + 1 < position) {
	                prev = curr;
	                curr = curr.next;
	                count++;
	            }
	            prev.next = node;
	            node.next = curr;
	        }
	        else {  //5}
	            size--;
	        }

	        size++;
	    }

	    public static void delete_node(int position) {
	        // @params position, integer
	        if (position == 1) {    //6}
	            head = head.next;
	        }  
	        else if (position >= 2 && position <= size){    //7}
	            ListNode prev = null;
	            ListNode curr = head;
	            int count = 0;
	            while (curr != null && count + 1 < position) {  
	                prev = curr;
	                curr = curr.next;
	                count++;
	            }

	            prev.next = curr.next;
	            if (size == position) { //8}
	                tail = prev;
	            }
	        }
	        else {
	            size++;
	        }

	        size--;
	    }

	    public static void print_ll() {
	        // Output each element followed by a space
	        ListNode curr = head;
	        while (curr != null) {
	            if (curr.next == null) {
	                System.out.print(curr.val);
	            }
	            else {
	                System.out.print(curr.val + " ");
	            }
	            curr = curr.next;
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * static class ListNode { int val; ListNode next;
 * 
 * public ListNode (int val) { this.val = val; } }
 */