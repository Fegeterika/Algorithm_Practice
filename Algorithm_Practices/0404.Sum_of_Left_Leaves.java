/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        sumLeft(root);
        return sum;
    }

    private int sumLeft(TreeNode node) {
        if (node == null) return 0;
        int left = sumLeft(node.left);
        int right = sumLeft(node.right);
        sum += left;
        if (node.left == null && node.right == null) {
            return node.val;
        } else {
            return 0;
        }
    }
}
