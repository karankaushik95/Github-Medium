class Board {
    public void solve(char[][] board) {
        
        if(board.length==0){
            return;
        }
        
        int[][] boardGrid = new int[board.length][board[0].length];
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board[i].length;j++){
                if(board[i][j]=='O'){
                    checkBoard(board, boardGrid, i,j);
                }else{
                    boardGrid[i][j] = 1;
                }
            }
        }
    
    
    }

    public boolean checkBoard(char[][] board, int[][] boardGrid, int i,int j){
        
       if(boardGrid[i][j] == 1){
           return true;
       }else if(boardGrid[i][j] == -1){
           return false;
       }
        
       try{
           if(board[i-1][j] == 'O'){
               board[i][j] = '?';
               if(!checkBoard(board, boardGrid, i-1,j)){
                   boardGrid[i][j] = -1;
           board[i][j] = 'O';
           return false;
               }
           }
           
       }catch(ArrayIndexOutOfBoundsException e){
           boardGrid[i][j] = -1;
           board[i][j] = 'O';
           return false;
       }
        
       try{
           if(board[i+1][j] == 'O'){
               board[i][j] = '?';
               if(!checkBoard(board, boardGrid, i+1,j)){
                   boardGrid[i][j] = -1;
           board[i][j] = 'O';
           return false;
               }
           }
           
       }catch(ArrayIndexOutOfBoundsException e){
           boardGrid[i][j] = -1;
           board[i][j] = 'O';
           return false;
       }
        
       try{
           if(board[i][j-1] == 'O'){
               board[i][j] = '?';
               if(!checkBoard(board, boardGrid, i,j-1)){
                   boardGrid[i][j] = -1;
           board[i][j] = 'O';
           return false;
               }
           }
           
       }catch(ArrayIndexOutOfBoundsException e){
           boardGrid[i][j] = -1;
           board[i][j] = 'O';
           return false;
       }
        
       try{
           if(board[i][j+1] == 'O'){
               board[i][j] = '?';
               if(!checkBoard(board, boardGrid, i,j+1)){
                   boardGrid[i][j] = -1;
           board[i][j] = 'O';
           return false;
               }
           }
           
       }catch(ArrayIndexOutOfBoundsException e){
           boardGrid[i][j] = -1;
           board[i][j] = 'O';
           return false;
       } 
        
        boardGrid[i][j] = 1;
        board[i][j] = 'X';
        return true;
    }

}

class SurrondedRegions{
    
    public static void main(String[] args){
        Board sol = new Board();
        char[][] board = {{'O','X','O','O','O','X'},{'O','O','X','X','X','O'},{'X','X','X','X','X','O'},{'O','O','O','O','X','X'},{'X','X','O','O','X','O'},{'O','O','X','X','X','X'}};
        sol.solve(board);
    }
}
    