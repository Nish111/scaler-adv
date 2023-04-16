package backtracking1_120423;

// https://www.scaler.com/academy/mentee-dashboard/class/70941/assignment/problems/4176?navref=cl_tt_nv
public class UniquePath3 {

	public int solution(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int start_i=0, start_j=0;
		int ans=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(A[i][j]==1) {
					start_i=i;
					start_j=j;
					ans++;
				} else if(A[i][j]==0) {
					ans++;
				}
					
			}
		}
		return count(start_i, start_j, n, m, A, 0, ans);
	}
	public int count(int i, int j, int n, int m, int[][] A, int curr, int ans) {
		// TODO Auto-generated method stub
		if(i<0 || i>= n || j<0 || j>=m) {
			return 0;
		}
		if(A[i][j]==2) {
			if(curr==ans) return 1;
			else return 0;
		}
		if(A[i][j]==-1) return 0;
		A[i][j] = -1; // do
		curr++;
		int p1 = count(i, j+1, n, m, A, curr, ans); // right
		int p2 = count(i+1, j, n, m, A, curr, ans); // down
		int p3 = count(i, j-1, n, m, A, curr, ans); // left
		int p4 = count(i-1, j, n, m, A, curr, ans); // up
		A[i][j] = 0; // undo
		return p1+p2+p3+p4;
	}
	int n, m, ans;
    int xx[] = new int[]{1, 0, 0, -1};
    int yy[] = new int[]{0, 1, -1, 0};

    boolean isVScalerSol(int u, int v, int a[][]) {
        // checks if it is possible to walk over the square (u, v)
        return 0 <= u && u < n && 0 <= v && v < m && a[u][v] != -1;
    }

    void recurScalerSol(int x, int y, int cnt, int a[][]) {
        if(a[x][y] == 2) {
            // checks if every non-obstacle square has been covered
            if(cnt == 0)    ans++;
            return;
        }
        a[x][y] = -1;
        // traverse all the directions
        for(int i = 0; i < 4; i++) {
            int u = x + xx[i];
            int v = y + yy[i];
            if(isVScalerSol(u, v, a)) {
                recurScalerSol(u, v, cnt - 1, a);
            }
        }
        a[x][y] = 0;
    }
    public int solveScalerSol(int[][] a) {
        n = a.length;   m = a[0].length;
        ans = 0;
        int u = -1, v = -1, cnt = 0;
        // find starting point and count number of non-obstacle squares
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 1) {
                    u = i;    
                    v = j;
                } else if(a[i][j] == 0)
                    cnt++;
            }
        }
        // Ending square is also counted in cnt so pass cnt + 1
        recurScalerSol(u, v, cnt + 1, a);
        return ans;
    }   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePath3 up = new UniquePath3();
		int[][] A = {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
		System.out.println(up.solution(A)); // 2
	}

}
