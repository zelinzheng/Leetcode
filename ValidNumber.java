public class ValidNumber {
    public boolean isNumber(String s) {
        if(s==null || s.length() ==0 ) return false;
        
        int i=0;
        
        while(i<s.length() && s.charAt(i) == ' ') i++;
        
        if(i<s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        
        boolean pointSign = false;
        boolean eSign = false;
        boolean num = false;
        
        while(i<s.length()) {
            if(s.charAt(i) == '.') {
                if(pointSign||eSign) return false;
                pointSign = true;
            } else if (s.charAt(i) == 'e') {
                if(eSign || !num) return false;
                num = false;
                eSign = true;
                if(i<s.length()-1 && (s.charAt(i+1) == '+' || s.charAt(i+1) == '-')) i++;
            } else if(s.charAt(i) < '0' || s.charAt(i) > '9' ) {
                while(i<s.length() && s.charAt(i) == ' ') i++;
                if(num && i == s.length()) return true;
                return false;
            } else {
                if(!num) num = true;
            }
            i++;
        }
        
        return num;
    }
}