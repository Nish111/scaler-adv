package math1_modarith_160123;
// https://www.scaler.com/academy/mentee-dashboard/class/50131/assignment/problems/1072/hints?navref=cl_pb_nv_tb
public class VeryLargePower {

	public int solve(int A, int B) {
		long mod = 1000000007;
		long fact = 1;
		for(long i=2; i<=B; i++) {
			fact = (fact * i)%(mod-1);
		}
		int ans = powmod(A, fact, mod);
		return ans;
    }
	public int powmod(long A,long B,long mod){//power funtion a^b%m
        if(B==0)return 1;
        long temp= powmod(A,B/2,mod);
        if(B%2==0) return (int)((temp*temp)%mod);
        return (int)((((temp*temp)%mod)*A)%mod);
    }
	int fast_powerScalerSol(long A, long B, long mod) {
        long ans = 1;
        while(B > 0) {
            if((B & 1) == 1) {
                ans = (ans * A) % mod;
            }
            A = (A % mod * A % mod) % mod;
            B = B >> 1;
        }
        return (int)(ans % mod);
    }
    
    public int solveScalerSol(int A, int B) {
        long fact = 1;
        long mod = (long)(1e9 + 7);
        // calculating factorial of B
        for(long i = 2; i <= B; i += 1) {
            fact = (fact * i) % (mod - 1);      // (mod-1) is used accoring to Fermat Little theorem.
        }
        int ans = fast_powerScalerSol(A, fact, mod);     // calculating power by divide and conquer
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VeryLargePower vlp = new VeryLargePower();
		System.out.println(vlp.solve(1, 1)); // 1
		System.out.println(vlp.solve(2, 2)); // 4
	}

}
/*
Problem Description
Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

"^" means power,

"%" means "mod", and

"!" means factorial.



Problem Constraints
1 <= A, B <= 5e5
*/