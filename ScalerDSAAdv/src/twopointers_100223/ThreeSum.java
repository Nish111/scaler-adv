package twopointers_100223;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/50142/assignment/problems/165/?navref=cl_pb_nv_tb
public class ThreeSum {

	public int threeSumClosest(int[] A, int B) { // this finds only if sum is exact and its count
		Arrays.sort(A);
		int n = A.length;
		int count=0;
		for(int i=0; i<n-2; i++) {
			if(i>0 && A[i]==A[i-1])
				continue;
			int k = -A[i];
			int p1 = i+1, p2 = n-1;
			while(p1<p2) {
				int sum = A[p1] + A[p2];
				if(sum > k) p2--;
				else if(sum<k) p1++;
				else {
					//System.out.println("three elements "+A[i] +" "+A[p1]+" "+A[p2]);
					count++;
					p1++;
					while(p1<p2 && A[p1-1]==A[p2]) {
						p1++;
					}
				}
			}
		}
		return count;
    }
	public int threeSumClosest1(int[] A, int B) { // 
		Arrays.sort(A);
		int n = A.length;
		if(n<=3) {
			int sum = 0;
			for(int i:A)
				sum += i;
			return sum;
		}
		long res = Integer.MAX_VALUE;
		int i=0;
		for(i=0; i<n-2; i++) {
			int j=i+1, k=n-1;
			if(i>0 && A[i]==A[i-1])
				continue;
			while(j<k) {
				int sum = A[i]+A[j]+A[k];
				if(Math.abs(B-sum)<Math.abs(B-res))
					res = sum;
				if(sum<B) j++;
				else k--;
			}
		}
		return (int) res;
    }
	public int threeSumClosestScalerSol(int[] A, int B) {
        int n = A.length, diff = 1000000000, ans = -1;
        Arrays.sort(A);
        // fix the smallest number of the three integers
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (Math.abs(A[i] + A[j] + A[k] - B) < diff) {
                    diff = Math.abs(A[i] + A[j] + A[k] - B);
                    ans = A[i] + A[j] + A[k];
                }
                if (A[i] + A[j] + A[k] > B)
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum ts = new ThreeSum();
		int[] A = {-1, 2, 1, -4};
		System.out.println(ts.threeSumClosest(A, 1));	// 0
		System.out.println(ts.threeSumClosest1(A, 1));	// 2
		int[] B = {1, 2, 3};
		System.out.println(ts.threeSumClosest(B, 6)); // 0
		System.out.println(ts.threeSumClosest1(B, 6));	//6
		int[] C = {-1, 0, 1, 2, -1, 4};
		System.out.println(ts.threeSumClosest(C, 0)); // 2
		System.out.println(ts.threeSumClosest1(C, 0));	// 0
	}

}
