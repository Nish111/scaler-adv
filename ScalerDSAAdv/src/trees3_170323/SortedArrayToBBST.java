package trees3_170323;
// https://www.scaler.com/academy/mentee-dashboard/class/70934/assignment/problems/226?navref=cl_tt_nv
public class SortedArrayToBBST {

	public TreeNode createBBST(int[] A) {
		return build(A, 0, A.length-1);
	}
	public TreeNode build(int[] A, int start, int end) {
		if(start>end) return null;
		int mid = (start+end)/2;
		System.out.println(mid + " mid ");
		TreeNode root = new TreeNode(A[mid]);
		root.left = build(A, start, mid-1);
		root.right = build(A, mid+1, end);
		return root;
	}
	 public TreeNode sortedArrayToBSTScalerSol(final int[] A) {
	        return helperScalerSol(A, 0, A.length - 1);
	    }

	    private TreeNode helperScalerSol(int[] nums, int l, int r) {
	        if (l > r) {
	            return null;
	        }
	        if (l == r) {
	            return new TreeNode(nums[l]);
	        }
	        TreeNode node = new TreeNode(nums[(l + r) / 2]);
	        node.left = helperScalerSol(nums, l, (l + r) / 2 - 1);
	        node.right = helperScalerSol(nums, (l + r) / 2 + 1, r);
	        return node;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedArrayToBBST sa = new SortedArrayToBBST();
		int[] A = {1,3,5,8,10,15,18,20};
		TreeNode B = sa.createBBST(A);
		System.out.println(B.data);
	}

}
