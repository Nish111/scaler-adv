package stack2_030323;

import java.util.Arrays;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50151/assignment/problems/7042/?navref=cl_pb_nv_tb
public class IntArrayMaxMin {

	public int findMaxMinSubArray(int[] A) {
		if(A.length==1) return A[0];
		int[] nsl = nearestSmallerLeft(A);
		printArray(nsl); // -1 0 0 2 2 0 5 5 0 
		int[] nsr = nearestSmallerRight(A);
		printArray(nsr); // 9 2 5 4 5 9 7 8 9
		int[] ngl = nearestGreaterLeft(A);
		printArray(ngl); // -1 -1 1 1 3 4 -1 6 7 
		int[] ngr = nearestGreaterRight(A);
		printArray(ngr); // -1 -1 1 1 3 4 -1 6 7 
		
		long max=0, min=0;
		int mod = 1000000007;
		for(int i=0; i<A.length; i++) {
			long nSMax = 1l* (i-ngl[i])*(ngr[i]-i);
			long temp1 = (nSMax*A[i])%mod;
			long nSMin = 1L*(i-nsl[i])*(nsr[i]-i);
			long temp2 = (nSMin*A[i])%mod;
			
			max = ((temp1%mod) +(max%mod))%mod;
			min = ((temp2%mod) +(min%mod))%mod;
			
		}
		int res=(int) ((max - min)%mod);
		return ((res+mod)%mod);
	}
	public int[] nearestSmallerLeft(int[] A) { // O(N) O(N)
		int[] res = new int[A.length];
		Arrays.fill(res, -1);
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<A.length; i++) {
			while(!st.empty() && A[st.peek()]>=A[i]) { // pay attention here
				st.pop();
			}
			if(!st.empty()) res[i] = st.peek();
			st.push(i); // pay attention here
		}
		return res;
	}
	public int[] nearestGreaterLeft(int[] A) { // O(N) O(N)
		int[] res = new int[A.length];
		Arrays.fill(res, -1);
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<A.length; i++) {
			while(!st.empty() && A[st.peek()]<A[i]) { // pay attention here
				st.pop();
			}
			if(!st.empty()) res[i] = st.peek();
			st.push(i); // pay attention here
		}
		return res;
	}
	public int[] nearestSmallerRight(int[] A) { // O(N) O(N)
		int[] res = new int[A.length];
		Arrays.fill(res, A.length);
		Stack<Integer> st = new Stack<>();
		for(int i=A.length-1; i>=0; i--) {
			while(!st.empty() && A[st.peek()]>=A[i]) { // pay attention here
				st.pop();
			}
			if(!st.empty()) res[i] = st.peek();
			st.push(i); // pay attention here
		}
		return res;
	}
	public int[] nearestGreaterRight(int[] A) { // O(N) O(N)
		int[] res = new int[A.length];
		Arrays.fill(res, A.length);
		Stack<Integer> st = new Stack<>();
		for(int i=A.length-1; i>=0; i--) {
			while(!st.empty() && A[st.peek()]<=A[i]) { // pay attention here
				st.pop();
			}
			if(!st.empty()) res[i] = st.peek();
			st.push(i); // pay attention here
		}
		return res;
	}
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i] +" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntArrayMaxMin iamm = new IntArrayMaxMin();
		int[] A = {1, 8, 3, 5, 4, 2, 11, 7, 2};
		iamm.printArray(A); // 1 8 3 5 4 2 11 7 2 
		System.out.println(iamm.findMaxMinSubArray(A)); // 242
		int[] B = {1};
		iamm.printArray(B); // 1 8 3 5 4 2 11 7 2 
		System.out.println(iamm.findMaxMinSubArray(B)); // 1
		int[] C = {4, 7, 3, 8};
		iamm.printArray(C); // 1 8 3 5 4 2 11 7 2 
		System.out.println(iamm.findMaxMinSubArray(C)); // 26
		int[] D = {1, 2, 3};
		iamm.printArray(D); // 1 8 3 5 4 2 11 7 2 
		System.out.println(iamm.findMaxMinSubArray(D)); // 4
	}

}
