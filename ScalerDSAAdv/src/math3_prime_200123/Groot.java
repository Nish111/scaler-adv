package math3_prime_200123;

import java.util.Arrays;
import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50133/homework/problems/2206/?navref=cl_pb_nv_tb
public class Groot { // Factorial Array
	  public int getMax(int[] A){
	        int N=A.length,max = 1<<31;
	        for(int i:A){
	            max = Math.max(max,i);
	        }
	        return max;
	    }
	    public void findSPF(int max,int[] spf){
	        Arrays.fill(spf,1);
	        int pre=1,x = (int)Math.sqrt(max);
	        for(int i=2;i<=x;i++){
	            if(spf[i]==1){
	                for(int j=i*i;j<=max;j+=i){
	                    spf[j]=0; // marking non-prime numbers
	                }
	            }
	        }
	        for(int i=2;i<=max;i++){
	            if(spf[i]==1){
	                pre =i; //using carry forward approach to fill the largest prime number
	            }
	            spf[i]=pre;
	        }
	    }
	    public int solve(int[] A) {
	        int max = getMax(A),ans=0; //get max from A
	        int[] spf = new int[max+1];
	        findSPF(max,spf);        // filling spf array with largest prime numbers till there
	        HashMap<Integer,Integer> hm = new HashMap<>();
	        for(int i:A){
	            if(i==1) continue;
	            hm.put(spf[i],hm.getOrDefault(spf[i],0)+1);
	            ans += 1<<hm.get(spf[i])-1; // for every new occurrence, 2^count -1 subseq’s are possible
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Groot g = new Groot();
		int[] A = {2,3,2,3};
		int[] B = {2,3,4};
		int[] C = {5,25,11,10,15};
		System.out.println(g.solve(A)); // 6
		System.out.println(g.solve(B)); // 4
		System.out.println(g.solve(C)); // 5
		
		
	}

}
