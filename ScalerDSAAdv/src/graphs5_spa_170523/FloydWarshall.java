package graphs5_spa_170523;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/70954/assignment/problems/4699?navref=cl_tt_lst_nm
public class FloydWarshall {

	public long[][] findVal(int[][] A, int nodes) {
		long[][] adj=new long[nodes][nodes];
		for(int i=0; i<nodes; i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<A.length; i++) {
			adj[A[i][0]][A[i][1]] = A[i][2];
		}
		for(int i=0; i<nodes; i++) {
			adj[i][i]=0;
		}
		printArray(adj);
		for(int k=0; k<adj.length; k++) {
			for(int i=0; i<adj.length; i++) {
				for(int j=0; j<adj.length; j++) {
					if(i==j || i==k || j==k) continue;
					adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
				}
			}
		}
		return adj;
	}
	public int[][] findVal2(int[][] A) { // modified as per assignment
		// will use same A and not create adj Matrix
		int[][] adj = A;
		printArray(adj);
		for(int k=0; k<adj.length; k++) {
			for(int i=0; i<adj.length; i++) {
				for(int j=0; j<adj.length; j++) {
					if(i==j || i==k || j==k || adj[i][k] == -1
							|| adj[k][j] == -1) continue;
					if(adj[i][j]==-1 || adj[i][j]>(adj[i][k]+adj[k][j])) {
						adj[i][j]=adj[i][k]+adj[k][j];
					}
				}
			}
		}
		return adj;
	}
	public void	printArray(int [][]A){
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				System.out.print(A[i][j]+" ");
			} System.out.println();
		}
	}
	public void	printArray(long [][]A){
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				System.out.print(A[i][j]+" ");
			} System.out.println();
		}
	}
	public int[][] solveScalerSol(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = 100000005;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][k] + A[k][j] < A[i][j]) {
                        A[i][j] = A[i][k] + A[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 100000005) {
                    A[i][j] = -1;
                }
            }
        }
        return A;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FloydWarshall fw = new FloydWarshall();
		int[][] A = {{0,1,9},{1,0,6},{0,2,-4},{2,1,5},{1,3,2},{3,2,1}};
		long[][] B = fw.findVal(A, 4);
		fw.printArray(B);
		int[][] X = {{0 , 50 , 39}, {-1 , 0 , 1}, {-1 , 10 , 0}};
		int[][] Y= fw.findVal2(X);
		/* 0 49 39 
		   -1 0 1 
		   -1 10 0  */
		fw.printArray(Y);
		int[][] Z = {{0,5,-1,10}, {-1,0,3,-1}, {-1,-1,0,1}, {-1,-1,-1,0}};
		int[][] ZZ = fw.findVal2(Z);
		fw.printArray(ZZ);
		/*
		 * 0 5 8 9 
-1 0 3 4 
-1 -1 0 1 
-1 -1 -1 0 


		 */
	}

}
