package sorting2_300123;

import java.util.Arrays;
import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50137/assignment/problems/1224?navref=cl_tt_lst_sl
public class UniqueElements {

	public int solve(int[] A) {
		int count=0;
		for(int i=1; i<A.length; i++) {
			int j=i-1;
			while(j>=0 && A[j]>=A[j+1]) {
				if(A[j]==A[j+1]) {
					A[j+1]++;
					count++;
					continue;
				}
				int temp = A[j];
				A[j] = A[j+1];
				A[j+1] = temp;
				j--;
			}
		}
		return count;
    }
	public int solve2(int[] A) {
		int count = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			if(hm.containsKey(A[i])) hm.put(A[i], hm.get(A[i])+1);
			else hm.put(A[i], 1);
		}
		for(int i=0; i<hm.size(); i++) {
			if(hm.get(i) != 1) {
				hm.put(hm.get(i), null);
			}
		}
		return count;
	}
	public int solve3(int[] A) { // working
		int count = 0;
		Arrays.sort(A);
		for(int i=0; i<A.length-1; i++) {
			if(A[i+1] == A[i]) {
				count++;
				A[i+1]++;
			}
			if(A[i+1]<A[i]) {
				count += (A[i] - A[i+1] +1);
				A[i+1] += (A[i] - A[i+1] +1); // missed += earlier
			}
		}
		return count;
	}
	public int solveScalerSol(int[] A) {
        int n = A.length;
        // sort the array
        Arrays.sort(A);
        // initialize variables
        int steps = 0, i = 1, j = 0;
        // loop unitil you reach the end
        while (j < n) {
            // make current element unique
            if (i >= A[j]) {
                steps += (i - A[j++]);
                i += 1;
            } else {
                i = A[j] + 1;
                j += 1;
            }
        }
        // return the answer
        return steps;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueElements ue = new UniqueElements();
		int[] A = {1,1,3};
		System.out.println(ue.solve(A)); // 1
		int[] B = {2,4,5};
		System.out.println(ue.solve(B)); // 0
		int[] C = {1,1,2,3,5};
		System.out.println(ue.solve(C)); // 3
		int[] E = {2,4,3,4,5,3}; // 2 3 3 4 4 5
		System.out.println(ue.solve3(E)); // 6
		int[] D = {51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62};
		System.out.println(ue.solve3(D)); // 239

	}

}
