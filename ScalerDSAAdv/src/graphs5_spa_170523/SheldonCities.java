package graphs5_spa_170523;

import java.util.ArrayList;
import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/70954/homework/problems/447/?navref=cl_pb_nv_tb
public class SheldonCities {

	 public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
	        long dp[][] = new long[A + 1][A + 1];

	        //INITIALISING EVERY DISTANCE WITH INFINITY
	        for (int i = 0; i <= A; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
	        for (int i = 0; i <= A; i++) dp[i][i] = 0;

	        //EDGES INSERTION
	        for (int i = 0; i < B; i++) {
	            dp[D[i]][E[i]] = Math.min(dp[D[i]][E[i]], F[i]);
	            dp[E[i]][D[i]] = Math.min(dp[E[i]][D[i]], F[i]);
	        }

	        //CONSIDERING EVERY VERTEX AS INTERMEDIATE PT BW EACH EDGE
	        for (int i = 1; i <= A; i++) {
	            for (int j = 1; j <= A; j++) {
	                for (int k = 1; k <= A; k++) {
	                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
	                }
	            }
	        }

	        //GETTING QUERRY
	        int ans[] = new int[C];
	        for (int i = 0; i < C; i++) {
	            if (dp[G[i]][H[i]] != Integer.MAX_VALUE) {
	                ans[i] = (int) dp[G[i]][H[i]];
	            } else {
	                ans[i] = -1;
	            }
	        }

	        return ans;
	    }
	 public void printArray(int[] A) {
			for(int i=0; i<A.length; i++) {
				System.out.print(A[i] +" ");
			}
			System.out.println();
		}
	 public ArrayList < Integer > solveScalerSol(int A, int B, int C, ArrayList < Integer > D, ArrayList < Integer > E, ArrayList < Integer > F, ArrayList < Integer > G, ArrayList < Integer > H) {
	        int N = A;
	        int M = B;
	        int Q = C;
	        int[] u = D.stream().mapToInt(i -> i).toArray();
	        int[] v = E.stream().mapToInt(i -> i).toArray();
	        int[] w = F.stream().mapToInt(i -> i).toArray();
	        int[] a = G.stream().mapToInt(i -> i).toArray();
	        int[] b = H.stream().mapToInt(i -> i).toArray();
	        long inf = 1000000000000L;
	        long dp[][] = new long[205][205];
	        int i, j, k;
	        for (i = 0; i < 205; i++) {
	            dp[i][i] = 0;
	            for (j = 0; j < 205; j++) {
	                if (i != j) dp[i][j] = inf;
	            }
	        }
	        for (i = 0; i < M; i++) {
	            int uu = u[i] - 1;
	            int vv = v[i] - 1;
	            dp[uu][vv] = Math.min(dp[uu][vv], (long) w[i]);
	            dp[vv][uu] = Math.min(dp[vv][uu], (long) w[i]);
	        }
	        for (k = 0; k < N; k++) {
	            for (i = 0; i < N; i++) {
	                for (j = 0; j < N; j++) {
	                    if (dp[i][k] + dp[k][j] < dp[i][j])
	                        dp[i][j] = dp[i][k] + dp[k][j];
	                }
	            }
	        }
	        ArrayList < Integer > answer = new ArrayList < Integer > ();
	        for (i = 0; i < Q; i++) {
	            int aa = a[i] - 1;
	            int bb = b[i] - 1;
	            if (dp[aa][bb] == inf) {
	                answer.add(-1);
	            } else {
	                answer.add((int) dp[aa][bb]);
	            }
	        }
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SheldonCities sc = new SheldonCities();
		 int A = 4; int	 B = 6; int C = 2;
		 int[]	 D = {1, 2, 3, 2, 4, 3};
		 int[]	 E = {2, 3, 4, 4, 1, 1};
		 int[]	 F = {4, 1, 1, 1, 1, 1};
		 int[]   G = {1, 1};
	     int[]	 H = {2, 3};
	     int[] X = sc.solve(A, B, C, D, E, F, G, H);
	     sc.printArray(X);
		 int[]  D1 = {1, 2, 1};
		 int[]  E1 = {2, 3, 3};
		 int[]  F1 = {3, 1, 1};
		 int[]  G1 = {2, 1};
		 int[]  H1 = {3, 2};
		 int[] Y = sc.solve(3, 3, 2, D1, E1, F1, G1, H1);
		 sc.printArray(Y);
	}

}
