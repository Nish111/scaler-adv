package graphs4_mst_160523;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/85791/assignment/problems/208/?navref=cl_pb_nv_tb
public class CaptureRegionsOnBoard {

	int[] x = {-1,1,0,0};
    int[] y = {0,0,1,-1};
	public void solve(ArrayList<ArrayList<Character>> a) {
		int n = a.size(), m = a.get(0).size();
        if(m==1 && n==1) return;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair4A> queue = new LinkedList<>();
        for(int i=0; i<m-1; i++) if(a.get(0).get(i)=='O') queue.add(new Pair4A(0,i));
        for(int i=0; i<n-1; i++) if(a.get(i).get(m-1)=='O') queue.add(new Pair4A(i,m-1));
        for(int i=m-1; i>0; i--) if(a.get(n-1).get(i)=='O') queue.add(new Pair4A(n-1,i));
        for(int i=n-1; i>0; i--) if(a.get(i).get(0)=='O') queue.add(new Pair4A(i,0));
        while(!queue.isEmpty()) {
            Pair4A pair = queue.poll();
            vis[pair.x][pair.y] = true;
            for(int i=0; i<4; i++) {
                int xx = pair.x + x[i];
                int yy = pair.y + y[i];
                if(xx>=0 && xx<n && yy>=0 && yy<m && !vis[xx][yy] && a.get(xx).get(yy)=='O') {
                    queue.add(new Pair4A(xx,yy));
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(a.get(i).get(j)=='O' && !vis[i][j]) a.get(i).set(j,'X');
            }
        }
	}
	public void solve(char[][] a) {
		int n = a.length, m = a[0].length;
        if(m==1 && n==1) return;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair4A> queue = new LinkedList<>();
        for(int i=0; i<m-1; i++) if(a[0][i]=='O') queue.add(new Pair4A(0,i));
        for(int i=m-1; i>0; i--) if(a[n-1][i]=='O') queue.add(new Pair4A(n-1,i));
        for(int i=n-1; i>0; i--) if(a[i][0]=='O') queue.add(new Pair4A(i,0));
        while(!queue.isEmpty()) {
            Pair4A pair = queue.poll();
            vis[pair.x][pair.y] = true;
            for(int i=0; i<4; i++) {
                int xx = pair.x + x[i];
                int yy = pair.y + y[i];
                if(xx>=0 && xx<n && yy>=0 && yy<m && !vis[xx][yy] && a[xx][yy]=='O') {
                    queue.add(new Pair4A(xx,yy));
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(a[i][j]=='O' && !vis[i][j]) a[i][j]='X';
            }
        }
		
	}
	public void printArray(char[][] A){
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	private boolean[][] marked;
	  private int di[] = new int[] {1, -1, 0, 0};
	  private int dj[] = new int[] {0, 0, 1, -1};
	  private int m, n;
	  private ArrayList < ArrayList < Character >> A;

	  public void solveScalerSol(ArrayList < ArrayList < Character >> A) {
	    if (A == null)
	      return;
	    m = A.size();
	    n = A.get(0).size();
	    if (m == 0)
	      return;

	    marked = new boolean[m][n];
	    this.A = A;

	    // First and last row
	    for (int i = 0; i < n; i++) {
	      char c = A.get(0).get(i);
	      if (c == 'O')
	        dfsScalerSol(0, i);
	      c = A.get(m - 1).get(i);
	      if (c == 'O')
	        dfsScalerSol(m - 1, i);
	    }

	    // First and last column
	    for (int i = 0; i < m; i++) {
	      char c = A.get(i).get(0);
	      if (c == 'O')
	        dfsScalerSol(i, 0);
	      c = A.get(i).get(n - 1);
	      if (c == 'O')
	        dfsScalerSol(i, n - 1);
	    }

	    for (int i = 0; i < m; i++) {
	      for (int j = 0; j < n; j++) {
	        if (!marked[i][j])
	          A.get(i).set(j, 'X');
	      }
	    }

	  }

	  public void dfsScalerSol(int row, int col) {

	    marked[row][col] = true;
	    int nRow, nCol;

	    for (int k = 0; k < 4; k++) {
	      nRow = row + di[k];
	      nCol = col + dj[k];

	      if (isValidScalerSol(nRow, nCol) && !marked[nRow][nCol] && A.get(nRow).get(nCol) == 'O') {
	        dfsScalerSol(nRow, nCol);
	      }
	    }

	  }

	  private boolean isValidScalerSol(int row, int col) {
	    if (row < 0 || row >= m || col < 0 || col >= n)
	      return false;

	    return true;
	  }
	public static void main(String[] args) {
		// T'O'D'O' Auto-generated method stub
		CaptureRegionsOnBoard cr = new CaptureRegionsOnBoard();
		ArrayList<ArrayList<Character>>  A = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> a = new ArrayList<>();
		a.add('X'); a.add('X'); a.add('X'); a.add('X');
		A.add(a);
		ArrayList<Character> b = new ArrayList<>();
		b.add('X'); b.add('O'); b.add('O'); b.add('X');
		A.add(b);
		ArrayList<Character> c = new ArrayList<>();
		c.add('X'); c.add('X'); c.add('O'); c.add('X');
		A.add(c);
		ArrayList<Character> d = new ArrayList<>();
		d.add('X'); d.add('O'); d.add('X'); d.add('X');
		A.add(d);
		cr.solve(A);
		char[][] B = {{'X', 'O', 'O'}, {'X', 'O', 'X'}, {'O', 'O', 'O'}};
		cr.solve(B);
		cr.printArray(B);
		char[][] C = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, 
				{'X', 'O', 'X', 'X'}};
		cr.solve(C);
		cr.printArray(C);
	}
}
class Pair4A {
    int x,y;
    Pair4A(int i, int j) {
        x=i;
        y=j;
    }
}
