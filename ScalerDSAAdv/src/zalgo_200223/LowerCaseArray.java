 package zalgo_200223;

public class LowerCaseArray {

	public int[] lowerCaseAlpha(String S) { // O(n)
		int n = S.length();
		int[] arr = new int[S.length()];
		arr[0] = -1;
		for(int k = 1; k<S.length(); k++) {
			int i=k;
			while(i <n && S.charAt(i)==S.charAt(i-k)) {
				i++;
			}
			arr[k]=i-k ;
		}
		return arr;
	}
	public int[] zAlgo(String S) {
		// cumulative all is n and inside n outside n so O(2n) - > O(n)
		int[] z = new int[S.length()];
		z[0] = -1;
		int l=0, r = 0, n = S.length();
		for(int i=1; i<n; i++) {
			if(i>r) { // i is outside [l,r] so bruteForce and update z[i]
				l = r = i;
				while(r<n && S.charAt(r)==S.charAt(r-l)) {
					r++;
				}
				z[i] = r-l;
				r--;
			} else { // i is in range [l, r]
				int k = i-l;
				if(z[k] < (r-i+1)) {
					z[i] = z[k];
				} else {
					l=i;
					while(r<n && S.charAt(r)==S.charAt(r-l)) {
						r++;
					}
					z[i] = r-l;
					r--;
				}
			}
		}
		return z;
	}
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowerCaseArray lc = new LowerCaseArray();
		String S = "abcabcaa";
		lc.printArray(lc.lowerCaseAlpha(S)); // -1 0 0 4 0 0 1 1
		lc.printArray(lc.zAlgo(S)); // -1 0 0 4 0 0 1 1
		String B = "abcabcab";
		lc.printArray(lc.lowerCaseAlpha(B));  //-1 0 0 5 0 0 2 0
		lc.printArray(lc.zAlgo(B)); //-1 0 0 5 0 0 2 0
		String A = "xxyaxxyaz";
		lc.printArray(lc.lowerCaseAlpha(A));  // -1 1 0 0 4 1 0 0 0
		lc.printArray(lc.zAlgo(A)); // -1 1 0 0 4 1 0 0 0
		String C = "xxyaxxyazxxyaxxyaxz";
		lc.printArray(lc.lowerCaseAlpha(C)); // -1 1 0 0 4 1 0 0 0 8 1 0 0 5 1 0 0 1 0
		lc.printArray(lc.zAlgo(C)); // -1 1 0 0 4 1 0 0 0 8 1 0 0 5 1 0 0 1 0
		String D = "abcabacababac";
		lc.printArray(lc.lowerCaseAlpha(D)); //-1 0 0 2 0 1 0 2 0 2 0 1 0 
		lc.printArray(lc.zAlgo(D)); //-1 0 0 2 0 1 0 2 0 2 0 1 0 
		String E = "abacababac";
		lc.printArray(lc.lowerCaseAlpha(E)); //-1 0 1 0 3 0 4 0 1 0 
		lc.printArray(lc.zAlgo(E)); //-1 0 1 0 3 0 4 0 1 0  
		
		
	}

}
