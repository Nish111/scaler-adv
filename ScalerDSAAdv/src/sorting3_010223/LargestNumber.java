package sorting3_010223;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// https://www.scaler.com/academy/mentee-dashboard/class/50138/homework/problems/64/?navref=cl_pb_nv_tb
public class LargestNumber {

	public String largestNumber(int[] A) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			if(max<A[i]) max =A[i];
		}
		int[] B = new int[max+1];
		StringBuilder count = new StringBuilder();
		for(int i=0; i<A.length; i++) {
			B[A[i]]++;
		}
		//for(int i=0; i<B.length; i++) System.out.print(B[i] +" ");
		//System.out.println();
		for(int i=B.length-1; i>=0; i--) {
			int temp = B[i];
			while(temp>0) {
				count.append(i);
				temp--;
			}
		}
		return count.toString();
	}
	 // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        Collections.sort(A,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                String ab=a+""+b;
                String ba=b+""+a;
               // if(ab.equals(ba)) return 0;
                return ba.compareTo(ab);
            }
        });
        if(A.get(0)==0) return "0"; 
        StringBuilder output=new StringBuilder() ;
        for(int i=0;i<A.size();i++){
            output.append(A.get(i));
        }
        return output.toString();
    }
    public String largestNumberScalerSol(final List < Integer > A) {
        StringBuffer strBuf = new StringBuffer();
        NodeScalerSol num[];
        int i = 0;
        num = new NodeScalerSol[A.size()];
        for (int n: A) {
            num[i] = new NodeScalerSol(n);
            i++;
        }
        // sorts the array lexicographically
        Arrays.sort(num);
        for (NodeScalerSol n: num) {
            if (n.number == 0 && strBuf.length() != 0)
                continue;
            strBuf.append(n.number);
        }
        return strBuf.toString();
    }
    class NodeScalerSol implements Comparable < NodeScalerSol > {
        int number;
        public NodeScalerSol(int number) {
            this.number = number;
        }
        @Override
        public int compareTo(NodeScalerSol o) {
            String first = String.valueOf(this.number) + String.valueOf(o.number);
            String second = String.valueOf(o.number) + String.valueOf(this.number);
            return second.compareTo(first);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumber cs = new LargestNumber();
		int[] A = {9,0,1,6,5,4,4};
		System.out.println(cs.largestNumber(A)); // 9654410
		int[] B = {88,102,5,62,75};
		System.out.println(cs.largestNumber(B)); // 1028875625 - wrong
		int[] C = {3, 30, 34, 5, 9};
		System.out.println(cs.largestNumber(C)); // 3430953 - wrong
		int[] D = {2, 3, 9, 0};
		System.out.println(cs.largestNumber(D)); // 9320
	}

}
