package hashing_130223;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50143/homework/problems/4808/hints?navref=cl_pb_nv_tb
public class SortArrayInGivenOrder {

	public int[] solve(int[] A, int[] B) { // O(NlogN)
		/*
		 * Given two arrays of integers A and B, Sort A in such a way that the relative order 
		 * among the elements will be the same as those are in B.
For the elements not present in B, append them at last in sorted order.
Return the array A after sorting from the above method.
NOTE: Elements of B are unique.
		 */
		HashMap<Integer, Integer> hmA = new HashMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		for(int i=0; i<A.length; i++) {
			if(hmA.containsKey(A[i])) {
				hmA.put(A[i], hmA.get(A[i])+1);
				//System.out.println("A 1st if "+A[i] +" "+hmA.get(A[i]));
			} else {
				hmA.put(A[i], 1);
				//System.out.println("A 1st else "+A[i] +" "+hmA.get(A[i]));
			}
		}
		for(int i=0; i<B.length; i++) {
			if(hmA.containsKey(B[i])) {
				int temp = hmA.get(B[i]);
				//System.out.println("temp "+temp);
				while(temp != 0) {
					res.add(B[i]);
					temp--;
					//System.out.println("B 1st while "+B[i]);
				}
				hmA.remove(B[i]);
			}
		}
		ArrayList<Integer> temp  = new ArrayList<>();
        for(int val : A){
            if(hmA.containsKey(val)){
                temp.add(val);
            }
        }
        Collections.sort(temp);
        res.addAll(temp);
		
		System.out.println("ArrayList Contains :" + res);
        Integer ans[] = new Integer[res.size()];
        
        // toArray() method converts the set to array
        res.toArray(ans);
        System.out.println("Printing ans");
        for (int n : res)
            System.out.println(n);
		
        System.out.println("Printing arr");
        int[] arr = new int[ans.length];
        for(int i=0; i<arr.length; i++)
        	arr[i] = ans[i];
        printArray(arr);
		return arr;
    }
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public ArrayList < Integer > solveScalersol(ArrayList < Integer > A, ArrayList < Integer > B) {
        TreeMap < Integer, Integer > mp = new TreeMap < Integer, Integer > ();
        // stores the frequency of the elements of A
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            if (mp.get(x) == null) {
                mp.put(x, 1);
            } else {
                mp.put(x, mp.get(x) + 1);
            }
        }
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        for (int i = 0; i < B.size(); i++) {
            int y = B.get(i);
            // checks if y exists in A
            if (mp.get(y) != null) {
                while (mp.get(y) > 0) {
                    ans.add(y);
                    mp.put(y, mp.get(y) - 1);
                }
            }
        }
        Set < Integer > keys = mp.keySet();
        // append the elements that are not present in B
        for (Integer key: keys) {
            int t = mp.get(key);
            while (t > 0) {
                ans.add(key);
                t--;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortArrayInGivenOrder sago = new SortArrayInGivenOrder();
		int[] A = {1, 2, 3, 4, 5};
		int[] B = {5,4,2};
		int[] C = sago.solve(A, B); // 5 4 2 1 3
		sago.printArray(C);
		int[] D = {1, 3, 1, 5, 2, 6, 5, 4};
		int[] E = {5,4,2};
		int[] F = sago.solve(D, E); // 5 5 4 2 1 3 1 6
		sago.printArray(F);
		int[] G = { 15, 5, 10, 6, 14 };
		int[] H = { 8, 16, 6, 2, 13, 1, 12, 3, 14 };
		int[] I = sago.solve(G, H);
		sago.printArray(I);
	}

}
