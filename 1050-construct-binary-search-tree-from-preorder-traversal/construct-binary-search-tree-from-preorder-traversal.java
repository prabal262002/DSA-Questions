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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return rcrsvBSTfrompreorder(preorder,Integer.MAX_VALUE);
    }
    public TreeNode rcrsvBSTfrompreorder(int[] preorder,int max){
        if(i>=preorder.length || preorder[i]>=max) return null;
        TreeNode node = new TreeNode(preorder[i]);
        i++;
        node.left = rcrsvBSTfrompreorder(preorder,node.val);
        node.right = rcrsvBSTfrompreorder(preorder,max);
        return node;
    }
}