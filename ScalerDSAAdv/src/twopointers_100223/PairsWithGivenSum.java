package twopointers_100223;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50142/assignment/problems/5097/?navref=cl_pb_nv_tb
public class PairsWithGivenSum {

	// code working but need to check properly again to optimize
	public int checkPairExistsTwoPointers(int[] A, int B) { 
		int n = A.length;
		int l=0, r = n-1;
		long count = 0, mod = 1000000007;
		while(l<r) {
			long sum = A[l] + A[r];
			if(sum<B) l++;
			else if(sum >B) r--;
			else if(sum == B) {
				int x = A[l], y = A[r];
				if(x == y) {
					long temp = r-l+1;
					temp = temp * (temp-1);
					temp >>=1;
					count += temp;
					break;
				}
				long xval=0;
				while(l<n && x==A[l]) {
					l++;
					xval++;
				}
				long yval=0;
				while(r>=0 && y==A[r]) {
					r--;
					yval++;
				}
				count += xval *yval;
			}
		}
		return (int) (count%mod);
	}

	public int solveScalerSol(int[] A, int B) {
        int i = 0, j = A.length - 1, mod = 1000 * 1000 * 1000 + 7;
        long ans = 0;
        while (i < j) {
            if (A[i] + A[j] == B) {
                int ii = i, jj = j;
                if (A[i] == A[j]) {
                    // equal A[i] and A[j]
                    long cnt = j - i + 1;
                    ans += (cnt * (cnt - 1) / 2) % mod;
                    ans %= mod;
                    break;
                } else {
                    // count number of elements with value A[i]
                    while (A[i] == A[ii]) {
                        ii++;
                    }
                    int cnt1 = ii - i;
                    i = ii;
                    // count number of elements with value A[j]
                    while (A[jj] == A[j]) {
                        jj--;
                    }
                    int cnt2 = j - jj;
                    j = jj;
                    ans += (cnt1 * cnt2) % mod;
                    ans %= mod;
                }
            } else if (A[i] + A[j] > B) {
                j--;
            } else i++;
        }
        return (int) ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairsWithGivenSum pwgd = new PairsWithGivenSum();
		int[] A = {1, 1, 1};
		System.out.println(pwgd.checkPairExistsTwoPointers(A, 2)); // 2
		//System.out.println(pwgd.checkPairExistsTwoPointers1(A, 5));
		int[] B = {1, 1};
		System.out.println(pwgd.checkPairExistsTwoPointers(B, 2)); // 1
		//System.out.println(pwgd.checkPairExistsTwoPointers1(B, 3));
		int[] C = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
		System.out.println(pwgd.checkPairExistsTwoPointers(C, 5)); // 3
		//System.out.println(pwgd.checkPairExistsTwoPointers1(C, 5));
		int[] D = {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
		System.out.println(pwgd.checkPairExistsTwoPointers(D, 3)); // 7
		//System.out.println(pwgd.checkPairExistsTwoPointers1(D, 3));
		int[] E = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(pwgd.checkPairExistsTwoPointers(E, 0)); // 1
		int[] F = {1, 1, 1, 1, 1, 1, 1, 2, 2, 2};
		System.out.println(pwgd.checkPairExistsTwoPointers(F, 0)); // 1
		
	}

}
