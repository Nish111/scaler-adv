package graphs2_graphcoloring_100523;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PoisonousGraphScalerSol {
    static int maxn = 300009;
    static long mod = 998244353;
    static int[] visited = new int[maxn];
    static long[] dp = new long[maxn];
    static ArrayList < ArrayList < Integer > > adj;
    static int a, b;
    public static void graph() {
        adj = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = -1;
            adj.add(new ArrayList < Integer > ());
        }
    }
    public static void pre() {
        dp[0] = 1;
        for (int i = 1; i < maxn; i++) {
            dp[i] = ((long) 2) * dp[i - 1];
            dp[i] %= mod;
        }
    }
    public int solve(int A, int[][] B) {
        graph();
        pre();
        for (int[] edge: B) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        long ans = 1;
        for (int i = 1; i <= A; i++) {
            if (visited[i] == -1) {
                a = 0;
                b = 0;
                if (bfs(i) == false)
                    return 0;
                long res = ((dp[a] % mod) + (dp[b] % mod)) % mod;
                ans = ((ans % mod) * (res % mod)) % mod;
            }
        }
        return (int) ans;
    }
    public static boolean bfs(int s) {
        visited[s] = 1;
        a++;
        Queue < Integer > q = new ArrayDeque < > ();
        q.offer(s);
        while (q.size() > 0) {
            int temp = q.poll();
            for (int v: adj.get(temp)) {
                if (visited[v] == -1) {
                    visited[v] = 1 - visited[temp];
                    if (visited[v] == 0) b++;
                    else a++;
                    q.offer(v);
                } else if (visited[v] == visited[temp])
                    return false;
            }
        }
        return true;
    }
}
