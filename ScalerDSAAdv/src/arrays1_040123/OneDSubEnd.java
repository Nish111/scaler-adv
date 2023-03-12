package arrays1_040123;
// https://www.scaler.com/academy/mentee-dashboard/class/50126/assignment/problems/440/submissions
public class OneDSubEnd {

	public int[] oneD(int[] A, int[][] Q) {
		int len = Q.length;
		int count=0;
		while(count<len) {
			A[Q[count][0]] +=Q[count][2];
			if(Q[count][1] != len) {
				A[Q[count][1]] =A[Q[count][1]]-Q[count][2];
			}
			count++;
		}
		for(int i=1; i<A.length; i++) {
			A[i] = A[i-1] + A[i];
		}
		return A;
	}
	public int[] oneDStart1(int[] A, int[][] Q) {
		int len = Q.length;
		int count=0;
		while(count<len) {
			A[Q[count][0]-1] +=Q[count][2];
			if((Q[count][1]) != A.length) {
				//System.out.println(count + " "+Q[count][1]);
				A[Q[count][1]] =A[Q[count][1]]-Q[count][2];
			}
			count++;
		}
		/*
		 * for(int i=0; i<A.length; i++) System.out.print(A[i]+" ");
		 * System.out.println();
		 */
		for(int i=1; i<A.length; i++) {
			A[i] = A[i] + A[i-1];
		}
		return A;
	}
	public int[] prefixSumScalerSol(int[] A){
        int[] pref = A;
        for(int i = 1; i < A.length; i++){
            pref[i] += pref[i - 1];
        }
        return pref;
    }
    public int[] solveScalerSol(int A, int[][] B) {
        int[] coins = new int[A];
        for (int i = 0; i < A; i++) coins[i] = 0;
        // coins is an array which denotes the number of coins that each beggar has. Initially each beggar has 0 coins.
        for (int i = 0; i < B.length; i++) {
            int leftIndex = B[i][0] - 1, rightIndex = B[i][1] - 1;
            int donationByDevotee = B[i][2];
            coins[leftIndex] += donationByDevotee;
            if ((rightIndex + 1) < A) coins[rightIndex + 1] -= donationByDevotee;
        }
        int[] ans = prefixSumScalerSol(coins);
        return ans;
    }
	 public int[] solveBrute(int A, int[][] B) {
	        int rows = B.length;
	        int[] coins = new int[A];
	        for(int i = 0; i < rows; i++) {
	            for(int start = B[i][0]; start <= B[i][1]; start++) {
	                coins[start - 1] = coins[start - 1] + B[i][2];
	            }
	        }
	        return coins;
	    }
	 public int[] solve(int A, int[][] B) {
       int[] res=new int[A];
       for(int i=0;i<B.length;i++){
           res[B[i][0]-1]+=B[i][2];
           if(B[i][1]!=A) {
        	   System.out.println(i + " "+B[i][1]);
        	   res[B[i][1]]-=B[i][2];
           }
           
       }
       for(int i=0; i<res.length; i++) System.out.print(res[i]+" ");
       System.out.println(); 
       for(int i=1;i<res.length;i++){
            res[i]+=res[i-1];
       }
       return res;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneDSubEnd ods = new OneDSubEnd();
		int[] A = {0,0,0,0,0,0,0,0,0,0};
		int[][] Q = {{3,6,1},{2,7,3},{5,8,-3},{1,9,2}};
		int[] B = ods.oneDStart1(A, Q); // 0 2 5 6 6 3 2 -1 2 0 
		for(int i=0; i<B.length; i++) System.out.print(B[i]+" ");
		System.out.println();
		int[] E = {0,0,0,0,0};
		int[][] C = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
		int[] Z = ods.solve(E.length, C); // 10 55 45 25 25
		for(int i=0; i<Z.length; i++) System.out.print(Z[i]+" ");
		System.out.println();
		int[] D = ods.oneDStart1(E, C); // 10 55 45 25 25
		for(int i=0; i<D.length; i++) System.out.print(D[i]+" ");
		System.out.println(); // 
		}

}
