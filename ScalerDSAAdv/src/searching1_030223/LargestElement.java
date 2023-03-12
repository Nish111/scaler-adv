package searching1_030223;
// https://www.scaler.com/academy/mentee-dashboard/class/50139/assignment/problems/4132/submissions
public class LargestElement {

	public int largestElement(int[] A) {
		int low = 0;
		int high = A.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(mid== A.length-1) return A[mid]; // need before below for size 1
			if(mid==0) {
				if(A[mid] > A[mid+1]) return A[mid];
				else return A[mid+1];
			}
			if(A[mid] > A[mid-1] && A[mid]>A[mid+1]) return A[mid];
			if(A[mid+1]>A[mid]) low = mid+1;
			else high = mid-1;
		}
		return -1;
	}
	public int solveScalerSol(int[] A) {
	    // Try to think when will the unique answer exists, 
	    //Unique answer only exists when the elements first increases and then decreases.
	    // Check is first or last element is the answer.
	    int n = A.length;
	    //base cases
	    if (n == 1) return A[0];
	    if (A[1] <= A[0]) return A[0];
	    if (A[n - 1] >= A[n - 2]) return A[n - 1];
	    int low = 1, high = n - 2;
	    while (low <= high) {
	      int mid = (high - low) / 2 + low;
	      if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1])
	        return A[mid];
	      else if (A[mid] >= A[mid - 1])
	        low = mid + 1;
	      else
	        high = mid - 1;
	    }
	    return -1;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestElement le = new LargestElement();
		int[] A = {1,2,3,4,3,2,1};
		int[] B = {1,2,3,4,5};
		int[] C = {5,4,3,2,1};
		System.out.println(le.largestElement(A)); // 4
		System.out.println(le.largestElement(B)); // 5
		System.out.println(le.largestElement(C)); // 5
		int[] D = {5, 17, 100, 11};
		System.out.println(le.largestElement(D)); // 100
		int[] E = {3};
		System.out.println(le.largestElement(E)); // 3
		System.out.println(le.largestElement(C));
		
	}

}
