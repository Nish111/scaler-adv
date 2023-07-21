package contest_140423;
// https://www.scaler.com/test/7866a39158/#/problem_3
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode A) {
        if(A==null) return 0;
        int leftDepth=maxDepth(A.left);
        int rightDepth=maxDepth(A.right);
        return Math.max(leftDepth, rightDepth)+1;
    }
    public int depthScalerSol(TreeNode A, int level) {
        if(A==null) return level;
        int leftDepth=depthScalerSol(A.left, level+1);
        int rightDepth=depthScalerSol(A.right, level+1);
        return Math.max(leftDepth, rightDepth);
    }
    public int maxDepthScalerSol(TreeNode A, int level) {
    	return depthScalerSol(A,0);
    }
}
