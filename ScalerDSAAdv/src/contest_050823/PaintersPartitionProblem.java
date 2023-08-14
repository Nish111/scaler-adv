package contest_050823;
// https://www.scaler.com/test/97de52ecc3/#/problem_5
public class PaintersPartitionProblem {
    public int paint(int A, int B, int[] C) {
        int max_len = C[0];
        int sum_len = C[0];
        int n = C.length;
        int mod = 10000003;
        for(int i=1; i<n; i++){
            max_len = Math.max(C[i], max_len);
            sum_len += C[i]; 
        }
        int low = max_len;
        int high = sum_len;
        long ans = 0;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(check(A, C, mid)){
                ans = (mid*(long)B)%mod;
                high = mid-1;
            }
            else low = mid+1;
        }
        return (int)ans%mod;
    }
    public boolean check(int A, int[] C, int mid){
        int count = 1;
        int total_time = 0;
        int mod = 10000003;
        for(int i=0; i<C.length; i++){
            total_time += C[i];
            if(total_time>mid){
                count++;
                total_time=C[i];
            }
        }
        if(count>A) return false;
        else return true;
    }
}
