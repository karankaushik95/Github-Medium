class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length ==0){
            return false;
        }
        
        
        for (int i =0; i<board.length; i++){
            for(int j=0;j<board[i].length; j++){
               if(board[i][j] == word.charAt(0)){
                   if(depthFirstSearch(board, word.substring(1), new int[board.length][board[0].length], i, j)){
                       return true;
                   }
               } 
            }
        }
    
        return false;
    }
    
    public static boolean depthFirstSearch(char[][] board, String word, int[][] visited, int i, int j){
        if(word.isEmpty()){
            return true;
        }else{
            
            visited[i][j] = 1;
            
            try{
                if(visited[i-1][j] != 1){
                    if(board[i-1][j] == word.charAt(0)){
                        if(depthFirstSearch(board,word.substring(1), visited, i-1, j)){
                            return true;
                        }
                    }    
                }
                
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            
            try{
                if(visited[i+1][j] != 1){
                    if(board[i+1][j] == word.charAt(0)){
                        if(depthFirstSearch(board,word.substring(1), visited, i+1, j)){
                            return true;
                        }
                    }    
                }
                
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            
            try{
                if(visited[i][j-1] != 1){
                    if(board[i][j-1] == word.charAt(0)){
                        if(depthFirstSearch(board,word.substring(1), visited, i, j-1)){
                            return true;
                        }
                    }    
                }
                
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            
            try{
                if(visited[i][j+1] != 1){
                    if(board[i][j+1] == word.charAt(0)){
                        if(depthFirstSearch(board,word.substring(1), visited, i, j+1)){
                            return true;
                        }
                    }    
                }
                
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            
                        
            
        }
        visited[i][j] = 0;
        return false;
    }
}