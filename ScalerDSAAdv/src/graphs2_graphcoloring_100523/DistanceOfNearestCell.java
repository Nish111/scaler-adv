package graphs2_graphcoloring_100523;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/70951/homework/problems/4705/?navref=cl_pb_nv_tb
public class DistanceOfNearestCell {
    class Pair {
        int x, y;
        Pair(int i, int j) {
            x = i;
            y = j;
        }
    }
    int[] arr1 = {-1,1,0,0};
    int[] arr2 = {0,0,-1,1};
    public int[][] solve(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] dis = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(A[i][j]==1) queue.add(new Pair(i,j));
            }
        }
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            for(int i=0; i<4; i++) {
                int xx = pair.x+arr1[i];
                int yy = pair.y+arr2[i];
                if(xx>=0 && xx<n && yy>=0 && yy<m && A[xx][yy]==0) {
                    queue.add(new Pair(xx,yy));
                    A[xx][yy] = 2;
                    dis[xx][yy] = 1+dis[pair.x][pair.y];
                }
            }
        }
        return dis;
    }
    static int inf = 99999999;
    static int[] dxx = new int[] {0, 1, 0, -1};
    static int[] dyy = new int[] {1, 0, -1, 0};
    public int[][] solveScalerSol(int[][] A) {
      return solveItScalerSol(A);
    }
    public static int[][] solveItScalerSol(int[][] A) {
      int n = A.length;
      int m = A[0].length;
      Queue < Pair1 > q = new ArrayDeque < Pair1 > ();
      int[][] distance = new int[n][m];
      for (int[] row: distance)
        Arrays.fill(row, inf);
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
          if (A[i][j] == 1) {
            distance[i][j] = 0;
            q.offer(new Pair1(i, j));
          }
        }
      }
      int x, y;
      while (q.size() > 0) {
        Pair1 p = q.poll();
        x = p.ff;
        y = p.ss;
        int dx, dy;
        for (int k = 0; k < 4; ++k) {
          dx = x + dxx[k];
          dy = y + dyy[k];
          if (dx >= 0 && dx < n && dy >= 0 && dy < m && distance[dx][dy] > distance[x][y] + 1) {
            distance[dx][dy] = distance[x][y] + 1;
            q.offer(new Pair1(dx, dy));
          }
        }
      }
      return distance;
    }
  }
class Pair1 {
	  int ff;
	  int ss;
	  public Pair1(int a, int b) {
	    this.ff = a;
	    this.ss = b;
	  }
	}