package graphs3_sortdsu_120523;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
// https://www.scaler.com/academy/mentee-dashboard/class/70952/assignment/problems/9328/?navref=cl_pb_nv_tb
public class TopologicalSort {

	public int[] solve(int A, int[][] B) { // try once
        // Result ArrayList
        List<Integer> res = new ArrayList<>();

        ArrayList<Integer>[] graph = new ArrayList[A+1];
        // Initialize graph array of list
        for(int i=0; i<=A; i++){
            graph[i] = new ArrayList<Integer>();
        }

        // Create incoming edges array
        int[] incoming_edges = new int[A+1];

        // Add values to directed graph array
        for(int i=0; i<B.length; i++){
            graph[B[i][0]].add(B[i][1]);
            incoming_edges[B[i][1]] += 1;
        }

        // Traverse through incoming_edges array and add all 0 edges node to queue
        // Question said “If there are multiple solutions print the lexographically smallest one.”
        // So we created minHeap to find min node available each iteration
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i=1; i<=A; i++){
            if(incoming_edges[i] == 0) q.add(i);
        }

        if(q.size() == 0) return new int[]{};

        while(q.isEmpty() == false){
            int current = q.remove();
            res.add(current);
            for(int i=0; i<graph[current].size(); i++){
                incoming_edges[graph[current].get(i)] -= 1;
                if(incoming_edges[graph[current].get(i)] == 0) q.add(graph[current].get(i));
            }
            // incoming_edges[current] = -1;
        }

       
        if(res.size() != A) return new int[]{};
       
        int[] r = new int[A];
        for(int i=0; i<A; i++){
            r[i] = res.get(i);
        }
       
        return r;
    }
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++) System.out.print(A[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologicalSort ts = new TopologicalSort();
		int[][] B = {{6, 3}, {6, 1}, {5, 1}, {5, 2}, {3, 4}, {4, 2}};
		int[] A = ts.solve(6, B);
		ts.printArray(A);
	}

}
