public class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() <2 ) return s;
        int n = s.length();
        int longbegin = 0;
        int maxlength = 1;
        boolean[][] record = new boolean[n][n];
        
        for(int i=1;i<n;i++){
            for(int j=0;j+i<n;j++){
                record[j][j+i] = (s.charAt(j) == s.charAt(j+i) && (i<3 || record[j+1][j+i-1]));
                if(record[j][j+i]){
                    longbegin = j;
                    maxlength = i;
                } 
            }
            
        }

        return s.substring(longbegin, longbegin+maxlength+1);
    }
}