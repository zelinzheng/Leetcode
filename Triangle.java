
Triangle Total Accepted: 5596 Total Submissions: 21617My Submissions




Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle


[     [2],    [3,4],   [6,5,7],  [4,1,8,3]]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 

This question can be solved by traversing each level of the triangle. Since for each level, we only need to know the cumulative state of the adjacent two positions in the previous level, so we just need an array of n size to keep track of the states. During each level, the equation we used to compute for each position differs at the beginning and the end so that we need to deal with them differently. Two temporary int variable is used to help compute the value since the state each position used will interact. So only after the corresponding state will no longer be used, we can update it. See the code below:

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 ) return 0;
        int n = triangle.size();
        int[] result = new int[n];
        result[0] = triangle.get(0).get(0);
        for(int i=1; i<n; i++) {
            int temp = result[0]+ triangle.get(i).get(0);
            int j=1;
            for(; j<i; j++) {
                int temp2 = Math.min(result[j-1], result[j]) + triangle.get(i).get(j);
                result[j-1] = temp;
                temp = temp2;
               
            }
            result[j] = result[j-1] + triangle.get(i).get(j);
            result[j-1] = temp;
        }
        int minsofar = result[0];
        for(int i:result) {
            if(i<minsofar) minsofar = i;
        }
        return minsofar;
    }
}


However, I believe that there must be a way which is much cleaner than my code. For example. to avoid using the two ugly int temporary variable, or the separate the several situation in each level traversal. 
After searching on the Internet, I found out that if we don’t travel from the first level to the last level, but instead we go back, things will become much easier. It it because, the compute equation will be simplified into result[i][j] = triangle[i][j] + min(triangle[i+1][j], triangle[i+1][j+1], and only this one. This can much simplify our code. Considering the edge situation, when we are in the last level, if we are computing for the last index, j+1 will be out bound, however, we can set the array with a size as n+1, so that it will solve this problem. Now, things get done.


public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 ) return 0;
        int n = triangle.size();
        int[] result = new int[n+1];
        while(n-->0) {
            for(int j=0; j<=n; j++) {
                result[j] = Math.min(result[j], result[j+1]) + triangle.get(n).get(j);
               
            }
        }
        return result[0];
    }
}
