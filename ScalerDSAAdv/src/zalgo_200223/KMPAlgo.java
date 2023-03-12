package zalgo_200223;

public class KMPAlgo {

	public int KMPNaive(String A, String B) { // O(N*M)
		int count=0;
		for(int i=0; i<A.length()-B.length()+1; i++) {
			count=0;
			int k=0 ;
			for(int j=0; j<B.length(); j++) {
				if(A.charAt(i+k)== B.charAt(j)) {
					count++;
				}
				k++;
			}
			if(count==B.length()) return 1;
			//if(k>=B.length()) continue;
		}
		return 0;
	}
	public int KMP(String A, String B) { // O(N+M)
		// prefixes of abacmaba are
		// a, ab, aba, abac, abacm, abacma, abacmab, abacmaba
		// suffixes are
		// a, ba, aba, maba, cmaba, acmaba, bacmaba, abacmaba
		// proper prefix and proper suffix are excluding whole string(abacmaba)
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMPAlgo ka = new KMPAlgo();
		String A ="aaaaab";
		String B = "aab";
		System.out.println(ka.KMPNaive(A, B)); // 1
	}

}
