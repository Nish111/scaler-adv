package stack1_010323;

import java.util.Arrays;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50150/homework/problems/4218/?navref=cl_pb_nv_tb
public class BracketExpression {

	public int solveBrute(String A, String B) {
		
		return 0;
	}
	public int solve(String A, String B) {
		char[] strA = findSigns(A);
		char[] strB = findSigns(B);
		for(int i=0; i<strA.length; i++) {
			if(strA[i] != strB[i]) return 0;
		}
		return 1;
	}
	
	public char[] findSigns(String str) {
		Stack<Character> gOperators = new Stack<>();
		char[] temp = new char[26];
		Arrays.fill(temp, '+');
		char lOperator = '+';
		for(int i=0; i<str.length(); i++) {
			char curr = str.charAt(i);
			if(curr == '-' || curr == '+') {
				if(gOperators.isEmpty()) lOperator=curr;
				else {
					char gSign = gOperators.peek();
					if((gSign == '-' && curr == '+') || (gSign == '+' && curr == '-'))
						lOperator = '-';
					else lOperator = '+';
				}
				continue;
			}
			if(curr =='(') {
				gOperators.push(lOperator);continue;
			}
			if(curr == ')') {
				gOperators.pop();
				continue;
			}
			temp[curr-'a'] = lOperator;
		}
		return temp;
	}
	 int MAX_CHAR = 26;

	    public int solveScalerSol(String A, String B) {
	        if (areSameScalerSol(A, B))
	            return 1;
	        return 0;
	    }

	    Boolean areSameScalerSol(String expr1, String expr2) {
	        int v[] = new int[MAX_CHAR];
	        evalScalerSol(expr1, v, true);
	        // calls the second expression with opposite sign
	        evalScalerSol(expr2, v, false);
	        // checks if both the expressions are equal
	        for (int i = 0; i < MAX_CHAR; i++)
	            if (v[i] != 0)
	                return false;
	        return true;
	    }

	    void evalScalerSol(String s, int v[], Boolean add) {
	        Stack < Boolean > stk = new Stack < Boolean > ();
	        stk.push(true);
	        int i = 0;
	        // we evaluate the contribution of each character in the expression
	        while (i < s.length()) {
	            char c = s.charAt(i);
	            if (c == '+' || c == '-') {
	                i++;
	                continue;
	            }
	            if (c == '(') {
	                if (adjSignScalerSol(s, i))
	                    stk.push(stk.peek());
	                else
	                    stk.push(!stk.peek());
	            } else if (c == ')')
	                stk.pop();
	            else {
	                if (stk.peek())
	                    v[c - 'a'] += (adjSignScalerSol(s, i) ? add ? 1 : -1 :
	                        add ? -1 : 1);
	                else
	                    v[c - 'a'] += (adjSignScalerSol(s, i) ? add ? -1 : 1 :
	                        add ? 1 : -1);
	            }
	            i++;
	        }
	    }
	    
	    Boolean adjSignScalerSol(String s, int i) {
	        if (i == 0)
	            return true;
	        if (s.charAt(i - 1) == '-')
	            return false;
	        return true;
	    };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BracketExpression be = new BracketExpression();
		String A = "-(a+b+c)";
		String B = "-a-b-c";
		System.out.println(be.solve(A, B));
		String C = "a-b-(c-d)";
		String D = "a-b-c-d";
		System.out.println(be.solve(C, D));
		String E = "(a+b-(c+d-(-e)-f))";
		String F = "a+b-c-d-e+f";
		System.out.println(be.solve(E, F));
	}
/*
 * The sign before every number is considered as localOperator the sign outside the brackets is considered as globalOperator. 
Store the signs of each character array of size 26.
For each string, traverse over each character, and determine its sign by first looking at localOperator and then change it based on globalOperator. if (-, -) then change it to +, if (-, +) or (+ -) then change it to - and + by default.
Finally compare both the arrays, there should be same sign at their respctive places
 */
}
