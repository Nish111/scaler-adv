package zalgo_200223;

public class LowerCase {

	public int lowerCaseAlpha(String S, int k) { // O(n)
		int i=k;
		int n = S.length();
		while(i <n && S.charAt(i)==S.charAt(i-k)) {
			i++;
		}
		return i-k;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowerCase lc = new LowerCase();
		String S = "abcabcaa";
		System.out.println(lc.lowerCaseAlpha(S, 3)); // 4 -- abca
		String B = "abcabcab";
		System.out.println(lc.lowerCaseAlpha(B, 3)); // 5 -- abcab
		String A = "xxyaxxyaz";
		System.out.println(lc.lowerCaseAlpha(A, 1)); // 1 -- x
		System.out.println(lc.lowerCaseAlpha(A, 4)); // 4 -- xxya
		System.out.println(lc.lowerCaseAlpha(A, 7)); // 0 -- nothing
		System.out.println(lc.lowerCaseAlpha(A, 0)); // 9 -- xxyaxxyaz -- trivial case
		
	}

}
