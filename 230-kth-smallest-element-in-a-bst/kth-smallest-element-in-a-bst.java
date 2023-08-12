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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> l = new ArrayList<>();
        reverseInorder(root,l);
        return l.get(k-1);
    }
    public void reverseInorder(TreeNode root,ArrayList<Integer> l){
        if(root!=null){
            reverseInorder(root.left,l);
            l.add(root.val);
            reverseInorder(root.right,l);
        }
    }
}