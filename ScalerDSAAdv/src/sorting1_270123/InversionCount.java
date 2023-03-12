package sorting1_270123;
// https://www.scaler.com/academy/mentee-dashboard/class/50136/assignment/problems/4190/?navref=cl_pb_nv_tb
public class InversionCount {

	public int inversionCountBrute(int[] A) { // O(n^2) O(1)
		int count=0;
		for(int i=0; i<A.length-1; i++) {
			for(int j=i+1; j<A.length; j++) {
				if(A[i]>A[j]) count++;
			}
		}
		return count;
	}
	public int inversionCount(int[] A) { // O(nlogn)
		int s = 0, e = A.length-1;
		int mod = 1000000007;
		int count=inversion(A, s,e)%mod;
		return count;
	}
	public int merge(int[] A, int s, int m, int e) {
		int[] C = new int[e-s+1];
		int count=0;
		int p1=s, p2=m+1, p3=0;
		while(p1<=m && p2<=e) {
			if(A[p1] <= A[p2]) {
				C[p3] = A[p1];
				p1++; p3++;
			}
			else {
				C[p3] = A[p2];
				p2++; p3++;
				count += m-p1+1;
			}
		}
		while(p1<=m) {
			C[p3] = A[p1];
			p1++; p3++;
		}
		while(p2<=e) {
			C[p3] = A[p2];
			p2++; p3++;
		}
		// copy temp to main array
		p3=0;
		for(int i=s; i<=e; i++) {
			A[i] = C[p3];
			p3++;
		}
		//for(int i=0; i<C.length; i++) System.out.print(C[i] + " ");
		//System.out.println();
		return count;
	}
	public int inversion(int[] A, int s, int e) {
		if(s==e) return 0;
		int mod = 1000000007;
		int mid = (s+e)/2;
		int A_count = inversion(A, s, mid)%mod;
		int B_count = inversion(A, mid+1, e)%mod;
		int A_B_count = merge(A, s, mid, e)%mod;
		//System.out.println(A_count + " "+ B_count +" "+ A_B_count);
		return (A_count + B_count + A_B_count)%mod;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InversionCount ic = new InversionCount();
		int[] A = {10,3,8,15,6,12,2,18,7,1};
		System.out.println(ic.inversionCountBrute(A)); // 26
		System.out.println(ic.inversionCount(A)); // 5
	}

}
