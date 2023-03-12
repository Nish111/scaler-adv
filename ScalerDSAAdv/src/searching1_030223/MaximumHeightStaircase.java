package searching1_030223;
// https://www.scaler.com/academy/mentee-dashboard/class/50139/homework/problems/4101/submissions
public class MaximumHeightStaircase {

	public int solve(int A) { // not using binary search but GCD
		int count = 0;
		if (A==0) return 0;
		for(int i=1; i<=Math.sqrt(2*A); i++) {
			count++;
		}
		//System.out.println(count);
		for(int i=count; i>0; i--) {
			if(i*(i+1)<=(2*A)) return i;
		}
		return -1;
    }
	public int solveScalerSol(int A) {
        int low = 0, high = 1000*1000*1000, ans = 0;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            if((long)mid * (mid + 1) / 2 > A)
                high = mid - 1;   
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumHeightStaircase mhs = new MaximumHeightStaircase();
		System.out.println(mhs.solve(10)); // 4
		System.out.println(mhs.solve(20)); // 5
		System.out.println(mhs.solve(0)); // 0
		System.out.println(mhs.solve(1)); // 1
		System.out.println(mhs.solve(2)); // 1
		System.out.println(mhs.solve(3)); // 2
	}

}
