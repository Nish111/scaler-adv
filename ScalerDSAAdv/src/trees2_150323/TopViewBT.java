package trees2_150323;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/50154/assignment/problems/5715?navref=cl_tt_nv
public class TopViewBT {

	public ArrayList<Integer> solve(TreeNode root) {
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		Queue<Pair<TreeNode, Integer>> qu = new LinkedList<>();
		qu.add(new Pair(root, 0));
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while(!qu.isEmpty()) {
			Pair p = qu.poll();
			TreeNode curr = p.x;
			int var_level = p.y;
			if(hm.containsKey(var_level)) {
				hm.get(var_level).add(curr.data);
			} else {
				hm.put(var_level, new ArrayList<>());
				hm.get(var_level).add(curr.data);
			}
			max = Math.max(max, var_level);
			min = Math.min(min, var_level);
			if(curr.left != null) qu.add(new Pair(curr.left, var_level-1));
			if(curr.right != null) qu.add(new Pair(curr.right, var_level+1));
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=min; i<=max; i++) {
			ArrayList<Integer> temp = hm.get(i);
			ans.add(temp.get(0)); // to add only first element as it will be visible from top
			//ans.addAll(temp);
		}
		return ans;
    }
	public void printArrayList(ArrayList<Integer> A) {
		for(int i=0; i<A.size(); i++)
			System.out.print(A.get(i)+" ");
		System.out.println();
		
	}
	public ArrayList < Integer > topviewScalerSol(TreeNode root) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        if (root == null)
            return ans;

        Queue < PairScalerSol > level = new LinkedList < PairScalerSol > ();

        level.add(new PairScalerSol(root, 0));
        HashMap < Integer, Integer > top = new HashMap < Integer, Integer > ();
        //Using Level order traversal to find the top view
        while (level.size() != 0) {
            PairScalerSol curr = level.peek();
            level.remove();
            if (top.get(curr.second) == null)
                top.put(curr.second, curr.first.data);

            if (curr.first.left != null) {
                level.add(new PairScalerSol(curr.first.left, curr.second - 1));
            }
            if (curr.first.right != null) {
                level.add(new PairScalerSol(curr.first.right, curr.second + 1));
            }
        }

        for (Map.Entry elem: top.entrySet()) {
            ans.add((int) elem.getValue());
        }
        return ans;
    }
    public ArrayList < Integer > solveScalerSol(TreeNode A) {
        return topviewScalerSol(A);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopViewBT tv = new TopViewBT();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		ArrayList<Integer> A = tv.solve(four);
		tv.printArrayList(A);
	}
}
class PairScalerSol {

    public TreeNode first;
    public int second;

    public PairScalerSol(TreeNode x, int y) {
        first = x;
        second = y;
    }
}
