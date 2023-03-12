package zalgo_200223;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50146/homework/problems/9462?navref=cl_tt_lst_sl
public class SmallestPeriodOfString {

	public int smallestPeriod(String S) {
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
		for(int i=1; i<n; i++) {
			if(z[i]==(n-i)) return i;
		}
		return S.length();
	}
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public int solveScalerSol(String A) {
        ArrayList < Integer > Z = getZarrScalerSol(A);
        int n = A.length();
        for (int i = 1; i < n; i++) {
            if (i + Z.get(i) == n) {
                return i;
            }
        }
        return n;
    }
    public ArrayList < Integer > getZarrScalerSol(String str) {
        int n = str.length();
        // Z array
        ArrayList < Integer > Z = new ArrayList < Integer > ();
        for (int i = 0; i < n; i++) Z.add(0);
        int L, R, k;
        // [L, R] make a window which matches with prefix of str
        L = R = 0;
        for (int i = 1; i < n; ++i) {
            // if i > R nothing matches so we will calculate Z[i] using naive way
            if (i > R) {
                L = R = i;
                // R - L = 0 in starting, so it will start checking from 0'th index
                while (R < n && str.charAt(R - L) == str.charAt(R))
                    R++;
                Z.set(i, R - L);
                R--;
            } else {
                // k = i - L so k corresponds to number which matches in [L,R] interval
                k = i - L;
                // if Z[k] is less than remaining interval then Z[i] will be equal to Z[k].
                if (Z.get(k) < R - i + 1)
                    Z.set(i, Z.get(k));
                else {
                    // else start from R and check manually
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R))
                        R++;
                    Z.set(i, R - L);
                    R--;
                }
            }
        }
        return Z;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestPeriodOfString spos = new SmallestPeriodOfString();
		String A = "abcaabcaabca";
		System.out.println(spos.smallestPeriod(A)); // 4
		String B = "abcaabcaabcaab";
		System.out.println(spos.smallestPeriod(B)); // 4
		String C = "abcaabxaabbca";
		System.out.println(spos.smallestPeriod(C)); // 12
		String D = "abababab";
		System.out.println(spos.smallestPeriod(D)); // 2 
		String E = "aaaa";
		System.out.println(spos.smallestPeriod(E)); // 1
		String F = "abcaabxaabbc";
		System.out.println(spos.smallestPeriod(F)); // 12 -- no such i so length of S 
		String H = "abababababb";
		System.out.println(spos.smallestPeriod(H)); // 11
		
	}

}
