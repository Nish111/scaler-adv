package math2_gcd_180123;
// https://www.scaler.com/academy/mentee-dashboard/class/50132/homework/problems/967/?navref=cl_pb_nv_tb
public class EnumeratingGCD {

	public String solve(String A, String B) {
		// GCD of 2 consecutive numbers is 1;
		// if A==B then A else 1
		return A.equals(B) ? A : "1";
    }
	public String solveScalerSol(String A, String B) {
        // check if A equals B
        if (A.equals(B))
            return A;
        else 
            return "1";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumeratingGCD eg = new EnumeratingGCD();
		System.out.println(eg.solve("1", "3")); // 1
		System.out.println(eg.solve("3", "3")); // 3
		System.out.println(eg.solve("8", "10")); // 1
		System.out.println(eg.solve("234", "560")); // 1
		System.out.println(eg.solve("1", "3")); // 1
		
		
	}

}
