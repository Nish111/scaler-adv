 package trees1_130323;

import java.util.ArrayList;
import java.util.HashMap;

// https://www.scaler.com/academy/mentee-dashboard/class/69489/homework/problems/219?navref=cl_tt_lst_nm
public class BinaryTreeInorderAndPreorder {

	public TreeNode constructBinaryTree(int[]pre, int[]in) { // not done yet
		if(in.length==1) return new TreeNode(1);
		int len = in.length;
		int pos = pre[0];
		TreeNode root = null;
		root = constructbt(root, 0, len-1, pre, in);
		return root;
	}
	// end relates to in order array while pos is for pre 
	public TreeNode constructbt(TreeNode root, int start, int end, int[]pre, int[] in) {
	
		//TreeNode some = new TreeNode();
		//some.data = post[pos];
		if(start>end) return null;
		int len = in.length;
		root = new TreeNode(pre[start]);
		if(start==end) return root;
		int index = 0;
		for(int i=0; i<in.length; i++) {
			if(in[i]==pre[start]) {
				index = i;
				break;
			}
		}
		root.left = constructbt(root, start, index-1, pre, in);
		root.right = constructbt(root, index+1, end,  pre, in);
		return root;
	}
	public TreeNode constructBinaryTree2(int[]pre, int[]in) { // not done yet
		int n = pre.length, m = in.length;
		if(n==0 || m==0) return null;
		
		TreeNode root = null;
		root = new TreeNode(pre[0]);
		int index = 0;
		for(int i=0; i<in.length; i++) {
			if(in[i]==pre[0]) {
				index = i;
				break;
			}
		}
		System.out.println(pre[0]);
		System.out.println(index);
		
		int[] preLeft = new int[index];
		System.out.println(preLeft.length + " this");
		for(int i=0; i<preLeft.length; i++)
			preLeft[i]=pre[i+1];
		int[] inLeft = new int[index+1];
		for(int i=0; i<inLeft.length; i++)
			inLeft[i]=pre[i];
		root.left = constructBinaryTree2(preLeft, inLeft);
		int[] preRight = new int[n-index-1];
		for(int i=0; i<preRight.length; i++)
			preRight[i]=pre[index+i+1];
		int[] inRight = new int[m-index-1];
		for(int i=0; i<inRight.length; i++)
			inRight[i]=pre[index+i+1];
		root.right = constructBinaryTree2(preRight, inRight);
		return root;
	}
	HashMap<Integer, Integer> hm = new HashMap<>();

    public TreeNode create3(int[] A, int[] B, int Ps, int Pe, int Is, int Ie){
        if(Ps > Pe || Is > Ie) return null;

        TreeNode root = new TreeNode(A[Ps]);
        int rootIndex = hm.get(A[Ps]);

        int elements_in_Lst = rootIndex - Is;

        root.left = create3(A, B, Ps+1, Ps+elements_in_Lst, Is, rootIndex-1);
        root.right = create3(A, B, Ps+elements_in_Lst+1, Pe, rootIndex+1, Ie);

        return root;
    }

    public TreeNode buildTree3(int[] A, int[] B) {
        // Ps = preorder start, Pe = preorder end, Is = inorder start, Ie = inorder end
        int Ps = 0, Pe = A.length-1, Is = 0, Ie = B.length-1;
        for(int i=0; i<B.length; i++){
            hm.putIfAbsent(B[i], i);
        }
        return create3(A, B, Ps, Pe, Is, Ie);
    }
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
	        root.left = buildTree(new ArrayList<Integer>(A.subList(1,mid+1)),new ArrayList<Integer>( B.subList(0,mid+1)));
	        //preorder becomes (mid+1,n) and inorder becomes right subArray of mid for right of root
	root.right = buildTree(new ArrayList<Integer>(A.subList(mid+1,n)),new ArrayList<Integer>(B.subList(mid+1,m)));
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
		TreeNode B = bt.constructBinaryTree(pre1, in1);
		System.out.println(B.data +" "+B.left.data+" "+B.right.data); // 1 2 3
		int[] pre2= {1, 6, 2, 3};
		int[] in2 = {6, 1, 3, 2};
		TreeNode C = bt.constructBinaryTree(pre2, in2);
		System.out.println(C.data +" "+C.left.data+" "+C.right.data); 
		
	}

}
