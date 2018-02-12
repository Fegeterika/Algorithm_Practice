/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.equals("")) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] moves = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (check(board, word, 0, i, j, visited, moves)) return true;
            }
        }
        return false;
    }
    
    private boolean check(char[][] board, String word, int strIndex, int i, int j, boolean[][] visited, int[][] moves) {
        if (strIndex == word.length() - 1 && board[i][j] == word.charAt(strIndex)) {
            return true;
        } else if (board[i][j] == word.charAt(strIndex)) {
            visited[i][j] = true;
            for (int[] move : moves) {
                if (i + move[0] >= 0 && i + move[0] < board.length && j + move[1] >= 0 && j + move[1] < board[i].length
                    && !visited[i + move[0]][j + move[1]]) {
                    if (check(board, word, strIndex + 1, i + move[0], j + move[1], visited, moves)) return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
