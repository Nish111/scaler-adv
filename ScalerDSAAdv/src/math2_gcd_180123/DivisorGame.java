package math2_gcd_180123;
// https://www.scaler.com/academy/mentee-dashboard/class/50132/homework/problems/2126/hints?navref=cl_pb_nv_tb
public class DivisorGame {

	public int solve(int A, int B, int C) {
		int res=0;
		int lcm = B*C/gcd(B, C);
		for(int i=lcm; i<=A; i+=lcm) {
			res++;
		}
		return res;
    }
	public int gcd(int A, int B) {
		if(B==0) return A;
		return gcd(B, A%B); // as A%B always less than B so keep it first
	}
	public int gcdScalersol(int x, int y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
    }
    public int solveScalerSol(int A, int B, int C) {
        // find lcm of B and C
        long lcm = (long) B * C / gcdScalersol(B, C);
        if (lcm > A)
            return 0;
        // no of multiples of lcm that is <= A
        return (int)(A / lcm);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivisorGame dg = new DivisorGame();
		System.out.println(dg.solve(12, 3, 2)); // 2
		System.out.println(dg.solve(6, 1, 4)); // 1
		System.out.println(dg.solve(34, 24, 20)); // 0
		System.out.println(dg.solve(904579076, 1445, 462));// 1354
	}

}
