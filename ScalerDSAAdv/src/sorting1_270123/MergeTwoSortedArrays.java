package sorting1_270123;

import java.util.ArrayList;
import java.util.List;

// https://www.scaler.com/academy/mentee-dashboard/class/50136/assignment/problems/164/submissions
public class MergeTwoSortedArrays {

	public int[] solve(final int[] A, final int[] B) {
		int[] C = new int[A.length+B.length];
		int p1=0, p2=0, p3=0;
		while(p1<A.length && p2<B.length) {
			if(A[p1]<B[p2]) {
				C[p3] = A[p1];
				p1++; p3++;
			}
			else {
				C[p3] = B[p2];
				p2++; p3++;
			}
		}
		while(p1<A.length) {
			C[p3] = A[p1];
			p1++; p3++;
		}
		while(p2<B.length) {
			C[p3] = B[p2];
			p2++; p3++;
		}
		return C;
    }
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList < Integer > solveScalerSol(final List < Integer > A, final List < Integer > B) {
        int m = A.size(), n = B.size();
        ArrayList < Integer > res = new ArrayList < Integer > ();
        if (A == null && B == null)
            return null;
        if (A == null) {
            for (int i = 0; i < n; i++)
                res.add(B.get(i));
            return res;
        }
        if (B == null) {
            for (int i = 0; i < m; i++)
                res.add(A.get(i));
            return res;
        }
        int i, j;
        int k = 0;
        // i and j points to the elements of A and B respectively
        for (i = 0, j = 0; k < m + n; k++) {
            if (i >= m)
                res.add(B.get(j++));
            else if (j >= n)
                res.add(A.get(i++));
            else if (A.get(i) <= B.get(j))
                res.add(A.get(i++));
            else
                res.add(B.get(j++));
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoSortedArrays mtsa = new MergeTwoSortedArrays();
		int[] A = {-1, 2, 6};
		int[] B = {3,4,5};
		int[] C = mtsa.solve(A, B);
		for(int i=0; i<C.length; i++) System.out.print(C[i]+" ");
		System.out.println();
	}

}
