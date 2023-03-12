package sorting3_010223;

public class BubbleSort {

	public int[] bubbleSort(int[] A) { // O(n2)
		int count=0;
		for(int i=0; i<A.length-1; i++) {
			for(int j=i+1; j<A.length; j++) {
				count++;
				if(A[i]>A[j]) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}
		System.out.println(count);
		return A;
	}
	public int[] bubbleSortUsingFlag(int[] A) { // O(n) best case. nothing swapped
		int count=0;
		for(int i=0; i<A.length-1; i++) {
			boolean flag= false;
			for(int j=i+1; j<A.length; j++) {
				if(A[i]>A[j]) {
					flag = true;
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
					count++;
					//System.out.println(count);
				}
				if(!flag) continue;
			}
		}
		System.out.println(count);
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort bs = new BubbleSort();
		int[] A = {-1,3,4,2,10,8};
		int[] B = bs.bubbleSort(A);
		for(int i=0; i<B.length; i++) System.out.print(B[i] +" ");
		System.out.println();
		int[] C = {-1,3,4,5,10,28};
		int[] D = bs.bubbleSortUsingFlag(C);
		for(int i=0; i<D.length; i++) System.out.print(D[i] +" ");
		System.out.println();
	}

}
