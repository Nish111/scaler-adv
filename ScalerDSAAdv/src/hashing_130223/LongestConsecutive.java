package hashing_130223;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
// https://www.scaler.com/academy/mentee-dashboard/class/50143/assignment/problems/152?navref=cl_tt_lst_sl
public class LongestConsecutive {

	public int longestConsecBrute(int[] A) { // O(nlogn) O(1)
		Arrays.sort(A); // O(logn)
		int ans = 1, count=1;;
		for(int i=1; i<A.length; i++) {
			if(A[i]==A[i-1]) continue; // to cater for duplicates
			else if(A[i]-A[i-1] == 1) {
				count++;
				ans = Math.max(ans, count);
			}
			else count=1;
		}
		return ans;
	}
	public int longestConsec(int[] A) {
		int ans = 1, count=1;
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<A.length; i++) {
			hs.add(A[i]);
		}
		for(int i=0; i<A.length; i++) {
			if(hs.contains(A[i]-1)) {
				count=1;
			}
			else {
				count=1; // to cater duplicate elements
				int j=1;
				while(hs.contains(A[i]+j)) {
					count++;
					j++;
					ans = Math.max(ans, count);
				}
			}
		}
		return ans;
	}
	public int longestConsecutiveScalerSol(final List<Integer> A) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxCount = 0;
        for (int ele : A) {
            if (!mp.containsKey(ele)) {
                int lCount = 0;
                int rCount = 0;
                // lCount stores longest consecutive element till the current element - 1
                if (mp.containsKey(ele - 1)) {
                    lCount = mp.get(ele - 1);
                }
                // rCount stores longest consecutive element from the current element + 1
                if (mp.containsKey(ele + 1)) {
                    rCount = mp.get(ele + 1);
                }
                mp.put(ele, lCount + 1 + rCount);
                if(mp.containsKey(ele - lCount))
                    mp.put(ele - lCount, mp.get(ele));
                else
                    mp.put(ele - lCount, mp.get(ele));
                if(mp.containsKey(ele + rCount))
                    mp.put(ele + rCount, mp.get(ele));
                else
                    mp.put(ele + rCount, mp.get(ele));
                if (maxCount < lCount + 1 + rCount) 
                    maxCount = lCount + 1 + rCount;
            }
        }
        return maxCount;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutive lc = new LongestConsecutive();
		int[] A = {100, 4, 200, 1, 3, 2};
		System.out.println(lc.longestConsecBrute(A)); // 4
		System.out.println(lc.longestConsec(A));  // 4
		int[] B = {100, 4, 3, 6, 10, 20, 1, 101, 102};
		System.out.println(lc.longestConsecBrute(B)); // 3
		System.out.println(lc.longestConsec(B)); // 3
		int[] C = {2, 1};
		System.out.println(lc.longestConsecBrute(C)); // 2
		System.out.println(lc.longestConsec(C)); // 2
		int[] D = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
		System.out.println(lc.longestConsecBrute(D)); // 5
		System.out.println(lc.longestConsec(D)); // 5
	}

}
