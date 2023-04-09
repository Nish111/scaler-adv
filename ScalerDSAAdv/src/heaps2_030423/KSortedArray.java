package heaps2_030423;

import java.util.PriorityQueue;
// https://www.scaler.com/academy/mentee-dashboard/class/70939/assignment/problems/9264?navref=cl_tt_lst_sl
public class KSortedArray {

	public int[] KSorted(int[] A, int k) {
		// building min heap with 0 to k
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<=k;i++)
			pq.add(A[i]);
		int c = 0, n=A.length;
		int[] res = new int[A.length];
		for(int i=k+1; i<n; i++) {
			int val = pq.peek();
			res[c]=val;
			pq.poll();
			c++;
			pq.add(A[i]);
		}
		while(!pq.isEmpty()) {
			int val = pq.peek();
			res[c]=val;
			pq.poll();
			c++;
		}
		return res;
	}
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++)
			System.out.print(A[i] +" ");
		System.out.println();
	}
	 public int[] solveScalerSol(int[] A, int B) {
		    PriorityQueue < Integer > pq = new PriorityQueue();

		    int i = 0, n = A.length;
		    for (i = 0; i <= Math.min(B, n - 1); i++) {
		      pq.offer(A[i]);
		    }

		    int j = 0;
		    while (i < n) {
		      A[j] = pq.poll();
		      pq.offer(A[i]);
		      i++;
		      j++;
		    }

		    while (j < n) {
		      A[j] = pq.poll();
		      j++;
		    }
		    return A;
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSortedArray ksa = new KSortedArray();
		int[] A = {6,5,3,2,8,10,9};
		int[] B = ksa.KSorted(A, 3);
		ksa.printArray(B); // 2 3 5 6 8 9 10 
	}

}
