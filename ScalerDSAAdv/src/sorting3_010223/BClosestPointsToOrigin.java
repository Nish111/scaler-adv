package sorting3_010223;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50138/assignment/problems/4194/submissions
public class BClosestPointsToOrigin {

	public int[][] solve(int[][] A, int B) {
		int[][] res = new int[B][2];
		PriorityQueue<ListPoints> temp = new PriorityQueue<>((a,b)-> a.dist - b.dist);
		for(int i=0; i<A.length; i++) {
			int x1 = A[i][0];
			int y1 = A[i][1];
			int dist = (x1*x1) + (y1*y1);
			temp.add(new ListPoints(dist, i));
		}
		int i= 0;
		while(B-->0) {
			int temp2 = temp.remove().i;
			res[i]=A[temp2];
			i++;
		}
		return res;
    }
	 public class ListPoints {
		int dist; int i;
		ListPoints(int dist, int index){
			this.dist = dist;
			this.i = index;
		}
	}
	public int[][] solve2(int[][] A, int B) { 
		// mine used HashMap but need sort with i so TreeMap
			int[][] res = new int[B][2];
			TreeMap<Integer, Integer> temp = new TreeMap<>();
			for(int i=0; i<A.length; i++) {
				int x1 = A[i][0];
				int y1 = A[i][1];
				int dist = (x1*x1) + (y1*y1);
				temp.put(dist, i);
				System.out.println(dist+ " "+i);
			}
			Iterator itr = temp.keySet().iterator();
			int i=0;
			while(B-->0) {
				res[i] = A[temp.get((int) itr.next())];
				System.out.println(res[i][0]+" "+res[i][1]);
				i++;
				
			}
			return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BClosestPointsToOrigin bc = new BClosestPointsToOrigin();
		int[][] A = {{1, 3}, {-2, 2}};
		int[][] B = bc.solve2(A, 1); // -2 2
		for(int i=0; i<B.length; i++) {
			for(int j = 0; j<B[0].length; j++) System.out.print(B[i][j] +" ");
			System.out.println();
		}
		System.out.println();
		int[][] C = {{1, -1}, {2, -1}};
		int[][] D = bc.solve2(C, 1); // 1 -1
		for(int i=0; i<D.length; i++) {
			for(int j = 0; j<D[0].length; j++) System.out.print(D[i][j] +" ");
			System.out.println();
		}
		System.out.println();
		int[][] E = {{50, 35}, {6, 4}, {1, 26}, {35, 30}, {21, 14}, {16, 11}, {50, 35},
				{22, 37}, {26, 3}, {96, 74}, {78, 63}, {82, 106}, {91, 107}, {62, 107},
				{85, 82}, {74, 69}, {66, 105}, {109, 73}, {76, 108}, {63, 64}, {81, 104},
				{91, 106}, {68, 60}, {69, 65}, {86, 67}};
		int[][] F = bc.solve2(E, 9);
		for(int i=0; i<F.length; i++) {
			for(int j = 0; j<F[0].length; j++) System.out.print(F[i][j] +" ");
			System.out.println();
		}
		System.out.println();
		// 6 4  16 11  21 14  1 26  26 3  22 37  35 30  50 35  50 35 
		// 6 4  16 11  21 14  1 26  26 3  22 37  35 30  50 35  63 64 -- using solve 2 - missing duplicates
	}

}
