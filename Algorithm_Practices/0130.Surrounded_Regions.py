"""
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
"""

class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        # if board is 2x2 or smaller, all cells are boundary cells
        if len(board) <= 2 or len(board[0]) <= 2:
            return
        
        deltas = ((-1, 0), (1, 0), (0, -1), (0, 1))
        rows = len(board)
        cols = len(board[0])
        
        # flip all inside Os to Is
        for i in range(1, rows-1):
            for j in range(1, cols-1):
                if board[i][j] == 'O':
                    board[i][j] = 'I'
                    
        # search all columns on row 0 and len(board) - 1
        for j in range(1, cols-1):
            if board[0][j] == 'O':
                self.search_inside(board, deltas, 1, j)
            if board[-1][j] == 'O':
                self.search_inside(board, deltas, rows-2, j)
        
        for i in range(1, rows-1):
            if board[i][0] == 'O':
                self.search_inside(board, deltas, i, 1)
            if board[i][-1] == 'O':
                self.search_inside(board, deltas, i, cols-2)
        
        # flip all inside Is back to Os
        for i in range(1, rows-1):
            for j in range(1, cols-1):
                if board[i][j] == 'I':
                    board[i][j] = 'X'
    
    def search_inside(self, board, deltas, i, j):
        if board[i][j] == 'I':
            board[i][j] = 'O'
            for delta in deltas:
                self.search_inside(board, deltas, i+delta[0], j+delta[1])
