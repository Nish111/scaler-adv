package hashing_130223;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
// https://www.scaler.com/academy/mentee-dashboard/class/50143/assignment/problems/1302/hints?navref=cl_pb_nv_tb
public class ShaggyAndDistances {

	public int solve(int[] A) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			int temp = A[i];
			hm.put(temp, -1);
		}
		int dist=0, result = Integer.MAX_VALUE;
		for(int i=0; i<A.length; i++) {
			int temp = A[i];
			if(hm.containsKey(temp)) {
				if(hm.get(temp)== -1) {
					hm.put(temp, i);
				}
				else {
					dist = Math.abs(hm.get(temp)-i);
					result = Math.min(dist, result);
				}
			} 
		}
		if(result == Integer.MAX_VALUE) return -1;
		else return result;			
    }
	public int solveScalereSol(int[] A) {
        if (A.length == 1) {
            return -1;
        }
        // stores <Value, Index> pair
        HashMap < Integer, Integer > map = new HashMap < Integer, Integer > ();
        int result = A.length;
        for (int i = 0; i < A.length; i++) {
            // checks if A[i] has occurred previously
            if (map.containsKey(A[i])) {
                result = Math.min(result, i - map.get(A[i]));
            }
            map.put(A[i], i);
        }
        return (result == A.length) ? -1 : result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShaggyAndDistances sad = new ShaggyAndDistances();
		int[] A = {7, 1, 3, 4, 1, 7};
		System.out.println(sad.solve(A)); // 3
		int[] B = {1, 1};
		System.out.println(sad.solve(B)); // 1
		int[] C = {1, 2};
		System.out.println(sad.solve(C)); // -1
	}

}
