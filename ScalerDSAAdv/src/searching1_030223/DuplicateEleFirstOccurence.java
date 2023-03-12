package searching1_030223;

public class DuplicateEleFirstOccurence {

	public int firstOccurence(int[] A, int k) {
		int low = 0;
		int high = A.length-1;
		int ans=0;
		while(low<=high) {
			int mid = (low+high)/2;
			if(A[mid]==k) {
				ans =  mid; // found it
				high = mid-1;
			}
			else if(A[mid]>k) high = mid-1; // go left
			else low = mid+1; // go right
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateEleFirstOccurence defo = new DuplicateEleFirstOccurence();
		int[] A = {1,1,2,2,2,5,5,5,5,7,8};
		System.out.println(defo.firstOccurence(A, 5)); // 5
		System.out.println(defo.firstOccurence(A, 2)); // 2
	}

}
