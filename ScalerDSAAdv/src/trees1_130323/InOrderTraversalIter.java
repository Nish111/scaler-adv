package trees1_130323;
import java.util.Stack;

public class  InOrderTraversalIter{

	public void inorderTraversalIterative(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		TreeNode curr = root;
		while(curr != null || !st.isEmpty()) {
			// for conditions of recursive
			if(curr != null) {
				st.push(curr);
				curr = curr.left;
			} else {
				// actual steps LST Root RST
				//if(st.isEmpty()) break;
				curr = st.pop();
				System.out.print(curr.data +" ");
				curr = curr.right;
			}
		}
		System.out.println();
	}
	public void inorderTraversalIterative2(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		TreeNode curr = root;
		while(root != null || st.isEmpty()) {
			// for conditions of recursive
			if(curr != null) {
				st.push(curr);
				curr = curr.left;
			} else {
				// actual steps LST Root RST
				if(st.isEmpty()) break;
				curr = st.pop();
				System.out.print(curr.data +" ");
				curr = curr.right;
			}
		}
		System.out.println();
	}
	public void preorderTraversalIterative(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		TreeNode curr = root;
		while(curr != null || !st.isEmpty()) {
			// for conditions of recursive
			if(curr != null) {
				System.out.print(curr.data +" ");
				st.push(curr);
				curr = curr.left;
			} else {
				// actual steps LST Root RST
				//if(st.isEmpty()) break;
				curr = st.pop();
				
				curr = curr.right;
			}
		}
		System.out.println();
	}
	public void postorderTraversalIterative(TreeNode root) { // try to print reverse
		Stack<TreeNode> st = new Stack<>();
		TreeNode curr = root;
		while(curr != null || !st.isEmpty()) {
			// for conditions of recursive
			while(curr != null) {
				st.push(curr);
				System.out.print(curr.data +" ");
				curr = curr.right;
			}
				// actual steps LST Root RST
				//if(st.isEmpty()) break;
				curr = st.pop();
				curr = curr.left;
		}
		System.out.println();
		// reverse of the printed is postorder
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InOrderTraversalIter iot = new InOrderTraversalIter();
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		four.left = five;
		four.right = two;
		two.left = three;
		two.right = six;
		iot.inorderTraversalIterative(four); // 5 4 3 2 6 
		iot.inorderTraversalIterative2(four); // 5 4 3 2 6
		iot.preorderTraversalIterative(four);  // 4 5 2 3 6 
		iot.postorderTraversalIterative(four); // 4 2 6 3 5 -- wrong
		// 5 3 6 2 4
	}

}
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
/*
 	4
   / \
  5  2
    / \
   3   6 -> should give 5 4 3 2 6
	 * 
	 */