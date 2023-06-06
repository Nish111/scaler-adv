package searching1_030223;
// https://www.scaler.com/academy/mentee-dashboard/class/50139/homework/problems/196/hints?navref=cl_pb_nv_tb
public class MatrixSearch {

	public int searchMatrix(int[][] A, int B) {
		int low = 0;
		int high = A.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(A[mid][0]==B) return 1; // found it
			else if(A[mid][0]>B) high = mid-1; // go left
			else low = mid+1; // go right
		}
		int temp=0;
		if(low==0) return 0; // if low is 0 means B is less than 0th row
		if(low>A.length-1) { // if B in last row or more than last element
			low = 0;
			high = A[0].length-1;
			while(low<=high) {
				int mid = (low+high)/2;
				if(A[A.length-1][mid]==B) return 1; // found it
				else if(A[A.length-1][mid]>B) high = mid-1; // go left
				else low = mid+1; // go right
			}
			return 0;
		}
		else {
			temp = low-1;
		}
		if(A[0].length==1) return 0; // if only 1 column and element not found return 0
		low = 0;
		high = A[0].length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(A[temp][mid]==B) return 1; // found it
			else if(A[temp][mid]>B) high = mid-1; // go left
			else low = mid+1; // go right
		}
		return 0;
    }
	public int searchMatrixScalerSol(int[][] A, int B) { // optimal
        int n = A.length, m = A[0].length;
        //assume all elements are added to a list and after that it is sorted
        //last index will be n * m - 1
        int low = 0, high = n * m - 1, ans = -1;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            int row = mid / m, col = mid % m;
            if(A[row][col] > B) 
                high = mid - 1;
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        if(ans == -1 || A[ans / m][ans % m] != B) 
            return 0;
        return 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixSearch ms = new MatrixSearch();
		int[][] A = {{1, 3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		System.out.println(ms.searchMatrix(A, 3)); // 1
		int[][] B = {{5, 17, 100, 111}, {119, 120, 127, 131}};   
		System.out.println(ms.searchMatrix(B, 3)); // 0
		System.out.println(ms.searchMatrix(B, 127)); // 1
		int[][] C = {{3}, {29},{36}, {63}, {67}, {72}, {74}, {78}, {85}};
		System.out.println(ms.searchMatrix(C, 41)); // 0
		int[][] D = {{2, 3, 4, 6}, {16, 19, 33, 36}, {37, 38, 38, 41},
			{47, 47, 50, 51}, {55, 57, 58, 62}, {63, 65, 66, 66}, {68, 70, 75, 77},
			{78, 84, 84, 86}, {86, 87, 88, 92}, {94, 95, 96, 97}};
		System.out.println(ms.searchMatrix(D, 81)); // 0
		int[][] E = {{3, 3, 11, 12, 14}, {16, 17, 30, 34, 35}, {45, 48, 49, 50, 52},
			{56, 59, 63, 63, 65}, {67, 71, 72, 73, 79}, {80, 84, 85, 85, 88}, {88, 91, 92, 93, 94}};
		System.out.println(ms.searchMatrix(E, 94)); // 1
	}

}
