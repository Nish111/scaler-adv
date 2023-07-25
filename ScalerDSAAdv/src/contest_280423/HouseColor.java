package contest_280423;

import java.util.HashMap;
import java.util.Map;
// https://www.scaler.com/test/194c814142/#/problem_3
public class HouseColor {
	
	public static int solve(int[] A) {
        //return maxDistance;
        int p1=0, p2=A.length-1;
        int res=-1;
        while(p1<p2) {
        	if(A[p1]==A[p2]) {
        		p1++;
        		
        	} else {
        		res = Math.max(res, p2-p1);
        		break;
        	}
        }
        p1=0; p2=A.length-1;
        while(p1<p2) {
        	if(A[p1]==A[p2]) {
        		p2--;
        	} else {
        		res = Math.max(res, p2-p1);
        		break;
        	}
        }
        
        return res;
    }
	public int solveScalerSol(int[] A) {
		int n = A.length, i=0, j=n-1;
		while(A[0]==A[j]) j--;
		while(A[n-1]==A[i]) i++;
		return Math.max(n-1-i, j);
	}
	public static void main(String[] args) {
		HouseColor hc = new HouseColor();
		int[] shops = {3, 4, 1, 4, 4};
		System.out.println(hc.solve(shops)); // 4
		int[] A = {4,1,2,4,5,1,4};
		System.out.println(hc.solve(A)); // 5
	}
}

