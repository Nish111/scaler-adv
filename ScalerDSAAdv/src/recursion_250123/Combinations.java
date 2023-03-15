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
	// working now
	 private ArrayList<ArrayList<Integer>> ans;
	   public ArrayList<ArrayList<Integer>> combine3(int A, int B) { // not working
	        ans = new ArrayList <> ();
	        ArrayList<Integer> cur = new ArrayList <> ();
	        solve(ans, cur, A, B, 1);
	        return ans;
	    }
	    void solve(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> cur, int A, int B, int index) {
	        if (cur.size() == B) {
	            ans.add(new ArrayList < > (cur));
	            return;
	        }
	        if (index == A + 1) 
	            return;
	        // Include current element
	        cur.add(index);
	        solve(ans, cur, A, B, index + 1);
	        cur.remove(cur.size() - 1);
	        // Don't include current element
	        solve(ans, cur, A, B, index + 1);
	    }
	    //
	    public static ArrayList<ArrayList<Integer>> combine2(int A, int B) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	        finalCombine2(res, new ArrayList<Integer>(), A, B, 1);
	        return res;
	    }

	    private static void
	    finalCombine2(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int A, int size, int index) {

	        if (temp.size() == size) {
	            res.add(new ArrayList<>(temp));
	            return;
	        }
	        for (int i = index; i <=A; i++) {
	            if (temp.contains(i)) continue;
	            temp.add(i);
	            finalCombine2(res, temp, A, size, i + 1);
	            //  this is shared array for all the stack calls , so we undo the array to previous stack
	            temp.remove(temp.size() - 1);

	        }
	    }
	    private ArrayList < ArrayList < Integer >> ansScalerSol;
	    public ArrayList < ArrayList < Integer >> combineScalerSol(int A, int B) {
	        ansScalerSol = new ArrayList < > ();
	        ArrayList < Integer > cur = new ArrayList < > ();
	        solveScalerSol(1, cur, A, B);
	        return ansScalerSol;
	    }
	    void solveScalerSol(int idx, ArrayList < Integer > cur, int A, int B) {
	        if (cur.size() == B) {
	            ans.add(new ArrayList < > (cur));
	            return;
	        }
	        if (idx == A + 1) 
	            return;
	        // Include current element
	        cur.add(idx);
	        solveScalerSol(idx + 1, cur, A, B);
	        cur.remove(cur.size() - 1);
	        // Don't include current element
	        solveScalerSol(idx + 1, cur, A, B);
	    }
	    public void printArray(int[][] A) {
	    	for(int i=0; i<A.length; i++) 
				System.out.println(A[i][0] + " " + A[i][1]);
			System.out.println();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations c = new Combinations();
		int[][] A = c.combine(4, 2); // 1 2  1 3  1 4  2 3  2 4  3 4
		int[][] B = c.combine(3, 2); // 1 2  1 3  2 3
		int[][] C = c.combine(1, 1); // 1
		//int[][] D = c.combine(3, 3); // not working for these, need to make generic
		c.printArray(A);
		c.printArray(B);
		//c.printArray(C);
		for(int i=0; i<C.length; i++) {
			System.out.println(C[i][0] + " " );
		}
		System.out.println();
	}

}
