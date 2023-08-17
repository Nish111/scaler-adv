package contest_190523;
// https://www.scaler.com/test/745654aa9c/#/problem_2
public class TreasureHunter {
    public int solve(String A, String B) {
        int[] charA = new int[26];
        int[] charB = new int[26];
        for(int i=0; i<A.length(); i++){
            charA[A.charAt(i)-'a']++;
        }
        for(int i=0; i<B.length(); i++){
            charB[B.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            if(charB[i]>charA[i]) return 0;
        }
        return 1;
    }
}
