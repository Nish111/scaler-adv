package hashing2_150223;

import java.util.HashMap;

// https://www.scaler.com/academy/mentee-dashboard/class/50144/assignment/problems/151/?navref=cl_pb_nv_tb
public class WindowString {
	public String minWindow(String A, String B) { // please check again
        //this problem statement can be resolved using SLIDING WINDOW + TWO POINTERS
        //I can use freq array of size 128(total no. of ASCII values) as well, I can use hashmap as well
        //proceeding with freq array[128]
        //if found valid window shrink window, else expand window
        //worst case T.C = l pointer can traverse whole array
        //r pointer can traverse whole Arrays = T.C = O(2n) = O(n)

        int m = A.length();
        int n = B.length();
        int[] freqA = new int[128];
        int[] freqB = new int[128];

        for(char c : B.toCharArray()){
            freqB[c]++;
        }
        int l = 0;
        int r = 0;
        int minL = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;
        while(l < m){
            if(check(freqA,freqB)){
                int length = r-l+1;
                if(length < minLength){
                    minLength = length;
                    minL = l;
                    minR = r;
                }
                freqA[A.charAt(l)]--;
                l++;
            }else{
                if(r == m) break;
                freqA[A.charAt(r)]++;
                r++;
            }
        }
        return minL == Integer.MAX_VALUE ? "" : A.substring(minL,minR);
    }

    //T.C = O(128) consider as constant
    private boolean check(int[] a, int[] b){
        for(int i = 0; i < 128; i++){
            if(a[i] < b[i])
                return false;
        }
        return true;
    }
    public String minWindowScalerSol(String A, String B) {
    if (A.length() < B.length())
        return "";
    HashMap < Character, Integer > counts = new HashMap < Character, Integer > ();
    for (int i = 0; i < B.length(); i++) {
        if (counts.get(B.charAt(i)) == null) {
            counts.put(B.charAt(i), 1);
        } else {
            counts.put(B.charAt(i), counts.get(B.charAt(i)) + 1);
        }
    }
    int start = 0;
    int length = 0;
    int total = 0;
    for (int head = 0, tail = 0; tail < A.length(); tail++) {
        if (counts.get(A.charAt(tail)) == null) {
            // If this character is not present in B at all, 
            // we don't care about this character. 
            continue;
        }
        counts.put(A.charAt(tail), counts.get(A.charAt(tail)) - 1);
        // We check if the current character represented by tail caused
        // a character to be included which is relevant to B and is still
        // in deficit. 
        // For example, if B has 3 As, then the first 3 A are relevant to us
        // but the 4th one is not. 
        if (counts.get(A.charAt(tail)) >= 0) {
            total++;
        }
        // check if we have all characters in B covered. 
        if (total == B.length()) {
            // Now move the head pointer till popping out those characters 
            // still makes sure that all characters in B are covered. 
            while (counts.get(A.charAt(head)) == null || counts.get(A.charAt(head)) < 0) {
                if (counts.get(A.charAt(head)) != null) counts.put(A.charAt(head), counts.get(A.charAt(head)) + 1);;
                head++;
            }
            // Now [head - 1, tail] is a valid substring. Update the answer. 
            if (length == 0 || tail - head + 1 < length) {
                length = tail - head + 1;
                start = head;
            }
        }
    }
    return A.substring(start, start + length);
}
    public String minLength(String A, String B) { // hashmap still not working out
    	int m = A.length(), n = B.length();
    	
		HashMap<Character, Integer> h1 = new HashMap<>();
		HashMap<Character, Integer> h2 = new HashMap<>();

		for(int i=0; i<B.length(); i++) {
			if(!h2.containsKey(B.charAt(i))) {
				h2.put(B.charAt(i), 1);
			} else {
				h2.put(B.charAt(i), h2.get(B.charAt(i))+1);
			}
			
		}
		int ans=Integer.MAX_VALUE;
		int minL = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
		
		int l=0, r=0;
		while(l<m) {
			if(checkMap(h1, h2)) {
				if(ans>(r-l+1)) {
					ans = r-l+1;
					minL = l; minR = r;
				}
				h1.put(A.charAt(l), h1.get(A.charAt(l))-1);
				l++;
			}
			else {
				if(r==m) break;
				h1.put(A.charAt(r), h1.get(A.charAt(r))+1);
				r++;
			}
		}
		//if(checkMap(h1, h2)) return n;
		return minL == Integer.MAX_VALUE ? "" : A.substring(minL,minR);
	}
	public boolean checkMap(HashMap<Character, Integer> h1, HashMap<Character, Integer> h2) {
		// TODO Auto-generated method stub
		for(char c = '0'; c<='z'; c++) {
			/*
			 * if(h1.containsKey(c) && h2.containsKey(c)) { if(h2.get(c) > h1.get(c)) return
			 * false; } else if(h1.containsKey(c) && !h2.containsKey(c)) return false;
			 */
			if(h2.get(c) > h1.get(c)) return false;
			///if(h2.containsKey(c) && h1.containsKey(c)) 
		}
		return true;
	}
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowString ws = new WindowString();
		String A = "ADOBECODEBANC";
		String B = "ABC";
		System.out.println(ws.minWindow(A, B)); // BANC
		System.out.println(ws.minLength(A, B));
		String C = "Aa91b";
		String D = "ab";
		System.out.println(ws.minWindow(C, D)); // a91b
		System.out.println(ws.minLength(C, D));
	}

}
