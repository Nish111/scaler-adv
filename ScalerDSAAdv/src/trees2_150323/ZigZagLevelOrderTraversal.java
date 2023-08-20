package trees2_150323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.scaler.com/academy/mentee-dashboard/class/50154/homework/problems/233
public class ZigZagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder1(TreeNode A) {

        // Base case: Return empty list if root is null
        if (A == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(A.data);
        ans.add(first);

        boolean leftToRight = false;

        while (!q.isEmpty()) {

            // Current level list
            ArrayList<Integer> level = new ArrayList<Integer>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();

                // Add current node value to level list based on the direction
                if (leftToRight) {
                    level.add(0, curr.data); // Add to the beginning of the list
                } else {
                    level.add(curr.data); // Add to the end of the list
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

            }
            ans.add(level);
            leftToRight = !leftToRight;
        }

        // Remove the first level (root node only)
        ans.remove(0);
        return ans;
    }
	 public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		 Queue<TreeNode> qu = new LinkedList<TreeNode>();
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			if(A == null) return res;
			qu.add(A);
			boolean flag=false;
			while(!qu.isEmpty()) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				int len = qu.size();
				for(int i=0; i<len; i++) {
					TreeNode curr = qu.poll();
					if(flag) temp.add(0, curr.data);
					else temp.add(curr.data);
					if(curr.left != null) qu.add(curr.left);
					if(curr.right != null) qu.add(curr.right);
				}
				res.add(temp);
				flag=!flag;
			}
			return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagLevelOrderTraversal lot = new ZigZagLevelOrderTraversal();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		lot.zigzagLevelOrder(four); // 4 5 2 3 6 
		//int[][] A = lot.solve(four);
		//lot.printArray(A);
	}

}
