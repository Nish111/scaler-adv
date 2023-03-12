package sorting2_300123;

import java.util.Arrays;

public class QuickSortPrev {

	// A[0] only needs to be in correct position
	public int[] sortBrute(int[] A) { // O(nlogn) O(1) // approach 1
		// simple sort
		Arrays.sort(A);
		return A;
	}
	public int[] sort2(int[] A) { // O(n) O(n) // approach 2
		int[] B = new int[A.length];
		int l=0, r = A.length-1;
		int temp=1;
		while(l<r) {
			if(A[temp]<A[0]) {
				B[l]=A[temp];
				l++; temp++;
			} else if(A[temp]>A[0]) {
				B[r] = A[temp];
				r--;temp++;
			} 
		}
		B[l] = A[0];
		return B;
	}
	public int[] sort3(int[] A) { // approach 3 swapping // my code
		int l=1, r = A.length-1;
		while(l<r) {
			if(A[l]<A[0]) {
				l++;
			} else if(A[l]>A[0]){
				if(A[r]>A[0]) {
					r--;
				} else {
					int temp = A[l];
					A[l] = A[r];
					A[r] = temp;
					l++; r--;
				}
			}
		}
		int temp = A[0];
		A[0] = A[r];
		A[r] = temp;
		return A;
	}
	public int[] sort3His(int[] A) { // approach 3 swapping // his code
		int l=1, r = A.length-1;
		while(l<r) {
			if(A[l]<A[0]) l++;
			else if(A[r]>A[0]) r--;
			else {
				int temp = A[l];
				A[l] = A[r];
				A[r] = temp;
				l++; r--;
			}
		}
		int temp = A[0];
		A[0] = A[r];
		A[r] = temp;
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortPrev is = new QuickSortPrev();
		int[] A = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14};
		int[] B = is.sortBrute(A); // 2 3 6 7 8 10 12 14 15 15 18 
		for(int i=0; i<B.length; i++) System.out.print(B[i]+" ");
		System.out.println();
		int[] D = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14};
		int[] C = is.sort2(D); // 3 8 6 2 7 10 14 15 18 12 15 
		for(int i=0; i<C.length; i++) System.out.print(C[i]+" ");
		System.out.println();
		int[] E = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14};
		int[] F = is.sort3(E); // 2 3 8 7 6 10 12 18 15 15 14  
		for(int i=0; i<F.length; i++) System.out.print(F[i]+" ");
		System.out.println();
		int[] G = {6};
		int[] H = is.sort3(G); // 6 corner cases working
		for(int i=0; i<G.length; i++) System.out.print(G[i]+" ");
		System.out.println();
		int[] I = {6, 3};
		int[] J = is.sort3(I); // 3 6 corner cases working
		for(int i=0; i<J.length; i++) System.out.print(J[i]+" ");
		System.out.println();
	}

}
