package trees3_170323;
// https://www.scaler.com/academy/mentee-dashboard/class/70934/assignment/problems/18384/?navref=cl_pb_nv_tb
public class DeleteK {

	public TreeNode deleteK(TreeNode root, int k) { // we are returning root so 1st else if
		if(root == null) return null;
		if(root.data ==k) {
			// case 1 leaf
			if(root.left ==null && root.right==null) return null;
			// case 2 only 1 leaf for that node
			if(root.left ==null || root.right==null) {
				if(root.left==null) return root.right;
				else return root.left;
			}
			// case 3
			TreeNode left_max = findMax(root.left);
			root.data = left_max.data;
			//int right_min = findMin(root.right);
			root.left = deleteK(root.left, left_max.data);
			//root.right = deleteK(root.right, right_min);
			return root;
		} else if(root.data>k) {
			root.left = deleteK(root.left, k);
		} else {
			root.right = deleteK(root.right, k);
		}
		return root;
	}
	public TreeNode findMax(TreeNode root) {
		// TODO Auto-generated method stub
		/*
		 * if(root==null) return 0; int temp = root.data; int max = findMax(root.left);
		 * return Math.max(temp, root.data);
		 */
		while(root.right != null) root = root.right;
		return root;
	}
	public TreeNode solveScalerSol(TreeNode A, int B) {
        if(A != null) 
            if(B < A.data) 
                A.left = solveScalerSol(A.left, B);                
            else if(B > A.data) 
                A.right = solveScalerSol(A.right, B);       
            else{
                if(A.left == null && A.right == null) 
                    return null;              
                if (A.left == null || A.right == null)
                    return A.left != null ? A.left : A.right;           
                                                                  
                TreeNode temp = A.left;                         
                while(temp.right != null) 
                    temp = temp.right;  
                A.data = temp.data;                             
                A.left = solveScalerSol(A.left, temp.data);		
            }
        return A;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteK dk = new DeleteK();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = three;
		four.right = five;
		//two.left = three;
		five.right = six;
		TreeNode temp = dk.deleteK(four, six.data);
		
	}

}
