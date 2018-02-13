/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) return null;
        return buildBranch(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildBranch(int[] preorder, int[] inorder, int pi, int pj, int ii, int ij) {
        if (pi == pj && ii == ij && preorder[pi] == inorder[ii]) return new TreeNode(preorder[pi]);
        TreeNode root = new TreeNode(preorder[pi]); // First element of preorder is always the root
        int pivot = ii;
        while (inorder[pivot] != preorder[pi]) pivot++;
        if ((pi - ii) + pivot > pi) root.left = buildBranch(preorder, inorder, pi + 1, (pi - ii) + pivot, ii, pivot - 1);
        if (pj > (pi - ii) + pivot) root.right = buildBranch(preorder, inorder, (pi - ii) + pivot + 1, pj, pivot + 1, ij);
        return root;
    }
}
