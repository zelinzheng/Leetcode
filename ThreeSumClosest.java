public class Solution {
    public int threeSumClosest(int[] num, int target) {
        
        if(num == null || num.length <3) return 0;
        
        Arrays.sort(num);
        
        int ret = num[0] + num[1] + num[2];
        
        for(int i=0; i<num.length-2; i++) {
            int temp = num[i];
            int l= i+1, r = num.length-1;
            while(l<r) {
                temp = num[i] + num[l] + num[r];
                if(temp == target) return target;
                if(Math.abs(temp-target)<Math.abs(ret - target) ) ret = temp;
                if(temp<target) l++;
                else r--;
            }
        
        }
        return ret;
        
        
        
    }
}