package searching3_080223;

import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/50141/assignment/problems/4129?navref=cl_tt_lst_sl
public class CowsStalls {

	public int maxMinimumDistance(int[] A, int m, int n) { // m stalls, n cows
		Arrays.sort(A); // for assignments needed this
		int low = Integer.MAX_VALUE, ans=0;
		for(int i=0; i<m-1; i++) {
			low = Math.min(low, A[i+1]-A[i]);
		}
		int high = A[m-1] - A[0];
		//System.out.println(low+" "+high);
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(check(A,m,n,mid)) {
				ans = mid;
				low =mid+1;
			} else {
				high = mid-1;
			}
		}
		return ans;
	}
	public boolean check(int[] A, int m, int n, int min_time) {
		int count = 1;
		int pos_last_cow = A[0];
		for(int i=1; i<m; i++) {
			if((A[i]-pos_last_cow)>=min_time) {
				count++;
				pos_last_cow = A[i];
				if(count==n) return true;
			}
		}
		return false; // if count never reaches n after traversing for loop, then false
	}
	public boolean checkScalerSol(int x, int[] A, int c) {
	      int j = 0, n = A.length;
	      int cnt = 1;
	      for (int i = 1; i < n; i++) {
	         if (A[i] - A[j] >= x) {
	            j = i;
	            cnt++;
	         }
	      }
	      return (cnt >= c);
	   }

	   public int solveScalerSol(int[] A, int B) {
	      int n = A.length;
	      Arrays.sort(A);
	      int l = 1, r = 1000 * 1000 * 1000;
	      int ans = 1;
	      while (l <= r) {
	         int mid = (l + r) / 2;
	         if (checkScalerSol(mid, A, B)) {
	            ans = mid;
	            l = mid + 1;
	         } else {
	            r = mid - 1;
	         }
	      }
	      return ans;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CowsStalls cw = new CowsStalls();
		int[] A = {2,6,11,14,19,25,30,39,43};
		System.out.println(cw.maxMinimumDistance(A, 9, 4)); // 12
		int[] B = {1,2,4,8,9};
		System.out.println(cw.maxMinimumDistance(B, 5, 3)); // 3
		int[] C = { 5, 17, 100, 11}; // assignment problem not sorted
		// converting to our problem array should be
		int[] D = {5, 22, 122, 133};
		// or sorting C
		int[] E = {5,11,17,100};
		System.out.println(cw.maxMinimumDistance(C, 4, 2)); // 6 - need 95
		System.out.println(cw.maxMinimumDistance(D, 4, 2)); // 128 - need 95
		System.out.println(cw.maxMinimumDistance(E, 4, 2)); // 95 - expected
	}

}
