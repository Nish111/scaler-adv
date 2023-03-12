package bitmanipu1_110123;
// https://www.scaler.com/academy/mentee-dashboard/class/50129/homework/problems/194/submissions
public class DivideIntegers {

	public int divide(int A, int B) {
		int sign=1;
		if((A<0 & B>0) ||(A>0 & B<0)) sign = -1;
		if(B==1) return A;
		if(A == Integer.MIN_VALUE) A = Integer.MAX_VALUE;
		int count=0;
		long x = Math.abs(A);
		long y = Math.abs(B);
		while(x>=y)
		{
			x = x-y;
			count++;
		}
		return (int)count * sign;
    }
	public int divide2(int A, int B) {
		//method
		// A/B => 125/5 ==> 
		// 125 = 5*25 ==> 5 * ( 2^4 * (1) + 2^3 * (1) + 2^2* (0) + 2^1 * (0)+ 2^0 * (1) );
		boolean sign = (A<0) ^ (B<0);
		long answer = 0L;
		long tempA = Math.abs(A * 1L);
		long tempB = Math.abs(B * 1L);

		for (int i = 31; i >= 0; i--) {
			long power = (long) tempB<< i;
			while (power<= tempA) {
				tempA -= power;
				answer += (1L<< i);
			}
		}
		if (answer >= Integer.MAX_VALUE)
			return (sign ? -Integer.MIN_VALUE : Integer.MAX_VALUE);
		if (sign)
			return (int) answer * -1;
		return (int) answer;
	}
	public int divide3(int A, int B) {
        int sign = (A < 0)^(B < 0)?-1:1;          
        if(B == 1){                     //Edge Case
            return A;
        }
        if(A == Integer.MIN_VALUE){     //Edge Case
            A = Integer.MAX_VALUE;
        }
        long x = Math.abs(A);
        long y = Math.abs(B);
        int quotient = 0;
        while(x >= y){
            x = x - y;
            quotient++;
        }
        return (int)quotient * sign;
    }
	public int divideScalerSol(int A, int B) {
        long n = A, m = B;
        // determine sign of the quotient
        int sign = 1;
        if ((n < 0 && m >= 0) || (n >= 0 && m < 0))
            sign = -1;
        // remove sign of operands
        n = Math.abs(n);
        m = Math.abs(m);
        // q stores the quotient in computation
        long q = 0, t = 0;
        // test down from the highest bit
        // accumulate the tentative value for valid bits
        for (int i = 31; i >= 0; i--) {
            if (t + (m << i) <= n) {
                t += m << i;
                q |= (long) 1 << i;
            }
        }
        // assign back the sign
        if (sign < 0)
            q = -q;
        // check for overflow and return
        if (q > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) q;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideIntegers di = new DivideIntegers();
		System.out.println(di.divide(5, 2)); // 2
		System.out.println(di.divide(7, 1)); // 7
		System.out.println(di.divide(-2147483648, -1)); // 2147483647
		
	}

}
