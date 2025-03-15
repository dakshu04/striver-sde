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

class Solution {
    // HashMap to store the index of inorder values for quick lookup
    Map<Integer, Integer> inMap = new HashMap<>();
    
    // Variable to track the current index in postorder (starting from the last element)
    int postIndex;

    // Main function to build the binary tree
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Store inorder values with their corresponding indices in a HashMap
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // Start from the last index of the postorder array
        postIndex = postorder.length - 1;

        // Call the recursive function to construct the tree
        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    // Recursive function to construct the tree
    private TreeNode buildTreeHelper(int[] postorder, int inStart, int inEnd) {
        // Base condition: If no elements are left in this range, return null
        if (inStart > inEnd) {
            return null;
        }

        // The last element in postorder is always the root of the current subtree
        TreeNode root = new TreeNode(postorder[postIndex]);

        // Move to the previous postorder index (right subtree gets processed first)
        postIndex--;

        // Get the index of the root in the inorder traversal
        int inRoot = inMap.get(root.val);

        // Construct the right subtree first because postorder is **left-right-root**
        root.right = buildTreeHelper(postorder, inRoot + 1, inEnd);

        // Construct the left subtree
        root.left = buildTreeHelper(postorder, inStart, inRoot - 1);

        // Return the constructed root node
        return root;
    }
}
