package stringpattern_170223;

import java.util.Arrays;
import java.util.TreeSet;
// https://www.scaler.com/academy/mentee-dashboard/class/50145/assignment/problems/5550?navref=cl_tt_lst_sl
public class BoringSubstring {

	public int solveBrute(String A) { // O(n!)
		int n = A.length();
		for (int len = 1; len <= n; len++) {
            // Pick ending point
            for (int i = 0; i <= n - len; i++) {
                //  Print characters from current
                // starting point to current ending
                // point.  
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    //System.out.print(A.charAt(k));
                	//if(A.charAt(k))
                }
  
                //System.out.println();
            }
        }
		return 0;
    }
	public int solve(String A) { // O(n)
		TreeSet<Character> hsO = new TreeSet<>();
		TreeSet<Character> hsE = new TreeSet<>();
		for(char c:A.toCharArray()) {
			if(c%2==0) hsE.add(c);
			else hsO.add(c);
		}
		char maxO = 'a', minO = 'y', maxE = 'b', minE = 'z';
		for(char c: hsO) {
			maxO = (char) Math.max(c, maxO);
			minO = (char) Math.min(c, minO);
		}
		for(char c: hsE) {
			maxE = (char) Math.max(c, maxE);
			minE = (char) Math.min(c, minE);
		}
		//System.out.println(maxE +" "+minE+" "+maxO+" "+minO);
		if((Math.abs(minO-minE) > 1) || (Math.abs(minO-maxE) > 1))
		return 1;
		else return 0;
    }
	public boolean checkScalerSol(String s) {
        boolean ok = true;
        for (int i = 0; i + 1 < s.length(); ++i)
            ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
        return ok;
    }
    public int solveScalerSol(String A) {
        String odd = "", even = "";
        // odd and even stores odd and even characters respective
        for (int i = 0; i < A.length(); ++i) {
            char c = A.charAt(i);
            if (c % 2 == 0)
                odd += c;
            else
                even += c;
        }
        char[] ar = odd.toCharArray();
        Arrays.sort(ar);
        odd = String.valueOf(ar);
        ar = even.toCharArray();
        Arrays.sort(ar);
        even = String.valueOf(ar);
        // check if either (odd + even) or (even + odd) has no boring substrings
        if (checkScalerSol(odd + even))
            return 1;
        else if (checkScalerSol(even + odd))
            return 1;
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoringSubstring bs = new BoringSubstring();
		System.out.println(bs.solveBrute("abcd")); // 0 -- 1
		System.out.println(bs.solveBrute("aab")); // 0
		System.out.println(bs.solve("abcd")); // 1
		System.out.println(bs.solve("aab")); // 0
		System.out.println(bs.solve("abcd")); // 1
		System.out.println(bs.solve("aabcbc")); // 0
	}

}
