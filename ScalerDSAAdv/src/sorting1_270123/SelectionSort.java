package sorting1_270123;
// https://www.scaler.com/academy/mentee-dashboard/class/50136/assignment/problems/260?navref=cl_tt_lst_nm
public class SelectionSort {

	public int selectionSort(int N, int k, int[] arr) { // class
		int[] ar = arr;
		for(int i=0; i<(N-1); i++) {
			int c_min = ar[i];
			int index = i;
			for(int j=i+1; j<N; j++) {
				if(ar[j]<c_min) {
					c_min = ar[j];
					index = j;
				}
			}
			int temp = ar[i];
			ar[i] = ar[index];
			ar[index] = temp;
		}
		return ar[k-1];
	}
	public int kthsmallest(final int[] A, int B) {
		int[] ar = A;
		int N = ar.length;
		for(int i=0; i<(N-1); i++) {
			int c_min = ar[i];
			int index = i;
			for(int j=i+1; j<N; j++) {
				if(ar[j]<c_min) {
					c_min = ar[j];
					index = j;
				}
			}
			int temp = ar[i];
			ar[i] = ar[index];
			ar[index] = temp;
		}
		return ar[B-1];
    }
	public int kthsmallestScalerSol(final int[] A, int B) {
        for (int i = 0; i < B; i++) {
            // finding the minimum element from the remaining array
            int minn = Integer.MAX_VALUE, idx = 0;
            for (int j = i; j < A.length; j++) {
                if (A[j] < minn) {
                    minn = A[j];
                    idx = j;
                }
            }
            int tmp = A[i];
            A[i] = A[idx];
            A[idx] = tmp;
        }
        return A[B - 1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort ss = new SelectionSort();
		int[] A = {3,8,2,4,-1};
		System.out.println(ss.selectionSort(5, 2, A)); // 2
		int[] B = {2, 1, 4, 3, 2};
		System.out.println(ss.kthsmallest(B, 3)); // 2
		int[] C = {1, 2};
		System.out.println(ss.kthsmallest(C, 2)); // 2
	}

}
