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
    TreeNode prev,first,middle,last;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int temp=first.val;
        if(last==null){
            first.val = middle.val;
            middle.val = temp;
        }
        else {
            first.val = last.val;
            last.val = temp;
        }
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);

        if(prev!=null && root.val<prev.val){
            if(first==null){
                first=prev;
                middle=root;
            }
            if(first!=null){
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}