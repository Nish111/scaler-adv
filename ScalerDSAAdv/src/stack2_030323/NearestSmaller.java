package stack2_030323;

import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50151/assignment/problems/332?navref=cl_tt_lst_sl
public class NearestSmaller {

	// finding nearest smaller element on left
	public int[] nearestSmallerBrute(int[] A) { // O(N2) O(N)
		int[] res = new int[A.length];
		res[0] = -1;
		for(int i=1; i<A.length; i++) {
			for(int j=i-1; j>=0; j--) {
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
		for(int i=0; i<A.length; i++) {
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
	public int[] nearestSmallerForAsgn(int[] A) { // O(N) O(N)
		int[] res = new int[A.length];
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<A.length; i++) {
			while(!st.empty() && st.peek()>=A[i]) {
				st.pop();
			}
			if(!st.empty() && st.peek()<A[i]) {
				res[i]=st.peek();
			} else res[i] = -1;
			st.push(A[i]);
		}
		return res;
	}
	public int[] prevSmallerScalerSol(int[] A) {
        int[] ans = new int[A.length];
        Stack < Integer > st = new Stack < > ();
        for (int i = 0; i < A.length; i++) {
            // pop all the elements from the stack greater than current element
            while (!st.isEmpty() && st.peek() >= A[i])
                st.pop();
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(A[i]);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NearestSmaller ns = new NearestSmaller();
		int[] A = {4, 5, 2, 10, 11, 2};
		int[] B = ns.nearestSmaller(A);
		ns.printArray(B); // -1 4 -1 2 10 -1 
		int[] Z = ns.nearestSmallerForAsgn(A);
		ns.printArray(Z); // -1 4 -1 2 10 -1 
		int[] X = ns.nearestSmallerBrute(A);
		ns.printArray(X); // -1 4 -1 2 10 -1
		int[] C = {4, 6, 10, 11, 7, 8, 3, 5};
		int[] D = ns.nearestSmaller(C);
		ns.printArray(D); // -1 4 6 10 6 7 -1 3 
		int[] Y = ns.nearestSmallerBrute(C);
		ns.printArray(Y); // -1 4 6 10 6 7 -1 3 
		int[] E = {4, 5, 2, 10, 11, 2};
		int[] F = ns.nearestSmaller(E);
	}

}
