package arrays1_040123;
// https://www.scaler.com/academy/mentee-dashboard/class/50126/homework/problems/4186/?navref=cl_pb_nv_tb
public class AbsoluteMaximum {

	public int solve(int[] A, int[] B, int[] C, int[] D) {
		if(A.length==1) return 0;
		int sum=0;
		int[] sign = {-1,1};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int result=Integer.MIN_VALUE;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2;j++) {
				for(int k=0; k<2; k++) {
					for(int l=0; l<2; l++) {
						sum=0;
						min = Integer.MAX_VALUE;
						max = Integer.MIN_VALUE;
						for(int x=0; x<A.length; x++) {
							//System.out.println(x+" "+i);
							sum=sign[i]*A[x]+sign[j]*B[x]+sign[k]*C[x]+sign[l]*D[x]+x;
							//System.out.println(i+" "+j+" "+k+" "+l+" "+x+" "+sum);
							max = Math.max(max, sum);
							min = Math.min(min, sum);
							result = Math.max(result, max-min);
						}
					}
				}
			}
		}
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbsoluteMaximum am = new AbsoluteMaximum();
		int[] A = {1, 2, 3, 4};
		int[] B = {-1, 4, 5, 6};
		int[] C = {-10, 5, 3, -8};
		int[] D = {-1, -9, -6, -10};
		System.out.println(am.solve(A, B, C, D));
		int[] a = {1, 2};
		int[] b = {3, 6};
		int[] c = {10, 11};
		int[] d = {1, 6};
		System.out.println(am.solve(a, b, c, d));
	}

}
