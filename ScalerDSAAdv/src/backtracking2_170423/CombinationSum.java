package backtracking2_170423;

import java.util.ArrayList;
import java.util.Collections;
// https://www.scaler.com/academy/mentee-dashboard/class/70942/homework/problems/136/?navref=cl_pb_nv_tb
public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	    //Sorting data
	    Collections.sort(A);
	    getAllCombi(0, ans, A, new ArrayList<>(), B, 0);
	    return ans;
	}
	
	public void getAllCombi(int indx, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> A, ArrayList<Integer> curr, int target, int sum){
        int n = A.size();
        int temp = indx + 1;
     	//Removing Duplicates
	    while(temp < n && A.get(indx) == A.get(temp++)) indx++;
	        if(indx == n || sum > target){
	            return;
	        }
	        if(sum == target){
	            ans.add(new ArrayList<>(curr));
	            return;
	        }
	        //Add curr data
	        curr.add(A.get(indx));
	        getAllCombi(indx,ans,A,curr,target,sum + A.get(indx));
        	//remove(Undo)
	        curr.remove(curr.size() -1);
	        getAllCombi(indx + 1,ans,A,curr,target,sum);
	
	    }
	    ArrayList < ArrayList < Integer >> res;
	    public ArrayList < ArrayList < Integer >> combinationSumScalerSol(ArrayList < Integer > A, int B) {
	        res = new ArrayList < > ();
	        ArrayList < Integer > unique = new ArrayList < > ();
	        if (A == null)
	            return res;
	        Collections.sort(A);
	        unique.add(A.get(0));
	        // list of all unique candidates
	        for (int i = 0; i < A.size(); i++) {
	            if (i != 0 && A.get(i) != A.get(i - 1))
	                unique.add(A.get(i));
	        }
	        combinationSumScalerSol(unique, new ArrayList < > (), B, 0);
	        return res;
	    }

	    public void combinationSumScalerSol(ArrayList < Integer > A, ArrayList < Integer > res, int B, int index) {
	        if (B == 0) {
	            this.res.add(new ArrayList(res));
	            return;
	        }
	        if (B < 0)
	            return;
	        // try for all possible next candidate
	        for (int i = index; i < A.size(); i++) {
	            int num = A.get(i);
	            res.add(num);
	            combinationSumScalerSol(A, res, B - num, i);
	            res.remove(res.size() - 1);
	        }
	    }
}

