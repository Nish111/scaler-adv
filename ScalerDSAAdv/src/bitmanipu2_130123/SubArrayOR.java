package bitmanipu2_130123;
// https://www.scaler.com/academy/mentee-dashboard/class/50130/homework/problems/6604/?navref=cl_pb_nv_tb
public class SubArrayOR {
// didnt understand
	public int solveBrute(int[] A) { // O(N2) O(1)
		int sum=0, total=0, mod=1000000007;
		for(int i=0; i<A.length; i++) {
			sum=0;
			for(int j=i; j<A.length; j++) {
				// this is adding elements and we have new subarray
				sum |=A[j];
				total += sum;
				//System.out.println(sum+" "+i +" "+j);
			}
		}
		return total;
    }
	public int solve(int[] A) { // failing for some cases
		long sum=0; int temp=0; int mod=1000000007;
		for(int i=0; i<31;i++) {
			temp=0;
			for(int j=A.length-1; j>=0; j--) {
				if((A[j]>>i & 1)==1) {
					sum += (((1<<i)*((A.length-j)%mod))%mod)%mod; 
					temp=0;
				} else {
					sum += (((1<<i)*((A.length-j-1-temp)%mod))%mod)%mod;
					temp++;
				}
			}
		}
		return (int) (sum%mod);
    }
	public int solve2(int[] A) {
		  long ans =0, n = A.length, tot_subArray=(n*(n+1))/2;
	      for(int b = 0 ; b<32;b++){
	          long anszero =0, cnt =0;
	          for(int i = 0 ; i < A.length ; i++){
	              if(((A[i]>>b)&1)!=1)
	                cnt ++;
	              else {
	                 anszero +=((cnt *(cnt+1))/2);
	                 cnt =0;
	              }
	          }
	          anszero +=((cnt *(cnt+1))/2);
	          anszero = (tot_subArray -anszero);
	          ans = (ans+(anszero*(1<<b)))%1000000007;
	        }
	        return (int)ans;
	}
	public int solveScalerSol(int[] A) {
        int n = A.length;
        int[] idx = new int[32];
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            long tmp = A[i - 1];
            for (int j = 0; j <= 31; ++j) {
                long pw = 1 << j;
                if ((tmp & pw) != 0) { //if jth bit is set
                    ans += pw * i; // add its contribution in ans for all subarrays ending at index i
                    idx[j] = i; // store the index for next elements
                } else if (idx[j] != 0) // if jth bit is not set
                {
                    ans += pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using 
                } // the information of last element having jth bit set
            }
        }
        return (int)(ans % 1000000007);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubArrayOR so = new SubArrayOR();
		int[] A = {1,2,3};
		int[] B = {1, 2, 3, 4, 5};
		int[] C = {7, 8, 9, 10};
		int[] D = {54, 464648, 545459, 2323234};
		System.out.println(so.solveBrute(A)); // 15
		System.out.println(so.solveBrute(B)); // 71
		System.out.println(so.solveBrute(C)); // 110
		System.out.println(so.solve2(D)); // 14878456
		System.out.println(so.solve(A)); // 15
		System.out.println(so.solve(B)); // 71
		System.out.println(so.solve(C)); // 110
		System.out.println(so.solve(D)); // 14878456
	}

}
