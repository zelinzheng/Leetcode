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
}