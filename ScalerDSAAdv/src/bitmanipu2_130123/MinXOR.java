package bitmanipu2_130123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// https://www.scaler.com/academy/mentee-dashboard/class/50130/homework/problems/383/submissions
public class MinXOR {

	public int findMinXorBrute(int[] A) { // O(N2) O(1)
		int xor=0, min_val=Integer.MAX_VALUE;
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length;j++) {
				xor = A[i]^A[j];
				min_val = Math.min(min_val, xor);
			}
		}
		return min_val;
    }
	public int findMinXor(int[] A) {
		Arrays.sort(A);
		// sorting as need to find closer values those will have least xor
		int xor=0, min_val=Integer.MAX_VALUE;
		for(int i=0; i<A.length-1; i++) {
			xor = A[i]^A[i+1];
			min_val = Math.min(min_val, xor);
		}
		return min_val;
    }
	public int findMinXorScalerSol(ArrayList < Integer > A) {
        // sort the array A in ascending order
        Collections.sort(A);
        // the answer will be the min of XOR of each adjacent elements
        int ans = A.get(0) ^ A.get(1);
        for (int i = 1; i < A.size(); i++) {
            ans = Math.min(A.get(i) ^ A.get(i - 1), ans);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinXOR mx = new MinXOR();
		int[] A = {0, 2, 5, 7};
		int[] B = {0, 4, 7, 9};
		int[] C = {4,6,8,10};
		int[] D = {169, 185, 187};
		System.out.println(mx.findMinXorBrute(A)); // 2
		System.out.println(mx.findMinXorBrute(B)); // 3
		System.out.println(mx.findMinXor(A)); // 2
		System.out.println(mx.findMinXor(B)); // 3
		System.out.println(mx.findMinXor(C)); // 2
		System.out.println(mx.findMinXor(D)); // 2
	}

}
