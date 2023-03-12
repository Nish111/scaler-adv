package stack1_010323;

import java.util.HashMap;
import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50150/assignment/problems/678/hints?navref=cl_pb_nv_tb
public class SequenceBrackets {

	public int sequenceBrackets(String str) { // not working
		HashMap<String, String> hmOpen = new HashMap<>();
		hmOpen.put("{", "}");
		hmOpen.put("[", "]");
		hmOpen.put("(", ")");
		HashMap<String, String> hmClose = new HashMap<>();
		hmClose.put("}", "{");
		hmClose.put("]", "[");
		hmClose.put(")", "(");
		Stack<Character> s1 = new Stack<>();
		if(hmOpen.containsKey(str.charAt(0))) {
			System.out.println(str.charAt(0));
			s1.push(str.charAt(0));
		} else return 0;
		// check again incomplete
		for(int i=1; i<str.length(); i++) {
			//if(s1.empty()) s1.push(str.charAt(i));
			System.out.println(str.charAt(i));
			if(hmOpen.containsKey(str.charAt(i))) s1.push(str.charAt(i));
			if(hmClose.containsKey(str.charAt(i))) {
				System.out.println("In close");
				char temp = s1.pop();
				String temp1 = hmOpen.get(temp);
				if(str.charAt(i)!=temp1.charAt(0)) return 0;
			}
			
		}
		if(!s1.empty()) return 0;
		else return 1;
	}
	public int sequenceBrackets1(String str) {
		Stack<Character> st = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			char temp = str.charAt(i);
			if((temp == '(') ||(temp == '{')|| (temp == '[')) {
				st.push(temp);
			} else {
				if(temp==')') {
					if(st.empty() || st.peek()!='(') return 0;
					else st.pop();
				} else if(temp==']') {
					if(st.empty() || st.peek()!='[') return 0;
					else st.pop();
				} else if(temp=='}') {
					if(st.empty() || st.peek()!='{') return 0;
					else st.pop();
				}
			}
		}
		if(st.empty()) return 1;
		else return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceBrackets sb = new SequenceBrackets();
		System.out.println(sb.sequenceBrackets("{[]}")); // 1
		System.out.println(sb.sequenceBrackets("{[])")); // 0
		System.out.println(sb.sequenceBrackets("{(}]")); // 0
		System.out.println(sb.sequenceBrackets("[](){}")); // 1
		System.out.println(sb.sequenceBrackets("](){}")); // 0
		System.out.println(sb.sequenceBrackets1("{[]}")); // 1
		System.out.println(sb.sequenceBrackets1("{[])")); // 0
		System.out.println(sb.sequenceBrackets1("{(}]")); // 0
		System.out.println(sb.sequenceBrackets1("[](){}")); // 1
		System.out.println(sb.sequenceBrackets1("](){}")); // 0
		System.out.println(sb.sequenceBrackets1("(){")); // 0
		
	}

}
