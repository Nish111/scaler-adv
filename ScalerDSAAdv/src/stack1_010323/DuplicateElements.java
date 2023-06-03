package stack1_010323;

import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50150/assignment/problems/968?navref=cl_tt_nv
public class DuplicateElements { // Double Character Trouble

	public String removeConsecutiveDuplicate(String s) {
		Stack<Character> s1 = new Stack<>();
		s1.push(s.charAt(0));
		for(int i=1; i<s.length(); i++) {
			if(!s1.empty() && s.charAt(i)==s1.peek()) {
				//System.out.println(s.charAt(i));
				//System.out.println(s1.peek());
				//System.out.println(s1.pop());
				s1.pop();
			}
			else s1.push(s.charAt(i));
		}
		// return s1.toString(); // will give in format [a, k]
		StringBuilder sb = new StringBuilder("");
		if(s1.empty()) return "";
		else {
			String temp = s1.toString();
			for(int i=0; i<s1.size(); i++) {
				sb = sb.append(s1.elementAt(i));
			}
			return sb.toString();
		}
	}
	public String solveScalerSol(String A) {
        // we maintain a stack for the characters of the string
        Stack < Character > st = new Stack < Character > ();
        for (int i = 0; i < A.length(); i++) {
            // if the current character is equal to the top of the stack then they form 
            // a pair of consecutive similar characters therefore we pop from the stack,
            // else we push the charcter in the stack
            if (!st.empty() && st.peek() == A.charAt(i)) {
                st.pop();
            } else st.push(A.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateElements de = new DuplicateElements();
		System.out.println(de.removeConsecutiveDuplicate("acbbck")); // ak
		System.out.println(de.removeConsecutiveDuplicate("aaak")); // ak
		System.out.println(de.removeConsecutiveDuplicate("abckkcbadmmc")); // dc
		System.out.println(de.removeConsecutiveDuplicate("abccbc")); // ac
		System.out.println(de.removeConsecutiveDuplicate("bccb"));

	}

}
