package math4_combinatorics_240123;
// https://www.scaler.com/academy/mentee-dashboard/class/50134/homework/problems/6707/submissions
public class ConsecutiveNumbersSum {

	public int solveBrute(int A) { // O(n2 )
		int count = 0, sum=0;
		for(int i=1; i<=A/2; i++) {
			sum=0;
			for(int j=i; j<=A/2+1; j++) {
				sum+=j;
				if(sum==A) count++;
			}
		}
		return count+1;
    }
	public int solve(int A) { // O(sqrtA)
		int count = 0;
		for(int k=1; k<=Math.sqrt(2*A); k++) {
			int temp = (A-((k)*(k-1)/2));
			if(temp%k==0) count++;
		}
		return count;
    }
	public int solveScalerSol(int A) {
        int ans = 0;
        long n = 1;
        while(n * (n + 1) <= 2 * A) {
            // check if the difference between A and sum of n consecutive numbers is a multiple of n    
            long sum = n * (n + 1) / 2;
            if((A - sum) % n == 0) ans++;
            n++;
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsecutiveNumbersSum cns = new ConsecutiveNumbersSum();
		System.out.println(cns.solveBrute(5)); // 2 - 5 2,3
		System.out.println(cns.solveBrute(15)); // 4 - 15 7,8 3,4,5 1,2,3,4,5
		System.out.println(cns.solveBrute(4449)); // 4 - TLE
		System.out.println(cns.solveBrute(6997)); // 2 - TLE
		System.out.println(cns.solve(5)); // 2 - 5 2,3
		System.out.println(cns.solve(15)); // 4 - 15 7,8 3,4,5 1,2,3,4,5
		System.out.println(cns.solve(4449)); // 4
		System.out.println(cns.solve(6997)); // 2
		
	}

}
