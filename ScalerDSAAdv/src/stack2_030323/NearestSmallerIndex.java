package stack2_030323;

import java.util.Stack;

public class NearestSmallerIndex {

	// nearest smaller element's index on left
	public int[] nearestSmallerBrute(int[] A) { // O(N2) O(N)
		int[] res = new int[A.length];
		res[0] = -1;
		for(int i=1; i<A.length; i++) {
			for(int j=i-1; j>=0; j--) {
				if(A[j]<A[i]) {
					res[i] = j;
					break;
				}
				else res[i] = -1;
			}
			//if(res[i]==0) res[i] = -1;
		}
		return res;
	}
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i] +" ");
		}
		System.out.println();
	}
	public int[] nearestSmaller(int[] A) { // O(N) O(N)
		int[] res = new int[A.length];
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<A.length; i++) {
			while(!st.empty() && A[st.peek()]>=A[i]) {
				st.pop();
			}
			if(st.empty()) {
				res[i] = -1;
			}
			else {
				res[i]=st.peek();
			}
			st.push(i);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NearestSmallerIndex ns = new NearestSmallerIndex();
		int[] A = {4, 5, 2, 10, 11, 2};
		int[] B = ns.nearestSmaller(A);
		ns.printArray(B); // -1 0 -1 2 3 -1 
		int[] X = ns.nearestSmallerBrute(A);
		ns.printArray(X); // -1 0 -1 2 3 -1 
		int[] C = {4, 6, 10, 11, 7, 8, 3, 5};
		int[] D = ns.nearestSmaller(C);
		ns.printArray(D); // -1 0 1 2 1 4 -1 6 
		int[] Y = ns.nearestSmallerBrute(C);
		ns.printArray(Y); // -1 0 1 2 1 4 -1 6
		int[] E = {4, 5, 2, 10, 11, 2};
		int[] F = ns.nearestSmaller(E);
	}

}
