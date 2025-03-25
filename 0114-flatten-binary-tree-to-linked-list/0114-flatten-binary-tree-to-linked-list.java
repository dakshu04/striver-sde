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
    private TreeNode prev = null; // Global variable to track last node processed
    public void flatten(TreeNode root) {
        //TC->O(N),SC->O(N)
        TreeNode curr = root;
        if(curr == null) {
            return;
        }
        flatten(curr.right);
        flatten(curr.left);
        curr.right = prev;
        curr.left = null;
        prev = curr;
    }
}