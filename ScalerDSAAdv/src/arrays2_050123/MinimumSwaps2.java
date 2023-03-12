package arrays2_050123;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumSwaps2 {
/*
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)]. It is allowed to swap any two elements (not necessarily consecutive).

Find the minimum number of swaps required to sort the array in ascending order.
 */
	public int solve(int[] A) {
		int count=0;
	    int N=A.length;
	    int s=0;
	    while(s<N){
	        if(A[s]!=s){
	            count++;
	            int temp=A[A[s]];
	            A[A[s]]=A[s];
	            A[s]=temp;
	        }
	        else s++;
	    }
	    return count;
	}
	 public int solveScalerSol(ArrayList<Integer> A) {
	        int ans = 0;
	        for(int i = 0 ; i < A.size() ; i++ ){
	            while(A.get(i) != i){
	                ans++;
	                // swap A[i] with A[A[i]]
	                Collections.swap(A, i, A.get(i));
	            }
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSwaps2 ms = new MinimumSwaps2();
		int[] A = {1, 2, 3, 4, 0};
		int[] B = {2, 0, 1, 3};
		int[] C = {3, 4, 0, 2, 1, 5}; 
		System.out.println(ms.solve(A)); // 4
		System.out.println(ms.solve(B)); // 2
		System.out.println(ms.solve(C)); // 3
		System.out.println(ms.solve(A));
	}

}
