package backtracking1_120423;

import java.util.ArrayList;
import java.util.HashSet;

public class Permutation {
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>() ;
	public ArrayList<ArrayList<Integer>> createPermutations(ArrayList<Integer> A){
		ArrayList<Integer> l = new ArrayList<Integer>();
		HashSet<Integer> hs = new HashSet<>();
		int n = A.size();
		find(A, hs, n, l);
		return ans;
	}
	public void find(ArrayList<Integer> A, HashSet<Integer> hs, int n, ArrayList<Integer> l) {
		// TODO Auto-generated method stub
		if(hs.size()==n) {
			ans.add(new ArrayList<>(l));
			//System.out.println("Here");
			return;
		}
		for(int i=0; i<n; i++) {
			if(!hs.contains(A.get(i))) {
				l.add(A.get(i));
				hs.add(A.get(i));
				find(A, hs, n, l);
				l.remove(l.size()-1);
				hs.remove(A.get(i));
			}
		}
	}
	public void printArray(ArrayList<ArrayList<Integer>> A) {
		System.out.println(A.size()); // 4 but everything empty
		for(int i=0; i<A.size(); i++) {
			for(int j=0;j<A.get(i).size(); j++) {
				System.out.print(A.get(i).get(j) +" ");
			}
			System.out.println();
		}
	}
	private boolean[] marked;
    private ArrayList < ArrayList < Integer >> res;
    private ArrayList < Integer > A;
    private int n;
    public ArrayList < ArrayList < Integer >> permuteScalerSol(ArrayList < Integer > A) {
        n = A.size();
        marked = new boolean[n];
        res = new ArrayList < > ();
        this.A = A;
        recScalerSol(0, new ArrayList < > ());
        return res;
    }
    public void recScalerSol(int idx, ArrayList < Integer > temp) {
        if (idx == n) {
            res.add(new ArrayList < > (temp));
            return;
        }
        // try all possible elements for the current position
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                marked[i] = true;
                temp.add(A.get(i));
                recScalerSol(idx + 1, temp);
                marked[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation p = new Permutation();
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1); A.add(2); A.add(3);
		ArrayList<ArrayList<Integer>> B = p.createPermutations(A);
		p.printArray(B);
	}

}
