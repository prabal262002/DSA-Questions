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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            m.put(inorder[i],i);
        }
        return buildTree(postorder,0,n-1,inorder,0,n-1,m);
    }
    public TreeNode buildTree(int[] postorder,int postStart,int postEnd,
                        int[] inorder, int inStart, int inEnd, 
                        HashMap<Integer,Integer> m) {
        
        if(postStart>postEnd || inStart>inEnd) return null;

        TreeNode node = new TreeNode(postorder[postEnd]);

        int inIndex = m.get(postorder[postEnd]);
        int numLeft = inIndex - inStart; 
        node.left = buildTree(postorder, postStart, postStart+numLeft-1,
                            inorder, inStart, inIndex-1,m);
        node.right = buildTree(postorder, postStart+numLeft,postEnd-1,
                            inorder, inIndex+1,inEnd,m);
        
        return node;

    }
}