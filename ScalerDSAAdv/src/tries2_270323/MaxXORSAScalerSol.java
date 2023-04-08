package tries2_270323;

public class MaxXORSAScalerSol {
    static final int INT_SIZE = 32;
    static class TrieNode {
        int value;
        int end;
        TrieNode[] arr = new TrieNode[2];
        public TrieNode() {
            end = -1;
            value = 0;
            arr[0] = null;
            arr[1] = null;
        }
    }
    static TrieNode root;
    static void insert(int pre_xor, int index) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (temp.arr[val] == null)
                temp.arr[val] = new TrieNode();

            temp = temp.arr[val];
        }
        temp.value = pre_xor;
        temp.end = index;
    }
    static PairSA query(int pre_xor) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (temp.arr[1 - val] != null)
                temp = temp.arr[1 - val];
            else if (temp.arr[val] != null)
                temp = temp.arr[val];
        }
        return (new PairSA(pre_xor ^ (temp.value), temp.end));
    }
    public int[] solve(int[] arr) {
        int n = arr.length;
        root = new TrieNode();
        insert(0, -1);
        int[] res = new int[2];
        int result = Integer.MIN_VALUE;
        int pre_xor = 0;
        int start = -1;
        int end = 0;
        for (int i = 0; i < n; i++) {
            pre_xor = pre_xor ^ arr[i];
            insert(pre_xor, i);
            PairSA ans = query(pre_xor);
            if (ans.a > result) {
                result = ans.a;
                end = i;
                start = ans.b + 1;
            } else if (ans.a == result) {
                int currLen = end - start + 1;
                int newLen = i - (ans.b + 1) + 1;
                if (newLen < currLen) {
                    start = ans.b + 1;
                    end = i;
                } else if (newLen == currLen && (ans.b + 1) < start) {
                    start = ans.b + 1;
                    end = i;
                }
            }
        }
        res[0] = start + 1;
        res[1] = end + 1;
        return res;
    }
}
class PairSA {
    int a, b;
    public PairSA(int c, int d) {
        this.a = c;
        this.b = d;
    }
}