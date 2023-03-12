package math1_modarith_160123;
// https://www.scaler.com/academy/mentee-dashboard/class/50131/homework/problems/5840/hints?navref=cl_pb_nv_tb
public class ABModulo {

	public int solve(int A, int B) { // TLE
		// anyway max value will be A-B
		int x = Math.abs(A-B);
		int count=0;
		int val=0, max_val=Integer.MIN_VALUE;
		for(int i=1; i<=x; i++) {
			if(x%i == 0) {
				val=i;
				count++;
			}
			max_val = Math.max(max_val, val);
		}
		// count will have all factors, need to exclude 1 so
		count--;
		System.out.println(count);
		return max_val;
    }
	public int solveScalerSol(int A, int B) {
        return Math.abs(A - B);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ABModulo abm = new ABModulo();
		System.out.println(abm.solve(1, 2)); // 1
		System.out.println(abm.solve(5, 10)); // 5
		System.out.println(abm.solve(763628, 8517406)); // 7753778
		System.out.println(abm.solve(4, 16)); // 12
		
	}

}
