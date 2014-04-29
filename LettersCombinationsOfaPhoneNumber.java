public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
         ArrayList<String> ret = new ArrayList<String>();
        int numbers = 0;
        try {
            numbers = Integer.parseInt(digits);
        } catch (Exception e) {
            ret.add("");
            return ret;
        }
        
        int high = 1;
        while(numbers/high>10) {
            high *= 10;
        }
        
       
        String temp = "";
        
        hp(ret, numbers, high, temp);
        
        return ret;
        
    }
    
    private void hp(ArrayList<String> ret, int numbers, int high, String temp) {
        if(high == 0 ) {
            ret.add(temp);
            return;
        }
        
        int num = numbers/high;
        numbers %= high;
        high /=10;
        int j=3;
        if(num ==7|| num ==9) j=4; 
        
        for(int i=0; i<j; i++) {
            int c = ('a' + 3*(num-2) + i);
            if(num>7) c++;
            char cc = (char)c;
            hp(ret, numbers, high, temp+cc);
        }
    }
}