public class Solution {
    //havn't deal with overflow yet, look at parseInt
    public int reverse(int x) {
        
        boolean positive = true;
        
        if(x<0) {x=-x;positive = false;}
        int ret = 0;
        
        while(x>0) {
            int digit = x%10;
            x= x/10;
            ret= ret*10+digit;
        }
        
        return positive?ret:-ret;
    }
}
