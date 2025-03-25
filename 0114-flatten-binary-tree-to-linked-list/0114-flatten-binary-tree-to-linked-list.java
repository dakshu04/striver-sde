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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {  // Find rightmost node of left subtree
                    prev = prev.right;
                }
                prev.right = curr.right;  // Connect rightmost node to current right subtree
                curr.right = curr.left;   // Move left subtree to right
                curr.left = null;         // Set left to null
            }
            curr = curr.right; // Move to next right node
        }
    }
}
