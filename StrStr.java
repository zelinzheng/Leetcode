public class StrStr {
    public String strStr(String haystack, String needle) {
        if(haystack == null ) return null;
        if(needle==null || needle.length() ==0) return haystack;
        
        for(int i=0; i<haystack.length()-needle.length() +1; i++) {
            int j=0; 
            while(j<needle.length()) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                } else
                    j++;
            }
            if(j == needle.length()) {
                return haystack.substring(i);
            }
        }
        
        return null;
    }
}