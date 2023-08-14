package contest_050823;

import java.util.Arrays;
// https://www.scaler.com/test/97de52ecc3/#/problem_3
public class MaximumSumMatrix {
     public int solve(int[] A, int[] B) {
        int n = A.length;
		int m = B.length;
		long ans = 0;
		Arrays.sort(A);
		long[] pre = new long[n];
		long mod = 1000000007;
		Arrays.fill(pre, 0);
		for(int i=0; i<n; i++){
			if(i != 0) pre[i] += pre[i-1];
			pre[i] += (long) A[i];
			pre[i] %= mod;
		}
		for(int i=0; i<m; i++){
			int index = upperBound(A, 0, A.length, B[i]);
			if(index == A.length) ans += pre[n-1];
			else {
				int idx = index;
				if(idx != 0) ans += pre[idx-1];
				ans += (long)(B[i] * (n-idx));
			}
			ans %= mod;
		}
		return (int)ans;
    }	
	static int upperBound(int[] a, int low, int high, int element) {
		while(low < high){
			int middle = low +(high-low)/2;
			if(a[middle] > element) high = middle;
			else low = middle+1;
		}
		return low;
	}
}
