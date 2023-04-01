package tries2_270323;
// https://www.scaler.com/academy/mentee-dashboard/class/70937/assignment/problems/4121?navref=cl_tt_lst_sl
public class MaxXORPair {

	public int findMaxXORPair(int[] A) { // brute O(N2 )
		int res=Integer.MIN_VALUE, ans=0;
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length; j++) {
				ans = A[i]^A[j];
				res = Math.max(ans, res);
			}
		}
		return res;
	}
	// approach 2 - insert all and search 1 by 1
	public int findMaxXORTrie(int[] A) {
		TrieNodeNum root = new TrieNodeNum();
		int res=Integer.MIN_VALUE, ans=0;
		for(int i=0; i<A.length; i++)
			insert(root, A[i]);
		for(int i=0; i<A.length; i++) {
			ans = A[i]^search(root, A[i]);
			//System.out.println(ans);
			res = Math.max(ans, res);
		}
		return res;
	}
	// approach 3 - insert element and then search
		public int findMaxXORTrie2(int[] A) {
			TrieNodeNum root = new TrieNodeNum();
			int res=Integer.MIN_VALUE, ans=0;
			for(int i=0; i<A.length; i++) {
				insert(root, A[i]);
				ans = A[i]^search(root, A[i]);
				//System.out.println(ans);
				res = Math.max(ans, res);
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
	
	static private class TrieNodeScalerSol {
        TrieNodeScalerSol left = null; // left points to 0 
        TrieNodeScalerSol right = null; // right points to 1
    }
    public int solveScalerSol(int[] A) {
        return findMaximumXORScalerSol(A);
    }
    public static int findMaximumXORScalerSol(int[] nums) {
        TrieNodeScalerSol root = new TrieNodeScalerSol();
        // Constructing the Trie
        for (int num: nums) {
            TrieNodeScalerSol curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (bit == 0) {
                    if (curr.left == null) {
                        curr.left = new TrieNodeScalerSol();
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new TrieNodeScalerSol();
                    }
                    curr = curr.right;
                }
            }
        }
        int max = Integer.MIN_VALUE;

        // Query on Trie
        for (int num: nums) {
            TrieNodeScalerSol curr = root;
            int currSum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (bit == 0) {
                    if (curr.right != null) {
                        currSum += (1 << i);
                        curr = curr.right;
                    } else {
                        curr = curr.left;
                    }
                } else {
                    if (curr.left != null) {
                        currSum += (1 << i);
                        curr = curr.left;
                    } else {
                        curr = curr.right;
                    }
                }
            }
            max = Math.max(currSum, max);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxXORPair mxp = new MaxXORPair();
		int[] A = {9,8,10,7};
		System.out.println(mxp.findMaxXORPair(A)); // 15
		System.out.println(mxp.findMaxXORTrie(A)); // 15
		System.out.println(mxp.findMaxXORTrie2(A)); // 15
	}

}
class TrieNodeNum {
	int val;
	TrieNodeNum child[] = new TrieNodeNum[26];
	TrieNodeNum(){
		for(int i=0; i<26; i++)
			child[i]=null;
	}
	
}