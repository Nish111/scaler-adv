package linklist3_270223;

import java.util.ArrayList;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50149/homework/problems/9290?navref=cl_tt_nv
public class MiddleElementOfStack {

	public int[] solve(int[][] A) {
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> ar = new ArrayList<>();
		for(int i=0;i<A.length; i++) {
			if(A[i][0] == 1) {
				st.push(A[i][1]);
			}
			else if(A[i][0]==2) {
				if(st.isEmpty()) ar.add(-1);
				else ar.add(st.pop());
			} else if(A[i][0]==3) {
				if(st.isEmpty()) ar.add(-1);
				else ar.add(middleElement(st));
			} else if(A[i][0]==4) {
				// delete middle of stack;
				if(!st.isEmpty()) {
					deleteMiddle(st);
				}
			}
		}
		int[] res = new int[ar.size()];
		for(int i=0; i<ar.size(); i++) {
			res[i] = ar.get(i);
		}
		return res;
		
    }
	public Integer middleElement(Stack<Integer> st) {
		// TODO Auto-generated method stub
		int len = st.size()/2;
		return st.get(len);
	}
	public void deleteMiddle(Stack<Integer> st) {
		// TODO Auto-generated method stub
		st.removeElementAt(st.size()/2);
	}
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiddleElementOfStack meos = new MiddleElementOfStack();
		int[][] A = { {1, 3}, {3, 0}, {4, 0}, {2 ,0}, {1, 5}, {1, 9}, {3, 0}};
		int[] X = meos.solve(A);
		meos.printArray(X); // 3 -1 9 
		int[][] B = {{1, 1}, {1, 2}, {1, 3}, {3, 0}, {4, 0}, {3, 0}, {4, 0}};
		int[] Y = meos.solve(B);
		meos.printArray(Y); // 2 3 
		int[][] C = {{2, 0}, {4, 0}, {3, 0}, {1, 170}, {1, 479}, {3, 0}, {3, 0}, 
				{1, 706}, {2, 0}, {2, 0}};
		int[] Z = meos.solve(C);
		meos.printArray(Z); // -1 -1 479 479 706 479 
		                	     
	}
}
