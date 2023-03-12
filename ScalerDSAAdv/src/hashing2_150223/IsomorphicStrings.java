package hashing2_150223;

import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50144/homework/problems/9464?navref=cl_tt_nv
public class IsomorphicStrings {

	public int solve(String A, String B) {
		HashMap<Character, Integer> hmA = new HashMap<>();
		HashMap<Character, Integer> hmB = new HashMap<>();
		for(char c:A.toCharArray()) {
			hmA.put(c, hmA.getOrDefault(c, 1)+1);
		}
		for(char c:B.toCharArray()) {
			hmB.put(c, hmB.getOrDefault(c, 1)+1);
		}
		for(int i=0; i<A.length(); i++) {
			int valA = hmA.get(A.charAt(i));
			int valB = hmB.get(B.charAt(i));
			if(valA != valB) return 0;
			hmA.put(A.charAt(i), hmA.get(A.charAt(i))-1);
			hmB.put(B.charAt(i), hmB.get(B.charAt(i))-1);
		}
		return 1;
    }
	public int solveScalerSol(String A, String B) {
        if (isIsomorphicScalerSol(A, B))
            return 1;
        else
            return 0;
    }

    public Boolean isIsomorphicScalerSol(String X, String Y) {
        // if X and Y have different lengths, they cannot be Isomorphic
        if (X.length() != Y.length())
            return false;
        // use map to store mapping from characters of string X to string Y
        int map[] = new int[26];
        for (int i = 0; i < 26; i++)
            map[i] = -1;
        // to store if i is mapped or not
        int isMap[] = new int[26];
        for (int i = 0; i < 26; i++)
            isMap[i] = -1;
        for (int i = 0; i < X.length(); i++) {
            char x = X.charAt(i), y = Y.charAt(i);
            // if x is seen before
            if (map[x - 'a'] != -1) {
                // return false if first occurrence of x is mapped to
                // different character
                if (map[x - 'a'] != y - 'a')
                    return false;
            }
            // if x is seen for the first time (i.e. it is not mapped yet)
            else {
                // return false if y is already mapped to some other char in X
                if (isMap[y - 'a'] != -1)
                    return false;
                // map y to x and mark it mapped
                map[x - 'a'] = y - 'a';
                isMap[y - 'a'] = 1;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsomorphicStrings is = new IsomorphicStrings();
		String A = "aba";
		String B = "xyx";
		System.out.println(is.solve(A, B)); // 1
		String C = "cvv";
		String D = "xyx";
		System.out.println(is.solve(C, D)); // 0
		String E = "cvv";
		String F = "xxx";
		System.out.println(is.solve(E, F)); // 0
	}

}
