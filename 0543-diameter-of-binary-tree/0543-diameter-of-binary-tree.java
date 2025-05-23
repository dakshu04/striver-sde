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
        if(root == null) return 0;
        int lh = height(root.left, diam);
        int rh = height(root.right, diam);
        diam[0] = Math.max(diam[0], lh + rh);
        return Math.max(lh, rh) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diam = new int[1];
        diam[0] = 0;
        height(root, diam);
        return diam[0];
    }
}