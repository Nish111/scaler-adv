package contest_050823;

import java.util.ArrayList;
// https://www.scaler.com/test/97de52ecc3/#/problem_2
public class LongestPath {
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size(), ans = 0;
		int[][][] aux = new int[n][m][4];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				for(int k=0; k<4; k++) aux[i][j][k] = A.get(i).get(j);
				if(A.get(i).get(j) == 0) continue;
				if(i>0) aux[i][j][0] += aux[i-1][j][0];
				if(j>0) aux[i][j][1] += aux[i][j-1][1];
				if(i>0 && j>0) aux[i][j][2] += aux[i-1][j-1][2];
				if(i>0 && j <m-1) aux[i][j][3] += aux[i-1][j+1][3];
				for(int k=0; k<4; k++) ans = Math.max(ans, aux[i][j][k]);
			}
		}
		return ans;

    }
    
}

