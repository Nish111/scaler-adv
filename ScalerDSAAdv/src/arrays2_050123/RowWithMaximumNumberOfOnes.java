package arrays2_050123;
// https://www.scaler.com/academy/mentee-dashboard/class/50127/homework/problems/5784/submissions
public class RowWithMaximumNumberOfOnes {

	public int solve(int[][] A) {
		int count=0;
		int index=0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			count=0;
			for(int j=0; j<A[0].length; j++) {
				if(A[i][j]==1) count++;
			}
			//System.out.println(count + " "+i);
			if(count>max) {
				max = count;
				index = i;
			}
		}
	    return index;
	}
	public int solveScalerSol(int[][] A) {
        int n = A.length;
        int ans = 0, i, j;
        for (i = 0, j = n - 1; i < n && j >= 0; i++){
            while(A[i][j] == 1 && j >= 0){
                ans = i;
                j--;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RowWithMaximumNumberOfOnes rwmno = new RowWithMaximumNumberOfOnes();
		int[][] A = {{0, 1, 1}, {0, 0, 1}, {0, 1, 1}};
		int[][] B = {{0, 0, 0, 0}, {0, 1, 1, 1}};
		System.out.println(rwmno.solve(A));
		System.out.println(rwmno.solve(B));
	}

}
