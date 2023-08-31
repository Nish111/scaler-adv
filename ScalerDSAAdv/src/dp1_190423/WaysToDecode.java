package dp1_190423;

import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/70943/homework/problems/10/?navref=cl_pb_nv_tb
public class WaysToDecode {
	int mod = 1000000007;
    public int numDecodings(String A) {
        int dp[] = new int[A.length()];
        return ways(0, A, dp);
    }

    private int ways(int idx, String A, int dp[]) {

        //IF STRING IS FINISHED WE GET ONE COMBINATION    
        if (idx == A.length()) return 1;

        if (dp[idx] != 0) return dp[idx];
        long ans = 0;
        StringBuilder str = new StringBuilder();

        //TRYING MAKING CODE BETWEEN 1-26 AT EACH INDEX PASS REST OF THE STRING
        for (int i = idx; i < Math.min(A.length(), idx + 2); i++) {
            char ch = A.charAt(i);
            str.append(ch);

            //CODE CANNOT START WITH ZERO
            if (str.toString().equals("0")) break;
            int decoded = Integer.parseInt(str.toString());

            //TAKING CODE RANGE BETWEEN 1-26
            if (decoded <= 26) ans = ans + ways(i + 1, A, dp);
        }
        return dp[idx] = (int)(ans % mod);
    }
    private int[] dp;
    private int N;
    private String A;

    public int numDecodingsScalerSol(String A) {

      N = A.length();

      if (A == null)
        return 0;

      dp = new int[N];
      Arrays.fill(dp, -1);
      this.A = A;

      return recScalerSol(N - 1);
    }

    private int recScalerSol(int index) {

      if (index < 0)
        return 1;

      if (dp[index] != -1)
        return dp[index] % 1000000007;

      int ways = 0;

      if (A.charAt(index) > '0') {
        ways = recScalerSol(index - 1);
        ways %= 1000000007;
      }

      if (isValidTwoDigitsScalerSol(index)) {
        ways += recScalerSol(index - 2);
        ways %= 1000000007;
      }

      return dp[index] = ways;
    }

    private boolean isValidTwoDigitsScalerSol(int index) {
      if (index > 0 && (A.charAt(index - 1) == '1' || A.charAt(index - 1) == '2' && A.charAt(index) < '7'))
        return true;

      return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaysToDecode wtd = new WaysToDecode();
		System.out.println(wtd.numDecodings("12")); // 2
		System.out.println(wtd.numDecodings("8"));// 1
	}

}
