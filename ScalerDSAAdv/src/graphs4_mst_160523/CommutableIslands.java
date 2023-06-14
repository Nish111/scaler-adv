package graphs4_mst_160523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
// https://www.scaler.com/academy/mentee-dashboard/class/85791/assignment/problems/376?navref=cl_tt_nv
public class CommutableIslands {
	public int solve(int A, int[][] B) {
		 Arrays.sort(B, Comparator.comparingInt(a -> a[2]));
		 int[] parent = new int[A+1];
		 for(int i=1; i<=A; i++) parent[i]=i;
		 int count = 0;
	     int cost = 0;
	     int mod = 1000000007;
	     for(int i=0; i<B.length; i++) {
	         if(count>=A-1) break;
	         int a = getRoot(B[i][0], parent);
	         int b = getRoot(B[i][1], parent);
	            if(a!=b) {
	                parent[a]=b;
	                count++;
	                cost = (cost+B[i][2])%mod;
	            }
	        }
	        return cost;
    }
	public int getRoot(int x, int[] parent) {
        if(parent[x]==x) return x;
        int ans = getRoot(parent[x],parent);
        parent[x] = ans;
        return ans;
    }
	 static int maxn = 60009;
	    static int[] arr = new int[maxn];
	    static int[] sz = new int[maxn];
	    static ArrayList < pair1 > edges;
	    public int solveScalerSol(int A, int[][] B) {
	        iniScalerSol();
	        for (int[] row: B) {
	            edges.add(new pair1(row[2], row[0], row[1]));
	        }
	        Collections.sort(edges);
	        return kruskalScalerSol();
	    }
	    public static int kruskalScalerSol() {
	        int cost = 0;
	        for (int i = 0; i < edges.size(); i++) {
	            if (root(edges.get(i).b) == root(edges.get(i).c))
	                continue;
	            cost += edges.get(i).a;
	            unScalerSol(edges.get(i).b, edges.get(i).c);
	        }
	        return cost;
	    }
	    public static void iniScalerSol() {
	        edges = new ArrayList < pair1 > ();
	        for (int i = 0; i < maxn; i++) {
	            arr[i] = i;
	            sz[i] = 1;
	        }
	    }
	    public static int root(int a) {
	        while (arr[a] != a) {
	            arr[a] = arr[arr[a]];
	            a = arr[a];
	        }
	        return a;
	    }
	    public static void unScalerSol(int a, int b) {
	        int ra = root(a);
	        int rb = root(b);
	        if (sz[ra] <= sz[rb]) {
	            arr[ra] = rb;
	            sz[rb] += sz[ra];
	        } else {
	            arr[rb] = ra;
	            sz[ra] += sz[rb];
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommutableIslands ci = new CommutableIslands();
		int[][] B = {{1, 2, 1}, {2, 3, 4}, {1, 4, 3}, {4, 3, 2}, {1, 3, 10}};
		System.out.println(ci.solve(4, B));
		int[][] A = {{1, 2, 1}, {2, 3, 2}, {3, 4, 4}, {1, 4, 3}};
		System.out.println(ci.solve(4, A));
	}
}
class pair1 implements Comparable < pair1 > {
    int a, b, c;
    pair1(int e, int f, int g) {
        this.a = e;
        this.b = f;
        this.c = g;
    }
    @Override
    public int compareTo(pair1 aa) {
        return this.a - aa.a;
    }
}
