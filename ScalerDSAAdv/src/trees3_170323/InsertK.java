package trees3_170323;

public class InsertK {

	public TreeNode insertK(TreeNode root, int k) {
		// new nodes always inserted as leaf
		if(root == null) {
			TreeNode temp = new TreeNode(k);
			root = temp;
			return root;
		}
		if(root.data>k) {
			root.left = insertK(root.left, k);
		} else {
			root.right = insertK(root.right, k);
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertK ik = new InsertK();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = three;
		four.right = five;
		//two.left = three;
		five.right = six;
		TreeNode A = ik.insertK(four, two.data);
		System.out.println(A.data);
	}

}
