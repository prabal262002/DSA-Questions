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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        recur(l,root);
        return l;
    }
    public void recur(List<Integer> l, TreeNode root){
        if(root==null) return;
        recur(l,root.left);
        l.add(root.val);
        recur(l,root.right);
    }
}