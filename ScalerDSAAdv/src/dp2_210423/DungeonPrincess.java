package dp2_210423;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/70944/assignment/problems/8?navref=cl_tt_lst_sl
public class DungeonPrincess {

	
	public int findWaysBU(int[][] A) { // working correctly
		 int n = A.length;
	     int m = A[0].length;
	     int dp[][] = new int[n+1][m + 1];
	     for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(i == n - 1 && j == m - 1){
                    dp[i][j] = Math.min(0, A[i][j]);
                }
                else if(i == n - 1){
                    dp[i][j] = Math.min(0, A[i][j] + dp[i][j + 1]);
                    //if(i==1 && j==2) System.out.println("this is val "+dp[i][j + 1]);
                }
                else if(j == m - 1){
                    dp[i][j] = Math.min(0,A[i][j] + dp[i+1][j]);
                }
                else{
                    dp[i][j] = Math.min(0, A[i][j] + Math.max(dp[i+1][j], dp[i][j + 1]));
                }
                //System.out.println("this is "+i);
                //printArray(dp);
            }
        }
        printArray(dp);
        return Math.abs(dp[0][0]) + 1;
	}
	  public int calculateMinimumHP(int[][] A) {
	        int n = A.length;
	        int m = A[0].length;
	        int dp[] = new int[m];
	        printArray(A);
	        //filling dp from bottom left to top right

	        if(A[n-1][m-1] <= 0)
	            dp[m-1] = (A[n-1][m-1] * -1) + 1;
	        else
	            dp[m-1] = 1;
	        printArraydp(dp);
	        //filling last row
	        for(int i = m-2; i >=0; i--){
	            int val = A[n-1][i];
	            int hpNeed = dp[i + 1] - val;
	            if(hpNeed <= 0)
	                dp[i] = 1;
	            else
	                dp[i] = hpNeed;
	        }
	        printArraydp(dp);
	        //rest of the rows
	        for(int i = n-2; i >= 0; i--){
	            //creating a right boundary for last column and updating it for rest of columns
	            int rightBoundary = 99999;
	            for(int j = m-1; j >= 0; j--){
	                int right = rightBoundary + (A[i][j] * -1);
	                int down = dp[j] + (A[i][j] * -1);
	                int hpNeed = Math.min(right, down);
	                if(hpNeed <= 0)
	                    dp[j] = 1;
	                else
	                    dp[j] = hpNeed;
	                rightBoundary = dp[j];
	            }
	        }
	        printArraydp(dp);
	        return dp[0];
	    }
	  public void printArraydp(int[] A) {
			for(int i=0; i<A.length; i++) {
					System.out.print(A[i]+" ");
				}
				System.out.println();
		}
	  public int calculateMinimumHP2(int[][] A) {
	        int n = A.length;
	        int m = A[0].length;
	        int dp[] = new int[m + 1];
	        for(int i = n - 1; i >= 0; i--){
	            int curr[] = new int[m+1];
	            for(int j = m - 1; j >= 0; j--){
	                if(i == n - 1 && j == m - 1){
	                    curr[j] = Math.min(0, A[i][j]);
	                }
	                else if(i == n - 1){
	                    curr[j] = Math.min(0, A[i][j] + curr[j + 1]);
	                }
	                else if(j == m - 1){
	                    curr[j] = Math.min(0,A[i][j] + dp[j]);
	                }
	               
	                else{
	                    curr[j] = Math.min(0, A[i][j] + Math.max(dp[j], curr[j + 1]));
	                }
	                //System.out.println("this is curr "+ i);
	                //printArraydp(curr);
	            }
	            dp = curr;
	            //printArraydp(dp);
	        }
	        printArraydp(dp);
	        return Math.abs(dp[0]) + 1;
	    }
	  int dp[][];
	    ArrayList < ArrayList < Integer >> A;
	    int m, n;
	    public int calculateMinimumHPScalerSol(ArrayList < ArrayList < Integer >> A) {
	        if (A == null)
	            return 0;
	        m = A.size();
	        n = A.get(0).size();
	        dp = new int[m][n];
	        this.A = A;
	        for (int i = 0; i < m; i++)
	            Arrays.fill(dp[i], -1);
	        recScalerSol(0, 0);
	        if (dp[0][0] <= 0)
	            return 1;
	        return dp[0][0];
	    }

	    public int recScalerSol(int row, int col) {
	        if (row == m - 1 && col == n - 1) {
	            int num = A.get(row).get(col);
	            if (num < 0)
	                return 1 - num;
	            else
	                return 1;
	        }
	        if (dp[row][col] != -1)
	            return dp[row][col];
	        int max = Integer.MAX_VALUE;
	        int num = A.get(row).get(col);
	        if (isValidScalerSol(row + 1, col)) {
	            max = recScalerSol(row + 1, col);
	            max -= num;
	            max = Math.max(1, max);
	        }
	        if (isValidScalerSol(row, col + 1)) {
	            int temp = recScalerSol(row, col + 1);
	            temp -= num;
	            temp = Math.max(1, temp);
	            max = Math.min(temp, max);
	        }
	        return dp[row][col] = max;
	    }

	    public boolean isValidScalerSol(int row, int col) {
	        if (row < 0 || row >= m || col < 0 || col >= n)
	            return false;
	        return true;
	    }
	public void printArray(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DungeonPrincess wtr = new DungeonPrincess();
		int[][] A = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
		//System.out.println(wtr.findWaysToReach(A)); // 35
		wtr.printArray(A);
		System.out.println(wtr.findWaysBU(A)); // 2
		//System.out.println(wtr.calculateMinimumHP(A));
		System.out.println("Second method");
		System.out.println(wtr.calculateMinimumHP2(A));
		int[][] B = {{1, -1, 0}, {-1, 1, -1}, {1, 0, -1}};
		wtr.printArray(B);
		System.out.println(wtr.findWaysBU(B)); // 35
		System.out.println(wtr.calculateMinimumHP2(B)); // 0
	}

}
