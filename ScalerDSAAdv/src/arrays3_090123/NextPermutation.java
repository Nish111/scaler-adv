package arrays3_090123;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NextPermutation {

	public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
	
		return A;
	}
	//1
	public int[] nextPermutation(int[] A) {
		  if(A.length<=1) return A;
	        int i = A.length - 2;
	        while(i >= 0 && A[i] >= A[i+1]) i--;
	        if(i >= 0){
	            int j = A.length-1;
	            while(j >= 0 && A[j] <= A[i]) j--;
	            swap(A, i, j);
	        }
	        reverse(A,i+1);
	        return A;
	    }

	    public void swap(int A[], int i, int j){
	        int temp = A[i];
	        A[i] = A[j];
	        A[j] = temp;
	    }

	    public void reverse(int[] A, int start){
	        int end = A.length-1;
	        while(start<end){
	            swap(A, start, end);
	            start++;
	            end--;
	        }
	    }
	    //1
	    //2
	    public int[] nextPermutation2(int[] A) {
	        //Edge case
	        if(A.length<=1) return A;
	        /*
	        Test Case : [1,3,5,4,2]

	        Step 1 - We find A[i] < A[i+1], (3,5) i.e 3 or i==1
	        Step 2 - From the last till i+1 we find A[j]>A[i], (3,4) i.e 4 or i==3
	        Step 3 - Swap A[i] and A[j], new arr after swap will be [1,4,5,3,2]
	        Step 4 - Reverse the digits from i+1 to the end of the array, new arr after reversal will be [1,4,2,3,5]

	        This question is part of Striver's SDE Sheet as well, refer that for more clarity
	        */
	        int i = A.length - 2;
	        while(i>=0 && A[i]>=A[i+1])i--;
	        if(i>=0){
	            int j = A.length - 1;
	            while(A[j]<=A[i])j--;
	            swap(A, i, j);
	        }
	        reverse2(A,i+1,A.length-1);
	        return A;
	    }

	    public void swap2(int[] arr, int i, int j){
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

	    public void reverse2(int[] arr, int i, int j){
	        while(i<j){
	            swap2(arr, i++, j--);
	        }
	    }
	    //2
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation np = new NextPermutation();
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1,1);
		al.add(2,2);
		al.add(3,3);
		ArrayList<Integer> alr = np.nextPermutation(al);
		ArrayList<Integer> al2 = new ArrayList<>();
		al2.add(1,3);
		al2.add(2,2);
		al2.add(3,1);
		ArrayList<Integer> al2r = np.nextPermutation(al2);
		
	}

}
