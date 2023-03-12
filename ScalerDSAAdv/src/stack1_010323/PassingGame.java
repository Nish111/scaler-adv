package stack1_010323;

import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50150/assignment/problems/1064?navref=cl_tt_nv
public class PassingGame {
	public int solve(int A, int B, int[] C) {
		if(A==1) return C[0];
		Stack<Integer> st = new Stack<>();
		st.push(B);
		int result = 0;
		for(int i=0; i<A; i++) {
			if(C[i]==0) st.pop();
			else st.push(C[i]);
		}
		result = st.pop();
		return result;
    }
	public static void main(String[] args) {
		PassingGame pg = new PassingGame();
		int[] C = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
		System.out.println(pg.solve(10, 23, C)); // 63
		int[] A = {2};
		System.out.println(pg.solve(1, 1, A)); // 2
	}
}
