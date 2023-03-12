package math4_combinatorics_240123;
// https://www.scaler.com/academy/mentee-dashboard/class/50134/assignment/problems/4111/submissions
public class CombinationCode {

	public int nCRCode(int n, int r) { // approach 1 O(n*r) O(n*r)
		int[][] arr = new int[n+1][r+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=r; j++) {
				if(j==0) arr[i][j] = 1;
				else if(i==j) arr[i][j] = 1;
				else if(j>i) arr[i][j] = 0;
				else {
					arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
				}
			}
		}
		return arr[n][r];
	}
	// approach 2
	 public int solve(int A, int B, int C) {
		 int[][] arr = new int[A+1][B+1];
			for(int i=0; i<=A; i++) {
				for(int j=0; j<=B; j++) {
					if(j==0) arr[i][j] = 1;
					else if(i==j) arr[i][j] = 1;
					else if(j>i) arr[i][j] = 0;
					else {
						arr[i][j] = (arr[i-1][j-1]+arr[i-1][j])%C;
					}
				}
			}
			return arr[A][B]%C;
	    }
	 public int solveScalerSol(int A, int B, int C) {
	        // dp[n][r] stores the value of nCr
	        int[][] dp = new int[A + 1][B + 1];
	        for(int i = 0; i <= A; i++) {
	            for(int j = 0; j <= Math.min(i, B); j++) {
	                if(j == i || j == 0) {
	                    dp[i][j] = 1;
	                } else {
	                    // nCr = (n - 1)C(r - 1) + (n - 1)Cr
	                    dp[i][j] = (dp[i - 1][j - 1] % C + dp[i - 1][j] % C) % C;
	                }
	            }
	        }
	        return dp[A][B] % C;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationCode cc = new CombinationCode();
		System.out.println(cc.nCRCode(6, 3)); // 20
		System.out.println(cc.solve(5, 2, 13)); // 10
		System.out.println(cc.solve(6, 2, 13)); // 2
	}

}
