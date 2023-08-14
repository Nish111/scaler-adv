package contest_050823;

public class MinimumPartition {
    public int solve(int[] A) {
        int ans = 0;
		int n = A.length;
		int[] prev = new int[n];
		prev[0] = 0;
		for(int i=1; i<n; i++){
			if(A[i] == A[i-1]){
				prev[i] = prev[i-1];
				continue;
			}
			else if(A[i]>A[i-1]) {
				if(prev[i-1] == 0) 
					prev[i] = 1;
				else if(prev[i-1] == -1){
					prev[i] = 0;
					ans++;
				}
				else prev[i] = prev[i-1];
			}
			else if(A[i]<A[i-1]){
		    	if(prev[i-1] == 0) prev[i] = -1;
			    else if(prev[i-1] == 1){
				    prev[i]=0;
				    ans++;
			    }
			    else prev[i] = prev[i-1];
			}
		}
		return ans+1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumPartition mp = new MinimumPartition();
		int[] A = {2,1,2,3,3,1};
		System.out.println(mp.solve(A)); // 3
		int[] B = {2,2,2,2};
		System.out.println(mp.solve(B));// 1
	}

}
