package trees2_150323;

// https://www.scaler.com/academy/mentee-dashboard/class/70934/assignment/problems/4857/?navref=cl_pb_nv_tb
public class LargestBSTSubtree {
	int count = Integer.MIN_VALUE;
	public int solve(TreeNode A) {
	
		int va = checkIfBST(A);
		return count;
    }
	public int checkIfBST(TreeNode A) {
		if(A==null) return 0;
		int aLeft = checkIfBST(A.left);
		int aRight= checkIfBST(A.right);
		if(A.right!=null && A.data>A.right.data) return -1;
		if(A.left!=null && A.data<A.left.data) return -1;

		if(aLeft != -1 && aRight != -1) {
			count = Math.max(count, aLeft+aRight+1);
			return aLeft+aRight+1;
		}
		return -1;
	}
	public int solveScalerSol(TreeNode A) {
        return largestBSTScalerSol(A);
    }
    int largestBSTScalerSol(TreeNode node) {
        ValueScalerSol val = new ValueScalerSol();
        largestBSTUtil(node, val, val, val, val);

        return val.max_size;
    }
    /* largestBSTUtil() updates *max_size_ref for the size of the largest BST 
     subtree.   Also, if the tree rooted with node is non-empty and a BST, 
     then returns size of the tree. Otherwise returns 0.*/
    int largestBSTUtil(TreeNode node, ValueScalerSol min_ref, ValueScalerSol max_ref,
        ValueScalerSol max_size_ref, ValueScalerSol is_bst_ref) {

        /* Base Case */
        if (node == null) {
            is_bst_ref.is_bst = true; // An empty tree is BST 
            return 0; // Size of the BST is 0 
        }

        int min = Integer.MAX_VALUE;

        /* A flag variable for left subtree property 
         i.e., max(root->left) < root->data */
        boolean left_flag = false;

        /* A flag variable for right subtree property 
         i.e., min(root->right) > root->data */
        boolean right_flag = false;

        int ls, rs; // To store sizes of left and right subtrees 

        /* Following tasks are done by recursive call for left subtree 
         a) Get the maximum value in left subtree (Stored in *max_ref) 
         b) Check whether Left Subtree is BST or not (Stored in *is_bst_ref) 
         c) Get the size of maximum size BST in left subtree (updates *max_size) */
        max_ref.max = Integer.MIN_VALUE;
        ls = largestBSTUtil(node.left, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.is_bst == true && node.data > max_ref.max) {
            left_flag = true;
        }

        /* Before updating *min_ref, store the min value in left subtree. So that we 
         have the correct minimum value for this subtree */
        min = min_ref.min;

        /* The following recursive call does similar (similar to left subtree)  
         task for right subtree */
        min_ref.min = Integer.MAX_VALUE;
        rs = largestBSTUtil(node.right, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.is_bst == true && node.data < min_ref.min) {
            right_flag = true;
        }

        // Update min and max values for the parent recursive calls 
        if (min < min_ref.min) {
            min_ref.min = min;
        }
        if (node.data < min_ref.min) // For leaf nodes 
        {
            min_ref.min = node.data;
        }
        if (node.data > max_ref.max) {
            max_ref.max = node.data;
        }

        /* If both left and right subtrees are BST. And left and right 
         subtree properties hold for this node, then this tree is BST. 
         So return the size of this tree */
        if (left_flag && right_flag) {
            if (ls + rs + 1 > max_size_ref.max_size) {
                max_size_ref.max_size = ls + rs + 1;
            }
            return ls + rs + 1;
        } else {
            //Since this subtree is not BST, set is_bst flag for parent calls 
            is_bst_ref.is_bst = false;
            return 0;
        }
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestBSTSubtree lbt = new LargestBSTSubtree();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		two.left = one;
		two.right = four;
		four.left = three;
		four.right = five; 
		System.out.println(lbt.solve(two));
	}

}
class ValueScalerSol {

    int max_size = 0; // for size of largest BST 
    boolean is_bst = false;
    int min = Integer.MAX_VALUE; // For minimum value in right subtree 
    int max = Integer.MIN_VALUE; // For maximum value in left subtree 

}  
