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
class Solution {//TC->O(N),SC->O(1)
    private int counter = 0;
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    public void inorder(TreeNode root, int k) {
        if(root == null) return;
        TreeNode node = root;
        inorder(node.left, k);
        counter++;
        if(counter == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }
}