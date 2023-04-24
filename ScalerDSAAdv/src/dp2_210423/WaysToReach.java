package dp2_210423;

public class WaysToReach {

	public int findWaysToReach(int n, int m) {
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
	public int findWaysTD(int n, int m, int[][] dp) {
		if(dp[n][m] != -1) return dp[n][m];
		dp[n][m] = findWaysTD(n-1, m, dp)+ findWaysTD(n, m-1, dp);
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaysToReach wtr = new WaysToReach();
		System.out.println(wtr.findWaysToReach(5, 4)); // 35
	}

}
