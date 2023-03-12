package math1_modarith_160123;
// https://www.scaler.com/academy/mentee-dashboard/class/50131/assignment/problems/80?navref=cl_tt_lst_nm
public class CountTrailingZeroes{
	
	public int countTrailingZeroes(int A) { // O(logN/log5)
		int count=0, sum=0, temp=5;
		while(A/temp>0) {
			count = A/temp;
			temp *=5;
			sum += count;
		}
		return sum;
	}
	public int trailingZeroesScalerSol(int A) {
	    int count = 0;
        long num = 5;
        // count multiples of 5
        while (num <= 1L * A) {
            count += ((int) (A / num));
            num *= 5;
        }
	    return count;
	}
	public static void main(String[] args) {
		CountTrailingZeroes ctz = new CountTrailingZeroes();
		System.out.println(ctz.countTrailingZeroes(5)); // 1
		System.out.println(ctz.countTrailingZeroes(10)); // 2
		System.out.println(ctz.countTrailingZeroes(30)); // 7
		System.out.println(ctz.countTrailingZeroes(50)); // 12
		System.out.println(ctz.countTrailingZeroes(150)); // 37
		System.out.println(ctz.countTrailingZeroes(340)); // 83
		// 340 = 68+13+2 = 83
		
	}

}
