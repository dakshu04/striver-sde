import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

// This class helps traverse the BST like an iterator
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean reverse; // false -> Inorder (left to right), true -> Reverse Inorder (right to left)

    // Constructor initializes iterator and starts pushing nodes
    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushNodes(root);
    }

    // Push nodes in a way that allows in-order traversal
    private void pushNodes(TreeNode node) {
        while (node != null) {
            stack.push(node); // Store node in stack
            node = reverse ? node.right : node.left; // Move in correct direction
        }
    }

    // Returns true if there are more elements left
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Returns the next smallest or largest value
    public int next() {
        TreeNode node = stack.pop(); // Get top node
        pushNodes(reverse ? node.left : node.right); // Move to next valid node
        return node.val;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false; // Base case: empty tree

        // Create two iterators: one for smallest values (inorder), one for largest values (reverse inorder)
        BSTIterator leftIter = new BSTIterator(root, false);  // Ascending order
        BSTIterator rightIter = new BSTIterator(root, true);  // Descending order
        
        // Get the first values from both iterators
        int left = leftIter.next();   // Smallest value in BST
        int right = rightIter.next(); // Largest value in BST

        // Two-pointer technique to find the target sum
        while (left < right) {  // Continue while pointers do not cross
            int sum = left + right;
            
            if (sum == k) return true;  // Found a pair that adds to k
            else if (sum < k) left = leftIter.next(); // Move left pointer to get a larger sum
            else right = rightIter.next(); // Move right pointer to get a smaller sum
        }

        return false; // No pair found
    }
}
