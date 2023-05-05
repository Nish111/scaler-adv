package trees3_170323;

import java.util.ArrayList;
import java.util.Stack;

// https://www.scaler.com/academy/mentee-dashboard/class/70934/homework/problems/4679?navref=cl_tt_lst_nm
public class BSTInRange {

	public int solve(TreeNode A, int B, int C) {
		/*TreeNode head  = A;
		TreeNode start = A;
		while(head.left != null & head.left.data>=B) {
			start = head.left;
			head = head.left;
		}
		System.out.println(start.data);
		head  = A;
		TreeNode end = A;
		while(head.right != null & head.right.data<=C) {
			end = head.right;
			head = head.right;
		}
		System.out.println(end.data);
		*/
		int count=0;
		Stack<TreeNode> st = new Stack<>();
		ArrayList<Integer> ar = new ArrayList<>();
		TreeNode curr = A;
		while(curr != null || !st.isEmpty()) {
			// for conditions of recursive
			if(curr != null) {
				//System.out.print(curr.data +" ");
				ar.add(curr.data);
				if(curr.data>=B && curr.data<=C) count++;
				st.push(curr);
				curr = curr.left;
			} else {
				// actual steps LST Root RST
				curr = st.pop();
				//ar.add(curr.data);
				curr = curr.right;
			}
		}
		
		return count;
    }
	 static int ans = 0;
	    public int solveScalerSol(TreeNode A, int B, int C) {
	        ans = 0;
	        traverseScalerSol(A, B, C);
	        return ans;
	    }
	    public static void traverseScalerSol(TreeNode a, int B, int C) {
	        if (a == null)
	            return;
	        if (a.data >= B && a.data <= C)
	            ans++;
	        traverseScalerSol(a.left, B, C);
	        traverseScalerSol(a.right, B, C);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTInRange bst = new BSTInRange();
		TreeNode eight = new TreeNode(8);
		TreeNode six = new TreeNode(6);
		TreeNode one = new TreeNode(1);
		TreeNode twoone = new TreeNode(21);
		TreeNode seven = new TreeNode(7);
		eight.left = six;
		eight.right = twoone;
		six.left = one;
		six.right = seven;
		System.out.println(bst.solve(eight, 2, 20));
	}

}
