package math2_gcd_180123;

public class GCDFactorial {

	public int gcdFactorial(int[] A) {
		int min = Integer.MAX_VALUE, ans=1;
		for(int i=0; i<A.length; i++) {
			min = Math.min(min, A[i]);
		}
		for(int i=min; i>0; i--) {
			ans *= i;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GCDFactorial gcd = new GCDFactorial();
		int[] A = {4,3,8,6};
		System.out.println(gcd.gcdFactorial(A));
	}

}
