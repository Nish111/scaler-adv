package arrays2_050123;
// https://www.scaler.com/academy/mentee-dashboard/class/50127/homework/problems/11866/?navref=cl_pb_nv_tb
public class MaximumSUMSquareSubMatrix {

	public int solve(int[][] A, int B) {
		int[][] pf = new int[A.length][A[0].length];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				if(j==0) pf[i][j] = A[i][j];
				else {
					pf[i][j] = pf[i][j-1] + A[i][j];
				}
			}
		}
		for(int j=0; j<A.length; j++) {
			for(int i=0; i<A.length; i++) {
				if(i != 0) pf[i][j] = pf[i][j] + pf[i-1][j];
			}
		}
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				if((i+B-1) <A.length && (j+B-1)<A.length) {
					int sum = pf[i+B-1][j+B-1];
					if(j>0) sum = sum-pf[i+B-1][j-1];
					if(i>0) sum = sum -pf[i-1][j+B-1];
					if(i>0 && j>0) sum += pf[i-1][j-1];
					max = Math.max(max, sum);
				}
			}
		}
		return max;
	}
	int maxn = 1009;
    int[][] stripSum=new int[maxn][maxn];
	public void getStripSumScalerSol(int[][] A, int B){
        int N = A.length;
        // To store sums of all strips of size B x 1
        for(int i = 0; i < maxn; i++)
            for(int j = 0; j < maxn; j++)
                stripSum[i][j] = 0;
        
        // Go column by column
        for (int j = 0; j < N; j++) {
            // Calculate sum of first B x 1 rectangle in this column
            int sum = 0;
            for (int i = 0; i < B; i++)
                sum += A[i][j];
            stripSum[0][j] = sum;
            
            // Calculate sum of remaining rectangles
            for (int i = 1; i < N - B + 1; i++) {
                sum += (A[i + B - 1][j] - A[i - 1][j]);
                stripSum[i][j] = sum;
            }
        }
    }
    public int solveScalerSol(int[][] A, int B) {
        int N = A.length;
        // B must be smaller than or equal to N
        if (B > N) return 0;
        
        // 1: PREPROCESSING
        getStripSumScalerSol(A, B);
        
        // max_sum stores maximum sum in matrix
        int max_sum = Integer.MIN_VALUE;
        
        // 2: CALCULATE SUM of Sub-Squares using stripSum[][]
        for (int i = 0; i < N - B + 1; i++) {
            // Calculate sum of first subsquare in this row
            int sum = 0;
            for (int j = 0; j < B; j++)
                sum += stripSum[i][j];
                
            // Update max_sum
            if (sum > max_sum) {
                max_sum = sum;
            }
            
            // Calculate sum of remaining squares in current row by removing
            // the leftmost strip of previous sub-square and adding a new strip
            for (int j = 1; j < N - B + 1; j++) {
                sum += (stripSum[i][j + B - 1] - stripSum[i][j - 1]);
                // Update max_sum
                if (sum > max_sum) {
                    max_sum = sum;
                }
            }
        }
        return max_sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSUMSquareSubMatrix mssm = new MaximumSUMSquareSubMatrix();
		int[][] A = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 8, 6, 7, 3},
				{4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}};
		System.out.println(mssm.solve(A, 3)); // 48
		int[][] B = {{2,2}, {2,2}};
		System.out.println(mssm.solve(B, 2)); // 8
	}

}
