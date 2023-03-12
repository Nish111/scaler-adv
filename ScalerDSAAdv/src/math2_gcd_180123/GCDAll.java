package math2_gcd_180123;
// https://www.scaler.com/academy/mentee-dashboard/class/50132/assignment/problems/9104/submissions
public class GCDAll {

	public int gcdArray(int[] A) { // O(logs(Max(A[i]))) // Pubg
		int ans = 0; // identity for gcd
		for(int i=0; i<A.length; i++)
		{
			ans = gcd(ans, Math.abs(A[i]));
		}
		return ans;
    }
	public int gcd(int A, int B) {
		if(B==0) return A;
		return gcd(B, A%B); // as A%B always less than B so keep it first
	}
	public int gcdScalerSol(int x, int y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
    }
    public int solveScalerSol(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++)
            ans = gcdScalerSol(ans, A[i]);
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GCDAll gcd = new GCDAll();
		int[] A = { 2,4,6};
		int[] B = {13, 69, 10, 14};
		System.out.println(gcd.gcdArray(A)); // 2
		System.out.println(gcd.gcdArray(B)); // 1
	}

}
