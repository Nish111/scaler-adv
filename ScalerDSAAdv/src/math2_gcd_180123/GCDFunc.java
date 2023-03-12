package math2_gcd_180123;

public class GCDFunc {

	public int gcd12(int n, int m) {
        if (n%m ==0) return m;
        if (n < m) swap(n, m);
        while (m > 0) {
            n = n%m;
            swap(n, m);
        }
        return n;
	}
	public void swap(int n, int m) { // infinite loop for java
		int temp = n;
		n = m; 
		m = temp;
		System.out.println(n + " " + m);
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GCDFunc gcd = new GCDFunc();
		System.out.println(gcd.gcd12(15, 8));
	}

}
