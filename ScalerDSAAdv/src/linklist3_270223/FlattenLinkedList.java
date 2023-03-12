package linklist3_270223;

public class FlattenLinkedList {

	public ListNodeForFlat flatten(ListNodeForFlat root) { // pending
		ListNodeForFlat temp = root;
		ListNodeForFlat p1 = root.down;
		ListNodeForFlat p2 = root.right;
	    while(temp.right != null) {
	    	if(p1.val < p2.val) {
	    		
	    	} else {
	    		temp.right=p2;
	    		p2.right = p2;
	    		p2.right=p1;
	    	}
	    }
	    return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlattenLinkedList fll = new FlattenLinkedList();
		ListNodeForFlat a = new ListNodeForFlat(3);
		ListNodeForFlat b = new ListNodeForFlat(4);
		ListNodeForFlat d = new ListNodeForFlat(20);
		ListNodeForFlat e = new ListNodeForFlat(20);
		ListNodeForFlat f = new ListNodeForFlat(30);
		ListNodeForFlat g = new ListNodeForFlat(7);
		ListNodeForFlat h = new ListNodeForFlat(7);
		ListNodeForFlat i = new ListNodeForFlat(8);
		ListNodeForFlat j = new ListNodeForFlat(11);
		ListNodeForFlat k = new ListNodeForFlat(22);
		ListNodeForFlat l = new ListNodeForFlat(20);
		ListNodeForFlat m = new ListNodeForFlat(28);
		ListNodeForFlat n = new ListNodeForFlat(39);
		ListNodeForFlat o = new ListNodeForFlat(31);
		ListNodeForFlat p = new ListNodeForFlat(39);
		a.right=b; b.right=d; d.right=e; e.right=f;
		a.down=g; g.down=h; h.down=i;
		b.down=j;  d.down=k;  e.down=l; l.down=m; m.down=n;
		f.down=o; o.down=p;
		fll.printLinkedList(a);
		ListNodeForFlat q = fll.flatten(a);
		fll.printLinkedList(q);
	}
	public void printLinkedList(ListNodeForFlat head) { // if cycle then no null is next so not 
		ListNodeForFlat temp = head;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.right;
		} System.out.println();
	}
}
class ListNodeForFlat {
    int val;
    ListNodeForFlat right, down;
    ListNodeForFlat(int x) {
        val = x;
        right = down = null;
    }
}