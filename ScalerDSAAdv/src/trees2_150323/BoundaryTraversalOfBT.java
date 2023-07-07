package trees2_150323;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// https://www.scaler.com/academy/mentee-dashboard/class/50154/homework/problems/4860/?navref=cl_pb_nv_tb
public class BoundaryTraversalOfBT {

	public int[] solve(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(A.data);
		result = leftSubtree(A.left, result);
		result = leafNode(A, result);
		result = rightSubtree(A.right, result);
		int[] res = result.stream().mapToInt(Integer::intValue).toArray();
		return res;
    }
	public ArrayList<Integer> leftSubtree(TreeNode A, ArrayList<Integer> result){
		if(A==null) return result;
		if(A.left != null) {
			result.add(A.data);
			leftSubtree(A.left, result);
		} else if (A.right != null) {
			result.add(A.data);
			leftSubtree(A.right, result);
		}
		return result;
	}
	public ArrayList<Integer> leafNode(TreeNode A, ArrayList<Integer> result){
		if(A==null) return result;
		leafNode(A.left, result);
		if(A.left == null && A.right==null) result.add(A.data);
		leafNode(A.right, result);
		return result;
				
	}
	public ArrayList<Integer> rightSubtree(TreeNode A, ArrayList<Integer> result){
		if(A==null) return result;
		if (A.right != null) {
			rightSubtree(A.right, result);
			result.add(A.data);
		} else if(A.left != null) {
			rightSubtree(A.left, result);
			result.add(A.data);
		} 
		return result;
	}
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++)
			System.out.print(A[i]+" ");
		System.out.println();
	}
	 private void leftMostScalerSol(TreeNode root, List<TreeNode> list) {
	        while (root != null) {
	            list.add(root);
	            if (root.left != null)
	                root = root.left;
	            else
	                root = root.right;
	        }
	    }

	    private void leafScalerSol(TreeNode root, List<TreeNode> list) {
	        if (root != null) {
	            if (root.left == null && root.right == null)
	                list.add(root);
	            if (root.left != null)
	                leafScalerSol(root.left, list);
	            if (root.right != null)
	                leafScalerSol(root.right, list);
	        }
	    }

	    private void rightMostScalerSol(TreeNode root, List<TreeNode> list) {
	        Stack<TreeNode> stack = new Stack<>();
	        while (root != null) {
	            stack.push(root);
	            if (root.right != null)
	                root = root.right;
	            else
	                root = root.left;
	        }
	        while (!stack.isEmpty()) {
	            list.add(stack.peek());
	            stack.pop();
	        }
	    }

	    public int[] solveScalerSol(TreeNode A) {
	        List<Integer> ans = new ArrayList<>();
	        if (A == null)
	            return new int[0];
	        List<TreeNode> tmp = new ArrayList<>();
	        Set<TreeNode> set = new HashSet<>();
	        leftMostScalerSol(A, tmp);
	        leafScalerSol(A, tmp);
	        rightMostScalerSol(A, tmp);
	        for (TreeNode p : tmp) {
	            if (!set.contains(p)) {
	                ans.add(p.data);
	                set.add(p);
	            }
	        }

	        int[] result = new int[ans.size()];
	        for (int i = 0; i < ans.size(); i++) {
	            result[i] = ans.get(i);
	        }
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode ten = new TreeNode(10);
		one.left = two; one.right = three;
		two.left=four; two.right = five;
		three.left=six; six.left = nine; six.right = ten;
		five.left = seven; five.right = eight;
		BoundaryTraversalOfBT bt = new BoundaryTraversalOfBT();
		int[] A = bt.solve(one); // [1, 2, 4, 7, 8, 9, 10, 6, 3]
		bt.printArray(A);
	}

}
