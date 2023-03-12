package searching3_080223;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50141/homework/problems/270?navref=cl_tt_lst_sl
public class AllocateBooks {

	public int books(int[] A, int B) {
		if(B>A.length) return -1;
		int max_len = A[0];
		int sum_len = A[0];
		int n = A.length;
		for(int i=1; i<n; i++) {
			max_len = Math.max(max_len, A[i]);
			sum_len += A[i];
		}
		int low = max_len;
		int high = sum_len;
		int ans = 0;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(check(B, A, mid)) {
				ans = mid;
				high = mid-1;
			} else low = mid+1;
		}
		return ans;
    }
	public boolean check(int B, int arr[], int time) {
		int count = 1;
		int total_time=0;
		int n = arr.length;
		for(int i=0; i<n; i++){
			total_time += arr[i];
			if(total_time > time) {
				count++;
				total_time = arr[i];
			}
		}
		if(count>B) return false;
		else return true;
	}
	public int booksScalerSol(ArrayList<Integer> A, int B) {
	    int students = B;
	    long high = Long.MAX_VALUE;
	    long low = 0;
	    long mid, res = 0;
	    if (B > A.size())
	        return -1;
	    long sum = 0;
	    for (int pages : A)
	        sum += pages;
	    while (low <= high) {
	        mid = low + ((high - low) >> 1);
	        
	        if (isPossibleScalerSol(A, B, mid, sum)) {
	            res = mid;
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    }
	    return (int) res;
	}
	private boolean isPossibleScalerSol(ArrayList<Integer> A, int B, long maxPage, long totalPages) {
	    if (maxPage < totalPages / B)
	        return false;
	    int index = 0;
	    int n = A.size();
	    int i;
	    for (i = 0; i < B && index < n; i++) {
	        long page = maxPage;
	        long total = 0;
	        while (total < maxPage && index < n) {
	            total += A.get(index);
	            if (total > maxPage)
	                break;
	            index++;
	        }
	    }
	    if (index < n)
	        return false;
	    return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllocateBooks ab = new AllocateBooks();
		int[] A = {12, 34, 67, 90};
		System.out.println(ab.books(A, 2)); // 113
		int[] B = {31, 14, 19, 75};
		System.out.println(ab.books(B, 12)); // -1
	}

}
