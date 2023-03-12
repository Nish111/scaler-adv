package twopointers_100223;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50142/assignment/problems/169?navref=cl_tt_nv
public class MaxWaterInWall {

	public int maxWaterAccumulated(int[] A) {
		if(A.length <= 1) return 0;
		int p1=0, p2=A.length-1;
		int sum=Integer.MIN_VALUE;
		int height=Integer.MIN_VALUE, width = Integer.MIN_VALUE;
		while(p1<p2) {
			height = Math.min(A[p1], A[p2]);
			width = p2-p1;
			sum = Math.max(sum, width*height);
			if(A[p1]<A[p2]) p1++;
			else p2--;
		}
		return sum;
	}
	public int maxAreaScalerSol(ArrayList < Integer > A) {
        if (A == null)
            return 0;
        int n = A.size();
        int first = 0;
        int last = n - 1;
        int area = 0;
        while (first < last) {
            int width = last - first;
            // finds the area for the current window
            area = Math.max(area, Math.min(A.get(first), A.get(last)) * width);
            if (A.get(first).intValue() >= A.get(last).intValue())
                last--;
            else
                first++;
        }
        return area;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxWaterInWall mwiw = new MaxWaterInWall();
		int[] A = {3,7,4,5,2};
		System.out.println(mwiw.maxWaterAccumulated(A)); // 10
		int[] B = {1, 5, 4, 3};
		System.out.println(mwiw.maxWaterAccumulated(B)); // 6
		int[] C = {1};
		System.out.println(mwiw.maxWaterAccumulated(C)); // 0
	}

}
