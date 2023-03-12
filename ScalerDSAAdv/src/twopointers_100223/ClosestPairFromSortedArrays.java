package twopointers_100223;
// https://www.scaler.com/academy/mentee-dashboard/class/50142/homework/problems/4117?navref=cl_tt_lst_sl
public class ClosestPairFromSortedArrays {

	public int[] solve(int[] A, int[] B, int C) {
			int n = A.length, m=B.length;
			int l=0, r = m-1;
			long res = Integer.MAX_VALUE;
			int[] ans = new int[2];
			while(l<n && r>=0) {
				long sum = A[l] + B[r];
				// finding min so that sum is closest to C
				if(Math.abs(sum-C)<Math.abs(res-C)) {
					res = sum;
					ans[0] = A[l];
					ans[1] = B[r];
				}
				// for conditions where sum is equal to get the 
				// i min and j min in output
				// like for J K case we need 1, 8 and not 1, 10 or 9, 2
				else if(Math.abs(sum-C)==Math.abs(res-C)) {
					if(A[l]<ans[0]) {
						ans[0] = A[l];
						ans[1] = B[r];
					}
					else if(A[l]==ans[0]) {
						if(A[r]<ans[1]) {
							ans[1] = B[r];
						}
					}
					
				}
				if(sum<C) l++;
				else if(sum >C) r--;
				else if(sum == C) {
					return ans;
				}
			}
			return ans;
		
    }
	public int[] solveScalerSol(int[] a, int[] b, int c) {
        int n = a.length, m = b.length;
        int l = 0, r = m-1;
        long dif = (long)(2e9);
        int ans[] = new int[]{-1, -1};
        while(l < n && r >= 0) {
            if(Math.abs(a[l] + b[r] - c) < dif) {
                // update the ans
                dif = Math.abs(a[l] + b[r] - c);
                ans[0] = a[l];  ans[1] = b[r];
            }
            else if(Math.abs(a[l] + b[r] - c) == dif && ans[0] == a[l]){
                // check for the smallest index
                ans[1] = b[r];
            }
            if(a[l] + b[r] >= c) 
                r--;
            else    
                l++;
        }
        return ans;
    }
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestPairFromSortedArrays spsa = new ClosestPairFromSortedArrays();
		int[] A = {1, 2, 3, 4, 5};
		int[] B = {2, 4, 6, 8};
		int[] C = spsa.solve(A, B, 9);
		spsa.printArray(C); // 1 8 
		int[] D = {5, 10, 20};
		int[] E = {1, 2, 30};
		int[] F = spsa.solve(D, E, 13);
		spsa.printArray(F); // 10 2 
		int[] G = { 1 };
		int[] H =  { 2, 4 };
		int[] I = spsa.solve(G, H, 4);
		spsa.printArray(I); // 1 2 
		int[] J = { 1, 3, 5, 7, 9 };
		int[] K = { 2, 4, 6, 8, 10 };
		int[] L = spsa.solve(J, K, 10);			
		spsa.printArray(L); // 1 8 
	}

}
