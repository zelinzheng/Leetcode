 class Solution5 {
    public int atoi(String str) {
        if(str == null || str.length() ==0) return 0;
        boolean negative = false;
        int i=0;
        while(str.charAt(i) == ' ') {
            i++;
        }
        
        if(str.charAt(i) == '-') {
            negative = true;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        int ret = 0;
        for(;i<str.length();i++) {
            if( str.charAt(i) <'0' || str.charAt(i) >'9') 
                break;
            if( ((ret == 214748364) && (str.charAt(i) > '7')) || (ret > 214748364) ) 
                return negative?Integer.MIN_VALUE: Integer.MAX_VALUE;
            ret = ret*10 + (str.charAt(i) - '0');
        }
        
        return negative? -ret : ret;
    }
}
