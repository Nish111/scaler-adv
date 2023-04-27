package linklist3_270223;
// https://www.scaler.com/academy/mentee-dashboard/class/50149/homework/problems/4390/?navref=cl_pb_nv_tb
public class FlattenLinkedList {

	public ListNodeForFlat flatten(ListNodeForFlat root) { // need to check once again
		if(root.right == null) return root;
		return flat(root, flatten(root.right));
	}
	public ListNodeForFlat flat(ListNodeForFlat root, ListNodeForFlat right) {
		ListNodeForFlat temp = new ListNodeForFlat(-1);
		ListNodeForFlat temp1 = temp;
		
		while(root != null && right != null) {
			if(root.val < right.val) {
				temp1.down = root;
				temp1 = temp1.down;
				root = root.down;
			} else {
				temp1.down = right;
				temp1 = temp1.down;
				right = right.down;
			}
		}
		if(root != null) temp1.down = root;
		else temp1.down = right;
		
		return temp.down;
	}
	public void printLinkedList(ListNodeForFlat head) {
		// TODO Auto-generated method stub
		ListNodeForFlat temp = head;
		System.out.println("Printing flatten ones");
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.down;
		} 
		System.out.println();
	}
	public void printTotalLinkedList(ListNodeForFlat head) { // if cycle then no null is next so not 
		ListNodeForFlat temp = head;
		System.out.println("Printing right ones");
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.right;
		} 
		System.out.println();
		System.out.println("Printing down ones for each");
		temp = head;
		ListNodeForFlat temp1 = head;
		while(temp1 !=null) {
			while(temp != null) {
				System.out.print(temp.val +" ");
				temp = temp.down;
			} 
			System.out.println();
			temp = temp1.right;
			temp1 = temp1.right;
		}
	}
	ListNodeForFlat mergeScalerSol(ListNodeForFlat a, ListNodeForFlat b) {
	    if (a == null)
	        return b;
	    if (b == null)
	        return a;
	    ListNodeForFlat result;
	    if (a.val < b.val) {
	        result = a;
	        result.down = mergeScalerSol(a.down, b);
	    } else {
	        result = b;
	        result.down = mergeScalerSol(a, b.down);
	    }
	    return result;
	}

	ListNodeForFlat flattenScalerSol(ListNodeForFlat root) {
	    if (root == null || root.right == null)
	        return root;
	    return mergeScalerSol(root, flatten(root.right));
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
		fll.printTotalLinkedList(a);
		ListNodeForFlat q = fll.flatten(a);
		fll.printLinkedList(q);
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