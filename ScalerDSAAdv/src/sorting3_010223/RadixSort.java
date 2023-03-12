package sorting3_010223;

import java.util.ArrayList;
import java.util.Arrays;
// https://www.geeksforgeeks.org/radix-sort/
public class RadixSort {

	public int[] radixSort(int[] A) { // not implemented
		
		//ArrayList<Integer, ArrayList<Integer>> ar = new ArrayList<b >();
		
		return A;
	}
	// A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
 
    // A utility function to print an array
    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadixSort rs = new RadixSort();
		int[] A = {22, 59, 234, 6, 999, 224, 33};
		int[] B = rs.radixSort(A);
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		radixsort(arr, arr.length);
	    print(arr, arr.length);
	    System.out.println();
	    int[] C = {3, 30, 34, 5, 9};
	    radixsort(C, C.length);
	    print(C, C.length);
	    System.out.println();
	    int[] D = {2,3,9,0};
	    radixsort(D, D.length);
	    print(D, D.length);
	    System.out.println();
	}

}
