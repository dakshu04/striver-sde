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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalAns = new ArrayList<>();
        if(root == null) return finalAns;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode currEl = q.poll();
                ans.add(currEl.val);
                if(currEl.left != null) q.add(currEl.left);
                if(currEl.right != null) q.add(currEl.right);
            }
            finalAns.add(ans);
        }
        return finalAns;
    }
}