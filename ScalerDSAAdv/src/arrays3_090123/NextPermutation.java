package arrays3_090123;

import java.util.ArrayList;
import java.util.Collections;
// https://www.scaler.com/academy/mentee-dashboard/class/50128/homework/problems/71/?navref=cl_pb_nv_tb
public class NextPermutation {

	//1
	public int[] nextPermutation(int[] A) { // working
		  if(A.length<=1) return A;
	      int len = A.length ;
	      for(int i=len-2; i>=0; i--) {
	    	  if(A[i+1]>A[i]) {
	    		  for(int j=len-1; j>i; j--) {
	    			  if(A[j]>A[i]) {
	    				  int temp = A[i];
	    				  A[i] = A[j];
	    				  A[j] = temp;
	    				  break;
	    			  }
	    		  }
	    		  reverse(A, i+1, len-1);
	    		  return A;
	    	  }
	      }
	      reverse(A,0,len-1);
	      return A;
	    }

	    public void reverse(int[] A, int start, int end){
	        while(start<end){
	        	int temp = A[start];
	        	A[start] = A[end];
	        	A[end] = temp;
	            start++;
	            end--;
	        }
	    }
	    public void printArray(int[] A) {
	    	for(int i=0; i<A.length; i++)
	    		System.out.print(A[i] +" ");
	    	System.out.println();
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
	            //swap(A, i, j);
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
	    public ArrayList<Integer> nextPermutationScalerSol(ArrayList<Integer> A) {
		    boolean status;
		    status = nextPermScalerSol(A);
		    if (!status)
		        Collections.sort(A);
		    return A;
		}
		
		public boolean nextPermScalerSol(ArrayList<Integer> A) {
		    
		    int i = 0;
		    int n = A.size();
		    
		    for (i = n - 2; i >= 0; i--) {
		        if (A.get(i) < A.get(i + 1))
		            break;
		    }
		    
		    // the array is in descending order
		    if (i == -1)
		        return false;
		   
		    int j = n - 1;
		    for (; j >= i; j--) {
		        if (A.get(j) > A.get(i))
		            break;
		    }
		    
		    // swap with the smallest number in the suffix
		    swapScalerSol(A, i, j);
		    
		    // reversing the suffix
		    i++;
		    int steps = (n - i + 1) / 2;
		    for (int k = 0; k < steps; k++) {
		        swapScalerSol(A, i + k, n - k - 1);
		    }
		    
		    return true;
		}
		
		public void swapScalerSol(ArrayList<Integer> A, int i, int j) {
		    int temp = A.get(i);
		    A.set(i, A.get(j));
		    A.set(j, temp);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation np = new NextPermutation();
		int[] A = {1,3,2};
		int[] B = np.nextPermutation(A);
		np.printArray(B); // 2 1 3 
		int[] C = {1, 5, 8, 4, 7, 6, 5, 3, 1};
		int[] D = np.nextPermutation(C);
		np.printArray(D); // 1 5 8 5 1 3 4 6 7 
		int[] E = { 5, 4, 3, 1};
		int[] F = np.nextPermutation(E); // 1 3 4 5 
		np.printArray(F); // 1 5 8 5 1 3 4 6 7
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		ArrayList<Integer> alr = np.nextPermutationScalerSol(al);
		ArrayList<Integer> al2 = new ArrayList<>();
		al2.add(1);
		al2.add(1);
		al2.add(5);
		ArrayList<Integer> al2r = np.nextPermutationScalerSol(al2);
		
	}


}
