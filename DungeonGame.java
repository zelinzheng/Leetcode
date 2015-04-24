public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int lenX = dungeon.length;
        if(lenX==0) return 0;
        int lenY = dungeon[0].length;
        if(lenY==0) return 0;
        
        int[] ret = new int[lenY+1];
        for(int i=0;i<lenY+1;i++){
            ret[i] = Integer.MAX_VALUE;
        }
        
        
        for(int i=lenX-1;i>=0;i--){
            for(int j=lenY-1; j>=0;j--) {
                if(i==lenX-1&&j==lenY-1) ret[j] = Math.max(0,0-dungeon[i][j]);
                else ret[j] = Math.max(0, Math.min(ret[j],ret[j+1])-dungeon[i][j]);
            }
        }
        
        return ret[0]+1;
    }
}
