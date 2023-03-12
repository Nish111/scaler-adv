package math2_gcd_180123;

public class SubsequenceGCD1 {
	public int gcdSubsequence(int[] A) { // O(logs(Max(A[i])))
		int ans = 0; // identity for gcd
		for(int i=0; i<A.length; i++)
		{
			ans = gcd(ans, Math.abs(A[i]));
			if(ans==1) return 1;
		}
		return 0;
    }
	public int gcd(int A, int B) {
		if(B==0) return A;
		return gcd(B, A%B); // as A%B always less than B so keep it first
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsequenceGCD1 sgcd = new SubsequenceGCD1();
		int[] A = {4, 6, 3, 8};
		int[] B = {6, 9};
		System.out.println(sgcd.gcdSubsequence(A)); // 1
		System.out.println(sgcd.gcdSubsequence(B)); // 0
	}

}
