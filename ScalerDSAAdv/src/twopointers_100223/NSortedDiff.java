package twopointers_100223;

import java.util.Arrays;

public class NSortedDiff {

	// for distinct elements
	private int checkPairExists(int[] a, int k) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int checkPairExistsHash(int[] a, int k) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int checkPairExistsTwoPointers(int[] A, int k) {
		//Arrays.sort(A);
		int count=0;
		int p1 = 0, p2 = 1;
		while(p1<p2 && p2<A.length) { // if we use = then for element 8 and k 16, it will consider
			int diff = A[p2] - A[p1];
			if(diff == k) {
				count++;
				p1++;
			} 
			else if(diff < k) {
				p2++;
			}
			else p1++;
			if(p1==p2 && p2 != (A.length-1)) p2++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NSortedDiff nsd = new NSortedDiff();
		int[] A = {3, 7, 8, 12, 19};
		System.out.println(nsd.checkPairExists(A, 5)); // 
		System.out.println(nsd.checkPairExistsHash(A, 5)); // 
		System.out.println(nsd.checkPairExistsTwoPointers(A, 5)); // 2
		int[] B = {2,5,8,11,15};
		System.out.println(nsd.checkPairExists(B, 3)); // 
		System.out.println(nsd.checkPairExistsHash(B, 3)); // 
		System.out.println(nsd.checkPairExistsTwoPointers(B, 3)); // 3
		int[] C = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
		System.out.println(nsd.checkPairExists(C, 5)); // 
		System.out.println(nsd.checkPairExistsHash(C, 5)); // 
		System.out.println(nsd.checkPairExistsTwoPointers(C, 5)); // 3
		int[] D = {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
		System.out.println(nsd.checkPairExists(D, 3)); // 1
		System.out.println(nsd.checkPairExistsTwoPointers(D, 3)); // 3 -- need 7
	}

	

}
