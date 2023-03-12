package bitmanipu1_110123;
// https://www.scaler.com/academy/mentee-dashboard/class/50129/assignment/problems/192/submissions
public class NumberOf1Bits {

	public int numSetBits(int A) {
		int count=0;
		while(A>0) {
			if((A & 1) ==1) count++;
			A=A>>1;
		}
		return count;
    }
	 public int numSetBitsScalerSol(long A) {
	        int total_ones = 0;
	        while (A != 0) {
	            // rightmost set bit becomes unset
	            A = A & (A - 1);
	            total_ones++;
	        }
	        return total_ones;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOf1Bits nob = new NumberOf1Bits();
		System.out.println(nob.numSetBits(11)); // 3
		System.out.println(nob.numSetBits(6)); // 2
		
		
	}

}
