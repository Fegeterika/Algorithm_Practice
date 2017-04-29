/* ou are given a binary tree. Implement the method maxSum which returns the maximal sum of a route from root to leaf. For example, given the following tree:

    17
   /  \
  3   -10
 /    /  \
2    16   1
         /
        13
The method should return 23, since [17,-10,16] is the route from root to leaf with the maximal sum.

The class TreeNode is available for you:

class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;
    ...
} */

class Solution {
    static int maxSum(TreeNode root) {
        int maxSum = 0;
        
        if (root == null) {
            return 0;   
        }
        
        int leftSum = maxSum(root.left);
        int rightSum = maxSum(root.right);
        
        maxSum = root.value + Math.max(leftSum, rightSum);
        return maxSum;
    }
}
