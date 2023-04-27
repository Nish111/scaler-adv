package tries2_270323;
// https://www.scaler.com/academy/mentee-dashboard/class/70937/assignment/problems/220/?navref=cl_pb_nv_tb
public class FlatterBTToLL {
	TreeNodeLL temp = null;
	public TreeNodeLL flatten(TreeNodeLL root) {
		if(root == null) return null;
		flatten(root.right);
		flatten(root.left);
		//System.out.println(L.val);
		
		root.right = temp;
		root.left = null;
		temp = root;
		return root;
		/*
		 * if(L==null && R ==null) return (root); else if(L==null) { root.right =
		 * R.left; return root; } else if(R==null) { root.right = L.left; return root; }
		 * else { root.right = L.left; L.right = R.head; return root; }
		 */
	}
	 public TreeNode flattenScalerSol(TreeNode root) {
	        if (root != null) {
	        	flattenScalerSol(root.right);
	            if (root.left != null) {
	            	flattenScalerSol(root.left);
	                TreeNode node = root.left;
	                while (node.right != null) {
	                    node = node.right;
	                }
	                node.right = root.right;
	                root.right = root.left;
	                root.left = null;
	            }
	        }
	        return root;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlatterBTToLL fbl = new FlatterBTToLL();
		TreeNodeLL A = new TreeNodeLL(1);
		TreeNodeLL B = new TreeNodeLL(2);
		TreeNodeLL C = new TreeNodeLL(3);
		A.left=B; A.right=C;
		TreeNodeLL X = fbl.flatten(A);
		System.out.println(X.val+" "+X.right.val+" "+X.right.right.val);
	}

}
class TreeNodeLL{
	int val;
	TreeNodeLL head, tail;
	TreeNodeLL left, right;
	TreeNodeLL(int x){
		this.val = x;
		this.left=null; this.right=null;
		this.head=null; this.tail=null;
	}
}