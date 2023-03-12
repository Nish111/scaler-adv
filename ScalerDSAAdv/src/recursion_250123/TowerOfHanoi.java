package recursion_250123;

import java.util.ArrayList;
// https://www.scaler.com/academy/mentee-dashboard/class/50135/assignment/problems/15010/?navref=cl_pb_nv_tb
public class TowerOfHanoi {

	// (2^n)
	public void tower(int n, String source, String destination, String helper) {
		if(n==1) {
			System.out.println("Moving 1 from " + source + " to "+destination);
			return;
		}
		tower(n-1, source, helper, destination);
		System.out.println("Moving " + n + " from " + source + " to " + destination);
		tower(n-1, helper, destination, source);
		
	}
	int temp=0;
	int[][] res; 
	public int[][] towerOfHanoi(int A) {
		int x = (1<<A)-1;
		res = new int[x][3];
		int source = 1, destination = 3, helper =2;
		towerH(A, source, destination, helper);
		return res;
    }
	public void towerH(int A, int source, int destination, int helper) {
		// TODO Auto-generated method stub
		if(A==0) {
			return;
		}
		towerH(A-1, source, helper, destination);
		res[temp][0]=A;
		res[temp][1]=source;
		res[temp][2]=destination;
		temp++;
		towerH(A-1, helper, destination, source);
		return;
	}
	 int ind=0;
	    int ans[][];
	    public int[][] towerOfHanoi2(int A) {
	       int M=(1<<A)-1;
	       ans=new int[M][3];
	        toh2(A,1,2,3);
	        return ans;
	    }
	    public void toh2(int A,int S,int T,int D){
	        if(A==0)
	        return;
	        toh2(A-1,S,D,T);
	        ans[ind][0]=A;
	        ans[ind][1]=S;
	        ans[ind][2]=D;
	        ind++;
	        toh2(A-1,T,S,D);
	        return;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowerOfHanoi toh = new TowerOfHanoi();
		toh.tower(3, "A", "C", "B"); // so urce destination helper
		System.out.println();
		toh.tower(5, "A", "C", "B");
		System.out.println();
		toh.tower(2, "A", "C", "B");
		System.out.println();
		int[][] A = toh.towerOfHanoi(2);
		for(int i=0; i<A.length; i++) {
			System.out.println(A[i][0] + " " + A[i][1] +" "+A[i][2]+" ");
		}
		System.out.println();
		int[][] B = toh.towerOfHanoi(3);//toh.towerOfHanoi(3);
		for(int i=0; i<B.length; i++) {
			System.out.println(B[i][0] + " " + B[i][1] +" "+B[i][2]+" ");
		}
		System.out.println();
	}

}
