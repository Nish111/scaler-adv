package backtracking2_170423;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
// https://www.scaler.com/academy/mentee-dashboard/class/70942/homework/problems/140/?navref=cl_pb_nv_tb
public class CombinationSum2 {
	    ArrayList < ArrayList < Integer >> ans;
	    HashSet < String > set;
	    public ArrayList < ArrayList < Integer >> combinationSum(ArrayList < Integer > A, int B) {
	        set = new HashSet < > ();
	        ans = new ArrayList < > ();
	        Collections.sort(A);
	        HashMap < Integer, Integer > map = new HashMap < > ();
	        for (int i = 0; i < A.size(); i++) map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
	        combinations(new ArrayList < > (), B, A, map);
	        return ans;
	    }

	    private void combinations(ArrayList < Integer > arrangement, int target, ArrayList < Integer > A, HashMap < Integer, Integer > map) {

	        if (target == 0) {
	            ArrayList < Integer > arr = new ArrayList < > (arrangement);
	            Collections.sort(arr);
	            if (set.add(arr.toString())) ans.add(new ArrayList < Integer > (arrangement));
	            return;
	        }
	        for (int key: A) {
	            if (map.get(key) > 0 && target - key >= 0) {
	                target -= key;
	                arrangement.add(key);
	                map.put(key, map.get(key) - 1);
	                combinations(arrangement, target, A, map);
	                arrangement.remove(arrangement.size() - 1);
	                target += key;
	                map.put(key, map.get(key) + 1);
	            }
	        }
	    }
	    ArrayList < ArrayList < Integer >> res;
	    public ArrayList < ArrayList < Integer >> combinationSumScalerSol(ArrayList < Integer > A, int B) {
	        if (A == null)
	            return null;
	        res = new ArrayList < > ();
	        Collections.sort(A);
	        recScalerSol(A, new ArrayList < > (), B, 0);
	        return res;
	    }
	    public void recScalerSol(ArrayList < Integer > A, ArrayList < Integer > ans, int B, int index) {
	        if (B == 0) {
	            res.add(new ArrayList < > (ans));
	            return;
	        }
	        if (B < 0 || index >= A.size())
	            return;
	        int i = index + 1;
	        for (; i < A.size(); i++)
	            if (A.get(i) != A.get(i - 1))
	                break;
	        recScalerSol(A, ans, B, i);
	        ans.add(A.get(index));
	        recScalerSol(A, ans, B - A.get(index), index + 1);
	        ans.remove(ans.size() - 1);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
