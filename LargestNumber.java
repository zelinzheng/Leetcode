public class LargestNumber {
    public String largestNumber(int[] nums) {
        NumObject[] nos = new NumObject[nums.length];
        for(int i=0;i<nums.length;i++){
            nos[i] = new NumObject(nums[i]);
        }
        
        Arrays.sort(nos);
        String ret = "";
        for(int i=0;i<nos.length;i++){
            if(ret.equals("0")) ret = nos[i].num;
            else ret +=nos[i].num;
        }
        
        return ret;
    }
    
    class NumObject implements Comparable<NumObject> {
        String num;
        public NumObject(int num) {
            this.num = num+"";
        }
        
       public  int compareTo(NumObject no) {
            String num2 = ((NumObject)no).num;
            
            String s12 = num+num2;
            String s21 = num2+num;
            
            return s21.compareTo(s12);
        }
    }
}
