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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            m.put(inorder[i],i);
        }
        return buildTree(preorder,0,n-1,inorder,0,n-1,m);
    }
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,
                        int[] inorder, int inStart, int inEnd, 
                        HashMap<Integer,Integer> m) {
        
        if(preStart>preEnd || inStart>inEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int inIndex = m.get(preorder[preStart]);
        int numLeft = inIndex - inStart; 
        node.left = buildTree(preorder, preStart+1, preStart+numLeft,
                            inorder, inStart, inIndex-1,m);
        node.right = buildTree(preorder, preStart+numLeft+1,preEnd,
                            inorder, inIndex+1,inEnd,m);
        
        return node;

    }
}