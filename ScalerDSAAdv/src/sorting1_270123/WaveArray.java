package sorting1_270123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// https://www.scaler.com/academy/mentee-dashboard/class/50136/homework/problems/267?navref=cl_tt_nv
public class WaveArray {
	public int[] wave(int[] A) {
		Arrays.sort(A);
		int end = 0;
		if(A.length%2 == 0) end = A.length;
		else end = A.length-1;
		for(int i=0; i<end; i=i+2) {
			int temp = A[i];
			A[i] = A[i+1];
			A[i+1] = temp;
		}
		return A;
	}
	public ArrayList < Integer > waveScalerSol(ArrayList < Integer > A) {
        // sort the array
        Collections.sort(A);
        int n = A.size();
        // swap adjacent elements in pairs
        for (int i = 2; i <= n; i += 2) {
            exchScalerSol(A, i - 2, i - 1);
        }
        return A;
    }
    private void exchScalerSol(ArrayList < Integer > A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaveArray wa = new WaveArray();
		int[] A = {1, 2, 3, 4};
		int[] B = wa.wave(A); 
		wa.printArray(B); // 2 1 4 3
		int[] C = {1, 2};
		int[] D = wa.wave(C);
		wa.printArray(D); // 2 1
		int[] E = {1, 2, 3};
		int[] F = wa.wave(E);
		wa.printArray(F); // 2 1 3
		int[] G = {1, 2, 3, 4};
		int[] H = wa.wave(G);
		wa.printArray(H);
	}

}
