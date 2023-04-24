package dp2_210423;
// https://www.scaler.com/academy/mentee-dashboard/class/70944/assignment/problems/368?navref=cl_tt_lst_sl
public class NDigitNumberSum {

	public int findSum(int N, int S) {
		int[][] dp = new int[N+1][S+1];
		int mod = 1000000007;
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++)
				dp[i][j]=-1;
		}
		dp[1][0]=0;
		/*
		 * for(int i=0; i<=9; i++) { if(i<S) dp[1][i]=1; } for(int i=10; i<=S;i++)
		 * dp[1][i] = 0;
		 */
		return (int) findWays(N, S, dp)%mod;
	}
	public long findWays(int N, int S, int[][] dp) {
		int mod = 1000000007;
		if(N==1) {
			if(S>=1 && S<=9) return 1;
			else return 0;
		}
		if(dp[N][S] !=-1) return dp[N][S]%mod;
		long ans=0;
		for(int i=0; i<=9; i++) {
			if(i<S) {
				ans=(ans+findWays(N-1, S-i, dp))%mod;
			}
		}
		dp[N][S] = (int) ans;
		return dp[N][S];
	}
	public int findSumBU(int N, int S) { // bottom up iterative-needs prev solved
		int[][] dp = new int[N+1][S+1];
		int mod = 1000000007;
		for(int i=0; i<=N; i++) { 
			 dp[i][0]=0; 
		}
		for(int i=0; i<=S; i++) { 
			 dp[0][i]=0; 
		}
		for(int i=1; i<=N; i++) { 
			dp[i][1] = 1;
		} 
		for(int i=1; i<=S;i++) {
			dp[1][i]=1; 
		}
		//printArray(dp);
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=S; j++) {
				int ans=0;
				for(int d=0; d<=9; d++) {
					if(j>d) {
						ans += dp[i-1][j-d];
						ans%=mod;
					}
					dp[i][j] = ans;
				}
			}
		}
		//printArray(dp);
		return dp[N][S]%mod;
	}
	public void printArray(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	 public int dp[][] = new int[1001][10001];
	    int recScalerSol(int id, int sum) {
	        if (sum < 0)
	            return 0;
	        if (id == 0 && sum == 0)
	            return 1;
	        if (id == 0)
	            return 0;
	        if (dp[id][sum] != -1)
	            return dp[id][sum];
	        int ans = 0;
	        for (int i = 0; i < 10; i++) {
	            ans += recScalerSol(id - 1, sum - i);
	            ans %= 1000000007;
	        }
	        return dp[id][sum] = ans;
	    }
	    public int solveScalerSol(int A, int B) {
	        int ans = 0;
	        for (int i = 0; i < A + 1; i++) {
	            for (int j = 0; j < B + 1; j++)
	                dp[i][j] = -1;
	        }
	        for (int i = 1; i < 10; i++) {
	            ans += recScalerSol(A - 1, B - i);
	            ans %= 1000000007;
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NDigitNumberSum ndn = new NDigitNumberSum();
		System.out.println(ndn.findSum(3, 3)); // 6
		System.out.println(ndn.findSum(2, 4)); // 4
		System.out.println(ndn.findSum(1, 3)); // 1
		System.out.println(ndn.findSum(75, 22)); // 478432066
		System.out.println(ndn.findSumBU(3, 3)); // 6
		System.out.println(ndn.findSumBU(2, 4)); // 4
		System.out.println(ndn.findSumBU(1, 3)); // 1
		System.out.println(ndn.findSumBU(75, 22)); // 478432066 -- 744109202
		//some issue with mod for BU approach
	}

}
