//https://leetcode.com/problems/word-search

class Solution {
    public boolean exist(char[][] board, String word) {
        // Empty board
        if (board.length == 0) {
            return false;
        }

        // Look through the grid for the first letter of the word
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // call DFS if it matches
                    if (depthFirstSearch(board, word.substring(1), new int[board.length][board[0].length], i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean depthFirstSearch(char[][] board, String word, int[][] visited, int i, int j) {
        // Base case, word is empty / or end of the word has been reached
        if (word.isEmpty()) {
            return true;
        } else {
            // Current node is "visited"
            visited[i][j] = 1;
            // Check if neighbouring nodes are worth visiting by checking if they have the required letter
            try {
                if (visited[i - 1][j] != 1) {
                    if (board[i - 1][j] == word.charAt(0)) {
                        if (depthFirstSearch(board, word.substring(1), visited, i - 1, j)) {
                            return true;
                        }
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }

            try {
                if (visited[i + 1][j] != 1) {
                    if (board[i + 1][j] == word.charAt(0)) {
                        if (depthFirstSearch(board, word.substring(1), visited, i + 1, j)) {
                            return true;
                        }
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }

            try {
                if (visited[i][j - 1] != 1) {
                    if (board[i][j - 1] == word.charAt(0)) {
                        if (depthFirstSearch(board, word.substring(1), visited, i, j - 1)) {
                            return true;
                        }
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }

            try {
                if (visited[i][j + 1] != 1) {
                    if (board[i][j + 1] == word.charAt(0)) {
                        if (depthFirstSearch(board, word.substring(1), visited, i, j + 1)) {
                            return true;
                        }
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }

        }
        // Mark this node as "not visited" if any other future nodes go through this path via another node
        visited[i][j] = 0;
        // return false because didn't find it
        return false;
    }
}