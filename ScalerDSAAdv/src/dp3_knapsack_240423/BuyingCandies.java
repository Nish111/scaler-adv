package dp3_knapsack_240423;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/70945/homework/problems/9011/?navref=cl_pb_nv_tb
public class BuyingCandies {
    int [][] dp;
    public int helper(int[] candy, int[]sweetness, int[] cost,int i, int cap ){
        if(i<0 || cap==0){
            return 0;
        }

        if(dp[i][cap] != -1){
            return dp[i][cap];
        }

        int a= 0;
        if(cap >= cost[i]){
            a = helper(candy, sweetness, cost, i, cap-cost[i])+sweetness[i];
        }
        int b = helper(candy, sweetness, cost, i-1, cap);

        int ans = Math.max(a,b);
        dp[i][cap] = ans;

        return ans;
    }
    public int solve(int[] A, int[] B, int[] C, int D) {
         int n = B.length;
         dp = new int [n][D+1];
            for(int i = 0; i<n; i++){
                Arrays.fill(dp[i], -1);
            }

        for(int i = 0; i<n; i++){
            B[i] = A[i] * B[i];
        }

        return helper(A,B, C, n-1, D);
    }
    public int solveScalerSol(int[] A, int[] B, int[] C, int D) {
        int[] dp = new int[D + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < A.length; i++) {
            for (int j = C[i]; j <= D; j++) {
                dp[j] = Math.max(dp[j], dp[j - C[i]] + A[i] * B[i]);
            }
        }
        return dp[D];
    }
}
