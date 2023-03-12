package math2_gcd_180123;
//https://www.scaler.com/academy/mentee-dashboard/class/50132/homework/problems/358/submissions

public class LargestCoPrimeDivisor {

	public int cpFact(int A, int B) {
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=Math.sqrt(A); i++) {
			if(A%i==0) {
				int temp = gcd(i, B);
				if(temp==1) {
					max = Math.max(max, i);
				}
				temp = gcd(A/i, B);
				if(temp==1) {
					max = Math.max(max, A/i);
				}
			}
		}
		return max;
    }
	public int gcd(int A, int B) {
		if(B==0) return A;
		return gcd(B, A%B); // as A%B always less than B so keep it first
	}
	
	public int gcdScalerSol(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public int cpFactScalersol(int A, int B) {
        while (gcdScalerSol(A, B) != 1){
            // dividing A by gcd(A, B)
            A = A / gcdScalerSol(A, B);
        }
        return A;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestCoPrimeDivisor lcpd = new LargestCoPrimeDivisor();
		System.out.println(lcpd.cpFact(30, 12)); // 5
		System.out.println(lcpd.cpFact(5, 10)); // 1
		System.out.println(lcpd.cpFact(2, 3)); // 2 - need 2
		System.out.println(lcpd.cpFact(90, 47)); 
		System.out.println(lcpd.cpFact(921127411, 8745993)); // 921127411
		
	}

}
