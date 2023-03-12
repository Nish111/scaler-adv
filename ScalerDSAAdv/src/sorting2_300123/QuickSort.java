package sorting2_300123;

public class QuickSort {

	public void quickSort(int[] A, int s, int e) {
		if(s >= e) return;
		int pos = rearrange(A, s, e);
		quickSort(A, s , pos-1);
		quickSort(A, pos+1, e);
	}
	public int rearrange(int[] A, int s, int e) {
		// TODO Auto-generated method stub
		int l = s+1;
		int r = e;
		while(l<=r) {
			if(A[l]<=A[s]) l++;
			else if(A[r]>A[s]) r--;
			else {
				int temp = A[l];
				A[l] = A[r];
				A[r] = temp;
				l++; r--;
			}
		}
		int temp = A[s];
		A[s] = A[r];
		A[r] = temp;
		return r;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort qs = new QuickSort();
		int[] A = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14};
		qs.quickSort(A, 0, A.length-1); // 2 3 6 7 8 10 12 14 15 15 18 
		for(int i=0; i<A.length; i++) System.out.print(A[i]+" ");
		System.out.println();
	}

}
