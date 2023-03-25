package trees5_220323;

import java.util.ArrayList;
import java.util.Stack;

// https://www.scaler.com/academy/mentee-dashboard/class/70935/assignment/problems/335?navref=cl_tt_nv
public class KthSmallestElement {

	public int kthSmallestElement(TreeNode root, int k) { // O(N) O(N)
		int[] arr = inorderTraversalIterative(root);
		return arr[k-1];
	}
	public int[] inorderTraversalIterative(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		ArrayList<Integer> ar = new ArrayList<>();
		TreeNode curr = root;
		while(curr != null || !st.isEmpty()) {
			if(curr != null) {
				st.push(curr);
				curr = curr.left;
			} else {
				curr = st.pop();
				ar.add(curr.data);
				//System.out.print(curr.data +" ");
				curr = curr.right;
			}
		}
		System.out.println();
		Integer[] res = new Integer[ar.size()];
		int[] temp = new int[ar.size()];
		res = ar.toArray(res);
		for(int i=0; i<res.length; i++) 
			temp[i] = res[i];
		return temp;
	}
	static int k = 0;
    public int kthsmallestScalerSol(TreeNode A, int B) {
        k = B;
        return findScalerSol(A);
    }
    public static int findScalerSol(TreeNode root) {
        if (root == null)
            return -1;
        // We do an inorder traversal here. 
        int k1 = findScalerSol(root.left);
        if (k == 0)
            return k1; // left subtree has k or more elements.
        k--;
        if (k == 0)
            return root.data; // root is the kth element.
        return findScalerSol(root.right); // answer lies in the right node.
    }
	public static void main(String[] args) {
		KthSmallestElement kse = new KthSmallestElement();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		three.left = two;
		three.right = five;
		five.left = four;
		five.right = six;
		System.out.println(kse.kthSmallestElement(three, 2));// 3 --2 3 4 5 6 
		
	}

}
