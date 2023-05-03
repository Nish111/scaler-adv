 package trees1_130323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://www.scaler.com/academy/mentee-dashboard/class/69489/homework/problems/219?navref=cl_tt_lst_nm
public class BinaryTreeInorderAndPreorder {


	  public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
	        TreeNode root;
	        int n = A.size(),m=B.size();
	        if(n==0 || m==0){
	            return null;
	        }
	        root = new TreeNode(A.get(0));
	// Find mid from inorder array
	        int mid = B.indexOf(A.get(0));
	//preorder becomes (1, mid+1) and inorder becomes left subArray of mid for left of root
	        root.left = buildTree(new ArrayList<Integer>(A.subList(1,mid+1)),
	        		new ArrayList<Integer>( B.subList(0,mid+1)));
	        //preorder becomes (mid+1,n) and inorder becomes right subArray of mid for right of root
	root.right = buildTree(new ArrayList<Integer>(A.subList(mid+1,n)),
			new ArrayList<Integer>(B.subList(mid+1,m)));
	        return root;
	    }

		public TreeNode buildTreeArr(int[] A, int[] B) {
			TreeNode root;
			int n = A.length, m = B.length;
			if (n == 0 || m == 0) {
				return null;
			}
			root = new TreeNode(A[0]);
			// Find mid from inorder array
			int mid = 0;
			for (int i = 0; i < m; i++) {
				if (B[i] == A[0]) {
					mid = i;
					break;
				}
			}
			// preorder becomes (1, mid+1) and inorder becomes left subArray of mid for left
			// of root
			Arrays.copyOfRange(A, 1, mid + 1);
			root.left = buildTreeArr(Arrays.copyOfRange(A, 1, mid + 1), Arrays.copyOfRange(B, 0, mid + 1));
			// preorder becomes (mid+1,n) and inorder becomes right subArray of mid for
			// right of root
			root.right = buildTreeArr(Arrays.copyOfRange(A, mid + 1, n), Arrays.copyOfRange(B, mid + 1, m));
			return root;
		}
		ArrayList < Integer > preorder, inorder;

		  public TreeNode buildTreeScalerSol(ArrayList < Integer > preorder, ArrayList < Integer > inorder) {

		    if (preorder == null || inorder == null || preorder.size() == 0 || inorder.size() == 0)
		      return null;

		    if (preorder.size() != inorder.size())
		      return null;

		    this.preorder = preorder;
		    this.inorder = inorder;

		    return recScalerSol(0, preorder.size() - 1, 0);

		  }

		  private TreeNode recScalerSol(int start, int end, int index) {

		    if (start > end)
		      return null;

		    TreeNode root = new TreeNode(preorder.get(index));

		    int i = start;

		    for (; i <= end; i++) {
		      if (inorder.get(i).intValue() == root.data)
		        break;
		    }

		    root.left = recScalerSol(start, i - 1, index + 1);
		    root.right = recScalerSol(i + 1, end, index + i - start + 1);

		    return root;
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInorderAndPreorder bt = new BinaryTreeInorderAndPreorder();
		//int[] in =   {6,4,7,2,5,1,10,3,12,11,13};
		//int[] pre = {6,7,4,5,2,10,12,13,11,3,1};
		//TreeNode A = bt.constructBinaryTree2(pre, in);
		int[] pre1 = {1, 2, 3};
		int[] in1 = {2,1,3};
		TreeNode B = bt.buildTreeArr(pre1, in1);
		System.out.println(B.data +" "+B.left.data+" "+B.right.data); // 1 2 3
		int[] pre2= {1, 6, 2, 3};
		int[] in2 = {6, 1, 3, 2};
		TreeNode C = bt.buildTreeArr(pre2, in2);
		System.out.println(C.data +" "+C.left.data+" "+C.right.data); // 1 6 2
		
	}

}
