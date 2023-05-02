package trees1_130323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/69489/homework/problems/9269/?navref=cl_pb_nv_tb
public class DeSerializeBT {

	public TreeNode deserializeBT(int[] A) { // O(N) // Class
	        Queue<TreeNode> qu = new LinkedList<>();
	        qu.add(new TreeNode(A[0]));
	        int i=1;
	        TreeNode root = qu.peek();
	        while(!qu.isEmpty() && i<A.length){
	        	TreeNode temp = qu.poll();
	        	if(A[i] != -1) {
	        		temp.left= new TreeNode(A[i]);
	        		qu.add(temp.left);
	        	}
	            i++;
	            if(A[i] != -1) {
	        		temp.right= new TreeNode(A[i]);
	        		qu.add(temp.right);
	        	}
	            i++;
	        }
	        return root;
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
	 public TreeNode solveScalerSol(ArrayList<Integer> A) {

	        TreeNode root = new TreeNode(A.get(0));
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        int i = 1;
	        while(q.size() != 0){
	            TreeNode cur = q.peek();
	            q.remove();
	            if(cur == null){
	                continue;
	            }
	            int val_left = A.get(i);
	            int val_right = A.get(i+1);
	            
	            i += 2;
	            
	            if(val_left == -1){
	                cur.left = null;
	            }
	            else{
	                cur.left = new TreeNode(val_left);
	            }
	            if(val_right == -1){
	                cur.right = null;
	            }
	            else{
	                cur.right = new TreeNode(val_right);
	            }
	            q.add(cur.left);
	            q.add(cur.right);
	        }
	        
	        return root;

	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeSerializeBT lot = new DeSerializeBT();
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
		int[] A = { 1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1 };
		TreeNode t = lot.deserializeBT(A); // 1 2 3 4 5 -1 -1 -1 -1 -1 -1 -- wrong
		lot.printArray(A);
		int[] B = lot.solve2(t); // 1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1 
		lot.printArray(B);
	}

}
