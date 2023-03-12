package math4_combinatorics_240123;
// https://www.scaler.com/academy/mentee-dashboard/class/50134/assignment/problems/4112?navref=cl_tt_nv
public class ComputenCrP {

	public int solve(int A, int B, int C) {
	       long numerator = factorial(A,C);
	       long denominator = (factorial(B,C) * factorial(A-B,C))%C;

	       //By Applying Fermat's Little Theorem to calculate the inverse modulo
	       long result = (numerator * pow(denominator,C-2,C))%C;
	       return (int)result;
	    }

	    private long factorial(long A, long C){
	        long result=1;
	        for(long i=2;i<=A;i++){
	            result = (result * i)%C;
	        }
	        return result;
	    }

	    private long pow(long A,long B,long C){
	        long A_new = (A+C)%C;
	        if(A_new==0) return 0;
	        if(B==0) return 1;
	        long calculatedResult = pow(A_new,B/2,C);
	        if(B%2==0) return ((calculatedResult * calculatedResult)%C);
	        else return (((calculatedResult * calculatedResult)%C * A_new)%C);
	    }
	    public int solveScalerSol(int A, int B, int C) {
	        if(C == 1)
	            return 0;
	        if(A == 1)
	            return 1;
	        long mx = Math.max(A - B, B);
	        long mn = Math.min(A - B, B);
	        long denominator = 1, numerator = 1;
	        // nCr = (n * (n - 1) * ... * (n - r + 1)) * inverse(fact[r])
	        // nCr = (n * (n - 1) * ... * (r + 1)) * inverse(fact[n - r])
	        for(long n = mx + 1; n < A + 1; n++) {   
	            numerator = (numerator * n) % C;
	        }
	        for(int d = 2 ; d < mn + 1; d++) {
	            denominator = (denominator * d) % C;
	        }
	        return (int)((numerator * powScalerSol(denominator, C - 2, C)) % C);
	    }
	    
	    public long powScalerSol(long x, int y, int k) {
	        long result = 1;
	        while(y > 0) {
	            if(y % 2 == 1) {
	                result = (result * x) % k;
	                y--;
	            }
	            y >>= 1;
	            x = (x * x) % k;
	        }
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComputenCrP cc = new ComputenCrP();
		System.out.println(cc.solve(5, 2, 11)); // 10
		System.out.println(cc.solve(6, 2, 13)); // 2
		System.out.println(cc.solve(7269, 4002, 331997)); // 326229 heap space error
		
		
	}

}
