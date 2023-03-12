package searching2_060223;
// https://www.scaler.com/academy/mentee-dashboard/class/50140/assignment/problems/200?navref=cl_tt_lst_sl
public class FloorSqrt {

	public int solveBrute(int N) { // O(sqrtN) O(1)
		int num=0;
		for(int i=1; i<=N; i++) {
			if(i*i <=N) num =i;
		}
		return num;
	}
	public int solve(int N) { //O(logn) binary search
		long l=1, r=N;
		while(l<=r) {
			long mid = (l+r)/2;
			if(mid*mid == N) return (int) mid;
			if((mid*mid) < N && ((mid+1)*(mid+1)>N)) return (int) mid;
			if(mid*mid < N) l = mid+1;
			else r = mid-1;
		}
		return 0;
	}
	public int solve2(int N) { //O(logn) binary search another approach without condition
		// range 10^10 so need long
		long l=0, r=N, res=0;
		long mid = 0;
		while(l<=r) {
			mid = (l+r)/2;
			if(mid*mid <= N) {
				l = mid+1;
				res = mid;
			}
			else r = mid-1;
		}
		return (int) res;
	}
	public int sqrtDis(int A) {

        long l=0,r=A,ans=0, mid = 0;
        while(l<=r){
            mid = l+(r-l)/2;
            if(mid *mid <=A){
            l = mid+1;
            ans = mid;
            }
            else {
                r = mid-1;
            }
        }
        return (int)Math.floor(ans);
    }
	 public int sqrtScalerSol(int A) {
	      int low = 1, high = A, root = 0;
	      while (low <= high) {
	         int mid = (low + high) / 2;
	         if (mid == A / mid && (A % mid == 0))
	            return mid;
	         if (mid <= A / mid) {
	            root = mid;
	            low = mid + 1;
	         } else {
	            high = mid - 1;
	         }
	      }
	      return root;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FloorSqrt fs = new FloorSqrt();
		System.out.println(fs.solveBrute(17)); // 4
		System.out.println(fs.solve(17)); // 4
		System.out.println(fs.solve2(17)); // 4
		System.out.println(fs.solveBrute(17));
		System.out.println(fs.sqrtDis(2147483647)); // 46340
		System.out.println(fs.solve2(2147483647));// 46340
		System.out.println(fs.solveBrute(2147483647));
	}

}
