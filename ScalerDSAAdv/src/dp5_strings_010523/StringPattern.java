package dp5_strings_010523;

import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/70947/assignment/problems/16/?navref=cl_pb_nv_tb
public class StringPattern {

	public int stringPat(String A, String B) {
		int N = A.length();
		int M = B.length();
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<M-1; j++) {
			if(B.charAt(j)=='*' && B.charAt(j+1)=='*') continue;
			sb.append(B.charAt(j));
		}
		sb.append(B.charAt(M-1));
		String P = sb.toString();
		M = P.length();
		int[][] dp = new int[N][M];
		for(int i=0; i<N; i++) Arrays.fill(dp[i], -1);
		int ans = findMatches(N-1, M-1, dp, A, P);
		//printArray(dp);
		return ans;
	}
	public void printArray(int[][] dp) {
		// TODO Auto-generated method stub
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
			
	}
	public int findMatches(int i, int j, int[][] dp, String A, String B) {
		if(i<0 && j<0) {
			return 1;
		}
		if(i<0) {
			while(j>=0){
                if(B.charAt(j)=='*') j--;
                else return 0;
            }
            return 1;
			/*
			 * for(int k=0; k<=j; k++) { if((B.charAt(k)>='a' && B.charAt(k)<='z') ||
			 * B.charAt(k) == '?') return 0; } return 1;
			 */
		}
		if(j<0) return 0;
		if(dp[i][j] == -1) {
			if(A.charAt(i)==B.charAt(j)) {
				dp[i][j] = findMatches(i-1, j-1, dp, A, B);
			} 
			//else if(B.charAt(j)>='a' && B.charAt(j)<='z') return false;
			else if(B.charAt(j) == '*') {
				dp[i][j] = (findMatches(i-1, j-1, dp, A, B) | findMatches(i-1, j, dp, A, B)
						| findMatches(i, j-1, dp, A, B));
			}
			else if(B.charAt(j) == '?') dp[i][j]=findMatches(i-1, j-1, dp, A, B);
			else dp[i][j] = 0;
		}
		return dp[i][j];
	}
	public int isMatchScalerSol(final String s, final String p) {
        boolean[][] d = new boolean[s.length() + 1][p.length() + 1];
        d[0][0] = true;
        if (p.charAt(0) == '*') {
            d[0][1] = true;
        }
        for (int i = 0; i < p.length(); ++i) {
            if (p.charAt(i) == '*') {
                d[0][i + 1] = d[0][i];
                for (int j = 0; j < s.length(); ++j) {
                    d[j + 1][i + 1] = d[j][i] || d[j + 1][i] || d[j][i + 1];
                }
            } else if (p.charAt(i) == '?') {
                for (int j = s.length() - 1; j >= 0; --j) {
                    d[j + 1][i + 1] = d[j][i];
                }
            } else {
                for (int j = 0; j < s.length(); ++j) {
                    if (p.charAt(i) == s.charAt(j)) {
                        d[j + 1][i + 1] = d[j][i];
                    }
                }
            }
        }
        return d[s.length()][p.length()] ? 1 : 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPattern sp = new StringPattern();
		System.out.println(sp.stringPat("abxc", "xa*")); // 0
		System.out.println(sp.stringPat("xxyz", "x?y*z")); // 1
		System.out.println(sp.stringPat("xxyzxyzzz", "x?y*z")); // 1
		System.out.println(sp.stringPat("abc", "ab*")); // 1
		
	}

}
