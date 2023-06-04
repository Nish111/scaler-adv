package queues_070323;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/67343/homework/problems/4363?navref=cl_tt_nv
public class ReversingElementsOfQueue {

	public int[] solve(int[] A, int B) {
		Queue<Integer> q = new ArrayDeque();
		int count=0;
		while(count<B) {
			q.add(A[count]);
			count++;
		}
		//System.out.println(count);
		while(count>0) {
			A[count-1]=q.poll();
			count--;
		}
		return A;
    }
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++)
			System.out.print(A[i]+" ");
		System.out.println();
	}
	 public int[] solveScalerSol(int[] A, int B) {
	        Deque < Integer > q = new ArrayDeque < Integer > (A.length);
	        int i = 0;
	        // Insert first B elements in queue
	        for (i = 0; i < B; i++)
	            q.addLast(A[i]);
	        // Reverse the first B elements in the array A
	        while (q.size() > 0) {
	            i--;
	            A[i] = q.getFirst();
	            q.removeFirst();
	        }
	        return A;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReversingElementsOfQueue re = new ReversingElementsOfQueue();
		int[] A = {1,2,3,4,5};
		int[] X = re.solve(A, 3);
		re.printArray(X);
		int[] B = {5,17,100,11};
		int[] Y = re.solve(B, 2);
		re.printArray(Y);
	}

}
