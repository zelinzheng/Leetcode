public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length ==0) return 0;
        
        int m=obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[] count = new int[n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(obstacleGrid[i][j] == 1) 
                    count[j] = 0;
                else {
                    if(j == 0 && i == 0)
                        count[j] = 1;
                    else if (j==0) 
                        count[j] = count[j];
                    else if (i==0)
                        count[j] = count[j-1];
                    else 
                        count[j] = count[j-1] + count[j];
                }
            }
        }
        return count[n-1];
        
    }
}