package arrays2_050123;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50127/assignment/problems/4091/hints?navref=cl_pb_nv_tb
public class Sumcontri {

	public int sumContri(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int contri = (i+1)*(j+1)*(m-j)*(n-i);
				sum += contri*A[i][j];
			}
		}
		return sum;
	}
	public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // Number of sub matrices contain A[i][j]
                int times = (i + 1) * (j + 1) * (n - i) * (n - j);
                sum += times * A.get(i).get(j);
            }
        }
        return sum;
    }

//Approach 2: Works only with given contraints

    public int solve(int[][] A) {
        int n = A.length;
        int sum = 0;
        int preSum[][] = new int[n + 1][n + 1];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n; j++){
                preSum[i][j] = A[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = i; k <= n; k++){
                    for(int l = j; l <= n; l++){
                        sum += preSum[k][l] - preSum[k][j - 1] - preSum[i - 1][l] + preSum[i - 1][j - 1];
                    }
                }
            }
        }
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sumcontri sc = new Sumcontri();
		int[][] A = {{3,1}, {-1,-2}, {2,4}};
		System.out.println(sc.sumContri(A)); // 36
	}

}
