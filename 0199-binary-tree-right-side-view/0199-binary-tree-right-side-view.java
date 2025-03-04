/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void rightSideViewHelper(TreeNode root, int level, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(level == list.size()) {
            list.add(root.val);
        }
        rightSideViewHelper(root.right, level + 1, list);
        rightSideViewHelper(root.left, level + 1, list);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewHelper(root, 0, result);
        return result;
    }
}