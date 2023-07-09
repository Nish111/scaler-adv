package trees2_150323;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// https://www.scaler.com/academy/mentee-dashboard/class/50154/homework/problems/4677
public class OddAndEvenLevels {
	public int solve(TreeNode A) {
	        Queue<TreeNode> qu = new ArrayDeque<>();
	        qu.add(A);
	        int odd = 0, even = 0, count=1;
	        while(qu.size()>0){
	            int temp = qu.size();
	            int sum = 0;
	            for(int i=0; i<temp; i++){
	                TreeNode node = qu.remove();
	                if(node.left != null) qu.add(node.left);
	                if(node.right != null) qu.add(node.right);
	                sum += node.data;
	            }
	            if(count%2==0) even+=sum;
	            else odd+=sum;
	            count++;
	        }
	        return odd-even;
    }
	
	 public int solve1(TreeNode A) {

	        Queue<TreeNode> q = new ArrayDeque<>();
	        q.add(A);
	        int oddSum = 0, evenSum = 0, cnt = 1;

	        while(q.size() > 0)
	        {
	            int cs = q.size();
	            int inSum = 0;

	            for(int i=1; i<=cs; i++)
	            {
	                TreeNode node = q.remove();

	                if(node.left!=null)
	                    q.add(node.left);
	                if(node.right!=null)
	                    q.add(node.right);

	                inSum += node.data;        
	            }
	            if(cnt % 2==0)
	                evenSum += inSum;
	            else
	                oddSum += inSum;
	            cnt++;  
	        }
	        return oddSum-evenSum;
	    }
	 public int solveScalerSol(TreeNode A) {

	        Queue < TreeNode > q = new LinkedList < TreeNode > ();

	        if (A == null)
	            return 0;

	        int oddsum = 0;
	        int evensum = 0;
	        int level = 0;
	        q.add(A);

	        while (q.size() > 0) {
	            // q contains all the nodes in a level
	            int n = q.size();
	            level ^= 1;
	            while (n--> 0) {
	                TreeNode temp = q.peek();
	                q.remove();
	                if (temp.left != null)
	                    q.add(temp.left);
	                if (temp.right != null)
	                    q.add(temp.right);

	                if (level != 0)
	                    oddsum += temp.data;
	                else
	                    evensum += temp.data;
	            }
	        }
	        return (oddsum - evensum);

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddAndEvenLevels oel = new OddAndEvenLevels();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode ten = new TreeNode(10);
		one.left = two; one.right = three;
		two.left=four; two.right = five;
		three.left=six; three.right = seven; four.left = eight;
		System.out.println(oel.solve(one));
	}

}
