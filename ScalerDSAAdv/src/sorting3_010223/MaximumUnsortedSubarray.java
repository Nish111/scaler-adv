package sorting3_010223;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/50138/assignment/problems/359/?navref=cl_pb_nv_tb
public class MaximumUnsortedSubarray {

	public int[] subUnsort(int[] A) {
		int count=0;
		int[] temp = new int[A.length];
		for(int i=0; i<A.length; i++) {
			temp[i] = A[i];
		}
		boolean flag=true;
		Arrays.sort(temp);
		int[] res = new int[2];
		for(int i=0; i<A.length; i++) {
			if(A[i]!=temp[i]) {
				if(count==0) {
					res[0] = i;
					res[1] = i;
				}
				count++;
				res[1] = i;
				flag = false;
			}
			/*
			 * if(A[i] == temp[i]) flag = true; if(flag==true && count !=0 && res[1] == 0)
			 * res[1] = i-1; if(flag == false && count !=0 && res[1] !=0) return new
			 * int[]{-1};
			 */
		}
		if(flag==true) return new int[] {-1};
		return res;
    }
	 public int[] subUnsortScalerSol(int[] A) {
	        int n = A.length;
	        int i = 0, j = n - 1;
	        while (i < n - 1 && A[i] <= A[i + 1]) {
	            i++;
	        }
	        while (j > 0 && A[j] >= A[j - 1]) {
	            j--;
	        }
	        if (i == n - 1) { // if array is already sorted, output -1
	            int ans[] = new int[1];
	            ans[0] = -1;
	            return ans;
	        }
	        // find the maximum and and minimum element from A[i]...A[j]
	        int mn = A[i + 1], mx = A[i + 1];
	        for (int k = i; k <= j; k++) {
	            mx = Math.max(mx, A[k]);
	            mn = Math.min(mn, A[k]);
	        }
	        int l = 0, r = n - 1;
	        while (A[l] <= mn && l <= i) {
	            l++;
	        }
	        while (A[r] >= mx && r >= j) {
	            r--;
	        }
	        int ans[] = new int[2];
	        ans[0] = l;
	        ans[1] = r;
	        return ans;

	    }
	public int[] subUnsort1(int[] A) {
        int[] res = new int[2];
        int n = A.length;
        int flag = 0;
        int[] B = A.clone();
        int start = -1;
        int end = -1;
        Arrays.sort(B);
        for(int i=0; i<n; i++){
            if(A[i]!=B[i]){
                if(start==-1){
                    start = i;
                    end = i;
                    flag = 1;
                }
                end = i;
            }
        }
        if(flag==0)
            return new int[]{-1};
        res[0] = start;
        res[1] = end;
        return res;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumUnsortedSubarray msa = new MaximumUnsortedSubarray();
		int[] A = {1, 3, 2, 4, 5};
		int[] B = msa.subUnsort(A); // 1 2
		System.out.println(B[0]+" "+B[1]);
		int[] C = {1, 2, 3, 4, 5};
		int[] D = msa.subUnsort(C); // -1
		System.out.println(D[0]+" ");
		int[] E = {1, 2, 3, 5, 4};
		int[] F = msa.subUnsort(E); // 3 4
		System.out.println(F[0]+" "+F[1]);
		int[] G = {1, 2, 3, 6, 5};
		int[] H = msa.subUnsort(G); // 3 4
		System.out.println(H[0]+" "+H[1]);
	}

}
