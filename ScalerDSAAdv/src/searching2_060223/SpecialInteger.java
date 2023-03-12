package searching2_060223;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/50140/homework/problems/4133/?navref=cl_pb_nv_tb
public class SpecialInteger {

	public int solveBrute(int[] A, int B) { // O(n) incorrect
		// incorrect as we need contiguous array and so sort not correct
		Arrays.sort(A);
		int ans = 0, sum=0;
		for(int i=A.length-1; i>=0; i--) {
				sum+=A[i];
				if(sum<=B) ans++;
		}
		
		return ans;
    }
	
	public int solve(int[] A, int B) { // something wrong
		int ans=0, sum=0, count=0;
		int n = A.length;
		int[] C = new int[n*(n+1)/2];
		// to generate subarrays - but i ma not clear for next step
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				C = Arrays.copyOfRange(A, i, j + 1);
				System.out.println(Arrays.toString(C));
			}
		}
		Arrays.sort(C);
		for(int i=0; i<C.length; i++) {
			System.out.println(C[i] + " " +1);
		}
		return ans;
    }
	public void prefix_function(int[] A, long[] prefix){
        // calculating the prefix sum
        for (int i = 0; i < A.length; ++i) {
            prefix[i] = A[i];
            if(i > 0)
                prefix[i] += prefix[i - 1];
        }
    }
    
    public int solveScalerSol(int[] A, int B) {
        long[] prefix = new long[A.length];
        prefix_function(A, prefix);
        // Binary search for the length  
        int lo = 1;
        int hi = A.length, ans = 0;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo; // to keep our mid towards the right
            if (checkScalerSol(mid, prefix, (long) B) == 1) {
                hi = mid - 1;
            } else {
                ans = mid;
                lo = mid + 1;
            }
        }
        return ans;
    }

   // Checks if there is a subarray of size s whose sum is greater than sm in linear time
   int checkScalerSol(int s, long[] arr, long sm) {
        int flag = 0;
        for (int i = s - 1; i < arr.length; ++i) {
            if (i == s - 1) {
                if (arr[i] > sm)
                    return 1;
            } else if (arr[i] - arr[i - s] > sm) {
                return 1;
            }
        }
        return 0;
    }
	 public int solve1(int[] A, int B) {
	        int left =0,right=A.length;
	        int ans=0;
	        while(left<=right){
	            int mid=(left+right)/2;
	            long sum = maxSumSubArray(A,mid);
	            if(sum <= B){
	                ans= Math.max(ans,mid);
	               // System.out.println(ans);
	                left= mid+1;
	            }else{
	                right=mid-1;
	            }
	        }
	        return ans;
	    }
	    public long maxSumSubArray(int[] a,int mid){
	        long sum=0;
	        for(int i=0;i<mid;i++){
	            sum+=a[i];
	        }
	        long ans=sum;
	        int start=0,end=mid;
	        while(end<a.length){
	            sum = sum-a[start++]+a[end++];
	            ans = Math.max(ans,sum);
	        }
	        return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecialInteger si = new SpecialInteger();
		int[] A = {1, 2, 3, 4, 5};
		System.out.println(si.solveBrute(A, 10)); // 2
		System.out.println(si.solve1(A, 10)); // 2
		int[] B = {5, 17, 100, 11};
		System.out.println(si.solveBrute(B, 130));// 3
		System.out.println(si.solve1(B, 130)); // 3
		int[] C = {2, 24, 38, 25, 35, 33, 43, 12, 49, 35, 45, 47, 5, 33};
		System.out.println(si.solveBrute(C, 249)); // 5
		System.out.println(si.solve1(C, 249)); // 5
		int[] D = {2,1,6,1,3,4};
		System.out.println(si.solveBrute(D, 8));// 1
		System.out.println(si.solve1(D, 8)); //1
	}

}
