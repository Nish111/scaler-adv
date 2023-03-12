package sorting1_270123;

public class SubArraySorting {

	public int[] solve(int[] A, int s, int m, int e) {
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
		SubArraySorting sso = new SubArraySorting();
		int[] A = {4,8,10,11,12,5,6,7,2,1};
		int[] B = sso.solve(A, 2, 4, 7);
		for(int i=0; i<B.length; i++) System.out.print(B[i]+" ");
		System.out.println();
		
	}

}
