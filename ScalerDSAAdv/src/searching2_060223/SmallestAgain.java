package searching2_060223;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/50140/homework/problems/9155/?navref=cl_pb_nv_tb
public class SmallestAgain {

	public int solveBrute(int[] A, int B) { //O(N3logN3) O(N3)
		// traverse all triplets, push sum in array, sort array and return arr[B-1]
		int sum=0, count=0;
		for(int i=0; i<A.length-2; i++) {
			sum=0;
			
		}
		return count;
    }
	public int solve(int[] A, int B) {
		int ans=-1, count=0, n = A.length;
		Arrays.sort(A);
		if(n<=3) {
			for(int i=0; i<n; i++) {
				ans+=A[i];
			}
			return ans;
		}
		int low = A[0]+A[1]+A[2], high = A[n-1]+A[n-2]+A[n-2];
		while(low<=high) {
			int mid = low + (high-low)/2;
			count = check(mid, A);
			if(count < B) {
				ans = mid;
				low = mid+1;
			} else high = mid-1;
			
		}
		if(ans == -1) return 0;
		else return ans;
    }
	public int check(int mid, int[] A) {
		int n = A.length, count = 0;
		for(int i=0; i<n; i++) {
			int low = i+1, high = n-1;
			while(low<high) {
				if((A[i] + A[low] + A[high]) < mid) {
					count += high-low;
					low++;
				} else high--;
			}
		}
		return count;
	}
	public int checkScalerSol(int[] A, int val) {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            int s = i + 1, e = A.length - 1;
            while (s < e) {
                if (A[i] + A[s] + A[e] < val) {
                    cnt += e - s;
                    s++;
                } else {
                    e--;
                }
            }
        }
        return cnt;
    }

    public int solveScalerSol(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        int low = 0, high = A[n - 1] + A[n - 2] + A[n - 3], ans = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // count of triplets with sum less than mid
            int count = checkScalerSol(A, mid);
            if (count >= B) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestAgain sa = new SmallestAgain();
		int[] A = {2, 4, 3, 2};
		System.out.println(sa.solve(A, 3)); // 9
		int[] B = {1, 5, 7, 3, 2};
		System.out.println(sa.solve(B, 9)); // 14
		
		
	}

}
