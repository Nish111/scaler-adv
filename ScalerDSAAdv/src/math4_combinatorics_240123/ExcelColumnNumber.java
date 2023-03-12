package math4_combinatorics_240123;
// https://www.scaler.com/academy/mentee-dashboard/class/50134/homework/problems/74?navref=cl_tt_lst_sl
public class ExcelColumnNumber {

	public int solve(String s) { // assume base as 26
		int ans = 0, temp = 1;
		for(int i=s.length()-1; i>=0; i--) {
			ans += temp*(s.charAt(i)-'A'+1);
			temp *= 26;
		}
		return ans;
	}
	public int titleToNumberScalerSol(String A) {
	    int value = 0;
	    // traverse each character
	    for(int i = 0; i < A.length(); i++){
	        char c = A.charAt(i);
	        value = value * 26 + (c - 'A' + 1);
	    }
	    return value;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelColumnNumber ecn = new ExcelColumnNumber();
		System.out.println(ecn.solve("AB")); // 28
		System.out.println(ecn.solve("BB")); // 54
	}

	

}
