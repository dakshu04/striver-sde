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
    public int maxFn(TreeNode root, int[] maxPath) {
        if(root == null) {
            return 0;
        }
        int left = Math.max(0, maxFn(root.left, maxPath));
        int right = Math.max(0, maxFn(root.right, maxPath));
        maxPath[0] = Math.max(maxPath[0], root.val + left + right);
        return Math.max(left, right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        int[] maxPath = { Integer.MIN_VALUE };
        maxFn(root, maxPath);
        return maxPath[0];
    }
}