package zalgo_200223;
// https://www.scaler.com/academy/mentee-dashboard/class/50146/assignment/problems/9233/hints?navref=cl_pb_nv_tb
public class CyclicPermutations { // do again

	// A nd B equal length
	public int solveBrute(String A, String B) { // O(N2) // not working 
		int count=0;
		int xor=0, k=0;
		for(int i=0; i<A.length(); i++) {
			k=0;
			for(int j=i; j<B.length(); j++) {
				j = j%B.length();
				k = k%B.length();
				xor += B.charAt(j)^A.charAt(k);
				k++;
			}
			if(xor==0) count++;
		}
		
		return count;
		/*
		 * //public void rotate(int[] nums, int k) { int newk=k%nums.length; int[] C =
		 * new int[nums.length]; int var = nums.length-newk; for(int j=0; j<nums.length;
		 * j++) { C[j]=nums[(j+ var)%nums.length]; } for(int j=0; j<C.length; j++)
		 * System.out.print(C[j] + " "); System.out.println();
		 */
		
    }
	public int solve1(String A, String B) {
		String str = A + A; //add both the string so that cyclic count  can we check
		int ans = 0;
		for(int i = 1; i < str.length(); i++) {
		if(B.length() + i > str.length()) { //edge case next window should be in range
		continue;
		}
		String str1 = str.substring(i, B.length() + i); //check substring of window same to string
		if(B.equals(str1)) {
		ans+=1;
		}
		}
		return ans;
	}
	public int solve(String A, String B) { // not working out
		//B = B+B;
	    String S = A+'x'+B+B.substring(0, B.length()-1);
		//String S = A+A;
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
		//printArray(z);
		int count=0;
		for(int i=1; i<n; i++) {
			if(z[i]>=B.length()) count++;
		}
		//if(count>=1) return count-1;
		//else return count;
		return count;
    }
	public int solve2(String A, String B) {

        B = B+B;
        String str = A+'$'+B;
        int n = str.length();
        int[] Z = new int[n];
        Z = Zstring2(Z, str, n);

        int count = 0;
        for(int i=0; i<n; i++)
        {
            if(Z[i] == A.length() && i>2*A.length())
                count++;
        }
        return count;
    }

    // Z-String Algorithm
    public int[] Zstring2(int[] Z, String str, int n) {   
    	 Z[0] = 0;
         int len = 0;
         int i = 1;
         while(i<n){
             if(str.charAt(i) == str.charAt(len)){
                 len++;
                 Z[i] = len;
                 i++;
             }
             else{
                 if(len != 0)
                 len = Z[len-1];
                 else{
                     Z[i] = 0;
                     i++;
                 }
             }
         }
        return Z;
    }
    public int solve3(String A, String B) {
        // concatenate the strings
        B = B + B;
        String p = A + "$" + B;
        int N = p.length();
        // creaing lps array
        int[] lps = new int[N];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while(i<N){
            if(p.charAt(i) == p.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0)
                len = lps[len-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        // counting the number of occurences of A.length
        int count = 0;
        for(int j=0; j<N; j++){
            if(lps[j] == A.length() && j > 2*A.length())
            count++;
        }
        return count;
    }
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicPermutations cp = new CyclicPermutations();
		String A = "1001";
		String B = "0011";
		System.out.println(cp.solveBrute(A, B));// 0 -- 1
		System.out.println(cp.solve1(A, B)); // 1
		System.out.println(cp.solve3(A, B)); // 1
		String C = "0011000010";
		String D = "0101000001";
		System.out.println(cp.solveBrute(C, D)); // 0
		System.out.println(cp.solve1(C, D)); // 0
		System.out.println(cp.solve3(C, D)); // 0
		String E = "0011000010";
		String F = "0110000100";
		System.out.println(cp.solveBrute(E, F)); // 0 -- 1
		System.out.println(cp.solve1(E, F)); // 1
		System.out.println(cp.solve3(E, F)); // 1
		String G = "1111111111";
		String H = "1111111111";
		System.out.println(cp.solveBrute(G, H)); // 10
		System.out.println(cp.solve1(G, H)); // 10
		System.out.println(cp.solve3(G, H)); // 10
		String I = "01111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111";
		String J = "11111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101";
		System.out.println(cp.solveBrute(I, J)); // 0 -- 64
		System.out.println(cp.solve1(I, J)); // 65
		System.out.println(cp.solve3(I, J)); // 65 
	}

}
