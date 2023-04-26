package greedy_070423;

import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/70940/homework/problems/1074/hints?navref=cl_pb_nv_tb
public class BinaryStrings {

	public int solve(String A, int B) { // O(NB) so TLE
		StringBuilder sb1 = new StringBuilder();
		
		sb1=sb1.append(A);
		if(A.length()<B) return -1;
		int count=0;
		for(int i=0; i<sb1.length()-B+1; i++) {
			StringBuilder sb2 = new StringBuilder();
			if(sb1.charAt(i)=='0') {
				int start = i, end = start+B-1;
				for(int j=start; j<=end; j++) {
					if(sb1.charAt(j)=='0') sb2.append("1");
					if(sb1.charAt(j)=='1') sb2.append("0");
				}
				count++;
				sb1.replace(i, i+B, sb2.toString());
				//System.out.println(sb1);
			}
		}
		//System.out.println(sb);
		for(int i=0;i<sb1.length(); i++)
			if(sb1.charAt(i)=='0') return -1;
		return count;
    }
	public int solve2(String A, int B) { // approach 2
		int ans=0;
		int[] temp = new int[A.length()];
		for(int i=0; i<A.length(); i++) {
			if(i>0) {
				temp[i]+=temp[i-1];
			}
			if((temp[i]%2==1 && A.charAt(i)=='1') ||(temp[i]%2==0 && A.charAt(i)=='0')) {
				ans++;
				temp[i]++;
				if(i+B>A.length()) return -1;
				if(i+B<A.length()) temp[i+B]--;
			}
			
		}
		return ans;
    }
	public int solve3(String A, int B) {
        int n = A.length();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            if(A.charAt(i) == '0'){
                arr[i] = 0;
            }
            else{
                arr[i] = 1;
            }
        }

        int ans = 0;
        //Iterate from 0 till n-B+1 to check if any element is 0
        //If it is 0, flip B continuous elements from that index ( arr[j]^1 ) 
        //Increment the answer
        //IF 0 still exists then we can’t make all characters to 1 in the given string
        for(int i=0; i<n-B+1; i++){
            if(arr[i] == 0){
                for(int j=i; j<i+B; j++){
                    arr[j] = arr[j]^1;
                }
                ans++;
            }
        }

        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                return -1;
            }
        }
        return ans;
    }
	public int solveScalerSol(String A, int B) {
        int n = A.length();
        int[] temp = new int[n];
        Arrays.fill(temp, 0);
        int xr = 0;
        int ans = 0;
        int i = 0;
        for (i = 0; i <= n - B; i++) {
            xr ^= temp[i];
            if ((A.charAt(i) == '0' && xr == 0) || (A.charAt(i) == '1' && xr == 1)) {
                ans++;
                if (i + B < n) {
                    temp[i + B] = 1;
                }
                xr = 1 - xr;
            }
        }
        while (i < n) {
            xr ^= temp[i];
            int val = A.charAt(i) - 48;
            if ((val ^ xr) == 0) {
                return -1;
            }
            i++;
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryStrings bs = new BinaryStrings();
		String A = "00010110";
		System.out.println(bs.solve(A, 3)); // 3
		System.out.println(bs.solve2(A, 3));
		String B = "011"; 
		System.out.println(bs.solve(B, 3)); // -1
		System.out.println(bs.solve2(B, 3));
		String C= "0010";
		System.out.println(bs.solve(C, 3)); // -1
		System.out.println(bs.solve2(C, 3));
		String D = "00010110";
		System.out.println(bs.solve(D, 3));
		System.out.println(bs.solve2(D, 3));
	}

}
