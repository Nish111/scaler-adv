package math2_gcd_180123;
// https://www.scaler.com/academy/mentee-dashboard/class/50132/homework/problems/5880/?navref=cl_pb_nv_tb
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class AllGCDPair {

	public int[] solve(int[] A) {
		
		HashSet<Integer> hashSet = new HashSet<>();
		for(int i=0; i<A.length-1; i++) {
			int temp = gcd(A[i], A[i+1]);
			hashSet.add(temp);
		}
		
		return hashSet.stream().mapToInt(Integer::intValue).toArray();
    }
	public int gcd(int A, int B) {
		if(B==0) return A;
		return gcd(B, A%B); // as A%B always less than B so keep it first
	}
	  public int[] solve2(int[] A) {

	        int orignalN =(int) Math.sqrt(A.length);//size of original array
	        int[] ans=new int[orignalN]; // original array to return
	        int max=0;
	        int j =0;
	        for(int i =0; i<orignalN;i++){
	            for( ;j<(i+1)*orignalN;j++){
	                max=Math.max(max,A[j]);
	            }
	            ans[i]=max;
	            max=0;
	        }
	        return ans;
	    }
	  public int gcdScalerSol(int A, int B) {
	        if (A == 0)
	            return B;
	        return gcd(B % A, A);
	    }
	    public ArrayList < Integer > solveScalerSol(ArrayList < Integer > A) {
	        ArrayList < Integer > ans = new ArrayList < Integer > ();
	        Collections.sort(A, Collections.reverseOrder());
	        HashMap < Integer, Integer > mp = new HashMap < Integer, Integer > ();
	        // mp stores the count of A[i]'s that are to be deleted from the array
	        for (int i = 0; i < A.size(); i++) {
	            int x = A.get(i);
	            if (mp.containsKey(x) && mp.get(x) > 0)
	                mp.put(x, mp.get(x) - 1);
	            else {
	                for (int j = 0; j < ans.size(); j++) {
	                    int g = gcdScalerSol(ans.get(j), x);

	                    if (mp.containsKey(g))
	                        mp.put(g, mp.get(g) + 2);
	                    else
	                        mp.put(g, 2);
	                        
	                    // we are adding 2 to the mp as there will 2 pairs gcd(ans[j],A[i]) and gcd(A[i],ans[j])
	                }
	                ans.add(x);
	            }
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllGCDPair agp = new AllGCDPair();
		int[] A = {2,2,2,2,8,2,2,2,10};
		int[] B = agp.solve2(A);
		int[] C = {5, 5, 5, 15};
		int[] D = agp.solve2(C);
		// given this example to disprove above approach
		// but this is incorrect as if we go by pair G will be correct array
		// and if we apply on G, then we do get correct
		int[] E = {1,1,1,2,2,2,1,4,9};// 2 4 9 - G = {2,2,1,2,4,1,1,1,9}
		int[] F = agp.solve2(E);
		int[] G = {2,2,1,2,4,1,1,1,9};
		int[] H = agp.solve2(G);
		for(int i=0; i<B.length; i++) System.out.print(B[i]+" ");
		System.out.println(); // 2 8 10
		for(int i=0; i<D.length; i++) System.out.print(D[i]+" ");
		System.out.println(); // 5 15
		for(int i=0; i<F.length; i++) System.out.print(F[i]+" ");
		System.out.println(); // 1 2 9 -- incorrect array E 
		for(int i=0; i<H.length; i++) System.out.print(H[i]+" ");
		System.out.println(); // 2 4 9 
		
	}

}
