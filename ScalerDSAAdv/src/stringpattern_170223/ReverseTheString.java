package stringpattern_170223;
// https://www.scaler.com/academy/mentee-dashboard/class/50145/homework/problems/190?navref=cl_tt_nv
public class ReverseTheString {

	public String solve(String A) {
		String[] str = A.split(" ");
		String[] temp = new String[str.length];
		for(int i=str.length-1, j=0; i>=0; i--, j++) {
			temp[j] = str[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length-1; i++) {
			sb.append(temp[i]);
			sb.append(" ");
		}
		sb.append(temp[str.length-1]);
		return sb.toString();
    }
	public String solveScalerSol(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder buf = new StringBuilder();
        
        for(int i = s.length()-1; i>=0; i--)
        {
            char c = s.charAt(i);
            if(c!=' ') buf.append(c);
            else createScalerSol(res, buf);
        }
        
        createScalerSol(res, buf);
        return res.toString();
    }
    
    private void createScalerSol(StringBuilder res, StringBuilder buf)
    {
        int i = buf.length()-1;
        
        while(i>=0){
            if(i==buf.length()-1 && res.length()>0) res.append(' ');
            res.append(buf.charAt(i));
            i--;
        }
        buf.setLength(0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseTheString rts = new ReverseTheString();
		String A = "the sky is blue";
		System.out.println(rts.solve(A)); // blue is sky the
		String B = "this is ib";
		System.out.println(rts.solve(B)); // ib is this
	}

}
