package stack2_030323;

import java.util.ArrayList;
import java.util.Stack;

//https://www.scaler.com/academy/mentee-dashboard/class/50151/homework/problems/4349
public class MaximumRectangle {

	public int solveBrute(int[][] A) {
		
		return 0;
	}
	int[][] dp;
	public int solve(int[][] A) {
		dp = new int[A.length][A[0].length];
		 for(int i=0; i<A.length; i++) { 
			 for(int j=0; j<A[0].length; j++) { 
				 dp[i][j]=A[i][j]; 
				 }
			 }
		 
		int max = 0;
		//printArray(A);
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				if(j==0) dp[i][j] = A[i][j];
				else if(A[i][j]==0) continue;
				else {
					dp[i][j] = dp[i][j] + dp[i][j-1];
				}
			}
		}
		printArray(dp); // still now working fully
		if(A.length==1) {
			for(int i=0;i<A.length; i++)
				max = Math.max(max, A[i][0]);
		}
		if(A[0].length==1) {
			for(int i=0;i<A[0].length; i++)
				max = Math.max(max, A[0][i]);
		}
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				if(dp[i][j]==0) continue;
				else {
					int w = dp[i][j];
					int h  = 1;
					max = Math.max(max, w*h);
					int temp = i-1;
					while(temp >=0) {
						h++;
						w = Math.min(w, dp[temp][j]);
						max = Math.max(max, w*h);
						temp--;
						//System.out.println(max+" "+temp+" "+i+" "+j);
					}
				}
			}
		}
		//printArray(dp);
		return max;
	}
public int maximalRectangleScalerSol(ArrayList<ArrayList<Integer>> A) {
	    
	    if (A == null || A.size() == 0)
	        return 0;
	    
	    int m, n;
	    int i, j;
	    
	    m = A.size();
	    n = A.get(0).size();
	    
	    int count[][];
	    count = new int[m][n];
	    
	    for (i = 0; i < m; i++) {
	        for (j = 0; j < n; j++) {
	            if (i == 0) {
	                count[i][j] = A.get(i).get(j);
	            } else {
	                count[i][j] = A.get(i).get(j) == 0 ? 0 : count[i - 1][j] + 1;
	            }
	        }
	    }
	    
	    int res = 0;
	    
	    for (i = 0; i < m; i++) {
	        res = Math.max(res, maxRectScalerSol(count[i]));
	    }
	    
	    return res;
	    
	}
	
	public int maxRectScalerSol(int [] histogram) {
	    int n;
	    int res = 0;
	    int prevMin[];
	    int nextMin[];
	    int num;
	    Stack<Integer> stack;
	    
	    n = histogram.length;
	    prevMin = new int[n];
	    nextMin = new int[n];
	    
	    stack = new Stack<Integer>();
	    
	    prevMin[0] = -1;
	    stack.push(0);
	    for (int i = 1; i < n; i++) {
	        num = histogram[i];
	        while (!stack.isEmpty() && num <= histogram[stack.peek()]) {
	            stack.pop();
	        }
	        prevMin[i] = -1;
	        if (!stack.isEmpty()) {
	            prevMin[i] = stack.peek();
	        }
	        stack.push(i);
	    }

	    
	    nextMin[n - 1] = n;
	    stack.clear();
	    stack.push(n - 1);
	    for (int i = n - 2; i >= 0; i--) {
	        num = histogram[i];
	        while (!stack.isEmpty() && num <= histogram[stack.peek()]) {
	            stack.pop();
	        }
	        nextMin[i] = n;
	        if (!stack.isEmpty())
	            nextMin[i] = stack.peek();
	        stack.push(i);
	    }
	    
	    for (int i = 0; i < n; i++) {
	        int left = prevMin[i] + 1;
	        int right = nextMin[i] - 1;
	        res = Math.max(res, histogram[i] * (right - left + 1));
	    }
	    
	    return res;
	}
	public void printArray(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumRectangle mr = new MaximumRectangle();
		int[][] A = {{0,0,1}, {0, 1, 1}, {1, 1, 1}};
		mr.printArray(A);
		System.out.println(mr.solve(A)); // 4
		int[][] B = {{0,1,1,0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
		mr.printArray(B);
		System.out.println(mr.solve(B));
	}

}
