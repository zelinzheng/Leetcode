public class PalindromePartitioningII {
    public int minCut(String s) {
        if(s == null || s.length() ==0) return 0;
        
        boolean[][] ret = new boolean[s.length()][s.length()];
        
        int[] count = new int[s.length()+1];
        for(int i=0; i<=s.length(); i++) {
            count[i] = s.length()-i-1;
        }
        
        dp(s,ret, count);
        
        return count[0];
    }

    private void dp(String s, boolean[][] record, int[] count) {
        int len = s.length();
        for(int i=len-1; i>=0; i-- ) {
            for(int j=i; j<len; j++) {
                if(s.charAt(j) == s.charAt(i)) {
                    if(j-i<2 || record[i+1][j-1]) {
                        record[i][j] = true;
                        count[i] = Math.min(count[i], count[j+1]+1);
                    }
                }
                
               
            }
        }
    }
}