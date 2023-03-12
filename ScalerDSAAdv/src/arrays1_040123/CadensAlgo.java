package arrays1_040123;

import java.util.List;

// https://www.scaler.com/academy/mentee-dashboard/class/50126/assignment/problems/56/hints?navref=cl_pb_nv_tb
public class CadensAlgo {

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
	public int maxSubArrayScalerSol(final List<Integer> A) {
        int curSum = 0; //is the maximum sum ending at any given index i
        int maxSum = Integer.MIN_VALUE; // maximum subarray sum for all subarrays till now
	    for (int num : A) {
	        curSum += num;
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) curSum = 0;
	    }
	    return maxSum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CadensAlgo ca = new CadensAlgo();
		int[] A = {5,6,7,-3,2,-10,-12,8,21,-6};
		System.out.println(ca.cadens(A)); // 29
		int[] B = {1, 2, 3, 4, -10};
		System.out.println(ca.cadens(B));// 10
		int[] C = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(ca.cadens(C));// 6
		int[] D = {-500};
		System.out.println(ca.cadens(D));// -500
	}

}
