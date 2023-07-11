class Solution {
    public void solveSudoku(char[][] board) {
        boolean ans = solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    for(int c=1;c<=9;c++){
                        if(check(i,j,board,c)){
                            board[i][j]=(char)(c+'0');
                            if(solve(board)) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
            
        }
        return true;
    }
    public boolean check(int row, int col, char[][] board, int ch ){
        char c = Character.forDigit(ch,10);
        for(int i=0;i<board.length;i++){
            if(board[row][i]==c) return false;
            if(board[i][col]==c) return false;
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==c) return false;
        }
        return true;
    } 
}