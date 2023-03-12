package math3_prime_200123;
// https://www.scaler.com/academy/mentee-dashboard/class/50133/homework/problems/4104/submissions
public class IfTwoRectanglesOverlap {

	public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
		if(A>=G || B>=H || C<=E|| D<=F) return 0;
		else return 1;
		
    }
	public int solveScalerSol(int A, int B, int C, int D, int E, int F, int G, int H) {
        // check if the rectangles overlap
        int xs = Math.max(A, E), xe = Math.min(C, G);
        int ys = Math.max(B, F), ye = Math.min(D, H);
        if (xs < xe && ys < ye)
            return 1;
        else
            return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IfTwoRectanglesOverlap itro = new IfTwoRectanglesOverlap();
		System.out.println(itro.solve(0, 0, 4, 4, 2, 2, 6, 6)); // 1
		System.out.println(itro.solve(0, 0, 4, 4, 2, 2, 3, 3)); // 1
		System.out.println(itro.solve(0, 0, 4, 4, 2, 5, 6, 6)); // 0
		System.out.println(itro.solve(2, 2, 4, 7, 3, 2, 6, 4)); // 1
		System.out.println(itro.solve(3, 1, 10, 5, 1, 4, 9, 8)); // 1
		
	}

}
