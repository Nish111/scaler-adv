package queues_070323;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class NthElement {
	// Nth number created from 1, 2
	public int findNthUsing12(int n) {
		Queue<Integer> q = new LinkedList<>();
		int el1 = 1, el2 = 2;
		q.add(el1);
		q.add(el2);
		int count=2;
		int res1=0, res2=0;
		while(count<=n) {
			int temp = q.poll();
			res1 = temp*10+el1;
			q.add(res1);
			count++;
			System.out.println(res1);
			res2 = temp*10+el2;
			q.add(res2);
			count++;
			System.out.println(res2);
		}
		if(count>n) return res1;
		else return res2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthElement ne = new NthElement();
		System.out.println(ne.findNthUsing12(5)); // 21
		   
	}

}
