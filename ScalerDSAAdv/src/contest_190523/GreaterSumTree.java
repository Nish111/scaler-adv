package contest_190523;
public class GreaterSumTree {
    int sum=0;
    public TreeNode solve(TreeNode A) {
        // convert pre order to inorder
        // apply addition logic as per arrays
        // convert inorder to preorder
        
        //   or
        // inversely traverse from right, root and left
        if (A != null) {
            // Traverse the tree in reverse (right, root, left) to calculate sum of greater values
            solve(A.right);
            // Update the node value with the sum of greater values
            sum += A.val;
            A.val = sum;
            solve(A.left);
        }
        return A;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
     left=null;
      right=null;
     }
}