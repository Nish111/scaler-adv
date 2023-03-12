package sorting1_270123;

public class InversionCount2 {
    int mod = 1000000007;
    long inversionCount = 0l;
    public int solve(int[] A) {
        int n = A.length;
        mergeSort(A,0,n-1);
        return (int) inversionCount;
    }
    public void mergeSort(int[] A, int s, int e){
        if(s >= e) return;
        int mid = (s+e)/2;
        mergeSort(A,s,mid);
        mergeSort(A,mid+1,e);
        merge(A,s,mid,e);
    }

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
        index = s; // important

        while(i < n1 && j < n2){
            if(A1[i] <= A2[j]) // equals to condition for equal elements
                A[index++] = A1[i++];
            else{
                inversionCount = (inversionCount + (A1.length - i))%mod; //here fulfilling problem statement condition
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
    private int Mod = 1000 * 1000 * 1000 + 7;
    public int solveScalerSol(int[] A) {
        return (int) mergeSortScalerSol(A);
    }
    public long mergeSortScalerSol(int[] A) {
        int[] temp = new int[A.length];
        return _mergeSortScalerSol(A, temp, 0, A.length - 1) % Mod;
    }
    public long _mergeSortScalerSol(int arr[], int temp[], int left, int right) {
        int mid;
        long inv_count = 0;
        if (right > left) {
            /* Divide the array into two parts and
            call _mergeSortAndCountInv()  
            for each of the parts */
            mid = (right + left) / 2;
            /* Inversion count will be sum of  
            inversions in left-part, right-part  
            and number of inversions in merging */
            inv_count += _mergeSortScalerSol(arr, temp, left, mid);
            inv_count += _mergeSortScalerSol(arr, temp, mid + 1, right);
            /*Merge the two parts*/
            inv_count += mergeScalerSol(arr, temp, left, mid + 1, right);
        }
        return inv_count % Mod;
    }
    public long mergeScalerSol(int arr[], int temp[], int left, int mid, int right) {
        int i, j, k;
        long inv_count = 0;
        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                inv_count = inv_count + (mid - i);
            }
        }
        /* Copy the remaining elements of left subarray  
                (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];
        /* Copy the remaining elements of right subarray  
                (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];
        /*Copy back the merged elements to original array*/
        for (i = left; i <= right; i++)
            arr[i] = temp[i];
        return inv_count % Mod;
    }
}
