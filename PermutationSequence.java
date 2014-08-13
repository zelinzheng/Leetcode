public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if(n<1 || k<1) return "";
        
        StringBuilder ret = new StringBuilder();
        for(int i=1; i<=n; i++) {
            ret.append(i);
        }
        for(int i=1; i<k; i++) {
            ret = nextRet(ret,n);
        }
        
        return ret.toString();
    }
    
    private StringBuilder nextRet(StringBuilder ret, int n) {
        int i=n-2;
        for(; i>-1; i--) {
            if(ret.charAt(i)<ret.charAt(i+1)) break;
        }
        int j = n-1;
        for(;j>i;j--) {
            if(ret.charAt(j)>ret.charAt(i)) break;
        }
        swap(ret, i,j);
        reverse(ret, i+1, n-1);
        return ret;
    }
    
    private void swap(StringBuilder ret, int low, int high) {
        char c = ret.charAt(low);
        ret.setCharAt(low, ret.charAt(high));
        ret.setCharAt(high, c);
    }
    
    private void reverse(StringBuilder ret, int low, int high) {
        while(high>low) {
            swap(ret, low, high);
            low++;
            high--;
        }
    }
}