package trees3_170323;

// https://www.scaler.com/academy/mentee-dashboard/class/70934/assignment/problems/221?navref=cl_tt_lst_sl
public class BST2 {

	public boolean checkIfBSTOrNot(TreeNode root) {
		int l = Integer.MIN_VALUE;
		int r = Integer.MAX_VALUE;
		return checkForTree(root, l, r);
	}
	public boolean checkForTree(TreeNode root, int l, int r) {
		if(root==null) return true;
		if(root.data >= l && root.data <=r) {
			return 
				checkForTree(root.left, l, root.data-1) && 
				checkForTree(root.right, root.data+1, r);
			
		} else return false;
	}
	 public int isValidBSTScalerSol(TreeNode A) {
	        if (isValidScalerSol(A, Long.MIN_VALUE, Long.MAX_VALUE))
	            return 1;
	        return 0;
	    }
	    public static boolean isValidScalerSol(TreeNode A, long l, long r) {
	        if (A == null)
	            return true;
	        if (A.data > l && A.data < r) {
	            boolean left = isValidScalerSol(A.left, l, A.data);
	            boolean right = isValidScalerSol(A.right, A.data, r);
	            return (left && right);
	        } else
	            return false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST2 b = new BST2();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = three;
		four.right = five;
		//two.left = three;
		five.right = six;
		System.out.println(b.checkIfBSTOrNot(four));// true
		five.left=two;
		System.out.println(b.checkIfBSTOrNot(four));// false
	}

}
