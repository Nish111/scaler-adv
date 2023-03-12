package arrays3_090123;

public class PrefixMaxArray {

	public int[] prefixMaxArray(int[] A) {
		for(int i=1; i<A.length; i++) {
			if(A[i] < A[i-1]) A[i] = A[i-1];
		}
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrefixMaxArray pfm = new PrefixMaxArray();
		int[] A = {-5,1,2,3,2};
		int[] B = pfm.prefixMaxArray(A); // -5 1 2 3 3 
		for(int i=0; i<B.length; i++) System.out.print(B[i]+ " ");
		System.out.println();
	}

}
