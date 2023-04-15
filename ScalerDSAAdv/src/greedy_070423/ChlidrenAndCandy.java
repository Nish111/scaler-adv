package greedy_070423;

import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/70940/assignment/problems/3?navref=cl_tt_lst_nm
public class ChlidrenAndCandy {

	public int findMinCandyGiven(int[] A) {
		int res = 0;
		int[] B = new int[A.length];
		for(int i=0; i<A.length; i++) {
			B[i]=1;
		}
		//printArray(B);
		// approach 2
		// need this condition to check B and modify only if Bi is less
		for(int i=1; i<A.length; i++) {
			if(A[i]>A[i-1]) {
				if(!(B[i]>B[i-1])) B[i] = B[i-1]+1;
			}
		}
		//printArray(B);
		for(int i=A.length-2; i>=0; i--) {
			if(A[i]>A[i+1]) {
				if(!(B[i]>B[i+1])) B[i] = B[i+1]+1;
			}
		}
		//printArray(B);
		for(int i=0; i<A.length; i++) {
			res+=B[i];
		}
		return res;
	}
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++)
			System.out.print(A[i] +" ");
		System.out.println();
	}
	public int candyScalerSol(int[] A) {
        int n = A.length;
        int[] candies = new int[n + 1];
        Arrays.fill(candies, 1);
        for (int i = 2; i <= n; i++) {
            if (A[i - 1] > A[i - 2])
                candies[i] = candies[i - 1] + 1;
        }
        for (int i = n - 1; i >= 1; i--) {
            if (A[i - 1] > A[i]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int s = 0;
        for (int i = 1; i <= n; i++) s += candies[i];
        return s;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChlidrenAndCandy cac = new ChlidrenAndCandy();
		int[] A = {1,5,3,2};
		System.out.println(cac.findMinCandyGiven(A)); // 7
		int[] B = {2,2,2};
		System.out.println(cac.findMinCandyGiven(B)); // 3
		int[] C = {3, 10, 8};
		System.out.println(cac.findMinCandyGiven(C)); // 4
		int[] D = {10, 3, 8};
		System.out.println(cac.findMinCandyGiven(D)); // 5
		int[] E = {1,6,3,1,10,12,20,5,2};
		System.out.println(cac.findMinCandyGiven(E)); // 19
		int[] F = {1,2,3,4,5,6};
		System.out.println(cac.findMinCandyGiven(F)); // 21
		int[] G = {4,3,6,2};
		System.out.println(cac.findMinCandyGiven(G)); // 6
		int[] H = {6,5,4,3,2,1};
		System.out.println(cac.findMinCandyGiven(H)); // 21
	}

}
