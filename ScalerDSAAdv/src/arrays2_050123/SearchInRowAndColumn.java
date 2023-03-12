package arrays2_050123;

public class SearchInRowAndColumn {

	public int solve(int[][] A, int B) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				if(A[i][j]==B) return (i+1)*1009+(j+1);
			}
		}
		return -1;
	}
	public int solveScalerSol(int[][] A, int B) {
        int n = A.length, m = A[0].length;
        int i = 0 , j = m - 1, ans = -1;
        while(i < n && j >= 0){
            if(A[i][j] > B){
                j--;
            }
            else if(A[i][j] < B){
                i++;
            }
            else{
                for(int k = j ; k >= 0 ; k--){
                    if(A[i][k] == B){
                        ans = ((i + 1) * 1009 + (k + 1));
                    }
                }
                break;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInRowAndColumn src = new SearchInRowAndColumn();
		int[][] A = {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println(src.solve(A, 2)); // 1011
	}

}
