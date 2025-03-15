// Definition of a TreeNode for a binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructors for TreeNode
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {//TC->O(n),SC->O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to store index positions of inorder values for quick lookup
        Map<Integer, Integer> inMap = new HashMap<>();

        // Populate the HashMap with inorder value-to-index mappings
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // Call helper function to construct the tree recursively
        return buildTreeHelper(preorder, 0, preorder.length - 1,
                               inorder, 0, inorder.length - 1, inMap);
    }
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     Map<Integer, Integer> inMap) {
        // Base condition: If the indices are invalid, return null (no tree to construct)
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in the preorder range is always the root of the current subtree
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find the index of this root node in the inorder array
        int inRoot = inMap.get(root.val);  // Position of root in inorder traversal

        // Calculate the number of nodes in the left subtree
        int numsLeft = inRoot - inStart;

        // Recursively construct the left subtree
        // - Left subtree elements are found between (preStart + 1) and (preStart + numsLeft) in preorder.
        // - Corresponding inorder range is from inStart to (inRoot - 1).
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft,
                                    inorder, inStart, inRoot - 1, inMap);

        // Recursively construct the right subtree
        // - Right subtree elements start from (preStart + numsLeft + 1) to preEnd in preorder.
        // - Corresponding inorder range is from (inRoot + 1) to inEnd.
        root.right = buildTreeHelper(preorder, preStart + numsLeft + 1, preEnd,
                                     inorder, inRoot + 1, inEnd, inMap);

        // Return the constructed root node
        return root;
    }
}
