package sorting3_010223;
// https://www.scaler.com/academy/mentee-dashboard/class/50138/assignment/problems/21391/?navref=cl_pb_nv_tb
public class CountSort2 {

	public int[] solve(int[] A) {
		int max = A[0];
		for(int i=0; i<A.length; i++) {
			max = Math.max(max, A[i]);
		}
		int[] B = new int[max]; // 0 to max
		for(int i=0; i<A.length; i++) {
			B[A[i]-1]++;
		}
		int k=0;
		for(int i=0; i<B.length; i++) {
			for(int j=1; j<=B[i]; j++) {
				A[k] = i+1;
				k++;
			}
		}
		return A;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountSort2 cs = new CountSort2();
		int[] A = {9,1,6,5,4,4};
		int[] B = cs.solve(A); // 1 4 4 5 6 9 
		for(int i=0; i<B.length; i++) System.out.print(B[i]+" ");
		System.out.println();
		int[] C = {88,102,5,62,75};
		int[] D = cs.solve(C); // 5 62 75 88 102 
		for(int i=0; i<D.length; i++) System.out.print(D[i]+" ");
		System.out.println();
		int[] E = {3, 30, 34, 5, 9};
		int[] F = cs.solve(E); // 3 5 9 30 34 
		for(int i=0; i<F.length; i++) System.out.print(F[i]+" ");
		System.out.println();
		int[] G = {2, 3, 9};
		int[] H = cs.solve(G); // 2 3 9 
		for(int i=0; i<H.length; i++) System.out.print(H[i]+" ");
		System.out.println();
	}

}
