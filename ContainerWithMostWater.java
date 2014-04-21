public class Solution {
    public int maxArea(int[] height) {
        //area = small height * distance between xs
        if(height.length<2) return 0 ;
        
        int l=0, r = height.length-1;
        
        int maxArea = 0;
        
        while(l<r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r-l));
            
            if(height[l]<height[r]) l++;
            else r--;
        }
        
        return maxArea;
        
    }
}