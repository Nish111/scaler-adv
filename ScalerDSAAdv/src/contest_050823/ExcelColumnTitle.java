package contest_050823;
// https://www.scaler.com/test/97de52ecc3/#/problem_4
public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        String sb = new String();
        while(A>0){
            int temp = (A-1)%26;
            sb = (char)('A'+temp)+sb;
            A = (A-1)/26;
            
        }
        return sb;
    }
}
