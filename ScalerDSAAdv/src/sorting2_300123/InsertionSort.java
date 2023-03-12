package sorting2_300123;

public class InsertionSort {

	public int[] insertionsort(int[] A) {
		
		for(int i=1; i<A.length; i++) {
			int j=i-1;
			while(j>=0 && A[j]>A[j+1]) {
				int temp = A[j];
				A[j] = A[j+1];
				A[j+1] = temp;
				j--;
			}
		}
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort is = new InsertionSort();
		int[] A = {8, 7, 6, 4, 3};
		int[] B = is.insertionsort(A); // 3 4 6 7 8 
		for(int i=0; i<B.length; i++) System.out.print(B[i] +" ");
		System.out.println();
		int[] C = {9, 1, 2, 4, 6, 5};
		int[] D = is.insertionsort(C); // 1 2 4 5 6 9 
		for(int i=0; i<D.length; i++) System.out.print(D[i] +" ");
		System.out.println();
	}

}
