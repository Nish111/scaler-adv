package math3_prime_200123;

import java.util.ArrayList;

//https://www.scaler.com/academy/mentee-dashboard/class/50133/assignment/problems/35398?navref=cl_tt_nv
public class FindAllPrimes {

	public int[] sieveCode(int A) {
		
		boolean[] prime = new boolean[A+1];
		for(int i=1; i<=A; i++) {
			prime[i] = true;
		}
		if(A==1) return new int[1];
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
		int[] res = new int[count];
		for(int i=2, j=0; i<=A; i++) {
			if(prime[i]) {
				res[j]=i;
				j++;
			}
		}
		return res;
	}
	 public int[] sieveScalerSol(int n){
	        // sieve of eratosthenes
	        int[] prime = new int[n + 1];
	        for(int i = 2; i * i <= n; i++){
	            if(prime[i] == 0){
	                for(int j = i * i; j <= n; j += i){
	                    prime[j] = 1;
	                }
	            }
	        }
	        return prime;
	    }
	    public int[] solveScalersol(int A) {
	        ArrayList<Integer> ans = new ArrayList<Integer>();
	        int[] prime = sieveScalerSol(A);
	        for(int i = 2; i <= A; i++){
	            if(prime[i] == 0){
	                ans.add(i);
	            }
	        }
	        return ans.stream().mapToInt(i -> i).toArray();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllPrimes fap = new FindAllPrimes();
		int[] A = fap.sieveCode(4);
		int[] B = fap.sieveCode(1);
		int[] C = fap.sieveCode(6);
		int[] D = fap.sieveCode(7);
		int[] E = fap.sieveCode(12);
		for(int i=0; i<A.length; i++) System.out.print(A[i] +" ");
		System.out.println(); // 2 3
		for(int i=0; i<B.length; i++) System.out.print(B[i] +" ");
		System.out.println(); /// 0
		for(int i=0; i<C.length; i++) System.out.print(C[i] +" ");
		System.out.println(); // 2 3 5
		for(int i=0; i<D.length; i++) System.out.print(D[i] +" ");
		System.out.println(); // 2 3 5 7
		for(int i=0; i<E.length; i++) System.out.print(E[i] +" ");
		System.out.println(); // 2 3 5 7 11
		for(int i=0; i<E.length; i++) System.out.print(E[i] +" ");
		System.out.println();
	}

}
