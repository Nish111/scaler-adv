package twopointers_100223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://www.scaler.com/academy/mentee-dashboard/class/50142/assignment/problems/9323?navref=cl_tt_nv
public class PairsWithGivenDifference {

	// code working but need to check properly again to optimize
	private int checkPairExistsTwoPointers(int[] A, int B) { 
		Arrays.sort(A);
		// as we need distinct pairs will use Hashset and revert it to arrays
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<A.length; i++) hs.add(A[i]);
		// specially for E F
		if(B==0) {
			if(hs.size() != A.length) return checkPairExistsTwoPointers1(A, B);
		}
		Integer[] D = new Integer[hs.size()];
		hs.toArray(D);
		Arrays.sort(D);
		int count=0;
		int p1 = 0, p2 = 1;
		while(p1<p2 && p2<D.length) { // if we use = then for element 8 and k 16, it will consider
			int diff = D[p2] - D[p1];
			if(diff == B) {
				count++;
				p1++;
			} 
			else if(diff < B) p2++;
			else p1++;
			if(p1==p2 && p2 != (D.length-1)) p2++;
		}
		return count;
	}
	public int checkPairExistsTwoPointers1(int[] A, int B) { // this is specifically for B=0
		//Arrays.sort(A);
		// as we need distinct pairs will use Hashset and revert it to arrays
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			if(hm.containsKey(A[i])) hm.put(A[i], hm.get(A[i])+1);
			else hm.put(A[i], 1);
		}
		int count=0;
		if(B==0){
			for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
				 if(entry.getValue() >1) count++;
			}
			return count;
		}
		Set<Map.Entry<Integer, Integer>> entrySet = hm.entrySet();
		Set<Map.Entry<Integer, Integer>> hs = new HashSet<>(entrySet);
		Integer[] D = new Integer[hs.size()];
		hs.toArray(D);
		Arrays.sort(D);
		int p1 = 0, p2 = 1;
		while(p1<p2 && p2<D.length) { // if we use = then for element 8 and k 16, it will consider
			int diff = D[p2] - D[p1];
			if(diff == B) {
				count++;
				p1++;
			} 
			else if(diff < B) p2++;
			else p1++;
			if(p1==p2 && p2 != (D.length-1)) p2++;
		}
		return count;
	}
	public int solveScalerSol(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int i = 0, j = 1;
        long ans = 0;
        while(j < A.size()) {
            if(j == i) {
                j++;
                continue;
            }
            int x = A.get(i), y = A.get(j);
            if(y - x == B) {
                // count the pair A[i], A[j] only once
                ans++;
                while(i < A.size() && A.get(i) == x) i++;
                while(j < A.size() && A.get(j) == y) j++;
            }
            else if(y - x > B){
                i++;
            }
            else j++;
        }
        return (int)ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairsWithGivenDifference pwgd = new PairsWithGivenDifference();
		int[] A = {3, 7, 8, 12, 19};
		System.out.println(pwgd.checkPairExistsTwoPointers(A, 5)); // 2
		//System.out.println(pwgd.checkPairExistsTwoPointers1(A, 5));
		int[] B = {2,5,8,11,15};
		System.out.println(pwgd.checkPairExistsTwoPointers(B, 3)); // 3
		//System.out.println(pwgd.checkPairExistsTwoPointers1(B, 3));
		int[] C = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
		System.out.println(pwgd.checkPairExistsTwoPointers(C, 5)); // 3
		//System.out.println(pwgd.checkPairExistsTwoPointers1(C, 5));
		int[] D = {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
		System.out.println(pwgd.checkPairExistsTwoPointers(D, 3)); // 7
		//System.out.println(pwgd.checkPairExistsTwoPointers1(D, 3));
		int[] E = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(pwgd.checkPairExistsTwoPointers(E, 0)); // 1
		System.out.println(pwgd.checkPairExistsTwoPointers1(E, 0)); // 1
		int[] F = {1, 1, 1, 1, 1, 1, 1, 2, 2, 2};
		System.out.println(pwgd.checkPairExistsTwoPointers(F, 0)); // 1
		System.out.println(pwgd.checkPairExistsTwoPointers1(F, 0)); // 2
		
	}

}
