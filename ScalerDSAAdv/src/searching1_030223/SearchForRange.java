package searching1_030223;

import java.util.ArrayList;
import java.util.List;

// https://www.scaler.com/academy/mentee-dashboard/class/50139/assignment/problems/199/hints?navref=cl_pb_nv_tb
public class SearchForRange {

	// based on DuplicateEleFirstOccurence
	public int[] searchRange(final int[] A, int B) {

		int[] res = new int[2];
		res[0] = firstOccurence(A, B);//(firstOccurence(A, B)==0)?-1:firstOccurence(A, B);
		res[1] = lastOccurence(A, B);//(lastOccurence(A, B)==0)?-1:lastOccurence(A, B);
		return res;
    }
	public int lastOccurence(int[] A, int B) {
		int low = 0;
		int high = A.length-1;
		int ans=-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(A[mid]==B) {
				ans =  mid; // found it
				low = mid+1;
			}
			else if(A[mid]>B) high = mid-1; // go left
			else low = mid+1; // go right
			//if(A[high]<B) return -1;
			//if(A[low]>B) return -1;
		}
		return ans;
	}
	public int firstOccurence(int[] A, int B) {
		int low = 0;
		int high = A.length-1;
		int ans=-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(A[mid]==B) {
				ans =  mid; // found it
				high = mid-1;
			}
			else if(A[mid]>B) high = mid-1; // go left
			else low = mid+1; // go right
			//if(A[high]<B) return -1;
			//if(A[low]>B) return -1;
		}
		return ans;
	}
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRangeScalerSol(final List<Integer> A, int B) {
	    int low, up;
	    ArrayList<Integer> res = new ArrayList<>();
	    low = lowerBoundScalerSol(A, 0, A.size() - 1, B);
	    if (low == -1) {
	        res.add(-1);
	        res.add(-1);
	        return res;
	    }
	   up = upperBoundScalerSol(A, 0, A.size() - 1, B);
	   res.add(low);
	   res.add(up);
	   return res;
	}
	
	public int lowerBoundScalerSol(final List<Integer> A, int start, int end, int num) {
	    int steps = end - start + 1;
	    int mid;
	    int low = -1;
	    int val;
	    while (steps > 0) {
	        mid = (start + end) / 2;
	        val = A.get(mid);
	        if (num < val)
	            end = mid - 1;
	        else if (num > val)
	            start = mid + 1;
	        else{
	            low = mid;
	            end = mid - 1;
	        }
	        steps /= 2;
	    }
	    return low;
	}
	public int upperBoundScalerSol(final List<Integer> A, int start, int end, int num) {
	    int steps = end - start + 1;
	    int mid;
	    int up = end + 1;
	    int val;
	    while (steps > 0) {
	        mid = (start + end) / 2;
	        val = A.get(mid);
	        if (num < val)
	            end = mid - 1;
	        else if (num > val)
	            start = mid + 1;
	        else{
	            up = mid;
	            start = mid + 1;
	        }
	        steps /= 2;
	    }
	    return up;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchForRange sfr = new SearchForRange();
		int[] A = {5, 7, 7, 8, 8, 10};
		int[] B = sfr.searchRange(A, 8); // 3, 4
		System.out.println(B[0] + " " + B[1]);
		int[] C = {5, 17, 100, 111};
		int[] D = sfr.searchRange(C, 3); // -1, -1
		System.out.println(D[0] + " " + D[1]);
		int[] E = {1};
		int[] F = sfr.searchRange(E, 1); // 0 , 0
		System.out.println(F[0] + " " + F[1]);
		int[] G = {5, 7, 7, 8, 8, 10};
		int[] H = sfr.searchRange(G, 8); // 3,4
		System.out.println(H[0] + " " + H[1]);
		
	}

}
