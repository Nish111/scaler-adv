package math2_gcd_180123;
// https://www.scaler.com/academy/mentee-dashboard/class/50132/assignment/problems/9103?navref=cl_tt_lst_nm
public class GCDArrayMax {
	
	public int deleteOneGCDMax(int[] A) {
		int[] pfGCD = new int[A.length];
		int[] sfGCD = new int[A.length];
		pfGCD[0] = A[0];
		sfGCD[A.length-1] = A[A.length-1];
		for(int i=1; i<A.length; i++) {
			pfGCD[i] = gcd(pfGCD[i-1], A[i]);
		}
		for(int i=A.length-2; i>0; i--) {
			sfGCD[i] = gcd(sfGCD[i+1], A[i]);
		}
		int ans = Math.max(pfGCD[A.length-2], sfGCD[1]);
		for(int i=1; i<A.length-1; i++) {
			int curr_gcd = gcd(pfGCD[i-1], sfGCD[i+1]);
			ans = Math.max(ans, curr_gcd);
		}
		return ans;
	}
	public int gcd(int A, int B) {
		if(B==0) return A;
		return gcd(B, A%B);
	}
	 public int gcdScalerSol(int a, int b) {
	        if (a == 0)
	            return b;
	        return gcdScalerSol(b % a, a);
	    }
	    public int[]suffixGCDScalerSol(int[] A){
	        int n = A.length;
	        int[] suf = new int[n];
	        int g = 0;
	        for (int i = n - 1; i >= 0; i--) {
	            g = gcd(g, A[i]);
	            suf[i] = g;
	        }
	        return suf;
	    }
	    public int solveScalerSol(int[] A) {
	        int n = A.length, ans = 1;
	        // suf stores the suffix gcd of the array
	        int[] suf = suffixGCDScalerSol(A);
	        int curGcd = 0;
	        for (int i = 0; i < n; i++) {
	            if (i != n - 1)
	                ans = Math.max(ans, gcdScalerSol(suf[i + 1], curGcd));
	            else
	                ans = Math.max(ans, curGcd);
	            curGcd = gcdScalerSol(curGcd, A[i]);
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GCDArrayMax gcd = new GCDArrayMax();
		int[] A = {4, 8, 3, 12, 16};
		int[] B = {12, 15, 18};
		int[] C = {5, 15, 30};
		System.out.println(gcd.deleteOneGCDMax(A)); // 4
		System.out.println(gcd.deleteOneGCDMax(B)); // 6
		System.out.println(gcd.deleteOneGCDMax(C)); // 15
		
	}

}
