package math1_modarith_160123;

import java.util.ArrayList;
// https://www.scaler.com/academy/mentee-dashboard/class/50131/homework/problems/268/hints?navref=cl_pb_nv_tb
public class RearrangeArray {

	 public void arrange(ArrayList<Integer> A) {
	        int mul = A.size();
	        for(int i = 0; i < A.size(); i++){
	            int val = mul * A.get(i);
	            A.set(i,val);
	        }
	        for(int i = 0; i < A.size(); i++){
	            int newidx = A.get(i)/mul;
	            int newval = A.get(newidx)/mul + A.get(i);
	            A.set(i,newval);
	        }
	        for(int i = 0; i < A.size(); i++){
	            int val = A.get(i) % mul;
	            A.set(i,val);
	       }
	        for(int i=0; i<A.size(); i++) {
	        	System.out.print(A.get(i) +" ");
	        }
	        System.out.println();
	}
	 public void arrangeScalerSol(ArrayList<Integer> A) {
	   	    int n = A.size();
		    for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
		    for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RearrangeArray ra = new RearrangeArray();
		ArrayList<Integer> arrL = new ArrayList<>();
		arrL.add(0); arrL.add(2);arrL.add(1); arrL.add(3);
		ra.arrange(arrL);
		ArrayList<Integer> arrL1 = new ArrayList<>();
		arrL1.add(1); arrL1.add(0);
		ra.arrange(arrL1);
		ArrayList<Integer> arrL2 = new ArrayList<>();
		arrL2.add(0); arrL2.add(2);arrL2.add(1); //arrL2.add(4); // error so should be consecutive
		ra.arrange(arrL2);
	}

}
