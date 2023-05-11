package graphs1_introbfsdfs_080523;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/70950/assignment/problems/9327?navref=cl_tt_lst_nm
public class DetectCycle {

	//------ trying now
	int flag;

	public void checkFinal(int[][] adj, int[] visited, int i) {
		visited[i] = 1;
		for (int j = 0; j < adj[i].length; j++) {
			int temp = adj[i][j];
			if (visited[temp] == -1)
				checkFinal(adj, visited, temp);
			else if (visited[temp] == 1)
				flag = 1;
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
	//--------
	public int solveMine2(int A, int[][] B) { // fails for D
		int[][] adj = new int[A+1][A+1];
		boolean[] visited = new boolean[A+1];
		boolean[] stack = new boolean[A+1];
		for(int i=0; i<B.length; i++) {
			adj[B[i][0]][B[i][1]]=1;
		}
		//printArray(adj);
		for(int i=0; i<A; i++) {
			if(checkDFS2(i, visited, stack, adj, A)) {
				return 1;
			}
		}
		return 0;
	}
	public boolean checkDFS2(int node, boolean[] visited, boolean[] stack, int[][] adj, int A) {
		// TODO Auto-generated method stub
		if(stack[node]) return true; // cycle detected
		if(visited[node]) return false; // node visited
		visited[node]=true;
		stack[node]=true;
		for(int i=0; i<A; i++) {
			if(adj[node][i]==1 && checkDFS2(i, visited, stack, adj, A)) {
					return true;
			}
				
		}
		stack[node]=false;
		return false;
	}
	public int solveMine(int A, int[][] B) { // fails for D
		int[][] adj = new int[A+1][A+1];
		boolean[] visited = new boolean[A+1];
		boolean[] stack = new boolean[A+1];
		for(int i=0; i<B.length; i++) {
			adj[B[i][0]][B[i][1]]=1;
		}
		//printArray(adj);
		for(int i=0; i<A; i++) {
			if(checkDFS(i, visited, stack, adj, A)) {
				return 1;
			}
		}
		return 0;
	}
	public boolean checkDFS(int node, boolean[] visited, boolean[] stack, int[][] adj, int A) {
		// TODO Auto-generated method stub
		if(stack[node]) return true; // cycle detected
		if(visited[node]) return false; // node visited
		visited[node]=true;
		stack[node]=true;
		for(int i=0; i<A; i++) {
			if(adj[node][i]==1 && checkDFS(i, visited, stack, adj, A))
				return true;
		}
		stack[node]=false;
		return false;
	}
	public int detectCycle(int A, int[][] B) { // not working for E
		int[][] adj = new int[A+1][A+1];
		int[] visited = new int[A+1];
		for(int i=0; i<B.length; i++) {
			adj[B[i][0]][B[i][1]]=1;
		}
		//printArray(adj);
		isCycle=0;
		dfs(1, 0,adj, visited);
		for(int j=0; j<visited.length; j++) {
			System.out.print(visited[j]+" ");
		}
		System.out.println();
		
		return isCycle;
	}
	int isCycle=0;
	public void dfs(int node, int parent, int[][] adj, int[] visited) { // not working for E
		//if(visited[node] != 1) return; 
		visited[node] = 1;
		for(int i=0; i<adj[node].length; i++) {
			if(adj[node][i]==1) {
				int child=i;
				if(visited[child] == 1 && child != node) {
					isCycle = 1;
					break;
				}
				else if(visited[child] !=1) {
					dfs(child, node, adj, visited);
				}
			}
		}
		//return false;
	}
	public int solve1(int A, int[][] B)
    {
        int N = B.length;
        ArrayList<Integer>[] mat = new ArrayList[A+1];
        for(int i=1; i<=A; i++) //Instantiate adjacency list
        {
            mat[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<N; i++) //Populate each list as prescribed
        {
            int u = B[i][0];
            int v = B[i][1];
            mat[u].add(v);
        }

        boolean[] vis = new boolean[A+1]; //visited array
        boolean[] isDesc = new boolean[A+1]; //Descendant check

        for(int i=1; i<=A; i++)
        {
            if(Check1(i, mat, vis, isDesc))
            {
                return 1;
            }
        }
        return 0;
    }

    private boolean Check1(int u, ArrayList<Integer>[] mat, boolean[] vis, boolean[] isDesc)
    {
        if(vis[u])
        {
            return false;
        }

        vis[u] = true;
        isDesc[u] = true;
        ArrayList<Integer> nei = mat[u];
        for(int i=0; i<nei.size(); i++)
        {
            int curr_nei = nei.get(i);
            if(isDesc[curr_nei]) //cycle is present if neighbor is a descendant.
            {
                return true;
            }

            boolean b = Check1(curr_nei, mat, vis, isDesc); //cycle detection for neighbor

            if(b==true) //if neighbor has a cycle the graph is cyclic.
                return true;
        }
        isDesc[u] = false; //unmark this as non-desc before returning.
        return false;
    }
	public void printArray(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	int f;
    public void check2(ArrayList<Integer> g[] , int[] vis ,int i){
      vis[i]=1;
      for(int j=0;j<g[i].size();j++){
          int v=g[i].get(j);
           if(vis[v]==-1)
             check2(g,vis,v);
            else if(vis[v]==1)
             f=1;
             }
            vis[i]=2;
        }
   public int solve2(int A, int[][] B) {
      int vis[]=new int[A+1];
      Arrays.fill(vis,-1);
      ArrayList<Integer> g[]=new ArrayList[A+1];
        for(int i=0;i<=A;i++){
          g[i]=new ArrayList<>();
      }
       for(int i=0;i<B.length;i++){
          g[B[i][0]].add(B[i][1]);
      }
       for(int i=1;i<=A;i++){
          if(vis[i]==-1){
          f=0;
          check2(g,vis,i);
          if(f==1)
          return 1;
          }
       }
     return 0;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectCycle dc = new DetectCycle();
		int[][] B = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2},{1, 3}};
		System.out.println(dc.solve2(5, B)); // 1
		System.out.println(dc.solveFinal(5, B)); // 1
		int[][] C = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		System.out.println(dc.solve2(5, C)); // 0
		System.out.println(dc.solveFinal(5, C)); // 1-- 0
		int[][] D = {{1,3},{2,3},{3,2}};
		System.out.println(dc.solve2(3, D)); // 1
		System.out.println(dc.solveFinal(3, D)); // 1
		int[][] E = {{1,2}, {1,3}, {2,3}, {1,4}, {4,3}, {4,5}, {3,5}};
		System.out.println(dc.solve2(5, E)); // 0
		System.out.println(dc.solveFinal(5, E)); // 1-- 0
	}

}
