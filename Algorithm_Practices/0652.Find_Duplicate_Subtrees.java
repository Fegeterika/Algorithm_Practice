/*
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1: 
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.

*/
class Solution {
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        search(root, res, new HashMap<>());
        return res;
    }
    
    private String search(TreeNode node, List<TreeNode> res, Map<String, Integer> subs) {
        if (node == null) return "";
        String subtree = node.val + "," + search(node.left, res, subs) + "," + search(node.right, res, subs);
        if (subs.getOrDefault(subtree, 0) == 1) res.add(node);
        subs.put(subtree, subs.getOrDefault(subtree, 0) + 1);
        return subtree;
    }
}
