package bitmanipu2_130123;

public class StrangeEquality {

	public int solve(int A) { // TLE
		int sumX=0, xorX=0, valX=0, max_valX=Integer.MIN_VALUE;
		int sumY=0, xorY=0, valY=Integer.MAX_VALUE, min_valY=Integer.MAX_VALUE;
		for(int i=0; i<A; i++) {
			sumX = i+A;
			xorX = i^A;
			if(sumX==xorX) valX = i;
			max_valX = Math.max(max_valX, valX);
		}
		//System.out.println(max_valX);
		for(int i=A+1; i<2*A+2; i++) {
			sumY = i+A;
			xorY = i^A;
			if(sumY==xorY) {
				valY = i;
				break;
			}
//			if(i==8) {
//				System.out.println(sumY +" "+xorY+" "+valY);
//			}
			//min_valY = Math.min(min_valY, valY);
			//System.out.println(min_valY +" "+i);
		}
		//System.out.println(min_valY);
		return max_valX^valY;
    }
	public int solve2(int A) { // TLE
		int sumX=0, xorX=0, valX=0;
		int sumY=0, xorY=0, valY=Integer.MAX_VALUE, min_valY=Integer.MAX_VALUE;
		for(int i=A-1; i>=0; i--) {
			sumX = i+A;
			xorX = i^A;
			if(sumX==xorX) {
				valX = i;
				break;
			}
		}
		//System.out.println(valX);
		for(int i=A+1; i<2*A+2; i++) {
			sumY = i+A;
			xorY = i^A;
			if(sumY==xorY) {
				valY = i;
				break;
			}
		}
		//System.out.println(valY);
		return valX^valY;
    }
	public int solveLogic(int A) { // 
		// revert bits in A to get x such that A&X=0
		// A+X = A^X + 2*(A&X)
		/*
		 * //if A is lets say 4 i.e, 100 in binary, then the final answer
// in binary will be 1011, how? lets see
a|b = a^b + a&b this is one of the properties which you can easily check,
a+b = a|b + a&b  also one of the properties of bitwise addition.
a+b = a^b + 2(a&b)  by substitution 
since a+b=a^b we get a&b=0 which means that all the bits are diff for a & b!
similary a&c==0, but keep in mind c is greater than a which is only possible if 
there's an extra msb(most significant bit) in c when compared with a.
		 */
		int msb = 0, ans=0, temp=0, temp2=0;;
		for(int i=30;i>=0; i--) {
			temp = 1<<i;
			temp2 = A&temp;
			//System.out.println(A&1<<i);
			if((A&1<<i) !=0) { // is equal to ((A&(1<<i)) !=0)
				msb = Math.max(msb, i);
				//System.out.println(msb +" "+ i+" "+ temp+" "+temp2);
			} else if(msb !=0) {
				ans += 1<<i;
				//System.out.println("else "+ans +" "+ i);
			}
		}
			ans += 1<<(msb+1);
			return ans;
    }
	public int solveLogicMine(int A) { // 
		// revert bits in A to get x such that A&X=0
		// A+X = A^X + 2*(A&X)
		int msb = 0, ans=0, temp=0, temp2=0, temp3=0;
		// finding msb bit of A
		for(int i=30;i>=0; i--) {
			if((A&1<<i) !=0) { // is equal to ((A&(1<<i)) !=0)
				msb = i;
				break;
			} 
		}
		// then getting Y which will be msb+1
		temp = 1<<(msb+1);
		if(temp-1 == A) return temp;
		// if we have all A as 2^x-1 then X is 0 and Y is 2^x which will be temp
		// else we find temp2 which is temp-1(1111..1)
		// and X is (1111..1)-A which is automatically temp2-A
		else {
			temp2 = temp-1;
			temp3 = temp2-A;
			return temp+temp3;
		}
    }
	public int solveScalerSol(int A) {
        int bit = 0, x = 0;
        // x is equal to the summation of unset bits in A
        while (A != 0) {
            if (A % 2 == 0) {
                x = x | (1 << bit);
            }
            A /= 2;
            bit++;
        }
        // y equals the power of 2 just greater than A
        int y = (1 << bit);
        return x ^ y;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrangeEquality se = new StrangeEquality();
		System.out.println(se.solve2(5)); // 10 - 2 8
		System.out.println(se.solve2(3)); // 4 - 0 4
		System.out.println(se.solve2(8)); // 23 - 7 16
		System.out.println(se.solve2(6)); // 9 - 1 8 
		System.out.println(se.solveLogicMine(5)); // 10
		System.out.println(se.solveLogicMine(3)); // 4
		System.out.println(se.solveLogicMine(8)); // 23
		System.out.println(se.solveLogicMine(6)); // 9
		System.out.println(se.solveLogicMine(3304567)); // 5084040
		System.out.println(se.solveLogicMine(8136293)); // 8640922
		System.out.println(se.solveLogicMine(6192855)); // 10584360
	}

}
