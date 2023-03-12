package stringpattern_170223;

import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50145/homework/problems/960/?navref=cl_pb_nv_tb
public class ReplicatingSubstring {

	public int solveBrute(int A, String B) {
		
		return 1;
	}
	public int solve(int A, String B) { // O(N) O(1)
		int[] arrB = new int[26];
		for(int i=0; i<B.length(); i++) {
			arrB[B.charAt(i)-'a']++;
		}
		printArray(arrB);
		for(int i=0; i<26; i++) {
			if(arrB[i]%A !=0) return 0;
		}
		
		return 1;
	}
	public int solveHash(int A, String B) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0; i<B.length(); i++) {
			char temp = B.charAt(i);
			if(hm.containsKey(temp))
				hm.put(temp, hm.get(temp)+1);
			else 
				hm.put(B.charAt(i), 1);
		}
		printHashMap(hm, B);
		for(int i=0; i<B.length(); i++) {
			if(hm.get(B.charAt(i))%A !=0) return -1;
		}
		
		return 1;
	}
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	public void printHashMap(HashMap<Character, Integer> hm, String B) {
		for(int i=0; i<B.length(); i++) {
			System.out.print(hm.get(B.charAt(i))+ " ");
		}
		System.out.println();
	}
	public int solveScalerSol(int A, String B) {
        // hash array to keep a track of frequency of each character
        int hash[] = new int[26];
        for (int i = 0; i < B.length(); i++) {
            hash[B.charAt(i) - 'a']++;
        }
        int flag = 0;
        for (int i = 0; i < 26; i++) {
            // if the frequency of a charatcer present in the string isn't divisble by A, set a flag which 
            // indicates that it will never be possible to represent B as concatenation of A strings
            if (hash[i] % A != 0)
                flag = 1;
        }
        if (flag == 1)
            return -1;
        else
            return 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplicatingSubstring rs = new ReplicatingSubstring();
		String B = "aabbaa";
		System.out.println(rs.solve(2, B));
		System.out.println(rs.solveHash(2, B));
	}

}
