package trees2_150323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/50154/homework/problems/4675/submissions
public class LeftViewOfBT {
	public int[] solve(TreeNode A) {
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(A == null) return new int[] {};
		qu.add(A);
		int count=0;
		while(!qu.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int len = qu.size();
			for(int i=0; i<len; i++) {
				TreeNode curr = qu.poll();
				if(i==len-1) {
					temp.add(curr.data);
				}
				
				if(curr.right != null) qu.add(curr.right);
                if(curr.left != null) qu.add(curr.left);
			}
			Integer[] ans1 = new Integer[temp.size()];
			//System.out.println(temp.size());
			for(int i=0; i<temp.size(); i++) {
				ans1[i] = temp.get(i);
				//System.out.println(ans1[i] + " In ans1");
				count++;
			}
			for(int i=0; i<ans1.length; i++) {
				//System.out.println(ans1[i] + " In ans1");
				int temp1 = ans1[i];
				res.add(temp1);
				//System.out.println(res.get(count));
				count++;
			}
		}
		//for(int i=0; i<res.size(); i++)
			//System.out.println(res.get(i));
		Integer[] ans2 = new Integer[res.size()];
		int[] ans = new int[res.size()];
		for(int i=0; i<res.size(); i++) {
			ans2[i] = res.get(i);
			ans[i] = ans2[i];
		}
		//printArray(ans);
		return ans;
    }
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++)
			System.out.print(A[i]+" ");
		System.out.println();
	}
	public ArrayList < Integer > solveScalerSol(TreeNode A) {

        ArrayList < Integer > ans = new ArrayList < Integer > ();
        Queue < PairScalerSolT1 > q = new LinkedList < > ();
        int l = 0;

        q.add(new PairScalerSolT1(A, 0));
        while (q.size() > 0) {
            TreeNode temp = q.peek().first;
            int temp_l = q.peek().second;

            if (temp.left != null) {
                q.add(new PairScalerSolT1(temp.left, temp_l + 1));
            }
            if (temp.right != null) {
                q.add(new PairScalerSolT1(temp.right, temp_l + 1));
            }
            if (temp_l == l) {
                // append the first node of each level to the answer
                ans.add(temp.data);
                l++;
            }
            q.remove();
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeftViewOfBT lv = new LeftViewOfBT();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		int[] A = lv.solve(four);
		lv.printArray(A);
	}

}
class PairScalerSolT1 {

    public TreeNode first;
    public int second;

    public PairScalerSolT1 (TreeNode x, int y) {
        first = x;
        second = y;
    }
}