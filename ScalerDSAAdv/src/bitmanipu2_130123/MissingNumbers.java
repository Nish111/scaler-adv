package bitmanipu2_130123;

import java.util.HashMap;
// 
public class MissingNumbers {

	public void solveHash(int[] A) {
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			if(hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i])+1);
			else
				hm.put(A[i], 1);
		}
		for(int i=0; i<A.length; i++) {
			if(hm.get(A[i])==1)
				System.out.println(A[i]);
		}
	}
	public void solve(int[] A) {
		int xor=0;
		for(int i=0; i<A.length; i++) {
			xor = xor^A[i];
		}
		for(int i=1; i<=A.length+2; i++) {
			xor=xor^i;
		}
		int bitno = -1;
		for(int i=0; i<32; i++) {
			if(((xor>>i) & 1) == 1) {
				bitno=i;
				break;
			}
		}
		int xor1=0, xor2=0;
		for(int i=0; i<A.length; i++) {
			if(((A[i]>>bitno) & 1) == 1) {
				xor1 = xor1^A[i];
			}else {
				xor2 = xor2^A[i];
			}
		}
		for(int i=1; i<=A.length+2; i++) {
			if(((i>>bitno) & 1) == 1) {
				xor1 = xor1^i;
			}else {
				xor2 = xor2^i;
			}
		}
		System.out.println(xor1 + " " + xor2);
	}
	public int[] solveUsing(int[] A) {
		int xor=0;
		for(int i=0; i<A.length; i++) {
			xor = xor^A[i];
		}
		int bitno = -1;
		for(int i=0; i<32; i++) {
			if(((xor>>i) & 1) == 1) {
				bitno=i;
				break;
			}
		}
		int xor1=0, xor2=0;
		for(int i=0; i<A.length; i++) {
			if(((A[i]>>bitno) & 1) == 1) {
				xor1 = xor1^A[i];
			}else {
				xor2 = xor2^A[i];
			}
		}
		int[] result = new int[2];
		if(xor1<xor2) {
			result[0] = xor1;
			result[1] = xor2;
		} else {
			result[0] = xor2;
			result[1] = xor1;	
		}
		return result;
    }
	 public int[] solveScalerSol(int[] A) {
	        int aXorb = 0; // the result of a xor b
	        for (int item: A)
	            aXorb ^= item;
	        int lastBit = (aXorb & (aXorb - 1)) ^ aXorb; // the last bit that a differs from b
	        int intA = 0, intB = 0;
	        for (int item: A) {
	            // based on the last bit, group the items into groupA (include a) and groupB
	            if ((item & lastBit) != 0)
	                intA = intA ^ item;
	            else
	                intB = intB ^ item;
	        }
	        int x = Math.min(intA, intB), y = Math.max(intA, intB);
	        int[] ans = new int[2];
	        ans[0] = x;
	        ans[1] = y;
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNumbers ue = new MissingNumbers();
		int[] A = {3, 6, 1, 4}; // 5 2
		//ue.solveHash(A);
		ue.solve(A);
		//int[] B = ue.solveUsing(A);
		//for(int i=0; i<B.length; i++) System.out.print(B[i]+" ");
	}

}
