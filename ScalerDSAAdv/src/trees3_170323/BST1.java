package trees3_170323;

// https://www.scaler.com/academy/mentee-dashboard/class/70934/assignment/problems/35476?navref=cl_tt_nv
public class BST1 {

	public boolean searchNode(TreeNode root, int k) { // O(LogN) best, O(N) worst Skewed
		TreeNode curr = root;
		while(curr != null) {
			if(curr.data == k) return true;
			else if(curr.data>k) curr=curr.left;
			else curr = curr.right;
		}
		return false;
	}
	public int solve(TreeNode A, int B) {
		TreeNode curr = A;
		while(curr != null) {
			if(curr.data == B) return 1;
			else if(curr.data>B) curr=curr.left;
			else curr = curr.right;
		}
		return 0;
    }
	public int solveScalerSol(TreeNode A, int B) {
        while (A != null && A.data != B) {
            A = (A.data > B) ? A.left : A.right;
        }
        return A != null ? 1 : 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST1 b = new BST1();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = three;
		four.right = five;
		//two.left = three;
		five.right = six;
		System.out.println(b.searchNode(four, 17)); // false
		System.out.println(b.searchNode(four, 6)); // true
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