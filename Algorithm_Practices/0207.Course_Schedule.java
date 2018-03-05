/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] prereq = new ArrayList[numCourses];
        for (int i = 0; i < prereq.length; i++) {
            prereq[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            prereq[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < prereq.length; i++) {
            if(!dfs(visited, prereq, i)) return false;
        }
        return true;
    }
    
    private boolean dfs(Set<Integer> visited, ArrayList[] prereq, int target) {
        if (visited.contains(target)) return false;
        visited.add(target);
        for (int j = 0; j < prereq[target].size(); j++) {
            if (!dfs(visited, prereq, (int) prereq[target].get(j))) return false;
        }
        visited.remove(target);
        return true;
    }
}
