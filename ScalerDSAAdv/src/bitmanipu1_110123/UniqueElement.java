package bitmanipu1_110123;

import java.util.HashMap;
import java.util.List;
// https://www.scaler.com/academy/mentee-dashboard/class/50129/assignment/problems/195/submissions
public class UniqueElement { // Single Number 2  Single Number II

	public int restThrice(int[] A) {
		int ans = 0;
		for(int i=0; i<32; i++) { // int so 32 and checking ith bit for all numbers in array
			int sum = 0;
			for(int j=0; j<A.length; j++) { // check if ith bit for jth number is set and sum++
				if(checkBit(A[j], i)) sum++;
			}
			if(sum%3 == 1) ans = ans + (1<<i);
		}
		return ans;
	}
	public boolean checkBit(int val, int bit) {
		// TODO Auto-generated method stub
		if(((val>>bit) & 1) == 1) return true;
		return false;
	}
	public int restThriceBrute(int[] A) {
		for(int i=0; i<A.length; i++) { 
			int count = 0;
			for(int j=0; j<A.length; j++) { 
				if(A[i]==A[j]) count++;
			}
			if(count%3 != 0) return A[i];
		}
		return 0;
	}
	public int restThriceHashMap(int[] A) { // working now
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<A.length; i++) { 
			if(hm.containsKey(A[i])) {
				hm.put(A[i], hm.get(A[i])+1);
				//System.out.println(hm.get(A[i]));
			} else {
				hm.put(A[i], 1);
			}
		}
		for(int i=0; i<A.length; i++) {
			if(hm.get(A[i]) %3 != 0) return A[i];
			//System.out.println(hm.get(i));
		}
		return 0;
	}
	 public int singleNumberScalerSol1(final List < Integer > A) {
	        int[] bits = new int[32];
	        // check frequency of each bit
	        for (int num: A) {
	            for (int i = 0; i < 32; i++) {
	                bits[i] += (1 & (num >> i));
	                bits[i] %= 3;
	            }
	        }
	        int number = 0;
	        for (int i = 31; i >= 0; i--) {
	            number = number * 2 + bits[i];
	        }
	        return number;
	    }
	 public int singleNumberScalerSol2(final List < Integer > A) {
	        int ones = 0, twos = 0, threes = 0;
	        for (int num : A) {
	            // twos is a bitmask to represent the ith bit had appeared twice
	            twos |= ones & num;
	            // ones is a bitmask to represent the ith bit had appeared once
	            ones ^= num;
	            // threes is a bitmask to represent the ith bit had appeared three times
	            threes = ones & twos;
	            ones &= ~threes;
	            twos &= ~threes;
	        }
	        return ones;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueElement ue = new UniqueElement();
		int[] A = {1,2,1,1,3,3,3};
		System.out.println(ue.restThrice(A)); // 2
		System.out.println(ue.restThriceBrute(A)); // 2
		System.out.println(ue.restThriceHashMap(A)); // 2
		int[] B = {5,7,5,4,7,11,11,9,11,7,5,4,4};
		System.out.println(ue.restThrice(B)); // 9
		System.out.println(ue.restThriceBrute(B)); // 9
		System.out.println(ue.restThriceHashMap(B)); // 2
		
	}

}
