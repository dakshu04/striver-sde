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
 //TC->O(n),SC->O(n)
class Solution {
    static class Pair {
        TreeNode node;
        int num; // Stores the index of the node
        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;  // Base case: if tree is empty, width is 0
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));  // Initialize queue with root node at index 0
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().num;  // Normalize index to avoid overflow
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair current = q.poll();
                TreeNode node = current.node;
                int cur_id = current.num - min; // Normalize index

                if (i == 0) first = cur_id;  // First node's index in the level
                if (i == size - 1) last = cur_id;  // Last node's index in the level

                if (node.left != null) 
                    q.offer(new Pair(node.left, cur_id * 2 + 1));
                if (node.right != null) 
                    q.offer(new Pair(node.right, cur_id * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);  // Update max width
        }
        return ans;
    }
}
