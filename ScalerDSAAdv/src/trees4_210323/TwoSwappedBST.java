package trees4_220323;

import java.util.ArrayList;
import java.util.Stack;

// https://www.scaler.com/academy/mentee-dashboard/class/71401/assignment/problems/216?navref=cl_tt_nv
public class TwoSwappedBST {

	public void twoSwappedNodesBST(int[] root) {
		int first=-1, second=-1, index=0;
		for(int i=1; i<root.length; i++) {
			if(root[i]<root[i-1] && first == -1) {
				first = root[i-1];
				index=i-1;
				//System.out.println(index +" "+first);
			}
			else if(root[i]<root[i-1]) {
				second=root[i];
			}
		}
		if(second==-1) {
			System.out.println(root[index] +" "+root[index+1]);
		}
		else {
			System.out.println(first +" "+second);
		}
	}
	public int[] recoverTree(TreeNode root) { // assignment
		int[] trav = inorderTraversalIterative(root);
		int first=-1, second=-1, index=0;
		for(int i=1; i<trav.length; i++) {
			if(trav[i]<trav[i-1] && first == -1) {
				first = trav[i-1];
				index=i-1;
				//System.out.println(index +" "+first);
			}
			else if(trav[i]<trav[i-1]) {
				second=trav[i];
			}
		}
		if(second==-1) {
			return new int[] {trav[index+1], trav[index]};
		}
		else {
			return new int[] {second, first};
		}
	}
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
				//System.out.print(curr.data +" ");
				curr = curr.right;
			}
		}
		//System.out.println();
		
		Integer[] res = new Integer[ar.size()];
		int[] temp = new int[ar.size()];
		res = ar.toArray(res);
		for(int i=0; i<res.length; i++) {
			temp[i] = res[i];
		}
		return temp;
	}
	private TreeNode left;
    private TreeNode right;
    private TreeNode prev;
    public int[] recoverTreeScalerSol(TreeNode root) {
        int[] res = new int[2];
        dfsScalerSol(root);
        if (left == null) return res;
        int tmp = left.data;
        left.data = right.data;
        right.data = tmp;
        res[0] = left.data;
        res[1] = right.data;
        return res;
    }
    private void dfsScalerSol(TreeNode node) {
        if (node == null)
            return;
        dfsScalerSol(node.left);
        if (prev != null) {
            if (node.data < prev.data) {
                if (left == null) {
                    left = prev;
                    right = node;
                } else {
                    right = node;
                }
            }
        }
        prev = node;
        dfsScalerSol(node.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSwappedBST tsb = new TwoSwappedBST();
		int[] A = {2, 22, 6, 7, 9, 10, 20, 21, 5, 50};
		tsb.twoSwappedNodesBST(A); // 22 5
		TreeNode two = new TreeNode(2);
		TreeNode tt = new TreeNode(22);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		tt.left = two;
		tt.right = six;
		six.right = seven;
		seven.right = four;
		int[] X = tsb.recoverTree(tt);
		System.out.println(X[0]+" "+X[1]); // 4 22
		int[] B = {2, 5, 6, 7, 10, 9, 20, 21, 22, 50};
		tsb.twoSwappedNodesBST(B); // 10 9
		
		
	}

}
