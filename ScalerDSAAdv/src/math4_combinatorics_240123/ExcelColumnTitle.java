package math4_combinatorics_240123;
// https://www.scaler.com/academy/mentee-dashboard/class/50134/assignment/problems/76/?navref=cl_pb_nv_tb
public class ExcelColumnTitle {

	public String convertToTitle(int A) {
		String sb = new String();
		while(A>0) {
			int temp = (A-1)%26;
			sb = (char) ('A'+temp)+sb;
			//sb = (char)('A'+temp)+sb;
			A = (A-1)/26;
			//System.out.println(sb);
		}
		return sb;
    }
	public String convertToTitleScalerSol(int A) {
        char[] array = new char[26];
        for (int i = 0; i < 26; i++)
            array[i] = (char)('A' + i);
        int num = 26;
        int index;
        String res = "";
        // find the characters from right to left
        while (A > 0) {
            index = (A - 1 + num) % num;
            A = (A - 1) / num;
            res = array[index] + res;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelColumnTitle ect = new ExcelColumnTitle();
		System.out.println(ect.convertToTitle(3)); // C
		System.out.println(ect.convertToTitle(27)); // AA
		System.out.println(ect.convertToTitle(33));
		System.out.println(ect.convertToTitle(333));
		
		
	}

}
