package hashing_130223;

import java.util.HashSet;
// https://www.scaler.com/academy/mentee-dashboard/class/50143/homework/problems/275/hints?navref=cl_pb_nv_tb
public class ColorfulNumber {

	public int findIfColorfulNumber(int N) { //O(digits2) O(digits2) 
		// number broken into different contiguous sub-sequnece parts
		// 3245 into 3 2 4 5 32 24 45 324 245
		// this is colorful number as product of every digit of above subsequence is different
		int count=0;
		int number = N;
		while(N>0) {
			N = N/10;
			count++;
		}
		N = number;
		int[] digits = new int[count];
		for(int i=count-1; i>=0; i--) {
			int temp = N%10;
			if(temp==1 && count>1) return 0; // if 1 it will repeat
			digits[i] = temp;
			N=N/10;
		}
		printArray(digits);
		HashSet<Integer> hs = new HashSet<>();
		int product = 1;
		for(int i=0; i<digits.length; i++) {
			product = 1;
			for(int j=i; j<digits.length; j++) {
				product *= digits[j];
				if(hs.contains(product)) return 0;
				else hs.add(product);
			}
		}
		return 1;
	}
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorfulNumber cn = new ColorfulNumber();
		System.out.println(cn.findIfColorfulNumber(3245)); // 1
		System.out.println(cn.findIfColorfulNumber(23)); // 1
		System.out.println(cn.findIfColorfulNumber(213)); // 0
	}

}
