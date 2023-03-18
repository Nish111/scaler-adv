package trees1_130323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/69489/assignment/problems/206/?navref=cl_pb_nv_tb
public class LevelOrderTraversal {

	public void levelOrderTraversalIter(TreeNode root) { // O(N) // Class
		LinkedList<TreeNode> qu = new LinkedList<TreeNode>();
		if(root == null) return;
		qu.add(root);
		while(!qu.isEmpty()) {
			TreeNode curr = qu.poll();
			System.out.print(curr.data +" ");
			if(curr.left != null) qu.add(curr.left);
			if(curr.right != null) qu.add(curr.right);
		}
		System.out.println();
	}
	 public ArrayList<ArrayList<Integer>> solve(TreeNode root) { // O(N) // Assignment
		 // will implement using ArrayList then try for array
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root == null) return res;
		qu.add(root);
		
		while(!qu.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int len = qu.size();
			for(int i=0; i<len; i++) {
				TreeNode curr = qu.poll();
				temp.add(curr.data);
				if(curr.left != null) qu.add(curr.left);
				if(curr.right != null) qu.add(curr.right);
			}
			res.add(temp);
		}
		return res;
	}
	 public void printArray(int[][] A) {
			for(int i=0; i<A.length; i++) {
				for(int j=0; j<A[0].length;j++) {
					System.out.print(A[i][j] +" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	 public ArrayList<ArrayList<Integer>> levelOrderScalerSol(TreeNode A) {
		    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		    ArrayList<Integer> level = new ArrayList<>();
		    Queue<TreeNode> queue = new LinkedList<>();
		    if (A == null)
		        return null;
		    queue.add(A);
		    queue.add(null);
		    TreeNode node;
		    while (!queue.isEmpty()) {
		        node = queue.remove();
		        if (node == null && queue.isEmpty()) {
		            res.add(new ArrayList<>(level));
		            break;
		        }
		        if (node == null) {
		            res.add(new ArrayList<>(level));
		            level.clear();
		            queue.add(null);
		            continue;
		        }
		        level.add(node.data);
		        if (node.left != null)
		            queue.add(node.left);
		        if (node.right != null) {
		            queue.add(node.right);
		        }
		    }
		    return res;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrderTraversal lot = new LevelOrderTraversal();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		lot.levelOrderTraversalIter(four); // 4 5 2 3 6 
		//int[][] A = lot.solve(four);
		//lot.printArray(A);
	}

}
