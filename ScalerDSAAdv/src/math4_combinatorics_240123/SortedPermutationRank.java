package math4_combinatorics_240123;

// https://www.scaler.com/academy/mentee-dashboard/class/50134/assignment/problems/317/?navref=cl_pb_nv_tb
public class SortedPermutationRank {

	int  mod = 1000003;
	public int findRank(String A) {
		String str = A;
		int n=A.length(), ans=0;
		for(int i=0; i<n; i++) {
			int count=0;
			for(int j=i+1; j<n; j++) {
				if(str.charAt(j)<str.charAt(i)) {
					count++;
					//count = count%mod;
				}
			}
			ans += (count*fact(n-i-1)%mod)%mod;
		}
		return (ans+1)%mod;
    }
	public int fact(int n) {
		if(n==0 || n==1) return 1;
		else return n*fact(n-1)%mod;
	}
	//private int mod = 1000003;
    public int factScalerSol(int n) {
        if(n == 0 || n == 1)
            return 1;
        else
            return (n * factScalerSol(n - 1)) % mod;
    }
    public int findRankScalerSol(String A) {
        int ans = 0;
        int n = A.length();
        for(int i = 0; i < n - 1; i++) {
            int count = 0;  // count of characters less than A[i]
            for(int j = i + 1; j < n; j++)
                if(A.charAt(j) < A.charAt(i))
                    count++;
            ans += (count * fact(n - i - 1)) % mod;
        }
        return (ans + 1) % mod;        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedPermutationRank spr = new SortedPermutationRank();
		System.out.println(spr.findRank("acb")); // 2
		System.out.println(spr.findRank("a")); // 1
		System.out.println(spr.findRank("avcb")); // 6
		System.out.println(spr.findRank("acbe")); // 3
		System.out.println(spr.findRank("ZCSFLVHXRYJQKWABGT")); // 318057
		
		
	}

}
