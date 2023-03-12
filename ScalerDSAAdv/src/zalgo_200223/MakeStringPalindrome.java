package zalgo_200223;

// https://www.scaler.com/academy/mentee-dashboard/class/50146/homework/problems/363/hints?navref=cl_pb_nv_tb
public class MakeStringPalindrome {

	public int solve(String A) {
		String S = A+A;
		System.out.println(S);
		int[] z = new int[S.length()];
		z[0] = -1;
		int l=0, r = 0, n = S.length();
		for(int i=1; i<n; i++) {
			if(i>r) { // i is outside [l,r] so bruteForce and update z[i]
				l = r = i;
				while(r<n && S.charAt(r)==S.charAt(r-l)) {
					r++;
				}
				z[i] = r-l; r--;
			} else { // i is in range [l, r]
				int k = i-l;
				if(z[k] < (r-i+1)) {
					z[i] = z[k];
				} else {
					l=i;
					while(r<n && S.charAt(r)==S.charAt(r-l)) {
						r++;
					}
					z[i] = r-l; r--;
				}
			}
		}
		printArray(z);
		int count=0;
		for(int i=1; i<n; i++) {
			if(z[i]>=A.length()) count++;
		}
		return count;
    }
	public int solveBrute(String A) { // O(N2) not working now
		// check for palindrome if not then delete last character and check again
		// till we get palindrome or no chars left
		String str = A+A;
		int count=0;
		for(int i=0; i<str.length(); i++) {
			if(palindrome(str)) return count;
			else {
				count++;
				str = str.substring(0, str.length()-1);
				System.out.println(str);
			}
		}
		return 0;
	}
	public boolean palindrome(String palin) {
		int i=0; int j=palin.length()-1;
		while(i<j) {
			if(palin.charAt(i) != palin.charAt(j)) return false;
			i++; j--;
		}
		return true;
	}
	// Using KMP
	public int solveUsingKMP(String A) { // working
		String rev = reverse(A);
		String str = A+"$"+rev;
		int[] lps = compute_lps(str);
		printArray(lps);
		return A.length()-lps[str.length()-1];
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
	public String reverse(String A) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for(int i=A.length()-1; i>=0; i--) {
			sb.append(A.charAt(i));
		}
		return sb.toString();
	}
	 public int solveScalerSol(String A) {
	        String s = new String(A);
	        StringBuilder sb = new StringBuilder(A);
	        s += sb.reverse();
	        int lps[];
	        // lps array contains the longest prefix, which is also a suffix
	        lps = computeLPSScalerSol(s);
	        return Math.max(A.length() - lps[s.length() - 1], 0);
	    }
	    public int[] computeLPSScalerSol(String s) {
	        int l = 0, i = 1;
	        int lps[] = new int[s.length()];
	        while (i < s.length()) {
	            if (s.charAt(i) == s.charAt(l)) {
	                lps[i] = ++l;
	                i++;
	            } else {
	                if (l > 0) {
	                    l = lps[l - 1];
	                } else {
	                    lps[i] = 0;
	                    i++;
	                }
	            }
	        }
	        return lps;
	    }
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeStringPalindrome msp = new MakeStringPalindrome();
		String A = "abc";
		//System.out.println(msp.solve(A)); // 2 - cbabc
		//System.out.println(msp.solveBrute(A)); // 0
		System.out.println(msp.solveUsingKMP(A)); // 2
		String B = "bb";
		//System.out.println(msp.solve(B)); // 0 - bb
		//System.out.println(msp.solveBrute(B)); // 0
		System.out.println(msp.solveUsingKMP(B)); // 0
		String C = "safasd";
		//System.out.println(msp.solve(C));
		//System.out.println(msp.solveBrute(C)); // 0
		System.out.println(msp.solveUsingKMP(C)); // 1
	}

}
