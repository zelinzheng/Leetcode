public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() ==0) return 0;
        //if(s.length() ==1 && s.charAt(0) == '0') return 0;
        int ret[] = new int[s.length()+1];
        int n = s.length();
        ret[n] = 1;
        if(s.charAt(n-1) == '0')ret[n-1] = 0;
        else ret[n-1] = 1;
        
        for(int i=n-2; i>=0; i--) {
            int c = s.charAt(i) - '0';
            if(c>2) ret[i] = ret[i+1];
            else if(c==2) {
                if(s.charAt(i+1) >'6') ret[i] = ret[i+1];
                else ret[i] = ret[i+1] + ret[i+2];
            } else if(c==1){
                ret[i] = ret[i+1] + ret[i+2];
            } else {
                ret[i] = 0;
            }
        }
        return ret[0];
        
    }
}