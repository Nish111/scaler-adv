package trees1_130323;

import java.util.ArrayList;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/69489/homework/problems/229?navref=cl_tt_nv
public class PostorderTraversalAs {
	public int[] postorderTraversal(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		ArrayList<Integer> ar = new ArrayList<>();
		TreeNode curr = root;
		while(curr != null || !st.isEmpty()) {
			// for conditions of recursive
			while(curr != null) {
				st.push(curr);
				ar.add(curr.data);
				System.out.print(curr.data +" ");
				curr = curr.right;
			}
				// actual steps LST Root RST
				//if(st.isEmpty()) break;
				curr = st.pop();
				curr = curr.left;
		}
		System.out.println();
		// reverse of the printed is postorder
		
		Integer[] res = new Integer[ar.size()];
		int[] temp = new int[ar.size()];
		res = ar.toArray(res);
		// reverse the array as per POST
		for(int i=0; i<res.length; i++) {
			temp[i] = res[res.length-1-i];
		}
		return temp;
	}
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++)
			System.out.print(A[i] +" ");
		System.out.println();
	}
	public ArrayList<Integer> postorderTraversalScalerSol(TreeNode A) {
	    Stack<TreeNode> stack1, stack2;
	    ArrayList<Integer> postorder;
	    TreeNode node;
	    stack1 = new Stack<>();
	    stack2 = new Stack<>();
	    postorder = new ArrayList<>();
	    if (A == null)
	        return null;
	    stack1.push(A);
	    while (!stack1.isEmpty()) {
	        node = stack1.pop();
	        stack2.push(node);
	        if (node.left != null)
	            stack1.push(node.left);
	        if (node.right != null)
	            stack1.push(node.right);
	    }
	    while (!stack2.isEmpty()) {
	        node = stack2.pop();
	        postorder.add(node.data);
	    }
	    return postorder;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostorderTraversalAs iot = new PostorderTraversalAs();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		int[] A =iot.postorderTraversal(four); // 
		iot.printArray(A); // 5 3 6 2 4 
	}

}
