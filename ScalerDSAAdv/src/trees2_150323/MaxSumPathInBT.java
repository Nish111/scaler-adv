package trees2_150323;
// https://www.scaler.com/academy/mentee-dashboard/class/50154/homework/problems/15/?navref=cl_pb_nv_tb
public class MaxSumPathInBT {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode A) {
		
		solve(A);
		return max;
	}
	public int solve(TreeNode A) {
		if(A==null) return 0;
		int left = Math.max(0, solve(A.left));
		int right = Math.max(0, solve(A.right));
		max = Math.max(max, left+right+A.data);
		return Math.max(left+A.data, right+A.data);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumPathInBT bt = new MaxSumPathInBT();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		one.left = two; one.right=three;
		System.out.println(bt.maxPathSum(one));
		TreeNode twenty = new TreeNode(20);
		TreeNode twenty1 = new TreeNode(20);
		TreeNode mten = new TreeNode(-10);
		TreeNode mten1 = new TreeNode(-10);
		TreeNode mfifty = new TreeNode(-50);
		twenty.left=mten; twenty.right=twenty1;
		twenty1.right=mten1; twenty1.right=mfifty;
		System.out.println(bt.maxPathSum(twenty));
	}

}
