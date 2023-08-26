package graphs2_graphcoloring_100523;

import java.util.ArrayList;
import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/70951/homework/problems/9428/?navref=cl_pb_nv_tb
public class PoisonousGraph {
    int mod = 998244353;
    //FOR COUNTING ONES AND NO. OF NODES IN THE COMPONENET
    int ones, nodesCount;
    public int solve(int A, ArrayList < ArrayList < Integer >> B) {
        boolean visited[] = new boolean[A + 1];
        int color[] = new int[A + 1];
        HashMap < Integer, ArrayList < Integer >> graph = new HashMap < > ();
        boolean ans = true;

        //GRAPH PREP
        for (int i = 0; i < B.size(); i++) {
            int source = B.get(i).get(0), dest = B.get(i).get(1);
            if (!graph.containsKey(source)) graph.put(source, new ArrayList < > ());
            graph.get(source).add(dest);
            if (!graph.containsKey(dest)) graph.put(dest, new ArrayList < > ());
            graph.get(dest).add(source);
        }

        //COUNTING DISCONNECTED COMPONENETS
        int size = graph.size(), discComp = 0;
        //IF ALL COMPONENETS ARE DISCONNECTED THE THER WILL 3^N WAYS
        if (size == 0) return fastExpo(3, A);

        discComp = A - size;
        long ways = 1;

        //CHECKING EVEREY NODE BECAUSE OF DISCONNECTED CASE
        //GOING THROUGH THE DEPTH OF EACH COMPONENET AND GETTING THE COUNT OF ONE
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                ones = 0;
                nodesCount = 0;
                ans = ans & DFS(i, graph, visited, color);
                if (!ans) return 0;
                ways = ways * 1L * ((fastExpo(2, ones) + fastExpo(2, nodesCount - ones)) % mod);
                ways %= mod;
            }
        }
        return (int)(ways % mod);
    }

    public int solve(int A, int[][] B) {
        boolean visited[] = new boolean[A + 1];
        int color[] = new int[A + 1];
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        for (int[] row : B) {
            ArrayList<Integer> arrayListRow = new ArrayList<>();
            for (int num : row) {
                arrayListRow.add(num);
            }
            x.add(arrayListRow);
        }
        HashMap < Integer, ArrayList < Integer >> graph = new HashMap < > ();
        boolean ans = true;

        //GRAPH PREP
        for (int i = 0; i < x.size(); i++) {
            int source = x.get(i).get(0), dest = x.get(i).get(1);
            if (!graph.containsKey(source)) graph.put(source, new ArrayList < > ());
            graph.get(source).add(dest);
            if (!graph.containsKey(dest)) graph.put(dest, new ArrayList < > ());
            graph.get(dest).add(source);
        }

        //COUNTING DISCONNECTED COMPONENETS
        int size = graph.size(), discComp = 0;
        //IF ALL COMPONENETS ARE DISCONNECTED THE THER WILL 3^N WAYS
        if (size == 0) return fastExpo(3, A);

        discComp = A - size;
        long ways = 1;

        //CHECKING EVEREY NODE BECAUSE OF DISCONNECTED CASE
        //GOING THROUGH THE DEPTH OF EACH COMPONENET AND GETTING THE COUNT OF ONE
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                ones = 0;
                nodesCount = 0;
                ans = ans & DFS(i, graph, visited, color);
                if (!ans) return 0;
                ways = ways * 1L * ((fastExpo(2, ones) + fastExpo(2, nodesCount - ones)) % mod);
                ways %= mod;
            }
        }
        return (int)(ways % mod);
    }
    private boolean DFS(int source, HashMap < Integer, ArrayList < Integer >> graph, boolean[] visited, int[] color) {
        visited[source] = true;
        nodesCount++;

        //WHEN THERE IS NO NEB NODE CONNECTION 
        if (!graph.containsKey(source)) return true;

        //GOING THROUGH ALL THE NEB.
        for (int neb: graph.get(source)) {
            if (visited[neb]) {
                if (color[neb] == color[source]) return false;
            } else {
                color[neb] = 1 - color[source];
                //WHENEVER COLORED ONE INCREASE THE COUNT
                if (color[neb] == 1) ones++;
                if (!DFS(neb, graph, visited, color)) return false;
            }
        }
        return true;
    }

    //FOR GETTING THE POWER
    private int fastExpo(int a, int n) {
        if (n == 0) return 1;
        long ha = fastExpo(a, n / 2) % mod;
        long hp = (ha * ha) % mod;
        if ((n & 1) == 1) return (int)((hp * a) % mod);
        return (int) hp;
    }
    public static void main(String[] args) {
		PoisonousGraph pg = new PoisonousGraph();
		int A = 2;
		int[][] B = {{1, 2}};
		System.out.println(pg.solve(A, B)); // 4
		int a = 4;
		int[][] b = {{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
		System.out.println(pg.solve(a, b));// 0
	}
}