package searching2_060223;

import java.util.List;

// https://www.scaler.com/academy/mentee-dashboard/class/50140/assignment/problems/203?navref=cl_tt_nv
public class RotatingSortedArray {

	public int solve1(int[] A, int k, int key) { // Linear search O(A)
		
		for(int i=0; i<A.length; i++) {
			if(A[i]==key) return 1;
		}
		return 0;
	}
	public int solve2(int[] A, int k, int key) { // Binary search O(logA)
		// assume 2 halves in array ans confirm in which part key lies
		int start = 0, end = A.length-1;
		if(key<A[0]) start = k;
		if(key>A[A.length-1]) end = k-1;
		for(int i=start; i<=end; i++) {
			if(A[i]==key) return 1;
		}
		return 0;
	}
	
	// k is not given
	public int solveKnot1(int[] A, int key) { // Linear search O(A)
		
		for(int i=0; i<A.length; i++) {
			if(A[i]==key) return 1;
		}
		return 0;
	}
	public int solveKnot2(int[] A, int key) { // Binary search O(logA)
		// assume 2 halves in array ans confirm in which part key lies
		int start = 0, end = A.length-1;
		int mid = 0;
		int index = 0;
		while(start<end) {
			mid = (start+end)/2;
			if(A[mid]>A[mid-1] && A[mid]<A[mid+1]) {
				index = mid;
				break;
			}
			else if(A[mid]>A[0]) start = mid+1; // go to right
			else end = mid-1; //if(A[mid]<A[0]) go to left
		}
		start = 0; end = A.length-1;
		if(key<A[0]) start = index;
		if(key>A[A.length-1]) end = index-1;
		for(int i=start; i<=end; i++) {
			if(A[i]==key) return 1;
		}
		return 0;
	}
	public int solveKnot3(int[] A, int key) { // Binary search O(logA)
		// assume 2 halves in array ans confirm in which part key lies
		// without if
		int start = 0, end = A.length-1;
		int mid = (start+end)/2;
		int index = 0;
		while(start<end) {
			mid = (start+end)/2;
			if(A[mid]>A[0]) {
				start = mid+1; // go to right
				index = mid;
			}
			else {
				end = mid-1; //if(A[mid]<A[0]) go to left
				index = mid;
			}
		}
		start = 0; end = A.length-1;
		if(key<A[0]) start = index;
		if(key>A[A.length-1]) end = index-1;
		for(int i=start; i<=end; i++) {
			if(A[i]==key) return i;
		}
		return -1;
	}
	// DO NOT MODIFY THE LIST
		public int searchScalerSol(final List<Integer> A, int B) {
		    int mid;
		    int start, end;
		    int count;
		    int num;
		    int n = A.size();
		    count = n;
		    // find the index of minimum element
		    int pivot = getMinElementIndexScalerSol(A);
		    // Now we can binary search in two parts 0 - pivot and pivot to n-2
		    start = pivot;
		    end = n - 1;
		    int res = binarySearchScalerSol(A, start, end, B);
		    if (res == -1) {
		        start = 0;
		        end = pivot - 1;
		        res = binarySearchScalerSol(A, start, end, B);
		    }
		    return res;
		}
		
		public int binarySearchScalerSol(final List<Integer> A, int start, int end, int B) {
		    int count = end - start + 1;
		    int num, mid;
		    while (count > 0) {
		        mid = start + (end - start) / 2;
		        num = A.get(mid);
		        if (B == num)
		            return mid;
		        if (B < num)
		            end = mid - 1;
		        else
		            start = mid + 1;
		        count /= 2;
		    }
	        return -1;
		}
		public int getMinElementIndexScalerSol(final List<Integer> A) {
		    int first, last, start, end;
		    int count, num, n;
		    int mid;
		    int next, prev;
		    n = A.size();
		    count = n;
		    first = A.get(0);
		    last = A.get(n - 1);
		    start = 0;
		    end = n - 1;
		    while (count > 0) {
		        mid = start + (end - start) / 2;
		        num = A.get(mid);
		        next = A.get((mid + 1) % n);
		        prev = A.get((mid - 1 + n) % n);
		        if (num < prev && num < next) {
		            return mid;
		        }
		        if (num > first && num > last)
		            start = mid + 1;
		        else 
		            end = mid - 1;
		        count /= 2;
	        }
		    return -1;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotatingSortedArray rsa = new RotatingSortedArray();
		int[] A = {11, 14, 19, 23, 27, -20, -14, -8, -4, 1, 2, 4, 9};
		System.out.println(rsa.solve1(A, 5, -14)); // 1
		System.out.println(rsa.solve2(A, 5, -14)); // 1
		System.out.println(rsa.solve2(A, 5, -13)); // 0
		System.out.println(rsa.solveKnot1(A, -14)); // 1
		System.out.println(rsa.solveKnot2(A, -14)); // 1
		System.out.println(rsa.solveKnot3(A, -13)); // 0
		System.out.println(rsa.solveKnot3(A, -14)); // 1
		int[] B = {5, 1, 3};
		System.out.println(rsa.solveKnot3(B, 5));// 0
		System.out.println(rsa.solveKnot2(B, 5));// 0
	}

}
