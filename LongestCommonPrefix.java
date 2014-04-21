public class Solution {
    public String longestCommonPrefix(String[] strs) {
       if(strs == null || strs.length==0) return "";
       
       int end = strs[0].length()-1;
       
       for(int i=1; i<strs.length; i++) {
           end = Math.min(strs[i].length()-1, end);
           int j= 0;
           while(j<=end) {
               if(strs[i].charAt(j) != strs[0].charAt(j)) end = j-1;
               j++;
           }
       }
       
       return strs[0].substring(0, ++end);
        
    }
}