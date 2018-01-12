"""
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1
"""
class Solution:
    def numIslands(self, grid):
        if (len(grid) == 0 or len(grid[0]) == 0):
            return 0
        
        self.map = grid
        self.num_row = len(grid)
        self.num_col = len(grid[0])
        self.cnt = 0
        
        for i in range(0, len(self.map)):
            for j in range(0, len(self.map[i])):
                if (self.__check_pos(i, j)):
                    self.cnt += 1
                    self.__dfs(i, j)
        return self.cnt

    def __get_pos_list(self, i, j):
        """ Returns a list of valid adjacent positions to search """
        moves = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        pos_list = []
        for move in moves:
            if self.__check_pos(i + move[0], j + move[1]):
                pos_list.append((i + move[0], j + move[1]))
        return pos_list

    def __check_pos(self, i, j):
        """ Check if given position can be visited """
        if (i < self.num_row and i > -1 and j < self.num_col and j > -1):
            if (self.map[i][j] == "1"):
                return True
        return False

    def __dfs(self, i, j):
        self.map[i][j] = "-1"
        pos_list = self.__get_pos_list(i, j)
        for pos in pos_list:
            self.__dfs(pos[0], pos[1])

        
        
