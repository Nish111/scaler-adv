package sorting1_270123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumAbsoluteDifference {

	public int solveBrute(int[] A) { // O(nlogn)
		Arrays.sort(A);
		int min = Integer.MAX_VALUE;
		for(int i=0; i<A.length-1; i++) {
			min = Math.min(min, A[i+1]-A[i]);
		}
		return min;
    }
	 public int solveScalerSol(ArrayList < Integer > A) {
	        int n = A.size();
	        // sort the array 
	        Collections.sort(A);
	        // initialize the ans variable
	        int ans = Integer.MAX_VALUE;
	        for (int i = 1; i < n; i++) {
	            // store the minimum value
	            ans = Math.min(ans, A.get(i) - A.get(i - 1));
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumAbsoluteDifference mad = new MinimumAbsoluteDifference();
		int[] A = {1, 2, 3, 4, 5};
		System.out.println(mad.solveBrute(A)); // 1
		int[] B = {5, 17, 100, 11};
		System.out.println(mad.solveBrute(B)); // 6
		int[] C = {1, 2, 3, 4, 5};
		System.out.println(mad.solveBrute(C));
		int[] D = {1, 2, 3, 4, 5};
		System.out.println(mad.solveBrute(D));
	}

}
