package graphs5_spa_170523;

import java.util.LinkedList;
import java.util.Queue;
// https://www.scaler.com/academy/mentee-dashboard/class/70954/homework/problems/292/?navref=cl_pb_nv_tb
public class KnightOnChessBoard {
	class Pair { // We add a pair of indices to the queue. So create a class to store a pair of indices.
        int x;
        int y;
        Pair(int a, int b) {
            x = a;
            y = b;
        }
    }
    public int knight(int A, int B, int C, int D, int E, int F) {

        // source point and destination point are based on 1-based indexing. Convert it to 0-based indexing.
        C--;
        D--;
        E--;
        F--;

        /*
        We can apply the bfs to get the minimum steps required to reach the destination.

        Create a matrix of size A*B.
        Also to determine if a cell has been visited, let us have another boolean matrix. If a cell has been
        visited let us mark it as true.
        To maintain the track of steps from the source point to all nodes that are visited,
        let us have a 'steps' variable.
        Each time we visit a cell, we update the cell with the value equal to the no.of steps needed in mat.
        At first there is only one source point.
        We add it to the queue initially.
        Later, we delete that and add the cells that can be visited from that point in the queue.
        These points that have been added are the new source points.
        Now we can see multisource points. And the destination point can be reached from any such source point.
        */

        int[][] mat = new int[A][B];
        boolean[][] check = new boolean[A][B];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(C, D));
        check[C][D] = true;

        int steps = 0;

        while (q.size() > 0) {

            int n = q.size();
            steps++;

            for (int i = 1; i <= n; i++) {

                Pair obj = q.peek();
                q.poll();

                int a = obj.x;
                int b = obj.y;

                if (a - 2 >= 0 && b - 1 >= 0 && check[a - 2][b - 1] == false) {
                    mat[a - 2][b - 1] = steps;
                    check[a - 2][b - 1] = true;
                    q.add(new Pair(a - 2, b - 1));
                }

                if (a - 1 >= 0 && b - 2 >= 0 && check[a - 1][b - 2] == false) {
                    mat[a - 1][b - 2] = steps;
                    check[a - 1][b - 2] = true;
                    q.add(new Pair(a - 1, b - 2));
                }

                if (a - 2 >= 0 && b + 1 < B && check[a - 2][b + 1] == false) {
                    mat[a - 2][b + 1] = steps;
                    check[a - 2][b + 1] = true;
                    q.add(new Pair(a - 2, b + 1));
                }

                if (a - 1 >= 0 && b + 2 < B && check[a - 1][b + 2] == false) {
                    mat[a - 1][b + 2] = steps;
                    check[a - 1][b + 2] = true;
                    q.add(new Pair(a - 1, b + 2));
                }

                if (a + 2 < A && b - 1 >= 0 && check[a + 2][b - 1] == false) {
                    mat[a + 2][b - 1] = steps;
                    check[a + 2][b - 1] = true;
                    q.add(new Pair(a + 2, b - 1));
                }

                if (a + 1 < A && b - 2 >= 0 && check[a + 1][b - 2] == false) {
                    mat[a + 1][b - 2] = steps;
                    check[a + 1][b - 2] = true;
                    q.add(new Pair(a + 1, b - 2));
                }

                if (a + 2 < A && b + 1 < B && check[a + 2][b + 1] == false) {
                    mat[a + 2][b + 1] = steps;
                    check[a + 2][b + 1] = true;
                    q.add(new Pair(a + 2, b + 1));
                }

                if (a + 1 < A && b + 2 < B && check[a + 1][b + 2] == false) {
                    mat[a + 1][b + 2] = steps;
                    check[a + 1][b + 2] = true;
                    q.add(new Pair(a + 1, b + 2));
                }
            }
        }

        // There are two conditions where we return -1.
        // If any of these E and F are outside the matrix.
        // If that is not the case, we check its status in the boolean matrix. If unvisited, we can conclude
        // that destination cannot be reached.

        if (E >= A || F >= B || check[E][F] == false) {
            return -1;
        }
       
        // If we are not returning -1, we know we have visited the destination.
        // Since we have stored the minimum no.of steps to reach to reach a particular cell from a node,
        // we know our answer is the value at cell mat[E][F]. So we return that.

        return mat[E][F];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnightOnChessBoard koc = new KnightOnChessBoard();
		int A = 8, B = 8, C = 1, D = 1, E = 8, F = 8;
		System.out.println(koc.knight(A, B, C, D, E, F)); // 6
		int A1 = 2, B1 = 4, C1 = 2, D1 = 1, E1 = 4, F1 = 4;
		System.out.println(koc.knight(A1, B1, C1, D1, E1, F1)); // -1
				

	}

}
