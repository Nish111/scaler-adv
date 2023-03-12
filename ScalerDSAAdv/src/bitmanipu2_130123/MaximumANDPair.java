package bitmanipu2_130123;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50130/assignment/problems/19558?navref=cl_tt_lst_sl
public class MaximumANDPair {

	public int solveBrute(int[] A) { // O(N2)
		int and=0, max_val=Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length; j++) {
				and = A[i]&A[j];
				max_val = Math.max(max_val, and);
			}
		}
		return max_val;
	}
	public int solve(int[] A) {
		int count=0, ans=0;
		for(int i=31; i>=0; i--) {
			count=0;
			for(int j=0; j<A.length; j++) {
				if(((A[j]>>i) & 1) == 1) count++;
			}
			if(count>=2) {
				ans+=Math.pow(2, i);
				for(int k=0; k<A.length; k++) {
					if(((A[k]>>i) & 1) != 1) A[k]=0;
				}
			}
		}
		return ans;
	}
	 public int solveScalerSol(ArrayList < Integer > A) {
	        ArrayList < Integer > v = new ArrayList < Integer > ();
	        for (int it : A) 
	            v.add(it);
	        for (int i = 29; i >= 0; i--) {
	            // create a set of elements with the i-th bit set
	            ArrayList < Integer > v2 = new ArrayList < Integer > ();
	            for (int it : v)
	                if ((it & (1 << i)) != 0) 
	                    v2.add(it);
	            if (v2.size() >= 2) {
	                v.clear();
	                for (int it: v2) 
	                    v.add(it);
	            }
	        }
	        return (int)(v.get(0) & v.get(1));
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumANDPair map = new MaximumANDPair();
		int[] A = {53, 39, 88};
		System.out.println(map.solveBrute(A)); // 37
		System.out.println(map.solve(A)); // 37
		int[] B = {38, 44, 84, 12};
		System.out.println(map.solveBrute(B)); // 36
		System.out.println(map.solve(B)); // 36
		int[] C = {26, 13, 23, 28, 27, 7, 25};
		System.out.println(map.solveBrute(C)); // 26
		System.out.println(map.solve(C)); // 26
	}

}
