package twopointers_100223;

import java.util.HashMap;

public class NSortedElements {
	public int checkPairExists(int[] A, int k) { // O(n2) O(1) -- brute
		int count=0;
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length; j++) {
				if(A[i]+A[j] == k) count++;
			}
		}
		return count;
	}
	public int checkPairExistsHash(int[] A, int k) { // O(n) O(n) -- hashmap
		int count=0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			if(hm.containsKey(k-A[i])) count++;
			else hm.put(A[i], 1);
		}
		return count;
	}
	public int checkPairExistsBinary(int[] A, int k) { // O(nlogn) O(1) -- binary search
		// not correct
		int count=0;
		int left = 0, right = A.length-1;
		while(left<=right) {
			int mid = A[left] + A[right];
			if(mid == k) {
				count++;
			} 
			else if(mid < k) {
				left = mid+1;
			}
			else right = mid-1;
		}
		return count;
	}
	public int checkPairExistsTwoPointers(int[] A, int k) { // O(n) O(1) -- two pointers
		int count=0;
		int p1 = 0, p2 = A.length-1;
		while(p1<p2) { // if we use = then for element 8 and k 16, it will consider
			int sum = A[p1] + A[p2];
			if(sum == k) {
				count++;
				p1++;
			} 
			else if(sum < k) {
				p1++;
			}
			else p2--;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NSortedElements nse = new NSortedElements();
		int[] A = {3, 7, 8, 12, 19};
		System.out.println(nse.checkPairExists(A, 15)); // 2
		System.out.println(nse.checkPairExistsHash(A, 15)); // 2
		System.out.println(nse.checkPairExistsTwoPointers(A, 15)); // 2
		int[] B = {2,5,8,11,15};
		System.out.println(nse.checkPairExists(B, 16)); // 1
		System.out.println(nse.checkPairExistsHash(B, 16)); // 1
		System.out.println(nse.checkPairExistsTwoPointers(B, 16)); // 1
		int[] C = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
		System.out.println(nse.checkPairExists(C, 17)); // 2
		System.out.println(nse.checkPairExistsHash(C, 17)); // 2
		System.out.println(nse.checkPairExistsTwoPointers(C, 17)); // 2
		int[] D = {2,5,8,11,15};
		System.out.println(nse.checkPairExists(D, 16)); // 1
	}

}
