package arrays3_090123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
// https://www.scaler.com/academy/mentee-dashboard/class/50128/assignment/problems/65/hints?navref=cl_pb_nv_tb
public class MissingNaturalNumber {

	public int missingNumber(int[] A) { // brute O(n2) O(1)
		boolean flag=false;
		int val=0;
		for(int i=1; i<A.length+1; i++) {
			flag = false;
			for(int j=0; j<A.length; j++) {
				if(i==A[j]) flag= true;
			}
			//System.out.println(i);
			if(!flag) {
				val=i;
				break;
			}
			//System.out.println(i+" "+val);
		}
		if(val != 0) return val;
		else return A.length+1;
	}
	public int missingNumberHash(int[] A) { // hashset O(n) O(n)
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<A.length; i++) {
			hs.add(A[i]);
		}
		for(int i=1; i<A.length+1; i++) {
			if(!hs.contains(i)) return i;
		}
		return A.length+1;
	}
	public int firstMissingPositive(ArrayList<Integer> A) { // for Scaler as ArrayList
        HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<A.size(); i++) {
			hs.add(A.get(i));
		}
		for(int i=1; i<A.size()+1; i++) {
			if(!hs.contains(i)) return i;
		}
		return A.size()+1;
    }
	public int firstMissingPositiveScalerSol(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0 && A.get(i) <= n) {
                int pos = A.get(i) - 1;
                if (A.get(pos) != A.get(i)) {
                    Collections.swap(A, pos, i);
                    i--;
                    // We are doing i-- as we have swapped i'th element with pos'th element and we might not have processed the pos'th element.
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (A.get(i) != i + 1) 
                return (i + 1);
        }
        return n + 1;
    }
	public int missingNumberSorting(int[] A) { // hashset O(nlogn) O(1)
		Arrays.sort(A);
		int count=0;
		for(int i=1; i<A.length+1; i++) {
			if(i<A.length-1) {
				if(A[i]>0 &&(A[i+1]-A[i]>1)) return A[i]+1;
			}
		}
		return A.length+1;
	}
	public int missingNumberBestApproach(int[] A) { // hashset O(nlogn) O(1)
		// while is not ending infinite loop
		for(int i=0; i<A.length; i++) {
			  while(A[i] != (i+1) && A[i]>0 && A[i]<=A.length) {
				  int x = A[i];
				  if(x == A[x-1]) break;
				  // swap(A[i], A[x-1]); // swap is not happening so problem
				  int temp = A[i];
					A[i] = A[x-1];
					A[x-1]= temp;
				  //System.out.println(i);
				  //i++;
			  }
			  //System.out.println(i);
		}
		for(int i=0; i<A.length; i++) {
			if(A[i] != i+1) return i+1;
		}
		return A.length+1;
	}
	public void swap(int i, int j) {
		// TODO Auto-generated method stub
		int temp = i;
		i = j;
		j= temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNaturalNumber mnn = new MissingNaturalNumber();
		int[] A = {3, -2, 1, 2, 7};
		int[] B = {-9, 2, 6, 4, 8, 1, 3};
		int[] C = {1,2,3,4,5};
		int[] D = {4,3,7,6,9,1,8,3};
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(4); ar.add(3); ar.add(7); ar.add(6); ar.add(9); ar.add(1); ar.add(8); ar.add(3);
		System.out.println(mnn.firstMissingPositive(ar)); // 2
		System.out.println(mnn.missingNumberBestApproach(D)); // 2
		System.out.println(mnn.missingNumber(A)); // 4
		System.out.println(mnn.missingNumber(B)); // 5
		System.out.println(mnn.missingNumber(C)); // 6
		System.out.println(mnn.missingNumberHash(A)); // 4
		System.out.println(mnn.missingNumberHash(B)); // 5
		System.out.println(mnn.missingNumberHash(C)); // 6
		System.out.println(mnn.missingNumberSorting(A)); // 4
		System.out.println(mnn.missingNumberSorting(B)); // 5
		System.out.println(mnn.missingNumberSorting(C)); // 6
	}

}
