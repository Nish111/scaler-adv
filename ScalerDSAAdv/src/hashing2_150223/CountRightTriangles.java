package hashing2_150223;

import java.util.HashMap;

public class CountRightTriangles {
// https://www.scaler.com/academy/mentee-dashboard/class/50144/assignment/problems/4719?navref=cl_tt_nv
	public int solve(int[] A, int[] B) {
		HashMap<Integer, Integer> hmx = new HashMap<>();
		HashMap<Integer, Integer> hmy = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			if(!hmx.containsKey(A[i])) hmx.put(A[i], 1);
			else hmx.put(A[i], hmx.get(A[i])+1);
		}
		for(int i=0; i<B.length; i++) {
			if(!hmy.containsKey(B[i])) hmy.put(B[i], 1);
			else hmy.put(B[i], hmy.get(B[i])+1);
		}
		int ans=0;
		for(int i=0; i<A.length; i++) {
			int x1 = A[i];
			int y1 = B[i];
			int countx = hmx.get(x1);
			int county = hmy.get(y1);
			ans += (countx-1)*(county-1);
		}
		return ans;
	}
	public int solveScalerSol(int[] a, int[] b) {
        int n = a.length;
        // stores the frequency of each x coordinate
        HashMap < Integer, Integer > mpx = new HashMap < Integer, Integer > ();
        // stores the frequency of each y coordinate
        HashMap < Integer, Integer > mpy = new HashMap < Integer, Integer > ();
        for (int i = 0; i < n; i++) {
            if (mpx.get(a[i]) == null) {
                mpx.put(a[i], 1);
            } else
                mpx.put(a[i], mpx.get(a[i]) + 1);

            if (mpy.get(b[i]) == null) {
                mpy.put(b[i], 1);
            } else
                mpy.put(b[i], mpy.get(b[i]) + 1);
        }
        long ans = 0, mod = 1000 * 1000 * 1000 + 7;
        for (int i = 0; i < n; i++) {
            // counts the no of triangles that forms a right angle at the i-th point
            ans = (ans + (mpx.get(a[i]) - 1) * (mpy.get(b[i]) - 1)) % mod;
        }
        return (int) ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountRightTriangles crt = new CountRightTriangles();
		int[] A = {1, 1, 2};
		int[] B = {1, 2, 1};
		int[] C = {1, 1, 2, 3, 3};
		int[] D = {1, 2, 1, 2, 1};
		System.out.println(crt.solve(A, B)); // 1
		System.out.println(crt.solve(C, D)); // 6
		int[] E = {1,1,3,5,5};
		int[] F = {1,4,4,4,1};
		System.out.println(crt.solve(E, F)); // 6
	}

}
