public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        if(height == null||height.length==0) return 0;
        //int max = 0;
        int i=0;
        int ret = 0;
        Stack<Integer> track = new Stack<Integer>();
        while(i<height.length) {
            if(track.isEmpty()||height[i]>height[track.peek()]) {
                track.push(i);
                i++;
            } else {
                int h = height[track.pop()];
                int width = track.isEmpty()? i: i-track.peek()-1;
                ret = Math.max(ret, h*width);
            }
        }
        
        while(!track.isEmpty()) {
            int h = height[track.pop()];
            int width = track.isEmpty()? i: i-track.peek()-1;
            ret = Math.max(ret, h*width);
        }
        
        return ret;
    }
}
