package sorting1_270123;
// https://www.scaler.com/academy/mentee-dashboard/class/50136/homework/problems/4192/hints?navref=cl_pb_nv_tb
public class ReversePairs {
	public int solve(int[] A) { // O(n2) so TLE
		int count=0;
		for(int i=0; i<A.length-1; i++) {
			for(int j=i+1; j<A.length; j++) {
				/*
				 * if((A[i] == A[j]) && (A[i] == 2000000000)) continue; //if(A[i]==A[j])
				 * continue; int temp = 2*A[j]; if(A[i]>temp) count++;
				 */
				
				 if(A[i] > 2*1L*A[j]) count++;
			}
		}
		return count;
    }
	int reversePair = 0;

	public int solveScalerSol(int[] A) {
        int n = A.length;
        return mergesort_and_countScalerSol(A, 0, n - 1);
    }
    public void mergeScalerSol(int a[], int start, int mid, int end) {
        int n1 = (mid - start + 1);
        int n2 = (end - mid);
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = a[start + i];
        for (int j = 0; j < n2; j++)
            R[j] = a[mid + 1 + j];
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if (j >= n2 || (i < n1 && L[i] <= R[j]))
                a[k] = L[i++];
            else
                a[k] = R[j++];
        }
    }
    public int mergesort_and_countScalerSol(int a[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // divide the array into two half and sort them
            int count = mergesort_and_countScalerSol(a, start, mid) + 
            		mergesort_and_countScalerSol(a, mid + 1, end);
            // count the number of pairs
            int j = mid + 1;
            for (int i = start; i <= mid; i++) {
                while (j <= end && 1l * a[i] > a[j] * 2l)
                    j++;
                count += j - (mid + 1);
            }
            mergeScalerSol(a, start, mid, end);
            return count;
        } else
            return 0;
    }
    public int solve3(int[] A) { // this one working
        return invCount(A , 0 , A.length - 1);
    }
    public int invCount(int[] A , int left , int right){
        if(left == right){
            return 0;
        }
        // Divide the array into two parts
        int mid = (left + right) / 2;
        int a = invCount(A , left , mid);
        int b = invCount(A , mid + 1 , right);
        // Merge the two parts
        int aWithB = mergeSort(A , left , mid , right);
        return a + b + aWithB;
    }
    public int mergeSort(int[] A , int left , int mid , int right){
        int count = 0;
        int i = left,       // i is index for left subarray
            j = mid + 1,    // j is index for right subarray
            k = 0;          // k is index for resultant merged subarray    
        int[] C = new int[right - left + 1];
        // Counting number of valid pairs
        while(i <= mid && j <= right){            
            if((long)A[i] > (long)2 * A[j]){
                count += mid - i + 1;              
                j++;
            } else {                
                i++;
            }
        }
        // Using Merge Sort to sort and update resultant array
        i = left;
        j = mid + 1;
        while(i <= mid && j <= right){
            if(A[i] <= A[j]){
                C[k] = A[i];
                i++;
                k++;
            } else {
                C[k] = A[j];
                j++;
                k++;
            }
        }
        while(i <= mid){
            C[k] = A[i];
            k++;
            i++;
        }
        while(j <= right){
            C[k] = A[j];
            j++;
            k++;
        }
        /*Copy back the merged elements to original array*/
        k = 0;
        for(int z = left; z <= right; z++){
            A[z] = C[k];
            k++;
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReversePairs rp = new ReversePairs();
		int[] A = {1, 3, 2, 3, 1};
		System.out.println(rp.solve(A)); // 2
		System.out.println(rp.solveScalerSol(A)); // 2
		A = new int[] {1, 3, 2, 3, 1};
		System.out.println(rp.solve3(A)); // 2
		int[] B = {4, 1, 2};
		System.out.println(rp.solve(B)); // 1
		System.out.println(rp.solveScalerSol(B)); // 3 -- 1
		B = new int[]{4, 1, 2};
		System.out.println(rp.solve3(B)); // 1
		int[] C = { 2000000000, 2000000000, -2000000000 };
		System.out.println(rp.solve(C)); // 2
		System.out.println(rp.solveScalerSol(C)); // 2
		C = new int[]{ 2000000000, 2000000000, -2000000000 };
		System.out.println(rp.solve3(C)); // 2
		int[] D = {769, -71, 599, -1438, -530, -512, 1680, 1907, -301, 492, -844, 1765, -188, 685, -1879, -699, -990, 1022, 459, 528, -930, 1051, 1412, -1598, 245, -480, 1979, 1212, 1177, 447, -509, 881, 1968, -1603, -429, 1165, 405, 426, -1610, 931, -835, -1156, 1273, -143, -940, 199, -1886, -1646, 390, -1349, -256, -256, -103, -135, 637, -605, 55, -1805, -17, -229, 1162, 288, -818, -922, 32, -1032, -1823, -1874, -1650, 146, 721, 1586, 1969, 1720, -993, -1137, -1233, -1629, -879, -277, 444, -1191, -1273, 127, 1785, 1407, -1460, 414, -1578, -1348, 72, -794, 632, 877, 338, 1921, -650, -1314, 1187, -40};
		System.out.println(rp.solve(D)); // 2761
		System.out.println(rp.solveScalerSol(D)); // 2761
		D = new int[]{769, -71, 599, -1438, -530, -512, 1680, 1907, -301, 492, -844, 1765, -188, 685, -1879, -699, -990, 1022, 459, 528, -930, 1051, 1412, -1598, 245, -480, 1979, 1212, 1177, 447, -509, 881, 1968, -1603, -429, 1165, 405, 426, -1610, 931, -835, -1156, 1273, -143, -940, 199, -1886, -1646, 390, -1349, -256, -256, -103, -135, 637, -605, 55, -1805, -17, -229, 1162, 288, -818, -922, 32, -1032, -1823, -1874, -1650, 146, 721, 1586, 1969, 1720, -993, -1137, -1233, -1629, -879, -277, 444, -1191, -1273, 127, 1785, 1407, -1460, 414, -1578, -1348, 72, -794, 632, 877, 338, 1921, -650, -1314, 1187, -40};
		System.out.println(rp.solve3(D)); // 2761 
		int[] E = {1, 3, 2, 3, 1};
		System.out.println(rp.solve(E)); // 2
		System.out.println(rp.solveScalerSol(E)); // 2
		E = new int[]{1, 3, 2, 3, 1};
		System.out.println(rp.solve(E)); // 2
				
	}

}
