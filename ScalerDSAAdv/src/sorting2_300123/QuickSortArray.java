package sorting2_300123;

public class QuickSortArray {

	public int[] insertionArray(int[] A, int s, int e) {
		int l=s+1, r = e;
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
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortArray isa = new QuickSortArray();
		int[] E = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14}; // 6 2 8 12 15 placed 8 
		int[] F = isa.insertionArray(E, 2,6); // 10 3 6 2 8 12 15 18 7 15 14  
		for(int i=0; i<F.length; i++) System.out.print(F[i]+" ");
		System.out.println();
		int[] G = {6};
		int[] H = isa.insertionArray(G,0,0); // 6 corner cases working
		for(int i=0; i<G.length; i++) System.out.print(G[i]+" ");
		System.out.println();
		int[] I = {6, 3};
		int[] J = isa.insertionArray(I,0,1); // 3 6 corner cases working
		for(int i=0; i<J.length; i++) System.out.print(J[i]+" ");
		System.out.println();
	}

}
