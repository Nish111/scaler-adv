package contest_180223;

import java.util.ArrayList;
// https://www.scaler.com/test/5c9c7e523b/#/problem_2
public class FantasticFour {
	public int solve(int[] A) { // not working
        int count=0;
        int res=0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<A.length; i++){
            if(A[i]%4 != 0) {
            	count++;
            	arr.add(A[i]);
            }
        }
        int sum=0;
        for(int i=0; i<arr.size(); i++) {
        	sum += arr.get(i);
        }
        if(sum%4 != 0 || count%2 !=0) return -1;
        else return count/2;
       /* for(int i=0; i<arr.size(); i+=2) {
        	int temp1 = arr.get(i);
        	int temp2 = arr.get(i+1);
        	if((temp1+temp2) %4 == 0) {
        		res++;
        	} else {
        		
        	}
        }
        return res;*/
    }
	public int solveVideo(int[] A) { // O(N) working
        int count=0;
        int res=0;
        int[] G = new int[4];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<A.length; i++){
           G[A[i]%4]++;
        }
        // finding min values of G and subtracting from rest
        // as G[1]+G[3]=4 so 
        // Step 1
        int m = Math.min(G[1], G[3]);
        res += m;
        G[1] = G[1]-m;
        G[3] = G[3]-m;
        // Step 2
        int remaining = Math.max(G[1], G[3]);
        res += remaining/2;
        G[2] += remaining/2;
        remaining = remaining%2;
        if(remaining==1) return -1;
        // Step 3
        res += G[2]/2;
        G[2] = G[2]%2;
        if(G[2]==1) return -1;
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FantasticFour ff = new FantasticFour();
		int[] A = {1,3,4,4,2,2};
		System.out.println(ff.solveVideo(A)); // 2
		int[] B = {4,2,2};
		System.out.println(ff.solveVideo(B)); // 1
		int[] C = {1,3,2,4};
		System.out.println(ff.solveVideo(C)); // -1
		int[] D = {1,1,2,4};
		System.out.println(ff.solveVideo(D));// 2
		int[] E = {3,3,3,3};
		System.out.println(ff.solveVideo(E));// 3 -- 3 expected
		int[] F = {1,4,3,7,11,2,16};
		System.out.println(ff.solveVideo(F)); // 3
	}

}
