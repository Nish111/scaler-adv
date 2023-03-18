package searching1_030223;

import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/50139/homework/problems/1104?navref=cl_tt_nv
public class MinimumDifference {

	public int solveBrute(int A, int B, int[][] C) { // working but TLE as O(n^2)
		int count=Integer.MAX_VALUE;
		for(int i=0; i<C.length-1; i++) {
			for(int j=0; j<C[0].length; j++) {
				int temp = C[i][j];
				for(int k=0; k<C[0].length; k++) {
					count = Math.min(count, Math.abs(temp-C[i+1][k]));
				}
			}
		}
		return count;
    }
	public int solveVideo(int A, int B, int[][] C) { // not working
		int min = Integer.MAX_VALUE;
		for(int i=0; i<C.length; i++) {
			Arrays.sort(C[i]);
		}
		for(int i=0; i<C.length-1; i++) {
			for(int j=0; j<C[0].length; j++) {
				int a = upperBound(C[i][j], C[i+1]);
				int b = lowerBound(C[i][j], C[i+1]);
				min = Math.min(min, Math.min(Math.abs(a-C[i][j]), Math.abs(b-C[i][j])));
			}
		}
		
		return min;
    }
	public int upperBound(int i, int[] A) {
		int temp = Integer.MAX_VALUE;
		int l = 0, r = A.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(i<=A[mid]) {
				temp = Math.min(temp, A[mid]);
			}
			if (A[mid] > i) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
			/*
			 * int mid = (l+r)/2; if(A[mid]==i) { temp = mid; // found it r = mid-1; }
			 * if(A[mid]<i) l = mid+1; if(A[mid]>i) { r = mid-1; temp = A[mid]; }
			 */
		}
		return temp;
	}
	public int lowerBound(int i, int[] A) {
		int temp = Integer.MIN_VALUE;
		int l = 0, r = A.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if (i > A[mid]) {
				temp = Math.max(temp, A[mid]);
			}
			if (A[mid] > i) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
			/*
			 * if(A[mid]==i) { temp = mid; // found it r = mid-1; } if(A[mid]<i) { l =
			 * mid+1; temp = A[mid]; } if(A[mid]>i) { r = mid-1; }
			 */
		}
		return temp;
	}

	public int solve(int A, int B, int[][] C) { // working O(ABlogB) O(1)
		// Sorting individual row arr to perform BinarySearch
		for (int i = 0; i < A; i++) {
			Arrays.sort(C[i]);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < A - 1; i++) {
			for (int j = 0; j < B; j++) {
				int l = 0, r = B - 1;
				int checkValue = C[i][j];
				ans = Math.min(ans, getNearestMinDifferenceValue(l, r, C[i + 1], checkValue));
			}
		}
		return ans;
	}

	// Finding upperbound and lowerbound value to get the min possible difference.
	public int getNearestMinDifferenceValue(int l, int r, int[] A, int checkValue) {
		int lesserValue = Integer.MIN_VALUE, greaterValue = Integer.MAX_VALUE;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (checkValue <= A[mid]) {
				greaterValue = Math.min(greaterValue, A[mid]);
			} else if (checkValue > A[mid]) {
				lesserValue = Math.max(lesserValue, A[mid]);
			}
			if (A[mid] > checkValue) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		// Check for if any of the bound values missed
		if (lesserValue == Integer.MIN_VALUE) {
			return greaterValue - checkValue;
		} else if (greaterValue == Integer.MAX_VALUE) {
			return checkValue - lesserValue;
		}
		return Math.min(checkValue - lesserValue, greaterValue - checkValue);
	}
	public int solveScalerSol(int A, int B, int[][] C) {
	      int x;
	      int ans = 1000000000; // Initialize answer as a large number
	      int lb;
	      for (int i = 0; i < A; i++) {
	         Arrays.sort(C[i]); // Sort each row of matrix
	      }
	      for (int i = 0; i < A - 1; i++) {
	         for (int j = 0; j < B; j++) {
	            lb = lower_boundScalerSol(C[i + 1], C[i][j]); // check for next element as in soltion
	            if (lb != B) {
	               ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb])); // Update answer
	            }
	            if (lb != 0) {
	               ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb - 1]));
	            }
	         }
	      }
	      return ans;
	   }

	   // function used to find element index just greater than or equal to val
	   public int lower_boundScalerSol(int a[], int val) {
	      int low = 0, high = a.length - 1, ans = a.length;
	      while (low <= high) {
	         int mid = (high - low) / 2 + low;
	         if (a[mid] < val) {
	            low = mid + 1;
	         } else {
	            ans = mid;
	            high = mid - 1;
	         }
	      }
	      return ans;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumDifference md = new MinimumDifference();
		int[][] A = {{8,4}, {6,8}};
		System.out.println(md.solveVideo(2, 2, A)); // 0
		System.out.println(md.solveBrute(2, 2, A)); // 0
		System.out.println(md.solve(2, 2, A)); // 0
		int[][] B = {{7,3}, {2,1}, {4,9}};
		System.out.println(md.solveVideo(3, 2, B)); // 1
		System.out.println(md.solveBrute(3, 2, B)); // 1
		System.out.println(md.solve(3, 2, B)); // 1
		int[][] C = {{9,4,3,6}, {7,5,2,1}, {1,9,3,4}, {6,4,5,8}};
		System.out.println(md.solveVideo(3, 2, C)); // 0
		System.out.println(md.solveBrute(3, 2, C)); // 0
		System.out.println(md.solve(3, 2, C)); // 0
		int[][] D = {{7,3}, {2,1}, {4,9}};
		System.out.println(md.solveVideo(3, 2, D)); // 1
		System.out.println(md.solveBrute(3, 2, D)); // 1
		System.out.println(md.solve(3, 2, D)); // 1
	}

}
