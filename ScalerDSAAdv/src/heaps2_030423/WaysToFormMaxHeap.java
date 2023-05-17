package heaps2_030423;

import java.util.Arrays;
import java.util.Objects;
// https://www.scaler.com/academy/mentee-dashboard/class/70939/homework/problems/437?navref=cl_tt_lst_nm
public class WaysToFormMaxHeap { // check and understand

	final int MOD = 1000000007;
	final int MAX = 1005;
	long[] dp = new long[MAX];
	long[] dp2 = new long[MAX];
	int[] log = new int[MAX];
	long[][] nCk = new long[MAX][MAX];

	public int solve(int[] A) {
		Arrays.fill(dp2, -1);
		Arrays.fill(dp, -1);
		Arrays.fill(log, -1);
		for (long[] row : nCk)
			Arrays.fill(row, -1);

		int n = A.length;
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;

		Arrays.sort(A);
		boolean minRepeating = Objects.equals(A[0], A[1]);

		if (minRepeating) {
			return (int) ((numberOfWays2(n) + MOD) % MOD);
		}

		return (int) ((numberOfWays(n) + MOD) % MOD);
	}

	public long numberOfWays2(int n) {
		if (n == 0)
			return 0;
		if (n <= 3)
			return 1;
		if (dp2[n] != -1)
			return dp2[n];
		int height = log2(n);
		int nodes = (1 << height) - 1;

		int left = ((nodes - 1) / 2) + Math.min(n - nodes, (nodes + 1) / 2);
		int right = n - left - 1;
		// If repeated min are in left subtree
		long ans = (compute(n - 3, left - 2) % MOD * numberOfWays2(left) % MOD * numberOfWays(right) % MOD) % MOD;
		// If repeated min are in right subtree
		ans = (ans % MOD)
				+ (compute(n - 3, right - 2) % MOD * numberOfWays(left) % MOD * numberOfWays2(right) % MOD) % MOD;
		// If 1 is in left & other is in right subtree
		ans = (ans % MOD)
				+ (compute(n - 3, left - 1) % MOD * numberOfWays(left) % MOD * numberOfWays(right) % MOD) % MOD;

		dp2[n] = ans;

		return dp2[n];

	}

	public long numberOfWays(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		if (dp[n] != -1)
			return dp[n];

		int height = log2(n);
		int nodes = (1 << height) - 1;

		int left = ((nodes - 1) / 2) + Math.min(n - nodes, (nodes + 1) / 2);
		int right = n - left - 1;
		dp[n] = (compute(n - 1, left) % MOD * numberOfWays(left) % MOD * numberOfWays(right) % MOD) % MOD;
		return dp[n];
	}

	long compute(int n, int k) {
		if (k < 0 || k > n) {
			return 0;
		}
		if (n <= 1 || k == 0) {
			return 1;
		}
		if (nCk[n][k] != -1) {
			return nCk[n][k];
		}

		long answer = (compute(n - 1, k - 1) + compute(n - 1, k)) % MOD;
		nCk[n][k] = answer;
		return answer;
	}

	int log2(int n) {
		if (log[n] != -1) {
			return log[n];
		}
		return (int) (Math.log(n) / Math.log(2) + 1e-10);
	}

	static int maxnScalerSol = 1005;
    static long[] dpScalerSol = new long[maxnScalerSol];
    static long[] dp1ScalerSol = new long[maxnScalerSol];
    static long[][] nckScalerSol = new long[maxnScalerSol][maxnScalerSol];
    static int[] log_2ScalerSol = new int[maxnScalerSol];
    static long MODScalerSol = 1000000007;
    public int solveScalerSol(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n; i++)
            dpScalerSol[i] = (long) - 1;

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                nckScalerSol[i][j] = (long) - 1;

        int currlog_2Answer = -1;
        int currPower2 = 1;
        for (int i = 1; i <= n; i++) {
            if (currPower2 == i) {
                currlog_2Answer++;
                currPower2 *= 2;
            }
            log_2ScalerSol[i] = currlog_2Answer;
        }
        int max = -1;
        int min = 10000000;
        int maxcount = 0;
        int mincount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                mincount = 1;
            } else if (arr[i] == min) {
                mincount++;
            }
            if (arr[i] > max) {
                max = arr[i];
                maxcount = 1;
            } else if (arr[i] == max) {
                maxcount++;
            }
        }
        if (maxcount == 2)
            return (int) getNumberOfMaxHeapsScalerSol(n);
        else
            return (int) getNumberOfMaxHeaps2ScalerSol(n);
    }
    public static long chooseScalerSol(int n, int k) {
        if (k > n)
            return 0;
        if (n <= 1)
            return 1;
        if (k == 0)
            return 1;

        if (nckScalerSol[n][k] != -1)
            return nckScalerSol[n][k];
        long answer = chooseScalerSol(n - 1, k - 1) + chooseScalerSol(n - 1, k);
        answer %= MODScalerSol;
        nckScalerSol[n][k] = answer;
        return answer;
    }
    public static int getLScalerSol(int n) {
        if (n == 1)
            return 0;

        int h = log_2ScalerSol[n];
        int p = n - ((1 << (h)) - 1);
        int m = (1 << h);
        if (p >= (m / 2))
            return (1 << (h)) - 1;
        else
            return (1 << (h)) - 1 - ((m / 2) - p);
    }
    public static long getNumberOfMaxHeapsScalerSol(int n) {
        if (n <= 1)
            return 1;

        if (dpScalerSol[n] != -1)
            return dpScalerSol[n];

        int L = getLScalerSol(n);
        long ans = (chooseScalerSol(n - 1, L) * getNumberOfMaxHeapsScalerSol(L)) % MODScalerSol * (getNumberOfMaxHeapsScalerSol(n - 1 - L));
        ans %= MODScalerSol;
        dpScalerSol[n] = ans;
        return ans;
    }
    public static long getNumberOfMaxHeaps2ScalerSol(int n) {
        if (n < 2)
            return (long) 0;
        if (n < 4)
            return (long) 1;
        if (n == 4)
            return (long) 2;
        if (n == 5)
            return (long) 4;
        if (dp1ScalerSol[n] != 0)
            return dp1ScalerSol[n];
        int l = getLScalerSol(n);
        int r = n - l - 1;
        long ans = (((chooseScalerSol(n - 3, l - 2) * getNumberOfMaxHeaps2ScalerSol(l)) % MODScalerSol) * getNumberOfMaxHeapsScalerSol(r)) % MODScalerSol;
        ans = (ans + (((chooseScalerSol(n - 3, r - 2) * getNumberOfMaxHeapsScalerSol(l)) % MODScalerSol) * getNumberOfMaxHeaps2ScalerSol(r)) % MODScalerSol) % MODScalerSol;
        ans = (ans + (((chooseScalerSol(n - 3, l - 1) * getNumberOfMaxHeapsScalerSol(l)) % MODScalerSol) * getNumberOfMaxHeapsScalerSol(r)) % MODScalerSol) % MODScalerSol;
        dp1ScalerSol[n] = ans;
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaysToFormMaxHeap wa = new WaysToFormMaxHeap();
		int[] A = {1,2,2};
		System.out.println(wa.solve(A)); // 2
		int[] B = {1,1,2};
		System.out.println(wa.solve(B)); // 1
	}

}
