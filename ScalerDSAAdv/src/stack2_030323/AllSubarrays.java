package stack2_030323;

import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50151/homework/problems/1157/?navref=cl_pb_nv_tb
public class AllSubarrays {

	public int solveBrute(int[] A) { // O(N3) // not working
		// create all subarrays N2
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		int xor=0;
		for(int i=0; i<A.length-1; i++) {
			for(int j=i+1; j<A.length; j++) {
				// find max and sec max N
				for(int k=i; k<=j; k++) {
					if(A[k]>max) {
						max = A[k];
						secMax = max;
					} else if(A[k]<max && A[k]>secMax) {
						secMax = A[k];
					}
				}
				xor += max^secMax; 
			}
		}
		return xor;
		
	}
	public int solve(int[] A) { // O(N) O(N)
		// monotonous stack
		Stack<Integer> st = new Stack<>();
		int ans = 0;
		for(int i=0; i<A.length; i++) {
			while(!st.isEmpty()) {
				ans = Math.max(ans, st.peek()^A[i]);
				// we are putting max element only in stack
				if(st.peek()>A[i]) break;
				st.pop();
			}
			st.push(A[i]);
		}
		return ans;
	}
	public int solveScalerSol(int[] A) {
        int ans = 0;
        int n = A.length;
        // create a stack to store the maximum value of all subarrays
        Stack < Integer > s = new Stack < Integer > ();
        for (int i = 0; i < n; i++) {
            // while stack is not emepty take xor of its top and current element
            while (!s.empty()) {
                // strore the maximum value of xor
                int topElement = s.peek();
                ans = Math.max(ans, (A[topElement] ^ A[i]));
                // if top of the stack is greater than current element than break the loop
                if (A[topElement] > A[i]) break;
                else s.pop(); //pop out the top of the stack
            }
            // push the current element into the stack
            s.push(i);
        }
        // return the answer
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllSubarrays as = new AllSubarrays();
		int[] A = {2,3,1,4,2};
		System.out.println(as.solveBrute(A));
		System.out.println(as.solve(A)); // 7
		int[] B = {5, 2, 1,4,3};
		System.out.println(as.solveBrute(B));
		System.out.println(as.solve(B)); // 7
	}

}
