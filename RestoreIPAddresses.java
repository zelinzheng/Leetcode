public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        
        if(s==null || s.length()<4) return ret;
        
        String temp = "";
        hp(ret, temp, s.length(), 0, s);
        return ret;
    }
    
    private void hp(List<String> ret, String temp, int len, int count, String s) {
        if(count == 4) {
            if(len == 0)
                ret.add(temp);
            return;
        }
        
        int max = Math.min(3, len);
        int num = 0;
        for(int i=0; i<max; i++) {
            num = num*10+ s.charAt(s.length()-len+i) - '0';
            if(num>255) break;
            String temp2 =temp;
            if(count !=0) temp2 += ".";
            temp2 += num;
            hp(ret, temp2, len-i-1, count+1, s);
            if(num ==0) break;
        }
    }
}