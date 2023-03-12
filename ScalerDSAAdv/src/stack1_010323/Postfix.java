package stack1_010323;

import java.util.HashSet;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50150/assignment/problems/46?navref=cl_tt_nv
public class Postfix {

	// ASCII 2 Decimal 50 -- so subtracted 48 
	public String postfixExpression(String str) {
		HashSet<Character> hs = new HashSet<>();
		hs.add('-'); hs.add('+'); hs.add('*'); hs.add('/');
		Stack<Integer> s1 = new Stack<>();
		s1.push((int) str.charAt(0)-48);
		//System.out.println(s1.peek()-48);
		//System.out.println(str.charAt(0)-48);
		for(int i=1; i<str.length(); i++) {
			//System.out.println(str.charAt(i));
			char s = str.charAt(i);
			//System.out.println(s);
			if(hs.contains(s)) {
				//System.out.println(s1.peek());
				int x = (int)s1.pop();
				//System.out.println(x + " x ");
				int y = (int)s1.pop();
				//System.out.println(y + " y ");
				if(s=='-') s1.push(y-x);
				if(s=='+') s1.push(y+x);
				if(s=='*') s1.push(y*x);
				if(s=='/') s1.push(y/x);
				
				//System.out.println(s1.toString());
			}
			else s1.push((int)str.charAt(i)-48);
		}
		return s1.toString();
	}
	public int evalRPN(String[] A) { // O(N) O(N - no of operands)
		// still not working for scaler   
		if(A.length == 1){
			return Integer.parseInt(A[0]);
		}
		HashSet<String> hs = new HashSet<>();
		hs.add("-"); hs.add("+"); hs.add("*"); hs.add("/");
		Stack<Integer> s1 = new Stack<>();
		//s1.push(Integer.parseInt(A[0]));
		//System.out.println(s1.peek()-48);
		//System.out.println(str.charAt(0)-48);
		int temp=0;
		for(int i=0; i<A.length; i++) {
			//System.out.println(str.charAt(i));
			String s = A[i];
			//System.out.println(s);
			if(hs.contains(s)) {
				//System.out.println(s1.peek());
				int x = (int)s1.pop();
				//System.out.println(x + " x ");
				int y = (int)s1.pop();
				//System.out.println(y + " y ");
				
				if(s=="-") {
					temp = y-x;
				}
				else if(s=="+") {
					temp = y+x;
				}
				else if(s=="*") {
					temp = y*x;
				}
				else if(s=="/") {
					temp = y/x;
				}
				s1.push(temp);
				//System.out.println(s1.toString());
			}
			else s1.push(Integer.parseInt(A[i]));
		}
		System.out.println(temp);
		return temp;
		/*StringBuilder sb = new StringBuilder("");
		//sb = sb.append(s1.elementAt(0));
		String temp = s1.toString();
		for(int i=0; i<s1.size(); i++) {
			sb = sb.append(s1.elementAt(i));
		}
		return Integer.parseInt(sb.toString());*/
	}
	public int again(String[] A) { // worked for scaler
		if(A.length == 1){
			return Integer.parseInt(A[0]);
		}

		int result = 0;

		Stack <Integer> st = new Stack<>(); // intialising Stack

		for(int i = 0; i < A.length; i++){
		if ( A[i].equals("+") || A[i].equals("-")|| A[i].equals("*") ||A[i].equals("/") ){

		String operator = A[i];
		int b = st.pop();
		int a = st.pop();

		if(operator.equals("+")) result = a + b;
		else if(operator.equals("-")) result = a - b;
		else if(operator.equals("*")) result = a * b;
		else if(operator.equals("/")) result = a / b;

		st.push(result); // getting the result and store it in the stack
		}
		// if no operators found we just store it in the stack
		else{
		int curr_Value = Integer.parseInt(A[i]);
		st.push(curr_Value);
		}

		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Postfix pf = new Postfix();
		System.out.println(pf.postfixExpression("21+3*")); // 9
		String[] A = {"2", "1", "+", "3", "*"};
		String[] B = {"4", "13", "5", "/", "+"};
		//System.out.println(pf.evalRPN(A)); // 9
		//System.out.println(pf.evalRPN(B)); // 6
		String[] C = {"2", "2", "/"};
		System.out.println(pf.evalRPN(C)); // 1
		String[] D = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
		System.out.println(pf.evalRPN(D));
		System.out.println(pf.again(D));
	}

}
