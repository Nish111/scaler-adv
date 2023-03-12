package stack1_010323;

import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50150/homework/problems/274/?navref=cl_pb_nv_tb
public class RedundantBraces {

	public int redundantBraces(String A) { // O(N) O(N)
		Stack<Character> st = new Stack<>();
		for(int i=0; i<A.length(); i++) {
			char curr = A.charAt(i);
			if(curr =='(' || curr=='+' || curr =='-'
					|| curr == '/' || curr == '*') {
				st.push(A.charAt(i));
			}
			else if(curr == ')') {
				if(st.peek()=='(') return 1;
				else {
					while(st.peek() != '(') st.pop();
				}
				st.pop();
			}
		}
		return 0;
	}
	 boolean isOperatorScalerSol(char c) {
	        return c == '+' || c == '-' || c == '*' || c == '/';
	    }
	    
	    public int bracesScalerSol(String A) {
	        char s[] = A.toCharArray();
	        int n = s.length;
	        Stack <Character> st = new Stack<>();
	        for(char c : s) {
	            if(c == '(') {
	                st.push(c);
	            } else if(c == ')') {
	                // finds the no of characters between adjacent '(' and ')' pair
	                char top = st.peek();
	                if( !isOperatorScalerSol(top) )    return 1;
	                while ( isOperatorScalerSol(st.peek()) )   st.pop();
	                if(st.peek() != '(')    return 1;
	                st.pop();
	            } else if(isOperatorScalerSol(c)) {
	                st.push(c);
	            }
	        }
	        while ( !st.isEmpty() && isOperatorScalerSol(st.peek()) )   
	            st.pop();
	        return st.isEmpty() ? 0 : 1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedundantBraces rb = new RedundantBraces();
		String A = "((a+B))";
		String B = "a+b+(c+d)";
		System.out.println(rb.redundantBraces(A)); // 1 - redundant braces
		System.out.println(rb.redundantBraces(B)); // 0 - no redundant braces
		String C = "(a+(a+b))";
		System.out.println(rb.redundantBraces(C)); // 0
	}

}
