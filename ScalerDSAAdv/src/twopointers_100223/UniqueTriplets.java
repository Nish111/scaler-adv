package twopointers_100223;

import java.util.Arrays;

public class UniqueTriplets {

	public void findUniqueTriplets(int[] A) {
		Arrays.sort(A); // nlogn
		for (int i = 0; i < (A.length - 2); i++) {
			if (i > 0 && A[i] == A[i - 1])
				continue;
			int k = -A[i];
			int p1 = i + 1, p2 = A.length - 1;
			while (p1 < p2) {
				int sum = A[p1] + A[p2];
				if (sum > k)
					p2--;
				else if (sum < k)
					p1++;
				else {
					System.out.println(A[i] + "," + A[p1] + "," + A[p2]);
					p1++;
					while (p1 < p2 && A[p1 - 1] == A[p1])
						p1++;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueTriplets ut = new UniqueTriplets();
		int[] A = { -1, 0, 1, 2, -1, 4 };
		ut.findUniqueTriplets(A);  // -1,-1,2  -1,0,1
		int[] B = { -10, 4, 6, 6, 4 }; 
		ut.findUniqueTriplets(B);  // -10,4,6
		int[] C = { -10, 5, 5, 5 };
		ut.findUniqueTriplets(C); // -10,5,5
	}

}
