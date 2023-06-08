package graphs3_sortdsu_120523;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/70952/assignment/problems/377/?navref=cl_pb_nv_tb
public class PossibilityOfFinishing {

	public int solve(int A, int[] B, int[] C) {
        ArrayList<Integer>[] graph = new ArrayList[A+1];
        // Initialize graph array of list
        for(int i=0; i<=A; i++){
            graph[i] = new ArrayList<Integer>();
        }

        // Create incoming edges array
        int[] incoming_edges = new int[A+1];

        // Add values to directed graph array
        for(int i=0; i<B.length; i++){
            graph[B[i]].add(C[i]);
            incoming_edges[C[i]] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=A; i++){
            if(incoming_edges[i] == 0) q.add(i);
        }

        if(q.size() == 0) return 0;

        while(q.isEmpty() == false){
            int current = q.remove();
            for(int i=0; i<graph[current].size(); i++){
                incoming_edges[graph[current].get(i)] -= 1;
                if(incoming_edges[graph[current].get(i)] == 0) q.add(graph[current].get(i));
            }
        }

        for(int i: incoming_edges){
            if(i != 0) return 0;
        }

        return 1;
    }
	static int maxn = 100009;
    static ArrayList < ArrayList < Integer > > g;
    static int[] visited = new int[maxn];
    static int f = 0;
    public static void graphScalerSol() {
        g = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = 0;
            g.add(new ArrayList < Integer > ());
        }
    }
    public int solveScalerSol(int A, int[] B, int[] C) {
        graphScalerSol();
        for (int i = 0; i < B.length; i++) {
            g.get(B[i]).add(C[i]);
        }
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0) {
                f = 0;
                check_cycleScalerSol(i);
                if (f == 1)
                    break;
            }
        }
        f = 1 - f;
        return f;
    }
    public static void check_cycleScalerSol(int u) {
        visited[u] = 1;
        for (int v: g.get(u)) {
            if (visited[v] == 0)
                check_cycleScalerSol(v);
            else if (visited[v] == 1)
                f = 1;
        }
        visited[u] = 2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PossibilityOfFinishing pof = new PossibilityOfFinishing();
		int[] B = {1,2};
		int[] C = {2,3};
		System.out.println(pof.solve(3, B, C));
		int[]b = {1,2};
		int[] c = {2,1};
		System.out.println(pof.solve(2, b, c));
	}

}
