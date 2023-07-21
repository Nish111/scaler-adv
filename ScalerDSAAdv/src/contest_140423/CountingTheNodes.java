package contest_140423;


// Definition for binary tree
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
 // https://www.scaler.com/test/7866a39158/#/problem_1
public class CountingTheNodes {
    public int solve(TreeNode A) {
        return solveBranches(A)+1;
    }
    public int solveBranches(TreeNode A){
        if(A==null) return 0;
        int count=0;
        if(A.left!=null){
            if(A.left.val>A.val) count++;
            else A.left.val = A.val;
        }
        if(A.right!=null){
            if(A.right.val>A.val) count++;
            else A.right.val = A.val;
        }
        return count + solveBranches(A.left) + solveBranches(A.right);
    }
    int dfsScalersol(TreeNode cur, int mx){
        if(cur == null){
            return 0;
        }
        int ans = dfsScalersol(cur.left, Math.max(mx, cur.val)) + 
        		dfsScalersol(cur.right, Math.max(mx, cur.val));
        if(cur.val > mx){
            ++ans;
        }
        return ans;
    }
    public int solveScalerSol(TreeNode A) {
        return dfsScalersol(A, 0);
    }
}
