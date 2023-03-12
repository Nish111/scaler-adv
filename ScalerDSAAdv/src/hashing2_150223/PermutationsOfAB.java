package hashing2_150223;

// https://www.scaler.com/academy/mentee-dashboard/class/50144/assignment/problems/1089?navref=cl_tt_nv
public class PermutationsOfAB {

	public int solve(String A, String B) {
		int n = A.length();
		int m = B.length();
		int[] freqA = new int[128];
		int[] freqB = new int[128];
		for (char c : A.toCharArray()) freqA[c]++;
		// sliding window implementation
		int s = 0, e = n - 1, count = 0;
		int max_val = Integer.MIN_VALUE;
		for (int i = s; i <= e; i++) {
			freqB[B.charAt(i)]++;
		}
		if (check(freqA, freqB)) count++;
		s = 1; e = n;
		while (e < m) {
			freqB[B.charAt(e)]++;
			freqB[B.charAt(s - 1)]--;
			if (check(freqA, freqB)) count++;
			s++; e++;
		}
		return count;
	}
	public boolean check(int[] a, int[] b) {
		for (int i = 0; i < 128; i++) {
			if (a[i] != b[i]) return false;
		}
		return true;
	}
	public int solveScalerSol(String A, String B) {
		int n = A.length();
		int m = B.length();
		int hash1[] = new int[26];
		int hash2[] = new int[26];
		int count = 0;
		// count frequency of each char in A
		for (int i = 0; i < n; i += 1) {
			hash1[A.charAt(i) - 'a'] += 1;
		}
		// count frequency of each char in first window of size n in B
		for (int i = 0; i < n; i += 1) {
			hash2[B.charAt(i) - 'a'] += 1;
		}
		count += sameScalerSol(hash1, hash2);
		// move current window 1 step ahead
		for (int i = n, j = 0; i < m; i += 1, j += 1) {
			hash2[B.charAt(j) - 'a'] -= 1;
			hash2[B.charAt(i) - 'a'] += 1;
			count += sameScalerSol(hash1, hash2);
		}
		return count;
	}
	public int sameScalerSol(int[] hash1, int[] hash2) {
		for (int i = 0; i < 26; i += 1) {
			if (hash1[i] != hash2[i])
				return 0; // not a permutation of A
		}
		return 1; // got a permutation of A in B
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationsOfAB poa = new PermutationsOfAB();
		String A = "abc";
		String B = "abcbacabc";
		System.out.println(poa.solve(A, B)); // 5
		String C = "aca";
		String D = "acaa";
		System.out.println(poa.solve(C, D)); // 2
	}

}
