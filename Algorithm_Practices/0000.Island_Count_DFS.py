from datetime import datetime
from functools import wraps
from random import randint
import time

class MapCounter(object):

    def __init__(self, in_map):
        self.map = in_map
        self.num_row = len(in_map)
        self.num_col = len(in_map[0])
        self.new_map = [[0 for x in range(0, self.num_col)] for y in range(0, self.num_row)]
        self.cnt = 0

    def __check_time(inner):
        @wraps(inner)
        def wrapper(*args, **kwargs):
            start = datetime.now()
            print("starting at {tm}".format(tm = start))
            wrapped = inner(*args, **kwargs)
            end = datetime.now()
            print("ended at {tm}".format(tm = end))
            print("duration: {tm}ms".format(tm = (end - start).microseconds / 1000))
            return wrapped
        return wrapper

    def __get_pos_list(self, i, j):
        """ Returns a list of valid adjacent positions to search """
        moves = [(0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1)]
        pos_list = []
        for move in moves:
            if self.__check_pos(i + move[0], j + move[1]):
                pos_list.append((i + move[0], j + move[1]))
        return pos_list

    def __check_pos(self, i, j):
        """ Check if given position can be visited """
        if (i < self.num_row and i > -1 and j < self.num_row and j > -1):
            if (self.map[i][j] == 1):
                return True
        return False

    def __dfs(self, i, j):
        self.map[i][j] = -1
        self.__mark(i, j)
        pos_list = self.__get_pos_list(i, j)
        for pos in pos_list:
            self.__dfs(pos[0], pos[1])

    def __out(self, tp):
        """ Prints out the map """
        if tp == 'new':
            print("\nshowing the marked map")
            target = self.new_map
        elif tp == 'old':
            print("\nshowing the original map")
            target = self.map
        for row in target:
            print(row)

    def __mark(self, i, j):
        """ Marks the map with island number """
        self.new_map[i][j] = self.cnt

    @__check_time
    def count_island(self):
        """ Main method to be called to count islands"""
        self.__out('old')
        for i in range(0, len(self.map)):
            for j in range(0, len(self.map[i])):
                if (self.__check_pos(i, j)):
                    self.cnt += 1
                    self.__dfs(i, j)
        self.__out('new')
        return self.cnt

if __name__ == "__main__":
    sample = [[1, 1, 0, 0, 0],[0, 1, 0, 0, 1],[1, 0, 0, 1, 1],[0, 0, 0, 0, 0],[1, 0, 1, 0, 1]]
    counter = MapCounter(sample)
    print(counter.count_island())

    r = 10
    c = 10
    big_map = []
    for i in range(0, r):
        temp_row = []
        for j in range(0, c):
            if randint(0, 2) == 1:
                num = 1
            else:
                num = 0
            temp_row.append(num)
        big_map.append(temp_row)
    big_counter = MapCounter(big_map)
    print(big_counter.count_island())
