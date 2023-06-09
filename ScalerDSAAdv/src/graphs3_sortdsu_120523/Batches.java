package graphs3_sortdsu_120523;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/70952/assignment/problems/4974/?navref=cl_pb_nv_tb
public class Batches {

	public int solve(int A, int[] B, int[][] C, int D) {
        ArrayList<Integer>[] adjList = new ArrayList[A+1];
        int ans = 0;
        boolean[] vis = new boolean[A+1];
        for(int i=0; i<C.length; i++) {
            if(adjList[C[i][0]]==null) adjList[C[i][0]] = new ArrayList<Integer>();
            if(adjList[C[i][1]]==null) adjList[C[i][1]] = new ArrayList<Integer>();
            adjList[C[i][0]].add(C[i][1]);
            adjList[C[i][1]].add(C[i][0]);
        }
        for(int i=1; i<=A; i++) {
            if(!vis[i]) {
                int strength = dfs(i,B,vis,adjList);
                if(strength>=D) ans++;
            }
        }
        return ans;
    }
    // dfs = getBatchStrength
    private int dfs(int i, int[] strengths, boolean[] vis, ArrayList<Integer>[] adjList) {
        vis[i] = true;
        int strength = strengths[i-1];
        if(adjList[i]==null) return strength;
        for(int j=0; j<adjList[i].size(); j++) {
            int k = adjList[i].get(j);
            if(!vis[k]) {
                strength+=dfs(k,strengths,vis,adjList);
            }
        }
        return strength;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				 Batches b = new Batches();
				 int[] B = {1, 6, 7, 2, 9, 4, 5};
		 int[][] C = {{1, 2}, {2, 3}, {5, 6}, {5, 7}};
		 System.out.println(b.solve(7, B, C, 12)); // 2

		int[] A = {1, 2, 3, 4, 5};
		int[][] D = {{1, 5}, {2, 3}};
		System.out.println(b.solve(5, A, D, 6)); // 1
	}

}
