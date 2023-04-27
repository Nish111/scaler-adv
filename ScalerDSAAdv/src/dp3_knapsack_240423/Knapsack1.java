package dp3_knapsack_240423;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/70945/assignment/problems/35883?navref=cl_tt_lst_nm
public class Knapsack1 {

	// Fractional Knapsack
	public int maxHappiness(int[] weight, int[] happiness, int capacity) {
		double max=0;
		int n = weight.length;
		double[][] arr = new double[n][3];
		for(int i=0; i<n; i++) {
			arr[i][0] = (double) weight[i];
			arr[i][1] = (double) happiness[i];
			arr[i][2] = (double) weight[i]/happiness[i];
		}
		Arrays.sort(arr, (a,b) -> Double.compare(b[2], a[2]));
		double temp = (double)capacity;
		for(int i=0; i<n; i++) {
			if(arr[i][1]<=temp) {
				max += arr[i][0];
				temp -= arr[i][1];
			}
			else {
				max = (max *100) + ((temp * arr[i][2]) * 1000)/10;
				//return (int) Math.ceil(max*100  + (temp * arr[i][2]) * 100) ;
				return (int) max;
			}
		}
		//printArray(arr);
		return (int) (max*1000)/10 ;
	}
	public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        double[][] pair = new double[n][3];
        for(int i = 0; i < n; i++){
            pair[i][0] = (double)A[i];
            pair[i][1] = (double)B[i];
            pair[i][2] = (double)A[i] / B[i];
        }

        Arrays.sort(pair, (a,b) -> Double.compare(b[2], a[2]));
        double sum = 0;
        double remainingCapacity = (double)C;
        for(int i = 0; i < n; i++){
            if(pair[i][1] <= remainingCapacity){
                sum += pair[i][0];
                remainingCapacity -= pair[i][1];
            }else{
                sum = (sum * 100) +  (remainingCapacity * pair[i][2]) * 100;
                return (int)sum;
            }
            
        }
        return (int) (sum*100);
    }
	
	public int solve1(int[] weight, int[] happiness, int capacity) {
        double max=0;
		int n = weight.length;
		Triplet[] arr = new Triplet[n];
		for(int i=0; i<n; i++) {
			arr[i] = new Triplet( weight[i], happiness[i]);
			arr[i].weight = (double) weight[i];
			arr[i].happiness = (double) happiness[i];
			arr[i].ratio = (double) weight[i]/happiness[i];
		}
		Arrays.sort(arr, (a,b) -> Double.compare(b.ratio, a.ratio));
		for(int i=0; i<n; i++) {
			if(arr[i].happiness<=(double)capacity) {
				max += arr[i].weight;
				capacity -= arr[i].happiness;
			}
			else {
                max = max*100  + ((capacity * arr[i].ratio) * 1000)/10;
				return (int) max ;
			}
		}
		
		return (int) (max * 1000)/10;
    }
	public void printArray1(double[] dp) {
		for(int i=0; i<dp.length; i++) 
				System.out.print(dp[i]+" ");
			System.out.println();
	}
	public void printArray(double[][] dp) {
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack1 ks = new Knapsack1();
		int[] weight = {3,8,10,2,5};
		int[] happiness = {10,4,20,8,15};
		System.out.println(ks.maxHappiness(weight, happiness, 40)); // 2330
		System.out.println(ks.solve(weight, happiness, 40)); // 2330
		int[] A = {60, 100, 120};
		int[] B = {10, 20, 30};
		System.out.println(ks.maxHappiness(A, B, 50)); // 24000
		System.out.println(ks.solve(A, B, 50)); // 24000
		int[] C = {10, 20, 30, 40};
		int[] D = {12, 13, 15, 19};
		System.out.println(ks.maxHappiness(C, D, 10)); // 2105
		System.out.println(ks.solve(C, D, 10)); // 2105
		int[] E = {3};
		int[] F = {20};
		System.out.println(ks.maxHappiness(E, F, 17)); // 255
		System.out.println(ks.solve1(E, F, 17)); // 255
		System.out.println((int)Math.ceil(254.9)); // 255
		int[] G = {16, 3, 3, 6, 7, 8, 17, 13, 7};
		int[] H = {3, 10, 9, 18, 17, 17, 6, 16, 13};
		System.out.println(ks.maxHappiness(G, H, 11)); // 3462
		System.out.println(ks.solve(G, H, 11)); //  3462
		System.out.println(ks.solve1(G, H, 11)); // 3462
	}

}
class Triplet {
	double happiness, weight, ratio;
	Triplet(int weight, int happiness){
		happiness = happiness;
		weight = weight;
		ratio = weight/happiness;
	}
	
}