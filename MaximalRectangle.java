public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int[] row = new int[matrix[0].length];
        int ret = 0;
        
        for ( int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(i==0) 
                    row[j] = matrix[i][j] == '0'? 0:1;
                else 
                    row[j] = matrix[i][j] == '0'? 0: (row[j] + 1);
            }
            
            ret = Math.max(ret, hp(row));
        }
        return ret;
    }
    
    private int hp(int[] row) {
        if(row == null || row.length ==0)
            return 0;
        
        Stack<Integer> h = new Stack<Integer>();
        int ret = 0;
        for(int i=0; i<=row.length; i++) {
            int current = (i==row.length)? -1: row[i];
            while(!h.isEmpty() && current<= row[h.peek()]) {
                int height = row[h.pop()];
                int width = h.isEmpty()? i: i-h.peek()-1;
                ret = Math.max(ret, height* width);
            }
            h.push(i);
        }
        return ret;
    }
    
    public class Solution {
    public int maximalRectangle2(char[][] matrix) {
        int max = 0;
        if(matrix == null || matrix.length==0 || matrix[0].length==0) return max;
        
        int m = matrix.length, n = matrix[0].length;
        int area[][] = new int[n][n];
        for(int i=0;i<m;i++){
            int pre = -1;
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1') {
                    if(pre==-1) pre = j;
                    for(int k=0;k<pre;k++){
                        area[k][j] = 0;
                    }
                    
                    for(int k=pre;k<=j;k++){
                        area[k][j] += j-k+1;
                        max = Math.max(area[k][j], max);
                    }
                }else {
                    pre = -1;
                    for(int k=0;k<=j;k++){
                        area[k][j] = 0;
                    }
                }
            }
        }
        
        return max;
        
    }
}
}
