package math4_combinatorics_240123;

import java.util.ArrayList;
import java.util.HashMap;
// https://www.scaler.com/academy/mentee-dashboard/class/50134/homework/problems/318/?navref=cl_pb_nv_tb
public class SortedPermutationRankRepeats {

	public int fact(int n,int mod){ // factorial function
        if(n==0)return 1;

        return (int)((1L*n*fact(n-1,mod))%mod);
    }

    public int powmod(long a,int b,int m){//power funtion a^b%m
        if(b==0)return 1;
        long t= powmod(a,b/2,m);
        if(b%2==0) return (int)((t*t)%m);
        return (int)((((t*t)%m)*a)%m);
    }

    public int findRank(String A) {
       
        int n=A.length();
        int mod=1000003;
        long ans=0L;

        //initially calculating all the freaquencies of all the char's in string A using Map
        //this can be done in the for loop as well everytime but this will save us many iteration
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++)
        {   char temp =A.charAt(i);
            hm.put(temp,hm.getOrDefault(temp,0)+1);
        }
        //our formula = (c*x)/d;
        //where c = count of all character(all appearences) strictly smaller than itself
        //      x=factorial of (n-i-1).this represent no of permu. for one samller char
        //    therefore multiplying it by c, gives total no of permutations starting with smaller char.
        //      d= the product of all factorials of the freq of all char's.
        for(int i=0;i<n-1;i++)
        {
            char temp =A.charAt(i);
            long c=0L;
            for(int j=i+1;j<n;j++)
            if(A.charAt(j)<temp)c++;  // we count c -smaller characters


            long div=1L;             //the product of freq of all the chars-***Including itself i.e char at i also;
            for(char s:hm.keySet())
            {
                int f=fact(hm.get(s),mod);
                div=(div*f)%mod;
            }

            hm.put(temp,hm.get(temp)-1);    // we will reduce the freq of ith char so as we already fixed it at ith position
           
            //Also we cant use the div directly to divide, we neew to find inverse of div.
            //using fermat little theorem.
            int inverse=powmod(div,mod-2,mod);

            //now the formula
            long p=(((fact(n-1-i,mod)*c)%mod)*inverse)%mod;
            ans=(ans+p)%mod;

           
        }
        return (int)((ans+1)%mod);// adding one as our string comes after ans.
       
    }
    private int MOD = 1000003;
    public int findRankScalerSol(String A) {
    
        // Initializations
        ArrayList<Integer> charCount = new ArrayList<Integer>(256);
        
        for(int i = 0; i < 256; i++) 
            charCount.add(0);
        for (int i = 0; i < A.length(); i++) {
            int ch = (int)A.charAt(i);
            charCount.set(ch, charCount.get(ch)+1);
        }
        
        ArrayList<Integer> fact = new ArrayList<Integer>(); // fact[i] will contain i! % MOD
        initializeFactorialsScalerSol(A.length() + 1, fact);
        
        long rank =  1;
        
        for (int i = 0; i < A.length(); i++) {
            // find number of permutations placing character smaller than A[i] at ith position 
            // among characters from i to A.length 
            long less = 0;
            int remaining = A.length() - i - 1;
            for (int ch = 0; ch < A.charAt(i); ch++) {
                if (charCount.get(ch) == 0) continue;
                // Lets try placing ch as the first character in remaining characters
                // and check the number of permutation possible.
                charCount.set(ch, charCount.get(ch)-1);
                long numPermutation = fact.get(remaining);
                
                for (int c = 0; c < 128; c++) {
                    if (charCount.get(c) <= 1) continue; 
                    numPermutation = (numPermutation * inverseNumberScalerSol(fact.get(charCount.get(c)))) % MOD;
                }
    
                charCount.set(ch, charCount.get(ch)+1);
                less = (less + numPermutation) % MOD;
            }
            
            rank = (rank + less) % MOD;
            // remove the current character from the set. 
            charCount.set((int)A.charAt(i), charCount.get(A.charAt(i))-1);
        }
        return (int)rank;

    }
    
    public void initializeFactorialsScalerSol(int totalLen, ArrayList<Integer> fact) {
        // calculates factorial
        long factorial = 1;
        fact.add(1); // 0!= 1
        for (int curIndex = 1; curIndex < totalLen; curIndex++) {
            factorial = (factorial * curIndex) % MOD;
            fact.add((int)factorial);
        }
        return;
    }
    
    public long powScalerSol(long x, int y, int k){
        long result = 1;
        while(y > 0){
            if(y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
    long inverseNumberScalerSol(int num) {
        // Find the modular multiplicative inverse
        // Calculates (num ^ (MOD - 2)) % MOD
        return powScalerSol(num, MOD-2 , MOD);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedPermutationRankRepeats sprr = new SortedPermutationRankRepeats();
		System.out.println(sprr.findRank("aba")); // 2
		System.out.println(sprr.findRank("bca")); // 4
		System.out.println(sprr.findRank("baa")); // 3 
		System.out.println(sprr.findRank("aba")); // 2
		System.out.println(sprr.findRank("aab")); // 1
		System.out.println(sprr.findRank("aab")); // 1

	}

}
