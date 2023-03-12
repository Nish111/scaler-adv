package hashing_130223;

import java.util.HashSet;
// https://www.scaler.com/academy/mentee-dashboard/class/50143/homework/problems/1226/?navref=cl_pb_nv_tb
public class CountSubarrays {

	public int countSubarraysBrute(int[] A) { // brute // not done
		// find number of subarrays that have unique elements
		// contiguous part of array is subarray
		for(int i=0; i<A.length; i++) {
			
			for(int j=i; j<A.length; j++) {
				
				for(int k=i;k<=j; k++) {
					// check from i to j and if unique then increase count
				}
			}
		}
		return 1;
	}
	public int countSubarrays(int[] A) { // optimal // O(2N)
		// find number of subarrays that have unique elements
		// contiguous part of array is subarray
		int l=0, r=0, mod=1000000007;
		long ans=0;
		HashSet<Integer> hs = new HashSet<>();
		while(r<A.length) {
			if(hs.contains(A[r])) {
				hs.remove(A[l]);
				l++;
			} else {
				hs.add(A[r]);
				ans += r-l+1;
				r++;
			}
		}
		return (int) (ans%mod);
	}
	public int solveScalerSol(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        long ans = 0;
        int N = A.length, l = 0;
        for(int r = 0; r < N; r++) {
            // check if A[r] is already there in the present window
            while(hs.contains(A[r])) {
                hs.remove(A[l]);
                l++;
            }
            // add the subarrays ending at position r
            ans += r - l + 1;
            hs.add(A[r]);
        }
        return (int)(ans % (long)(1e9 + 7));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountSubarrays cs = new CountSubarrays();
		int[] A = {2,3,2,5,2,3};
		System.out.println(cs.countSubarrays(A)); // 13
		int[] B = {1,1,3};
		System.out.println(cs.countSubarrays(B)); // 4 - 1, 1, 3, (1,3)
		int[] C = {3,2,3,5,3};
		System.out.println(cs.countSubarrays(C)); // 10 
	}

}
