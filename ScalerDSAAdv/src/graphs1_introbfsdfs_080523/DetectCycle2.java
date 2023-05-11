package graphs1_introbfsdfs_080523;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/70950/assignment/problems/9327?navref=cl_tt_lst_sl
public class DetectCycle2 {

	//------ not working
	// Arraylist ones was working
	int flag;

	public void checkFinal(int[][] adj, int[] visited, int i) { // works but hard fails
		// memory space
		// so need array list
		visited[i] = 1;
		for (int j = 0; j < adj[i].length; j++) {
			if(adj[i][j]==1) {
				int temp=j;
				if (visited[temp] == -1)
					checkFinal(adj, visited, temp);
				else if (visited[temp] == 1)
					flag = 1;
			}
			
		}
		visited[i] = 2;
	}

	public int solveFinal(int A, int[][] B) {
		int visited[] = new int[A + 1];
		Arrays.fill(visited, -1);
		int[][] adj = new int[A + 1][A + 1];

		for (int i = 0; i < B.length; i++) {
			adj[B[i][0]][B[i][1]] = 1;
		}
		for (int i = 1; i <= A; i++) {
			if (visited[i] == -1) {
				flag = 0;
				checkFinal(adj, visited, i);
				if (flag == 1)
					return 1;
			}
		}
		return 0;
   }
	// working as arraylist
	int isCycle;
    public void check2(ArrayList<Integer> adj[] , int[] visited ,int node){
    	visited[node]=1;
      for(int i=0;i<adj[node].size();i++){
          int temp=adj[node].get(i);
           if(visited[temp]==-1)
             check2(adj,visited,temp);
            else if(visited[temp]==1)
            	isCycle=1;
             }
      visited[node]=2;
        }
   public int solve2(int A, int[][] B) {
      int visited[]=new int[A+1];
      Arrays.fill(visited,-1);
      ArrayList<Integer> adj[]=new ArrayList[A+1];
        for(int i=0;i<=A;i++){
        	adj[i]=new ArrayList<>();
      }
       for(int i=0;i<B.length;i++){
    	   adj[B[i][0]].add(B[i][1]);
      }
       for(int i=1;i<=A;i++){
          if(visited[i]==-1){
        	  isCycle=0;
          check2(adj,visited,i);
          if(isCycle==1)
          return 1;
          }
       }
     return 0;
   }
   static int maxn = 100009;
   static ArrayList < ArrayList < Integer > > adj;
   static int[] visited = new int[maxn];
   static int[] recStack = new int[maxn];
   public static void graphScalerSol() {
       adj = new ArrayList < ArrayList < Integer > > (maxn);
       for (int i = 0; i < maxn; i++) {
           visited[i] = 0;
           recStack[i] = 0;
           adj.add(new ArrayList < Integer > ());
       }
   }
   public int solveScalerSol(int A, int[][] B) {
       graphScalerSol();
       for (int[] row: B)
           adj.get(row[0]).add(row[1]);
       int flag = 0;
       for (int i = 1; i <= A; i++) {
           if (visited[i] == 0 && isCyclicUtilScalerSol(i) == true)
               return 1;
       }
       return 0;
   }
   public static boolean isCyclicUtilScalerSol(int v) {
       if (visited[v] == 0) {
           // Mark the current node as visited and part of recursion stack
           visited[v] = 1;
           recStack[v] = 1;
           // Recur for all the vertices adjacent to this vertex
           for (int u: adj.get(v)) {
               if (visited[u] == 0 && isCyclicUtilScalerSol(u) == true)
                   return true;
               else if (recStack[u] == 1)
                   return true;
           }
       }
       recStack[v] = 0; // remove the vertex from recursion stack
       return false;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectCycle2 dc = new DetectCycle2();
		int[][] B = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2},{1, 3}};
		System.out.println(dc.solve2(5, B)); // 1
		System.out.println(dc.solveFinal(5, B)); // 1
		int[][] C = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		System.out.println(dc.solve2(5, C)); // 0
		System.out.println(dc.solveFinal(5, C)); // 0
		int[][] D = {{1,3},{2,3},{3,2}};
		System.out.println(dc.solve2(3, D)); // 1
		System.out.println(dc.solveFinal(3, D)); // 1
		int[][] E = {{1,2}, {1,3}, {2,3}, {1,4}, {4,3}, {4,5}, {3,5}};
		System.out.println(dc.solve2(5, E)); // 0
		System.out.println(dc.solveFinal(5, E)); // 0
	}

}
