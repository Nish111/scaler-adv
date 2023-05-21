package graphs5_spa_170523;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Djikstra {

	public int[] findDistance(int[][] A, int source) { // not working
		int distance[] = new int[A.length];
		Arrays.fill(distance, -1);
		distance[source] = 0;
		PriorityQueue<Pair> mh = new PriorityQueue<>();
		mh.offer(new Pair(source, 0));

		while(!mh.isEmpty()) {
			int dist = mh.peek().distance;
			int node = mh.peek().node;
			mh.poll();
			if (distance[node]!=-1) continue;

            distance[node] = dist;
			// this is failing
            /*
             * for(int n: neighbours){
             * 		if(distance[n]==-1){
             * 			mh.add(new Pair(dist+edgeWeight, v));
             * 		}
             * }
             */
            // this is failing
			for (int v = 0; v < A.length; v++) {
                if(distance[v]==-1) {
                	mh.add(new Pair(dist+A[node][v], v));
                }
            }
		}
		return distance;
	}
	public void printArray(int[] A) {
		// Print the shortest distances
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < A.length; i++) {
            System.out.println(i + " \t\t " + A[i]);
        }
	}
	private static final int INFINITY = Integer.MAX_VALUE;
    public int[] shortestPath(int[][] graph, int source) { // ChatGPT
        int numVertices = graph.length;
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(dist, INFINITY);
        dist[source] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int minVertex = getMinimumVertex(dist, visited);
            visited[minVertex] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && graph[minVertex][j] != 0 && dist[minVertex] != INFINITY
                        && dist[minVertex] + graph[minVertex][j] < dist[j]) {
                    dist[j] = dist[minVertex] + graph[minVertex][j];
                }
            }
        }

        //printArray(dist);
        return dist;
    }

    private int getMinimumVertex(int[] dist, boolean[] visited) {
        int min = INFINITY;
        int minVertex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minVertex = v;
            }
        }

        return minVertex;
    }
    // 
    public int[] shortestPath2(int[][] graph, int source) { // ChatGPT
        int numVertices = graph.length;
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(dist, INFINITY);
        dist[source] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.offer(new Pair(source, 0));
        while (!minHeap.isEmpty()) {
            Pair minVertex = minHeap.poll();
            int u = minVertex.node;
            if (visited[u]) continue;
            visited[u] = true;
            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] != 0 && dist[u] != INFINITY
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    minHeap.offer(new Pair(v, dist[v]));
                }
            }
        }
       //printArray(dist);
       return dist;
    }
	public static void main(String[] args) {
		Djikstra d = new Djikstra();
		 int[][] graph = {
		            {0, 4, 0, 0, 0, 0, 0, 8, 0},
		            {4, 0, 8, 0, 0, 0, 0, 11, 0},
		            {0, 8, 0, 7, 0, 4, 0, 0, 2},
		            {0, 0, 7, 0, 9, 14, 0, 0, 0},
		            {0, 0, 0, 9, 0, 10, 0, 0, 0},
		            {0, 0, 4, 14, 10, 0, 2, 0, 0},
		            {0, 0, 0, 0, 0, 2, 0, 1, 6},
		            {8, 11, 0, 0, 0, 0, 1, 0, 7},
		            {0, 0, 2, 0, 0, 0, 6, 7, 0}
		        };
		 int[] A = d.shortestPath2(graph, 0);
		 d.printArray(A);
		 int[] B = d.shortestPath(graph, 0);
		 d.printArray(B);
		 int[] C = d.findDistance(graph, 0);
		 d.printArray(C);
	}
}
class Pair implements Comparable<Pair>{
	int node;
	int distance;
	Pair(int node, int distance){
		this.node = node;
		this.distance = distance;
	}
	 public int compareTo(Pair other) {
	        return Integer.compare(this.distance, other.distance);
	    }
}