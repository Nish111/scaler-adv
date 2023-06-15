package graphs4_mst_160523;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/85791/assignment/problems/4707/?navref=cl_pb_nv_tb
public class AnotherBFS {

	public int solve(int A, int[][] B, int C, int D) {
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i = 0; i < A; i++){
	        adj.add(new ArrayList<Pair>());
	    }
	    int n = B.length;
	    for(int i = 0; i < n; i++){
	        adj.get(B[i][0]).add(new Pair(B[i][1], B[i][2]));
	        adj.get(B[i][1]).add(new Pair(B[i][0], B[i][2]));
	    }
	    boolean visited[] = new boolean[A];
	    int cost = 0;
	    boolean flag = false;
	    PriorityQueue<EdgeCost> pq = new PriorityQueue<>();
	    pq.add(new EdgeCost(C, 0));
	    while(!pq.isEmpty()){
	        int currNode = pq.peek().node;
	        int nodeCost = pq.peek().cost;
	        pq.remove();
	        cost = nodeCost;
	        if(currNode == D){
	            flag = true;
	            break;
	        }
	        visited[currNode] = true;
	        for(Pair neighbor : adj.get(currNode)){
	            if(!visited[neighbor.u]){
	                pq.add(new EdgeCost(neighbor.u, neighbor.weight + nodeCost));
	            }
	        }

	    }
	    if(!flag){
	        return -1;
	    }
	    return cost;
	}
	static int maxn = 200009;
    static int[] vis = new int[maxn];
    static ArrayList < ArrayList < Integer > > adj;
    public static void graph() {
        adj = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            vis[i] = 0;
            adj.add(new ArrayList < Integer > ());
        }
    }
    public int solveScalerSol(int A, int[][] B, int C, int D) {
        graph();
        int n = A;
        for (int[] it: B) {
            int x = it[0];
            int y = it[1];
            int w = it[2];
            if (w == 1) {
                adj.get(x).add(y);
                adj.get(y).add(x);
            } else {
                adj.get(x).add(x + n);
                adj.get(x + n).add(y);
                adj.get(y).add(y + n);
                adj.get(y + n).add(x);
            }
        }
        return bfsScalerSol(C, D);
    }
    public static int bfsScalerSol(int source, int destination) {
        vis[source] = 1;
        Queue < PairScalerSol > q = new ArrayDeque < PairScalerSol > ();
        q.offer(new PairScalerSol(source, 0));
        while (q.size() > 0) {
            PairScalerSol p = q.poll();
            int x = p.ff;
            int w = p.ss;
            if (x == destination)
                return w;
            for (int v: adj.get(x)) {
                if (vis[v] == 0) {
                    vis[v] = 1;
                    q.offer(new PairScalerSol(v, w + 1));
                }
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnotherBFS ab = new AnotherBFS();
		int[][] B = {{2, 5, 1}, {1, 3, 1}, {0, 5, 2}, {0, 2, 2}, {1, 4, 1}, {0, 1, 1}}; 
		System.out.println(ab.solve(6, B, 3, 2));
		int[][] A = {{0, 1, 1}};
		System.out.println(ab.solve(2, A, 0, 1));
	}

}
class Pair{
    int u;
    int weight;
    Pair(int u, int weight){
        this.u = u;
        this.weight = weight;
    }
}
class EdgeCost implements Comparable<EdgeCost>{
    int node;
    int cost;
    EdgeCost(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(EdgeCost ec2){
        return this.cost - ec2.cost;
    }
}

class PairScalerSol {
    int ff;
    int ss;
    public PairScalerSol(int a, int b) {
        this.ff = a;
        this.ss = b;
    }
}