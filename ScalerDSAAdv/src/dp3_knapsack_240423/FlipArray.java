package dp3_knapsack_240423;

import java.util.Arrays;
import java.util.List;

// https://www.scaler.com/academy/mentee-dashboard/class/70945/assignment/problems/373
public class FlipArray {

	Pair dp[][] = new Pair[101][10001];
	public int solve(final int[] A) {
		int sum =0;
		int len = A.length;
		for(int i=0; i<len ; i++) {
			sum +=A[i];
		}
		sum /= 2;
		//Pair dp[][] = new Pair[len][sum+1];
		for(int i=0; i<=100; i++) {
			for(int j=0; j<=1000; j++) {
				dp[i][j] = new Pair(-1, -1);
			}
		}
		/*
		 * for(int j=0; j<sum+1; j++) { dp[0][j] = new Pair(0, 0); } for(int j=0; j<len;
		 * j++) { dp[j][0] = new Pair(0, 0); }
		 */
		Pair total_flip = flip(len, sum/2+1, A);
		//printArray(dp);
		return total_flip.noOfFlips;
    }
	Pair flip(int n, int w, int[] A) {
		if(n==0 || w==0) return new Pair(0,0);
		if(dp[n][w].sum != -1) return dp[n][w];
		if(w>=A[n-1]) {
			Pair p1 = flip(n-1,w, A); // no flip
			Pair p2 = flip(n-1, w-A[n-1], A); // flip
			if(p1.sum > (p2.sum+A[n-1])) dp[n][w] = p1;
			else if (p1.sum < (p2.sum+A[n-1])) {
				dp[n][w] = new Pair(p2.sum+A[n-1], p2.noOfFlips+1);
			} else {
				dp[n][w] = new Pair(p2.sum, Math.min(p1.noOfFlips, p2.noOfFlips+1));
			}
		}
		else {
			// array value is greater than weight so no choice but to skip
			dp[n][w] = flip(n-1, w, A);// not flip
		}
		return dp[n][w];
	}
	public int solve(final List<Integer> A) {

		//Intuition behind the approach
		//some no of elements needed to get the minSum from totalSum. foreg → Totalsum = 10, to make this sum nearer to zero or zero.
		//we need sum elements like ->(totalSum - no of elements needed) >= 0…this makes the logic to find the no of elements needed
		//to get totalSum/2…Only a number can be drived to zero if it was subtracted with half of that.

		//So using DP array to find no of elements needed to get totalsum/2… so we can get minSum…
		//Here no of elements needed would be representing the flips we needed
		        int sum = 0;
		        for (int x : A)
		            sum += x;

		        sum /= 2;

		        int n = A.size()+1;
		        int m = sum + 1;
		        Pair2[][] dp = new Pair2[n][m];


		        for (int j = 0; j < m; j++) {
		            dp[0][j] = new Pair2(0, 0);
		        }

		        for (int i = 0; i < n; i++) {
		            dp[i][0] = new Pair2(0, 0);
		        }
		//In DP array we are storing info of sum which we got by considering or not considering the element and the number of elements selected to get the sum.
		        for (int i = 1; i < n; i++) {
		            for (int j = 1; j < m; j++) {
		                if (A.get(i-1) <= j) {
		                    Pair2 prev = dp[i - 1][j];
		                    int newSum = dp[i - 1][j - A.get(i-1)].sum + A.get(i-1);
		                    int newFlips = dp[i - 1][j - A.get(i-1)].flips + 1;

		                    if (Math.abs(newSum - j) < Math.abs(prev.sum - j)) {
		                        dp[i][j] = new Pair2(newSum, newFlips);
		                    } else if (Math.abs(newSum - j) > Math.abs(prev.sum - j)) {
		                        dp[i][j] = new Pair2(prev.sum, prev.flips);
		                    } else {
		                        if (newFlips < prev.flips) {
		                            dp[i][j] = new Pair2(newSum, newFlips);
		                        } else {
		                            dp[i][j] = new Pair2(prev.sum, prev.flips);
		                        }
		                    }
		                } else {
		                    dp[i][j] = dp[i - 1][j];
		                }
		            }
		        }
		        //for (int i = 0; i < n; i++) {
		        //    for (int j = 0; j < m; j++) {
		        //        System.out.print("("+dp[i][j].sum+", “+dp[i][j].flips+”)");
		        //    }
		        //    System.out.println();
		        //}
		        return dp[n - 1][m - 1].flips;
		    }
	public int solve3(final int[] A) { // working
        int sum = 0;
        int len = A.length;
        for(int i=0; i<len ; i++) {
			sum +=A[i];
		}
		sum /= 2;
       
       
        int[][] dp = new int[len+1][sum+1];

        for(int j = 1;j<=sum;j++){
            dp[0][j] = 9999999;
        }
        //printArray(dp);
        for(int i = 1;i<=len;i++){
            for(int j = 1;j<=sum;j++){
                if(j<A[i-1]){
                    dp[i][j] = dp[i-1][j]; // not flipped
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i-1][j-A[i-1]]); // flipped
                }
            }
        }

        while(dp[len][sum]==9999999){
            sum-=1;
        }
        //printArray(dp);
        return dp[len][sum];
    }
	public int solveScalerSol(final int[] A) {
        nodeScalerSol[][] dp = new nodeScalerSol[105][10005];
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += A[i];
        for (int i = 0; i < 105; i++)
            for (int j = 0; j < 10005; j++) dp[i][j] = new nodeScalerSol(0, 0);
        int temp = sum / 2;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= temp; j++) {
                if (i == 0 || j == 0) dp[i][j] = new nodeScalerSol(0,0);
                else {
                    int prev_items = dp[i - 1][j].items;
                    int prev_weight = dp[i - 1][j].weight;
                    if (j - A[i - 1] >= 0) {
                        int curr_weight = dp[i - 1][j - A[i - 1]].weight + A[i - 1];
                        int curr_items = dp[i - 1][j - A[i - 1]].items + 1;

                        if ((curr_weight > prev_weight) || ((curr_weight == prev_weight) && (curr_items < prev_items))) {
                            dp[i][j] = new nodeScalerSol(curr_items,curr_weight);
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][temp].items;
    }
	public void printArray(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void printArray(Pair[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlipArray fa = new FlipArray();
		int[] A = {15, 10, 6};
		System.out.println(fa.solve3(A)); // 1
		int[] B = {14, 10, 4};
		System.out.println(fa.solve3(B)); // 1
		int[] C = {11,10,8,6,8,11,1,10,2,3,8,3,8,12,11,1,7,5,5,12,9,4,10,3,3,3,8,8,8,6,7,7,7,6,4,2,5,8,11,10,10,10,12,9,2,3,9,12,7,6,11,8,9,9,10,3,3,5,2,10,10,9,4,9,6,11,10,2,6,1,4,7,10,3,4,3,9,4,3,8,1,1,3};
		System.out.println(fa.solve(C)); // 41 -- 27
		System.out.println(fa.solve3(C)); // 27
	}
}
class Pair{
	int sum;
	int noOfFlips;
	Pair(int sum, int noOfFlips){
		this.sum = sum;
		this.noOfFlips = noOfFlips; 
	}
}
class Pair2 {
    int sum;
    int flips;

    Pair2(int sum, int flips) {
        this.sum = sum;
        this.flips = flips;
    }
}
class nodeScalerSol {
    int items;
    int weight;
    public nodeScalerSol(int a, int b) {
        this.items = a;
        this.weight = b;
    }
}
