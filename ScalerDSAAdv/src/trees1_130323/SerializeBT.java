package trees1_130323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/69489/homework/problems/9268
public class SerializeBT {

	public int[] serializeBT(TreeNode root) { // O(N) // Class
		LinkedList<TreeNode> qu = new LinkedList<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) return new int[]{-1};
		qu.add(root);
		TreeNode temp = new TreeNode(-1);
		while(!qu.isEmpty()) {
			TreeNode curr = qu.poll();
			System.out.print(curr.data +" ");
			res.add(curr.data);
			if(curr.left != null) qu.add(curr.left);
			if(curr.right != null) qu.add(curr.right);
			if(curr.left == null) {
				if(curr.data != -1)
					qu.add(temp);
				else continue;
			}
			if(curr.right == null) {
				if(curr.data != -1)
					qu.add(temp);
				else continue;
			}
		}
		System.out.println();
		int len = res.size();
		int[] ans = new int[len];
		for(int i=0; i<len; i++)
			ans[i] = res.get(i);
		return ans;
	}
	 public int[] solve2(TreeNode root) {
	        List<Integer> list = new ArrayList<>();
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()){
	            TreeNode temp = q.remove();
	            if(temp != null)
	                list.add(temp.data);
	            else{
	                list.add(-1);
	                continue;
	            }
	            q.add(temp.left);
	            q.add(temp.right);
	        }

	        // System.out.println(list);
	        int n = list.size();
	        int[]  ans =  new int[n];
	        for(int i = 0; i < n; i++){
	            ans[i] = list.get(i);
	        }
	        
	        return ans;

	    }
	 public void printArray(int[] A) {
			for(int i=0; i<A.length; i++) {
					System.out.print(A[i] +" ");
				}
				System.out.println();
		}
	 public ArrayList<Integer> solveScalerSol(TreeNode A) {
	        ArrayList<Integer> ans = new ArrayList<Integer>();
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(A);
	        while(q.size() != 0){
	            TreeNode cur = q.peek();
	            q.remove();
	            if(cur == null){
	                ans.add(-1);
	                continue;
	            }
	            
	            ans.add(cur.data);
	            q.add(cur.left);
	            q.add(cur.right);
	        }
	        return ans;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializeBT lot = new SerializeBT();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five; three.right=six;
		int[] A = lot.serializeBT(one); // 1 2 3 4 5 -1 -1 -1 -1 -1 -1 -- wrong
		lot.printArray(A);
		int[] B = lot.solve2(one); // 1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1 
		lot.printArray(B);
	}

}
