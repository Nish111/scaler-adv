package hashing2_150223;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
// https://www.scaler.com/academy/mentee-dashboard/class/50144/assignment/problems/4759/?navref=cl_pb_nv_tb
class Pair {
	int x; int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class UniqueRectangle {

	public int countRectangles(int[] A, int[] B) {
		
		TreeSet<Pair> ts = new TreeSet<>();
		for(int i=0; i<A.length; i++) {
			ts.add(Pair(A[i], B[i]));
		}
		return 0;
	}
	public Pair Pair(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	public int solve(int[] A, int[] B) {
        int n = A.length;
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < n;i++){
            hs.add(A[i] + "," + B[i]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
               // if(A[i] < A[j] && B[i] < B[j] &&
                if(A[i] != A[j] && B[i] != B[j] &&
                hs.contains(A[i] + "," + B[j]) &&
                hs.contains(A[j] + "," + B[i]))
                    ans++;
            }
        }

       // return ans;
        return ans/4;
    }
	public int solveScalerSol(int[] a, int[] b) {
        int n = a.length;
        HashMap<Integer, HashSet<Integer>> mpx = new HashMap<>();
        HashSet<Integer> h;
        // stores all the points
        for (int i = 0; i < n; i++) {
            if (mpx.containsKey(a[i]))
                h = mpx.get(a[i]);
            else
                h = new HashSet<>();
            h.add(b[i]);
            mpx.put(a[i], h);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // checks if there exists a rectange such that the i-th and 
                // j-th points are the ends of a diagonal
                if (a[i] == a[j] || b[i] == b[j])
                    continue;
                if (mpx.get(a[i]).contains(b[j]) && mpx.get(a[j]).contains(b[i]))
                    ans++;
            }
        }
        return ans >> 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueRectangle ur = new UniqueRectangle();
		int[] A = {1, 1, 2, 2};
		int[] B = {1, 2, 1, 2};
		System.out.println(ur.solve(A, B));// 1
		int[] C = {1, 1, 2, 2, 3, 3};
		int[] D = {1, 2, 1, 2, 1, 2};
		System.out.println(ur.solve(C, D));// 3
		int[] E = {3, 3, 8, 8};
		int[] F = {9, 5, 9, 5};
		System.out.println(ur.solve(E, F));// 1
		
	}

}
