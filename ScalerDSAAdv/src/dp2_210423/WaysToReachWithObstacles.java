package dp2_210423;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/70944/assignment/problems/8?navref=cl_tt_lst_sl
public class WaysToReachWithObstacles {

	public int findWaysToReach(int n, int m) { // to modify for obstacles
		// making 1 to n m for better visibility
		int[][] dp = new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			for(int j=0; j<=m;j++) {
				dp[i][j] = -1;
			}
		}
		for(int i=1;i<=n; i++) {
			dp[i][1] = 1;
		}
		for(int i=1;i<=m; i++) {
			dp[1][i] = 1;
		}
		printArray(dp);
		int ans = findWaysTD(n,m,dp);
		printArray(dp);
		return ans;
	}
	public int findWaysTD(int n, int m, int[][] dp) { // to modify for obstacles
		if(dp[n][m] != -1) return dp[n][m];
		dp[n][m] = findWaysTD(n-1, m, dp)+ findWaysTD(n, m-1, dp);
		return dp[n][m];
	}
	public int findWaysBU(int[][] A) { // working correctly
		int n = A.length; int m = A[0].length;
		int[][] dp = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1; j<=m;j++) {
				dp[i][j] = A[i-1][j-1];
			}
		}
		//printArray(dp);
		for(int i=1;i<=n;i++) {
			for(int j=1; j<=m;j++) {
				if(dp[i][j] != 1) dp[i][j]=-1;
			}
		}
		//printArray(dp);
		for(int i=1;i<=n;i++) {
			for(int j=1; j<=m;j++) {
				if(dp[i][j] == 1) dp[i][j]=0;
			}
		}
		//printArray(dp);
		for(int i=1;i<=n;i++) {
			for(int j=1; j<=m;j++) {
				if(dp[i][j] == -1) dp[i][j]=1;
			}
		}
		//printArray(dp);
		if(dp[1][1] !=0) dp[1][1] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=1;j<=m; j++) {
				if(i==1 && j==1) continue;
				if(dp[i][j]!=0) dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		printArray(dp);
		return dp[n][m];
	}
	public void printArray(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	private int mem[][];
    private ArrayList < ArrayList < Integer >> A;
    public int uniquePathsWithObstaclesScalerSol(ArrayList < ArrayList < Integer >> A) {
        int m, n;
        if (A == null)
            return 0;
        m = A.size();
        if (m == 0)
            return 0;
        n = A.get(0).size();
        if (n == 0)
            return 0;
        mem = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(mem[i], -1);
        this.A = A;
        if (A.get(0).get(0) == 0)
            mem[0][0] = 1;
        recScalerSol(m - 1, n - 1);
        return mem[m - 1][n - 1];
    }

    public int recScalerSol(int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (mem[i][j] != -1)
            return mem[i][j];
        if (A.get(i).get(j) == 1)
            return mem[i][j] = 0;
        mem[i][j] = recScalerSol(i - 1, j) + recScalerSol(i, j - 1);
        return mem[i][j];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaysToReachWithObstacles wtr = new WaysToReachWithObstacles();
		int[][] A = {{0,0,0}, {0,1,0}, {0,0,0}};
		//System.out.println(wtr.findWaysToReach(A)); // 35
		System.out.println(wtr.findWaysBU(A)); // 2
		int[][] B = {{0,0,0}, {1,1,1}, {0,0,0}};
		//System.out.println(wtr.findWaysToReach(A)); // 35
		System.out.println(wtr.findWaysBU(B)); // 0
	}

}
