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
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //self
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int currDiam = leftHeight + rightHeight;
        //without self
        int leftDiam = diameterOfBinaryTree(root.left); 
        int rightDiam = diameterOfBinaryTree(root.right); 
        return Math.max(Math.max(leftDiam, rightDiam), currDiam);
    }
}