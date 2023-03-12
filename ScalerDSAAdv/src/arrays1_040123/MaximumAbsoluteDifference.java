package arrays1_040123;

public class MaximumAbsoluteDifference {

	public int maxArr(int[] A) { // base this is only calculating diff max-min
		if(A.length==1) return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			if(A[i]<min) min = A[i];
			if(A[i]>max) max = A[i];
		}
		return max-min;
    }
	public int solve(int[] A) { // base
		if(A.length==1) return 0;
		int[] x = new int[A.length];
		int[] y = new int[A.length];
		for(int i=0; i<A.length; i++) {
			x[i] = A[i]+i;
			y[i] = A[i]-i;
		}
		/*
		 * for(int i=0; i<x.length; i++) { System.out.println("x[i] is " + x[i]);
		 * System.out.println("y[i] is " + y[i]); }
		 */
		//System.out.println(); //
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			if(x[i]<minX) minX = x[i];
			if(x[i]>maxX) maxX = x[i];
			if(y[i]<minY) minY = y[i];
			if(y[i]>maxY) maxY = y[i];
		}
		int result = maxX-minX;
		if (result >(maxY-minY)) return result;
		else return maxY-minY;
    }
	public int solveOptimized(int[] A) { // base
		if(A.length==1) return 0;
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			maxX = Math.max(maxX, A[i]+i);
			maxY = Math.max(maxY, A[i]-i);
			minX = Math.min(minX, A[i]+i);
			minY = Math.min(minY, A[i]-i);
		}
		int result = maxX-minX;
		if (result >(maxY-minY)) return result;
		else return maxY-minY;
    }
	public int maxArrScalerSol(int[] A) {
	    
        int ans = 0, n = A.length; 
        
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            max1 = Math.max(max1, A[i] + i);
            max2 = Math.max(max2, A[i] - i);
            min1 = Math.min(min1, A[i] + i);
            min2 = Math.min(min2, A[i] - i);
        }   
        
        ans = Math.max(ans, max2 - min2);
        ans = Math.max(ans, max1 - min1);
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumAbsoluteDifference mad = new MaximumAbsoluteDifference();
		int[] A = {1, 3, -1};
		int[] B = {2};
		System.out.println(mad.maxArr(A)); // 5
		System.out.println(mad.maxArr(B)); // 0
		System.out.println(mad.solve(A)); // 5
		System.out.println(mad.solve(B)); // 0
		System.out.println(mad.solveOptimized(A)); // 5
		System.out.println(mad.solveOptimized(B)); // 0
		
	}

}
