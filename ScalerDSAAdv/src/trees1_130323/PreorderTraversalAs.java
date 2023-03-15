package trees1_130323;

import java.util.ArrayList;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/69489/homework/problems/222?navref=cl_tt_lst_sl
public class PreorderTraversalAs {
	public int[] preorderTraversal(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		ArrayList<Integer> ar = new ArrayList<>();
		TreeNode curr = root;
		while(curr != null || !st.isEmpty()) {
			// for conditions of recursive
			if(curr != null) {
				System.out.print(curr.data +" ");
				ar.add(curr.data);
				st.push(curr);
				curr = curr.left;
			} else {
				// actual steps LST Root RST
				curr = st.pop();
				//ar.add(curr.data);
				curr = curr.right;
			}
		}
		System.out.println();
		
		Integer[] res = new Integer[ar.size()];
		int[] temp = new int[ar.size()];
		res = ar.toArray(res);
		for(int i=0; i<res.length; i++) {
			temp[i] = res[i];
		}
		return temp;
	}
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++)
			System.out.print(A[i] +" ");
		System.out.println();
	}
	  public ArrayList < Integer > preorderTraversalScalerSol(TreeNode A) {
		    ArrayList < Integer > res = new ArrayList < Integer > ();
		    Stack < TreeNode > stack = new Stack < > ();
		    if (A == null)
		      return res;
		    stack.push(A);
		    TreeNode node;
		    while (!stack.isEmpty()) {
		      node = stack.pop();
		      res.add(node.data);
		      if (node.right != null)
		        stack.push(node.right);
		      if (node.left != null)
		        stack.push(node.left);
		    }
		    return res;
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreorderTraversalAs iot = new PreorderTraversalAs();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		int[] A =iot.preorderTraversal(four); // 5 4 3 2 6 
		iot.printArray(A); // 5 4 3 2 6 
	}

}
