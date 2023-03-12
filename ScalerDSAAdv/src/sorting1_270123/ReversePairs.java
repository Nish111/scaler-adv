package sorting1_270123;

public class ReversePairs {
	public int solve(int[] A) { // O(n2) so TLE
		int count=0;
		for(int i=0; i<A.length-1; i++) {
			for(int j=i+1; j<A.length; j++) {
				if((A[i] == A[j]) && (A[i] == 2000000000)) continue;
				//if(A[i]==A[j]) continue;
				int temp = 2*A[j];
				if(A[i]>temp) count++;
			}
		}
		return count;
    }
	int reversePair = 0;

    public int solve2(int[] A) { // not working from dis
        int n = A.length;
        mergeSort(A,0,n-1);
        return reversePair;
    }
    //merge sort function to split the array into individual elements
    public void mergeSort(int[] A, int s, int e){
        if(s >= e) return;
        int mid = (s+e)/2;
        mergeSort(A,s,mid);
        mergeSort(A,mid+1,e);
        merge(A,s,mid,e);
    }

    //main merge function
    public void merge(int[] A, int s, int mid, int e){
        int n1 = mid - s + 1; //number of elements in array1
        int n2 = e - mid;//number of elements in array2
        int A1[] = new int[n1];
        int A2[] = new int[n2];
        int index = 0;

        //filling A1 and A2
        for(int i = s; i <= mid; i++)
            A1[index++] = A[i];

        index = 0;
        for(int i = mid+1; i <= e; i++)
            A2[index++] = A[i];
       
        int i = 0, j = 0; // i and j referncing A1 and A2 array respectively

        //checking A[i] > 2*A[j] remember merge didnot happened yet
        while(i < n1 && j < n2){
            if((long)A1[i] > 2 * (long)A2[j]){ //handle overflow
                reversePair += n1-i;
                j++;
            }
            else
                i++;
        }

        //merging A1 and A2 in sorted manner

        i = 0; j = 0; // i and j referncing A1 and A2 array respectively
        index = s; // important because using the original input array

        while(i < n1 && j < n2){
            if(A1[i] < A2[j]){ // equals to condition for equal elements
                A[index++] = A1[i++];
            }
            else{
                A[index++] = A2[j++];
            }
        }
        //if some elements still remaining after traversal
        if(i < n1){
            while(i < n1){
                A[index++] = A1[i++];
            }
        }else{
            while(j < n2){
                A[index++] = A2[j++];
            }
        }
    }
    public int solve3(int[] A) { // this one working
        return invCount(A , 0 , A.length - 1);
    }
    public int invCount(int[] A , int left , int right){
        if(left == right){
            return 0;
        }
        // Divide the array into two parts
        int mid = (left + right) / 2;
        int a = invCount(A , left , mid);
        int b = invCount(A , mid + 1 , right);
        // Merge the two parts
        int aWithB = mergeSort(A , left , mid , right);
        return a + b + aWithB;
    }
    public int mergeSort(int[] A , int left , int mid , int right){
        int count = 0;
        int i = left,       // i is index for left subarray
            j = mid + 1,    // j is index for right subarray
            k = 0;          // k is index for resultant merged subarray    
        int[] C = new int[right - left + 1];
        // Counting number of valid pairs
        while(i <= mid && j <= right){            
            if((long)A[i] > (long)2 * A[j]){
                count += mid - i + 1;              
                j++;
            } else {                
                i++;
            }
        }
        // Using Merge Sort to sort and update resultant array
        i = left;
        j = mid + 1;
        while(i <= mid && j <= right){
            if(A[i] <= A[j]){
                C[k] = A[i];
                i++;
                k++;
            } else {
                C[k] = A[j];
                j++;
                k++;
            }
        }
        while(i <= mid){
            C[k] = A[i];
            k++;
            i++;
        }
        while(j <= right){
            C[k] = A[j];
            j++;
            k++;
        }
        /*Copy back the merged elements to original array*/
        k = 0;
        for(int z = left; z <= right; z++){
            A[z] = C[k];
            k++;
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReversePairs rp = new ReversePairs();
		int[] A = {1, 3, 2, 3, 1};
		System.out.println(rp.solve3(A)); // 2
		int[] B = {4, 1, 2};
		System.out.println(rp.solve3(B)); // 1
		int[] C = { 2000000000, 2000000000, -2000000000 };
		System.out.println(rp.solve3(C)); // 2
		int[] D = {769, -71, 599, -1438, -530, -512, 1680, 1907, -301, 492, -844, 1765, -188, 685, -1879, -699, -990, 1022, 459, 528, -930, 1051, 1412, -1598, 245, -480, 1979, 1212, 1177, 447, -509, 881, 1968, -1603, -429, 1165, 405, 426, -1610, 931, -835, -1156, 1273, -143, -940, 199, -1886, -1646, 390, -1349, -256, -256, -103, -135, 637, -605, 55, -1805, -17, -229, 1162, 288, -818, -922, 32, -1032, -1823, -1874, -1650, 146, 721, 1586, 1969, 1720, -993, -1137, -1233, -1629, -879, -277, 444, -1191, -1273, 127, 1785, 1407, -1460, 414, -1578, -1348, 72, -794, 632, 877, 338, 1921, -650, -1314, 1187, -40};
		System.out.println(rp.solve3(D)); // 2761 expected 2760
		int[] E = {1, 3, 2, 3, 1};
		System.out.println(rp.solve(E));
				
	}

}
