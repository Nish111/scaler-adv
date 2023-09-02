package dp3_knapsack_240423;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/70945/homework/problems/385/?navref=cl_pb_nv_tb
public class TusharsBirthdayParty {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A, final int[] B, final int[] C) {
	        int maxCapacity = 0;
	        for (int capacity : A) {
	            maxCapacity = Math.max(maxCapacity, capacity);
	        }
	        int[] dp = new int[maxCapacity + 1];
	        // Initialize the DP table with a large value
	        Arrays.fill(dp, Integer.MAX_VALUE);
	        // Base case Minimum cost for capacity 0 is 0
	        dp[0] = 0;
	        // Iterate over each dish
	        for (int i = 0; i < B.length; i++) {
	            int dishFilling = B[i];
	            int dishCost = C[i];
	            // Iterate over each capacity from dishFilling to maxCapacity
	            for (int capacity = dishFilling; capacity <= maxCapacity; capacity++) {
	                if (dp[capacity - dishFilling] != Integer.MAX_VALUE) {
	                    dp[capacity] = Math.min(dp[capacity], dp[capacity - dishFilling] + dishCost);
	                }
	            }
	        }
	        int minCost = 0;  
	        // Calculate the minimum cost for each friend's eating capacity
	        for (int capacity : A) {
	            minCost += dp[capacity];
	        }
	        return minCost;
	    }
}
