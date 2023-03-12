package recursion_250123;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/50135/homework/problems/142?navref=cl_tt_lst_sl
public class Combinations { // failing, need different approach

	// need to understand
	public int[][] combine(int A, int B) { // not working
		int[][] res ;
		if(B>A) return new int[][] {};
		int n = factorial(A)/(factorial(B) *(factorial(A-B)));
		res = new int[n][2];
		if(A==1 & B==1) return new int[][] {{1}};
		int count=0;
		for(int i=1; i<=A; i++) {
			for(int j=i+1; j<=A; j++) {
				//System.out.println((i) +" "+(j));
				res[count][0] = i;
				res[count][1] = j;
				count++;
			}
		}
		return res;
    }
	public int factorial(int b) {
		// TODO Auto-generated method stub
		if(b==1 || b==0) return 1;
		return b*factorial(b-1);
	}
	 private ArrayList < ArrayList < Integer >> ans;
	   public ArrayList < ArrayList < Integer >> combine2(int A, int B) { // not working
	        ans = new ArrayList < > ();
	        ArrayList < Integer > cur = new ArrayList < > ();
	        solve(1, cur, A, B);
	        return ans;
	    }
	    void solve(int idx, ArrayList < Integer > cur, int A, int B) {
	        if (cur.size() == B) {
	            ans.add(new ArrayList < > (cur));
	            return;
	        }
	        if (idx == A + 1) 
	            return;
	        // Include current element
	        cur.add(idx);
	        solve(idx + 1, cur, A, B);
	        cur.remove(cur.size() - 1);
	        // Don't include current element
	        solve(idx + 1, cur, A, B);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations c = new Combinations();
		int[][] A = c.combine(4, 2); // 1 2  1 3  1 4  2 3  2 4  3 4
		int[][] B = c.combine(3, 2); // 1 2  1 3  2 3
		int[][] C = c.combine(1, 1); // 1
		//int[][] D = c.combine(3, 3); // not working for these, need to make generic
		for(int i=0; i<A.length; i++) {
			System.out.println(A[i][0] + " " + A[i][1]);
		}
		System.out.println();
		for(int i=0; i<B.length; i++) {
			System.out.println(B[i][0] + " " + B[i][1]);
		}
		System.out.println();
		for(int i=0; i<C.length; i++) {
			System.out.println(C[i][0] + " " );
		}
		System.out.println();
	}

}
