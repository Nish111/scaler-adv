package trees2_150323;

// https://www.scaler.com/academy/mentee-dashboard/class/50154/assignment/problems/9256?navref=cl_tt_nv
public class DiameterOfBT {

	public boolean is_balanced = true;
	public int solve(TreeNode root) {
		findHeight(root);
		return h;
	}
	public int h = Integer.MIN_VALUE;
	public int findHeight(TreeNode root) {
		
		if(root == null) return -1;
		int l_h = findHeight(root.left)+1;
		int r_h = findHeight(root.right)+1;
		//if(l_h==0 ||  r_h==0) return 0;
		/*
		 * if(Math.abs(l_h-r_h) > 1) { is_balanced = false; return 0; }
		 */
		h = Math.max(l_h+r_h, h);
		return Math.max(l_h, r_h);
    }
	static int diameter;
    public int solveScalerSol(TreeNode A) {
        diameter = 0;
        heightScalerSol(A);
        return diameter;
    }
    public static int heightScalerSol(TreeNode root) {
        if (root == null)
            return -1;
        int leftHeight = heightScalerSol(root.left);
        int rightHeight = heightScalerSol(root.right);
        diameter = Math.max(diameter, 2 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiameterOfBT dobt = new DiameterOfBT();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		System.out.println(dobt.solve(five)); // 0
		System.out.println(dobt.solve(four)); // 3
	}

}
