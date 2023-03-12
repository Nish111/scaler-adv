package stack1_010323;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50150/homework/problems/4353/?navref=cl_pb_nv_tb
public class InfixToPostfix {

	public String solve(String A) { // nor working 
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
	      HashMap<Character,Integer> priorityChar = new HashMap<>();
	      priorityChar.put('(', 0);
	      priorityChar.put('+', 1 );
	      priorityChar.put('-', 1);
	      priorityChar.put('*', 2);
	      priorityChar.put('/', 2);
	      priorityChar.put('^', 3);
		for(int i=0; i<A.length(); i++) {
			char curr = A.charAt(i);
			if(Character.isAlphabetic(curr)) {
				sb.append(curr);
			}
			else if(curr == '(') {
				st.push(curr);
			} else if(curr==')') {
				while(st.peek()!='(') {
					sb.append(st.pop());
				}
				st.pop();
			}
			else {
				if(st.isEmpty() || st.peek()=='(') {
					st.push(curr);
				} else {
					int stPR = priorityChar.get(st.peek());
					int curPR = priorityChar.get(curr);
					while(stPR >= curPR) {
						sb.append(st.pop());
						if(st.isEmpty())
							stPR = 0;
						else
							stPR = priorityChar.get(st.peek());
					}
					st.push(curr);
					
					
					/*if(curr=='^' || curr=='+' || curr=='-' || curr=='*' || curr=='/') {
						
					}
						else if(st.peek()=='^') {
							sb.append(st.pop());
							st.push(A.charAt(i));
						}
						else if((st.peek()=='+' || st.peek()=='-') && (A.charAt(i) == '*' || A.charAt(i)=='/')) {
							st.push(A.charAt(i));
						} else if((st.peek()=='*' || st.peek()=='/') && (A.charAt(i) == '+' || A.charAt(i)=='-')){
							sb.append(st.pop());
							st.push(A.charAt(i));
						}*/
				}
			} 
		}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		printStack(st);
		return sb.toString();
	}
	public String solveScalerSol(String A) {
        return infixToPostfixScalerSol(A);
    }
    public int precScalerSol(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
    // Function to convert infix expression
    //to postfix expression
    public String infixToPostfixScalerSol(String s) {
        Stack < Character > st = new Stack < Character > ();
        st.push('N');
        ArrayList < Character > ns = new ArrayList < Character > ();
        for (int i = 0; i < s.length(); i++) {
            char C = s.charAt(i);
            // If the scanned character is an operand, add it to output string.
            if ((C >= 'a' && C <= 'z') || (C >= 'A' && C <= 'Z'))
                ns.add(C);
            // If the scanned character is an '(', push it to the stack.
            else if (C == '(')
                st.push('(');
            // If the scanned character is an ')', pop and to output string from the stack
            // until an '(' is encountered.
            else if (C == ')') {
                while (st.peek() != 'N' && st.peek() != '(') {
                    char c = st.peek();
                    st.pop();
                    ns.add(c);
                }
                if (st.peek() == '(') {
                    char c = st.peek();
                    st.pop();
                }
            }
            //If an operator is scanned
            else {
                while (st.peek() != 'N' && precScalerSol(C) <= precScalerSol(st.peek())) {
                    char c = st.peek();
                    st.pop();
                    ns.add(c);
                }
                st.push(C);
            }
        }
        //Pop all the remaining elements from the stack
        while (st.peek() != 'N') {
            char c = st.peek();
            st.pop();
            ns.add(c);
        }
        StringBuilder result = new StringBuilder(ns.size());
        for (Character c: ns) {
            result.append(c);
        }
        return result.toString();
    }
	public String solve1(String A) { // nor working 
		Stack<Character> st = new Stack<>();
		boolean flag = true;
		char temp = A.charAt(0);
		for(int i=0; i<A.length(); i++) {
			char curr = A.charAt(i);
			if(curr == '(') {
				temp = A.charAt(i-1);
				//flag = true;
			} else if(curr==')') {
				st.push(temp);
			}
			else if(curr=='^' || curr=='+' || curr=='-' || curr=='*' || curr=='/') {
				flag = false;
				temp = A.charAt(i);
			} else {
				st.push(curr);
				if(flag == false) st.push(temp);
				flag = true;
			}
		}
		printStack(st);
		return null;
    }
	public void printStack(Stack<Character> st) {
		// TODO Auto-generated method stub
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfixToPostfix itp = new InfixToPostfix();
		String A = "x^y/(a*z)+b";
		System.out.println(itp.solve(A)); //  "xy^az*/b+"
		String B = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(itp.solve(B)); // "abcd^e-fgh*+^*+i-"


	}

}
