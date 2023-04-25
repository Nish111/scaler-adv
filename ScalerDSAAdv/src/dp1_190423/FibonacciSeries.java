package dp1_190423;

import java.util.Scanner;

// https://www.scaler.com/academy/mentee-dashboard/class/70943/assignment/problems/4035?navref=cl_tt_lst_sl
public class FibonacciSeries {

	public static int findUsingDPSub(int A, int[] dp) {
		if(dp[A]!=-1) return dp[A];
		dp[A] = findUsingDPSub(A-1, dp) + findUsingDPSub(A-2, dp);
		return dp[A];
	}
	 public static void main1(String[] args) {
	        // YOUR CODE GOES HERE
	        // Please take input and print output to standard input/output (stdin/stdout)
	        // DO NOT USE ARGUMENTS FOR INPUTS
	        // E.g. 'Scanner' for input & 'System.out' for output
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        int dp[] = new int[n+1];
			for(int i=0; i<=n; i++)
				dp[i]=-1;
			dp[0]=0;dp[1]=1;
	        System.out.println(findUsingDPSub(n, dp)); 
	    }
	 public static void mainScalerSol(String[] args) { // bottom up
		    Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    int[] fib = new int[n + 1]; //  fib[i] denotes the i'th fibonacci number
		    fib[0] = 0;
		    fib[1] = 1;
		    for (int i = 2; i <= n; i++)
		      fib[i] = fib[i - 1] + fib[i - 2];
		    System.out.println(fib[n]);
		  }
	public int findFibonacci(int A) {
		if(A==1) return 0;
		if(A==2) return 1;
		return findFibonacci(A-1)+findFibonacci(A-2);
	}
	public int findFibonacciUsingDP(int A) { // top down approach
		int dp[] = new int[15];
		for(int i=0; i<=A; i++)
			dp[i]=-1;
		dp[1]=0;dp[2]=1;
		return findUsingDP(A, dp);
	}
	public int findUsingDP(int A, int[] dp) {
		if(dp[A]!=-1) return dp[A];
		dp[A] = findUsingDP(A-1, dp) + findUsingDP(A-2, dp);
		return dp[A];
	}
	public int findFibonacciUsingDPBottomUp(int A) { // bottom up approach
		int dp[] = new int[15];
		for(int i=0; i<=A; i++)
			dp[i]=-1;
		dp[1]=0;dp[2]=1;
		return findUsingDPBU(A, dp);
	}
	public int findUsingDPBU(int A, int[] dp) {
		for(int i=3; i<=A; i++)
			dp[i] = dp[i-1] + dp[i-2];
		return dp[A];
	}
	public int findFibonacciUsingTwoVar(int A) { // using only 2 variables
		int a=0, b=1;
		if(A==1) return 0;
		if(A==2) return 1;
		for(int i=3; i<=A; i=i+2) {
			a=a+b; b=a+b;
		}
		if(A%2==0) return b;
		else return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciSeries fs = new FibonacciSeries();
		System.out.println(fs.findFibonacci(3)); // 1
		System.out.println(fs.findFibonacci(5)); // 3
		System.out.println(fs.findFibonacci(8)); // 13
		System.out.println(fs.findFibonacciUsingDP(3)); // 1
		System.out.println(fs.findFibonacciUsingDP(5)); // 3
		System.out.println(fs.findFibonacciUsingDP(8)); // 13
		System.out.println(fs.findFibonacciUsingDPBottomUp(3)); // 1
		System.out.println(fs.findFibonacciUsingDPBottomUp(5)); // 3
		System.out.println(fs.findFibonacciUsingDPBottomUp(8)); // 13
		System.out.println(fs.findFibonacciUsingTwoVar(3)); // 1
		System.out.println(fs.findFibonacciUsingTwoVar(5)); // 3
		System.out.println(fs.findFibonacciUsingTwoVar(8)); // 13
		fs.main1(args);
	}

}
