package dp1_190423;

import java.util.List;
// https://www.scaler.com/academy/mentee-dashboard/class/70943/homework/problems/9/?navref=cl_pb_nv_tb
public class MaxProductSubArray {
	public int maxProduct(final int[] A) {
		int ans = Integer.MIN_VALUE;
		int prevMin = 1, prevMax=1;
		for(int i=0; i<A.length; i++) {
			int max = Math.max(A[i], Math.max(A[i]*prevMax, A[i]*prevMin));
			int min = Math.min(A[i], Math.min(A[i]*prevMax, A[i]*prevMin));
			prevMax = max;
			prevMin = min;
			ans = Math.max(ans, prevMax);
		}
		return ans;
    }
	public int maxProduct(final List < Integer > A) {
        int ans = Integer.MIN_VALUE, prevMax = 1, prevMin = 1;
        for (int i = 0; i < A.size(); i++) {
            int temp1 = Math.max(A.get(i), Math.max(A.get(i) * prevMax, A.get(i) * prevMin));
            int temp2 = Math.min(A.get(i), Math.min(A.get(i) * prevMax, A.get(i) * prevMin));
            prevMax = temp1;
            prevMin = temp2;
            ans = Math.max(ans, prevMax);
        }
        return ans;
    }
	 public int maxProductScalerSol(final int[] A) {
		    return maxProductCScalerSol(A, A.length);
		  }
		  static int maxProductCScalerSol(int arr[], int n) {

		    // Variables to store maximum and minimum 
		    // product till ith index. 
		    int minVal = arr[0];
		    int maxVal = arr[0];

		    int maxProduct = arr[0];

		    for (int i = 1; i < n; i++) {

		      // When multiplied by -ve number, 
		      // maxVal becomes minVal 
		      // and minVal becomes maxVal. 
		      if (arr[i] < 0) {
		        int temp = maxVal;
		        maxVal = minVal;
		        minVal = temp;

		      }

		      // maxVal and minVal stores the 
		      // product of subarray ending at arr[i]. 
		      maxVal = Math.max(arr[i], maxVal * arr[i]);
		      minVal = Math.min(arr[i], minVal * arr[i]);

		      // Max Product of array. 
		      maxProduct = Math.max(maxProduct, maxVal);
		    }

		    // Return maximum product found in array. 
		    return maxProduct;
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxProductSubArray mps = new MaxProductSubArray();
		int[] A = {4, 2, -5, 1};
		System.out.println(mps.maxProduct(A));// 8
		int[] B = {-3, 0, -5, 0};
		System.out.println(mps.maxProduct(B));// 0
	}

}
