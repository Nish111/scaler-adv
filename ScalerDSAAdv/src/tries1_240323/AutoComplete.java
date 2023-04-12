package tries1_240323;

import java.util.Scanner;
// https://www.scaler.com/academy/mentee-dashboard/class/70936/assignment/problems/9388?navref=cl_tt_nv
public class AutoComplete {
	public void insert(TrieNode2 root, String word) { // O(len(word))
		TrieNode2 curr = root;
		int n = word.length();
		for(int i=0; i<n; i++) {
			int index = word.charAt(i)-'a';
			if(curr.child[index]==null) {
				curr.child[index] = new TrieNode2();
			}
			curr = curr.child[index];
			curr.counter++;
		}
		curr.counter++;
		return;
	}
	public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
		AutoComplete ac = new AutoComplete();
		Scanner sc = new Scanner(System.in);
		int to = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] arrN = new String[N];
        for(int i=0; i<N; i++) {
        	arrN[i]=sc.next();
        }
        int[] arrN1 = new int[N];
        for(int i=0; i<N; i++) {
        	arrN1[i]=sc.nextInt();
        }
        String[] arrM = new String[M];
        for(int i=0; i<M; i++) {
        	arrM[i]=sc.next();
        }
    }

}
