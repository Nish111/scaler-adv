package greedy_070423;

import java.util.ArrayList;
import java.util.Collections;
// https://www.scaler.com/academy/mentee-dashboard/class/70940/homework/problems/4669/hints?navref=cl_pb_nv_tb
public class AnotherCoinProblem {

	public int anotherCoinProblem(int A) {
		// 1, 5, 25, 125, 625, 3125, 15625,
		int res=0;
		// assumed this as this is nearest and smaller than 2*10^9
		double temp=Math.pow(5, 13);
		//System.out.println((int)temp);
		while(A>0) {
			int some = (int) (A%temp);
			if(A==some) {
				temp=temp/5;
			}
			else if(some<temp) {
				res=(int) (res+A/temp);
				A=(int) (A%temp);
				
			}
		}
		return res;
	}
	 public int solveScalerSol(int A) {
	        ArrayList < Integer > v = new ArrayList < Integer > ();

	        int val = 1;

	        // Storing all denominations of coins
	        while (val <= 2000000000) {
	            v.add(val);
	            val = val * 5;
	        }
	        // Sort in decreasing order
	        Collections.reverse(v);

	        int ans = 0;
	        // Loop from the largest denomination
	        for (int i = 0; i < v.size(); i++) {
	            ans += A / v.get(i);
	            A = A % v.get(i);
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnotherCoinProblem acp = new AnotherCoinProblem();
		System.out.println(acp.anotherCoinProblem(47)); // 7
		System.out.println(acp.anotherCoinProblem(9)); // 5
		System.out.println(acp.anotherCoinProblem(101)); // 5
		System.out.println(acp.anotherCoinProblem(12399)); // 19
	}

}
