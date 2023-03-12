package recursion_250123;

import java.util.ArrayList;
// https://www.scaler.com/academy/mentee-dashboard/class/50135/assignment/problems/139/?navref=cl_pb_nv_tb
public class GenerateAllParentheses {

	// understand again
	public ArrayList<String> generateParenthesis(int A) {
		ArrayList<String> res = new ArrayList<String>();
		genrateAllParenthesis("(", 1, 0, res, A);
		return res;
	}

	public void genrateAllParenthesis(String current, int open, int close, 
			ArrayList<String> stringArray, int n) {
		if (current.length() == 2 * n) {
			stringArray.add(current);
			return;
		}
		if (open < n)
			genrateAllParenthesis(current + "(", open + 1, close, stringArray, n);
		if (close < open)
			genrateAllParenthesis(current + ")", open, close + 1, stringArray, n);
	}
	ArrayList < String > ans;
    // cnt denotes remaining open brackets (
    // dif denotes the difference between open and closed brackets
    void solveScalerSol(int cnt, int dif, int n, String s) {
        if (n == 0) {
            ans.add(s);
            return;
        }
        // Now we have 2 options. We can either add '(' to the string or add ')' to the string. 
        // Option 1. Add '(' 
        if (cnt > 0)
            solveScalerSol(cnt - 1, dif + 1, n - 1, s + '(');
        // Option 2. Add ')'
        if (dif > 0)
            solveScalerSol(cnt, dif - 1, n - 1, s + ')');
    }
    public ArrayList < String > generateParenthesisScalerSol(int A) {
        ans = new ArrayList < > ();
        solveScalerSol(A, 0, 2 * A, "");
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateAllParentheses gap = new GenerateAllParentheses();
		ArrayList<String> arr = gap.generateParenthesis(3);
		for (String i : arr)
			System.out.print(i + " ");
		System.out.println();
		ArrayList<String> arr1 = gap.generateParenthesis(1);
		for (String i : arr1)
			System.out.print(i + " ");
		System.out.println();
		ArrayList<String> arr2 = gap.generateParenthesis(1);
		for (String i : arr2)
			System.out.print(i + " ");
		System.out.println();
	}

}
