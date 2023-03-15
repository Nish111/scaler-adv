package math3_prime_200123;

import java.util.Arrays;
import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50133/homework/problems/2206/?navref=cl_pb_nv_tb
public class FactorialArray {

	public int solveBrute(int[] A) { // this will not work as factorial will overflow
		int[] B = new int[A.length];
		for(int i=0; i<A.length; i++) {
			B[i] = fact(A[i]);
		}
		printArray(B);
		return 0;
    }
	public int fact(int i) {
		// TODO Auto-generated method stub
		if(i==0) return 1;
		else return i*fact(i-1);
	}
	public int solve(int[] A) { // this will not work as factorial will overflow
		Arrays.sort(A);
		//printArray(A);
		Arrays.sort(A);
		int max = A[A.length-1],ans=0; //get max from A
		System.out.println(max);
	    int[] primes = sieveCode(max);        // filling spf array with largest prime numbers till there
	    printArray(primes);
	    HashMap<Integer,Integer> hm = new HashMap<>();
	        for(int i:A){
	            if(i==1) continue;
	            hm.put(primes[i],hm.getOrDefault(primes[i],0)+1);
	            //ans += Math.pow(2, hm.get(primes[i])-1); //1<<hm.get(primes[i])-1; // for every new occurrence, 2^count -1 subseq’s are possible
	            int temp = hm.get(primes[i]);
	            ans += (int)1<<(temp-1);
	           // System.out.println(ans +" "+hm.get(primes[i]));
	        }
	        return ans;
    }
	public int[] sieveCode(int A) {
		boolean[] prime = new boolean[A+1];
		for(int i=1; i<=A; i++) {
			prime[i] = true;
		}
		if(A==0) return new int[]{0};
		if(A==1) return new int[]{0};
		int count=0;
		prime[0] = prime[1] = false;// marking for prime
		for(int i=2; i<=Math.sqrt(A); i++) { // O(n^(1/2) +log(log(N))
			if(prime[i]) {
				for(int j=i*i; j<=A; j+=i) // log(log(N)
					prime[j] = false;
			}
		}
		int temp=1;
		int[] arr = new int[A+1];
		//printArray(arr);
		for(int i=2;i<=A;i++){
            if(prime[i]){
                temp =i; 
            }
            arr[i]=temp;
        }
		arr[0] = arr[1] = 1;
		return arr;
	}
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++)
			System.out.print(A[i]+ " ");
		System.out.println();
	}
	private int[] prime = new int[1000001];
    private int mod = 1000 * 1000 * 1000 + 7;

    public void preScalerSol(){
        // sieve of eratosthenes
        int maxN = 1000001;
        prime[1] = 1;
        for(int i = 2; i < maxN; i++){
            if(prime[i] == 0){
                for(int j = 2 * i; j < maxN; j += i) {
                    prime[j] = 1;
                }
            }
        }
    }
    
    public int powerScalerSol(long x, long y){
        // modular exponentiation
        long res = 1;
        while(y != 0){
            if(y % 2 == 1){
                res = (x * res) % mod;
            }
            y /= 2;
            x = (x * x) % mod;
        }
        return (int)res;
    }    
    
    public int solveScalerSol(int[] A) {
        preScalerSol();
        int n = A.length;
        Arrays.sort(A);
        int v[] = new int[100000], itr = 0;
        // stores all the prime numbers
        for(int i = 2; i <= A[n - 1]; i++) {
            if(prime[i] == 0){
                v[itr] = i;
                itr++;
            }
        }
        
        long ans = 0;
        int j = 0, i = 0;
        while(i < n && j < itr) {
            // find the count of elements with same set of non-empty prime factors
            int cnt = 0;
            if(A[i] == 1){
                i++;
                continue;
            }
            while(i < n && A[i] < v[j]) {
                i++;
                cnt++;
            }
            long temp = powerScalerSol(2, cnt) - 1;
            ans = (ans + temp) % mod;
            j++;
        }
        if(i < n){
            long temp = powerScalerSol(2, n - i) -1;
            ans = (ans + temp) % mod;
        }
        return (int)ans;
    }
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		FactorialArray fa = new FactorialArray();
		int[] A = {2,3,2,3};
		System.out.println(fa.solve(A));// 6 -  2 2 6 6 2,2 6,6
		int[] B = {2,3,4}; 
		System.out.println(fa.solve(B)); // 4 - 2 6 24 6,24
		int[] C = {5,10,7,3,4};
		System.out.println(fa.solve(C)); // 7
		int[] D = {2, 3, 4, 5, 6 };
		System.out.println(fa.solve(D)); //9
	}

}
