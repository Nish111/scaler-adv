package graphs5_spa_170523;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MatrixAndAbsoluteDiffScalerSol {
    static int maxn = 10009;
    static ArrayList < ArrayList < Pair1 > > adj;
    static int[] visited = new int[maxn];
    public int solve(int A, int B, int[][] C) {
        adj = new ArrayList < ArrayList < Pair1 > > (maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList < Pair1 > ());
            visited[i] = 0;
        }
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                int u = i * B + j;
                if (i + 1 < A) {
                    int v = (i + 1) * B + j;
                    int w = Math.abs(C[i][j] - C[i + 1][j]);
                    adj.get(u).add(new Pair1(v, w));
                    adj.get(v).add(new Pair1(u, w));
                }
                if (j + 1 < B) {
                    int v = i * B + (j + 1);
                    int w = Math.abs(C[i][j] - C[i][j + 1]);
                    adj.get(u).add(new Pair1(v, w));
                    adj.get(v).add(new Pair1(u, w));
                }
            }
        }
        return prims();
    }
    public static int prims() {
        PriorityQueue < Pair1 > pq = new PriorityQueue < Pair1 > (new CustomComp());
        pq.offer(new Pair1(0, 0));
        int maxe = 0;
        while (pq.size() > 0) {
            Pair1 temp = pq.poll();
            if (visited[temp.b] > 0) continue;
            visited[temp.b] = 1;
            maxe = Math.max(maxe, temp.a);
            for (Pair1 p: adj.get(temp.b)) {
                if (visited[p.a] > 0) continue;
                pq.offer(new Pair1(p.b, p.a));
            }
        }
        return maxe;
    }
}
class Pair1 {
    int a;
    int b;
    public Pair1(int c, int d) {
        this.a = c;
        this.b = d;
    }
}
class CustomComp implements Comparator < Pair1 > {
    @Override
    public int compare(Pair1 aa, Pair1 b) {
        return aa.a - b.a;
    }
}