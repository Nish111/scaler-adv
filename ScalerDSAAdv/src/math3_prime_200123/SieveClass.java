package math3_prime_200123;

public class SieveClass {

	public int sieveCode(int A) {
		
		boolean[] prime = new boolean[A+1];
		for(int i=1; i<=A; i++) {
			prime[i] = true;
		}
		if(A==0) return 0;
		if(A==1) return 0;
		int count=0;
		prime[0] = prime[1] = false;// marking for prime
		for(int i=2; i<=Math.sqrt(A); i++) { // O(n^(1/2) +log(log(N))
			if(prime[i]) {
				for(int j=i*i; j<=A; j+=i) // log(log(N)
					prime[j] = false;
			}
		}
		for(int i=2; i<=A; i++) {
			if(prime[i]) count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SieveClass sc = new SieveClass();
		System.out.println(sc.sieveCode(4)); // 2
		System.out.println(sc.sieveCode(1)); // 0
		System.out.println(sc.sieveCode(6)); // 3
		System.out.println(sc.sieveCode(5)); // 3
		System.out.println(sc.sieveCode(7)); // 4
		System.out.println(sc.sieveCode(12)); // 5
	}

}
