package searching3_080223;
// https://www.scaler.com/academy/mentee-dashboard/class/50141/assignment/problems/5697/submissions
public class AthMagicalNumber {

	public int solve(int A, int B, int C) {
		int mod = 1000000007;
		long a = A, b= B, c = C; 
		long low =1, high = (Math.min(b, c)*a);
		//System.out.println(high);
		long ans=0;
		while(low<=high) {
			long mid = low + (high-low)/2;
			if(countMagicalNumbers(mid, b, c)>=A) {
				high = mid-1;
				ans = mid;
			} else low = mid+1;
		}
		return (int) (ans%mod);
    }
	public long countMagicalNumbers(long mid, long b, long c) {
		return (int) (mid/b + mid/c - mid/lcm(b, c));
	}
	public static long lcm(long a, long b) {
        long gcd = gcd(a, b);
        return (a * b) / gcd;
    }
    
    public static long gcd(long a, long b) {
        if (b == 0)  return a;
        else return gcd(b, a % b);
    }

	public int solveBrute(int A, int B, int C) { // O(min(B,C)*A)
		int mod = 1000000007;
		long count=0;
		for(long i=1; i<Long.MAX_VALUE; i++) {
			if(i%B==0 || i%C==0) count++;
			if(count==A) return (int) (i%mod);
		}
		return 0;
    }
	public int gcdScalerSol(int x, int y) {
        if (x == 0)
            return y;
        return gcdScalerSol(y % x, x);
    }

    public int solveScalerSol(int A, int B, int C) {
        // lcm of B and C
        long lcm = (long) B * C / gcdScalerSol(B, C);
        long low = 2, high = ((long)A * Math.min(B, C)) , ans = 0;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            // f(x) = x / B + x / C - x / lcm(B, C)
            long cntB = mid / B, cntC = mid / C, cntBC = mid / lcm;
            if (cntB + cntC - cntBC >= A) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return (int)(ans % (1000 * 1000 * 1000 + 7));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AthMagicalNumber amn = new AthMagicalNumber();
		System.out.println(amn.solve(1, 2, 3)); // 2
		System.out.println(amn.solve(4, 2, 3)); // 6
		System.out.println(amn.solve(7, 2, 3)); // 10
		System.out.println(amn.solveBrute(1, 2, 3)); // 2
		System.out.println(amn.solveBrute(4, 2, 3)); // 6
		System.out.println(amn.solveBrute(7, 2, 3)); // 10
		System.out.println(amn.solve(807414236, 3788, 38141)); // 238134151
		// too much timel
		//System.out.println(amn.solveBrute(807414236, 3788, 38141)); // 0 -- need 238134151
		
	}

}
