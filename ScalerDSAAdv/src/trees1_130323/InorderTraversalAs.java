package trees1_130323;

import java.util.ArrayList;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/69489/assignment/problems/214?navref=cl_tt_lst_sl
public class InorderTraversalAs {
	public int[] inorderTraversalIterative(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		ArrayList<Integer> ar = new ArrayList<>();
		TreeNode curr = root;
		while(curr != null || !st.isEmpty()) {
			// for conditions of recursive
			if(curr != null) {
				st.push(curr);
				curr = curr.left;
			} else {
				// actual steps LST Root RST
				//if(st.isEmpty()) break;
				curr = st.pop();
				ar.add(curr.data);
				System.out.print(curr.data +" ");
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
	// Threaded binary tree Morris traversal
		public ArrayList<Integer> inorderTraversalScalerSol(TreeNode A) {
		    TreeNode current, node;
		    ArrayList<Integer> res = new ArrayList<>();
		    current = A;
		    while (current != null) {
		        if (current.left == null) {
		            res.add(current.data);
		            current = current.right;
		        } else {
		            node = current.left;
		            while (node.right != null && !current.equals(node.right))
		                node = node.right;
		            
		            if (node.right == null) {
		                node.right = current;
		                current = current.left;
		            } else {
		                current = node.right;
		                node.right = null;
		                res.add(current.data);
		                current = current.right;
		            }
		        }
		    }
		    return res;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InorderTraversalAs iot = new InorderTraversalAs();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		int[] A =iot.inorderTraversalIterative(four); // 5 4 3 2 6 
		iot.printArray(A); // 5 4 3 2 6 
	}

}
