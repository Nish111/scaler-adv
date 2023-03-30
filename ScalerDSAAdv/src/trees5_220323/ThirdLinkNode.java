package trees5_220323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.scaler.com/academy/mentee-dashboard/class/70935/assignment/problems/235/hints?navref=cl_pb_nv_tb
public class ThirdLinkNode {

	public void pointThirdLink(TreeNode2 root) { // Video
		// simple level order traversal
		if(root == null) return;
		TreeNode2 p = root;
		while(p != null) {
			TreeNode2 q = p;
			while(q != null) {
				if(q.left != null) {
					if(q.right != null) q.left.third = q.right.third;
					else q.left.third = getNextRight(q);
				}
				if(q.right != null) q.right.third = getNextRight(q);
				q=q.third;
				if(p.left != null) p = p.left;
				else if(p.right != null) p = p.right;
				else p = getNextRight(p);
			}
		}
		
	}
	 public TreeNode2 getNextRight(TreeNode2 q) {
		TreeNode2 x = q.third;
		while(x != null) {
			if(x.left != null) x=x.left;
			if(x.right != null) x=x.right;
			x = x.third;
		}
		return x;
	}
	public void solve(TreeNode2 root) { // O(N) // Assignment -- not modified yet
		 // will implement using ArrayList then try for array
		Queue<TreeNode2> qu = new LinkedList<TreeNode2>();
		if(root == null) return;
		qu.add(root);
		
		while(!qu.isEmpty()) {
			int len = qu.size();
			for(int i=0; i<len; i++) {
				
				/* My logic - not working
				 * TreeNode2 curr = qu.poll();
				 * if(!qu.isEmpty()) { // if qu not empty meaning till last element, // getting
				 * the element and making it third TreeNode2 nextOne = qu.element(); curr.third
				 * = nextOne; }
				 */
				TreeNode2 curr = qu.peek();
				qu.remove();
				if(i==len-1) curr.third=null;
				else curr.third = qu.peek();
				if(curr.left != null) qu.add(curr.left);
				if(curr.right != null) qu.add(curr.right);
			}
		}
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdLinkNode tln = new ThirdLinkNode();
		TreeNode2 four = new TreeNode2(4);
		TreeNode2 five = new TreeNode2(5);
		TreeNode2 two = new TreeNode2(2);
		TreeNode2 three = new TreeNode2(3);
		TreeNode2 six = new TreeNode2(6);
		three.left = two;
		three.right = five;
		five.left = four;
		five.right = six;
		tln.solve(three);
		//System.out.print(x.third + " ");
		//System.out.print(x.left.third.data +" ");
		//System.out.print(x.right.third +" ");
		//System.out.print(x.right.left.third.data +" ");
		//System.out.print(x.right.right.third +" ");
	}
}
class TreeNode2 {
	int data;
	TreeNode2 left;
	TreeNode2 right;
	TreeNode2 third;
	
	TreeNode2(int data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.third = null;
	}
}