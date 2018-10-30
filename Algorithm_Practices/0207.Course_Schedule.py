"""
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
"""
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        visited = set()
        
        # build a dependency array
        prereqs = [[] for course in range(numCourses)]
        
        for prereq in prerequisites:
            prereqs[prereq[0]].append(prereq[1])
            
        for courseNum in range(len(prereqs)):
            # do DFS if not already visited
            if courseNum not in visited:
                if not self.dfs(prereqs, visited, courseNum, set()):
                    return False
        
        return True
                
    def dfs(self, prereqs, visited, courseNum, temp):
        # if this course is in temp, we have a cycle
        if courseNum in temp:
            return False
        
        # check each prereqs
        temp.add(courseNum)
        for prereq in prereqs[courseNum]:
            res = self.dfs(prereqs, visited, prereq, temp)
            if not res:
                # cycle is detected downstream
                return False
        temp.remove(courseNum)
        
        # mark visited. This course is valid
        visited.add(courseNum)
        return True
