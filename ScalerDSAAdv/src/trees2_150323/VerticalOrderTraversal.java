package trees2_150323;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50154/assignment/problems/378?navref=cl_tt_nv
public class VerticalOrderTraversal {

	public  ArrayList<ArrayList<Integer>>  verticalOrderTraversal(TreeNode root) {
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
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i=min; i<=max; i++) {
			ans.add(hm.get(i));
		}
		return ans;
	}
	public void printArray(int[][] A) {
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[i].length; j++)
				System.out.print(A[i][j] +" ");
			System.out.println();
		}
	}
	public void printArrayList(ArrayList<ArrayList<Integer>> A) {
		for(int i=0; i<A.size(); i++)
			System.out.print(A.get(i)+" ");
		System.out.println();
		
	}
	static class PairScalerSol {
	    TreeNode t;
	    int x;
	    PairScalerSol(TreeNode t, int x) {
	      this.t = t;
	      this.x = x;
	    }
	  }
	  public ArrayList < ArrayList < Integer >> verticalOrderTraversalScalerSol(TreeNode root) {
	    ArrayList < ArrayList < Integer >> ans = new ArrayList < ArrayList < Integer >> ();

	    ArrayList < Integer > ar = new ArrayList < Integer > ();
	    if (root == null) {
	      return ans;
	    }

	    TreeMap < Integer, ArrayList < Integer >> tm = new TreeMap < > ();
	    Queue < PairScalerSol > q = new LinkedList < PairScalerSol > ();
	    q.add(new PairScalerSol(root, 0));

	    while (!q.isEmpty()) {
	      PairScalerSol p = q.poll();
	      int v = p.t.data;
	      int x = p.x;
	      ar = new ArrayList < Integer > ();
	      if (tm.containsKey(x)) {
	        ar = tm.get(x);
	        ar.add(v);
	      } else {
	        ar.add(v);
	      }

	      tm.put(x, ar);
	      if (p.t.left != null) {
	        q.add(new PairScalerSol(p.t.left, x - 1));
	      }
	      if (p.t.right != null) {
	        q.add(new PairScalerSol(p.t.right, x + 1));
	      }
	    }
	    for (int x: tm.keySet()) {
	      ArrayList < Integer > f = tm.get(x);
	      ans.add(f);
	    }
	    return ans;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerticalOrderTraversal vot = new VerticalOrderTraversal();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		ArrayList<ArrayList<Integer>>  A = vot.verticalOrderTraversal(four);
		vot.printArrayList(A);
	}
}
class Pair<x, y> {
	TreeNode x; Integer y;
	Pair(TreeNode x, Integer y){
		this.x = x;
		this.y = y;
	}
}

