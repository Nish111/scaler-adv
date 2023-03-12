package searching1_030223;
// https://www.scaler.com/academy/mentee-dashboard/class/50139/assignment/problems/204/submissions
public class BinarySearch {

	public int binarySearch(int[] A, int k) { // O(logn) // class
		int low = 0;
		int high = A.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(A[mid]==k) return mid; // found it
			else if(A[mid]>k) high = mid-1; // go left
			else low = mid+1; // go right
		}
		return -1;
	}
	// if not found return index where it can be inserted
	public int binarySearch2(int[] A, int k) { // O(logn)
		int low = 0;
		int high = A.length-1;
		int mid = (low+high)/2;
		while(low<=high) {
			mid = (low+high)/2;
			if(A[mid]==k) return mid; // found it
			else if(A[mid]>k) high = mid-1; // go left
			else low = mid+1; // go right
			//corner cases when k not found and index is higher or lower
			if(A[high]<k) return high+1;
			if(A[low]>k) return low;
		}
		return mid;// i think never encounterd as above corner takes care
		// without corner cases, low will return correct
	}
	 public int searchInsertScalerSol(int[] A, int B) {
	        int l = 0, h = A.length - 1;
	        int ans = A.length;
	        while (l <= h) {
	            int mid = l + (h - l) / 2;
	            if (A[mid] > B) {
	                ans = Math.min(ans, mid);
	                h = mid - 1;
	            } else if (A[mid] < B) {
	                l = mid + 1;
	            } else 
	                return mid;
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch bs = new BinarySearch();
		int[] A = {3,6,9,12,19, 20, 23, 25, 27};
		System.out.println(bs.binarySearch(A, 9)); // 2 returns index
		System.out.println(bs.binarySearch(A, 8)); // -1
		System.out.println(bs.binarySearch2(A, 8)); // 2
		System.out.println(bs.binarySearch2(A, 9)); // 2
		int[] B = {1, 3, 5, 6};
		System.out.println(bs.binarySearch(B, 5)); // 2
		System.out.println(bs.binarySearch2(B, 5)); // 2
		System.out.println(bs.binarySearch(B, 7)); // -1
		System.out.println(bs.binarySearch2(B, 7)); // 4
		int[] C = {141, 144, 145, 154, 229, 235, 243, 266, 344, 351, 466, 499, 512, 565, 641, 675, 690, 726, 805, 879, 978, 986 };
		System.out.println(bs.binarySearch(C, 65)); // -1
		System.out.println(bs.binarySearch2(C, 65)); // 0
		int[] D = {3, 4, 18, 19, 20, 27, 28, 31, 36, 42, 44, 71, 72, 75, 82, 
				86, 88, 97, 100, 103, 105, 107, 110, 116, 118, 119, 121, 122, 
				140, 141, 142, 155, 157, 166, 176, 184, 190, 199, 201, 210, 212, 
				220, 225, 234, 235, 236, 238, 244, 259, 265, 266, 280, 283, 285, 
				293, 299, 309, 312, 317, 335, 341, 352, 354, 360, 365, 368, 370, 
				379, 386, 391, 400, 405, 410, 414, 416, 428, 433, 437, 438, 445, 
				453, 457, 458, 472, 476, 480, 485, 489, 491, 493, 501, 502, 505, 
				510, 511, 520, 526, 535, 557, 574, 593, 595, 604, 605, 612, 629, 
				632, 633, 634, 642, 647, 653, 654, 656, 658, 686, 689, 690, 691, 
				709, 716, 717, 737, 738, 746, 759, 765, 775, 778, 783, 786, 787, 
				791, 797, 801, 806, 815, 820, 822, 823, 832, 839, 841, 847, 859, 
				873, 877, 880, 886, 904, 909, 911, 917, 919, 937, 946, 948, 951, 
				961, 971, 979, 980, 986, 993 };
		System.out.println(bs.binarySearch(D, 902)); // -1
		System.out.println(bs.binarySearch2(D, 902)); // 149
	}

}
