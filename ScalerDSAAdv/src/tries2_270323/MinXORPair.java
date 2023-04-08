package tries2_270323;

public class MinXORPair {

	public int findMinXORPair(int[] A) { // brute O(N2 )
		int res=Integer.MAX_VALUE, ans=0;
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length; j++) {
				ans = A[i]^A[j];
				res = Math.min(ans, res);
			}
		}
		return res;
	}
	// approach 2 - insert all and search 1 by 1 -- this will not work for Min
	public int findMinXORTrie(int[] A) {
		TrieNodeNum root = new TrieNodeNum();
		int res=Integer.MAX_VALUE, ans=0;
		for(int i=0; i<A.length; i++)
			insert(root, A[i]);
		for(int i=0; i<A.length; i++) {
			ans = A[i]^search(root, A[i]);
			//System.out.println(ans);
			res = Math.min(ans, res);
		}
		return res;
	}
	// approach 3 - first search and then insert
		public int findMinXORTrie2(int[] A) {
			TrieNodeNum root = new TrieNodeNum();
			int res=Integer.MAX_VALUE, ans=0;
			insert(root, A[0]);
			for(int i=1; i<A.length; i++) {
				insert(root, A[i]);
				ans = A[i]^search(root, A[i]);
				//System.out.println(ans);
				res = Math.min(ans, res);
			}
			return res;
		}
	public void insert(TrieNodeNum root, int x) {
		TrieNodeNum curr = root;
		for(int i=30; i>=0; i--) {
			int bit = checkBit(x, i);
			if(curr.child[bit]==null) {
				curr.child[bit]=new TrieNodeNum();
			}
			curr = curr.child[bit];
		}
		curr.val = x;
		//System.out.println(curr.val);
	}
	public int search(TrieNodeNum root, int x) {
		TrieNodeNum curr = root;
		for(int i=30; i>=0; i--) {
			int bit=1, bitRev=0;
			if(checkBit(x, i)==1){// if 1 then check 0 else 1
				bit=0; bitRev=1;
			}
			if(curr.child[bit]==null) {
				curr = curr.child[bitRev]; 
			} else {
				curr = curr.child[bit];
			}
		}
		//System.out.println(curr.val);
		//curr.val = x;
		return curr.val;
	}
	public int checkBit(int n, int i) {
		if(((n>>i)&1) == 1) return 1;
		else return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinXORPair mxp = new MinXORPair();
		int[] A = {9,8,10,7};
		System.out.println(mxp.findMinXORPair(A)); // 1
		System.out.println(mxp.findMinXORTrie(A)); // 13 -- this approach does not work
		System.out.println(mxp.findMinXORTrie2(A)); // 1
	}

}
