package arrays3_090123;
// https://www.scaler.com/academy/mentee-dashboard/class/50128/assignment/problems/47/submissions
public class RainWaterTrapped {

	public int waterTrapped(int[] A) {
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		left[0] = A[0];
		right[A.length-1] = A[A.length-1];
		for(int i=1; i<A.length; i++) {
			if(A[i] < left[i-1]) left[i] = left[i-1];
			else left[i] = A[i];
			//left[i] = Math.max(left[i-1], A[i]);
		}
		//for(int i=0; i<left.length; i++) System.out.print(left[i]+ " ");
		//System.out.println();
		for(int i=A.length-2; i>=0; i--) {
			if(A[i] < right[i+1]) right[i] = right[i+1];
			else right[i] = A[i];
			//right[i] = Math.max(right[i+1], A[i]);
		}
		//for(int i=0; i<right.length; i++) System.out.print(right[i]+ " ");
		//System.out.println();
		int result = 0, result2=0;
		for(int i=0; i<A.length; i++) {
			//int support = Math.min(left[i-1], right[i+1]);
			//int water_trapped = support-A[i];
			//if(water_trapped >0) result += water_trapped;
			//System.out.println(i+" "+water_trapped+" "+support);
			result += (Math.min(left[i], right[i])-A[i]);
			//System.out.print(Math.min(left[i], right[i]) -A[i] +" ");
		}
		//System.out.println();
		for(int i=1; i<A.length-1; i++) {
			int support = Math.min(left[i-1], right[i+1]);
			int water_trapped = support-A[i];
			if(water_trapped >0) result2 += water_trapped;
		}
		return result2;
	}
	public int waterTrapped2(int[] A) {
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		left[0] = A[0];
		right[A.length-1] = A[A.length-1];
		for(int i=1; i<A.length; i++) {
			left[i] = Math.max(left[i-1], A[i]);
		}
		for(int i=0; i<left.length; i++) System.out.print(left[i]+ " ");
		System.out.println();
		for(int i=A.length-2; i>=0; i--) {
			right[i] = Math.max(right[i+1], A[i]);
		}
		for(int i=0; i<right.length; i++) System.out.print(right[i]+ " ");
		System.out.println();
		int result = 0, result2=0;
		for(int i=0; i<A.length; i++) {
			result += (Math.min(left[i], right[i])-A[i]);
		}
		
		return result;
	}
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trapScalerSol(final int[] A) {
        int n = A.length;
        int left = 0; 
        int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;
        while(left <= right){ 
            // When height of left side is lower, calculate height of water trapped in left bin else calculate for right bin
            if(A[left] <= A[right]){
                if(A[left] >= maxleft) 
                    maxleft = A[left]; //This index wont store any water as there is no index towards the left whose height is greater than this.
                else 
                    res += maxleft - A[left];
                left++;
            }
            else{
                if(A[right] >= maxright) 
                    maxright = A[right]; //This index wont store any water as there is no index towards the right whose height is greater than this.
                else 
                    res += maxright - A[right];
                right--;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RainWaterTrapped rwt = new RainWaterTrapped();
		int[] A = {2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1};
		System.out.println(rwt.waterTrapped(A)); // 8
		System.out.println(rwt.waterTrapped2(A)); // 8
		int[] B = {56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80, 15, 62, 71, 61, 12, 98, 9, 28, 81, 70, 59, 95, 34, 9, 60, 70, 81, 71, 67, 58, 20, 22, 3, 95, 85, 20, 24, 74, 5, 23, 33, 75, 50, 38, 75, 68, 26, 46, 30, 75, 18, 4, 42, 51, 59, 8, 77};
		System.out.println(rwt.waterTrapped(B)); // 2107 
		System.out.println(rwt.waterTrapped2(B)); // 2107

	}

}
