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
    public boolean isValidBST(TreeNode root) {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean traverse(TreeNode root, long min, long max) {
        if (root != null) {
            if (root.val <= min || root.val >= max) {
                return false;
            }
            boolean leftIsValid = traverse(root.left, min, root.val);
            boolean rightIsValid = traverse(root.right, root.val, max);
            return leftIsValid && rightIsValid;
        }
        return true;
    }
}
