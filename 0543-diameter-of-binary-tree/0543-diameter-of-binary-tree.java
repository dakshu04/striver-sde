/**
 * Definition for a binary tree TreeNode.
 * public class TreeTreeNode {
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
    // Function to find the diameter of a binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1]; // Stores the maximum diameter
        height(root, diameter);
        return diameter[0];
    }

    // Function to calculate the height of the tree and update the diameter
    private int height(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        // Recursively calculate the height of left and right subtrees
        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);

        // Update the maximum diameter found so far
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        // Return the height of the current TreeNode's subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}