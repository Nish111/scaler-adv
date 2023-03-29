package trees4_210323;

import java.util.ArrayList;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/71401/assignment/problems/218/?navref=cl_pb_nv_tb
public class LeastCommonAncestor {

	public int findLCA(TreeNode root, int k1, int k2) { // some issue in code
		end = false;
		ArrayList<Integer> pathK1 = path(root, k1);
		end = false;
		ArrayList<Integer> pathK2 = path(root, k2);
		//System.out.println(pathK1.get(0));
		for(int i=0; i<pathK2.size(); i++) {
			//System.out.println("i is " + i);
			//System.out.println(pathK2.get(i));
			//if(pathK2.contains(pathK1.get(i))) return pathK1.get(i);
		}
		//System.out.println("pathK1");
		for(int i=0; i<pathK1.size(); i++) {
			//System.out.println("i is " + i);
			//System.out.println(pathK2.contains(pathK1.get(i)));
			if(pathK2.contains(pathK1.get(i))) return pathK1.get(i);
		}
		return 0;
	}
	static Stack<Integer> st = new Stack<>();
	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean end = false;
	public ArrayList<Integer> path(TreeNode root, int k) {
		
		if(root==null) return arr;
		st.push(root.data);
		if(root.data==k) {
			while(!st.isEmpty()) {
				int temp = st.pop();
				arr.add(temp);
				System.out.print(temp+" ");
			}
			end= true;
			return arr;
		}
		if(!end) path(root.left, k);
		if(!end) path(root.right, k);
		// st.pop();
		System.out.println();
		return arr;
	}
	public int lca2(TreeNode root, int B, int C) {
		boolean B_exists = checkIfExists(root, B);
		boolean C_exists = checkIfExists(root, C);
		if(!B_exists || !C_exists) return -1;
		return findLCA2(root, B, C);
	}
	public boolean checkIfExists(TreeNode root, int x) {
		if(root==null) return false;
		if(root.data==x) return true;
		return checkIfExists(root.left, x) || checkIfExists(root.right, x);
	}
	public int findLCA2(TreeNode root, int B, int C) {
		if(root ==null) return -1;
		if(root.data == B || root.data==C) return root.data;
		int left = findLCA2(root.left, B, C);
		int right = findLCA2(root.right, B, C);
		if(left==-1) return right;
		if(right==-1) return left;
		return root.data;
	}
	public static TreeNode LCAScalerSol(TreeNode root, int val1, int val2) {
        if (root == null)
            return null;
        if (root.data == val1 || root.data == val2)
            return root;
        TreeNode l = LCAScalerSol(root.left, val1, val2);
        TreeNode r = LCAScalerSol(root.right, val1, val2);
        if (l != null && r != null)
            return root;
        if (l != null)
            return l;
        return r;
    }
    public static boolean findScalerSol(TreeNode root, int val1) {
        if (root == null)
            return false;
        if (root.data == val1)
            return true;
        return (findScalerSol(root.left, val1) || findScalerSol(root.right, val1));
    }
    public int lcaScalerSol(TreeNode A, int B, int C) {
        int val1 = B;
        int val2 = C;
        TreeNode root = A;
        if (findScalerSol(root, val1) == false || findScalerSol(root, val2) == false) 
            return -1;
        TreeNode ans = LCAScalerSol(root, val1, val2);
        if (ans == null) 
            return -1;
        return ans.data;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeastCommonAncestor lca = new LeastCommonAncestor();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = three;
		four.right = five;
		three.left = two;
		five.right = six;
		//lca.path(four, 3);
		end = false;
		//lca.path(four, 2);
		System.out.println(lca.findLCA(four, 2, 3)); // 3
		System.out.println(lca.findLCA2(four, 2, 3)); // 3
		System.out.println(lca.lca2(four, 2, 3)); // 3
	}

}

