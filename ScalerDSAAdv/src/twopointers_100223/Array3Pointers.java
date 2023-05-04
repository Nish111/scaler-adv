package twopointers_100223;
// https://www.scaler.com/academy/mentee-dashboard/class/50142/homework/problems/168/?navref=cl_pb_nv_tb
public class Array3Pointers {
	   // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int ans = Integer.MAX_VALUE;
        int nA = A.length, nB = B.length, nC = C.length;
        int iA = 0, iB = 0, iC = 0;

        while(iA < nA && iB < nB && iC < nC) {
            int valA = A[iA], valB = B[iB], valC = C[iC];
            int curr = Math.max(Math.abs(valA - valB), 
            		Math.max(Math.abs(valB - valC), Math.abs(valC - valA)));
            ans = Math.min(ans, curr);

            if(valA <= valB && valA <= valC) {
                iA++;
            } else if(valB <= valA && valB <= valC) {
                iB++;
            } else {
                iC++;
            }
        }

        return ans;
    }
 // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimizeScalerSol(final int[] A, final int[] B, final int[] C) {
        int diff = Integer.MAX_VALUE;
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int i, j, k;
        for(i = 0, j = 0, k = 0; i < A.length && j < B.length && k < C.length;) {
            //  max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) = max(A[i], B[j], C[k]) - min(A[i], B[j], C[k])
            minimum = Math.min(A[i], Math.min(B[j], C[k]));
            maximum = Math.max(A[i], Math.max(B[j], C[k]));
            diff = Math.min(diff, maximum - minimum);
            if (diff == 0) break;
            if (A[i] == minimum) i++;
            else if (B[j] == minimum) j++;
            else k++;
        }
        return diff;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array3Pointers ap = new Array3Pointers();
		int[] A = {1, 4, 10};
		int[] B = {2, 15, 20};
		int[] C = {10, 12};
		System.out.println(ap.minimize(A, B, C)); // 5
		int[] D = {3, 5, 6};
		int[] E = {2};
		int[] F = {3, 4};
		System.out.println(ap.minimize(D, E, F)); // 1
	}

}
