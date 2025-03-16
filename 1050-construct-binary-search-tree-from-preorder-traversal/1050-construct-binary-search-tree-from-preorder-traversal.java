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
//TC->O(N^2),SC->O(1)
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++) {
            insertBST(root, preorder[i]);
        }
        return root;
    }
    public TreeNode insertBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val > val) {
            root.left = insertBST(root.left, val);
        } else {
            root.right = insertBST(root.right, val);
        }
        return root;
    }
}