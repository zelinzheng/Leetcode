public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        
        int ret=0;
        long div = (long)divisor;
        long did = (long)dividend;
        boolean negative = false;
        if(div<0) {
            negative = !negative;
            div = -div;
        }
        
        if(did<0) {
            negative = !negative;
            did = -did;
        }
    
        //if(divisor ==1) return negative? (int)-did: (int)did;
        //if(divisor ==2) return negative? - dividend>>1: dividend>>1;
        int i=0;
        for(;did>=div;){
            div = div << 1;
            i++;
        }
        i--;
        div = div>>1;
        while(i>=0&&did>0) {
            if(did>=div) {
                did -= div;
                ret += 1<<i;
            }
            div = div>>1;
            i--;
        }
        
        return negative? -ret:ret;
    }
}