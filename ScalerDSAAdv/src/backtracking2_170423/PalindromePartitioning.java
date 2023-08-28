package backtracking2_170423;

import java.util.ArrayList;
import java.util.Arrays;
// https://www.scaler.com/academy/mentee-dashboard/class/70942/homework/problems/149/?navref=cl_pb_nv_tb
public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String A) {
        ArrayList<ArrayList<String>> response = new ArrayList<>();
        ArrayList<String> currentList = new ArrayList<>();
        addBreakPoint(0, A, currentList, response);
        return response;
	}
    public void addBreakPoint(int index, String A, ArrayList<String> currentList, ArrayList<ArrayList<String>> response){
        if(index == A.length()){
            response.add(new ArrayList<>(currentList));
            return;
        }
        for(int i = index; i < A.length(); i++){
            if(isPalindrome(A, index, i)){
                currentList.add(A.substring(index, i + 1));
                addBreakPoint(i + 1, A, currentList, response);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String A, int s, int e){ 
        while(s < e){
            if(A.charAt(s) != A.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
    private int isPalin[][];
    private int N;
    private ArrayList < ArrayList < String >> mRes;
    private String mString;
    public ArrayList < ArrayList < String >> partitionScalerSol(String A) {
        mRes = new ArrayList < > ();
        N = A.length();
        if (N == 0)
            return null;
        mString = A;
        isPalin = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(isPalin[i], -1);
        }
        ArrayList < String > str = new ArrayList < > ();
        recScalerSol(str, 0);
        return mRes;
    }
    public void recScalerSol(ArrayList < String > str, int index) {
        if (index == N) {
            // we reached the end of the string and valid sequence of strings found.
            mRes.add(new ArrayList(str));
            return;
        }
        for (int i = index; i < N; i++) {
            // check if the substring str[index..i] is a palindrome
            if (isPalindromeScalerSol(index, i)) {
                str.add(mString.substring(index, i + 1));
                recScalerSol(str, i + 1);
                str.remove(str.size() - 1);
            }
        }
    }
    public boolean isPalindromeScalerSol(int start, int end) {
        if (start < 0 || start >= N || end < 0 || end >= N)
            return false;
        if (isPalin[start][end] != -1)
            return isPalin[start][end] == 1;
        int i, j;
        for (i = start, j = end; i < j; i++, j--) {
            if (mString.charAt(i) != mString.charAt(j)) {
                isPalin[start][end] = 0;
                return false;
            }
        }
        isPalin[start][end] = 1;
        return true;
    }

}

