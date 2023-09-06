package dp3_knapsack_240423;
// https://www.scaler.com/academy/mentee-dashboard/class/70945/homework/problems/4806/?navref=cl_pb_nv_tb
public class WaysToSendSignal {
    public int solve(int A) {
        int[][] dp = new int[A + 1][2];
        int MOD = 1000000007;

        dp[1][0] = 1;  // Number of ways with the first light off
        dp[1][1] = 1;  // Number of ways with the first light on

        for (int i = 2; i <= A; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = dp[i - 1][0];
        }

        int ans = (dp[A][0] + dp[A][1]) % MOD;
        return ans;
    }
    public int solveScalerSol(int A) {
        long mod = 1000000007;
        long[][] dp = new long[2][A + 1];
        dp[0][1] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= A; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[0][i] %= mod;
            dp[1][i] = dp[0][i - 1] % mod;
        }
        long res = (dp[0][A] + dp[1][A]) % mod;
        return (int) res;
    }
}
