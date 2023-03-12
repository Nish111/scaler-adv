package stack2_030323;

import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50151/assignment/problems/4347/?navref=cl_pb_nv_tb
public class SortStack {

	public int[] solve(int[] A) { // O(N2) O(N)
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		for(int i=0; i<A.length; i++) {
			s1.push(A[i]);
			//System.out.println(s1.peek());
		}
		while(!s1.isEmpty()) {
			int x = s1.pop();
			//System.out.println(x);
			while(!s2.isEmpty() && s2.peek()>x) {
				int y = s2.pop();
				s1.push(y);
			}
			s2.push(x);
			//System.out.println(s2.peek());
		}
		int[] res = new int[A.length];
		for(int i=A.length-1; i>=0; i--) {
			res[i] = s2.pop();
		}
		return res;
    }
	public int[] solveScalerSol(int[] A) {

	    if (A.length <= 1) return A;

	    Stack < Integer > s1 = new Stack < Integer > ();
	    Stack < Integer > helper = new Stack < Integer > ();
	    for (int i = 0; i < A.length; i++) {
	      s1.push(A[i]);
	    }

	    while (!s1.empty()) {
	      int temp = s1.peek();
	      s1.pop();
	      // keep popping from helper till its peek value is more than temp
	      while (!helper.empty() && helper.peek() > temp) {
	        s1.push(helper.peek());
	        helper.pop();
	      }
	      helper.push(temp);
	    }
	    while (!helper.empty()) {
	      s1.push(helper.peek());
	      helper.pop();
	    }

	    int ans[] = new int[A.length], i = 0;
	    while (!s1.empty()) {
	      ans[i] = s1.peek();;
	      s1.pop();
	      i++;
	    }
	    return ans;
	  }
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i] +" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortStack ss = new SortStack();
		int[] A = {5, 4, 3, 2, 1};
		int[] B = ss.solve(A);
		ss.printArray(B);
		int[] C = {5, 17, 100, 11};
		int[] D = ss.solve(C);
		ss.printArray(D);
	}

}
