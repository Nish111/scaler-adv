package graphs4_mst_160523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/85791/homework/problems/6284/submissions
public class DamagedRoads {

	int lower_bound(int[] A, int k){
        int left=0;
        int right = A.length-1;
        int ans=-1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(A[mid]>=k){
                ans = mid;
                right = mid-1;
            }
            else {

                left = mid+1;
            }
        }
        return ans;
    }
    public int solve(int[] A, int[] B) {
        Arrays.sort(B);
        int[] prefix = new int[B.length];
        prefix[0]=B[0];
        for(int i=1; i<B.length; i++){
            prefix[i] = prefix[i-1]+B[i];
        }
        long mod = (long)1e9+7;
        long ans=0;

        for(int i=0; i<A.length; i++){
            ans = (ans%mod+A[i])%mod;
        }
        for(int i=0; i<B.length; i++){
            ans = (ans%mod+B[i])%mod;
        }
        for(int i=0; i<A.length; i++){
            int k = lower_bound(B, A[i]);
            if(k==-1)
            k=B.length;
            //System.out.println(k+" "+A[i]);
            ans = ( ans%mod + ((k-1>=0)?prefix[k-1]:0) + A[i]*(B.length-k))%mod;
        }
        return (int)ans;
    }
    // approach 2 brute
    public int solve2(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int cities[][] = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                cities[i][j] = Integer.MAX_VALUE;
            }
        }
        cities[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] currentIndex = q.poll();
            int[] nextRow = new int[]{currentIndex[0] + 1, currentIndex[1]};
            int[] nextCol = new int[]{currentIndex[0], currentIndex[1] + 1};
            
            if(nextRow[0] <= n){
                cities[nextRow[0]][nextRow[1]] = Math.min(cities[nextRow[0]][nextRow[1]], A[nextRow[0] - 1]);
                q.add(nextRow);
            }
            if(nextCol[1] <= m){
                cities[nextCol[0]][nextCol[1]] = Math.min(cities[nextCol[0]][nextCol[1]], B[nextCol[1] - 1]);
                q.add(nextCol);
            }
        }

        long  minCost = 0;
        int mod = 1000000007;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                minCost = (minCost + cities[i][j]) % mod;
            }
        }
        return (int) minCost % mod;
    }
    // approach 3 optimized
    public int solve3(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        List<int[]> cost = new ArrayList<>(n + m);
        for(int i = 0; i < n; i++){
            cost.add(new int[]{A[i], 1});
        }
        for(int i = 0; i < m; i++){
            cost.add(new int[]{B[i], 0});
        }

        Collections.sort(cost, (a,b)-> Integer.compare(a[0], b[0]));
        n++;
        m++;
        long minCost = 0;
        int mod = 1000000007;

        for(int[] road : cost){
            if(road[1] == 0){
                minCost = (minCost + (n * road[0])) % mod;
                m--;
            }else{
                minCost = (minCost + (m * road[0])) % mod;
                n--;
            }
        }
        return (int)minCost % mod;
    }
    
    static long MOD = 1000000007;
    public int solveScalerSol(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        ArrayList < PairScalerSol4 > v = new ArrayList < PairScalerSol4 > ();
        for (int i = 0; i < n; i++)
            v.add(new PairScalerSol4(A[i], 0));
        for (int i = 0; i < m; i++)
            v.add(new PairScalerSol4(B[i], 1));
        Collections.sort(v);
        n++;
        m++;
        long ans = 0;
        for (PairScalerSol4 u: v) {
            if (u.second == 0) {
                ans = (ans + (m * u.first) % MOD) % MOD;
                ans %= MOD;
                n--;
            } else {
                ans = (ans + (n * u.first) % MOD) % MOD;
                ans %= MOD;
                m--;
            }
        }
        return (int) ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DamagedRoads dr = new DamagedRoads();
		int[] A = {1, 1, 1};
		int[] B = {1, 1, 2};
		System.out.println(dr.solve3(A, B)); // 16
		int[] C = {1, 2, 3};
		int[] D = {4, 5, 6};
		System.out.println(dr.solve3(C, D)); // 39
						 
	}
}
class PairScalerSol4 implements Comparable < PairScalerSol4 > {
    int first;
    int second;
    public PairScalerSol4(int a, int b) {
        this.first = a;
        this.second = b;
    }
    @Override
    public int compareTo(PairScalerSol4 temp) {
        if (this.first == temp.first)
            return this.second - temp.second;
        return this.first - temp.first;
    }
}
