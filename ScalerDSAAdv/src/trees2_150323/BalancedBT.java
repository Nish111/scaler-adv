package trees2_150323;

//https://www.scaler.com/academy/mentee-dashboard/class/50154/assignment/problems/225?navref=cl_tt_lst_sl
public class BalancedBT {

	boolean is_balanced = true;
	public int checkifBalanced(TreeNode root) {
		if(root == null) return -1;
		int l_h = checkifBalanced(root.left);
		int r_h = checkifBalanced(root.right);
		if(Math.abs(l_h-r_h) > 1) is_balanced = false;
		int h = Math.max(l_h, r_h) + 1;
		return h;
	}
	public int checkifBalancedAs(TreeNode root) {
		if(checkBalanced(root)==0) return 0;
		return 1;
		
	}
	public int checkBalanced(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return 1;
		int l_h = checkBalanced(root.left);
		int r_h = checkBalanced(root.right);
		if(l_h==0 ||  r_h==0) return 0;
		if(Math.abs(l_h-r_h) > 1) {
			is_balanced = false;
			return 0;
		}
		int h = Math.max(l_h, r_h) + 1;
		return h;
	}
	int balancedScalerSol = 1;

    public int isBalancedScalerSol(TreeNode A) {
        balancedScalerSol(A);
        return balancedScalerSol;
    }

    public int balancedScalerSol(TreeNode A) {
        if (A == null)
            return 0;

        int heightLeft = 1 + balancedScalerSol(A.left);
        int heightRight = 1 + balancedScalerSol(A.right);

        if (Math.abs(heightLeft - heightRight) > 1)
            balancedScalerSol = 0;
        return Math.max(heightLeft, heightRight);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBT bbt = new BalancedBT();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		System.out.println(bbt.checkifBalanced(four)); // 2
		System.out.println(bbt.checkifBalancedAs(four)); // 1
		System.out.println(bbt.checkifBalanced(five)); // 0
		System.out.println(bbt.checkifBalanced(two)); // 1
		System.out.println(bbt.checkifBalanced(six)); // 0
		TreeNode seven = new TreeNode(7);
		six.right = seven;
		System.out.println(bbt.checkifBalanced(four)); // 3
		System.out.println(bbt.checkifBalancedAs(four)); // 0
	}

}
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}