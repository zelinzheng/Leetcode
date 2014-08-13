public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length<9|| board[0].length<9) return;
        
        ArrayList<Integer> space = new ArrayList<Integer>();
        for(int i=0; i<9; i++) {
            for( int j=0; j<9;j++) {
                if(board[i][j] == '.')
                    space.add(i*9+j);
            }
        }
        dfs(space,0,board);
    }
    
    public boolean dfs(ArrayList<Integer> space, int index, char[][] board) {
        if(index == space.size()) return true;
        int position = space.get(index);
        int row = position/9;
        int col = position%9;
        for(int i=1; i<=9; i++) {
            board[row][col] = (char)('0' + i);
            if(isValid(board,row,col) && dfs(space, index+1, board)) return true;;
            board[row][col] = '.';
        }
        
        return false;
    }
    
    public boolean isValid(char[][] board, int row, int col) {
        for(int i=0; i<9;i++) {
            if(i!=col && (board[row][i]-board[row][col])==0) return false;
            if(i!=row && (board[i][col]-board[row][col])==0) return false;
            int blockrow = 3 * (row / 3) + i/3 ; int blockcol = 3 * (col / 3) + i%3;
            if((blockrow!=row || blockcol != col) && (board[blockrow][blockcol] - board[row][col]) == 0) return false;
        }
        return true;
    }
}