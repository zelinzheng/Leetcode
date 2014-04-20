public class Solution {
    public String convert(String s, int nRows) {
        if(s==null || s.length() < 2 || nRows<2) return s;
        StringBuilder[] sb = new StringBuilder[nRows];
        for(int i=0; i<sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        
        boolean down = true;
        int j=0;
        for(int i=0; i<s.length(); i++) {
            sb[j].append(s.charAt(i));
            if(down) {
                //if(j < nRows-1) j++;
                j++;
                if(j== nRows -1) down = false;
            } else {
                //if(j>0) j--;
                j--;
                if(j==0) down = true;
            }
        }
        
        for(int i=1; i<nRows; i++) {
            sb[0].append(sb[i]);
        }
        
        return sb[0].toString();
    }
}
