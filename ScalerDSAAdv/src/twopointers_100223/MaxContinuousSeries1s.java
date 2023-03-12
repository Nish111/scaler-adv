package twopointers_100223;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50142/homework/problems/273/?navref=cl_pb_nv_tb
public class MaxContinuousSeries1s {

	public int[] maxone(int[] A, int B) { // check again
		int l = 0, r=0, n=A.length;
		int zeros=0;
		int max=0, start=0, end=0;
		for(r = 0; r<n; r++) {
			if(A[r]==0) zeros++;
			while(zeros>B) {
				if(A[l]==0) zeros--;
				l++;
			}
			int curr_len = r-l+1;
			if(curr_len>max) {
				max = curr_len;
				start = l;
			}
		}
		int[] ans = new int[max];
		for(int i=0; i<max; i++) {
			ans[i]=start;
			start++;
		}
		return ans;
    }
	public ArrayList<Integer> maxoneScalerSol(ArrayList<Integer> A, int B) {
	    ArrayList<Integer> zeroPos = new ArrayList<>();
	    ArrayList<Integer> res = new ArrayList<>();
	    if (A == null)
	        return res;
	    int n = A.size();
	    // store the index of all the 0's
	    for (int i = 0; i < n ; i++) {
	        int num = A.get(i);
	        if (num == 0)
	            zeroPos.add(i);
	    }
	    if (B >= zeroPos.size()) {
	        for (int i = 0; i < n; i++)
	            res.add(i);
	        return res;
	    }
	    int i = 0;
	    int j = B;
	    int maxSize = 0;
	    int start, end;
	    start = 0;
	   // find the longest segment by removing B 0's
	    while (j <= zeroPos.size()) {
	        if (j == zeroPos.size())
    	        end = n - 1;
    	    else
    	        end = zeroPos.get(j) - 1;
	        
	        int size = end - start + 1;
	        
	        if (size > maxSize) {
	            maxSize = size;
	            res.clear();
	            res.add(start);
	            res.add(end);
	        }
	        
	        if (j == zeroPos.size())
	            break;
	        
	        start = zeroPos.get(i) + 1;
	        i++;
	        j++;
	    }
	    start = res.get(0);
	    end = res.get(1);
	    res.clear();
	    for (i = start; i <= end; i++)
	        res.add(i);
	    return res;
	}
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxContinuousSeries1s mcs = new MaxContinuousSeries1s();
		int[] A = {1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
		int[] B = mcs.maxone(A, 1);
		mcs.printArray(B); // 0 1 2 3 4 
		int[] C = {1, 0, 0, 0, 1, 0, 1};
		int[] D = mcs.maxone(C, 2);
		mcs.printArray(D); // 3 4 5 6 
	}

}
