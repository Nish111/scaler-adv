package graphs1_introbfsdfs_080523;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/70950/homework/problems/516/?navref=cl_pb_nv_tb
public class FirstDepthFirstSearch {
/*
 * Intuition: As the question mentions, the u->v relationship is A[i]->i+1. i.e. 
 * Each node i can have only one parent node due to linear relation with A[i]. 
 * Therefore indegree of all nodes <= 1. (0 for root nodes).

In this linearly parent-child relation, a full-fledged graph theory seems redundant. 
We can start at B and traverse back using the index until the current node == C or the 
current node < C (in this case the C is not in this path as u <= v from the question.)
 */
	public int search(int[] A, int B, int C) {
		  int x = B;
	        while(x>=C)
	        {
	            if(x == C)
	            {
	                return 1;
	            }
	            
	            x = A[x-1]; //set x as it’s parent.
	        }
	        return 0;
	}
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	  static int maxn = 100009;
	  static int[] vis = new int[maxn];
	  static ArrayList < ArrayList < Integer > > adj;
	  public static void graphScalerSol() {
	    adj = new ArrayList < ArrayList < Integer > > (maxn);
	    for (int i = 0; i < maxn; i++) {
	      vis[i] = 0;
	      adj.add(new ArrayList < Integer > ());
	    }
	  }
	  public int solveScalerSol(int[] A, final int B, final int C) {
	    graphScalerSol();
	    int n = A.length;
	    for (int i = 1; i < n; i++) {
	      adj.get(A[i]).add(i + 1);
	    }
	    if (dfsScalerSol(C, B) == true)
	      return 1;
	    return 0;
	  }
	  public static boolean dfsScalerSol(int s, int x) {
	    if (s == x)
	      return true;
	    vis[s] = 1;
	    int i, j, k = adj.get(s).size();
	    for (i = 0; i < k; i++) {
	      j = adj.get(s).get(i);
	      if (vis[j] == 0 && dfsScalerSol(j, x) == true)
	        return true;
	    }
	    return false;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstDepthFirstSearch fdfs = new FirstDepthFirstSearch();
		int[] A = {1,1,2};
		System.out.println(fdfs.search(A, 1, 2)); //0 
		System.out.println(fdfs.search(A, 2, 1));// 1
	}

}
