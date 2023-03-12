package bitmanipu1_110123;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50129/homework/problems/1085?navref=cl_tt_lst_sl
public class InterestingArray {
/*
 * Problem Description
You have an array A with N elements. We have two types of operation available on this array :
We can split an element B into two elements, C and D, such that B = C + D.
We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 
0 after several splits and/or merge?

For 9 and 17
 Following is one possible sequence of operations -  
 1) Merge i.e 9 XOR 17 = 24  
 2) Split 24 into two parts each of size 12  
 3) Merge i.e 12 XOR 12 = 0  
 As there is only 1 element i.e 0. So it is possible.
 */
	public String solve(int[] A) { // basically we re checking if we have even count of odd elements
		int count=0;
		for(int i=0; i<A.length; i++) {
			if(A[i]%2 != 0) count++;
		}
		if(count %2 ==0) return "Yes";
		else return "No";
	}
	 public String solveScalerSol(ArrayList < Integer > A) {
	        int cnt = 0;
	        for (int x: A) {
	            if (x % 2 == 1)
	                cnt++;
	        }
	        // checks the parity of the number of odd elements
	        if (cnt % 2 == 1)
	            return "No";
	        else
	            return "Yes";
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterestingArray ia = new InterestingArray();
		int[] A = {9,17};
		int[] B = {1};
		System.out.println(ia.solve(A)); // Yes
		System.out.println(ia.solve(B)); // No
		
	}

}
