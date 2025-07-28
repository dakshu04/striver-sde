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
    public int height(TreeNode root, int[] diam) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left, diam);
        int rightHeight = height(root.right, diam);
        diam[0] = Math.max(diam[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diam = new int[1];
        height(root, diam);
        return diam[0];
    }
}