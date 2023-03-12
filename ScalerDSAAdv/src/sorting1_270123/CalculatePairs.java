package sorting1_270123;

import java.util.Arrays;
import java.util.Collections;

public class CalculatePairs {

	public int calPairs(int[] A, int[] B) { // O(n*m)
		int count=0;
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<B.length; j++) {
				if(A[i]>B[j]) count++;
			}
		}
		return count;
	}
	public int calPairs2(int[] A, int[] B) {
		int count=0;
		Arrays.sort(A);
		Arrays.sort(B);
		int p1=0, p2=0;
		while(p1<B.length && p2<=A.length) {
			if(B[p1]<A[p2]) {
				count += A.length-p2;
				p1++;
			}
			else {
				p2++;
			}
			//System.out.println("-");
		}  
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatePairs cp = new CalculatePairs();
		int[] A = {7,3,5}; // 3 5 7
		int[] B = {2,0,6}; // 0 2 6
		System.out.println(cp.calPairs(A, B)); // 7
		System.out.println(cp.calPairs2(A, B)); // 7
		System.out.println(cp.calPairs(A, B));
		System.out.println(cp.calPairs(A, B));
	}

}
