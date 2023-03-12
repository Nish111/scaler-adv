package searching2_060223;

import java.util.List;
// https://www.scaler.com/academy/mentee-dashboard/class/50140/assignment/problems/198/?navref=cl_pb_nv_tb
public class TwoArrayMedian {

	public int findMedian(int[] A, int[] B) {
		int n1 = A.length, n2 = B.length;
		if(n2<n1) return findMedian(B,A);
		int low = 0, high=n1;
		while(low<=high) {
			int mid1 = (low+high)/2;
			int mid2 = (n1+n2+1)/2 - mid1; // now 
			int l1 = (mid1==0)?Integer.MIN_VALUE:A[mid1-1];// variable = Expression1 ? Expression2: Expression3
			int l2 = (mid2==0)?Integer.MIN_VALUE:B[mid2-1];
			int r1 = (mid1==n1)?Integer.MAX_VALUE:A[mid1];
			int r2 = (mid1==n2)?Integer.MAX_VALUE:B[mid2];
			if(l1<=r2 && l2<=r1) {
				if((n1+n2)%2 ==0) return (Math.max(l1, l2)+Math.min(r1, r2))/2;
				else return Math.max(l1, l2);
			}
			else if(l1>r2) high = mid1-1;
			else low = mid1+1;
		}
		return 0;
	}
	public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) { // not workng or empty list
		int n1 = A.size(), n2 = B.size();
		if(n2<n1) return findMedianSortedArrays(B,A);
		int low = 0, high=n1;
		while(low<=high) {
			int mid1 = (low+high)/2;
			int mid2 = (n1+n2+1)/2 - mid1; // now 
			int l1 = (mid1==0)?Integer.MIN_VALUE:A.indexOf(mid1-1);// variable = Expression1 ? Expression2: Expression3
			int l2 = (mid2==0)?Integer.MIN_VALUE:B.indexOf(mid2-1);
			int r1 = (mid1==n1)?Integer.MAX_VALUE:A.indexOf(mid1);
			int r2 = (mid1==n2)?Integer.MAX_VALUE:B.indexOf(mid2);
			if(l1<=r2 && l2<=r1) {
				if((n1+n2)%2 ==0) return (Math.max(l1, l2)+Math.min(r1, r2))/2;
				else return Math.max(l1, l2);
			}
			else if(l1>r2) high = mid1-1;
			else low = mid1+1;
		}
		return 0;
	}
	 // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays1(final List<Integer> a, final List<Integer> b) {
        int m = a.size();
        int n = b.size();
        if(m > n){
            return findMedianSortedArrays1(b, a);
        }
        int start = 0;
        int end = m;
        int medianPos = ((m + n) + 1)/2;
        while(start <= end){
            int cut1 = (start + end) /2;
            int cut2 = medianPos - cut1;
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a.get(cut1 - 1);
            int l2 = (cut2 == 0) ? Integer.MAX_VALUE : b.get(cut2 - 1);
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : a.get(cut1);
            int r2 = (cut2 == n) ? Integer.MIN_VALUE : b.get(cut2);
            if(l1 <= r2 && l2 <= r1){
                if((m + n) % 2 != 0){
                    return Math.max(l1,l2);
                }
                else{
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }
            }
            else if(l1 > r2){
                end = cut1 - 1;
            }
            else{
                start = cut1 + 1;
            }
        }
        return 0.0;
    }
    public double findMedianSortedArraysScalerSol(final List<Integer> A, final List<Integer> B) {
	    int len = A.size() + B.size();
	    if(len % 2 == 1) 
	        return findKthScalerSol(A, 0, B, 0, len / 2 + 1);
	    else return (findKthScalerSol(A, 0, B, 0, len / 2) + findKthScalerSol(A, 0, B, 0, len / 2 + 1)) / 2.0;
	}
	public int findKthScalerSol(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
	    if(A_start >= A.size()) 
	        return B.get(B_start + k - 1);
	    if(B_start >= B.size()) 
	        return A.get(A_start + k - 1);
	    if(k == 1) 
	        return Math.min(A.get(A_start), B.get(B_start));
	    int A_key = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;
	    int B_key = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;
	    if(A_key < B_key)
	        return findKthScalerSol(A, A_start + k / 2, B, B_start, k - k / 2);
	    else
	       return findKthScalerSol(A, A_start, B, B_start + k / 2, k - k / 2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoArrayMedian tam = new TwoArrayMedian();
		int[] A = {1,4,8,10,13, 18};
		int[] B = {3,7,11,16,17};
		System.out.println(tam.findMedian(A, B)); // 10
	}

}
