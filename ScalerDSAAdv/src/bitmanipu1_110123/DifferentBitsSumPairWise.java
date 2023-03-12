package bitmanipu1_110123;
// https://www.scaler.com/academy/mentee-dashboard/class/50129/homework/problems/330?navref=cl_tt_nv
public class DifferentBitsSumPairWise {

	public int cntBitsBrute(int[] A) { // TLE
		int count=0;
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length; j++) {
				int xor = A[i]^A[j];
				count += checkBitInt(xor);
			}
		}
		return count*2;
	}
	public int checkBitInt(int xor) {
		int count=0;
		while(xor>0) {
			count += xor & 1;
			xor=xor>>1;
		}
		return count;
	}
	public int cntBits(int[] A) { // something wrong- modified still for hard wrong
		long count=0;
		int mod=1000000007;
		/*
		 * int max = A[0]; int convertMaxB = 0; for(int i=1; i<A.length; i++) { max =
		 * Math.max(max, A[i]); } while(max>0) { max=max>>1; convertMaxB++; }
		 */
		//System.out.println(convertMaxB);
		for(int i=0; i<32; i++) { 
			long sum = 0;
			for(int j=0; j<A.length; j++) { 
				if(checkBit(A[j], i)) sum++;
				//System.out.println(sum);
			}
			if(sum !=0) {
				count+=(sum*(A.length-sum))%mod;	
			}
			count %= mod;
			//System.out.println(count);
		}
		return (int) (count*2);
	}
	public boolean checkBit(int i, int i2) {
		if(((i>>i2) & 1) == 1) return true;
		return false;
	}
	 public int cntBitsUsing(int[] A) {
	        int mod=1000000007;
	        long sum=0;
	        for(int i=0;i<32;i++){
	            long count=0;
	            for(int j=0;j<A.length;j++){
					/*
					 * if((A[j]&(1<<i))>0){ setbits++; }
					 */
	            	if((A[j]>>i & 1) ==1) count++;
	            }
	          sum+=(count*(A.length-count))%mod;
	         sum%=mod;
	        }
	      return (int)(sum*2)%mod;
	    }
	 public int cntBitsScalerSol(int[] A) {
	        long ans = 0;
	        int n = A.length, Mod = 1000 * 1000 * 1000 + 7;
	        // traverse over all bits
	        for (int i = 0; i < 31; i++) {
	            // count number of elements with i-th bit set
	            long cnt = 0;
	            for (int j = 0; j < n; j++)
	                if ((A[j] & (1 << i)) != 0) 
	                    cnt++;
	            // add to answer cnt * (n - cnt) * 2
	            ans += (cnt * (n - cnt) * 2) % Mod;
	            ans %= Mod;
	        }
	        return (int) ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DifferentBitsSumPairWise dbsw = new DifferentBitsSumPairWise();
		int[] A = {1,3,5};
		int[] B = {2,3};
		int[] C = {2,2,2};
		int[] D = { 81, 13, 2, 7, 96 };
		System.out.println(dbsw.cntBitsBrute(A)); // 8
		System.out.println(dbsw.cntBitsBrute(B)); // 2
		System.out.println(dbsw.cntBitsBrute(C)); // 0
		System.out.println(dbsw.cntBitsBrute(D)); // 72
		System.out.println(dbsw.cntBits(A)); // 8
		System.out.println(dbsw.cntBits(B)); // 2
		System.out.println(dbsw.cntBits(C)); // 0
		System.out.println(dbsw.cntBits(D)); // 46 - wrong
		System.out.println(dbsw.cntBitsUsing(D)); // 72
	}

}
