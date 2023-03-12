package stack2_030323;

import java.util.Arrays;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50151/homework/problems/263?navref=cl_tt_lst_sl
public class NearestGreaterRight {

	// nearest smaller element on right
	public int[] nearestSmallerBrute(int[] A) { // O(N2) O(N)
		int[] res = new int[A.length];
		res[0] = -1;
		for(int i=A.length-1; i>=0; i--) {
			for(int j=i+1; j<A.length; j++) {
				if(A[j]>A[i]) {
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
			while(!st.empty() && st.peek()<=A[i]) {
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
	public int[] nextGreaterScalerSol(int[] A) {
        Stack < Integer > s = new Stack < > ();
        s.push(0);
        int n = A.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 1; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            // find the elements whose next greater element is A[i]
            while (!s.isEmpty() && A[s.peek()] < A[i]) {
                ans[s.peek()] = A[i];
                s.pop();
            }
            s.push(i);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NearestGreaterRight ns = new NearestGreaterRight();
		int[] A = {4, 5, 2, 10, 11, 2};
		int[] B = ns.nearestSmaller(A);
		ns.printArray(B); // 5 10 10 11 -1 -1 
		int[] X = ns.nearestSmallerBrute(A);
		ns.printArray(X); // 5 10 10 11 -1 -1 
		int[] C = {4, 6, 10, 11, 7, 8, 3, 5};
		int[] D = ns.nearestSmaller(C);
		ns.printArray(D); // 6 10 11 -1 8 -1 5 -1
		int[] Y = ns.nearestSmallerBrute(C);
		ns.printArray(Y); // 6 10 11 -1 8 -1 5 -1
		int[] E = {39, 27, 11, 4, 24, 32, 32, 1};
		int[] F = ns.nearestSmaller(E);
		ns.printArray(F); // -1 32 24 24 32 32 -1 -1 
		int[] V = ns.nearestSmallerBrute(E);
		ns.printArray(V); // -1 32 24 24 32 -1 -1 -1 
	}

}
