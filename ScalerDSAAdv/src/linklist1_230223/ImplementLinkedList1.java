package linklist1_230223;

// https://www.scaler.com/academy/mentee-dashboard/class/50147/assignment/problems/4367/?navref=cl_pb_nv_tb

public class ImplementLinkedList1 {
	static class Node{
	    int val; 
	    Node next;
	    public Node(int val){
	        this.val = val;
	    }
	}
static int size = 0;
static Node head = null;
static Node tail = null;
    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        Node node = new Node(value);
        if(position == 1 && head ==null && tail ==null) {
            node.next = head;
            head = node;
            tail = node;
        }
        else if(position ==1){
            node.next = head;
            head = node;
        } else if (position == size+1){
            tail.next = node;
            tail = node;
        }
        else if(position >1 && position <=size){
            int count = 0;
            Node temp = head;
            Node prev = null;
            while(temp != null && count+1 < position){
                prev = temp;
                temp = temp.next;
                count++;
            }
            prev.next = node; 
            node.next = temp;
           
        }
        else {
            size--;
        }
        size++;
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position == 1) head = head.next;
        else if(position >1 && position <= size){
            Node prev = null;
            Node temp = head;
            int count = 0;
	            while (temp != null && count + 1 < position) {  
	                prev = temp;
	                temp = temp.next;
	                count++;
	            }

	            prev.next = temp.next;
	            if (size == position) { 
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
    	Node curr = head;
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

 }
