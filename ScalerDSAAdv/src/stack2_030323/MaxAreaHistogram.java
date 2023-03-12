package stack2_030323;

import java.util.Stack;
// https://www.scaler.com/academy/mentee-dashboard/class/50151/assignment/problems/49?navref=cl_tt_nv
public class MaxAreaHistogram {

	public int maxAreaContainedBrute(int[] A) { // O(N3) not working
		int res = 0;
		int min = Integer.MAX_VALUE;
		int temp = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			for(int j=i; j<A.length; j++) {
				min = Integer.MAX_VALUE; // missed initializing min
				for(int k=i; k<=j; k++) {
					min = Math.min(A[k], min);
					//System.out.println(min);
				}
				temp = Math.max(temp, min*(j-i+1));
				//System.out.println(temp);
			}
		}
		return temp;
	}
	public int maxAreaContained(int[] A) {
		// consider a bar and fix it as height
		// nsl and nsr
		int n = A.length;
		int p1=0, p2=0, len=0, ans = Integer.MIN_VALUE;
		int[] nsl = new int[n];
		int[] nsr = new int[n];
		Stack<Integer> stL = new Stack<>();
		for(int i=0; i<A.length; i++) {
			while(!stL.empty() && A[stL.peek()]>=A[i]) {
				stL.pop();
			}
			if(stL.empty()) {
				nsl[i] = -1;
			}
			else {
				nsl[i]=stL.peek();
			}
			stL.push(i);
		}
		Stack<Integer> stR = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			while(!stR.empty() && A[stR.peek()]>=A[i]) {
				stR.pop();
			}
			if(stR.empty()) {
				nsr[i] = -1;
			}
			else {
				nsr[i]=stR.peek();
			}
			stR.push(i);
		}
		for(int i=0; i<A.length; i++) {
			if(nsl[i]==-1) p1 = 0;
			else p1 = nsl[i]+1;
			if(nsr[i]==-1) p2 = n-1;
			else p2 = nsr[i]-1;
			len = p2-p1+1;
			ans = Math.max(ans, len*A[i]);
		}
		return ans;
	}
	public int largestRectangleAreaScalerSol(int[] A) {
        Stack < Integer > stack = new Stack < Integer > ();
        int ans = -1, n = A.length;
        for (int i = 0; i < A.length; i++) {
            while (!stack.empty() && A[i] < A[stack.peek()]) {
                int ind = stack.peek();
                stack.pop();
                // (stack.peek()+1) is the left and (i-1) is the right boundary of the rectangle with height A[ind]
                if (!stack.empty()) 
                    ans = Math.max(ans, (i - stack.peek() - 1) * A[ind]);
                else ans = Math.max(ans, i * A[ind]);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int ind = stack.peek();
            stack.pop();
            // (stack.peek()+1) is the left and (n-1) is the right boundary of the rectangle with height A[ind]
            if (!stack.empty()) 
                ans = Math.max(ans, (n - stack.peek() - 1) * A[ind]);
            else ans = Math.max(ans, (n) * A[ind]);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxAreaHistogram mah = new MaxAreaHistogram();
		int[] A = {2, 4, 3, 4, 5, 1};
		System.out.println(mah.maxAreaContainedBrute(A)); // 12
		System.out.println(mah.maxAreaContained(A)); // 12
		int[] B = {1, 10, 1};
		System.out.println(mah.maxAreaContainedBrute(B)); // 10
		System.out.println(mah.maxAreaContained(B)); // 10
	}

}
