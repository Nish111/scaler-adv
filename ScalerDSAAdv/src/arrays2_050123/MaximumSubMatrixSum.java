package arrays2_050123;
// https://www.scaler.com/academy/mentee-dashboard/class/50127/assignment/problems/20177/?navref=cl_pb_nv_tb
public class MaximumSubMatrixSum {

	public long solve(int[][] A) { // as per class but kadens need some modifications
		// not able to find what is missing
		int result = Integer.MIN_VALUE;
		int[] pf = new int[A.length];
		int start = 0;
		for(int end=0; end<A.length; end++) {
			for(int i=0; i<A[0].length; i++) {
				pf[i] = pf[i]+A[end][i];
			}
			int curr = cadens(pf);
			result = Math.max(result, curr);
		}
		return result;
	}
	public int cadens(int[] A) {
		/*
		 * int ans = Integer.MIN_VALUE; int carry = 0; for(int i=0; i<A.length; i++) {
		 * if(A[i]<0) carry++; ans = Math.max(ans, A[i]); }
		 */
		//System.out.println(carry);
		//if(carry==A.length) return ans;
		int ans = Integer.MIN_VALUE;
		int carry = 0;
		for(int i=0; i<A.length; i++) {
			int sum = carry + A[i];
			ans = Math.max(ans, sum);
			if(sum>0) carry = sum;
			else carry=0;
		}
		return ans;
	}
	public long solveAgain(int[][] A) { // as per class but kadens need some modifications
		// not able to find what is missing
		long result = Long.MIN_VALUE;
		int n = A.length, m = A[0].length;
		long[][] pf = new long[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				pf[i][j] = A[i][j];
				if(i>0) pf[i][j] +=pf[i-1][j];
				if(j>0) pf[i][j] +=pf[i][j-1];
				if(i>0 && j>0) pf[i][j] -=pf[i-1][j-1];
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				long sum = pf[n-1][m-1];
				if(i>0) sum -=pf[i-1][m-1];
				if(j>0) sum -=pf[n-1][j-1];
				if(i>0 && j>0) sum += pf[i-1][j-1];
				if(sum>result) result = sum;
			}
		}

		return result;
	}
	public long solveScalerSol(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        long suff[][] = new long[n][m];
        suff[n - 1][m - 1] = A[n - 1][m - 1];
        long ans = suff[n - 1][m - 1];
        for(int j = m - 2 ; j >= 0 ; j--){
            suff[n - 1][j] = suff[n - 1][j + 1] + A[n - 1][j];
            ans = Math.max(ans, suff[n - 1][j]);
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            suff[i][m - 1] = suff[i + 1][m - 1] + A[i][m - 1];
            ans = Math.max(ans, suff[i][m - 1]);
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = m - 2 ; j >= 0 ; j--){
                suff[i][j] = A[i][j] + suff[i + 1][j] + suff[i][j + 1] - suff[i + 1][j + 1];
                ans = Math.max(ans, suff[i][j]);
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubMatrixSum mss = new MaximumSubMatrixSum();
		int[][] A = {{-5, -4, -3}, {-1, 2, 3}, {2, 2, 4}};
		System.out.println(mss.solveAgain(A));
	}

}