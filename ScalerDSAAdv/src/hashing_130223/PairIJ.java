package hashing_130223;

import java.util.HashMap;
import java.util.Map;

public class PairIJ {

	public int findMinDistanceIJ(int[] A) {
		
		int ans = Integer.MAX_VALUE;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			if(!hm.containsKey(A[i])) hm.put(A[i], i);
			else {
				ans = Math.min(ans, i-hm.get(A[i]));
				hm.put(A[i], i);
			}
		}
		/*
		 * for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
		 * System.out.println("Key: " + entry.getKey() + ", Value: " +
		 * entry.getValue()); }
		 */
		if(ans==Integer.MAX_VALUE) return -1;
		else return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairIJ pij = new PairIJ();
		int[] A = {1,2,3,8,1,3,2,1};
		System.out.println(pij.findMinDistanceIJ(A)); // 3
	}

}
