package arrays1_040123;

import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/50126/homework/problems/329?navref=cl_tt_nv
public class Flip {

	public int[] flip(String A) {
		int[] X = new int[A.length()];
		for(int i=0; i<A.length(); i++) {
			if(A.charAt(i)=='1') X[i]=-1;
			if(A.charAt(i)=='0') X[i]=1;
		}
		int curr = 0, best=0, l=0, r=-1, count=0;
		for(int i=0; i<A.length(); i++) {
			curr +=X[i];
			if(curr <0) {
				curr=0; count=i+1;
			}
			else if(curr>best) {
				l = count;
				r=i;
				best = curr;
			}
			//System.out.println(i + " " + l +" "+ r);
		}
		if(r != -1) {
			return new int[] {l+1, r+1};
			//return Arrays.copyOfRange(X, l, r);
		}
		else return new int[]{};
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flip f = new Flip();
		String A = "010";
		String B = "000";
		String C = "1100100";
		int[] X = f.flip(A); // 1 1
		int[] Y = f.flip(B); // 1 3
		int[] Z = f.flip(C); // 3 7
		for (int i = 0; i < X.length; i++) System.out.print(X[i] + " ");
		System.out.println();
		for (int i = 0; i < Y.length; i++) System.out.print(Y[i] + " ");
		System.out.println();
		for (int i = 0; i < Z.length; i++) System.out.print(Z[i] + " ");
		System.out.println();
		
	}

}
