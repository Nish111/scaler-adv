package dp6_famousprob_030523;

import java.util.Arrays;
import java.util.List;

// https://www.scaler.com/academy/mentee-dashboard/class/70948/assignment/problems/4?navref=cl_tt_lst_nm
public class LIS {

	public int longestSequence(int[] A) {
		int N = A.length;
		int dp[] = new int[N];
		for(int i=0; i<N; i++)
			dp[i]=1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(A[i]>A[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int ans=0;
		for(int i=0; i<N; i++)
			ans = Math.max(ans, dp[i]);
		return ans;
	}
	public int lisScalerSol(final List < Integer > A) {
        if (A == null)
            return 0;
        int n = A.size();
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j) && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, dp[i]);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LIS l = new LIS();
		int[] A = {1,5,9,3,2};
		System.out.println(l.longestSequence(A)); // 3
	}

}
