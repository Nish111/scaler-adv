package searching3_080223;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50141/assignment/problems/271?navref=cl_tt_nv
public class Painter {

	public int minTime(int A, int B, int[] arr) {
		int max_len = arr[0];
		int sum_len = arr[0];
		int n = arr.length;
		int mod=10000003;
		for(int i=1; i<n; i++) {
			max_len = Math.max(max_len, arr[i]);
			sum_len += arr[i];
		}
		int low = max_len;
		int high = sum_len;
		long ans = 0;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(check(A, arr, mid)) {
				ans = (mid*(long)B)%mod;
				high = mid-1;
			} else low = mid+1;
		}
		return (int) (ans%mod);
	}
	public boolean check(int A, int arr[], int time) {
		int count = 1;
		int total_time=0;
		int n = arr.length;
		int mod=10000003;
		for(int i=0; i<n; i++){
			total_time += arr[i];
			if(total_time > time) {
				count++;
				total_time = arr[i];
			}
		}
		if(count>A) return false;
		else return true;
	}
	 	int mod=10000003;
	    public int paintersNeeded(int[] A,int k){
	        int N=A.length;
	        int time=0,workers=1;
	        for(int i=0;i<N;i++){
	            time+=A[i];
	            if(time>k){
	                workers++;
	                time=A[i];
	            }
	        }
	        return workers;
	    }
	    public int paint(int A, int B, int[] C) {
	        int N=C.length;
	        int l=Integer.MIN_VALUE,h=0,mid=0;
	        long ans=0;
	        for(int i=0;i<N;i++){
	            l=Math.max(l,C[i]);              //max of array is the lowest
	            h+=C[i];                         //sum of all elements in array is high
	        }
	        while(l<=h){
	            mid=l+(h-l)/2;
	            if(paintersNeeded(C,mid)<=A){
	                ans=(mid*(long)B)%mod;       //total time taken= no.of boards (given arracy C)* time taken for each board(B)
	                h=mid-1;
	            }else{
	                l=mid+1;
	            }
	        }
	        return (int)ans;
	    }
	    private static final int MOD = 10000003;

	    public int paintScalerSol(int A, int B, ArrayList < Integer > C) {

	       long res = Long.MAX_VALUE;
	       long low = 0;
	       long high = Long.MAX_VALUE;
	       long mid;

	       while (low <= high) {
	          mid = low + ((high - low) >> 1);
	          boolean status = possibleScalerSol(A, B, C, mid);
	          if (status) {
	             res = mid;
	             high = mid - 1;
	          } else {
	             low = mid + 1;
	          }
	       }
	       return (int)(res % MOD);
	    }

	    private boolean possibleScalerSol(int A, int B, ArrayList < Integer > C, long time) {
	       int n = C.size();
	       int index = 0;
	       long total;

	       for (int i = 0; i < A && index < n; i++) {
	          total = 0;
	          while (total < time && index < n) {
	             total += (1L * C.get(index) * B);
	             if (total > time)
	                break;
	             index++;
	          }
	       }
	       if (index != n)
	          return false;
	       return true;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Painter p = new Painter();
		int[] arr = {1,8,11,3};
		System.out.println(p.minTime(2, 1, arr)); // 14
		System.out.println(p.paint(2, 1, arr)); // 14
		int[] C = {1000000, 1000000};
		System.out.println(p.minTime(1, 1000000, C)); // 0 - need 9400003
		System.out.println(p.paint(1, 1000000, C)); // 9400003
	} 

}
