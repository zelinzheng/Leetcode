public class FindMinimuminRotatedSortedArray II  {
    public int findMin(int[] nums) {
        if(nums == null||nums.length==0) return 0;
        int l = 0, r = nums.length-1;
        int min = nums[0];
        
        while(l<r-1) {
            int mid = l +(r-l)/2;
            if(nums[l]<nums[r]) return nums[l];
            
            if(nums[l]<nums[mid]) l = mid+1;
            else if(nums[l]>nums[mid]){
                r = mid;
            } else {
                l++;
            }
        }
        
        min = Math.min(min, Math.min(nums[l],nums[r]));
        
        return min;
    }
}
