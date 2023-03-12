package searching2_060223;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
// https://www.scaler.com/academy/mentee-dashboard/class/50140/homework/problems/5153/?navref=cl_pb_nv_tb
public class AddOrNot {

	// check
	public int[] solve(int[] A, int B) {
		int max = Integer.MIN_VALUE, res=0;
		Arrays.sort(A);
		int n=A.length;
		long[] pf = new long[n];
		pf[0] = A[0]*1L;
		for(int i=1; i<n;i++) {
			pf[i] = pf[i-1]+A[i];
		}
		for(int i=1; i<n; i++) {
			int low = 1, high = i+1;
			while(low<=high) {
				int mid = (low+high)>>1;
				long val1 = A[i]*1L;
				long val2 = pf[i];
				long val3 = (i-mid) < 0?0:pf[i-mid];
				long val = (mid*val1) - (val2-val3);
				if(val<=B) {
					if(mid>max) {
						max = mid;
						res = A[i];
					}
					low = mid+1;
				}
				else high = mid-1;
			}
		}
		int[] ans = new int[2];
		ans[0] = max;
		ans[1] = res;
		return ans;
		
    }
	public int[] solve2(int[] A, int B) {

        Arrays.sort(A);

        long[] prefix = new long[A.length+1];
        prefix[0] = 0;
        for(int i=1; i<=A.length; i++)
        {
            prefix[i] = prefix[i-1]+A[i-1];
        }

        int max_count = -1;
        int max_num = -1;
        for(int i=0; i<A.length; i++)
        {
            int low = 1;
            int high = i+1;
            while(low<=high)
            {
                int mid = (low+high)>>1;
                long sum = prefix[i+1]-prefix[i+1-mid];
                if(1L*A[i]*mid - sum <= B)
                {
                    if(mid > max_count)
                    {
                        max_count = mid;
                        max_num = A[i];
                    }
                    low = mid+1;
                }
                else
                    high = mid-1;
            }
        }
        return new int[]{max_count, max_num};
    }
	public int[] solveBrute(int[] A, int B) { // O(N2)
		int count=0, n=A.length, operations = B;
		Arrays.sort(A);
		int[] ans = new int[2];
		ans[0] = ans[1] = -1;
		for(int i=0; i<n; i++) {
			count =0;
			operations = B;
			for(int j=i; j>=0; j--) {
				if(A[i]-A[j]<=operations) {
					operations -= A[i]-A[j];
					count++;
				} else break;
			}
			if(ans[0]<count) {
				ans[0] = count;
				ans[1] = A[i];
			}
		}
		return ans;
		/*
		 * HashMap<Integer, Integer> hm = new HashMap<>(); for(int i=0; i<A.length; i++)
		 * { if(hm.containsKey(A[i])) hm.put(A[i], hm.get(A[i])+1); else hm.put(A[i],
		 * 1); } for(Entry<Integer, Integer> entry : hm.entrySet()) {
		 * System.out.println(entry.getKey() + " " + entry.getValue()); }
		 * System.out.println();
		 */
    }
	public int[] solveScalerSol(int[] A, int B) {
	      // To do the prefix sum
	      long prefix[] = new long[A.length + 1];
	      Arrays.sort(A);
	      int n = A.length;
	      // Make prefix array
	      for (int i = 0; i < n; i++) {
	         prefix[i + 1] += A[i] + prefix[i];
	      }
	      int ans[] = new int[2];
	      ans[0] = -1;
	      ans[1] = -1;
	      for (int i = 0; i < n; i++) {
	         int lo = 1, hi = i + 1;
	         int mx = 0;
	         // Binary search to find the value of cnt for each i
	         while (lo <= hi) {
	            int cnt = (lo + hi) / 2;
	            if ((long) A[i] * cnt - (prefix[i + 1] - prefix[i - cnt + 1]) <= B) {
	               mx = cnt;
	               lo = cnt + 1;
	            } else {
	               hi = cnt - 1;
	            }
	         }
	         // Update ans
	         if (ans[0] < mx) {
	            ans[0] = mx;
	            ans[1] = A[i];
	         }
	      }
	      return ans;
	   }
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++) System.out.print(A[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOrNot aon = new AddOrNot();
		int[] A = {3,1,2,2,1};
		int[] B = aon.solveBrute(A, 3); // 4 2
		aon.printArray(B);
		int[] X = aon.solve(A, 3); // 4 2 
		aon.printArray(X);
		int[] C = {5,5,5};
		int[] D = aon.solveBrute(C, 3); // 3 5
		aon.printArray(D);
		int[] E = aon.solve(C, 3); // 2 5 
		aon.printArray(E);
	}

}
