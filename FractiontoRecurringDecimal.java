public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        String ret = "";
        long up = numerator, down = denominator;
        if(down<0) {
            down = -down;
            up = -up;
        }
        
        if(up<0) {
            ret+='-';
            up = -up;
        }
        
        long div = up/down;
        ret += div+"";
        long remainder = up%down;
        if(remainder !=0) {
            ret+='.';
            HashMap<Long, Integer> map = new HashMap<Long,Integer>();
            
            int index = 0, start = -1;
            ArrayList<Long> fra = new ArrayList<Long>();
            do{
                if(!map.containsKey(remainder)) {
                    map.put(remainder, index);
                    remainder *=10;
                    fra.add(remainder/down);
                    remainder =remainder%down;
                    index++;
                } else {
                    start = map.get(remainder);
                    break;
                }
            }
            while(remainder!=0);
            
            if(start!=-1) {
                for(int i=0;i<start;i++){
                ret += fra.get(i).toString();
                }
                ret += '(';
                for(int i=start; i<index;i++){
                    ret += fra.get(i).toString();
                }
                ret+=')';
            }else {
                for(int i=0;i<index;i++){
                    ret+=fra.get(i).toString();
                }
            }
        }
        return ret;
    }
}
