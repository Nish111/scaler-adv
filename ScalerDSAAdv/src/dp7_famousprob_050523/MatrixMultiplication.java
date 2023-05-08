package dp7_famousprob_050523;
// https://www.scaler.com/academy/mentee-dashboard/class/70949/assignment/problems/4822/?navref=cl_pb_nv_tb
public class MatrixMultiplication {

	public int costMM(int[] A) {
		int N = A.length;
		int[][] dp = new int[N+1][N+1];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				dp[i][j]=-1;
			}
		}
		int cost = minCost(1, N-1, A, dp);
		printArray(dp);
		return cost;
	}
	public int minCost(int i, int j, int[] A, int[][] dp) {
		if(i==j) return 0;
		if(i==(j-1)) return (A[i-1]* A[j]*A[i]);
		if(dp[i][j]!=-1) return dp[i][j];
		int ans = Integer.MAX_VALUE;
		for(int x=i; x<j; x++) {
			int cost_1 = minCost(i, x, A, dp);
			int cost_2 = minCost(x+1, j, A, dp);
			int finalMulCost = A[i-1]*A[j]*A[x];
			ans = Math.min(ans, cost_1+cost_2+finalMulCost);
		}
		dp[i][j] = ans;
		return dp[i][j];
	}
	public void printArray(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	public int solveScalerSol(int[] A) {
        int n = A.length;
        int[][] m = new int[n][n];
        int i, j, k, L, q;
        for (i = 1; i < n; i++)
            m[i][i] = 0;
        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                // try to divide at every i<=k<=j-1 
                for (k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + A[i - 1] * A[k] * A[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
        return m[1][n - 1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixMultiplication mm = new MatrixMultiplication();
		int[] A = {10, 30, 5, 60};
		System.out.println(mm.costMM(A));
	}

}
