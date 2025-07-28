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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftTRight = true;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list =  new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                if(leftTRight) {
                    list.add(currNode.val);
                } else {
                    list.add(0, currNode.val);
                }
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            leftTRight = !leftTRight;
            ans.add(list);
        }
        return ans;
    }
}