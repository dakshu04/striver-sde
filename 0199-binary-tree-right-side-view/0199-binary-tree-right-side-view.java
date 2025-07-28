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
    public void rightSVHelperFn(TreeNode root, List<Integer> rightSideVList, int level) {
        if(root == null) {
            return;
        }
        if(level == rightSideVList.size()) {
            rightSideVList.add(root.val);
        }
        rightSVHelperFn(root.right, rightSideVList, level + 1);
        rightSVHelperFn(root.left, rightSideVList, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideVList = new ArrayList<>();
        rightSVHelperFn(root, rightSideVList, 0);
        return rightSideVList;
    }
}