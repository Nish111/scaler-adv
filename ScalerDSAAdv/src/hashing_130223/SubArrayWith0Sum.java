package hashing_130223;

import java.util.ArrayList;
import java.util.HashSet;

// https://www.scaler.com/academy/mentee-dashboard/class/50143/assignment/problems/4202?navref=cl_tt_lst_nm
public class SubArrayWith0Sum {
	public int solve(int[] A) { // O(N2) O(1) so TLE
	      // Just write your code below to complete the function. Required input is available to you as the function arguments.
	      // Do not print the result or any output. Just return the result via this function.
		int sum=0;
		for(int i=0; i<A.length; i++) {
			sum = 0;
			for(int j=i; j<A.length; j++) {
				sum += A[j];
				if(sum==0) return 1;
			}
		}
		return 0;
	}
	public int solveOptimized(int[] A) { // O(N2) so TLE
		HashSet<Long> hs = new HashSet<>();
		hs.add(0L);
		long temp = 0;
		for(int i=0; i<A.length; i++) {
			temp += A[i];
			if(hs.contains(temp)) return 1;
			else hs.add(temp);
			
		}
		return 0;
	}
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public int solveScalerSol(ArrayList < Integer > A) {
        HashSet < Long > set = new HashSet < Long > ();
        long sum = 0;
        set.add(sum);
        for (int x: A) {
            sum += x;
            if (set.contains(sum)) return 1;
            else {
                set.add(sum);
            }
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubArrayWith0Sum sas = new SubArrayWith0Sum();
		int[] A = {1,2,3,4,5};
		System.out.println(sas.solve(A)); // 0
		System.out.println(sas.solveOptimized(A)); // 0
		int[] B = {-1,1};
		System.out.println(sas.solve(B)); // 1
		System.out.println(sas.solveOptimized(B)); // 1
		int[] C = {1, -3, 2, 4};
		System.out.println(sas.solve(C)); // 1
		System.out.println(sas.solveOptimized(C)); // 1
		int[] D = {1,0, -4, -3};
		System.out.println(sas.solve(D)); // 1
		System.out.println(sas.solveOptimized(D)); // 1
	}

}
