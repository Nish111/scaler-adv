package graphs5_spa_170523;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoardScalerSol {
  private static final int dx[] = new int[] {-2, -2, 1, -1, 2, 2, 1, -1};
  private static final int dy[] = new int[] {1, -1, 2, 2, 1, -1, -2, -2};
  public int knight(int N, int M, int x1, int y1, int x2, int y2) {

    Queue < Node > queue = new LinkedList < > ();
    Node node = new Node(x1, y1);
    HashSet < Node > marked = new HashSet < > ();

    queue.add(node);
    queue.add(null);
    int level = 0;
    marked.add(node);

    while (!queue.isEmpty()) {
      Node n = queue.remove();

      if (n == null) {
        level++;
        if (!queue.isEmpty()) {
          queue.add(null);
        }
        continue;
      }

      if (n.x == x2 && n.y == y2)
        return level;

      for (int k = 0; k < 8; k++) {
        int x = n.x + dx[k];
        int y = n.y + dy[k];

        if (isValid(x, y, N, M)) {
          Node nn = new Node(x, y);
          if (!marked.contains(nn)) {
            marked.add(nn);
            queue.add(nn);
          }
        }
      }

    }

    return -1;
  }

  public boolean isValid(int x, int y, int N, int M) {
    if (x < 1 || x > N || y < 1 || y > M)
      return false;

    return true;
  }

  class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null)
        return false;
      if (obj.getClass() != getClass())
        return false;
      if (this == obj)
        return true;
      Node node = (Node) obj;
      if (this.x == node.x && this.y == node.y)
        return true;
      return false;
    }

    @Override
    public int hashCode() {
      return (int)((31 * x + y) & 0x7fffffff);
    }
  }
}