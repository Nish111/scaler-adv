package zalgo_200223;

public class ZAlgoMore {

	public int zAlgoAgain(String A, String B) {
		String S = B+A;
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
			if(z[i]>=B.length()) count++;
		}
		return count;
	}
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		ZAlgoMore zam = new ZAlgoMore();
		String A = "abcabacababac"; String B = "aba";
		System.out.println(zam.zAlgoAgain(A, B)); // 3
	}

}
