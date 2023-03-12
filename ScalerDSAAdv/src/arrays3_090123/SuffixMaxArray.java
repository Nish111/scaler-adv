package arrays3_090123;

public class SuffixMaxArray {

	public int[] suffixMaxArray(int[] A) {
		for(int i=A.length-2; i>=0; i--) {
			if(A[i] < A[i+1]) A[i] = A[i+1];
		}
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuffixMaxArray pfm = new SuffixMaxArray();
		int[] A = {-5,1,2,3,2};
		int[] B = pfm.suffixMaxArray(A); // 3 3 3 3 2  
		for(int i=0; i<B.length; i++) System.out.print(B[i]+ " ");
		System.out.println();
	}

}
