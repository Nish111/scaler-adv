package math1_modarith_160123;

// https://www.scaler.com/academy/mentee-dashboard/class/50131/assignment/problems/9314?navref=cl_tt_nv
public class PrimeModuloInverse {

	public int solve(int A, int B) { // O(N)
		for(int i=1; i<B; i++) {
			if(((long)A*i)%B == 1) return i; // casting to long works for 3rd
		}
		return 0;
    }
	public int solve2(int A, int B) {
		if(A==0) return 0;
		//return fastPow(A, B-2, B);
		return fastPow(A, B-2, B);
    }
	public  int fastPow(int A, int pow, int B) {
		if(pow==0) return 1;
		long pow2 = fastPow(A, pow/2, B);
		long temp = pow2 % B ;
		temp = (temp * temp) % B;
		if(pow % 2 ==0) return (int) ((temp + B)%B);
		else return (int) ((temp * A % B) + B) % B;
	}
	public int pow(int A, int B, int C) {
		if (B == 0)
			return 1;
		long halfPower = pow(A, B / 2, C);
		long interimResult = halfPower % C * halfPower % C;
		// finding modulo of a%b is same as (a%b + b) % b
		// Approach 1: 2%4 ==> 2; Approach 2 (2%4 + 4)%4 ==> 6%4 ==> 2
		// above case handles both a%b and -a%b
		// -2%4 ==> (a-b)%m ==> (a%m -b%m+m)%m; 
		return ((B % 2 == 0) ? (int)((interimResult) + C) % C : (int)((interimResult * A % C) + C) % C);

	}
	long powerScalerSol(long x, long y, long p) { 
        long res = 1;        // Initialize result 
        x = x % p;        // Update x if it is more than or equal to p 
        while (y > 0) { 
            // If y is odd, multiply x with result 
            if ((y & 1) == (long)1) 
                res = (res*x) % p; 
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res; 
    }
    
    public int solveScalerSol(int A, int B) {
        // Modular inverse of A Modulo B = pow(A, B - 2, B)
        return (int)powerScalerSol(A, B - 2, B);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeModuloInverse pmi = new PrimeModuloInverse();
		System.out.println(pmi.solve(3, 5)); // 2
		System.out.println(pmi.solve(6, 23)); // 4
		System.out.println(pmi.solve(4707241, 999996259)); // 760976249
		System.out.println(pmi.solve2(3, 5)); // 2
		System.out.println(pmi.solve2(6, 23)); // 4
		System.out.println(pmi.solve2(4707241, 999996259)); // 760976249
	}
}
