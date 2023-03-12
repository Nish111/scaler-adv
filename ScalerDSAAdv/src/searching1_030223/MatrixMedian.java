package searching1_030223;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/50139/homework/problems/357/?navref=cl_pb_nv_tb
public class MatrixMedian {

	// need to check again
	public int findMedianBrute(int[][] A) {
		int row = A.length;
		int col = A[0].length;
		int[] arr = new int[row*col];
		int count=0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				arr[count] = A[i][j];
				count++;
			}
		}
		for(int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
		System.out.println();
		
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
		System.out.println();
		
		return arr[arr.length/2];
    }
	public int findMedianVideo(int[][] A) {
		int l=0, r=0;
		int temp = (A.length*A[0].length)/2+1;
		int mid=0;
		for(int i = 0; i<=A.length-1; i++) { // finding max element from all cols
			r = Math.max(r, A[i][A[0].length-1]);
		}
		int ans = -1;
		while(l<=r) {
			mid = l+(r-l)/2;
			int count=0;
			for(int[] row:A) {
				int p = count(row, mid);
				count += p;
			}
			if(count >= temp) {
				ans = mid;
				r = mid-1;
			}
			else {
				l = mid+1;
			}
		}
		return ans;
	}
	public int count(int[] A, int k) { // will count number of elements in A lhoe k
		int l=0; int r = A.length-1;
		int ans = -1;
		while(l<=r) {
			int x = (l+r)/2; // median so taking mid
			if(A[x]>k) {
				ans = x;
				r = x-1;
			} 
			else l = x+1;
		}
		if(ans == -1) return A.length;
		return ans;
	}
	 public int lowerBoundScalerSol(int A[], int val){    
	        int l = 0, h = A.length-1, ans = -1;
	        while(l <= h){
	            int mid = (h - l) / 2 + l;
	            if(A[mid] < val){
	                ans = mid;
	                l = mid + 1;
	            }
	            else
	                h = mid - 1;
	        }
	        return ans + 1;
	    }
	    public int findMedianScalerSol(int[][] A) {
	        int low = 0, high = 1000000000, n = A.length, m = A[0].length;
	        int medPos = n * m / 2, ans = -1; // number of elements less than median element
	        while(low <= high){
	            int mid = (high - low)/2 + low;
	            int cnt = 0;
	            //count in each row numer of elements <= mid
	            for(int i = 0; i < n; i++)
	                cnt += lowerBoundScalerSol(A[i], mid);
	            if(cnt > medPos)
	                high = mid - 1;
	            else{
	                ans = mid;
	                low = mid + 1;
	            }
	        }
	        return ans;
	    }
	public int findMedian(int[][] A) {
		int startVal = 0, endVal = 1000000000, midVal;
		int r = A.length;
		int c = A[0].length;
		int n = r * c;
		while (startVal <= endVal) {
			midVal = (endVal + startVal) / 2;
			int ans = 0;
			for (int i = 0; i < r; i++) {
				int l = 0, h = c - 1;
				while (l <= h) {
					int m = l + (h - l) / 2;
					if (A[i][m] <= midVal)
						l = m + 1;
					else
						h = m - 1;
				}
				ans += l;
			}
			if (ans <= n / 2)
				startVal = midVal + 1;
			else
				endVal = midVal - 1;
		}
		return startVal;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixMedian mm = new MatrixMedian();
		int[][] A = {{1,3,5},{2,6,9},{3,6,9}};
		System.out.println(mm.findMedianBrute(A)); // 5
		System.out.println(mm.findMedian(A)); // 5
		System.out.println(mm.findMedianVideo(A)); // 5 
		int[][] B = {{5, 17, 100}};
		System.out.println(mm.findMedianBrute(B)); // 17
		System.out.println(mm.findMedian(B));  // 17
		System.out.println(mm.findMedianVideo(B)); // 17
		int[][] C = {{1,13,15},{2,6,9},{3,6,9}};
		System.out.println(mm.findMedianBrute(C)); // 6
		System.out.println(mm.findMedian(C)); // 6
		System.out.println(mm.findMedianVideo(C)); // 6
		int[][] D = {{1,2,3},{12,16,19},{13,14,15}};
		System.out.println(mm.findMedianBrute(D)); // 13
		System.out.println(mm.findMedian(D)); // 13
		System.out.println(mm.findMedianVideo(D)); // 13
		int[][] E = {{1,8,9},{2,6,7},{3,4,5}}; 
		System.out.println(mm.findMedianBrute(E)); // 5
		System.out.println(mm.findMedian(E)); // 5
		System.out.println(mm.findMedianVideo(E)); // 5
		
	}

}
