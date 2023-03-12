package math2_gcd_180123;
// https://www.scaler.com/academy/mentee-dashboard/class/50132/assignment/problems/269/submissions
public class GCD {

	public int gcd(int A, int B) { // O(Min(A,B))
		if(A==1 || B==1) return 1;
		if(A==0) return B;
		if(B==0) return A;
		int gcd = Math.min(A, B);
		for(int i=gcd; i>=1; i--) {
			if(A%i==0 && B%i == 0) return i;
		}
		return 0;
    }
	public int gcd2(int A, int B) {
		if(B==0) return A;
		return gcd2(B, A%B); // as A%B always less than B so keep it first
    }
	public int gcd3(int A, int B) {
		if(A==1 || B==1) return 1;
		if(A==0) return B;
		if(B==0) return A;
		int min = Math.min(A, B);
		int temp = 0, gcd=0;
		for(int i=1; i<=Math.sqrt(min); i++) {
			if(min%i==0) {
				temp = i;
				if(A%i==0 && B%i==0) gcd=temp;
			}
		}
		return gcd;
    }
	 public int gcdScalerSol(int A, int B) {
	        if (A == 0)
	            return B;
	        return gcd(B % A, A);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GCD gcd = new GCD();
		System.out.println(gcd.gcd(4, 6)); // 2
		System.out.println(gcd.gcd(6, 7)); // 1
		System.out.println(gcd.gcd(0, 1)); // 1
		System.out.println(gcd.gcd(2, 0)); // 2
		System.out.println(gcd.gcd2(4, 6)); // 2
		System.out.println(gcd.gcd2(6, 7)); // 1
		System.out.println(gcd.gcd2(0, 1)); // 1
		System.out.println(gcd.gcd2(2, 0)); // 2
		System.out.println(gcd.gcd3(4, 6)); // 2
		System.out.println(gcd.gcd3(6, 7)); // 1
		System.out.println(gcd.gcd3(0, 1)); // 1
		System.out.println(gcd.gcd2(2, 0)); // 2
	}

}
