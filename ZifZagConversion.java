public class Solution {
    public String convert(String s, int nRows) {
        if(s == null || s.length()<2 || nRows<2) return s;
        
        StringBuilder[] as = new StringBuilder[nRows];
        for(int i=0;i<nRows;i++){
            as[i] = new StringBuilder();
        }
        int j=-1;
        boolean increase = true;
        for(int i=0; i<s.length(); i++) {
            if(increase) {
                j++;
                if(j==nRows-1) increase = false;
            } else {
                j--;
                if(j==0) increase = true;
            }
            as[j].append(s.charAt(i));
        }
        for(int i=1; i<nRows;i++) {
            as[0].append(as[i]);
        }
        
        return as[0].toString();
    }
}
