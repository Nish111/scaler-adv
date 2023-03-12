package math3_prime_200123;
//https://www.scaler.com/academy/mentee-dashboard/class/50133/assignment/problems/4106?navref=cl_tt_nv
public class NumberOfOpenDoors {
	
	public int solve(int A) { // O(N) so gives TLE as 1<=A<=10^9
		boolean[] arr = new boolean[A+1];
		int count=0;
		for(int i=1; i<=A; i++) {
			arr[i] = false;
		}
		for(int i=1; i<=A; i++) {
			for(int j=i; j<=A; j=j+i) {
				arr[j]=arr[j]?false:true;
			}
		}
		for(int i=1; i<=A; i++) {
			if(arr[i] == true) count++;
		}
		return count;
	}

	public int solve2(int A) {
		return (int) Math.sqrt(A);
	}
	public int solveScalerSol(int A) {
        // find the square root of A
        return (int)Math.sqrt(A);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfOpenDoors nood = new NumberOfOpenDoors();
		System.out.println(nood.solve(5)); // 2
		System.out.println(nood.solve(6)); // 2
		System.out.println(nood.solve(1)); // 1
		System.out.println(nood.solve(4)); // 2
		System.out.println(nood.solve(9507565)); // 3083
		System.out.println(nood.solve2(5)); // 2
		System.out.println(nood.solve2(6)); // 2
		System.out.println(nood.solve2(1)); // 1
		System.out.println(nood.solve2(4)); // 2
		System.out.println(nood.solve2(9507565)); // 3083
	}

}
