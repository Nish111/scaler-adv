package math4_combinatorics_240123;
// https://www.scaler.com/academy/mentee-dashboard/class/50134/homework/problems/4097/?navref=cl_pb_nv_tb
public class RectangeArea {

	public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
		if(G<=A || E>=C || H<=B || F>=D) return 0;
		int x1 = Math.max(A, E);
		int x2 = Math.min(C, G);
		int y1 = Math.max(B, F);
		int y2 = Math.min(D, H);
		return Math.abs((x2-x1)*(y2-y1));
	}
	public int solveScalerSol(int A, int B, int C, int D, int E, int F, int G, int H) {
        // x-distance for intersecting rectangle
        int x = Math.min(G, C) - Math.max(A, E);
        // y-distance for intersecting rectangle
        int y = Math.min(D, H) - Math.max(B, F);
        int area = x * y;
        if(x < 0 || y < 0)
            area = 0;
        return area;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectangeArea ra = new RectangeArea();
		System.out.println(ra.solve(0, 0, 4, 4, 2, 2, 6, 6)); // 4
		System.out.println(ra.solve(0, 0, 4, 4, 2, 2, 3, 3)); // 1
		System.out.println(ra.solve(0, 0, 4, 4, 2, 2, 6, 6)); // 
		
		
	}

}
