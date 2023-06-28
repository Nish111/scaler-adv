package graphs4_mst_160523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
// https://www.scaler.com/academy/mentee-dashboard/class/85791/homework/problems/9335?navref=cl_tt_lst_nm
public class EdgeMST3 {
    public int[] solve(int A, int[][] B) {
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            ans[i] = 0;
        }
        DSU1 dsu = new DSU1(A, B, ans);
        return ans;
    }
    static int maxn = 300009;
    static int[] arr = new int[maxn];
    static int[] sz = new int[maxn];
    static ArrayList < pairScalerSolGraph > edges;
    public int[] solveScalerSol(int A, int[][] B) {
        iniScalerSol();
        for (int i = 0; i < B.length; i++)
            edges.add(new pairScalerSolGraph(B[i][2], i, B[i][0], B[i][1]));
        int[] ans = new int[B.length];
        Collections.sort(edges);
        int i = 0;
        int m = B.length;
        while (i < m) {
            int j = i;
            while (j < m && edges.get(j).a == edges.get(i).a) {
                if (rootScalerSol(edges.get(j).c) != rootScalerSol(edges.get(j).d))
                    ans[edges.get(j).b] = 1;
                j++;
            }
            j = i;
            while (j < m && edges.get(j).a == edges.get(i).a) {
                if (rootScalerSol(edges.get(j).c) != rootScalerSol(edges.get(j).d))
                    unScalerSol(edges.get(j).c, edges.get(j).d);
                j++;
            }
            i = j;
        }
        return ans;
    }
    public static void iniScalerSol() {
        edges = new ArrayList < pairScalerSolGraph > ();
        for (int i = 0; i < maxn; i++) {
            arr[i] = i;
            sz[i] = 1;
        }
    }
    public static int rootScalerSol(int a) {
        while (arr[a] != a) {
            arr[a] = arr[arr[a]];
            a = arr[a];
        }
        return a;
    }
    public static void unScalerSol(int a, int b) {
        int ra = rootScalerSol(a);
        int rb = rootScalerSol(b);
        if (sz[ra] <= sz[rb]) {
            arr[ra] = rb;
            sz[rb] += sz[ra];
        } else {
            arr[rb] = ra;
            sz[ra] += sz[rb];
        }
    }
}

class DSU1 {
    int[] actualParent;
    int ans;

    DSU1(int A, int[][] B, int[] result) {
        ans = 0;
        for (int i = 0; i < B.length; i++) {
            B[i] = Arrays.copyOf(B[i], B[i].length + 1);
            B[i][B[i].length - 1] = i;
        }
        actualParent = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            actualParent[i] = i;
        }
        Arrays.sort(B, new ArrayComparator1());
        int j = 0;

        // GOING THROUGH ALL THE POSSIBLE OPTIONS THAT CAN BE TAKEN IN MST THEN TAKING THE UNION
        for (int i = 0; i < B.length; i++) {
            if (j <= i && j < B.length) {
                while (j < B.length && B[j][2] == B[i][2]) {
                    int parent1 = findParent(B[j][0]);
                    int parent2 = findParent(B[j][1]);
                    if (parent1 != parent2) {
                        result[B[j][3]] = 1;
                    }
                    j++;
                }
            }
            union(B[i][0], B[i][1], B[i][2], B[i][3]);
        }
    }

    // PATH COMPRESSION AND FINDING THE ULTIMATE PARENT OF NODE
    private int findParent(int node) {
        if (actualParent[node] == node) {
            return node;
        }
        return actualParent[node] = findParent(actualParent[node]);
    }

    // MERGING NODES IF THEY ARE FROM DIFFERENT COMPONENT
    private void union(int node1, int node2, int weight, int idx) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);
        if (parent1 != parent2) {
            actualParent[parent1] = parent2;
        }
    }
}

class ArrayComparator1 implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[2] < b[2]) {
            return -1;
        } else if (a[2] > b[2]) {
            return 1;
        } else {
            return 0;
        }
    }
}

class pairScalerSolGraph implements Comparable < pairScalerSolGraph > {
    int a, b, c, d;
    pairScalerSolGraph(int e, int f, int g, int h) {
        this.a = e;
        this.b = f;
        this.c = g;
        this.d = h;
    }
    @Override
    public int compareTo(pairScalerSolGraph aa) {
        return this.a - aa.a;
    }
}