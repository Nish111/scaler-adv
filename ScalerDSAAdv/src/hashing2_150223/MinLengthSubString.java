package hashing2_150223;

import java.util.HashMap;

public class MinLengthSubString {

	public int minLengthBrute(String A, String B) {
		// traverse through all substrings of B
		// compare with A
		// make hm of all B subsstrings and compare from a to z how many and which in 
		// A and B substrings
		
		return 0;
	}
	public int minLength(String A, String B) {
		HashMap<Character, Integer> h1 = new HashMap<>();
		HashMap<Character, Integer> h2 = new HashMap<>();
		for(int i=0; i<A.length(); i++) {
			if(!h1.containsKey(A.charAt(i))) {
				h1.put(A.charAt(i), 1);
			} else {
				h1.put(A.charAt(i), h1.get(A.charAt(i))+1);
			}
		}
		for(int i=0; i<B.length(); i++) {
			if(!h2.containsKey(B.charAt(i))) {
				h2.put(B.charAt(i), 1);
			} else {
				h2.put(B.charAt(i), h2.get(B.charAt(i))+1);
			}
			
		}
		int n = A.length(), m = B.length(), ans=Integer.MAX_VALUE;
		int minL = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
		
		int l=0, r=n-1;
		while(l<m) {
			if(checkMap(h1, h2)) {
				ans=Math.min(ans, r-l+1);
				h2.put(B.charAt(l), h2.get(B.charAt(l))-1);
				l++;
			}
			else {
				r++;
				if(r==m) break;
				h2.put(B.charAt(r), h2.get(B.charAt(r))+1);
			}
		}
		if(checkMap(h1, h2)) return n;
		return ans;
	}
	public boolean checkMap(HashMap<Character, Integer> h1, HashMap<Character, Integer> h2) {
		// TODO Auto-generated method stub
		for(char c = 'a'; c<='z'; c++) {
			if(h1.containsKey(c) && h2.containsKey(c)) {
				if(h1.get(c) > h2.get(c)) return false;
			}
			else if(h1.containsKey(c) && !h2.containsKey(c)) return false;
		}
		return true;
	}
	 public String minWindow(String A, String B) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinLengthSubString mlss = new MinLengthSubString();
		String A = "xyz"; String B = "xatyxvzmxpty";
		System.out.println(mlss.minLength(A, B)); // 3 -- 4
		String a = "ADOBECODEBANC";
		String b = "ABC";
		System.out.println(mlss.minLength(b, a));// 3 -- 4
		String x = "Aa91b";
		String y = "ab";
		System.out.println(mlss.minLength(y, x));// 1 -- 4
	}

}
