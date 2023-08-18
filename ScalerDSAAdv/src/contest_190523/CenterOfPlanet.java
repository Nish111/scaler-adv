package contest_190523;
// https://www.scaler.com/test/745654aa9c/#/problem_5
public class CenterOfPlanet {
	public int solve(int A, int[][] B) {
		/*
		 * int[] check = new int[A+1]; int k=0; public int solve(int A, int[][] B) { int
		 * result = B[0][1]; for(int i=0; i<B.length; i++){ int temp = B[i][1];
		 * if(temp!=result) { check[k]=temp; k++; } } while(temp != 0){
		 * 
		 * } return result;
		 */
		int[] in = new int[A + 1];
		int[] out = new int[A + 1];
		for (int i = 1; i <= A; i++) {
			in[i] = 0;
			out[i] = 0;
		}
		for (int i = 0; i < B.length; i++) {
			++in[B[i][0]];
			++out[B[i][1]];
		}
		for (int i = 1; i <= A; i++) {
			if (out[i] == A - 1 && in[i] == 0)
				return i;
		}
		return -1;

	}
}
