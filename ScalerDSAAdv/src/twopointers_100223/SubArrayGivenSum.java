package twopointers_100223;
// https://www.scaler.com/academy/mentee-dashboard/class/50142/assignment/problems/4116?navref=cl_tt_lst_sl
public class SubArrayGivenSum {

	public int[] solveBrute(int[] A, int B) { // O(n2) O(1)
		int sum=0;
		int[] arr = null;
		for(int i=0; i<A.length; i++) {
			sum=0;
			for(int j=i; j<A.length; j++) {
				sum+=A[j];
				if(sum==B) {
					arr = new int[j-i+1];
					for(int k=i, count=0; k<=j; k++, count++) {
						arr[count] = A[k];
					}
					return arr;
				}
			}
		}
		if(sum==B) return arr;
		else return new int[] {-1};
	}
	// need first sub contiguous array, mine is giving shortest and latest one
	// as checking for it
	public int[] solve(int[] A, int B) {
		int p1=0, p2=A.length-1;
		int start=0, end=0;
		while(p1<p2) {
			int sum = A[p1] + A[p2];
			if(sum > B) p2--;
			else if (sum<B) p1++;
			else if(sum==B){
				start = p1; end=p2;
				p1++;
			}
		}
		int[] arr = new int[end-start+1];
		int sum=0;
		for(int i=start, count=0; i<=end; i++, count++) {
			arr[count] = A[i];
			sum +=A[i];
		}
		if(sum==B) return arr;
		else return new int[] {-1};
    }
	public int[] solveVideo(int[] A, int B) { // working
		int p1=0, p2=0;
		int start=0, end=0;
		int sum=A[p2];
		while(p1<=p2 & p2<A.length) {
			if(sum==B){
				start = p1; end=p2;
				int[] arr = new int[end-start+1];
				sum=0;
				for(int i=start, count=0; i<=end; i++, count++) {
					arr[count] = A[i];
					sum +=A[i];
				}
				return arr;
			}
			else if (sum<B) {
				p2++;
				if(p2 < A.length) sum += A[p2]; // i missed if here
			}
			else {
				sum -= A[p1];
				p1++;
				if(p1>p2 && p1<A.length) {
					p2++;
					sum+=A[p2];
				}
			}
		}
		int[] arr = new int[end-start+1];
		sum=0;
		for(int i=start, count=0; i<=end; i++, count++) {
			arr[count] = A[i];
			sum +=A[i];
		}
		if(sum==B) return arr;
		else return new int[] {-1};
    }
	public int[] solveScalerSol(int[] A, int B) {
        long n = A.length;
        int l = 0, r = 0;
        long sum = A[l];
        while (r < n) {
            if (sum == B) {
                // current window sum = B
                int[] ans = new int[r - l + 1];
                for (int i = l; i <= r; i++) ans[i - l] = A[i];
                return ans;
            } else if (sum < B) {
                // current window sum < B
                r++;
                if (r < n) sum += A[r];
            } else {
                // current window sum > B
                sum -= A[l];
                l++;
                if (l > r && l < n - 1) {
                    r++;
                    sum += A[r];
                }
            }
        }
        int ans[] = new int[1];
        ans[0] = -1;
        return ans;
    }
	public void printArray(int[] A) {
		for(int i=0; i<A.length; i++) System.out.print(A[i] +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubArrayGivenSum sags = new SubArrayGivenSum();
		int[] A = {1, 2, 3, 4, 5};
		int[] B = sags.solveVideo(A, 5); // 2 3 
		int[] X = sags.solveBrute(A, 5); // 2 3
		sags.printArray(B);
		sags.printArray(X);
		int[] C = {5, 10, 20, 100, 105};
		int[] D = sags.solveVideo(C, 110); // -1
		int[] Y = sags.solveBrute(C, 110); // -1
		sags.printArray(D);
		sags.printArray(Y);
		int[] E = {42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37};
		int[] F = sags.solveVideo(E, 100);
		int[] Z = sags.solveBrute(E, 100);
		sags.printArray(F); // 50 50
		sags.printArray(Z); // 50 50
		int[] G = {1,3,2,5,2,7};
		int[] H = sags.solveVideo(G, 7);
		int[] U= sags.solveBrute(G, 7);
		sags.printArray(H);// 2 5
		sags.printArray(U); // 2 5
		int[] I = {15, 2, 5, 6, 9};
		int[] J = sags.solveVideo(I, 7);
		int[] V = sags.solveBrute(I, 7);
		sags.printArray(J);//  2 5
		sags.printArray(V); // 2 5
	}

}
