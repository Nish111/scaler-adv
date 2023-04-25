package tries2_270323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BTLinkedList {

	public LinkedList createLinkedListPreOrderFromBT(TreeNode root) {
		LinkedList<Integer> ar = new LinkedList<>();
		
		return ar;
		
	}
	public Pair flatten(TreeNode root) {
		if(root==null) return new Pair(null, null);
		Pair L = flatten(root.left);
		Pair R = flatten(root.right);
		if(L==null && R == null) return new Pair(root, root);
		else if(L==null) {
			root.right = R.head;
			return new Pair(root, R.head);
		} else if(R==null) {
			root.right = L.head;
			return new Pair(root, L.tail);
		} else {
			root.right = L.head;
			L.tail = R.head;
			return new Pair(root, R.tail);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode{
	int val;
	TreeNode head, tail;
	TreeNode left, right;
	TreeNode(){
		this.head=null;
		this.tail=null;
	}
}
class Pair {
	TreeNode head;
	TreeNode tail;
	TreeNode L, R, left;
	Pair(TreeNode L, TreeNode R){
		this.L = L;
		this.R = R;
	}

}