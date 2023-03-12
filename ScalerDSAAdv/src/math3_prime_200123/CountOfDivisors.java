package math3_prime_200123;
// https://www.scaler.com/academy/mentee-dashboard/class/50133/assignment/problems/4107?navref=cl_tt_lst_sl
public class CountOfDivisors {
	  public int[] solve1(int[] A) {
		  int[] res = new int[A.length];
		  for(int i=0; i<A.length; i++) {
			  if(A[i]==1) {
				  res[i]=1;
				  continue;
			  }
			  int count=2;
			  for(int j=2; j<=Math.sqrt(A[i]); j++) {
				  if(A[i]%j==0) {
					  count +=2;
				  }
				  if(j*j==A[i]) count--;
			  }
			  res[i] = count;
		  }
		  return res;
	  }
	  	// S[x] = smallest prime factor of x
	    int S[], SZ, NP = 1001001;
	    
	    void sieveScalerSol() {
	        int n = NP;
	        S = new int[n];
	        for(int i = 1; i < n; i++) 
	            S[i] = i;
	        for(int i = 2; i * i <= n; i++) {
	            if( S[i] != i )
	                continue;
	            for(int j = i * i; j < n; j += i) {
	                if(S[j] == j)
	                    S[j] = i;
	            }
	        }
	    }
	    
	    int countDivisorsScalerSol(int x) {
	        // Using prime factorization to get the number of divisors for every integer
	        int ans = 1;
	        while(S[x] > 1) {
	            int cnt = 1, u = S[x];
	            while(S[x] == u) {
	                cnt++;
	                x /= u;
	            }
	            ans *= cnt;
	        }
	        return ans;    
	    }
	    
	    public int[] solveScalerSol(int[] a) {
	    	sieveScalerSol();
	        int n = a.length;
	        int ans[] = new int[n];
	        for(int i = 0; i < n; i++)
	            ans[i] = countDivisorsScalerSol(a[i]);
	        return ans;
	    }
	  public static void main(String[] args) {
		  CountOfDivisors cod = new CountOfDivisors();
		  int[] A = {2,3,4,5};
		  int[] B = {8,9,10};
		  int[] C = cod.solve1(A);
		  int[] D = cod.solve1(B);
		  int[] E = {3, 52, 66, 64, 14, 51, 6, 39, 5, 26, 80, 88, 60, 73, 67, 16, 1, 81, 62, 42, 83, 31, 40, 4, 32, 31, 44, 3, 20, 94, 93, 57, 2, 18, 32, 59, 91, 30, 45};
		  int[] F = cod.solve1(E);
		  for(int i=0; i<C.length; i++) System.out.print(C[i] +" ");
		  System.out.println();
		  for(int i=0; i<D.length; i++) System.out.print(D[i] +" ");
		  System.out.println();
		  for(int i=0; i<F.length; i++) System.out.print(F[i] +" ");
		  System.out.println();
	}
}
