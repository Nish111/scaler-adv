package arrays3_090123;
// https://www.scaler.com/academy/mentee-dashboard/class/50128/homework/problems/4099/hints?navref=cl_pb_nv_tb
public class NumberOfDigitOne {

	public int solve(int A) { // TLE O(A) A is 10^9 so wont work
		int count=0, sum=0;
		//if(A<10) return 1;
		for(int i=1; i<=A; i++) {
			count += checkBitOne(i);
		}
		return count;
    }
	public int checkBitOne(int i) {
		int temp=0, count=0;
		while(i>0) {
			temp=i%10;
			i=i/10;
			if(temp==1) count++;
		}
		return count;
	}
	/*
	 * Theory:
1. Find the contribution of 1 for each places eg. for unit,tenth,hundredth ... places.
2. Add all the contributions
eg: 
Unit place:
0-9, 10-19, 20-29,30-39 => 1 after every 10 digit

Tenth Place:
00-99(10-19)  , 100-199, 200-299, 300-399 => 10 after every 100 digits

eg: 235
Unit place:
ans += (235/10)*1 + (235%10)>1? 1 : (235%10)>0? 1:0

Tenth Place:
ans += (235/100)*10+ (235%100)>19? 10 : (235%100)>9? 35-9:0

Hundred Place:
ans += (235/1000)*100+ (235%1000)>199? 100 : (235%1000)>99? 235-99:0
	 */
	 public int solve2(int A) {
	        int tmp = A;
	        int n = 0;
	        while(tmp>0){
	            n++;
	            tmp = tmp/10;
	        }
	        return totalNumDigit(A,n);
	    }
	   public int totalNumDigit(int num, int digits){
	        if(digits == 0) return 0;
	        int dN_1 = (int) Math.pow(10,digits-1);
	        int dN = (int) Math.pow(10,digits);
	        int a = num/dN;
	        int b = num%dN;
	        int ans = a*dN_1;
	        if(b > (2*dN_1-1)){  // eg: b : 35, if(b>19) => ans += 10
	            ans += dN_1;
	        }else if( b > dN_1-1){ // eg:b is 17,  b>9 => ans += 17-9 
	            ans += b-dN_1+1;
	        }
	        return ans+ totalNumDigit(num,digits-1);
	    }
	   public int solveVideo(int A) {
	        int tmp = A;
	        int n = 0;
	        while(tmp>0){
	            n++;
	            tmp = tmp/10;
	        }
	        //System.out.println(A+" "+n);
	        return loopDigits(A,n-1);
	    }
	public int loopDigits(int A, int n) {
		int sum=0;
		while(n>=0) {
			int i = (int) Math.pow(10, n);
			//System.out.println(i);
			int temp = (int) (Math.floor(A/(i*10)))*i + Math.min(Math.max(A%(i*10)-(i-1), 0), i);
			sum += temp;
			n--;
		}
		return sum;
	}
	public int solveScalerSol(int A) {
        int ans = 0;
        for (int i = 1; i <= A; i *= 10) {
            int divider = i * 10;
            // finding the number of 1's in each place
            ans += (A / divider) * i + Math.min(Math.max(A % divider - i + 1, 0), i);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfDigitOne node = new NumberOfDigitOne();
		System.out.println(node.solve(10)); // 2
		System.out.println(node.solve(11)); // 4
		System.out.println(node.solve(15)); // 8
		System.out.println(node.solve(6564054)); // 4986216
		System.out.println(node.solve(1685077)); // 1729596
		System.out.println(node.solveVideo(10)); // 2
		System.out.println(node.solveVideo(11)); // 4
		System.out.println(node.solveVideo(15)); // 8
		System.out.println(node.solveVideo(6564054)); // 4986216
		System.out.println(node.solveVideo(1685077)); // 1729596
	}

}
