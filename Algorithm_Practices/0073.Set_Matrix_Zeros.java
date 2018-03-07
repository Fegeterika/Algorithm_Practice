/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/
// This is a O(mn) solution
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || cols.contains(j)) matrix[i][j] = 0;
            }
        }
    }
}
