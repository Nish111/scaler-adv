package graphs3_sortdsu_120523;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/70952/homework/problems/4357/?navref=cl_pb_nv_tb
public class MaximumDepth {

	public int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
		ArrayList<Integer>[] adjList = new ArrayList[A+1];
        for(int i=0; i<B.length; i++) {
            if(adjList[B[i]]==null) adjList[B[i]] = new ArrayList<Integer>();
            if(adjList[C[i]]==null) adjList[C[i]] = new ArrayList<Integer>();
            adjList[B[i]].add(C[i]);
            adjList[C[i]].add(B[i]);
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[A+1];
        int level = 0;
        queue.add(1);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int x = queue.poll();
                vis[x] = true;
                if(map.containsKey(level)) {
                    map.get(level).add(D[x-1]);
                }else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(D[x-1]);
                    map.put(level, temp);
                }
                if(adjList[x]==null) continue;
                for(int j=0; j<adjList[x].size(); j++) {
                    int l = adjList[x].get(j);
                    if(!vis[l]) queue.add(l);
                }
            }
            Collections.sort(map.get(level));
            level++;
        }
        int[] ans = new int[E.length];
        for(int i=0; i<E.length; i++) {
            ans[i] = binarySearch(map.get(E[i]%level), F[i]);
        }
        return ans;
    }
    private int binarySearch(ArrayList<Integer> list, int target) {
        int ans = -1;
        int low = 0, high = list.size()-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(list.get(mid)>=target) {
                ans=list.get(mid);
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
    static int maxn = 100009;
    static int n, q;
    static int mx = 0;
    static int[] val = new int[maxn];
    static ArrayList < ArrayList < Integer > > adj;
    static ArrayList < ArrayList < Integer > > lvl;
    public static void graphScalerSol() {
        adj = new ArrayList < ArrayList < Integer > > (maxn);
        lvl = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList < Integer > ());
            lvl.add(new ArrayList < Integer > ());
        }
        mx = 0;
    }
    public int[] solveScalerSol(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        graphScalerSol();
        n = A;
        q = F.length;
        for (int i = 0; i < n; i++)
            val[i + 1] = D[i];
        for (int i = 0; i < n - 1; i++) {
            adj.get(B[i]).add(C[i]);
            adj.get(C[i]).add(B[i]);
        }
        mx = 0;
        dfsScalerSol(1, 1, 0);
        for (int i = 0; i < maxn; i++) {
            Collections.sort(lvl.get(i));
        }
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int l = E[i];
            int x = F[i];
            l %= (mx + 1);
            int it = lowerBoundScalerSol(lvl.get(l), 0, lvl.get(l).size(), x);
            if (it == lvl.get(l).size())
                res[i] = -1;
            else res[i] = lvl.get(l).get(it);
        }
        return res;
    }
    public static void dfsScalerSol(int u, int v, int d) {
        mx = Math.max(mx, d);
        lvl.get(d).add(val[u]);
        for (int i: adj.get(u)) {
            if (i == v) continue;
            dfsScalerSol(i, u, d + 1);
        }
    }
    static int lowerBoundScalerSol(ArrayList < Integer > a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element > a.get(middle)) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumDepth md = new MaximumDepth();
		int[] B = {1, 4, 3, 1};
		int[] C = {5, 2, 4, 4};
		int[] D = {7, 38, 27, 37, 1};
		int[] E = {1, 1, 2};
		int[] F = {32, 18, 26};
		int[] X = md.solve(5, B, C, D, E, F);
		md.printArray(X);
		int[] I = {1, 2};
		int[] J = {3, 1};
		int[] K = {7, 15, 27};
		int[] L = {1, 10, 1};
		int[] M = {29, 6, 26};
		int[] Y = md.solve(3, I, J, K, L, M);
	}
	private void printArray(int[] x) {
		// TODO Auto-generated method stub
		for(int i=0; i<x.length; i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}

}
