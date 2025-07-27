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
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) {
            return ansList;
        }
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()) {
            int size = q.size();
            
           ArrayList<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                
                TreeNode curr = q.poll();
                if(leftToRight){
                    levelList.add(curr.val);
                } else {
                    levelList.add(0, curr.val);
                }
                
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            leftToRight = !leftToRight;
            ansList.add(levelList);
        }
        return ansList;
    }
}