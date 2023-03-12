package sorting3_010223;

public class CountSort {

	public String smallestNumber(int[] A) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			if(max<A[i]) max =A[i];
		}
		int[] B = new int[max+1];
		StringBuilder count = new StringBuilder();
		for(int i=0; i<A.length; i++) {
			B[A[i]]++;
		}
		//for(int i=0; i<B.length; i++) System.out.print(B[i] +" ");
		//System.out.println();
		for(int i=0; i<B.length; i++) {
			int temp = B[i];
			while(temp>0) {
				count.append(i);
				temp--;
			}
		}
		return count.toString();
	}
	// accomodating negative
	public String smallestNumberTweak(int[] A) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<A.length; i++) {
			if(max<A[i]) max = A[i];
			if(min>A[i]) min = A[i];
		}
		//System.out.println(min + " " + max);
		int temp = max-min+1;
		int[] B = new int[temp];
		StringBuilder count = new StringBuilder();
		for(int i=0; i<A.length; i++) {
			B[A[i]+Math.abs(min)]++;
		}
		//for(int i=0; i<B.length; i++) System.out.print(B[i] +" ");
		//System.out.println();
		for(int i=0; i<B.length; i++) {
			int temp1 = B[i];
			while(temp1>0) {
				count.append(i-Math.abs(min));
				//System.out.println(count);
				temp1--;
			}
		}
		return count.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountSort cs = new CountSort();
		int[] A = {9,0,1,6,5,4,4};
		System.out.println(cs.smallestNumber(A)); // 0144569
		int[] B = {88,102,5,62,75};
		System.out.println(cs.smallestNumber(B)); // 5627588102
		int[] C = {3, 30, 34, 5, 9};
		System.out.println(cs.smallestNumber(C)); // 3593034
		int[] D = {2, 3, 9, 0};
		System.out.println(cs.smallestNumber(D)); // 0239
		int[] E = {-8,0,8,-10,1,2,-4,10};
		System.out.println(cs.smallestNumberTweak(E)); // -10-8-4012810
	}

}
