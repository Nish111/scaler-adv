 package trees1_130323;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/69489/assignment/problems/224?navref=cl_tt_lst_sl
public class BinaryTree {

	public TreeNode constructBinaryTree(int[]in, int[]post) { // working
		if(in.length==1) return new TreeNode(1);
		int len = in.length;
		int pos = post[post.length-1];
		TreeNode root = null;
		root = constructbt(root, 0, len-1, len-1, post, in);
		return root;
	}
	// end relates to in order array while pos is for post 
	public TreeNode constructbt(TreeNode root, int start, int end, int pos, int[]post, int[] in) {
	
		//TreeNode some = new TreeNode();
		//some.data = post[pos];
		if(start>end) return null;
		int len = in.length;
		root = new TreeNode(post[pos]);
		if(start==end) return root;
		int index = 0;
		for(int i=0; i<in.length; i++) {
			if(in[i]==post[pos]) {
				index = i;
				break;
			}
		}
		if(index!=0) {
			root.left = constructbt(root, start, index-1, pos-(end-index)-1, post, in);
		}
		root.right = constructbt(root, index+1, end, pos-1, post, in);
		return root;
	}
	public TreeNode buildTreeScalerSol(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
	    if (inorder == null || postorder == null || inorder.size() == 0 || inorder.size() != postorder.size())
	        return null;
	    TreeNode root;
	    int n = inorder.size();
	    
	    root = recScalerSol(inorder, postorder, 0, n - 1, n - 1);
	    
	    return root;
	    
	}
	
	public TreeNode recScalerSol(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int start, int end, int postIndex) {
	    if (start > end)
	        return null;
	    TreeNode node;
	    int nodeVal = postorder.get(postIndex);
	    node = new TreeNode(nodeVal);
	    int i;
	    for (i = start; i <= end; i++) {
	        if (inorder.get(i) == nodeVal)
	            break;
	    }
	    node.left = recScalerSol(inorder, postorder, start, i - 1, postIndex - (end - i + 1));
	    node.right = recScalerSol(inorder, postorder, i + 1, end, postIndex - 1);
	    return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		int[] in =   {6,4,7,2,5,1,10,3,12,11,13};
		int[] post = {6,7,4,5,2,10,12,13,11,3,1};
		TreeNode A = bt.constructBinaryTree(in, post);
		int[] in1 = {2,1,3};
		int[] post1 = {2,3,1};
		TreeNode B = bt.constructBinaryTree(in1, post1);
		System.out.println(B.data +" "+B.left.data+" "+B.right.data); // 1 2 3
		int[] in2 = { 7, 5, 6, 2, 3, 1, 4};
		int[] post2= {5, 6, 3, 1, 4, 2, 7};
		TreeNode C = bt.constructBinaryTree(in2, post2);
		
	}

}
