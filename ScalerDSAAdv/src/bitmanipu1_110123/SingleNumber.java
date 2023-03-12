package bitmanipu1_110123;

import java.util.List;

// https://www.scaler.com/academy/mentee-dashboard/class/50129/assignment/problems/193?navref=cl_tt_lst_sl
public class SingleNumber {

	public int singleNumber(final int[] A) {
		int result=0;
		for(int i=0; i<A.length; i++) {
			result = result ^A[i];
		}
		return result;
    }
	 public int singleNumberScalerSol(final List < Integer > A) {
	        int num = 0;
	        for (int val: A) {
	            // xor of all the elements of the array
	            num ^= val;
	        }
	        return num;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumber sn = new SingleNumber();
		int[] A = {1,2,2,3,1};
		System.out.println(sn.singleNumber(A));
		
	}

}
