package math3_prime_200123;
// https://www.scaler.com/academy/mentee-dashboard/class/50133/homework/problems/297/hints?navref=cl_pb_nv_tb
public class PrimeSum {
	public int[] primesum(int A) {
		boolean[] prime = new boolean[A+1];
		for(int i=1; i<=A; i++) {
			prime[i] = true;
		}
		if(A==1) return new int[1];
		int count=0;
		prime[0] = prime[1] = false;// marking for prime
		for(int i=2; i<=Math.sqrt(A); i++) { // O(n^(1/2) +Nlog(log(N))
			if(prime[i]) {
				for(int j=i*i; j<=A; j+=i) // Nlog(log(N)
					prime[j] = false;
			}
		}
		for(int i=0; i<prime.length; i++) System.out.print(prime[i] +" ");
		System.out.println(); // 2 2
		int[] res = new int[2];
		for(int i=2; i<A; i++) {
			if(prime[i]) {
				if(prime[A-i]) {
					res[0] = i;
					res[1] = A-i;
					break;
				}
			}
		}
		return res;
    }
	public int[] sieveScalerSol(int N){
        // Generate isPrime List less equal than N
        int[] isPrime = new int[N + 1];
        isPrime[0] = 0;
        isPrime[1] = 0;
        for(int i = 2; i <= N; i++){
            isPrime[i] = 1;
        }
        // Sieve of Erastothenes
        for(int i = 2; i <= N; i++) {
            if (isPrime[i] == 0)
                continue;
            if (i > N / i) 
                break;
            for (int j = i * i; j <= N; j += i) 
                isPrime[j] = 0;
        }
        return isPrime;
    }
    public int[] primesumScalerSol(int A) {
        int[] isPrime = sieveScalerSol(A);
        int[] ans = new int[2];
        for(int i = 2; i <= A; ++i) {
            if(isPrime[i] == 1 && isPrime[A - i] == 1) {
                ans[0] = i;
                ans[1] = A - i;
                return ans;
            }
        } 
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeSum ps = new PrimeSum();
		int[] A = ps.primesum(4);
		int[] B = ps.primesum(6);
		int[] C = ps.primesum(12);
		int[] D = ps.primesum(20);
		int[] E = ps.primesum(36);
		int[] F = ps.primesum(98);
		for(int i=0; i<A.length; i++) System.out.print(A[i] +" ");
		System.out.println(); // 2 2
		for(int i=0; i<B.length; i++) System.out.print(B[i] +" ");
		System.out.println(); /// 3 3 
		for(int i=0; i<C.length; i++) System.out.print(C[i] +" ");
		System.out.println(); // 5 7
		for(int i=0; i<D.length; i++) System.out.print(D[i] +" ");
		System.out.println(); // 3 17
		for(int i=0; i<E.length; i++) System.out.print(E[i] +" ");
		System.out.println(); // 5 31
		for(int i=0; i<F.length; i++) System.out.print(F[i] +" ");
		System.out.println(); // 0 0
	}

}
