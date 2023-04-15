package greedy_070423;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// https://www.scaler.com/academy/mentee-dashboard/class/70940/homework/problems/290/hints?navref=cl_pb_nv_tb
public class MiceAndHoles {
	public int mice(int[] A, int[] B) {
		if(A.length==0) return 0;
		int max = Integer.MIN_VALUE;
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i=0; i<A.length; i++)
			max = Math.max(Math.abs(A[i]-B[i]), max);
		return max;
	}
	public int mice(ArrayList < Integer > A, ArrayList < Integer > B) {
	    if (A == null || B == null)
	      return 0;

	    Collections.sort(A);
	    Collections.sort(B);

	    int max = 0;
	    int n = A.size();

	    for (int i = 0; i < n; i++) {
	      max = Math.max(max, Math.abs(A.get(i) - B.get(i)));
	    }

	    return max;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiceAndHoles mah = new MiceAndHoles();
		int[] A = {-4, 2, 3};
		int[] B = {0, -2, 4};
		System.out.println(mah.mice(A, B)); // 2
		int[] C = {-2};
		int[] D = {-6};
		System.out.println(mah.mice(C, D)); // 4
	}	

}
