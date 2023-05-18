package backtracking1_120423;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
// https://www.scaler.com/academy/mentee-dashboard/class/70941/homework/problems/4178/?navref=cl_pb_nv_tb
public class SquarefulArrays {
	public int findSquarefulArrays(int[] A){ // working // using arrays fives 4 but ArrayList 8
		// for C/B
		Arrays.sort(A);
		int n = A.length;
		if(n==1) return 0;
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		return checkPermutation(0,A,-1,visited);
	}
	public int checkPermutation(int pos, int[] A, int idx, boolean[] visited) {
		// TODO Auto-generated method stub
		if(pos==A.length) return 1;
		int ans = 0;
		for(int i=0; i<A.length; i++) {
			if(visited[i]==false && (i==0 || (A[i]!= A[i-1] || (visited[i-1])))
					&&(idx==-1 || checkVal(A[idx], A[i]))) {
				visited[i] = true;
				ans += checkPermutation(pos+1, A, i, visited);
				visited[i]=false;
			}
		}
		return ans;
	}
	  public boolean checkVal(int x, int y) {
		long temp = x+y;
		int val = (int) Math.sqrt(temp);
		return (long)val*val==temp;
	}
	  // another
	public int solve(ArrayList < Integer > A) {
	        int n = A.size();
	        if (n == 1) return 0;
	        HashMap < Integer, Integer > map = new HashMap < > ();
	        for (int i = 0; i < n; i++) map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
	        return Squareful(0, new ArrayList < > (), map, n);

	    }

	    private int Squareful(int index, ArrayList < Integer > arrangement, HashMap < Integer, Integer > map, int n) {
	        if (n == index) return 1;

	        int ans = 0;
	        for (int key: map.keySet()) {
	            if (map.get(key) > 0) {
	                if (index == 0) {
	                    arrangement.add(key);
	                    map.put(key, map.get(key) - 1);
	                    ans += Squareful(index + 1, arrangement, map, n);
	                    map.put(key, map.get(key) + 1);
	                    arrangement.remove(arrangement.size() - 1);
	                } else {
	                    int sum = key + arrangement.get(index - 1);
	                    int sqrt = (int) Math.sqrt(sum);
	                    if (sum == sqrt * sqrt) {
	                        arrangement.add(key);
	                        map.put(key, map.get(key) - 1);
	                        ans += Squareful(index + 1, arrangement, map, n);
	                        map.put(key, map.get(key) + 1);
	                        arrangement.remove(arrangement.size() - 1);
	                    }
	                }
	            }
	        }
	        return ans;
	    }
	    // modified now
	    boolean isPerfect(int num1,int num2){
	        long xx = num1+num2;
	        int root = (int)Math.sqrt(xx);
	        return (long)root*root==xx;
	    }
	    int helper(int count,int[] arr,int prevIdx,boolean[] visited){
	        if(count==arr.length) return 1;
	        int ans=0;
	        for(int i=0;i<arr.length;i++){
	            if(visited[i]==false && (i==0 || (arr[i]!=arr[i-1] || visited[i-1])) && (prevIdx==-1 || isPerfect(arr[prevIdx],arr[i]))){
	                visited[i]=true;
	                ans+=helper(count+1,arr,i,visited);
	                visited[i]=false;
	            }
	        }
	        return ans;
	    }
	    public int solve(int[] A) {
	        Arrays.sort(A);
	        int n = A.length;
	        if(n==1) return 0;        
	        boolean[] visited = new boolean[n];
	        return helper(0,A,-1,visited);
	        // return ans;
	    }
	    boolean isPerfectSquare(int n) {
	        int m = (int) Math.sqrt(n) - 2;
	        while (1L * m * m < n) m++;
	        return m * m == n;
	    }
	    public int solveScalerSol(int[] A) {
	        HashMap < Integer, Integer > count = new HashMap < > ();
	        int N = A.length;
	        for (int i = 0; i < N; i++) {
	            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
	        }
	        HashMap < Integer, HashSet < Integer >> graph = new HashMap < > ();
	        for (int i = 0; i < N - 1; i++) {
	            for (int j = i + 1; j < N; j++) {
	                if (isPerfectSquare(A[i] + A[j])) {
	                    // add an edge from i to j and j to i
	                    HashSet < Integer > set = graph.getOrDefault(A[i], new HashSet < Integer > ());
	                    if (!set.contains(A[j])) {
	                        set.add(A[j]);
	                        graph.put(A[i], set);
	                    }
	                    set = graph.getOrDefault(A[j], new HashSet < Integer > ());
	                    if (!set.contains(A[i])) {
	                        set.add(A[i]);
	                        graph.put(A[j], set);
	                    }
	                }
	            }
	        }
	        ArrayList < ArrayList < Integer >> res = new ArrayList < > ();
	        for (int i: count.keySet()) {
	            backtrackScalerSol(graph, count, N, i, new ArrayList < Integer > (), res);
	        }
	        return res.size();
	    }

	    public void backtrackScalerSol(HashMap < Integer, HashSet < Integer >> graph, Map < Integer, Integer > count, int N, int value,
	        List < Integer > temp, ArrayList < ArrayList < Integer >> res) {
	        if (count.get(value) == 0)
	            return;
	        if (!graph.containsKey(value))
	            return;
	        count.put(value, count.get(value) - 1);
	        temp.add(value);
	        if (temp.size() == N) {
	            res.add(new ArrayList < Integer > (temp));
	        } else {
	            for (int i: graph.get(value)) {
	                // traverse all adjacent vertices
	                backtrackScalerSol(graph, count, N, i, temp, res);
	            }
	        }
	        temp.remove(temp.size() - 1);
	        count.put(value, count.get(value) + 1);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquarefulArrays sa = new SquarefulArrays();
		ArrayList<Integer> A = new ArrayList<>();
		A.add(2); A.add(2); A.add(2);
		//System.out.println(sa.findSquarefulArrays(A)); // 1
		System.out.println(sa.solve(A));// 1
		int[] B = {16777,1179,265,135,90,135,34};
		System.out.println(sa.solve(B));// 4
		ArrayList<Integer> C = new ArrayList<>();
		C.add(16777); C.add(1179); C.add(265); C.add(135); C.add(90);
		C.add(135); C.add(34);
		System.out.println(sa.findSquarefulArrays(B)); // 8
	}

}
