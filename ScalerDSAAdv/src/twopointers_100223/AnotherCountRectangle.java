package twopointers_100223;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50142/homework/problems/4115?navref=cl_tt_nv
public class AnotherCountRectangle {

	public int solve(int[] A, int B) { // O(N2) TLE
		long product=0, count=0, mod=1000000007;
		int n = A.length;
		int l=0, r=n-1;
		while(l<r) {
			product = 1L * A[l]*A[r];
			if(product<B) {
				int temp = r-l;
				count += temp*2;
				l++;
			} else r--;
		}
		while(r>=0) {
			product = 1L * A[l]*A[r];
			if(product<B) {
				count += r+1;
				break;
			} 
			r--;
		}
		return (int) (count%mod);
    }
	public int solveBrute(int[] A, int B) { // O(N2) TLE
		long product=0, count=0, mod=1000000007;
		for(int i=0; i<A.length; i++) {
			product = 0;
			for(int j=0; j<A.length; j++) {
				product = A[i]*A[j];
				if(product < B) count++;
			}
		}
		return (int) (count%mod);
    }
	public int solveScalerSol(ArrayList < Integer > A, int B) {
        long ans = 0, mod = (long)(1000000000 + 7);
        int l = 0, r = A.size() - 1;
        while (l < A.size() && r >= 0) {
            if ((long) A.get(l) * A.get(r) < B) {
                // A[l] can form rectangles with any of A[0..r]
                ans = (ans + r + 1) % mod;
                l++;
            } else r--;
        }
        return (int) ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnotherCountRectangle acr = new AnotherCountRectangle();
		int[] A = {1, 2};
		System.out.println(acr.solveBrute(A, 5)); // 4
		System.out.println(acr.solve(A, 5)); // 4
		int[] B = {1, 2};
		System.out.println(acr.solveBrute(B, 1)); // 0
		System.out.println(acr.solve(B, 1)); // 0
		int[] C = {1, 2, 4, 5, 7, 8, 11};
		System.out.println(acr.solveBrute(C, 100)); // 48
		System.out.println(acr.solve(C, 100)); // 48
		
	}

}
