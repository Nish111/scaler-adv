package stack1_010323;

import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50150/homework/problems/52/?navref=cl_pb_nv_tb
public class MinStack {

	Stack<Integer> st = new Stack<>();
	Stack<Integer> stForMin = new Stack<>();
	int min = Integer.MAX_VALUE;
	public void push(int x) {
		st.push(x);
		if(stForMin.isEmpty()) {
			stForMin.push(x);
		}
		else {
			min = Math.min(stForMin.peek(), x);
			stForMin.push(min); // just storing the min element after inserting x
		}
    }
    public void pop() {
        if(st.isEmpty()) return;
        else {
        	st.pop();
        	stForMin.pop();
        }
    }
    public int top() {
    	if(st.isEmpty()) return -1;
    	else return st.peek();
    }

    public int getMin() {
    	if(stForMin.isEmpty()) return -1;
    	else return stForMin.peek();
    }
    private Stack < Integer > stack;
    private Stack < Integer > minStack;

    public MinStack() {
      stack = new Stack < > ();
      minStack = new Stack < > ();
    }

    public void pushScalerSol(int x) {
      stack.push(x);
      if (minStack.isEmpty())
        minStack.push(x);
      else if (x <= minStack.peek()) {
        minStack.push(x);
      }
    }

    public void popScalerSol() {
      if (stack.isEmpty())
        return;
      int num = stack.pop();
      if (num == minStack.peek())
        minStack.pop();
    }

    public int topScalerSol() {
      if (stack.isEmpty())
        return -1;

      return stack.peek();
    }

    public int getMinScalerSol() {
      if (minStack.isEmpty())
        return -1;

      return minStack.peek();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		ms.push(1);
		ms.push(2);
		ms.push(-2);
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		System.out.println(ms.top());
	}

}
