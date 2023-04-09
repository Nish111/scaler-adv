package heaps1_290323;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.scaler.com/academy/mentee-dashboard/class/70938/assignment/problems/362?navref=cl_tt_lst_nm
public class ChocolateEaten {

	public int findMax(int[] A, int T) { // failing for hard as expected
		int mod = 1000000007;
		Long ans=0L;
		int len = A.length, index=0;
		while(T>0) {
			int max = Integer.MIN_VALUE;
			for(int i=0; i<len; i++) {
				if(max<A[i]) {
					max = A[i];
					index=i;
				}
			}
			ans+=max%mod;
			A[index] = (int) Math.floor(max/2);
			T--;
		}
		int res = (int) (ans%mod);
		return res;
	}
	// using heap
	public int findMaxHeap(int A, int[] B) {
		// Max heap can do the trick
		// for max heap
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
		// for min heap
		//PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
		for(int i=0; i<B.length; i++) {
			pq.add(B[i]);
		}
		int max = Integer.MIN_VALUE, mod = 1000000007;
		Long ans=0L;
		while(A>0) {
			max = pq.poll();
			ans += max;
			pq.add((int) Math.floor(max/2));
			A--;
		}
		int res = (int) (ans%mod);
		return res;
	}
	static long mod = 1000000007;
    public int nchoc(int A, int[] B) {
        int N = B.length;
        int K = A;
        long ans = 0;
        PriorityQueue < Integer > heap = new PriorityQueue(new CustomComp());
        for (int a: B)
            heap.offer(a);
        while (K > 0) {

            //Get maximum element from the heap 
            long max_elem = (long) heap.poll();

            // Add the maximum element to the answer
            ans += max_elem;
            ans = ans % mod;
            // push the floor(A[i]/2) back to the heap.
            heap.offer((int)(max_elem / 2));
            K--;
        }
        return (int) ans;
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateEaten ce = new ChocolateEaten();
		int[] A = {2,8,10,24};
		System.out.println(ce.findMax(A, 3)); // 46
		A = new int[]{2,8,10,24};
		System.out.println(ce.findMaxHeap(3, A)); 
		int[] B = {6, 5};
		System.out.println(ce.findMax(B, 3)); // 14
		B = new int[]{6, 5};
		System.out.println(ce.findMaxHeap(3, B)); 
		int[] C = {2, 4, 6, 8, 10};
		System.out.println(ce.findMax(C, 5)); // 33
		C = new int[]{2, 4, 6, 8, 10};
		System.out.println(ce.findMaxHeap(5, C)); 
		int[] D = { 2147483647, 2000000014, 2147483647};
		System.out.println(ce.findMax(D, 10)); // -2010339118 -- 284628164
		D = new int[]{ 2147483647, 2000000014, 2147483647};
		System.out.println(ce.findMaxHeap(10, D)); 
	}

}
class CustomComp implements Comparator < Integer > {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}