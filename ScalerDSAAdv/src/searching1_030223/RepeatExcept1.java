package searching1_030223;
// https://www.scaler.com/academy/mentee-dashboard/class/50139/assignment/problems/4131?navref=cl_tt_nv
public class RepeatExcept1 {

	public int uniqueElementXOR(int[] A) { // O(n) xor
		int xor = 0;
		for(int i=0; i<A.length; i++) xor = xor ^ A[i];
		return xor;
	}
	public int uniqueElement(int[] A) { // O(nlogn) // class
		int low = 0;
		int high = A.length-1;
		int ans=0;
		while(low<=high) {
			int mid = (low+high)/2;
			if(mid==0 || mid ==A.length-1 || 
					(A[mid] != A[mid-1] &&(A[mid] != A[mid+1]))) {
				return A[mid];
			}
			// case where mid is even meaning 0,1,2,3,4 and 4th 5th same
			//so definitely unique will be in right part
			else if(A[mid]==A[mid+1] && mid%2 == 0) low = mid+1;
			// case where mid is odd meaning 0,1,2,3 and 3rd 4th same
			//so definitely unique will be in right part
			else if(A[mid]==A[mid-1] && mid%2 != 0) low = mid+1;
			// else has to be in left part
			else high = mid-1; 
		}
		return ans;
	}
	public int solveScalerSol(int[] A) {
        int ans = 0, n = A.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(mid == n - 1) 
                return A[n-1];
            if(A[mid] == A[mid+1]) 
                mid++;
            // if all elements with index < mid are occuring twice then mid should be odd
            if(mid%2 == 1)
                low = mid + 1;
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return A[ans];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatExcept1 re = new RepeatExcept1();
		int[] A = {1,1,2,2,3,4,4,5,5};
		System.out.println(re.uniqueElementXOR(A)); // 3
		System.out.println(re.uniqueElement(A)); // 3
		int[] B = {1,1,2,3,3,4,4,5,5};
		System.out.println(re.uniqueElementXOR(B)); // 2
		System.out.println(re.uniqueElement(B)); // 2
		int[] C = {1,1,2,2,3,3,4,5,5};
		System.out.println(re.uniqueElementXOR(C)); // 4
		System.out.println(re.uniqueElement(C)); // 4
	}

}
