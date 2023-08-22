package graphs5_spa_170523;

import java.util.ArrayList;
import java.util.Collections;
// https://www.scaler.com/academy/mentee-dashboard/class/70954/homework/problems/5706/?navref=cl_pb_nv_tb
public class MatrixAndAbsoluteDifference {
	class Edge {
        int x,y,w;
        Edge(int i, int j, int weight) {
            x=i;
            y=j;
            w=weight;
        }
    }
    public int solve(int A, int B, int[][] C) {
        int n = A*B;
        int[] par = new int[n];
        ArrayList<Edge> edges = new ArrayList<>();
        int[] dx = {0,1};
        int[] dy = {1,0};
        for(int i=0; i<A; i++) {
            for(int j=0; j<B; j++) {
                for(int k=0; k<2; k++) {
                    int xx = i+dx[k];
                    int yy = j+dy[k];
                    if(xx<A && yy<B) edges.add(new Edge(i*B+j, xx*B+yy, Math.abs(C[xx][yy]-C[i][j])));
                }
            }
        }
        for(int i=1; i<n; i++) par[i]=i;
        int ans = 0, cnt = 0;
        Collections.sort(edges, (a,b) -> a.w-b.w);
        for(int i=0; i<edges.size(); i++) {
            int a = getRoot(edges.get(i).x,par);
            int b = getRoot(edges.get(i).y,par);
            if(a!=b) {
                par[a]=b;
                cnt++;
                ans = Math.max(ans,edges.get(i).w);
            }
        }
        return ans;
    }
    public int getRoot(int x, int[] par) {
        if(x==par[x]) return x;
        int ans = getRoot(par[x],par);
        par[x] = ans;
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixAndAbsoluteDifference mad = new MatrixAndAbsoluteDifference();
		int A = 3; int B = 3;  
		int[][] C = {{1, 5, 6}, {10, 7, 2}, {3, 6, 9}};
	    System.out.println(mad.solve(A, B, C)); // 4
	}

}
