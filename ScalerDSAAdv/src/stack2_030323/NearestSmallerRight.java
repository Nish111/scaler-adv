package stack2_030323;

import java.util.Stack;
public class NearestSmallerRight {

	// nearest smaller element on right
	public int[] nearestSmallerBrute(int[] A) { // O(N2) O(N)
		int[] res = new int[A.length];
		res[0] = -1;
		for(int i=A.length-1; i>=0; i--) {
			for(int j=i+1; j<A.length; j++) {
				if(A[j]<A[i]) {
					res[i] = A[j];
					break;
				}
			}
			if(res[i]==0) res[i] = -1;
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
		for(int i=A.length-1; i>=0; i--) {
			while(!st.empty() && st.peek()>=A[i]) {
				st.pop();
			}
			if(st.empty()) {
				res[i] = -1;
			}
			else {
				res[i]=st.peek();
			}
			st.push(A[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NearestSmallerRight ns = new NearestSmallerRight();
		int[] A = {4, 5, 2, 10, 11, 2};
		int[] B = ns.nearestSmaller(A);
		ns.printArray(B); // 2 2 -1 2 2 -1 
		int[] X = ns.nearestSmallerBrute(A);
		ns.printArray(X); // 2 2 -1 2 2 -1 
		int[] C = {4, 6, 10, 11, 7, 8, 3, 5};
		int[] D = ns.nearestSmaller(C);
		ns.printArray(D); // 3 3 7 7 3 3 -1 -1 
		int[] Y = ns.nearestSmallerBrute(C);
		ns.printArray(Y); // 3 3 7 7 3 3 -1 -1 
		int[] E = {4, 5, 2, 10, 11, 2};
		int[] F = ns.nearestSmaller(E);
	}

}
