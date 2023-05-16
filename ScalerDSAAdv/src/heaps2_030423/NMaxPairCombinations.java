package heaps2_030423;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
// https://www.scaler.com/academy/mentee-dashboard/class/70939/homework/problems/417?navref=cl_tt_nv
public class NMaxPairCombinations {

	public int[] solve(int[] A, int[] B) { // N2 heap space issue
        int len = A.length;
		int[] res = new int[len];
		// wont work as too much space
		// Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		PriorityQueue<Integer> pqres = new PriorityQueue<>((a,b)-> b-a);
		for(int i=0; i<len;i++)
			for(int j=0; j<len; j++) {
				pqres.add(A[i]+B[j]);
			}
			
		for(int i=0; i<len; i++)
			res[i] = pqres.poll();
		
		return res;
    }
	public int[] solve1(int[] A, int[] B) { // N2 TLE just heap space optimized
		int len = A.length;
		int[] res = new int[len];
		
		PriorityQueue<Integer> pqres = new PriorityQueue<>();
		for(int i=0; i<len; i++) 
			pqres.add(A[0]+B[i]);
		for(int i=1; i<len;i++)
			for(int j=0; j<len; j++) {
				int temp = A[i]+B[j];
				int val = pqres.peek();
				//System.out.println(val);
				if(val<temp) {
					pqres.poll();
					pqres.add(temp);
					val=pqres.peek();
				}
				
			}
			
		for(int i=0; i<len; i++)
			res[len-i-1] = pqres.poll();
		
		return res;
		
    }
	public int[] solve2(int[] A, int[] B) { // should be working
		int len = A.length;
		int[] res = new int[len];
		Arrays.sort(A);
		Arrays.sort(B);
		Set<String> hs=  new HashSet<>();
		PriorityQueue<int[]> pqRes = new PriorityQueue<>((a,b)->
				Integer.compare(A[b[0]]+B[b[1]], A[a[0]]+B[a[1]]));
		pqRes.add(new int[] {len-1, len-1});
		int[] ans = new int[len];
		for(int i=0; i<len; i++) {
			int[] temp = pqRes.peek();
			ans[i] = A[temp[0]]+B[temp[1]];
			pqRes.poll();
			int[] one = new int[] {temp[0]-1, temp[1]};
			int[] two = new int[] {temp[0], temp[1]-1};
			if(hs.add(one[0] +" "+one[1]) && one[0] >= 0)
				pqRes.add(one);
			if(hs.add(two[0] +" "+two[1]) && two[1] >= 0)
				pqRes.add(two);
		}
		return ans;
    }
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++)
			System.out.print(A[i] +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NMaxPairCombinations nmp = new NMaxPairCombinations();
		int[] A = {1, 4, 2, 3};
		int[] B = {2, 5, 1, 6};
		int[] C = nmp.solve(A, B);
		nmp.printArray(C); // 10 9 9 8 
		int[] X = nmp.solve1(A, B);
		nmp.printArray(X); // 10 9 9 8
		int[] XX = nmp.solve2(A, B);
		nmp.printArray(XX); // 10 9 9 8
		int[] D = {2, 4, 1, 1};
		int[] E = {-2, -3, 2, 4};
		int[] F = nmp.solve(D, E);
		nmp.printArray(F); // 8 6 6 5 
		int[] Y = nmp.solve1(D, E);
		nmp.printArray(Y); // 8 6 6 5 
		int[] XY = nmp.solve2(D, E);
		nmp.printArray(XY); // 10 9 9 8
		int[] H = {3, 2, 4, 2};
		int[] I = {4, 3, 1, 2};
		int[] J = nmp.solve(H, I);
		nmp.printArray(J); // 8 7 7 6 
		int[] Z = nmp.solve1(H, I);
		nmp.printArray(Z); // 8 7 7 6 
		int[] XZ = nmp.solve2(H, I);
		nmp.printArray(XZ); // 10 9 9 8
	}

}
