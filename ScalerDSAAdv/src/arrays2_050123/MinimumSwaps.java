package arrays2_050123;
// https://www.scaler.com/academy/mentee-dashboard/class/50127/homework/problems/4033/submissions
public class MinimumSwaps {
	public int solve(int[] A, int B) {
		int count=0;
		int maxWin=0;
		int max_val=Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			if(A[i]<= B) count++;
		}
		int s=0; int e=count-1;
		for(int i=s; i<=e; i++) {
			if(A[i]<=B) maxWin++;
		}
		max_val = maxWin;
		s=1; e=count;
		while(e<A.length) {
			if(A[s-1]<=B) maxWin--;
			if(A[e]<=B) maxWin++;
			max_val = Math.max(max_val, maxWin);
			s++; e++;
		}	
		System.out.println(count +" "+max_val);
		return count-max_val;
	}
	public int solveScalerSol(int[] A, int B) {
        int n = A.length;
        int cnt = 0;
        // count number of elements <= B
        for(int x : A)  
            if(x <= B)  
                cnt++;
        // If there is only one element, No need to swap
        if(cnt <= 1)    
            return 0;
        else {
            int l = 0, r = 0, x = 0;
            // Find the count of elements <= B in every window of length cnt using two
            //pointer approach
            while(r < cnt) {
                if(A[r] > B)    
                    x++;
                r++;
            }
            int ans = x;
            while(r < n) {
                if(A[r] > B)   
                    x++;
                if(A[l] > B)    
                    x--;
                ans = Math.min(ans, x);
                r++;    
                l++;
            }
            return ans;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSwaps ms = new MinimumSwaps();
		int[] A = {1, 12, 10, 3, 14, 10, 5};
		System.out.println(ms.solve(A, 8)); //2 
		int[] B = {5, 17, 100, 11};
		System.out.println(ms.solve(B, 20)); // 1
		int[] C = {8, 3, 10, 20, 22, 13, 1, 2, 55, 5, 15, 50};
		System.out.println(ms.solve(C, 5)); // 1
		System.out.println(ms.solve(B, 20));
		
	}

}
