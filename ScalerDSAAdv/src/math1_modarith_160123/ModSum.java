package math1_modarith_160123;

import java.util.ArrayList;
// https://www.scaler.com/academy/mentee-dashboard/class/50131/homework/problems/4745/hints?navref=cl_pb_nv_tb
public class ModSum {
	public int solveBrute(int[] A) {
		int sum=0, mod = 1000000007;
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length;j++) {
				sum += A[i]%A[j];
			}
		}
		return sum;
    }

	public int solve(int[] A) {
		int sum=0, mod = 1000000007;
		int[] arr = new int[1001];
		for(int i=0; i<A.length; i++) {
			arr[A[i]]++;
		}
		//for(int i=0; i<4; i++) System.out.print(arr[i] +" ");
		//System.out.println();
		for(int i=1; i<1001; i++) {
			for(int j=1; j<1001;j++) {
				sum += ((i%j)*arr[i]*arr[j])%mod;
				sum=sum%mod;
			}
		}
		return sum;
    }
public int solveScalerSol(ArrayList<Integer> A) {
        int n = A.size(), mod = 1000 * 1000 * 1000 + 7;
        // To store the frequency of each element
        int[] cnt = new int[1009];
        // Store the frequency of each element
        for(int a: A)    
            cnt[a]++;
        // To store the required answer
        int ans = 0;
        // For all valid pairs
        for(int i = 1; i <= 1000; i++){
            if(cnt[i] == 0)    
                continue;
            for(int j = 1; j <= 1000; j++){
                if(cnt[j] == 0)    
                    continue;
                // Update the count
                int val = j % i;
                int temp = cnt[i] * cnt[j] * val;
                ans = ((ans % mod) + (temp % mod)) % mod;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModSum ms = new ModSum();
		int[] A = {1,2,3};
		int[] B = {17, 100, 11};
		System.out.println(ms.solveBrute(A)); // 5
		System.out.println(ms.solveBrute(B)); // 61
		System.out.println(ms.solve(A)); // 5
		System.out.println(ms.solve(B)); // 61
	}

}
