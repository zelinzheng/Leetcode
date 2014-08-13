public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer> ();
        
        if(matrix == null || matrix.length==0 || matrix[0].length == 0) return ret;
        int y = matrix.length, x = matrix[0].length;
        int size = x * y;
        boolean[][] flags = new boolean[y][x];
        int[] pos = {-1,0};
        int direction = 1;
        while(ret.size()< size) {
            int[] newPos = nextPos(pos, direction);
            if(isValid(newPos, flags, x, y) ){
                ret.add(matrix[newPos[1]][newPos[0]]);
                flags[newPos[1]][newPos[0]] = true;
                pos = newPos;
            } else {
                direction = next(direction);
            }
        }
        
        return ret;
    }
    
    private boolean isValid(int[] newPos,boolean[][] flags, int x, int y) {
        if(newPos[0]<0|| newPos[0]>x-1 || newPos[1]<0 || newPos[1] > y-1 || flags[newPos[1]][newPos[0]]) return false;
        return true;
    }
    
    private int[] nextPos(int[] pos, int direction) {
        int[] next = new int [2];
        switch(direction) {
            case 1:
               next[0] = pos[0] +1;
               next[1] = pos[1];
                break;
            case 2: 
               next[0] = pos[0];
               next[1] = pos[1] + 1;
                break;
            case 3:
               next[0] = pos[0] - 1;
               next[1] = pos[1];
                break;
            case 4:
               next[0] = pos[0];
               next[1] = pos[1] - 1;
                break;
        }
        return next;
    }
    
    private int next(int direction) {
        return direction == 4? 1:direction+1;
    }
}