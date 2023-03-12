package stringpattern_170223;

// https://www.scaler.com/academy/mentee-dashboard/class/50145/assignment/problems/37597/?navref=cl_pb_nv_tb
public class RabinKarp {

	public int solve(String A, String B) { 		// not working
		// sliding window not helpful as 
		// whole calculation cannot be done in O(1) and needs O(m)

		int n = A.length(), m = B.length();
		int s=0, e=m-1, ans=0;
		int count=0; int j=0;
		for(int i=s; i<=e; i++, j++) {
			if(check(A, B, e, j)) count++;
		}
		if(count==m) ans++;
		s=1; e=m; j=m-1;
		while(e<n) {
			count=0;
			if(check(A, B, e, j)) count++;
			//if(A.charAt(e)==B.charAt(j))
			
			//sum = sum - A[s-1] + A[e];
			//max_val = Math.max(max_val, sum);
			s++; e++;
		}
		return count+ans;
    }
	public boolean check(String A, String B, int e, int j) {
		// TODO Auto-generated method stub
		if((e==0) && (A.charAt(0)==B.charAt(0))) return true;
		if(A.charAt(e) != B.charAt(j)) return false;
		else {
			return check(A, B, e-1, j-1);
		}
	}
	public int solveBrute(String A, String B) { // working
        int N = A.length();
        int M = B.length();
        int count = 0;
        for(int i = 0;i<=N-M;i++){
            if(A.substring(i,i+M).equals(B)){
                count++;
            }
        }
        return count;
    }
	public int rabinKarp(String A, String B) { // working
		// modified as below one
		int n = A.length(), m = B.length();
		int ans=0;
		int valB = 0, valA=0; int j=0, p=1;
		int mod = 1000000007;
		for(int i=0; i<m-1; i++) {
			valB = ((valB)*29 + (B.charAt(i)-'a'))%mod;
			valA = ((valA)*29 + (A.charAt(i)-'a'))%mod;
			p = (p*29)%mod;
		}
		valB = ((valB)*29 + (B.charAt(m-1)-'a'))%mod;
		valA = ((valA)*29 + (A.charAt(m-1)-'a'))%mod;
		if(valA == valB) ans++;
		for(int i=m; i<n; i++) {
			valA = ((valA - p*(A.charAt(i-m)-'a'))*29 + (A.charAt(i)-'a') + mod) % mod;
	        if(valA == valB) {
	            ans++;
	        }
		}
		return ans;
	}
	public int solveUsingKMP(String A, String B) {
        int N = A.length();
        int M = B.length();
        int[] lps = new int[M];
        int j = 0;
        int count = 0;
        // Preprocessing for KMP
        lps = compute_lps(B);
        //printArray(lps);
        int i = 0;
        while (i < N) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            }
            if (j == M) {
                count++;
                j = lps[j - 1];
            } else if (i < N && A.charAt(i) != B.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return count;
    }

	public int[] compute_lps(String str) {
		int M = str.length();
		int lps[] = new int[M];
		int i=0, j=1;
		lps[0]=0;
		while(j<M) {
			if(str.charAt(i) == str.charAt(j)) {
				i++;
				lps[j]=i;
				j++;
			} else {
				if(i !=0) i = lps[i-1];
				else {
					lps[j]=0;
					j++;
				}
			}
		}
		return lps;
	}
	
	public int solveUsingZ(String A, String B) {
		String s = B + "$" + A;
		int z[] = new int[s.length()];
		z = compute_z(s);
		//printArray(z);
		int count = 0;
		for (int i = 1; i < z.length; i++) {
			if (z[i] >= B.length()) {
				count++;
			}
		}
		return count;
	}
	public int[] compute_z(String s) {
		int[] z = new int[s.length()];
		int n = s.length();
		z[0] = 0;
		int l = 0;
		int r = 0;
		for (int i = 1; i < s.length(); i++) {
			if (i > r) {
				int j = i;
				int k = 0;
				while (j < n && s.charAt(j) == s.charAt(k)) {
					k++;
					j++;
				}
				z[i] = k;
				l = i;
				r = j - 1;
			} else {
				if (z[i - l] < r - i + 1) {
					z[i] = z[i - l];
				} else {
					int j = r + 1;
					int k = r - i + 1;
					while (j < n && s.charAt(j) == s.charAt(k)) {
						k++;
						j++;
					}
					z[i] = k;
				}
			}
		}
		return z;
	}
	// Rabin-Karp Solution

	public int solveRabinKarp(String A, String B) { // try this
	    int N = A.length(), M = B.length(), count = 0;
	    long hashB = 0, hashA = 0, d = 1, k = 1, mod = 1000000007;
	    for(int i = 0; i < M-1; i++) {
	        hashB = ((hashB)*26 + (B.charAt(i)-'a'))%mod;
	        hashA = ((hashA)*26 + (A.charAt(i)-'a'))%mod;
	        d = (d*26)%mod;
	    }
	    hashB = ((hashB)*26 + (B.charAt(M-1)-'a'))%mod;
	    hashA = ((hashA)*26 + (A.charAt(M-1)-'a'))%mod;
	    if(hashA == hashB) count++;
	    for(int i = M; i < N; i++) {
	        hashA = ((hashA - d*(A.charAt(i-M)-'a'))*26 + (A.charAt(i)-'a') + mod) % mod;
	        if(hashA == hashB) {
	            count++;
	        }
	    }
	    return count;
	}
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	 public int solveScalerSol(String A, String B) {
	        int n = A.length();
	        int m = B.length();    
	        int prime = 31;
	        int mod = (int)(1e9 + 7);
	        
	        long[] p_pow = new long[n];
	        p_pow[0] = 1; 
	        for (int i = 1; i < n; i++) {
	            p_pow[i] = (p_pow[i - 1] * prime) % mod;
	        }
	           
	        long[] h = new long[n + 1]; 
	        for (int i = 0; i < n; i++){
	            h[i + 1] = (h[i] + (A.charAt(i) - 'a' + 1) * p_pow[i]) % mod;
	        }
	        
	        long hash_B = 0; 
	        for (int i = 0; i < m; i++) {
	            hash_B = (hash_B + (B.charAt(i) - 'a' + 1) * p_pow[i]) % mod; 
	        }
	        
	        int ans = 0;
	        for (int i = 0; i + m - 1 < n; i++) { 
	            long curr_hash = (h[i + m] + mod - h[i]) % mod; 
	            if (curr_hash == hash_B * p_pow[i] % mod)
	                ans += 1;
	        }
	        
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RabinKarp rk = new RabinKarp();
		String A = "acbac";
		String B = "ac";
		System.out.println(rk.rabinKarp(A, B)); // 2
		System.out.println(rk.solveBrute(A, B)); // 2 -- 2
		System.out.println(rk.solveUsingKMP(A, B)); // 2
		System.out.println(rk.solveUsingZ(A, B)); // 2
		System.out.println(rk.solveRabinKarp(A, B)); // 2
		String C = "aaaa";
	    String D = "aa";
	    System.out.println(rk.rabinKarp(C, D)); // 3
	    System.out.println(rk.solveBrute(C, D)); // 3
	    System.out.println(rk.solveUsingKMP(C, D)); // 3
	    System.out.println(rk.solveUsingZ(C, D)); // 3
	    System.out.println(rk.solveRabinKarp(C, D)); // 3
	    String E ="adabdaadbacccacbdaadaaadbcdcbca";
	    String F = "abd";
	    System.out.println(rk.rabinKarp(E, F)); // 1
	    System.out.println(rk.solveBrute(E, F)); // 1
	    System.out.println(rk.solveUsingKMP(E, F)); // 1
	    System.out.println(rk.solveUsingZ(E, F)); // 1
	    System.out.println(rk.solveRabinKarp(E, F)); // 1
	}
	

}
