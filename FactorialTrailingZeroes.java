public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if(n<=0) return 0;
        
        int fives = 0, twos =0;
        
        int temp = n;
        while(temp>=5) {
            fives+=temp/5;
            temp = temp/5;
        }
        temp = n;
        while(temp>=2){
            twos +=temp/2;
            temp = temp/2;
        }
        
        return Math.min(fives,twos);
    }
}
