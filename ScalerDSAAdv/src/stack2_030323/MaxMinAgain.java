package stack2_030323;

import java.util.Arrays;
import java.util.Stack;

public class MaxMinAgain {
    int mod = (int)1e9 + 7;
    public int solve(int[] A) {
        int n = A.length;
        if(n==1) return A[0];

        int nsl[] = nearestSmallerLeft(A);
        printArray(nsl); // -1 0 0 2 2 0 5 5 0 
        int nsr[] = nearestSmallerRight(A);
        printArray(nsr); // 9 2 5 4 5 9 7 8 9 
        int ngl[] = nearestGreaterLeft(A);
        printArray(ngl); // -1 -1 1 1 3 4 -1 6 7 
        int ngr[] = nearestGreaterRight(A);
        printArray(ngr); // 1 6 3 6 6 6 9 9 9 

        long totalMax = 0l, totalMin = 0l;

        for(int i = 0; i < n; i++){
            //number of subarrays where A[i] will be maximum
            long maxSubarrayCount = 1l*(ngr[i] - i)*(i - ngl[i]);
            long currentMaxContri = (A[i]*maxSubarrayCount) % mod;

            //number of subarrays where A[i] will be minimum
            long minSubarrayCount = 1l*(nsr[i] - i)*(i - nsl[i]);
            long currentMinContri = (A[i]*minSubarrayCount) % mod;

            //generating total max contribution and minimum contribution
            totalMax = ((currentMaxContri % mod) + (totalMax % mod)) % mod;
            totalMin = ((currentMinContri % mod) + (totalMin % mod)) % mod;
        }

        int sum = (int)(totalMax - totalMin) % mod;
        return (sum + mod) % mod;
    }

    public int[] nearestSmallerLeft(int[] a){
        Stack<Integer> cl = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);

        for(int i=0; i<a.length; i++){
            while(!cl.isEmpty() && a[cl.peek()]>=a[i]){
                cl.pop();
            }
            if(!cl.isEmpty()){
                ans[i] = cl.peek();
            }
            cl.push(i);
        }

        return ans;
    }

    public int[] nearestSmallerRight(int[] a){
        int n = a.length;
        Stack<Integer> cl = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, n);

        for(int i=a.length-1; i>=0; i--){
            while(!cl.isEmpty() && a[cl.peek()]>=a[i]){
                cl.pop();
            }
            if(!cl.isEmpty()){
                ans[i] = cl.peek();
            }
            cl.push(i);
        }

        return ans;
    }

    public int[] nearestGreaterLeft(int[] a){
        Stack<Integer> cl = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);

        for(int i=0; i<a.length; i++){
            while(!cl.isEmpty() && a[cl.peek()]<=a[i]){
                cl.pop();
            }
            if(!cl.isEmpty()){
                ans[i] = cl.peek();
            }
            cl.push(i);
        }

        return ans;
    }

    public int[] nearestGreaterRight(int[] a){
        int n = a.length;
        Stack<Integer> cl = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, n);

        for(int i=a.length-1; i>=0; i--){
            while(!cl.isEmpty() && a[cl.peek()]<=a[i]){
                cl.pop();
            }
            if(!cl.isEmpty()){
                ans[i] = cl.peek();
            }
            cl.push(i);
        }

        return ans;
    }
    public void printArray(int[] A) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i] +" ");
		}
		System.out.println();
	}
    public static void main(String[] args) {
    	MaxMinAgain iamm = new MaxMinAgain();
		int[] A = {1, 8, 3, 5, 4, 2, 11, 7, 2};
		iamm.printArray(A); // 1 8 3 5 4 2 11 7 2 
		System.out.println(iamm.solve(A)); // 242
		int[] B = {1};
		iamm.printArray(B); // 1
		System.out.println(iamm.solve(B)); // 1
		int[] C = {4, 7, 3, 8};
		iamm.printArray(C); // 4 7 3 8 
		System.out.println(iamm.solve(C)); // 26
		int[] D = {1, 2, 3};
		iamm.printArray(D); // 1 2 3 
		System.out.println(iamm.solve(D)); // 4
	}
}