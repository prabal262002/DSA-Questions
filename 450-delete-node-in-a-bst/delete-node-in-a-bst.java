class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case: if the tree is empty, return null
        if (root == null) {
            return null;
        }
        
        // If the current node's value matches the key, call the delete function
        if (root.val == key) {
            return delete(root);
        }
        
        // If the key is smaller than the current node's value, recursively search in the left subtree
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        // If the key is larger than or equal to the current node's value, recursively search in the right subtree
        else {
            root.right = deleteNode(root.right, key);
        }
        
        // Return the modified tree
        return root;
    }
    
    // Delete function to handle node deletion cases
    public TreeNode delete(TreeNode node) {
        // If the node has no left child, replace it with its right child
        if (node.left == null) {
            return node.right;
        }
        
        // If the node has no right child, replace it with its left child
        if (node.right == null) {
            return node.left;
        }
        
        // Find the minimum node in the right subtree (successor) and copy its value to the current node
        TreeNode successor = findMinimum(node.right);
        node.val = successor.val;
        
        // Delete the successor from the right subtree
        node.right = deleteNode(node.right, successor.val);
        
        // Return the modified node
        return node;
    }
    
    // Find the minimum node in a given subtree
    public TreeNode findMinimum(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
