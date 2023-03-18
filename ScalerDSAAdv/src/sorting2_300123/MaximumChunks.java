package sorting2_300123;
// https://www.scaler.com/academy/mentee-dashboard/class/50137/homework/problems/4036/hints?navref=cl_pb_nv_tb
public class MaximumChunks {

	public int solve(int[] A) { // O(N) O(1)
		int count=0, max = 0, temp=0;
		// we are comparing max element and index as max
		// if it is 0 we got 1 chunk
		// then we check for next max and similar
		for(int i:A) {
			max = Math.max(max, i);
			if(max==temp) count++;
			temp++;
		}
		return count;
	}
	public int solveScalerSol(int[] A) {
        int cnt = 0, ma = 0, i = 0;
        for (int x: A) {
            ma = Math.max(ma, x);
            // checks if the maximum number so far equals the index number
            if (ma == i)
                cnt += 1;
            i += 1;
        }
        return cnt;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumChunks mc = new MaximumChunks();
		int[] A = {1,2,3,4,0};
		System.out.println(mc.solve(A)); // 1 - 1,2,3,4,0
		int[] B = {2, 0, 1, 3};
		System.out.println(mc.solve(B)); // 2 - 2,0,1 3
		int[] C = {1,2,0,3,5,4};
		System.out.println(mc.solve(C)); // 3 - 1,2,0 3 5,4
		int[] D = {0,1,2,3,4,5};
		System.out.println(mc.solve(D)); /// 6
		int[] E = {1,2,0,4,3,6,5};
		System.out.println(mc.solve(E)); /// 3
	}

}
