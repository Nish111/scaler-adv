package arrays2_050123;
// https://www.scaler.com/academy/mentee-dashboard/class/50127/assignment/problems/4088/submissions
public class SubMatrixSumQueries {

	public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) { // not working for few
		int[][] X = new int[A.length][A[0].length];
		X[0][0] = A[0][0];
		int mod = 1000000007;
		// row addition
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				if(j==0) X[i][j] = A[i][j];
				else X[i][j] = X[i][j-1]+A[i][j];
			}
		}
		// column addition
		for(int j=0; j<A.length; j++) {
			for(int i=0; i<A[0].length; i++) {
				if(i==0) X[i][j] = X[i][j];
				else X[i][j] = X[i-1][j]+X[i][j];
			}
		}
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(X[i][j] + " ");
			}
			System.out.println();
		}
		int[] result = new int[B.length];
		for(int i=0 ; i<B.length; i++) {
			int x1 = B[i]-1;
			int y1 = C[i]-1;
			int x2 = D[i]-1;
			int y2 = E[i]-1;
			long sum = 0;
			sum +=X[x2][y2];
			if(x1>0) sum -=X[x1-1][y2];
			if(y1>0) sum -=X[x2][y1-1];
			if(x1>0 && y1>0) sum +=X[x1-1][y1-1];
			result[i] = (int) (((sum%mod)+mod)%mod);
		}
		return result;
    }
	public int[] solveAgain(int[][] A, int[] B, int[] C, int[] D, int[] E) {
		int n = A.length, m = A[0].length, mod = 1000000007;
		long[][] pf = new long[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				pf[i][j] = (A[i-1][j-1] +pf[i-1][j]+pf[i][j-1]-pf[i-1][j-1] + mod)%mod;
			}
		}
		int[] result = new int[B.length];
		for(int i=0; i<B.length; i++) {
			int x1=B[i], y1=C[i], x2=D[i], y2=E[i];
			long sum = pf[x2][y2]-pf[x2][y1-1] - pf[x1-1][y2] + pf[x1-1][y1-1];
			while(sum<0) sum+=mod;
			sum = sum%mod;
			result[i] = (int) sum;
		}
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubMatrixSumQueries smsq = new SubMatrixSumQueries();
		int[][] A = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[] B = {1,2};
		int[] C = {1,2};
		int[] D = {2,3};
		int[] E = {2,3};
		int[] F = smsq.solve(A, B, C, D, E);
		int[] G = smsq.solveAgain(A, B, C, D, E);
		for(int j=0; j<G.length; j++) {
			System.out.print(G[j] + " ");
		}
		System.out.println();
		
	}
	/*
	 * A : 
[
  [70, 88, 97, 98, 63, 69, 58, 46, 100, 73, 58, 18, 10, 96, 60, 41, 27, 76, 29, 66, 49, 69, 42, 96, 46, 16, 4, 87, 60, 46, 40, 74, 16, 18, 91, 34, 46, 16, 72, 51, 22, 44, 21, 82, 94, 20, 4, 43, 88, 44]
  [26, 89, 69, 59, 32, 75, 31, 36, 65, 79, 1, 95, 9, 46, 49, 79, 17, 37, 99, 17, 4, 38, 66, 71, 51, 47, 24, 38, 56, 73, 92, 98, 54, 19, 74, 36, 91, 91, 70, 23, 79, 63, 88, 58, 79, 38, 1, 70, 30, 35]
  [63, 51, 79, 57, 95, 66, 15, 45, 36, 87, 88, 36, 70, 34, 16, 3, 84, 96, 84, 66, 1, 45, 71, 55, 34, 33, 41, 80, 2, 78, 62, 14, 99, 20, 50, 11, 65, 55, 45, 17, 72, 65, 74, 74, 28, 36, 81, 31, 45, 41]
  [28, 53, 21, 89, 52, 12, 39, 63, 49, 67, 1, 88, 56, 84, 55, 15, 6, 31, 12, 91, 27, 85, 96, 3, 68, 37, 2, 93, 30, 9, 4, 44, 19, 33, 83, 81, 13, 25, 18, 11, 1, 57, 33, 9, 23, 76, 51, 93, 11, 71]
  [67, 87, 17, 61, 38, 48, 88, 92, 20, 50, 28, 70, 6, 50, 79, 15, 28, 40, 60, 30, 57, 64, 45, 82, 97, 34, 31, 60, 88, 92, 65, 32, 94, 84, 83, 64, 60, 83, 45, 50, 5, 66, 20, 9, 16, 96, 34, 80, 37, 48]
  [62, 45, 93, 59, 12, 94, 67, 15, 11, 90, 84, 59, 95, 12, 56, 31, 68, 79, 50, 63, 80, 18, 88, 16, 57, 34, 73, 56, 13, 35, 1, 51, 35, 37, 19, 37, 70, 30, 20, 74, 92, 77, 41, 12, 63, 74, 1, 3, 83, 24]
  [38, 83, 33, 84, 58, 1, 39, 53, 58, 13, 73, 100, 31, 85, 40, 6, 11, 19, 6, 100, 100, 32, 62, 78, 20, 24, 8, 50, 81, 33, 22, 61, 37, 66, 40, 15, 34, 97, 86, 80, 96, 55, 49, 20, 77, 21, 13, 2, 88, 9]
  [36, 12, 97, 62, 51, 20, 63, 29, 6, 56, 87, 76, 3, 14, 13, 81, 52, 89, 55, 22, 40, 64, 77, 98, 30, 99, 87, 46, 21, 62, 86, 24, 29, 4, 56, 73, 41, 41, 23, 59, 58, 47, 14, 95, 33, 22, 76, 77, 75, 49]
  [5, 27, 83, 51, 7, 27, 57, 60, 77, 53, 35, 73, 67, 40, 72, 15, 10, 13, 1, 64, 27, 99, 2, 86, 53, 76, 100, 17, 97, 55, 43, 79, 54, 15, 84, 63, 80, 75, 51, 30, 38, 76, 37, 62, 47, 76, 42, 79, 37, 1]
  [46, 87, 58, 76, 53, 42, 99, 59, 88, 24, 51, 52, 7, 14, 35, 85, 75, 8, 75, 13, 60, 51, 60, 30, 47, 5, 52, 94, 22, 35, 44, 82, 19, 8, 75, 60, 64, 14, 98, 5, 16, 83, 84, 61, 60, 62, 33, 99, 42, 6]
  [84, 71, 38, 16, 82, 92, 77, 72, 96, 25, 25, 76, 76, 9, 7, 64, 40, 5, 12, 78, 5, 80, 8, 6, 4, 65, 76, 62, 8, 75, 50, 54, 58, 91, 41, 25, 73, 95, 8, 86, 87, 24, 54, 10, 46, 47, 68, 4, 83, 5]
  [13, 58, 77, 68, 78, 50, 2, 8, 82, 64, 41, 7, 93, 2, 77, 89, 54, 78, 30, 58, 95, 11, 56, 46, 80, 51, 95, 1, 95, 82, 87, 76, 60, 28, 83, 6, 52, 16, 88, 83, 47, 31, 4, 5, 60, 64, 55, 58, 41, 79]
  [6, 30, 92, 68, 12, 47, 55, 41, 73, 79, 99, 79, 3, 66, 83, 31, 49, 50, 3, 77, 66, 43, 9, 66, 54, 65, 35, 47, 61, 88, 21, 70, 64, 67, 9, 71, 24, 16, 34, 88, 51, 64, 19, 44, 77, 92, 39, 28, 16, 57]
  [21, 31, 19, 48, 11, 71, 55, 61, 21, 12, 64, 7, 67, 100, 47, 31, 87, 93, 22, 23, 41, 30, 48, 27, 57, 68, 23, 92, 22, 71, 33, 100, 1, 72, 32, 23, 73, 23, 25, 67, 83, 53, 13, 61, 30, 99, 88, 14, 5, 51]
  [29, 96, 43, 33, 94, 52, 34, 75, 98, 12, 3, 100, 71, 3, 60, 94, 31, 52, 86, 77, 100, 93, 23, 3, 30, 2, 92, 97, 31, 88, 4, 23, 16, 29, 60, 100, 11, 95, 81, 43, 19, 19, 93, 68, 60, 3, 78, 17, 51, 93]
  [32, 97, 38, 58, 74, 71, 36, 15, 38, 56, 84, 78, 44, 83, 81, 5, 94, 19, 20, 61, 42, 49, 99, 27, 29, 84, 56, 39, 63, 37, 28, 17, 25, 10, 33, 83, 25, 94, 100, 60, 59, 28, 96, 64, 77, 66, 53, 46, 88, 25]
  [75, 15, 12, 36, 6, 60, 85, 92, 27, 61, 40, 100, 19, 71, 81, 84, 64, 7, 68, 23, 10, 46, 75, 46, 59, 100, 57, 58, 24, 99, 7, 96, 21, 7, 94, 15, 50, 36, 14, 64, 70, 67, 72, 8, 39, 71, 13, 31, 62, 31]
  [65, 28, 76, 26, 85, 27, 34, 71, 65, 6, 3, 29, 42, 63, 76, 31, 89, 73, 94, 73, 6, 24, 49, 70, 95, 40, 33, 17, 50, 41, 10, 88, 53, 31, 48, 20, 45, 14, 4, 59, 59, 58, 92, 53, 43, 57, 40, 5, 97, 29]
  [88, 27, 81, 96, 58, 75, 87, 5, 67, 29, 77, 29, 58, 31, 59, 61, 69, 56, 63, 31, 48, 50, 57, 29, 100, 88, 75, 75, 28, 75, 59, 97, 36, 46, 95, 78, 13, 99, 56, 16, 43, 18, 9, 18, 73, 58, 50, 41, 47, 48]
  [29, 74, 46, 52, 40, 84, 61, 32, 100, 69, 26, 49, 12, 82, 75, 56, 83, 37, 62, 8, 60, 96, 46, 69, 82, 43, 8, 47, 6, 89, 51, 88, 64, 13, 1, 49, 77, 55, 97, 66, 83, 63, 76, 46, 75, 100, 89, 70, 19, 35]
  [30, 70, 44, 98, 6, 62, 72, 80, 96, 33, 12, 55, 41, 68, 92, 37, 97, 71, 80, 78, 98, 77, 23, 96, 84, 85, 60, 23, 47, 21, 4, 74, 78, 54, 7, 56, 94, 10, 41, 99, 73, 94, 89, 76, 9, 27, 43, 5, 71, 98]
  [83, 60, 20, 18, 9, 90, 50, 85, 3, 49, 60, 22, 79, 70, 92, 32, 93, 68, 37, 21, 100, 42, 19, 71, 30, 57, 58, 20, 79, 38, 14, 81, 43, 61, 22, 77, 3, 36, 30, 96, 27, 94, 71, 45, 62, 50, 3, 20, 5, 89]
  [63, 91, 12, 30, 34, 14, 81, 82, 97, 17, 41, 27, 2, 92, 71, 12, 16, 88, 43, 14, 14, 57, 23, 15, 64, 37, 12, 77, 19, 40, 50, 58, 65, 21, 2, 90, 30, 44, 33, 42, 67, 24, 26, 66, 45, 100, 84, 51, 49, 51]
  [79, 37, 42, 74, 63, 52, 97, 49, 14, 93, 94, 7, 100, 55, 96, 51, 6, 10, 52, 54, 47, 94, 90, 26, 87, 18, 63, 66, 81, 90, 10, 88, 27, 13, 26, 27, 32, 100, 72, 95, 95, 99, 15, 37, 83, 69, 84, 29, 39, 15]
  [23, 21, 97, 44, 37, 61, 58, 92, 89, 74, 52, 99, 54, 21, 48, 38, 16, 100, 89, 1, 9, 35, 58, 46, 18, 90, 3, 5, 76, 1, 88, 78, 16, 49, 46, 51, 36, 17, 3, 62, 94, 74, 99, 22, 60, 75, 58, 13, 82, 38]
  [48, 67, 69, 88, 47, 60, 24, 27, 78, 5, 6, 26, 29, 39, 47, 41, 41, 63, 85, 50, 93, 96, 41, 60, 94, 13, 13, 99, 59, 86, 19, 25, 95, 21, 81, 61, 36, 91, 6, 99, 3, 3, 84, 11, 77, 69, 99, 90, 36, 72]
  [11, 32, 4, 17, 62, 66, 56, 4, 5, 29, 91, 18, 80, 91, 13, 67, 7, 9, 36, 85, 78, 58, 46, 99, 17, 85, 49, 42, 62, 98, 36, 95, 34, 22, 45, 93, 55, 97, 55, 87, 66, 56, 22, 72, 38, 44, 49, 90, 28, 20]
  [38, 81, 8, 93, 61, 58, 48, 80, 58, 41, 9, 15, 74, 86, 72, 65, 6, 41, 16, 69, 39, 34, 22, 34, 43, 36, 64, 22, 94, 67, 54, 23, 74, 35, 55, 95, 27, 39, 27, 52, 35, 90, 88, 13, 4, 60, 61, 6, 31, 67]
  [87, 91, 85, 29, 67, 5, 10, 56, 38, 77, 97, 20, 60, 19, 4, 66, 40, 39, 17, 46, 98, 18, 73, 4, 44, 76, 24, 59, 7, 45, 23, 22, 37, 61, 85, 38, 77, 52, 93, 9, 81, 78, 92, 78, 49, 46, 29, 31, 28, 2]
  [88, 1, 23, 22, 92, 68, 64, 17, 24, 28, 55, 1, 67, 94, 58, 90, 39, 91, 34, 78, 62, 93, 13, 44, 66, 79, 36, 55, 28, 22, 45, 93, 95, 47, 18, 24, 36, 45, 45, 23, 56, 24, 92, 11, 77, 8, 95, 52, 92, 99]
  [81, 5, 89, 41, 35, 99, 37, 84, 58, 26, 22, 87, 19, 20, 33, 74, 24, 17, 91, 1, 95, 23, 34, 49, 68, 54, 77, 72, 97, 61, 81, 92, 5, 4, 84, 66, 38, 49, 68, 23, 14, 96, 61, 80, 41, 73, 3, 67, 100, 65]
  [28, 60, 49, 80, 51, 6, 43, 91, 95, 30, 96, 64, 18, 83, 38, 48, 49, 24, 37, 93, 98, 69, 24, 20, 34, 33, 55, 41, 2, 87, 36, 67, 73, 86, 12, 10, 32, 81, 65, 43, 94, 50, 4, 71, 89, 54, 92, 88, 58, 10]
  [26, 51, 4, 23, 11, 55, 13, 52, 75, 43, 37, 68, 98, 50, 2, 81, 39, 25, 2, 51, 66, 81, 16, 34, 43, 2, 85, 72, 5, 54, 65, 69, 62, 17, 83, 46, 19, 70, 7, 43, 19, 93, 72, 41, 98, 82, 57, 21, 18, 100]
  [84, 16, 85, 50, 62, 54, 95, 63, 55, 23, 32, 87, 37, 42, 75, 46, 64, 91, 46, 75, 58, 59, 78, 86, 85, 93, 80, 13, 90, 3, 2, 67, 21, 56, 16, 19, 92, 10, 81, 42, 82, 84, 39, 87, 6, 31, 99, 52, 41, 85]
  [2, 84, 47, 70, 2, 11, 66, 34, 43, 38, 35, 30, 46, 33, 22, 13, 85, 44, 44, 17, 59, 35, 90, 1, 41, 92, 54, 89, 28, 45, 33, 12, 1, 98, 36, 63, 16, 86, 29, 1, 80, 89, 100, 12, 80, 23, 38, 97, 45, 70]
  [92, 16, 56, 98, 69, 10, 52, 81, 19, 40, 4, 83, 68, 41, 68, 12, 27, 65, 58, 20, 53, 88, 46, 49, 84, 95, 8, 48, 52, 20, 1, 52, 17, 6, 13, 18, 28, 72, 67, 1, 24, 16, 21, 53, 93, 67, 73, 51, 55, 89]
  [44, 2, 48, 90, 53, 92, 23, 16, 23, 97, 8, 54, 57, 99, 6, 9, 67, 12, 77, 37, 66, 19, 35, 28, 57, 77, 8, 82, 100, 26, 94, 11, 56, 11, 48, 82, 82, 47, 61, 80, 55, 59, 52, 8, 94, 47, 82, 51, 50, 53]
  [27, 32, 44, 1, 45, 53, 37, 43, 27, 67, 25, 20, 98, 61, 58, 52, 24, 23, 28, 92, 38, 68, 41, 60, 10, 41, 62, 52, 47, 74, 17, 21, 17, 76, 65, 12, 73, 56, 11, 61, 59, 17, 29, 96, 65, 51, 35, 20, 23, 76]
  [71, 62, 13, 62, 22, 37, 79, 93, 9, 15, 64, 71, 96, 73, 72, 16, 43, 45, 4, 26, 63, 40, 21, 78, 38, 30, 21, 21, 53, 86, 40, 63, 61, 96, 7, 1, 59, 26, 54, 37, 28, 29, 53, 48, 67, 44, 77, 93, 47, 75]
  [38, 46, 47, 99, 71, 24, 79, 71, 37, 13, 54, 6, 2, 40, 41, 97, 74, 58, 86, 83, 71, 69, 27, 44, 17, 6, 62, 74, 82, 27, 28, 31, 78, 82, 38, 93, 67, 48, 69, 22, 60, 65, 67, 64, 87, 97, 86, 24, 90, 48]
  [70, 29, 81, 9, 33, 69, 93, 53, 92, 53, 30, 34, 78, 5, 30, 2, 25, 72, 54, 81, 24, 52, 85, 40, 47, 28, 67, 84, 73, 8, 74, 54, 18, 11, 48, 35, 12, 93, 25, 41, 98, 1, 8, 61, 7, 76, 39, 17, 9, 59]
  [69, 37, 99, 30, 34, 67, 42, 39, 68, 63, 71, 89, 36, 79, 87, 4, 69, 43, 21, 26, 68, 22, 29, 58, 32, 55, 47, 63, 42, 46, 41, 56, 79, 87, 43, 78, 71, 18, 79, 24, 66, 82, 59, 82, 38, 31, 37, 21, 20, 23]
  [76, 76, 7, 38, 44, 20, 40, 42, 84, 1, 54, 9, 81, 75, 40, 46, 90, 62, 43, 7, 77, 31, 97, 79, 70, 71, 94, 21, 97, 64, 33, 72, 54, 42, 14, 26, 35, 80, 30, 50, 13, 47, 68, 42, 78, 97, 81, 99, 67, 96]
  [39, 6, 91, 90, 6, 5, 54, 16, 89, 96, 62, 83, 86, 23, 19, 37, 18, 60, 84, 2, 7, 42, 17, 3, 92, 40, 77, 44, 13, 42, 35, 77, 78, 1, 73, 5, 5, 75, 75, 1, 17, 91, 13, 77, 31, 4, 64, 33, 7, 4]
  [36, 28, 63, 80, 68, 74, 2, 23, 57, 94, 64, 54, 41, 44, 25, 60, 62, 57, 67, 46, 27, 92, 55, 9, 64, 9, 37, 18, 91, 31, 54, 2, 1, 95, 82, 14, 65, 37, 25, 28, 84, 5, 38, 88, 14, 62, 22, 30, 98, 51]
]
B : [ 7, 33, 15, 20, 5, 13, 21, 13, 23, 3, 14, 29, 14, 34, 39, 30, 40, 36, 23, 7, 8, 22, 17, 2, 35, 31, 13 ]
C : [ 27, 32, 1, 1, 27, 25, 9, 9, 34, 1, 11, 18, 31, 2, 11, 19, 27, 3, 14, 3, 36, 1, 23, 12, 16, 24, 3 ]
D : [ 7, 39, 33, 25, 11, 23, 28, 29, 29, 38, 28, 43, 40, 38, 43, 32, 44, 39, 25, 20, 11, 43, 33, 45, 44, 31, 35 ]
E : [ 29, 38, 29, 35, 49, 34, 19, 29, 35, 5, 31, 28, 43, 31, 22, 50, 43, 10, 34, 23, 43, 10, 25, 46, 40, 27, 4 ]
	
	 *139 2135 28367 10833 8345 5521 4440 18402 562 9057 16304 8426 17499 7309 3011 5227 4286 1514 2897 15116 1682 10889 2549 77934 11709 248 2279 
	 */

}
