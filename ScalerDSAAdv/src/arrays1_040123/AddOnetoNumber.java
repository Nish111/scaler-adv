package arrays1_040123;

import java.util.ArrayList;
import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/50126/homework/problems/66/hints?navref=cl_pb_nv_tb
public class AddOnetoNumber {

	public int[] plusOne(int[] A) { // Scaler gave correct made my working for 0 9 9 9
		int count = 0; // checking for preceding Zeroes
		for (int i = 0; i < A.length && A.length > 1; i++) {
			if (A[i] == 0) {
				count++;
			} else
				break;
		}
		int val = 0; // to check if count of 9 is A.length - count;
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] < 9) {
				A[i]++;
				//System.out.println(i);
				if((val == A.length-count)) { // to check if we have case like 0 9 9 9
				// in such cases need to increment and also does not remove 0
				// so have val to compare
					return Arrays.copyOfRange(A, 0, A.length);
				}
				return Arrays.copyOfRange(A, count, A.length);
			}
			else {
				A[i] = 0;
				val++;
			}
			
		}
		int[] result = new int[A.length + 1];
		result[0] = 1;
		return result;

		/*
		 * int count = 0; // This for loop is to count the preceding no. of zeros and
		 * A.length > 1 is to for edge case ex: {0} for (int i=0; i<A.length &&
		 * A.length>1; i++) { if (A[i] == 0) { count++;} else break; } // This is to
		 * increase the digit by 1 for (int i=A.length-1; i>=0; i--) { if (A[i] < 9) {
		 * A[i]++; return Arrays.copyOfRange(A, count, A.length); } A[i] = 0; } // This
		 * condition is for case for ex: {9,9,9,9} int[] ans = new int[A.length+1];
		 * ans[0] = 1; return ans;
		 */
	}
public ArrayList<Integer> plusOneScalerSol(ArrayList<Integer> A) { // this works for 0 9 9 9
	    int carry = 1;
	    int num;
	    int size = A.size();
	    // traversing the digits of the number in reverse order
	    for (int i = size - 1; i >= 0; i--) {
	        num = A.get(i);
	        num += carry;
	        carry = 0;
	        if (num == 10) {
	            num = 0;
	            carry = 1;
	        }
	        A.set(i, num);
	    }
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if (carry == 1)
	        res.add(1);
	    for (int x : A) {
	        if (x == 0 && res.size() == 0)
	            continue;
	        res.add(x);
	    }
	    return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOnetoNumber aotn = new AddOnetoNumber();
		int[] A = { 1, 2, 3 };
		//int[] B = aotn.plusOne(A);// 1 2 4
		int[] C = { 0, 1, 2, 3 };
		//int[] D = aotn.plusOne(C);// 1 2 4
		int[] E = { 9, 9, 9 };
		int[] F = aotn.plusOne(E);// 1 0 0 0
		int[] G = { 0, 9, 9, 9 };
		int[] H = aotn.plusOne(G);// 1 0 0 0 // modified and now getting
		int[] I = { 5, 9, 9};
		int[] J = aotn.plusOne(I);// 1 3 0
		//for (int i = 0; i < B.length; i++) System.out.print(B[i] + " ");
		//System.out.println();
		//for (int i = 0; i < D.length; i++) System.out.print(D[i] + " ");
		//System.out.println();
		for (int i = 0; i < F.length; i++) System.out.print(F[i] + " ");
		System.out.println();
		for (int i = 0; i < H.length; i++) System.out.print(H[i] + " ");
		System.out.println();
		for (int i = 0; i < J.length; i++) System.out.print(J[i] + " ");
		System.out.println();
		//ArrayList<Integer> X = new ArrayList<>();
		//X.add(0); X.add(9); X.add(9); X.add(9);
		//ArrayList<Integer> Y = aotn.plusOneScalerSol(X);
		//for (int i = 0; i < Y.size(); i++) System.out.print(Y.get(i) + " ");
		//System.out.println();
	}

}
