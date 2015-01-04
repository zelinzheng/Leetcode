public class SurroundedRegions {
    public void solve(char[][] board) {
        
        if(board == null || board.length ==0) return;
        
        int lenX = board.length ;
        int lenY = board[0].length;
        
        //Queue<Integer> queue = new LinkedList<Integer> ();
        
        for(int i=0; i<lenX; i++) {
                fill(i,0, board);
                fill(i, lenY-1, board);
        }
        
        for(int i=0; i<lenY; i++) {
             fill(0,i, board);
             fill(lenX-1, i, board);
        }
        
        for(int i=0; i<lenX; i++) {
            for(int j=0; j<lenY; j++) {
                if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        
        return;
    }
    
    private void fill (int x, int y, char[][] board) {
        if(board[x][y] != 'O') return;
        
        board[x][y] = 'Y';
        
        Queue<Integer> qc = new LinkedList<Integer>();
        Queue<Integer> qr = new LinkedList<Integer>();
        qr.add(x);
        qc.add(y);
        
        while(qr.size() != 0) {
            
            int row = qr.poll();
            int col = qc.poll();
            
        
            if(row>0 && board[row-1][col] == 'O') {
                board[row-1][col] = 'Y';
                qr.add(row-1);
                qc.add(col);
            }
            if(row<board.length-1 && board[row+1][col] == 'O') {
                board[row+1][col] = 'Y';
                qr.add(row+1);
                qc.add(col);
            }
            
            if(col>0 && board[row][col-1] == 'O') {
                board[row][col-1] = 'Y';
                qr.add(row);
                qc.add(col-1);
            }
            if(col<board[0].length-1 && board[row][col+1] == 'O') {
                board[row][col+1] = 'Y';
                qr.add(row);
                qc.add(col+1);
            }
        
        }
        return;
    }
    
}