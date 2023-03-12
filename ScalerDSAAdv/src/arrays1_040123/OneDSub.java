package arrays1_040123;

public class OneDSub {

	public int[] oneD(int[] A, int[][] Q) {
		
		int len = Q.length;
		int count=0;
		while(count<len) {
			A[Q[count][0]] +=A[Q[count][0]]+Q[count][1];
			count++;
		}
		for(int i=0; i<A.length; i++) System.out.print(A[i]+" ");
		System.out.println();
		for(int i=1; i<A.length; i++) {
			A[i] = A[i-1] + A[i];
		}
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneDSub ods = new OneDSub();
		int[] A = {0,0,0,0,0,0,0};
		int[][] Q = {{2,4},{3,-1},{0,2},{4,1}};
		int[] B = ods.oneD(A, Q);
		for(int i=0; i<B.length; i++) System.out.print(B[i]+" ");
		System.out.println();
	}

}
