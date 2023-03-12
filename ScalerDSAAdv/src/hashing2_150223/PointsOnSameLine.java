package hashing2_150223;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// https://www.scaler.com/academy/mentee-dashboard/class/50144/homework/problems/4219?navref=cl_tt_lst_nm
public class PointsOnSameLine {

	public int solve(int[] A, int[] B) {
		// doesnt work just by using 1 point
		HashMap<Integer, Integer> hm = new HashMap<>();
		int count=Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			int diff = A[i] - B[i];
			if(!hm.containsKey(diff)) hm.put(diff, 1);
			else hm.put(diff, hm.get(diff)+1);
		}
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			count = Math.max(count, entry.getValue());
		}
		return count==1?2:count;
    }
	public String findSlope(int x1, int y1, int x2, int y2) {
		int X = x2-x1, Y = y2-y1;
		int factor=gcd(X,Y);
		if(factor !=0) {
			X = X/factor;
			Y = Y/factor;
		}
		String s = X+","+Y;
		return s;
	}
	public int gcd(int x, int y) {
		if(x==0) return y;
		return gcd(y%x, x);
	}
	public int solve1(int[] A, int[] B) {
		int res=2;
		for(int i=0; i<A.length; i++) {
			int count=0;
			HashMap<String, Integer> hm = new HashMap<>();
			for(int j=i+1; j<A.length; j++) {
				int x2 = A[j], y2 = B[j];
				if(x2==A[i] && y2==B[i]) {
					count++;
					continue;
				}
				String s = findSlope(A[i], B[i], x2, y2);
				hm.put(s, hm.getOrDefault(s, 1)+1);
			}
			for(String s:hm.keySet()) {
				int temp = 0;
				temp = Math.max(temp, hm.get(s)+count);
				res = Math.max(res, temp);
			}
		}
		
		return res;
    }
	public int __gcdScalerSol(int x, int y) {
        if (x == 0)
            return y;
        return __gcdScalerSol(y % x, x);
    }
    public int solveScalerSol(int[] A, int[] B) {
        return maxpointsonsameline(A, B);
    }
    public int maxpointsonsameline(int[] x, int[] y) {
        int n = x.length;
        if (n < 3)
            return n;
        int ans = 0;
        int curmax = 0, overlap = 0, vertical = 0;
        for (int i = 0; i < n; ++i) {
            curmax = 0;
            overlap = 0;
            vertical = 0;
            HashMap<ArrayList<Integer>, Integer> mp = new HashMap<ArrayList<Integer>, Integer>();
            for (int j = i + 1; j < n; ++j) {
                if (x[i] == x[j] && y[i] == y[j])
                    ++overlap;
                else if (x[i] == x[j])
                    ++vertical;
                else {
                    int xdiff = x[j] - x[i];
                    int ydiff = y[j] - y[i];
                    int z = __gcdScalerSol(xdiff, ydiff);
                    xdiff /= z;
                    ydiff /= z;
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(xdiff);
                    tmp.add(ydiff);
                    // mp stores the slope of the line between i-th and j-th point
                    if (mp.get(tmp) == null) {
                        mp.put(tmp, 1);
                    } else {
                        mp.put(tmp, mp.get(tmp) + 1);
                    }
                    curmax = Math.max(curmax, mp.get(tmp));
                }
                curmax = Math.max(curmax, vertical);
            }
            ans = Math.max(ans, curmax + overlap + 1);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PointsOnSameLine posl = new PointsOnSameLine();
		int[] A = {-1, 0, 1, 2, 3, 3};
		int[] B = {1, 0, 1, 2, 3, 4};
		System.out.println(posl.solve(A, B)); // 4
		System.out.println(posl.solve1(A, B)); // 4
		int[] C = {3, 1, 4, 5, 7, -9, -8, 6};
		int[] D = {4, -8, -3, -2, -1, 5, 7, -4};
		System.out.println(posl.solve(C, D)); // 2
		System.out.println(posl.solve1(C, D)); // 2
		int[] E = {-10, 7, 4, -5, 4 };
		int[] F = {-6, -4, -6, 0, -8 };
		System.out.println(posl.solve(E, F)); // 2
		System.out.println(posl.solve1(E, F)); // 2
		int[] G = {0, -3, -6, 0, -7, 0, 2, 0, 5 };
		int[] H = {-9, -7, -8, -4, -3, 0, -9, -3, 7 };
		System.out.println(posl.solve(G, H)); // 2
		System.out.println(posl.solve1(G, H));  // 4
	}

}
