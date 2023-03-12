package math3_prime_200123;

public class SmallestPrimeFactors {

	public int[] smallestPF(int A) {
		
		int[] spf = new int[A+1];
		for(int i=2; i<=A; i++) {
			spf[i] = i;
		}
		for(int i=2; i<=A; i++) {
			if(spf[i]==i) {
				for(int j=i*i; j<=A; j+=i) {
					if(spf[j]==j) spf[j]=i;
				}
			}
		}
		return spf;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestPrimeFactors spf =  new SmallestPrimeFactors();
		int[] A = spf.smallestPF(5);
		int[] B = spf.smallestPF(8);
		int[] C = spf.smallestPF(24);
		int[] D = spf.smallestPF(9);
		int[] E = spf.smallestPF(32);
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
		
	}

}
