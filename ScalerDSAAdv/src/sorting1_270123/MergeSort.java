package sorting1_270123;

public class MergeSort {

	public int[] mergeSort(int[] A, int s, int e) {
		if(s==e) return A;
		int mid = (s+e)/2;
		mergeSort(A, s, mid);
		mergeSort(A, mid+1, e);
		int[] arr = merge(A, s, mid, e);
		return arr;
	}
	public int[] merge(int[] A, int s, int m, int e) {
		int p1=s, p2=m+1, p3=0;
		int[] C = new int[e-s+1];
		while(p1<=m && p2<=e) {
			if(A[p1]<A[p2]) {
				C[p3] = A[p1];
				p1++; p3++;
			}
			else {
				C[p3] = A[p2];
				p2++; p3++;
			}
		}
		while(p1<=m) {
			C[p3] = A[p1];
			p1++; p3++;
		}
		while(p2<=e) {
			C[p3] = A[p2];
			p2++; p3++;
		}
		p3=0;
		for(int i=s; i<=e; i++) {
			A[i]=C[p3];
			p3++;
		}
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort ms = new MergeSort();
		int[] A = {4,8,10,11,12,5,6,7,2,1};
		int[] B = ms.mergeSort(A, 0, 9);
		for(int i=0; i<B.length; i++) System.out.print(B[i]+" ");
		System.out.println();
		
	}

}
