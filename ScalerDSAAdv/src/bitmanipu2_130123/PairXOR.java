package bitmanipu2_130123;

public class PairXOR {

	public int solveBrute(int[] A) { // O(N2)
		int xor=0;
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length; j++) {
				xor += A[i]^A[j];
			}
		}
		return xor*2;
	}
	public int solve(int[] A) { // O(N2)
		int xor=0;
		for(int i=0; i<32; i++) {
			int set=0, unset=0, num=0;
			for(int j=0; j<A.length; j++) { 
				// for every element in A checking if ith bit is 1 or 0
				if(((A[j]>>i) & 1) == 1) set++;
				else unset++;
			}
				num = set * unset;
				xor += Math.pow(2, i) * num;
				//System.out.println(xor);
		}
		return xor*2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairXOR px = new PairXOR();
		int[] A = {3, 5, 6, 8, 2};
		System.out.println(px.solveBrute(A)); // 148
		System.out.println(px.solve(A)); // 148

	}

}
