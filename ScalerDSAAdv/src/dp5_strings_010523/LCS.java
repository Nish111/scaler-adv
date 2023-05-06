package dp5_strings_010523;

// https://www.scaler.com/academy/mentee-dashboard/class/70947/assignment/problems/4438?navref=cl_tt_lst_sl
public class LCS {
	public int findLCS(String A, String B) {
		int N = A.length();
		int M = B.length();
		int dp[][] = new int[N][M];
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				dp[i][j]=-1;
		int ans = lcs(N-1, M-1, dp, A, B);
		return ans;
	}
	public int lcs(int i, int j, int[][] dp, String A, String B) {
		if(i==-1 || j==-1) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		if(A.charAt(i)==B.charAt(j)) {
			dp[i][j] = lcs(i-1, j-1, dp, A, B)+1;
		} else {
			dp[i][j] = Math.max(lcs(i-1, j, dp, A, B), lcs(i, j-1, dp, A, B));
		}
		return dp[i][j];
	}
	 public int solveScalerSol(String A, String B) {
	        int m = A.length(), n = B.length();
	        int[][] L = new int[m + 1][n + 1];
	        int i, j;
	        for (i = 0; i <= m; i++) {
	            for (j = 0; j <= n; j++) {
	                //Base condition
	                if (i == 0 || j == 0)
	                    L[i][j] = 0;
	                else if (A.charAt(i - 1) == B.charAt(j - 1))
	                    L[i][j] = L[i - 1][j - 1] + 1;
	                else
	                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
	            }
	        }
	        return L[m][n];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCS l = new LCS();
		System.out.println(l.findLCS("abc", "acd")); // 2
		System.out.println(l.findLCS("acd", "aeb")); // 1
	}

}
