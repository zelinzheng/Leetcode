public class EditDistance {
    public int minDistance(String word1, String word2) {
        // retkkkk peta
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dpRet = new int[len1+1][len2+1];
        
        for(int i=0; i<=len1; i++) dpRet[i][0] = i;
        for(int i=0; i<=len2; i++) dpRet[0][i] = i;
        
        for(int i=0; i<len1; i++) {
            char c1 = word1.charAt(i);
            for(int j=0; j<len2; j++) {
                if(c1 == word2.charAt(j)) 
                    dpRet[i+1][j+1] = dpRet[i][j];
                else {
                    int insert = dpRet[i+1][j] + 1;
                    int delete = dpRet[i][j+1] + 1;
                    int replace = dpRet[i][j] + 1;
                    
                    dpRet[i+1][j+1] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        
        return dpRet[len1][len2];
    }
}