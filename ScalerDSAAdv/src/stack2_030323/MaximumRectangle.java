package stack2_030323;

public class MaximumRectangle {

	public int solveBrute(int[][] A) {
		
		return 0;
	}
	public int solve(int[][] A) {
		int[][] B = new int[A.length][A[0].length];
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				B[i][j] = A[i][j];
			}
		}
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				if(A[i][j] != 0) {
					if(i>0 && j >0) B[i][j] += B[i-1][j];
					else if(i>0) B[i][j] += B[i-1][j];
				}
			}
		}
		printArray(B);
		return 0;
	}
	public void printArray(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumRectangle mr = new MaximumRectangle();
		int[][] A = {{0,0,1}, {0, 1, 1}, {1, 1, 1}};
		mr.printArray(A);
		System.out.println(mr.solve(A)); // 4
		int[][] B = {{0,1,1,0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
		mr.printArray(B);
		System.out.println(mr.solve(B));
	}

}
