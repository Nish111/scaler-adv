package math1_modarith_160123;

import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50131/assignment/problems/4110/?navref=cl_pb_nv_tb
public class CountPairsModM {
	public int countPairsModBrute(int[] A, int B) { // O(N2)
		int count=0;
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length; j++) {
				if((A[i] + A[j])%B==0) count++;
			}
		}
		return count;
	}
	public int countPairsMod(int[] A, int B) { // failing for some hard case
		int count=0;
		int[] arr = new int[B];
		for(int i=0; i<A.length; i++) {
			A[i] = A[i]%B;
			arr[A[i]]++;
		}
		/*
		 * for(int i=0;i<B;i++) { System.out.print(arr[i]+" ");
		 * if(arr[i]>=1)System.out.println(i); } System.out.println();
		 */
		if(arr[0] >0) {
			count +=arr[0]*(arr[0]-1)/2;
		}
		if(arr[B/2]>0 & B%2==0) {
			count +=arr[B/2]*(arr[B/2]-1)/2;
		}
		
		if(B>2) {
			if(B %2 ==0) {
				for(int i=1; i<B/2; i++) {
					// B 3 -> 0 1 2
					int temp = arr[i] * arr[B-i];
					//System.out.println();
					count += temp;
				//if(arr[i]>=1) System.out.println(i+" "+(B-i)+" "+temp+" "+count);
				}	
			} else {
				for(int i=1; i<=B/2; i++) {
					// B 3 -> 0 1 2
					int temp = arr[i] * arr[B-i];
					//System.out.println();
					count += temp;
					// if(arr[i]>=1) System.out.println(i+" "+(B-i)+" "+temp+" "+count);
				}	
			}
			
		}
		
		return count;
	}
	public int countPairsModClass(int[] A, int B) { // failing for same above case
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			A[i] = A[i]%B;
			if(hm.containsKey(A[i])) {
				hm.put(A[i], hm.get(A[i])+1);
			}
			else {
				hm.put(A[i], 1);
			}
		}
		int ans = 0, mod=1000000007;
		if(hm.get(0) != null) {
			ans += ((hm.get(0)*(hm.get(0)-1)/2))%mod;
		}
		int i=1, j=B-1;
		while(i<j) {
			if(hm.get(i) != null && hm.get(j) != null) {
				ans += (hm.get(i)*hm.get(j))%mod;	
			}
			i++; j--;
		}
		if(B%2 == 0 && hm.get(B/2) != null) {
			ans += (hm.get(B/2)*(hm.get(B/2)-1)/2)%mod;
		}
		return ans;
	}
	public int solve(int[] A, int B) {
	       long count = 0;
	       int mod = 1000000007;
	       HashMap<Integer, Integer> hm = new HashMap<>();
	       for(int i = 0; i < A.length; i++){
	           int x = A[i] % B;
	           int xi = (B - x) % B;
	           count = (count + hm.getOrDefault(xi, 0)) % mod;
	           hm.put(x, hm.getOrDefault(x, 0) + 1);
	       }
	       return (int) count;
	    }
	public int solveScalerSol(int[] a, int k) {
        int n = a.length;
        long mod = (long)(1e9 + 7);
        long cnt[] = new long[k];
        // cnt[i] stores the count of elements such that their modulo k equals i
        for(int x : a)    cnt[x % k]++;
        long ans = cnt[0] * (cnt[0] - 1) / 2;
        for(int i = 1, j = k - 1; i <= j; i++, j--) {
            if(i == j)    
                ans = (ans + cnt[i] * (cnt[i] - 1) / 2) % mod;
            else    
                ans = (ans + cnt[i] * cnt[j]) % mod;
        }
        return (int)ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPairsModM cpm = new CountPairsModM();
		int[] A = {4, 7, 6, 5, 5, 3};
		int[] B = {1, 2, 3, 4, 5};
		int[] C = {5, 17, 100, 11};
		int[] D = {93, 9, 46, 79, 56, 24, 10, 26, 9, 93, 31, 93, 75, 7, 4, 80, 19, 67, 49, 84, 62, 100, 17, 40, 35, 84, 14, 81, 99, 31, 100, 66, 70, 2, 11, 84, 60, 89, 13, 57, 47, 60, 59, 60, 42, 67, 89, 29, 85, 83, 42, 47, 66, 80, 88, 85, 83, 82, 16, 23, 21, 55, 26, 2, 21, 92, 85, 26, 46, 3, 7, 95, 50, 22, 84, 52, 57, 44, 4, 23, 25, 55, 41, 49 };
		int[] E = {818, 63, 386, 563, 876, 855, 731, 933, 97, 935, 710, 27, 383, 975, 582, 188, 843, 569, 742, 834, 859, 938, 894, 554, 31, 506, 679, 153, 191, 816, 716, 698, 352, 688, 586, 206, 228, 418, 543, 996, 918, 55, 666, 133, 468, 494, 667, 596, 251, 189, 853, 15, 571, 794, 560, 835, 439, 923, 933, 789, 203, 527, 106, 401, 623, 97, 661, 53, 1, 17, 773, 835, 191, 887, 568, 987, 667, 620, 52, 253, 334, 373, 427, 891, 455, 186, 742, 375, 855, 288, 574, 67, 590, 628, 926, 260, 376, 110, 548, 40, 365, 398, 704, 328, 340, 927, 755, 356};
		System.out.println(cpm.countPairsModBrute(A, 3)); // 5
		System.out.println(cpm.countPairsMod(A, 3)); // 5
		System.out.println(cpm.countPairsModBrute(B, 2)); // 4
		System.out.println(cpm.countPairsMod(B, 2)); // 4
		System.out.println(cpm.countPairsModBrute(C, 28)); // 1
		System.out.println(cpm.countPairsMod(C, 28)); // 1
		System.out.println(cpm.countPairsModBrute(D, 37)); // 84
		System.out.println(cpm.countPairsMod(D, 37)); // 84
		System.out.println(cpm.countPairsModBrute(E, 96)); // 49
		System.out.println(cpm.countPairsMod(E, 96)); // 49
		System.out.println(cpm.countPairsModClass(A, 3)); // 5
		System.out.println(cpm.countPairsModClass(B, 2)); // 4
		System.out.println(cpm.countPairsModClass(C, 28)); // 1
		System.out.println(cpm.countPairsModClass(D, 37)); // 84
		System.out.println(cpm.countPairsModClass(E, 96)); // 49
		System.out.println(cpm.solve(A, 3)); // 5
		System.out.println(cpm.solve(B, 2)); // 4
		System.out.println(cpm.solve(C, 28)); // 1
		System.out.println(cpm.solve(D, 37)); // 84
		System.out.println(cpm.solve(E, 96)); // 49
	}

}
