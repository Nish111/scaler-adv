package trees4_220323;

import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/71401/assignment/problems/35981?navref=cl_tt_lst_sl
public class LCAInOut {
	int t = 0;
	HashMap<TreeNode, Integer> in = new HashMap<>();
	HashMap<TreeNode, Integer> out = new HashMap<>();
	public int findLCAInOut(TreeNode root, int x, int y) {
		TreeNode curr = root;
		while(curr != null) {
			if(x<curr.data && y<curr.data) {
				curr = curr.left;
			} else if(x>curr.data && y>curr.data) {
				curr = curr.right;
			} else return curr.data;
		}
		return 0;
	}
	public void travel(TreeNode root) { // not used
		if(root==null) return;
		in.put(root, t); t++;
		travel(root.left);
		travel(root.right);
		out.put(root, t); t++;
	}
	 public int solveScalerSol(TreeNode A, int B, int C) {
	        if (A.data > B && A.data > C)
	        return solveScalerSol(A.left, B, C);
	 
	        if (A.data < B && A.data < C)
	            return solveScalerSol(A.right, B, C);
	     
	        return A.data;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCAInOut lca = new LCAInOut();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = three;
		four.right = five;
		three.left = two;
		five.right = six;
		System.out.println(lca.findLCAInOut(four, 2, 3)); // 3
		System.out.println(lca.findLCAInOut(four, 2, 6)); // 4

	}

}
