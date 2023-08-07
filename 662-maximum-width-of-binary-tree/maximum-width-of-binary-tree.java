
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
    public int widthOfBinaryTree(TreeNode root) {
        // Check if the root is null
        if (root == null)
            return 0;

        // Initialize queues to perform level-order traversal
        Queue<TreeNode> q = new LinkedList<>(); // To store nodes
        Queue<Integer> qi = new LinkedList<>(); // To store corresponding indices

        int ans = 0; // Initialize the maximum width to zero

        // Start the level-order traversal from the root
        q.offer(root);
        qi.offer(0);

        while (!q.isEmpty()) {
            int first = 0; // To store the index of the leftmost node in the current level
            int last = 0; // To store the index of the rightmost node in the current level
            int n = q.size(); // Number of nodes in the current level
            int index = qi.peek(); // Get the index of the first node in the current level

            // Iterate over all nodes in the current level
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.poll(); // Dequeue the node from the queue
                int curri = qi.poll() - index; // Calculate the relative index of the node in the level

                if (i == 0) first = curri; // If it's the first node, update 'first' accordingly
                if (i == n - 1) last = curri; // If it's the last node, update 'last' accordingly

                // Enqueue the left and right children, along with their indices
                if (temp.left != null) {
                    q.offer(temp.left);
                    qi.offer(curri * 2 + 1);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                    qi.offer(curri * 2 + 2);
                }
            }

            // Calculate the width for the current level
            int currentWidth = last - first + 1;
            // Update the maximum width if necessary
            ans = Math.max(ans, currentWidth);
        }

        // Return the maximum width of the binary tree
        return ans;
    }
}
