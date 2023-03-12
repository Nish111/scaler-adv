package math3_prime_200123;
// https://www.scaler.com/academy/mentee-dashboard/class/50133/homework/problems/1095/?navref=cl_pb_nv_tb
public class LuckyNumber {

	public int solve(int A) {
		if(A==1) return 0;
		int[] arr = new int[A+1];
		int count_factors = 0;
		for(int i=2; i<=A; i++) {
			if(arr[i]==0) { // if prime
				for(int j=0; j<=A; j+=i) {
					arr[j] += 1; // incrementing value for factor of that number
				}
			}
		}
		for(int i=2; i<=A; i++) {
			if(arr[i]==2) count_factors++;
		}
		return count_factors;
    }
	public int solve2(int A) {
        //Modification of Sieve of Erastothenes Algorithm
        int[] isPrimeSieve = new int[A+1];
        for(int p=2; p<=A; p++){
            //Only Prime
            if(isPrimeSieve[p]==0){
                //This will give an array consisting of number of prime divisors for each number
                for(int i=p; i<=A; i+=p){
                    isPrimeSieve[i]+=1;
                }
            }
        }

        int count = 0;
        for(int i=2; i<=A; i++){
            if(isPrimeSieve[i]==2){
                count++;
            }
        }
        return count;
    }
	private boolean[] isprime = new boolean[50001];
    public int solveScalerSol(int A) {
    	sieveScalerSol();
        int[] cnt = new int[50001];
        for (int i = 0; i < 50001; i++)
            cnt[i] = 0;
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j * j <= i; j++) {
                // Check to increment count of distinct primes
                if (i % j == 0) {
                    if (isprime[j]) {
                        cnt[i]++;
                    }
                    if ((i / j) != j && isprime[i / j]) {
                        cnt[i]++;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= A; i++) {
            // Increment count for every lucky num
            if (cnt[i] == 2) {
                ans++;
            }
        }
        return ans;
    }

    public void sieveScalerSol() {
        //Sieve of Eratosthenes
        for (int i = 0; i < 50001; i++)
            isprime[i] = true;
        isprime[1] = false;
        for (long i = 2; i <= 50000; i++) {
            if (isprime[(int) i]) {
                for (long j = i * i; j <= 50000; j += i) {
                    isprime[(int) j] = false;
                }
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LuckyNumber ln = new LuckyNumber();
		System.out.println(ln.solve(8)); // 1
		System.out.println(ln.solve(12)); // 3
		System.out.println(ln.solve(5)); // 0
		System.out.println(ln.solve(25)); // 10 
		System.out.println(ln.solve(1)); // 0
	}

}
